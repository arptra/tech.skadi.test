local mods = require('translations.mods')

local distance_unit_mapping = { ['километров'] = 'километра',
                                ['миль'] = 'мили' }

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = variables[distance_unit]

    -- handle dot as "," (e.g.: 'Через 0.5 миль' becomes 'Через 0,5 миль')
    distance = string.gsub(d, '(%d+)%.(%d+)', '%1,%2')

    if d > 1 and d < 5 and distance_unit_mapping[u] ~= nil then
        u = distance_unit_mapping[u]
    end

    return distance .. ' ' .. u
end

function mods.apply_language_specific_mods(sentence)
    local streets = {
        ['на улица'] = 'на улицу',
        ['на набережная'] = 'на набережную',
        ['на (%S+)ая улица'] = 'на %1ую улицу',
        ['на (%S+)ая (%S+)ая улица'] = 'на %1ую %2ую улицу',
        ['на (%S+) пр%-т'] = 'на %1 проспект',
        ['на (%S+)ая площадь'] = 'на %1ую площадь',
        ['на (%S+)ая (%S+)ая площадь'] = 'на %1ую %2ую площадь',
        ['на (%S+)ая набережная'] = 'на %1ую набережную',
        ['на (%S+)ая (%S+)ая набережная'] = 'на %1ую %2ую набережную',
        ['в направлении ул%.'] = 'в направлении улицы',
        ['в направлении пр%.'] = 'в направлении проспекта',
        ['в направлении наб%.'] = 'в направлении набережной',
        ['в направлении ш%.'] = 'в направлении шоссе',
        ['в направлении пл%.'] = 'в направлении площади',
        ['в направлении (%S+) пр%-т'] = 'в направлении %1 проспект',
        ['в направлении (%S+) (%S+) пр%-т'] = 'в направлении %1 %2 проспект'
    }
    for source, target in pairs(streets) do
        updated_sentence, replaced = sentence:gsub(source, target)
        if replaced > 0 then
            return updated_sentence
        end
    end

    sentence = sentence:gsub("на {ORIENTATION} ", "")

    return sentence
end

return mods
