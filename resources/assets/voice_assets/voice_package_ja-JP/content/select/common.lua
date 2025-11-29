local utils = require 'content.utils'

local common  = {}


function common.get_config_value(config_table, attribute_table)
    if not config_table or not attribute_table then return end
    local config = config_table

    while not utils.inside('Setting', utils.keys(config)) do
        local attribute = config['Attribute']
        local value = attribute_table[attribute]
        if not value then
            return nil
        end
        if utils.inside(value, utils.keys(config['Values'])) then
            config = config['Values'][value]
        elseif utils.inside('*', utils.keys(config['Values'])) then
            config = config['Values']['*']
        else
            return nil
        end
    end
    return config['Setting']
end


function common.is_ignored_warning(rules, message)
    local attributes = { ['trigger_class'] = message.trigger_class,
                         ['trigger'] = message.trigger,
                         ['use_speed_camera'] = message.use_speed_camera,
                         ['use_speed_warner'] = message.use_speed_warner }
    return common.get_config_value(rules.ignore_warning, attributes)
end


function common.get_prompt_table(content_table, next_content_table)
    local prompt_table = common._get_prompt_variables(content_table, next_content_table)
    prompt_table.prompt_id = common._get_prompt_id(content_table, next_content_table)
    return prompt_table
end


function common._get_prompt_variables(content_table, next_content_table)
    local prefixed_next_content_table = {}
    if next_content_table then
        for key, value in pairs(next_content_table) do
            prefixed_next_content_table['next_'..key] = value
        end
    end
    return utils.merge_tables(content_table, prefixed_next_content_table)
end


function common._get_prompt_id(content_table, next_content_table)
    if content_table.prompt_class == 'instruction' then
       return common._get_prompt_id_instruction(content_table, next_content_table)
    else
       return common._get_prompt_id_warning(content_table)
    end
end


function common._get_prompt_id_instruction(content_table, next_content_table)
    if not content_table.prompt_class then return nil end

    if not content_table.action then return nil end
    local action_segment = content_table.action

    if not content_table.time then return nil end
    local time_segment = content_table.time

    if time_segment == 'afterdistance' or time_segment == 'now' or time_segment == 'none' then
        time_segment = 'interval'
    end

    local purpose_segment = '-'
    if content_table.purpose then
        purpose_segment = content_table.purpose
    end

    local additional_information_segment_first = common._get_additional_information_segment(content_table)

    local next_action_segment = '-'
    local next_purpose_segment = '-'
    local additional_information_segment_second = '-'
    if action_segment ~= 'follow' and next_content_table then
        if not next_content_table.action then return nil end
        next_action_segment = next_content_table.action

        if next_content_table.purpose then
            next_purpose_segment = next_content_table.purpose
        end

        additional_information_segment_second = common._get_additional_information_segment(next_content_table)
    end

    local segments1 = {'nav', time_segment,
                      action_segment, purpose_segment, additional_information_segment_first}

    local segments2 = {'nav', 'second',
                      next_action_segment, next_purpose_segment, additional_information_segment_second}

    return {table.concat(segments1, '.'), table.concat(segments2, '.')}
end


function common._get_prompt_id_warning(content_table)
    if not content_table.prompt_class then return nil end

    if not content_table.action then return nil end
    local action_segment = content_table.action

    local segments = {'nav', action_segment}

    return {table.concat(segments, '.')}
end


function common._get_additional_information_segment(content_table)
    if content_table.additional_information then return content_table.additional_information end
    return '-'
end

return common
