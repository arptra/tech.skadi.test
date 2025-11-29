local utils = require 'content.utils'

local prompt = {}

local constants = require 'prompt.constants'

function prompt.realize(prompt_table, language_code)
    local templates = require('translations.'..language_code..'.templates')
    local prompt_output = ''

    if prompt_table and prompt_table.prompt_id ~= nil and templates[prompt_table.prompt_id[1]] then
        local substitutes = {}
        substitutes.variables = require('translations.'..language_code..'.variables')
        substitutes.clauses = require('translations.'..language_code..'.clauses')
        local mods = require('translations.'..language_code..'.mods')
        local template = templates[prompt_table.prompt_id[1]]

        if template:find('{SECOND}') and templates[prompt_table.prompt_id[2]] then
            template = template:gsub('{SECOND}', templates[prompt_table.prompt_id[2]])
        end

        if not template:find('>$') then
            template = template .. '.'
        end

        prompt_output = prompt._substitute_placeholders(template, prompt_table, substitutes, mods)
        prompt_output = mods.apply_language_specific_mods(prompt_output)
        prompt_output = prompt._cleanup(prompt_output)
    end
    return prompt_output
end


function prompt._substitute_placeholders(template, prompt_table, substitutes, mods)
    local function _get_value_for_placeholder(placeholder)
        local value
        -- template placeholders
        ---- placeholders for clauses
        if placeholder == '{TURN_KEEP}' then
            value = prompt._get_turn_keep_phrase(prompt_table, substitutes, 'current')
        elseif placeholder == '{NEXT_TURN_KEEP}' then
            value = prompt._get_turn_keep_phrase(prompt_table, substitutes, 'next')
        elseif placeholder == '{INTERVAL}' then
            value = prompt._get_interval_phrase(prompt_table, substitutes, mods)
        elseif placeholder == '{DIRECTION}' then
            value = prompt._get_direction_phrase(prompt_table, substitutes, 'current')
        elseif placeholder == '{NEXT_DIRECTION}' then
            value = prompt._get_direction_phrase(prompt_table, substitutes, 'next')
        ---- placeholders for values
        elseif placeholder == '{GOAL}' then
            value = substitutes.variables[prompt_table.goal]
        elseif placeholder == '{NEXT_GOAL}' then
            value = substitutes.variables[prompt_table.next_goal]
        elseif placeholder == '{SIDE}' then
            value = substitutes.variables[prompt_table.side_of_road]
        elseif placeholder == '{HIGHWAY}' then
            value = substitutes.variables[prompt_table.highway_category]
        elseif placeholder == '{NEXT_HIGHWAY}' then
            value = substitutes.variables[prompt_table.next_highway_category]
        elseif placeholder == '{TAKE_NTH_EXIT}' then
            value = substitutes.variables[prompt_table.roundabout_exit_number]
        elseif placeholder == '{NEXT_TAKE_NTH_EXIT}' then
            value = substitutes.variables[prompt_table.next_roundabout_exit_number]
        elseif placeholder == '{EXIT}' then
            value = prompt._get_direction(prompt_table.exit_name, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{NEXT_EXIT}' then
            value = prompt._get_direction(prompt_table.next_exit_name, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{LANDMARK}' then
            value = prompt._get_natural_guidance(prompt_table.natural_guidance, substitutes.variables)
        elseif placeholder == '{NEXT_LANDMARK}' then
            value = prompt._get_natural_guidance(prompt_table.next_natural_guidance, substitutes.variables)
        elseif placeholder == '{IMMEDIATELY}' then
            value = prompt._get_immediately_phrase(prompt_table.next_immediately, substitutes.variables)
        elseif placeholder == '{AGAIN}' then
            value = prompt._get_again_phrase(prompt_table, substitutes.variables)
        elseif placeholder == '{ORIENTATION}' then
            value = prompt._get_orientation(prompt_table, substitutes.variables)

        -- clause placeholders for values
        elseif placeholder == '{DISTANCE}' then
            value = prompt._get_distance(prompt_table, substitutes.variables, mods)
        elseif placeholder == '{LANE}' then
           value = substitutes.variables[prompt_table.turn_information.lane_phrase_id]
        elseif placeholder == '{NEXT_LANE}' then
           value = substitutes.variables[prompt_table.next_turn_information.lane_phrase_id]
        elseif placeholder == '{MOVE}' then
           value = substitutes.variables[prompt_table.turn_information.move_phrase_id]
        elseif placeholder == '{NEXT_MOVE}' then
           value = substitutes.variables[prompt_table.next_turn_information.move_phrase_id]
        elseif placeholder == '{ROUTE}' then
            value = prompt._get_direction(prompt_table.route, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{NEXT_ROUTE}' then
            value = prompt._get_direction(prompt_table.next_route, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{STREET}' then
            value = prompt._get_direction(prompt_table.street, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{NEXT_STREET}' then
            value = prompt._get_direction(prompt_table.next_street, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{SIGNPOST}' then
            value = prompt._get_direction(prompt_table.signpost, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        elseif placeholder == '{NEXT_SIGNPOST}' then
            value = prompt._get_direction(prompt_table.next_signpost, prompt_table.vp_marc_lang_code, prompt_table.vp_supported_lang_code)
        end

        if value == '' then
            value = placeholder
        end

        return value
    end

    local placeholder_pattern = '{[%u_]+}' -- pattern for {PLACE_HOLDER}
    return string.gsub(template, placeholder_pattern, _get_value_for_placeholder)
end


function prompt._get_distance(prompt_table, variables, mods)
    local value = prompt_table.distance_value
    local unit = prompt_table.distance_unit_phrase_id

    local adapted_mile_phrase = prompt._adapt_mile_phrase(value, unit, variables)
    if adapted_mile_phrase then return adapted_mile_phrase end

    return mods.get_distance_phrase(value, unit, variables)
end


function prompt._adapt_mile_phrase(distance_value, distance_unit, variables)
    local fractional_part = distance_value % 1
    local integral_part = (math.tointeger or math.floor)(distance_value - fractional_part) -- For backward compatibility. Remove math.floor when dropping support for lua5.1.

    if distance_unit == 'nav.variable.UNIT.miles' and integral_part == 0 then
        if fractional_part == 0.25 then return variables['nav.variable.DISTANCE.quartermile']
        elseif fractional_part == 0.5 then return variables['nav.variable.DISTANCE.halfmile']
        elseif fractional_part == 0.75 then return variables['nav.variable.DISTANCE.threequartersmile']
        end
    elseif (distance_unit == 'nav.variable.UNIT.mile' or distance_unit == 'nav.variable.UNIT.miles') and integral_part >= 1 and integral_part < 10 and fractional_part == 0.5 then
        local variable_key = 'nav.variable.DISTANCE.' .. tostring(integral_part) .. 'andhalfmiles'
        return variables[variable_key]
    end
    return nil
end


function prompt._phonemes_supported()
    local voice_settings = _G['voice_settings'] or {}
    return voice_settings['tts_output_format'] ~= 'raw'
end


function prompt._get_direction(direction_table, marc_code, supported_lang_code)
    if not direction_table then return '' end
    local direction = direction_table.name

    if _G['imperative_mode'] == nil then
        direction = prompt._get_phoneme(direction_table.name, direction_table.phonetic_form, direction_table.phonetic_language, marc_code, supported_lang_code)
        -- no phoneme available
        if direction_table.name == direction then
            direction = prompt._expand_abbreviation(direction_table.name, direction_table.orthographic_language)
        end
    end
    return direction
end


function prompt._get_exit(exit_number_table, exit_name_table, marc_code, supported_lang_code)
    local exit_number = prompt._get_exit_segment(exit_number_table, marc_code, supported_lang_code)
    local exit_name = prompt._get_exit_segment(exit_name_table, marc_code, supported_lang_code)

    if exit_number and exit_name then return exit_number .. ', ' .. exit_name
    else return exit_number or exit_name end
end


function prompt._get_exit_segment(exit_segment_table, marc_code, supported_lang_code)
    if exit_segment_table then
        if exit_segment_table.content and exit_segment_table.content:find('%d') then
            return exit_segment_table.content
        else
            return prompt._get_phoneme(exit_segment_table.content, exit_segment_table.phonetic_form, exit_segment_table.phonetic_language, marc_code, supported_lang_code)
        end
    end
end


function prompt._get_natural_guidance(natural_guidance_table, variables)
    local natural_guidance_text = ''
    if natural_guidance_table ~= nil then
        local key = 'nav.variable.LANDMARK.'
        if natural_guidance_table.type == 't_junction' then
            key = key..'endofroad'
            natural_guidance_text = variables[key]
        end
        if natural_guidance_table.type == 'traffic_light' then
            key = key .. constants.order_prefix[tostring(natural_guidance_table.count)] .. 'light'
            natural_guidance_text = variables[key]
        end
        if natural_guidance_table.type == 'stop_sign' then
            key = key .. constants.order_prefix[tostring(natural_guidance_table.count)] .. 'stop'
            natural_guidance_text = variables[key]
        end
    end
    return natural_guidance_text
end


function prompt._get_turn_keep_phrase(prompt_table, substitutes, segment_order)
    local phrase, template_id, template
    if segment_order == 'next' then
        template_id = prompt_table.next_turn_information.turn_clause_id
    else
        template_id = prompt_table.turn_information.turn_clause_id
    end
    template = substitutes.clauses[template_id]
    if segment_order == 'next' then
        template = template:gsub('{', '{NEXT_')
    end
    phrase = prompt._substitute_placeholders(template, prompt_table, substitutes)
    return phrase
end


function prompt._get_interval_phrase(prompt_table, substitutes, mods)
    local phrase = ''
    local template_id = 'nav.clause.INTERVAL.' .. prompt_table.time
    template = substitutes.clauses[template_id]
    if template ~= nil then
        phrase = prompt._substitute_placeholders(template, prompt_table, substitutes, mods)
    end
    return phrase
end


function prompt._get_direction_phrase(prompt_table, substitutes, segment_order)
    local template, phrase = ''
    local template_id = 'nav.clause.DIRECTION.'
    local route, street, signpost
    local prompt_id
    if segment_order == 'next' then
        route = prompt_table.next_route
        street = prompt_table.next_street
        signpost = prompt_table.next_signpost
        prompt_id = prompt_table.prompt_id[2]
    else
        route = prompt_table.route
        street = prompt_table.street
        signpost = prompt_table.signpost
        prompt_id = prompt_table.prompt_id[1]
    end
    if route ~= nil or street ~= nil or signpost ~= nil then
        if (prompt_id:find('tocontinue')
                or prompt_id:find('tojoin'))
            and (route or street) and signpost then
            if route then
                template_id = template_id .. 'route-signpost.' .. route.preposition_id
            else
                template_id = template_id .. 'street-signpost.' .. street.preposition_id
            end
        elseif prompt_table.class == 'highway_turn' and route
            and ((prompt_id:find('toexit') and not prompt_id:find('tocontinue'))
                or (prompt_id:find('turnkeep') and not prompt_table.purpose)) then
            template_id = template_id .. 'route-signpost.towards'
        else
            if street and signpost and _G['imperative_mode'] ~= nil then
                template_id = template_id .. 'street-signpost.' .. street.preposition_id
            elseif signpost then
                template_id = template_id .. 'signpost.' .. signpost.preposition_id
            elseif street then
                template_id = template_id .. 'street.' .. street.preposition_id
            elseif route then
                template_id = template_id .. 'route.' .. route.preposition_id
            else
                return ''
            end
        end
        template = substitutes.clauses[template_id]
        if segment_order == 'next' then
            template = template:gsub('{', '{NEXT_')
        end
        phrase = prompt._substitute_placeholders(template, prompt_table, substitutes)
        phrase = phrase:gsub('%,%s*$','')
    end
    return phrase
end


function prompt._get_immediately_phrase(phrase_id, variables)
    if phrase_id then
        return variables[phrase_id]
    else
        return ''
    end
end


function prompt._get_again_phrase(prompt_table, variables)
    if prompt_table.turn_information ~= nil
        and prompt_table.next_turn_information ~= nil then
        local bearing_list = {'left', 'right', 'straight', 'middle'}

        for _, bearing in ipairs(bearing_list) do
            if prompt_table.turn_information.move_phrase_id:find(bearing)
                and prompt_table.next_turn_information.move_phrase_id:find(bearing) then
                return variables['nav.variable.again']
            end
        end
    end
    return ''
end


function prompt._get_phoneme(information_string, information_phoneme, phoneme_lang_code, marc_code, supported_lang_code)
    if not prompt._phonemes_supported() then
        return information_string
    end
    if information_string == '' or
        not information_phoneme or information_phoneme == '' or
        not phoneme_lang_code or not marc_code then
        return information_string
    end
    if (string.upper(phoneme_lang_code) == 'ID' and string.upper(supported_lang_code) == 'ID') or
       string.upper(supported_lang_code) == 'TH' then
        return information_string
    end
    local dest_lang = constants.phoneme_lang_to_nuance[string.upper(phoneme_lang_code)]
    local orig_lang = constants.marc_to_nuance[string.upper(marc_code)]
    if (not voice_settings['tts_output_format'] or voice_settings['tts_output_format'] == 'ssml')
        and dest_lang ~= nil then
        result = prompt._build_ssml_phoneme(dest_lang, information_phoneme, information_string)
        return result
    end
    if not dest_lang or not orig_lang then
        return information_string
    end
    information_phoneme = string.gsub(information_phoneme, '<break>', '<END_PHONEME><PAUSE:30><BEGIN_PHONEME_DEFAULT>')
    local result = '<BEGIN_PHONEME:' .. information_string .. '>' .. information_phoneme .. '<END_PHONEME>'
    if phoneme_lang_code ~= supported_lang_code then result = '<LANGUAGE:' .. dest_lang .. '>' .. result .. '<LANGUAGE:' .. orig_lang .. '>' end
    result = '<BEGIN_ADDRESS>' .. result .. '<END_ADDRESS>'
    return result
end


function prompt._build_ssml_phoneme(nuance_lang_code, phoneme, orthographic)
   if not phoneme then return orthographic end
   phoneme = phoneme:gsub('&', '&amp;'):gsub('<', '&lt;'):gsub('>', '&gt;'):gsub('"', '&quot;'):gsub('\'', '&apos;')
   return
      '<BEGIN_LANGUAGE:' .. nuance_lang_code .. '>' .. '<BEGIN_PHONEME:' .. phoneme .. '>' ..  orthographic .. "<END_PHONEME><END_LANGUAGE>"
end


function prompt._expand_abbreviation(phrase, phrase_lang_code)
    local expanded_phrase = phrase
    if phrase_lang_code ~= nil then
        if string.lower(phrase_lang_code) == 'zh-latn' or phrase_lang_code:find("^en(-)") ~= nil then
            phrase_lang_code = 'en'
        end
        if utils.contains( constants.supported_abbreviation_languages, phrase_lang_code, true ) then
            local status, abbreviation = pcall(require, 'prompt.abbreviation_' .. phrase_lang_code)
            if status then
                expanded_phrase = abbreviation.expand_abbreviation(phrase)
            end
        end
    end
    return expanded_phrase
end


function prompt._get_orientation(prompt_table, variables)
    if prompt_table.orientation ~= nil then
        return variables[prompt_table.orientation]
    end
    return ''
end


function prompt._cleanup(phrase)
    -- Remove unnecessary placeholder
    local clean_phrase = phrase:gsub('%s*%{[%w_]+%}', '')
    -- Remove redundant elements
    clean_phrase = clean_phrase:gsub('%s+', ' '):gsub('%s+,', ','):gsub(',+', ','):gsub('%s+%.', '.'):gsub('%.+', '.'):gsub(',+%.+', '.')
    -- Remove space at the beginning of the notification
    clean_phrase = clean_phrase:gsub("^%s*(.-)%s*$", "%1")
    -- Capitalize the sentence
    clean_phrase = clean_phrase:sub(1,1):upper() .. clean_phrase:sub(2)
    return clean_phrase
end


return prompt
