local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    -- add '-en' at the unit's end for 'follow distance' prompts with 'keresztül' word
    -- e.g.: "6 kilométer keresztül" becomes "6 kilométeren keresztül"
    modified_sentence = string.gsub(modified_sentence, '(%d+%.?%d*)%s+([^%s%p]+)%s+(keresztül)', '%1 %2en %3')

    -- add '.' at the end of pure digit exit number to make it sound ordinal
    -- e.g.: "a 8 kijáraton" becomes "a 8. kijáraton"
    modified_sentence = string.gsub(modified_sentence, '(a)%s+([%d]+)%s+(kijáraton)', '%1 %2. %3')

    -- remove repetitive orthographic word of street (utca) in the directional phrase
    modified_sentence = string.gsub(modified_sentence, 'utca utcá', 'utcá')

    modified_sentence = string.gsub(modified_sentence, '{ORIENTATION} irányába ', '')

    return modified_sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: '0.5 mérföld' becomes '0,5 mérföld')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
