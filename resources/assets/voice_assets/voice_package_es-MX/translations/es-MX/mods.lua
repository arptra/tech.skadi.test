local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    -- add a space between leading letter and digits of a highway number
    -- also, in order to avoid extension from "L-3" into "Local-3", "N-23" into "Numero23", "S10" into "Sur10", etc
    modified_sentence = string.gsub( modified_sentence, "([A-Z])(%d+)", "%1 %2" )

    -- don't pronounce B as "be grande" when followed by digits - this is a rule specific for Latin American Spanish
    modified_sentence = string.gsub( modified_sentence, "B(%s*)(%d+)", "Be %2" )

    modified_sentence = string.gsub( modified_sentence, "al {ORIENTATION} ", "" )

    return modified_sentence
end

return mods
