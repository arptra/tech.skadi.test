local mods = require('translations.mods')

function mods.apply_language_specific_mods(original_sentence)
    local sentence_to_modify = "Ο %s σας θα βρίσκεται"
    local destination = "προορισμό"
    local waypoint = "ενδιάμεσο σταθμό"

    original_sentence = original_sentence:gsub("στην οδό (.+)λατεία(.+)", "στην %1λατεία%2")
    original_sentence = original_sentence:gsub("στην οδό (.+)εωφόρο(.+)", "στη %1εωφόρο%2")

    local result = original_sentence

    local nouns = { [destination] = "προορισμός",
                    [waypoint] = "ενδιάμεσος σταθμός" }

    for accusative, nominative in pairs(nouns) do
        result = string.gsub( original_sentence,
                              string.format(sentence_to_modify, accusative),
                              string.format(sentence_to_modify, nominative) )
        if result ~= original_sentence then
            return result
        end
    end

    return result
end


function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Μετά από 0,5 μίλια')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
