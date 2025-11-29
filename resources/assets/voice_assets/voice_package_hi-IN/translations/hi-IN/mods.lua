local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("%s*%.$", "।")
    sentence = sentence:gsub("{[NEXT_]*LANDMARK} से", "")

    return sentence
end

return mods
