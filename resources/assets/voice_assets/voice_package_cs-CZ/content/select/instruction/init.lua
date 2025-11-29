local utils = require 'content.utils'
local common = require 'content.select.common'
local constants = require 'prompt.constants'
local direction = require 'content.select.instruction.direction'
local lane_information = require 'content.select.instruction.lane_information'
local natural_guidance = require 'content.select.instruction.natural_guidance'

local instruction = {}


function instruction.get_suppressed_instruction(road_class, distance_in_meters, distance_unit,
                                                distance_in_unit, suppressing_threshold)
    local content = {prompt_class = 'instruction', class = 'follow', action = 'follow', time = '-'}
    if road_class == 'street' then
        content.additional_information = 'road'
    elseif road_class == 'highway' then
        content.additional_information = 'highway'
        content.highway_category = 'nav.variable.HIGHWAY.regular'
    elseif road_class == 'urban_highway' then
        content.additional_information = 'highway'
        content.highway_category = 'nav.variable.HIGHWAY.urban'
    end

    local attributes = {distance_flag = 'without_distance', road_class = road_class}
    local threshold = common.get_config_value(suppressing_threshold, attributes)

    if distance_in_meters < 0 or
        ( threshold and distance_in_meters >= threshold ) then
        return content
    end

    content.distance_unit_phrase_id = 'nav.variable.UNIT.' .. distance_unit
    content.distance_value = distance_in_unit
    content.additional_information = 'distance-' .. content.additional_information
    attributes = {distance_flag = 'with_distance', road_class = road_class}
    threshold = common.get_config_value(suppressing_threshold, attributes)
    if threshold and distance_in_meters >= threshold then return content end

    return nil
end


function instruction.get_action_for_turn(trigger, turn, breaks_before_turn, instruction_order, lane_information_table, purpose, road_class, distance_in_meters,
                                         use_lane_information, lane_information_limit, lane_count_limit)
    local action_content = {turn_information = {}}

    action_content.action = 'turnkeep'
    local move_phrase_id = _get_move_phrase_id(turn, breaks_before_turn, instruction_order)
    if not move_phrase_id then return nil end
    action_content.turn_information.move_phrase_id = move_phrase_id
    action_content.turn_information.turn_clause_id = 'nav.clause.TURN_KEEP.move'

    local lane_recommendation = lane_information.get_recommended_lanes(lane_information_table)
    local turn_action, turn_bearing = _get_turn_action_and_bearing(turn)
    if lane_information.use(trigger, lane_recommendation, turn_action, turn_bearing, road_class, distance_in_meters, use_lane_information, lane_information_limit) then
        local lane_phrase_id = lane_information.get_lane_phrase_id(lane_recommendation, turn_bearing, lane_count_limit)
        if lane_phrase_id then
            action_content.turn_information.lane_phrase_id = lane_phrase_id
            if purpose ~= nil and turn_action == 'keep' then
                action_content.turn_information.turn_clause_id = 'nav.clause.TURN_KEEP.lane'
                action_content.turn_information.move_phrase_id = nil
            else
                action_content.turn_information.turn_clause_id = 'nav.clause.TURN_KEEP.lane-move'
            end
        end
    end

    return action_content
end


function _get_move_phrase_id(turn, breaks_before_turn, instruction_order)
    if breaks_before_turn and breaks_before_turn > 0 and breaks_before_turn < 3 and instruction_order == 'second' and turn ~= 'no_turn' then
        local bearing = string.match(turn, '%l+_(%l+)')
        return 'nav.variable.MOVE.' .. constants.order_prefix[tostring(breaks_before_turn + 1)] .. bearing
    end

    local turn_ids_for_turn = { 'light_right', 'quite_right','heavy_right', 'light_left', 'quite_left', 'heavy_left' }
    local turn_ids_for_keep = { 'keep_right', 'keep_left', 'keep_middle' }
    local degree, bearing, action
    if utils.inside(turn, turn_ids_for_turn) then
        action = 'turn'
        degree, bearing = string.match(turn, '(%l+)_(%l+)')
        if degree == 'light' then degree = 'slightly'
        elseif degree == 'quite' then degree = ''
        elseif degree == 'heavy' then degree = 'sharply'
        end
    elseif utils.inside(turn, turn_ids_for_keep) then
        action = 'keep'
        bearing = string.match(turn, '%l+_(%l+)')
        degree = ''
    elseif turn == 'no_turn' then
        action = 'continue'
        bearing = 'straight'
        degree = ''
    else return nil
    end
    return table.concat({'nav', 'variable', 'MOVE', (action .. degree .. bearing)}, '.')
end


function _get_turn_action_and_bearing(turn)
    local valid_turns = {'light_right', 'quite_right','heavy_right',
                         'light_left', 'quite_left', 'heavy_left',
                         'keep_right', 'keep_left', 'keep_middle',
                         'no_turn'}
    if not utils.inside(turn, valid_turns) then return nil end
    if turn == 'no_turn' then return 'continue', 'straight' end
    local action, bearing = string.match(turn, '(%l+)_(%l+)')
    if action ~= 'keep' then action = 'turn' end
    return action, bearing
end


function instruction.get_additional_info(additional_content)
    local additional_info_components = {}
    if utils.inside('exit_name', utils.keys(additional_content)) then
        utils.extend(additional_info_components, 'exit')
    end
    if utils.inside('highway_category', utils.keys(additional_content)) then
        utils.extend(additional_info_components, 'highway')
    end
    if utils.inside('side_of_road', utils.keys(additional_content)) then
        utils.extend(additional_info_components, 'side')
    end
    if not utils.empty(additional_info_components) then
        table.sort(additional_info_components)
        return table.concat(additional_info_components, '-')
    end
end


function instruction.get_highway_turn_purpose(use_exit_purpose, use_continue_purpose)
    local purpose_components = {}
    if use_exit_purpose then
        utils.extend(purpose_components, 'toexit')
    end
    if use_continue_purpose then
        utils.extend(purpose_components, 'tocontinue')
    end
    if not utils.empty(purpose_components) then
        table.sort(purpose_components)
        local purpose = table.concat(purpose_components, '-')
        purpose = purpose
        return purpose
    end
end


function _is_immediate_maneuver(message, close_distance_limit)
    if message.order == 'second' then
        local attributes = {road_class = message.road_class, instruction_class = message.instruction_class}
        local limit = common.get_config_value(close_distance_limit, attributes)
        if limit == nil or message.distance.value_in_meters <= limit then
            return true
        end
    end
    return false
end


function instruction.get_enter_highway_turn_information(turn, trigger, order, turn_rules)
    if not turn or not turn_rules then return nil end
    local attributes = {turn = turn, trigger = trigger, instruction_order = order}
    local enter_highway_turn_information = common.get_config_value(turn_rules, attributes)
    return enter_highway_turn_information
end


function instruction.get_arrival_information(trigger, order, side_of_road, arrival_information_rules)
    if not arrival_information_rules then return nil end
    if not side_of_road then side_of_road = 'none' end
    local attributes = {trigger = trigger, instruction_order = order, side_of_road = side_of_road}
    local arrival_information = common.get_config_value(arrival_information_rules, attributes)
    return arrival_information
end


function instruction.get_use_continue_purpose(order, trigger, road_change, use_continue_purpose_rules, use_direction_information)
    if not use_continue_purpose_rules or not use_direction_information then return false end
    local attributes = {instruction_order = order, trigger = trigger, road_change = tostring(road_change)}
    local use_continue_purpose = common.get_config_value(use_continue_purpose_rules, attributes)
    return use_continue_purpose
end


function instruction.get_use_exit_purpose(order, trigger, leaving_highway, exit_name, use_exit_purpose_rules)
    if not use_exit_purpose_rules then return nil end
    local exit_key = direction.get_exit_key(exit_name)
    if exit_key == nil then
        exit_key = '{}'
    end
    local attributes = {instruction_order = order, trigger = trigger, leaving_highway = tostring(leaving_highway), exit_info = exit_key}
    local use_exit_purpose = common.get_config_value(use_exit_purpose_rules, attributes)
    return use_exit_purpose
end


function instruction.get_goal(message)
    if message.arrival_class == 'end' then
        return 'nav.variable.GOAL.destination'
    elseif message.arrival_class == 'stopover' then
        return 'nav.variable.GOAL.waypoint'
    end
end


function instruction.get_side_of_road(message)
    if message.side_of_road == 'left' or
       message.side_of_road == 'right' or
       message.side_of_road == 'front' then
         return 'nav.variable.SIDE.'..string.lower(message.side_of_road)
    end
end


function instruction.get_roundabout_exit_number(roundabout_exit_number)
    if roundabout_exit_number == nil then return end
    local exit_number = tostring(roundabout_exit_number)
    return 'nav.variable.TAKENTHEXIT.'..exit_number
end


function instruction.get_use_exit_roundabout(trigger, use_exit_roundabout_rules)
    local attributes = {trigger = trigger}
    local use_exit_roundabout = common.get_config_value(use_exit_roundabout_rules, attributes)
    return use_exit_roundabout
end


function instruction.get_road_change(current_route, next_route)
    if ((current_route == nil) and (next_route == nil)) or
       ((current_route == nil) and (next_route ~= nil)) or
       ((current_route ~= nil) and (next_route == nil)) or
       (current_route.name ~= next_route.name) then
        return true
    end
    return false
end


function instruction.select_common_content(message, close_distance_limit)
    local content = {}
    content.class = message.instruction_class
    content.prompt_class = 'instruction'
    content.vp_marc_lang_code = message.vp_marc_lang_code
    content.vp_supported_lang_code = message.vp_supported_lang_code
    content.trigger = message.trigger

    if content.trigger == 'imperative' then
        content.time = 'none'
        content.trigger = 'distance'
        _G['imperative_mode'] = true
    elseif content.trigger == 'action' then
        if utils.inside(message.instruction_class, {'arrival', 'roundabout'}) then
            content.time = 'none'
        else
            content.time = 'now'
        end
    elseif message.distance then
            content.time = 'afterdistance'
            content.distance_unit_phrase_id = 'nav.variable.UNIT.'..message.distance.unit
            content.distance_value = message.distance.value_in_unit
    end

    if _is_immediate_maneuver(message, close_distance_limit) then
        content.immediately = 'nav.variable.immediately'
    end

    return content
end


function instruction.select_arrival(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    local arrival_information = instruction.get_arrival_information(content.trigger, message.order, message.side_of_road, rules.arrival_information)
    content.goal = instruction.get_goal(message)
    content.action = arrival_information.action
    if arrival_information.side_of_road then
        content.side_of_road = instruction.get_side_of_road(message)
    end
    if arrival_information.notification then
        content.prompt_class = 'notification'
    else
        content.additional_information = instruction.get_additional_info(content)
    end
    return content
end


function instruction.select_head(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    content.trigger = 'action'
    content.action = 'head'
    direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                message.street, message.route, message.signpost,
                                                                rules.filter_direction_information, content.action, content.purpose,
                                                                message.country_code, message.use_road_information_for_action_notification,
                                                                message.use_signpost_direction_for_action_notification)
    if utils.length(direction_information) > 0 then
        content = utils.merge_tables(content, direction_information)
    else
        return instruction.get_suppressed_instruction(message.road_class, -1, '', '', suppressing_threshold)
    end
    content.time = '-'
    return content
end


function instruction.select_uturn(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    content.action = 'makeuturn'
    content.natural_guidance = natural_guidance.get_element(message.order, content.trigger, message.instruction_class, message.distance.value_in_meters, message.natural_guidance,
                                                            rules.use_natural_guidance_with_trigger, rules.natural_guidance_importance_threshold, rules.natural_guidance_count_limit,
                                                            rules.natural_guidance_distance_limit, rules.natural_guidance_elements_priority_order,
                                                              rules.natural_guidance_distance_to_first_element_threshold)
    if natural_guidance.excludes_distance(content.natural_guidance, rules.use_distance_with_natural_guidance) then
        content.time = 'landmark'
        content.distance_value = nil
        content.distance_unit_phrase_id = nil
    end

    content.additional_information = instruction.get_additional_info(content)
    return content
end


function instruction.select_ferry(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    content.action = 'takeferry'
    local direction_information = nil
    if direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit) then
        direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                    message.street, message.route, message.signpost,
                                                                    rules.filter_direction_information, content.action, content.purpose,
                                                                    message.country_code, message.use_road_information_for_action_notification,
                                                                    message.use_signpost_direction_for_action_notification)
        content = utils.merge_tables(content, direction_information)
    end
    local natural_guidance_element = natural_guidance.get_element(message.order, content.trigger, message.instruction_class, message.distance.value_in_meters, message.natural_guidance,
                                                                  rules.use_natural_guidance_with_trigger, rules.natural_guidance_importance_threshold, rules.natural_guidance_count_limit,
                                                                  rules.natural_guidance_distance_limit, rules.natural_guidance_elements_priority_order,
                                                                  rules.natural_guidance_distance_to_first_element_threshold)
    if not natural_guidance.excluded_by_direction(direction_information, natural_guidance_element, rules.use_natural_guidance_with_direction) then
        content.natural_guidance = natural_guidance_element
        if natural_guidance.excludes_distance(natural_guidance_element, rules.use_distance_with_natural_guidance) then
            content.time = 'landmark'
            content.distance_value = nil
            content.distance_unit_phrase_id = nil
        end
    end

    content.additional_information = instruction.get_additional_info(content)
    return content
end


function instruction.select_exit_roundabout(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    local use_exit_roundabout = instruction.get_use_exit_roundabout(content.trigger, rules.use_exit_roundabout)
    if not _G['imperative_mode'] and not use_exit_roundabout then
        return {}
    end
    content.action = 'takeexit'
    if direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit) then
        local direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                          message.street, message.route, message.signpost,
                                                                          rules.filter_direction_information, content.action, content.purpose,
                                                                          message.country_code, message.use_road_information_for_action_notification,
                                                                          message.use_signpost_direction_for_action_notification)
        content = utils.merge_tables(content, direction_information)
    end
    content.additional_information = instruction.get_additional_info(content)
    return content
end


function instruction.select_roundabout(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    content.roundabout_exit_number = instruction.get_roundabout_exit_number(message.roundabout_exit_number)
    if content.roundabout_exit_number == nil then
        content.action = 'enterroundabout'
        return content
    end

    content.action = 'exitroundabout'
    if direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit) then
        local direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                          message.street, message.route, message.signpost,
                                                                          rules.filter_direction_information, content.action, content.purpose,
                                                                          message.country_code, message.use_road_information_for_action_notification,
                                                                          message.use_signpost_direction_for_action_notification)
        content = utils.merge_tables(content, direction_information)
    end
    content.additional_information = instruction.get_additional_info(content)
    return content
end


function instruction.select_enter_highway(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    local enter_highway_turn_information = instruction.get_enter_highway_turn_information(message.turn, content.trigger, message.order, rules.enter_highway_turn_information)
    if enter_highway_turn_information.action == 'join' then
        content.action = enter_highway_turn_information.action
        content.highway_category = 'nav.variable.HIGHWAY.'..message.highway_category
    end
    if enter_highway_turn_information.action == 'turnkeep' then
        local action_content = instruction.get_action_for_turn(content.trigger, message.turn, content.breaks_before_turn, message.order, message.lane_information,
                                                               enter_highway_turn_information.purpose, message.road_class, message.distance.value_in_meters,
                                                               rules.use_lane_information, rules.lane_information_limit, rules.lane_count_limit)
        content = utils.merge_tables(content, action_content)
        local use_direction_information = direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit)
        local direction_information = nil
        if use_direction_information then
            direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                        message.street, message.route, message.signpost,
                                                                        rules.filter_direction_information,
                                                                        enter_highway_turn_information.action, enter_highway_turn_information.purpose,
                                                                        message.country_code, message.use_road_information_for_action_notification,
                                                                        message.use_signpost_direction_for_action_notification)
            content = utils.merge_tables(content, direction_information)
        end

        local natural_guidance_element = natural_guidance.get_element(message.order, content.trigger, message.instruction_class, message.distance.value_in_meters, message.natural_guidance,
                                                                      rules.use_natural_guidance_with_trigger, rules.natural_guidance_importance_threshold,
                                                                      rules.natural_guidance_count_limit, rules.natural_guidance_distance_limit,
                                                                      rules.natural_guidance_elements_priority_order,
                                                                      rules.natural_guidance_distance_to_first_element_threshold)

        if not natural_guidance.excluded_by_direction(direction_information, natural_guidance_element, rules.use_natural_guidance_with_direction) and
           not natural_guidance.excluded_by_lane_information(action_content, natural_guidance_element, message.order, rules.use_natural_guidance_with_lane_information) then
            content.natural_guidance = natural_guidance_element
            if natural_guidance.excludes_distance(natural_guidance_element, rules.use_distance_with_natural_guidance) then
                content.time = 'landmark'
                content.distance_value = nil
                content.distance_unit_phrase_id = nil
            end
        end
        if enter_highway_turn_information.purpose then
            content.purpose = enter_highway_turn_information.purpose
            if direction_information == nil or direction_information.route == nil then
                content.highway_category = 'nav.variable.HIGHWAY.'..message.highway_category
            end
        end
    end

    content.additional_information = instruction.get_additional_info(content)

    return content
end


function instruction.select_junction(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    content.breaks_before_turn = message.breaks_before_turn
    local purpose = nil
    local action_content = instruction.get_action_for_turn(content.trigger, message.turn, content.breaks_before_turn, message.order,
                                                           message.lane_information, purpose, message.road_class, message.distance.value_in_meters,
                                                           rules.use_lane_information, rules.lane_information_limit, rules.lane_count_limit)
    content = utils.merge_tables(content, action_content)

    local direction_information = nil
    if direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit) then
        direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                    message.street, message.route, message.signpost,
                                                                    rules.filter_direction_information, content.action, content.purpose,
                                                                    message.country_code, message.use_road_information_for_action_notification,
                                                                    message.use_signpost_direction_for_action_notification)
        content = utils.merge_tables(content, direction_information)
    end

    local natural_guidance_element = natural_guidance.get_element(message.order, content.trigger, message.instruction_class, message.distance.value_in_meters, message.natural_guidance,
                                                                  rules.use_natural_guidance_with_trigger, rules.natural_guidance_importance_threshold,
                                                                  rules.natural_guidance_count_limit, rules.natural_guidance_distance_limit,
                                                                  rules.natural_guidance_elements_priority_order,
                                                                  rules.natural_guidance_distance_to_first_element_threshold)
    if not natural_guidance.excluded_by_direction(direction_information, natural_guidance_element, rules.use_natural_guidance_with_direction) and
       not natural_guidance.excluded_by_lane_information(action_content, natural_guidance_element, message.order, rules.use_natural_guidance_with_lane_information) then
        content.natural_guidance = natural_guidance_element
        if natural_guidance.excludes_distance(natural_guidance_element, rules.use_distance_with_natural_guidance) then
            content.time = 'landmark'
            content.distance_value = nil
            content.distance_unit_phrase_id = nil
        end
    end

    content.additional_information = instruction.get_additional_info(content)

    return content
end


function instruction.select_highway_turn(message, rules)
    local content = instruction.select_common_content(message, rules.close_distance_limit)
    local road_change = instruction.get_road_change(message.current_route, message.route)
    local continue_road_change = road_change == true and message.leaving_highway and (message.next_road_class == 'highway' or message.next_road_class == 'urban_highway') and message.route ~= nil
    local use_direction_information = direction.use_direction_information(content.trigger, message.road_class, message.distance.value_in_meters, rules.direction_information_limit)
    local highway_exit_information = direction.get_highway_exit_information(message.order, content.trigger, message.exit_name,
                                                                            message.road_class, message.distance.value_in_meters, rules.direction_information_limit,
                                                                            rules.filter_highway_exit_information)
    local check_continue = road_change
    if check_continue == true and continue_road_change == true then
       check_continue = false
    end

    local use_continue_purpose = instruction.get_use_continue_purpose(message.order, content.trigger, check_continue, rules.use_continue_purpose, use_direction_information)
    local use_exit_purpose = false
    if (message.order ~= 'second' and highway_exit_information ~= nil) or use_continue_purpose == false then
        use_exit_purpose = instruction.get_use_exit_purpose(message.order, content.trigger, message.leaving_highway, message.exit_name, rules.use_exit_purpose)
        if use_exit_purpose == true then
            content = utils.merge_tables(content, highway_exit_information)
        end
    end
    content.purpose = instruction.get_highway_turn_purpose(use_exit_purpose, use_continue_purpose)

    local action_content = instruction.get_action_for_turn(content.trigger, message.turn, content.breaks_before_turn, message.order,
                                                           message.lane_information, content.purpose, message.road_class, message.distance.value_in_meters,
                                                           rules.use_lane_information, rules.lane_information_limit, rules.lane_count_limit)
    content = utils.merge_tables(content, action_content)

    if use_direction_information then
        local direction_information = direction.get_direction_information(message.order, content.trigger, message.instruction_class, message.road_class,
                                                                          message.street, message.route, message.signpost,
                                                                          rules.filter_direction_information,content.action, content.purpose,
                                                                          message.country_code, message.use_road_information_for_action_notification,
                                                                          message.use_signpost_direction_for_action_notification, continue_road_change)
        content = utils.merge_tables(content, direction_information)
    end

    content.additional_information = instruction.get_additional_info(content)
    return content
end


return instruction
