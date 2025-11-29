local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    -- handle dot as "," (e.g.: 'Setelah 0.5 mil' becomes 'Setelah 0,5 mil')
    return string.gsub( sentence, "(setelah%s%d+)%.(%d+%s)", "%1,%2" )
end

return mods
