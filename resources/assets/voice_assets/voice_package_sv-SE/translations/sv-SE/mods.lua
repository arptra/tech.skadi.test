local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    -- for waypoint "it" should be "den", therefore replace "Det" with "Den"
    sentence = sentence:gsub("vägpunkten. Det", "vägpunkten. Den")

    sentence = sentence:gsub("kör efter (.*) och kör i (.*) {DIRECTION} {SECOND}", "kör i %2 efter %1")
    sentence = sentence:gsub("kör efter (.*) och (.*) {DIRECTION} {SECOND}", "%2 efter %1")
    sentence = sentence:gsub("kör efter", "kör")
    sentence = sentence:gsub("kör {INTERVAL},%s+", "")
    sentence = sentence:gsub("kör {INTERVAL} och", "")
    sentence = sentence:gsub("kör nu och ([^%s]+) %(nu%)", "%1 nu")
    sentence = sentence:gsub("och (.+) och", ", %1 och")
    sentence = sentence:gsub("%(nu%)", "")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Efter 0,5 engelska mil')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
