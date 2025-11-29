local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("^nu volg", "volg nu")
    sentence = sentence:gsub("^nu keer", "keer nu")
    sentence = sentence:gsub("^nu neem", "neem nu")

    sentence = sentence:gsub("richting {ORIENTATION} ", "")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as ","
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
