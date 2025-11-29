local content = require 'content.init'
local prompt = require 'prompt.init'
local config = require 'config.init'
local rules = require 'config.rules'
local platform = require 'platform.init'

require 'skin'

function _G.get_text_output()
    local input = _G
    input.maneuver = input.maneuver_1
    local message_table = content.extract(input)
    if type(message_table) == "table" then
        local next_message_table = nil
        if input.maneuver_count == 1 then
            message_table.order = 'single'
        else
            message_table.order = 'first'
            input.maneuver = input.maneuver_2
            next_message_table = content.extract(input)
            if type(next_message_table) == "table" then
                next_message_table.order = 'second'
            end
        end

        local selection_rules = config.get_selection_rules(rules, input.voice_settings or {})
        local prompt_table = content.select(message_table, next_message_table, selection_rules)
        local language_code = input.main_attribute_array["language_code"]
        local prompt_text = prompt.realize(prompt_table, language_code)
        if (type(package)=="table")  and (type(package.config)=="string") then
            local audio_files_path = input.audio_files_path_absolute or ''
            local file_path = audio_files_path .. package.config:sub(1, 1)
            local platform_text = platform.adapt(prompt_text, file_path)
            _G.result_list = {platform_text}
        end
    end
end
