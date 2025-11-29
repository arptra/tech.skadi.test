local mods = require('translations.mods')

local distance_unit_mapping = { ['kilometrů'] = 'kilometry',
                                ['metrů'] = 'metry',
                                ['mil'] = 'míle',
                                ['yardů'] = 'yardy',
                                ['stop'] = 'stopy' }

-- Names of Czech streets should have word "street" (ulice) added before the actual name, for them to be in correct case, except if street name contains one of the following exceptions: náměstí (square), třída (avenue), most (bridge), nábřeží (river bank), ulice (street), alej (parkway), zahrada (garden), zahrady (gardens) and sad or sady (orchard(s))
function modify_streetname(street_name)
    local exceptions = {'náměstí', 'třída', 'most', 'nábřeží', 'ulice', 'alej', 'zahrada', 'zahrady', 'sad', 'sady'}
    local exception_found = false
    local street_name_lower_case = street_name:lower()
    for _, exception in pairs(exceptions) do
        if (street_name_lower_case:find(exception)) then
            exception_found = true
            break
        end
    end
    if (street_name:find('<BEGIN_ADDRESS>')) then
        exception_found = true
    end
    if (not exception_found) then
        if (street_name:sub(1, 3) == 'do ') then
            street_name = street_name:gsub('do (.*)', 'do ulice %1')
        elseif (street_name:sub(1, 3) == 'na ') then
            street_name = street_name:gsub('na (.*)', 'na ulici %1')
        end
    end
    return street_name
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub('|(.*)|', modify_streetname)
    sentence = sentence:gsub("%. a poté ", ". poté ")
    sentence = sentence:gsub("%. poté ", ". Poté ")
    sentence = sentence:gsub("a se držte", "a držte se")
    sentence = sentence:gsub("{LANDMARK} se otočte", "otočte se")
    sentence = sentence:gsub("%{LANDMARK%} %(poté%)", "poté")
    sentence = sentence:gsub("%(poté%)", "")
    
    sentence = sentence:gsub("^[{INTERVAL}]*%s*a ", "")
    sentence = sentence:gsub("^[{INTERVAL}]*%s*[a%s]*poté ", "")
    sentence = sentence:gsub("nyní [a%s]*poté ", "nyní ")
    sentence = sentence:gsub("[a%s]*poté (.+) a poté", ", %1, a poté")

    sentence = sentence:gsub("na {ORIENTATION} ", "")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = variables[distance_unit]
    local v = variables

    --Replaces dot with a coma in numbers with decimal point 0.5 -> 0,5
    distance = string.gsub(d, '(%d+)%.(%d+)', '%1,%2')

    if d > 1 and d < 5 and distance_unit_mapping[u] ~= nil then
        u = distance_unit_mapping[u]
    end

    return distance .. ' ' .. u
end

return mods
