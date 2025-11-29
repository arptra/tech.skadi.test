local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    print('SENTENCE: '..sentence)
    sentence = sentence:gsub('%. mål ', '. Målet ')
    sentence = sentence:gsub('^nu (.+) %(nu%)', '%1 nu')
    sentence = sentence:gsub('mod {ORIENTATION} ', '')

    if sentence:find(',') == false then
        sentence = sentence:gsub('$nu%s(.+)%.$', '%1 nu.')
    else
        sentence = sentence:gsub('$nu foretag ', 'foretag nu ')
        sentence = sentence:gsub('$nu tag ', 'tag nu ')
        sentence = sentence:gsub('$nu kør ', 'kør nu ')
    end
    
    sentence = sentence:gsub('%(nu%)', '')

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'After 0,5 miles')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
