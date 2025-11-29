local platform = {}

local utils = require('content.utils')

-- List of tts mapping:
-- tts01 : Nuance


function platform.adapt(raw_prompt, file_path)
    local voice_settings = _G['voice_settings'] or {}
    local output_format = voice_settings['tts_output_format']
    if output_format == nil then
        output_format = 'ssml'
    end
    local platform_text = raw_prompt
    if raw_prompt ~= nil and raw_prompt ~= '' then
        local variables = require('platform.' .. output_format .. '.variables')
        local placeholders = platform._get_placeholders(raw_prompt)
        for _, placeholder in ipairs(placeholders) do
            local replacement_value = platform._get_replacement_value(placeholder, variables, file_path)
            if replacement_value ~= nil then
                platform_text = string.gsub(
                    platform_text,
                    utils.escape_pattern_string(placeholder),
                    utils.escape_replacement_string(replacement_value),
                    1)
            end
        end
    end
    return platform_text
end


function platform._get_replacement_value(placeholder, variables, file_path)
    local value
    if string.match(placeholder, '<AUDIO:(.*)>') ~= nil then
        value = platform._get_audio(placeholder, variables, file_path)
    elseif string.match(placeholder, '<PAUSE:(.*)>') ~= nil then
        value = utils._get_parametrized_replacement(placeholder, 'PAUSE', variables)
    elseif string.match(placeholder, '<LANGUAGE:(.*)>') ~= nil then
        value = utils._get_parametrized_replacement(placeholder, 'LANGUAGE', variables)
    elseif string.match(placeholder, '<BEGIN_PHONEME:(.*)>') ~= nil then
        value = utils._get_parametrized_replacement(placeholder, 'BEGIN_PHONEME', variables)
    elseif string.match(placeholder, '<BEGIN_LANGUAGE:(.*)>') ~= nil then
        value = utils._get_parametrized_replacement(placeholder, 'BEGIN_LANGUAGE', variables)
    else
        local key = string.gsub(placeholder, '[<>]', '')
        key = 'platform_var.' .. key
        value = variables[key]
    end
    return value
end


function platform._get_audio(placeholder, variables, file_path)
    local value = string.gsub(placeholder, '[<>]', '')
    value = string.gsub(value, 'AUDIO:', '')
    value = file_path .. value
    return string.gsub(variables['platform_var.AUDIO'], '<PARAM>', value)
end


function platform._get_placeholders(template)
    local placeholders = {}
    for placeholder in string.gmatch(template, '(<[^<>]->)') do
        table.insert(placeholders, placeholder)
    end
    return placeholders
end


return platform
