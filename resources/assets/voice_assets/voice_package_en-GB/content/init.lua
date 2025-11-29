local content = {}

require 'content.utils'

function content.extract(input_table)
    local common = require 'content.extract.common.init'
    local warning = require 'content.extract.warning.init'
    local instruction = require 'content.extract.instruction.init'

    local trigger_class = common.attributes.get_trigger_class(input_table)

    if trigger_class == 'warning' then
        return warning.extract_warning(input_table)
    elseif trigger_class == 'instruction' then
        local instruction_class = instruction.attributes.get_instruction_class(input_table.maneuver.id,
                                                                               input_table.maneuver.road_class,
                                                                               input_table.maneuver.next_road_class)
        if instruction_class == 'arrival' then
            return instruction.extract_arrival(input_table)
        elseif instruction_class == 'head' then
            return instruction.extract_head(input_table)
        elseif instruction_class == 'uturn' then
            return instruction.extract_uturn(input_table)
        elseif instruction_class == 'ferry' then
            return instruction.extract_ferry(input_table)
        elseif instruction_class == 'exit_roundabout' then
            return instruction.extract_exit_roundabout(input_table)
        elseif instruction_class == 'roundabout' then
            return instruction.extract_roundabout(input_table)
        elseif instruction_class == 'enter_highway' then
            return instruction.extract_enter_highway(input_table)
        elseif instruction_class == 'junction' then
            return instruction.extract_junction(input_table)
        elseif instruction_class == 'highway_turn' then
            return instruction.extract_highway_turn(input_table)
        end
    end
end


function content.select(message_table, next_message_table, rules)
    local common = require 'content.select.common'
    local warning = require 'content.select.warning'
    local instruction = require 'content.select.instruction.init'

    if common.is_ignored_warning(rules, message_table) then
        return nil
    end

    local content_table, next_content_table
    if message_table.trigger_class == 'warning' then
        content_table = warning.select_warning(message_table.trigger)
    elseif message_table.trigger_class == 'instruction' then
        content_table = _select_instruction(instruction, message_table, rules)
        if next_message_table and next_message_table.trigger_class == 'instruction' then
            next_content_table = _select_instruction(instruction, next_message_table, rules)
        end
    end

    return common.get_prompt_table(content_table, next_content_table)
end

function _select_instruction(instruction, message_table, rules)
    local content_table
    local suppressed = instruction.get_suppressed_instruction(message_table.road_class,
                                                              message_table.distance.value_in_meters,
                                                              message_table.distance.unit,
                                                              message_table.distance.value_in_unit,
                                                              rules.suppressing_threshold)
    if suppressed then
        content_table = suppressed
    elseif message_table.instruction_class == 'arrival' then
        content_table = instruction.select_arrival(message_table, rules)
    elseif message_table.instruction_class == 'head' then
        content_table = instruction.select_head(message_table, rules)
    elseif message_table.instruction_class == 'uturn' then
        content_table = instruction.select_uturn(message_table, rules)
    elseif message_table.instruction_class == 'ferry' then
        content_table = instruction.select_ferry(message_table, rules)
    elseif message_table.instruction_class == 'exit_roundabout' then
        content_table = instruction.select_exit_roundabout(message_table, rules)
    elseif message_table.instruction_class == 'roundabout' then
        content_table = instruction.select_roundabout(message_table, rules)
    elseif message_table.instruction_class == 'enter_highway' then
        content_table = instruction.select_enter_highway(message_table, rules)
    elseif message_table.instruction_class == 'junction' then
        content_table = instruction.select_junction(message_table, rules)
    elseif message_table.instruction_class == 'highway_turn' then
        content_table = instruction.select_highway_turn(message_table, rules)
    end
    return content_table
end


return content
