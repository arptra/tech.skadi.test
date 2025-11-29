local mods = require('translations.mods')

function mods.get_distance_phrase(distance, distance_unit, variables)
    distance = tonumber(distance)
    local unit_base = nil

    if distance_unit:find('feet') then unit_base = 'foot'
    elseif distance_unit:find('kilometer') then unit_base = 'kilometer'
    elseif distance_unit:find('meter') then unit_base = 'meter'
    elseif distance_unit:find('mile') then unit_base = 'mile'
    elseif distance_unit:find('yard') then unit_base = 'yard'
    end

    if unit_base ~= nil then
        if (unit_base == 'kilometer' or unit_base == 'mile') then
            local unit_table = { ['kilometer'] = { 'kilometer', 'kilometers.dual', 'kilometers.below10', 'kilometers.below100' },
                                 ['mile'] = { 'mile', 'miles.dual', 'miles.below10', 'miles.below100' }, }

            local distance_mod_100 = distance % 100
            local number_range

            if distance_mod_100 <= 1 then number_range = 1
            elseif distance_mod_100 == 2 then number_range = 2
            elseif distance_mod_100 >= 3 and distance_mod_100 <=10 then number_range = 3
            else number_range = 4 end

            unit_base = unit_table[unit_base][number_range]
        end
        distance_unit = 'nav.variable.UNIT.' .. unit_base
    end

    if distance == 1 then
        return variables[distance_unit] .. ' ' .. distance
    elseif distance == 2 then
        return variables[distance_unit]
    else
        return distance .. ' ' .. variables[distance_unit]
    end
end

function mods.apply_language_specific_mods(sentence)
    if _G['imperative_mode'] == nil then
        -- Update diacritic on `ثم` for better pronunciation by TTS engine
        sentence = sentence:gsub("ثم", "ثمَّ")
        -- Update diacritic on `Abdullah` for better pronunciation by TTS engine
        sentence = sentence:gsub("عبدال له", "عبدالله")
        -- Update diacritic on `Al Dammam` for better pronunciation by TTS engine
        sentence = sentence:gsub("الدمام", "الدمَّام")
        -- Use the phrase of eight hundred in Arabic for better pronunciation by TTS engine
        sentence = sentence:gsub(" 800 ", " ثمانية مئه ")
    end

    return sentence
end

return mods
