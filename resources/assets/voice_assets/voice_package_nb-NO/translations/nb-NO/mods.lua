local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("^nå (%.+),", "%1 nå,")
    sentence = sentence:gsub("^nå (%.+)%.$", "%1 nå.")

    -- add så (then) to turn and keep commands after og (and) keyword
    -- e.g. "and then turn left" becomes "og sving så til venstre"
    sentence = sentence:gsub("og sving til", "og sving så til")
    sentence = sentence:gsub("og hold til", "og hold så til")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Etter 0,5 miles')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
