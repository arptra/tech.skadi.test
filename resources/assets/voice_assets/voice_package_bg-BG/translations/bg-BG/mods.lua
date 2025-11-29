local mods = require('translations.mods')

function mods.get_distance_phrase(distance, distance_unit, variables)
    local distance_ones = math.floor(distance % 10)
    local distance_tens = math.floor(distance % 100 - distance_ones)
    local number_word = variables['nav.variable.DISTANCE.' .. distance_ones .. string.gsub(distance_unit, '.*(%.%a+)$', '%1')]

    if number_word and distance_tens ~= 10 then
        -- Nuance uses wrong gender of "one" and "two" for used "distance_unit". Below condition checks if gender has to
        -- be changed (except tens). Remove it, when Nuance vendor corrects it.
        distance = string.gsub(math.floor(distance-distance_ones) .. ' и ', '^0 и ', '') .. number_word
    elseif distance_ones == 0 and distance_tens == 50 then
        -- Nuance pronounces wrongly numbers, it does not use "and" before last non-zero register (digit), except of ones.
        -- Below condition fixes it for numbers which are multiplication of 50 (such numbers are passed to voice_packages).
        -- Remove it, when Nuance vendor corrects it.
        distance = string.gsub(math.floor(distance-distance_tens) .. ' и ', '^0 и ', '') .. distance_tens
    end

    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'След 0,5 мил')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("се на {ORIENTATION} ", "")

    return sentence
end

return mods
