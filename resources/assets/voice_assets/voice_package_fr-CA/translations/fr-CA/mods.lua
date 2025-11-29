local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'After 0,5 miles')
    modified_sentence = string.gsub( modified_sentence, "(dans%s%d)%.(%d%s)", "%1,%2" )

    modified_sentence = string.gsub( modified_sentence, "la direction {ORIENTATION} ", "" )

    return modified_sentence
end

return mods
