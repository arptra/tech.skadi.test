local mods = {}

function mods.apply_language_specific_mods(sentence)
    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    return distance .. ' ' .. variables[distance_unit]
end

return mods
