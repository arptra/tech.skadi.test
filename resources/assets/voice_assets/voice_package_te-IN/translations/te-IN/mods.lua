local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    modified_sentence = string.gsub( modified_sentence, "{ORIENTATION} వైపు ", "" )

    return modified_sentence
end

return mods
