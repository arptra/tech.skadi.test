local attributes = {}

local utils = require 'content.utils'
local constants = require 'prompt.constants'


function attributes.get_instruction_class(maneuver_id, road_class, next_road_class)
    if maneuver_id == 'JUNCTION' then
        if road_class:find('HIGHWAY')
           and next_road_class ~= nil
           and next_road_class:find('HIGHWAY') then return 'highway_turn'
        else return 'junction' end
    elseif maneuver_id == 'END' or
           maneuver_id == 'STOPOVER' then return 'arrival'
    elseif maneuver_id == 'HEAD_TO' then return 'head'
    elseif maneuver_id == 'UTURN' then return 'uturn'
    elseif maneuver_id == 'FERRY' then return 'ferry'
    elseif maneuver_id == 'ROUNDABOUT' or
           maneuver_id == 'ENTER_ROUNDABOUT' then return 'roundabout'
    elseif maneuver_id == 'EXIT_ROUNDABOUT' then return 'exit_roundabout'
    elseif maneuver_id == 'ENTER_HIGHWAY' or
           maneuver_id == 'ENTER_URBAN_HIGHWAY' or
           maneuver_id == 'ENTER_HIGHWAY_RIGHT' or
           maneuver_id == 'ENTER_HIGHWAY_LEFT' then return 'enter_highway'
    elseif maneuver_id == 'CONTINUE_HIGHWAY' or
           maneuver_id == 'CONTINUE_URBAN_HIGHWAY' then return 'highway_turn'
    elseif maneuver_id == 'LEAVE_HIGHWAY' or
           maneuver_id == 'LEAVE_URBAN_HIGHWAY' then return 'highway_turn'
    end
end


function attributes.get_distance(dist_to, dist_unit, dist_to_unit)
    local distance = {}
    distance.value_in_meters = dist_to
    if dist_unit then distance.unit = string.lower(dist_unit) end
    distance.value_in_unit = dist_to_unit
    return distance
end


function attributes.get_road_class(road_class)
    -- map RURAL and URBAN road types to STREET road type
    if road_class == 'RURAL' or
       road_class == 'URBAN' then
        road_class = 'STREET'
    end

    if road_class == 'STREET' or
       road_class == 'HIGHWAY' or
       road_class == 'URBAN_HIGHWAY' then
        return string.lower(road_class)
    end
end


function attributes.get_arrival_class(maneuver_id)
    if maneuver_id == 'END' or
       maneuver_id == 'STOPOVER' then
        return string.lower(maneuver_id)
    end
end


function attributes.get_side_of_road(side_of_destination)
    if side_of_destination == 'LEFT' or
       side_of_destination == 'RIGHT'or
       side_of_destination == 'FRONT' then
        return string.lower(side_of_destination)
    end
end


function attributes.get_natural_guidance(natural_guidance)
    if not natural_guidance then return nil end
    local natural_guidance_table = {}
    natural_guidance_table['traffic_light'] = utils.copy_table(natural_guidance['traffic_light'])
    natural_guidance_table['stop_sign'] = utils.copy_table(natural_guidance['stop_sign'])
    natural_guidance_table['t_junction'] = utils.copy_table(natural_guidance['t-junction'])    -- change from '-' to '_' is intentional, all lua variables use underscores
    if utils.length(natural_guidance_table) > 0 then
        return natural_guidance_table
    end
end


function attributes.get_direction_element(elements,
                                          phoneme_nt_sampa,
                                          phoneme_nt_sampa_lang)
    if elements == nil then return nil end
    if utils.length(elements) == 0 then return nil end

    local element_table = {}
    element_table.name = elements[1].text
    element_table.phonetic_form = phoneme_nt_sampa
    element_table.phonetic_language = phoneme_nt_sampa_lang
    if elements[1].language_code ~= nil then
        element_table.orthographic_language = elements[1].language_code
    end
    return element_table
end

function attributes.get_roundabout_exit_number(extra_integer)
    if extra_integer ~= nil and extra_integer > 0 then
        return extra_integer
    end
end


function attributes.get_turn(turn)
    if utils.inside(turn, {'KEEP_RIGHT', 'LIGHT_RIGHT', 'QUITE_RIGHT', 'HEAVY_RIGHT',
                           'KEEP_LEFT', 'LIGHT_LEFT', 'QUITE_LEFT', 'HEAVY_LEFT',
                           'KEEP_MIDDLE', 'RETURN', 'NO_TURN', 'UNDEFINED'}) then
        return string.lower(turn)
    end
end


function attributes.get_highway_category(maneuver_id)
    if utils.inside(maneuver_id, {'ENTER_HIGHWAY', 'ENTER_HIGHWAY_RIGHT', 'ENTER_HIGHWAY_LEFT'}) then
        return 'regular'
    elseif maneuver_id == 'ENTER_URBAN_HIGHWAY' then
        return 'urban'
    end
end


function attributes.get_breaks_before_turn(turn, breaks_count_left, breaks_count_right)
    if utils.inside(turn, {'KEEP_RIGHT', 'LIGHT_RIGHT', 'QUITE_RIGHT', 'HEAVY_RIGHT'}) and
       breaks_count_right ~= nil and
       breaks_count_right > 0 then
        return breaks_count_right
    end
    if utils.inside(turn, {'KEEP_LEFT', 'LIGHT_LEFT', 'QUITE_LEFT', 'HEAVY_LEFT'}) and
       breaks_count_left ~= nil and
       breaks_count_left > 0 then
        return breaks_count_left
    end
end


function attributes.get_leaving_highway(maneuver_id)
    if maneuver_id == 'LEAVE_HIGHWAY' or maneuver_id == 'LEAVE_URBAN_HIGHWAY' then
        return true
    end
    if maneuver_id == 'JUNCTION' or maneuver_id == 'CONTINUE_HIGHWAY' or maneuver_id == 'CONTINUE_URBAN_HIGHWAY' then
        return false
    end
end


function attributes.get_lane_information(lane_information_table)
    if not lane_information_table then return nil end
    for _, value in ipairs(lane_information_table) do
        if value < -1 or value > 2 then return nil end
    end
    return lane_information_table
end

return attributes
