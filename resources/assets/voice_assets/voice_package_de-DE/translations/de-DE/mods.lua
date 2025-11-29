local mods = require('translations.mods')

local function use_dative(phrase, distance, unit)
    distance = tonumber(distance)
    if not distance then
        -- if distance is not a number return nil which cause no replacement
        return nil
    end
    if distance == 1 then
        -- if distance is one then use dative numeral
        if unit == 'Meile' then
            -- in case of mile one becomes einer
            return phrase:gsub(distance, 'einer')
        elseif unit == 'Kilometer' or unit == 'Meter' then
            -- in case of meter or kilometer one becomes einer
            return phrase:gsub(distance, 'einem')
        end
    elseif  distance > 1 and (unit == 'Kilometer' or unit == 'Meter') then
        -- if distance is greater than 1 and unit is meter or kilometer
        -- then add 'n' to the end of phrase
        return phrase .. 'n'
    end

    -- otherwise do not replace anything
    return nil
end

local function use_accusative(phrase, distance, unit)
    distance = tonumber(distance)
    if not distance then
        -- if distance is not a number return nil which cause no replacement
        return nil
    end
    if distance == 1 and (unit == 'Kilometer' or unit == 'Meter') then
        -- if distance is one and unit Kilometer or Meter then use accusative numeral
        return phrase:gsub(distance, 'einen')
    end
end


local function modify_article(street_name)
    local street_articles = {
        ['auf der Straße'] = {
            ['auf der'] = {'[aA]llee', '[sS]tra[sß]+e', '[gG]a[sß]+e', '[bB]rücke'},
            ['auf dem'] = {'[wW]eg', '[gG]ang', '[pP]fad', '[dD]amm', '[wW]all'},
            ['im'] = {'[tT]unnel'}
        },
        ['in die Straße'] = {
            ['in die'] = {'[sS]tra[sß]+e', '[gG]a[sß]+e'},
            ['in den'] = {'[wW]eg', '[gG]ang', '[pP]fad', '[tT]unnel'},
            ['auf den'] = {'[dD]amm', '[wW]all'},
            ['auf die'] = {'[aA]llee'}
        }
    }
    for source,targets in pairs(street_articles) do
        for target,suffixes in pairs(targets) do
            for _,suffix in ipairs(suffixes) do
                local replaced
                street_name,replaced = street_name:gsub(source .. ' (.*' .. suffix .. ')', target .. ' %1')
                if replaced > 0 then
                    return street_name
                end
            end
        end
    end
    return street_name
end

function mods.apply_language_specific_mods(sentence)
    -- Use dative case of the unit/one if used with 'Nach'
    sentence = sentence:gsub('(nach%s+(%d+%.?%d*)%s+(%w+))', use_dative)

    -- Use accusative case of the one in other cases
    sentence = sentence:gsub('(folgen.*für%s+(%d+%.?%d*)%s+(%w+))', use_accusative)
    sentence = sentence:gsub('%s+(%d+%.?%d*)%s+(%w+)%s+folgen%.)', use_accusative)
    sentence = sentence:gsub('|(.*)|', modify_article)

    sentence = sentence:gsub('nach {ORIENTATION} ', '')

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: '0.5 Meile' becomes '0,5 Meile')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
