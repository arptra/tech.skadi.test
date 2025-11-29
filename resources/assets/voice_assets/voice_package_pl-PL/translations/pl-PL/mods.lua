local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    local modified_sentence = sentence

    -- handle dot as "," (e.g.: 'After 0.5 miles' becomes 'Za 0,5 mili')
    modified_sentence = string.gsub( modified_sentence, "(za%s%d+)%.(%d+%s)", "%1,%2" )

    -- remove repetitive orthographic word of 'ulica' in the directional phrase
    modified_sentence = string.gsub( modified_sentence, "ulica", "" )

    modified_sentence = string.gsub( modified_sentence, "na {ORIENTATION} ", "" )

    return modified_sentence
end

local function spread_number(d)
    local distance_integral = math.floor(d)
    local distance_ones = distance_integral % 10
    local distance_tens = distance_integral % 100 - distance_ones

    return distance_ones,distance_tens
end

local function is_fractional(d, _, _)
    return d % 1 ~= 0
end

local function is_one(d, _, _)
    return d == 1
end

local function needs_female_two(d, u, v)
    local distance_ones,distance_tens = spread_number(d)
    return v[string.gsub(u, 'UNIT', 'DISTANCE') .. '.female_two'] and distance_tens ~= 10 and distance_ones == 2
end

local function needs_genitive(d, _, _)
    local distance_ones,distance_tens = spread_number(d)
    return distance_tens == 10 or distance_ones <= 1 or distance_ones >= 5
end

local function get_female_two(d, _, _)
    return string.gsub(math.floor(d-2) .. ' ', '^0 ', '') .. 'dwie'
end

local numeral_rules = {
    [1] = { is_applicable = is_fractional,    applicate = function(d,u,_) return d,u..'.fractional' end},
    [2] = { is_applicable = is_one,           applicate = function(_,u,v) u=u..'.singular'; return v[string.gsub(u, 'UNIT', 'DISTANCE')],u end},
    [3] = { is_applicable = needs_female_two, applicate = function(d,u,_) return get_female_two(d),u end},
    [4] = { is_applicable = needs_genitive,   applicate = function(d,u,_) return d,u..'.genitive' end},
}

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = distance_unit
    local v = variables

    for _,rule in ipairs(numeral_rules) do
        if rule.is_applicable(d, u, v) then
            d,u = rule.applicate(d, u, v)
            break
        end
    end

    return d .. ' ' .. v[u]
end

return mods
