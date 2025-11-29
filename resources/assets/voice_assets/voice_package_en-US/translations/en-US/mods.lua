local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    if _G['imperative_mode'] == nil then
        -- use 'double oh' if the middle 2 digits are zero of a 4 digit number following a capital letter
        modified_sentence = string.gsub( modified_sentence, "([A-Z]%d)00(%d)", "%1 double oh %2" )
        -- pronounce 0 in 2nd position of a 4 digit number following a capital letter as 'Oh'
        modified_sentence = string.gsub( modified_sentence, "([A-Z]%d)0(%d)(%d)", "%1 oh %2 %3" )
        -- pronounce 0 in 3rd position of a 4 digit number following a capital letter as 'Oh',
        -- knowing that a 3 digit number with 0 in the middle is pronounced correctly in address mode
        modified_sentence = string.gsub( modified_sentence, "([A-Z]%d)(%d)0(%d)", "%1 %2 oh %3" )
        -- spell capital letter followed by 3 digits (not zero)
        modified_sentence = string.gsub( modified_sentence, "([A-Z]%d)([1-9])([1-9])", "%1 %2 %3" )
        -- spell capital letter followed by 4 digits if the last digit is non zero
        modified_sentence = string.gsub( modified_sentence, "([A-Z]%d)(%d)(%d)([1-9])", "%1 %2 %3 %4" )
    end

    return modified_sentence
end

return mods
