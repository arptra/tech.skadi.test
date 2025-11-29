local mods = require('translations.mods')

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Després de 0,5 milles')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("de 1 ", "d'un ")
    sentence = sentence:gsub("de un ", "d'un ")
    sentence = sentence:gsub("de una ", "d'una ")
    sentence = sentence:gsub("La punt intermig", "El punt intermig")
    sentence = sentence:gsub("a la vostra punt intermig", "al vostre punt intermig")

    sentence = sentence:gsub("immediatament gireu", "gireu immediatament")
    sentence = sentence:gsub("immediatament continueu", "continueu immediatament")
    sentence = sentence:gsub("immediatament seguiu", "seguiu immediatament")
    sentence = sentence:gsub("immediatament useu", "useu immediatament")

    sentence = sentence:gsub("en sentit {ORIENTATION} ", "")

    return sentence
end

return mods
