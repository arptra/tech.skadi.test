local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub('na međutočka', 'do međutočke')  --adapt waypoint

    --replace first  "keep {side}" in the phrase like 'Now keep right and then keep right towards...'
    local expr = 'sada držite se %a+ trake i onda%s+držite'
    local i,j = sentence:find(expr)
    if j then
        local substr = sentence:sub(i,j)
        --replace "keep"
        substr = substr:gsub('držite se', 'budite u')
        local sides = {['desne trake'] = 'desnoj traci', ['lijeve trake'] = 'lijevoj traci', ['sredne trake'] = 'srednjoj traci'}
        for  key, value in pairs(sides) do
            substr = substr:gsub(key, value)
        end
        --add the tail of TTS string
        sentence = substr..sentence:sub(j+1)
    end

    -- reverse "držite se"
    sentence = sentence:gsub('(sada) (držite) (se)', '%1 %3 %2')
    sentence = sentence:gsub('(odmah) (držite) (se)', '%1 %3 %2')
    sentence = sentence:gsub('(odmah) (polukružno) (se)', '%1 %3 %2')
    sentence = sentence:gsub('%(na izlazu%) %{[NEXT_]*DIRECTION%}', 'na izlazu')
    sentence = sentence:gsub('%(na izlazu%)', '')

    sentence = sentence:gsub("na {ORIENTATION} ", "")

    return sentence
end

function mods.get_distance_phrase(distance, distance_unit, variables)
    -- handle dot as "," (e.g.: '0.5 milja' becomes '0,5 milja')
    distance = string.gsub(distance, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. variables[distance_unit]
end

return mods
