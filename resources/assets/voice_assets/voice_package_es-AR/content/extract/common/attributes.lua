local attributes = {}


function attributes.get_trigger (trigger)
    return string.lower(trigger)
end


function attributes.get_vp_marc_lang_code (input)
    return string.lower(input.marc_code)
end


function attributes.get_vp_supported_lang_code (input)
    local supported_lang_code = input.main_attribute_array["language_code"]
    if string.len(supported_lang_code) >= 2 then
        supported_lang_code = string.sub(supported_lang_code,1,2)
    end
    return string.lower(supported_lang_code)
end


function attributes.get_trigger_class (input)
    local trigger = input.trigger
    if trigger == 'SAFETY_CAMERA' then return 'warning'
    elseif trigger == 'ROUTE_RECALCULATION' then return 'warning'
    elseif trigger == 'GPS_SIGNAL_LOST' then return 'warning'
    elseif trigger == 'GPS_SIGNAL_RESTORED' then return 'warning'
    elseif trigger == 'RANGE' then return 'instruction'
    elseif trigger == 'REMINDER' then return 'instruction'
    elseif trigger == 'DISTANCE' then return 'instruction'
    elseif trigger == 'ACTION' then return 'instruction'
    elseif trigger == 'IMPERATIVE' then return 'instruction'
    end
end


return attributes
