local mods = require('translations.mods')

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Tra 0,5 miglia')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("verso {ORIENTATION} ", "")
    sentence = sentence:gsub(" 1 chilometro", " un chilometro")
    sentence = sentence:gsub("poi immediatamente (%w+) ", "poi %1 immediatamente ")

    return sentence
end

return mods
