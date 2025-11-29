local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    ---change phrase containing waypoint (articles and change 'he' to 'she', because it is feminine
    sentence = sentence:gsub('נקודת הציון יהיה', 'נקודת הציון תהיה')
    sentence = sentence:gsub('הגעת אל נקודת הציון. הוא ', 'הגעת אל נקודת הציון. היא ')
    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- place distance unit (e.g km) before distance value for case of dist == 1
    if tonumber(distance) == 1 then
        return variables[distance_unit] .. ' ' .. distance
    else
        return distance .. ' ' .. variables[distance_unit]
    end
end

return mods
