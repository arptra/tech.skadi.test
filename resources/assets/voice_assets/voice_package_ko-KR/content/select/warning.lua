local warning = {}


function warning.select_common_content()
    local content = {}
    content.prompt_class = 'notification'
    return content
end


function warning.select_warning(trigger)
    local content = warning.select_common_content()
    if trigger == 'gps_signal_lost' then content.action = 'gpslost'
    elseif trigger == 'gps_signal_restored' then content.action = 'gpsrestored'
    elseif trigger == 'route_recalculation' then content.action = 'newroute'
    elseif trigger == 'safety_camera' then  content.action = 'speedcamera'
    end
    return content
end


return warning
