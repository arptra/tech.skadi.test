local mods = require('translations.mods')

function mods.apply_language_specific_mods(original_sentence)
    -- handle destination
    local sentence = string.gsub(original_sentence, "hedef hedefinize", "hedefinize")
    sentence = string.gsub(sentence, "hedef hedefi", "hedefiniz")

    -- replace "toyola yoluna" with "toyola"
    sentence = string.gsub(sentence, "toyola yoluna", "toyola")

    -- replace doubled "istikametinde istikametine" with "istikametine"
    sentence = string.gsub(sentence, "istikametinde istikametine", "istikametine")

    -- replace doubled "istikametinde yönünde" with "istikametinde"
    sentence = string.gsub(sentence, "istikametinde yönünde", "istikametinde")
  
    sentence = string.gsub(sentence, "%(daha%) %{IMMEDIATELY%}", "daha")
    sentence = string.gsub(sentence, "%(daha%) ", "")

    sentence = string.gsub(sentence, "{ORIENTATION} yönüne ", "")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- Handle dot as "," (e.g.: 'After 0.5 mil' becomes 'A 0,5 mil')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
