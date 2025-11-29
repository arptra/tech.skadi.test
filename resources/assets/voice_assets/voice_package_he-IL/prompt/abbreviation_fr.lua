local utils = require 'content.utils'


local abbreviation  = {}


-- abbreviations which are at the end of street names
abbreviation._last_word_abbr = {}


function abbreviation._has_cardinal(words)
    local cardinals = { 'N', 'S', 'E', 'O', 'NE', 'NO', 'SE', 'SO', 'Nord', 'Sud', 'Est', 'Ouest', 'Nord-est', 'Nord-ouest', 'Sud-est', 'Sud-ouest' }
    -- check if the last word is a cardinal direction
    return utils.contains(cardinals, words[#words][1], false)
end


function abbreviation._process_all_except_last_words_rules(word)
    local modified_word = word
    modified_word, _ = utils.replace(modified_word, '[Ss][Tt]', 'Saint')
    modified_word, _ = utils.replace(modified_word, '[Ss][Tt][Ee]', 'Sainte')
    return modified_word
end


function abbreviation._process_all_words_rules(word)
    local modified_word = word
    modified_word = abbreviation._process_cardinal_rules(modified_word)
    return modified_word
end


function abbreviation._process_cardinal_rules(word)
    -- compass directions
    local modified_word = word
    modified_word, _ = utils.replace(modified_word, 'N%-?E', 'Nord-est')
    modified_word, _ = utils.replace(modified_word, 'N%-?O', 'Nord-ouest')
    modified_word, _ = utils.replace(modified_word, 'S%-?E', 'Sud-est')
    modified_word, _ = utils.replace(modified_word, 'S%-?O', 'Sud-ouest')
    modified_word, _ = utils.replace(modified_word, 'N', 'Nord')
    modified_word, _ = utils.replace(modified_word, 'S', 'Sud')
    modified_word, _ = utils.replace(modified_word, 'E', 'Est')
    modified_word, _ = utils.replace(modified_word, 'O', 'Ouest')
    return modified_word
end


function abbreviation.expand_abbreviation(phrase)
    local words = utils.split_phrase(phrase)
    local has_cardinal = abbreviation._has_cardinal(words)
    for i = 1, #words do
        local word = words[i][1]
        -- process all except last word rules
        if ((has_cardinal == false and i < #words)
            or (has_cardinal == true and i < #words - 1))
            and not words[i][2]:find('/') then
            word = abbreviation._process_all_except_last_words_rules(word)
        end

        -- process last word rules
        if ((has_cardinal == false and i == #words)
            or (has_cardinal == true and i == #words - 1)
            or words[i][2]:find('/')) then
            for abbr,expansion in pairs(abbreviation._last_word_abbr) do
                word, _ = utils.replace(word, abbr, expansion)
            end
        end

        -- process all word rules
        word = abbreviation._process_all_words_rules(word)

        -- eliminate the dot if the abbreviation was expanded
        if ( word ~= words[i][1] ) then
            words[i][2] = utils.replace(words[i][2], '(%s*)%.(%s*)', ' ')
        end
        words[i][1] = word
    end

    -- re-construct the phrase based on the components
    local expanded_phrase = utils.reconstruct_phrase(words)

    return expanded_phrase
end


return abbreviation
