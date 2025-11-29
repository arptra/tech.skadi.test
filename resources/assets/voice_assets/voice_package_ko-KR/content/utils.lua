local utils = {}


function utils.inside (value, array)
    for _, item in ipairs(array) do
        if value == item then
            return true
        end
    end
    return false
end


function utils.keys (dict)
    local keys = {}
    for key, _ in pairs(dict) do
        table.insert(keys, key)
    end
    return keys
end


function utils.length(table)
    local length = 0
    for _, _ in pairs(table) do length = length + 1 end
    return length
end


function utils.copy_table(table)
    if type(table) ~= 'table' then return nil end
    local copy = {}
    for key, value in pairs(table) do
        if type(value) == 'table' then
            copy[key] = utils.copy_table(value)
        else
            copy[key] = value
        end
    end
    return copy
end


function utils.to_set(array)
    local table = {}
    for _, item in ipairs(array) do
        table[item] = true
    end
    return table
end


function utils.are_same(lhs_set, rhs_set)
    local lhs_keys = utils.keys(lhs_set)
    local rhs_keys = utils.keys(rhs_set)

    if #lhs_keys ~= #rhs_keys then return false end
    for _, item in ipairs(lhs_keys) do
        if not utils.inside(item, rhs_keys) then return false end
    end
    return true
end


function utils.merge_tables(...)
    local result = {}
    for i = 1, select("#", ...) do
        local source = select(i, ...)
        if source then
            for key, value in pairs(source) do
                if result[key] then return nil end
                result[key] = value
            end
        end
    end
    return result
end


function utils.extend(array, ...)
    local length = #array
    for i = 1, select("#", ...) do
        local value = select(i, ...)
        array[length + i] = value
    end
    return array
end


function utils.evaluate_lua_string(expression)
    return (loadstring or load)("return "..expression)() -- For backward compatibility. Remove loadstring when dropping support for lua5.1.
end


function utils.empty(table)
    if next(table) == nil then return true end
    return false
end


function utils._get_parametrized_replacement(placeholder, key, variables)
    local value = string.gsub(placeholder, '[<>]', '')
    value = utils.escape_replacement_string(string.gsub(value, key .. ':', ''))
    return string.gsub(variables['platform_var.' .. key], '<PARAM>', value)
end


function utils.replace(input, search_str, replace_str)
    return string.gsub(input, "^"..search_str.."[%.]?$", replace_str)
end


function utils.contains(table, element, casesensitive)
    for _, value in pairs(table) do
        if casesensitive == true then
            if value == element then
                return true
            end
        else
            if value:lower() == element:lower() then
                return true
            end
        end
    end
    return false
end


function utils.split_phrase(phrase)
    local separators = { ' ', ',', '.', '/' }
    local phrase_components = {}
    local i = 1
    local character = string.sub( phrase, i, i )
    while ( i <= string.len( phrase ) ) do
        local word_table = {}
        local content = ""
        local punctuation = ""
        while ( utils.contains( separators, character, true ) == false ) and ( i <= string.len( phrase ) ) do
            content = content..character
            i = i + 1
            character = string.sub( phrase, i, i )
        end
        while ( utils.contains( separators, character, true ) == true ) and ( i <= string.len( phrase ) ) do
            punctuation = punctuation..character
            i = i + 1
            character = string.sub( phrase, i, i )
        end
        table.insert( word_table, content )
        table.insert( word_table, punctuation )
        table.insert( phrase_components, word_table )
    end
    return phrase_components
end


function utils.reconstruct_phrase(phrase_components)
    local phrase = ""
    for i = 1, #phrase_components do
        phrase = phrase .. phrase_components[i][1] .. phrase_components[i][2]
    end
    return phrase
end


function utils.reverse(input_table)
    local result = {}
    if not input_table or #input_table == 0 then return result end
    local num_of_items = #input_table
    for index, value in ipairs(input_table) do
        result[num_of_items + 1 - index] = value
    end
    return result
end


function utils.escape_pattern_string(pattern)
    if type(pattern) ~= 'string' then return pattern end -- Korean road names  are just numbers
    -- The magic characters are:  ( ) . % + - * ? [ ^ $
    -- http://www.lua.org/pil/20.2.html
    local magic_character_set = '(['
        .. '%('
        .. '%)'
        .. '%.'
        .. '%%'
        .. '%+'
        .. '%-'
        .. '%*'
        .. '%?'
        .. '%['
        .. '%^'
        .. '%$'
        .. '])'
    return string.gsub(pattern, magic_character_set, '%%%1')
end

function utils.escape_replacement_string(pattern)
    if type(pattern) ~= 'string' then return pattern end -- Korean road names  are just numbers
    return string.gsub(pattern, '%%', '%%%%')
end

return utils
