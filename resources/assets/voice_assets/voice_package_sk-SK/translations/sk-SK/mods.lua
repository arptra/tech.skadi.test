local mods = require('translations.mods')

local function adjust_unit_case(first_part, second_part, matched_word)
    if (matched_word == "metrov" or matched_word == "metre") then
        return first_part..second_part.."metroch"
    elseif (matched_word == "meter") then
        return first_part..second_part.."metri"
    elseif (matched_word == "kilometrov" or matched_word == "kilometre") then
        return first_part..second_part.."kilometroch"
    elseif (matched_word == "kilometer") then
        return first_part..second_part.."kilometri"
    elseif (matched_word == "stôp" or matched_word == "st" or matched_word == "stopy") then
        return first_part..second_part.."stopách"
    elseif (matched_word == "míľ" or matched_word == "míle") then
        if (second_part == "štvrť " or second_part == "pol ") then
            return first_part..second_part.."míli"
        else
            return first_part..second_part.."míľach"
        end
    elseif (matched_word == "míľu") then
        return first_part..second_part.."míli"
    elseif (matched_word == "yardov" or matched_word == "yardy") then
        return first_part..second_part.."yardoch"
    else
        return first_part..second_part..matched_word
    end
end

function mods.apply_language_specific_mods(sentence)
    sentence = sentence:gsub("^teraz%s*[a]*%s*potom%s", "teraz ")
    sentence = sentence:gsub(", {[NEXT_]*LANDMARK},", "")
    sentence = sentence:gsub("^[{INTERVAL}]*%s*[a]*%s*potom%s", "")
    sentence = sentence:gsub(" a potom (.+) potom", " %1 potom")
    sentence = sentence:gsub("potom (.+) potom", "%1 potom")
    sentence = sentence:gsub("(pokračujte po diaľnicu)", "pokračujte po diaľnici")
    sentence = sentence:gsub("(pokračujte po mestskú diaľnicu)", "pokračujte po mestskej diaľnici")
    sentence = sentence:gsub("(po tri štvrtiny míle)", "po tri štvrtiny míli")
    sentence = sentence:gsub("(po jeden a pol míle)", "po jeden a pol míli")
    sentence = sentence:gsub("(po )([^%s]+)( a pol míle)", "%1%2 a pol míľach")
    sentence = sentence:gsub("(,%s*[{LANDMARK}]*%s+sa držte)", ", držte sa")
    sentence = sentence:gsub("(,%s*[{LANDMARK}]*%s+sa otočte)", ", otočte sa")
    sentence = sentence:gsub("na {ORIENTATION} ", "")
    local new_sentence = sentence:gsub("(po )([^%s]+ )([^%s|%p]+)", adjust_unit_case)
    if (new_sentence ~= nil) then
        return new_sentence
    else
        return sentence
    end
end

local function is_uptofour(d, _, _)
    return (d > 1 and d < 5)
end

local numeral_rules = {
    [1] = { is_applicable = is_uptofour, applicate = function(d, u, _) return d, u..'.uptofour' end},
}

function mods.get_distance_phrase(distance, distance_unit, variables)
    local d = tonumber(distance)
    local u = distance_unit
    local v = variables

    for _,rule in ipairs(numeral_rules) do
        if rule.is_applicable(d, u, v) then
            d, u = rule.applicate(d, u, v)
            break
        end
    end
    distance = string.gsub(d, '(%d+)%.(%d+)', '%1,%2')
    return distance .. ' ' .. v[u]
end

return mods
