local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("{[NEXT_]*DIRECTION} ನಲ್ಲಿ", "")

    return sentence
end

return mods

