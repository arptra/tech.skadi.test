local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("{[NEXT_]*DIRECTION} নিন", "")
    sentence = sentence:gsub("{[NEXT_]*DIRECTION} এ যান", "")
    sentence = sentence:gsub("{[NEXT_]*DIRECTION} এ", "")
    sentence = sentence:gsub("{[NEXT_]*LANDMARK} এ আসুন", "")
    sentence = sentence:gsub("{[NEXT_]*LANDMARK} এ", "")
    sentence = sentence:gsub("%s*,+%s*{SECOND}", "")
    sentence = sentence:gsub("%s*%.$", "।")

    return sentence
end

return mods
