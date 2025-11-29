local mods = require('translations.mods')

function mods.apply_language_specific_mods(original_sentence)
    --[[
    Change "destinație" to "destinația" at the beginning of the second sentence, e.g.:
    "După un sfert de milă veți ajunge la destinație. destinație va fi în stânga dumneavoastră."
    ->
    "După un sfert de milă veți ajunge la destinație. Destinația va fi în stânga dumneavoastră."
    ]]
    local modified_sentence = original_sentence:gsub("%. destinație",
                                                     ". Destinația")

    --[[
    Modify original sentence, e.g.:
    "Acum virați la dreapta și apoi veți ajunge la destinație dumneavoastră.""
    ->
    "Acum virați la dreapta și apoi veți ajunge la destinația dumneavoastră."
    ]]
    modified_sentence = modified_sentence:gsub("la destinație dumneavoastră",
                                               "la destinația dumneavoastră")

    modified_sentence = modified_sentence:gsub("spre {ORIENTATION} ", "")

    return modified_sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'După 0,5 mile')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
