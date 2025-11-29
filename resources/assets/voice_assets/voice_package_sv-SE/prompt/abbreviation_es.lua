local utils = require 'content.utils'


local abbreviation  = {}


-- abbreviations which are at the end of street names
abbreviation._last_word_abbr = {}


function abbreviation._has_cardinal(words)
    local cardinals = { 'N', 'S', 'E', 'O', 'NE', 'NO', 'SE', 'SO', 'Norte', 'Sur', 'Este', 'Oeste', 'Noreste', 'Noroeste', 'Sureste', 'Suroeste' }
    -- check if the last word is a cardinal direction
    return utils.contains(cardinals, words[#words][1], false)
end


function abbreviation._process_all_words_rules(word)
    local modified_word = word
    modified_word = abbreviation._process_cardinal_rules(modified_word)
    return modified_word
end


function abbreviation._process_cardinal_rules(word)
    -- compass directions
    local modified_word = word
    modified_word, _ = utils.replace(modified_word, 'N%-?E', 'Noreste')
    modified_word, _ = utils.replace(modified_word, 'N%-?O', 'Noroeste')
    modified_word, _ = utils.replace(modified_word, 'S%-?E', 'Sureste')
    modified_word, _ = utils.replace(modified_word, 'S%-?O', 'Suroeste')
    modified_word, _ = utils.replace(modified_word, 'N', 'Norte')
    modified_word, _ = utils.replace(modified_word, 'S', 'Sur')
    modified_word, _ = utils.replace(modified_word, 'E', 'Este')
    modified_word, _ = utils.replace(modified_word, 'O', 'Oeste')
    return modified_word
end


function abbreviation.expand_abbreviation(phrase)
    local words = utils.split_phrase(phrase)
    for i = 1, #words do
        local word = words[i][1]
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

    -- expand abbreviation "Unit. Hab." to "Unidad Habitacional"
    expanded_phrase = string.gsub( expanded_phrase, "[Uu]nid%.?%s+[Hh]ab%.?", "Unidad Habitacional" )

    return expanded_phrase
end


return abbreviation
