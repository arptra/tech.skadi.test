local utils = require 'content.utils'
local common = require 'content.select.common'
local direction = require 'content.select.instruction.direction'
local lane_information = require 'content.select.instruction.lane_information'

local natural_guidance = {}


function natural_guidance.get_element(order, trigger, instruction_class, distance_in_meters, natural_guidance_table,
                                      use_natural_guidance_with_trigger_rules, natural_guidance_importance_threshold,
                                      natural_guidance_count_limit, natural_guidance_distance_limit,
                                      natural_guidance_elements_priority_order_rules,
                                      natural_guidance_distance_to_first_element_threshold)
    if (not natural_guidance_table) or
       (not use_natural_guidance_with_trigger_rules) or
       (not natural_guidance_importance_threshold) or
       (not natural_guidance_count_limit) or
       (not natural_guidance_distance_limit) or
       (not natural_guidance_elements_priority_order_rules) then
        return nil
    end

    local attributes = {instruction_order = order, trigger = trigger, instruction_class = instruction_class}
    local use_natural_guidance_with_trigger = common.get_config_value(use_natural_guidance_with_trigger_rules, attributes)
    if (use_natural_guidance_with_trigger == false) then
        return nil
    end

    attributes = {trigger = trigger}
    local natural_guidance_distance_treshold = common.get_config_value(natural_guidance_distance_limit, attributes)
    if (natural_guidance_distance_treshold ~= nil) and (distance_in_meters > natural_guidance_distance_treshold) then
        return nil
    end

    local filtered_natural_guidance_table = _filter_element_array(natural_guidance_table, natural_guidance_importance_threshold,
                                                                  natural_guidance_count_limit)

    local filtered_element = _select_top_priority_element(filtered_natural_guidance_table, natural_guidance_elements_priority_order_rules)
    if filtered_element == nil then return nil end

    if utils.inside(filtered_element.type, {'traffic_light', 'stop_sign'}) and order ~= 'second' then
        return _adjust_element_count(filtered_element,
                                     natural_guidance_distance_to_first_element_threshold)
    end
    return filtered_element
end

function _adjust_element_count(element, distance_to_first_element_threshold)
    if element.dist_to_first_element == nil then return element end

    local distance_threshold = common.get_config_value(distance_to_first_element_threshold, {})
    local over_distance_threshold = element.dist_to_first_element > distance_threshold

    if over_distance_threshold == false then
        local adjusted_element = utils.copy_table(element)
        adjusted_element.count = 0
        return adjusted_element
    end
    return element
end

function natural_guidance.excludes_distance(natural_guidance_element, use_distance_with_natural_guidance_switch)
    if natural_guidance_element == nil or utils.empty(natural_guidance_element) then return false end

    local attributes = {natural_guidance_type = natural_guidance_element.type}
    local use_distance_with_natural_guidance = common.get_config_value(use_distance_with_natural_guidance_switch, attributes)

    return not (use_distance_with_natural_guidance or natural_guidance_element.count == 0)
end


function natural_guidance.excluded_by_direction(direction_information, natural_guidance_element, use_natural_guidance_with_direction_rules)
    if natural_guidance_element == nil or utils.empty(natural_guidance_element) then return false end
    if direction_information == nil then return false end
    local direction_key = direction.get_direction_information_key(direction_information.street, direction_information.route, direction_information.signpost)
    if direction_key == nil then return false end
    local attributes = {natural_guidance_type = natural_guidance_element.type, direction_info = direction_key}
    local use_natural_guidance_with_direction = common.get_config_value(use_natural_guidance_with_direction_rules, attributes)
    return not use_natural_guidance_with_direction
end


function natural_guidance.excluded_by_lane_information(action_content, natural_guidance_element, instruction_order, use_natural_guidance_with_lane_information_rules)
    if not lane_information.is_available(action_content) then return false end
    if natural_guidance_element == nil or utils.empty(natural_guidance_element) then return false end

    local attributes = {instruction_order = instruction_order}
    local use_natural_guidance_with_lane_information = common.get_config_value(use_natural_guidance_with_lane_information_rules, attributes)
    return not use_natural_guidance_with_lane_information
end


function _use_element(element, natural_guidance_importance_threshold, natural_guidance_count_limit)
    if (element.importance ~= nil) and (element.count ~= nil) and ((element.type == 'traffic_light') or (element.type == 'stop_sign')) then
        local attributes = {}
        local min_importance = common.get_config_value(natural_guidance_importance_threshold, attributes)
        if (min_importance ~= nil) and (element.importance < min_importance) then
            return false
        end
        attributes = {}
        local max_count = common.get_config_value(natural_guidance_count_limit, attributes)
        if (max_count ~= nil) and ((element.count > max_count) or (element.count < 0)) then
            return false
        end
    end
    return true
end


function _filter_element_array(natural_guidance_table, natural_guidance_importance_threshold,
                               natural_guidance_count_limit)
    local result_array = {}
    for key in pairs(natural_guidance_table) do
        local element = natural_guidance_table[key]
        element.type = key
        if _use_element(element, natural_guidance_importance_threshold, natural_guidance_count_limit) then
            result_array[key] = element
        end
    end
    return result_array
end


function _select_top_priority_element(elements_table, natural_guidance_elements_priority_order_rules)
    local attributes = {}
    local prioritized_array = common.get_config_value(natural_guidance_elements_priority_order_rules, attributes)
    if type(prioritized_array) ~= 'table' then return nil end
    local filtered_element = nil
    for _,key in ipairs(prioritized_array) do
        if elements_table[key] ~= nil then
            filtered_element = elements_table[key]
            break
        end
    end
    return filtered_element
end

return natural_guidance
