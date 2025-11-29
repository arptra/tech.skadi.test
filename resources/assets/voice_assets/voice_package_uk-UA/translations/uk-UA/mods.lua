local mods = require('translations.mods')

local function is_fractional(d)
    return d % 1 ~= 0
end

local function ends_with_1(d)
    -- check if number ends with digit 1 and not with 11
    return d % 10 == 1 and d ~= 1 and d % 100 ~= 11
end

local function ends_with_2_to_4(d)
    -- check if number ends with digit between 2 - 4 and not between 12 - 14
    local ones = d % 10
    local tens = d % 100 - ones
    return ones >= 2 and ones <= 4 and tens ~= 10
end

local numeral_rules = {
    -- handle dot as "," (e.g.: 'За 0.5 миль' becomes 'За 0,5 миль') and replace unit name
    [1] = { is_applicable = is_fractional,      applicate = function(d, u) return string.gsub(d, '(%d+)%.(%d+)', '%1,%2'), u..'.fractional' end},
    [2] = { is_applicable = ends_with_1,        applicate = function(d, u) return d, u..'.singular' end},
    [3] = { is_applicable = ends_with_2_to_4,   applicate = function(d, u) return d, u..'.uptofour' end}
}

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = distance_unit
    local v = variables

    for _,rule in ipairs(numeral_rules) do
        if rule.is_applicable(d) then
            d, u = rule.applicate(d, u)
            break
        end
    end

    return d .. ' ' .. v[u]
end

function mods.apply_language_specific_mods(sentence)
    sentence = string.gsub(sentence, "на {ORIENTATION} ", "")

    local streets = {
        [' вул%S*[%.я]%s+'] = ' вулиця',
        [' вул%S*[%.я]%p+$'] = ' вулиця',
        [' пр%S*%-т'] = ' проспект',
        [' прос%S*[%.т]'] = ' проспект',
        [' пл%S*[%.а]'] = ' площа',
        [' наб%S*[%.а]'] = ' набережна',
        [' шос%S*[%.е]'] = ' шосе',
        [' пров%S*[%.к]'] = ' провулок',
        [' пр%S*%-к'] = ' провулок',
        [' бул%S*[%.р]'] = ' бульвар',
        [' б%S*%-р'] = ' бульвар',
        [' у%S*[%.з]'] = ' узвіз',
        [' у%S*%-з'] = ' узвіз'
    }
    for source, target in pairs(streets) do
        local updated_sentence, replaced = sentence:gsub(source, target)
        if replaced > 0 then
            sentence = updated_sentence
        end
    end
    streets = {
        ['на вулицю (%S+[сц])ька вулиця'] = 'на %1ьку вулицю',
        ['на вулицю (%S+)а (%S+[сц])ька вулиця'] = 'на %1у %2ьку вулицю',
        ['на вулицю (%S+[сц])ька площа'] = 'на %1ьку площу',
        ['на вулицю (%S+)а (%S+[сц])ька площа'] = 'на %1у %2ьку площу',
        ['на вулицю (%S+[сц])ька набережна'] = 'на %1ьку набережну',
        ['на вулицю (%S+)а (%S+[сц])ька набережна'] = 'на %1у %2ьку набережну',
        ['на вулицю (.+) проспект'] = 'на %1 проспект',
        ['на вулицю (.+) шосе'] = 'на %1 шосе',
        ['на вулицю (.+) провулок'] = 'на %1 провулок',
        ['на вулицю (.+) бульвар'] = 'на %1 бульвар',
        ['на вулицю (.+) узвіз'] = 'на %1 узвіз'
    }
    for source, target in pairs(streets) do
        local updated_sentence, replaced = sentence:gsub(source, target)
        if replaced > 0 then
            return updated_sentence
        end
    end
    streets = {
        ['на вулицю (.+) вулиця'] = 'на %1 вулицю',
        ['на вулицю (.+) площа'] = 'на %1 площу',
        ['на вулицю (.+) набережна'] = 'на %1 набережну'
    }
    for source, target in pairs(streets) do
        local updated_sentence, replaced = sentence:gsub(source, target)
        if replaced > 0 then
            return updated_sentence
        end
    end
    return sentence
end

return mods
