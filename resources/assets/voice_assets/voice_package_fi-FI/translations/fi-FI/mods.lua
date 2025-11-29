local mods = require('translations.mods')

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- Handle dot as "," (e.g.: 'Kun 0.5 mailia' becomes 'Kun 0,5 mailia')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

function mods.apply_language_specific_mods(original_sentence)
    -- Handling "destination" and "waypoint" Finnish words in different (irregular) form
    local sentence = original_sentence:gsub("|([Mm])ääränpää|", "%1ääränpäähän")
    sentence = sentence:gsub("|[Rr]eittipiste|", "%1eittipisteeseen")
    sentence = sentence:gsub("^nyt aja", "aja nyt")
    sentence = sentence:gsub("^nyt tee", "tee nyt")
    sentence = sentence:gsub("^nyt jatka", "jatka nyt")

    return sentence
end

return mods
