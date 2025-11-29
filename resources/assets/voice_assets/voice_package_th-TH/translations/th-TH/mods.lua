local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub('%s*%.+$', '')

    return sentence
end

return mods
