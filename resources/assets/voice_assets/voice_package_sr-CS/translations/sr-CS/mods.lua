local mods = require('translations.mods')

local distance_unit_mapping = { ['kilometara'] = 'kilometra',
                                ['milja'] = 'milje' }

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = variables[distance_unit]

    -- handle dot as "," (e.g.: '0.5 milja' becomes '0,5 milja')
    distance = string.gsub(d, '(%d+)%.(%d+)', '%1,%2')

    if d > 1 and d < 5 and distance_unit_mapping[u] ~= nil then
        u = distance_unit_mapping[u]
    end

    return distance .. ' ' .. u
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("na {ORIENTATION} ", "")

    return sentence
end

return mods
