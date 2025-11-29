local common = require 'content.extract.common.init'
local attributes = require 'content.extract.instruction.attributes'
local prompt = require 'prompt.init'

local instruction = {}

instruction.attributes = attributes

function instruction.extract_common_instruction_content(input_table, with_direction)
    local message_content = common.extract_common_content(input_table)
    local input_maneuver = input_table.maneuver

    if input_table.maneuver.country_code ~= nil then
        message_content.country_code = string.lower(input_table.maneuver.country_code)
    end

    message_content.instruction_class = attributes.get_instruction_class(input_maneuver.id,
                                                                         input_maneuver.road_class,
                                                                         input_maneuver.next_road_class)

    message_content.road_class = attributes.get_road_class(input_maneuver.road_class)
    if input_maneuver.next_road_class ~= nil then
        message_content.next_road_class = attributes.get_road_class(input_maneuver.next_road_class)
    else
        message_content.next_road_class = nil
    end

    message_content.distance = attributes.get_distance(input_maneuver.dist_to,
                                                       input_maneuver.dist_unit,
                                                       input_maneuver.dist_to_unit)
    message_content.natural_guidance = attributes.get_natural_guidance(input_maneuver.natural_guidance)

    if with_direction == true then
        local input_maneuver = input_table.maneuver
        message_content.street = attributes.get_direction_element(input_maneuver.next_street,
                                                                  input_maneuver.next_street_phoneme_nt_sampa,
                                                                  input_maneuver.next_street_phoneme_nt_sampa_lang)
        message_content.route = attributes.get_direction_element(input_maneuver.next_route,
                                                                 input_maneuver.next_route_phoneme_nt_sampa,
                                                                 input_maneuver.next_route_phoneme_nt_sampa_lang)
        local signpost = attributes.get_direction_element(input_maneuver.signpost_direction,
                                                                    input_maneuver.signpost_direction_phoneme_nt_sampa,
                                                                    input_maneuver.signpost_direction_phoneme_nt_sampa_lang)
        local street_name
        local signpost_name
        if message_content.street ~= nil and signpost ~= nil then
            street_name = prompt._expand_abbreviation(message_content.street.name, message_content.street.orthographic_language)
            signpost_name = prompt._expand_abbreviation(signpost.name, signpost.orthographic_language)
        end
        if signpost ~= nil and (message_content.street == nil or signpost_name ~= street_name)
            and (message_content.route == nil or signpost.name ~= message_content.route.name) then
            message_content.signpost = signpost
        end
    end

    return message_content
end


function instruction.extract_arrival(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, false)
    local input_maneuver = input_table.maneuver
    message_content.arrival_class = attributes.get_arrival_class(input_maneuver.id)
    message_content.side_of_road = attributes.get_side_of_road(input_maneuver.side_of_destination)
    return message_content
end


function instruction.extract_head(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    return message_content
end


function instruction.extract_uturn(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, false)
    return message_content
end


function instruction.extract_ferry(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    return message_content
end


function instruction.extract_exit_roundabout(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    return message_content
end


function instruction.extract_roundabout(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    local input_maneuver = input_table.maneuver
    message_content.roundabout_exit_number = attributes.get_roundabout_exit_number(input_maneuver.roundabout_exit_number)
    return message_content
end


function instruction.extract_enter_highway(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    local input_maneuver = input_table.maneuver
    message_content.turn = attributes.get_turn(input_maneuver.turn)
    message_content.highway_category = attributes.get_highway_category(input_table.maneuver.id)
    message_content.lane_information = attributes.get_lane_information(input_maneuver.lane_information)
    return message_content
end


function instruction.extract_junction(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    local input_maneuver = input_table.maneuver
    if input_maneuver.ng_name_phoneme_nt_sampa and input_maneuver.ng_name_phoneme_nt_sampa_lang then
        input_maneuver.ng_name_p_nt_sampa = {}
        input_maneuver.ng_name_p_nt_sampa[string.lower(input_maneuver.ng_name_phoneme_nt_sampa_lang)] = input_maneuver.ng_name_phoneme_nt_sampa
    end
    message_content.turn = attributes.get_turn(input_maneuver.turn)
    message_content.breaks_before_turn = attributes.get_breaks_before_turn(input_maneuver.turn,
                                                                           input_maneuver.left_break,
                                                                           input_maneuver.right_break)
    message_content.lane_information = attributes.get_lane_information(input_maneuver.lane_information)
    return message_content
end


function instruction.extract_highway_turn(input_table)
    local message_content = instruction.extract_common_instruction_content(input_table, true)
    local input_maneuver = input_table.maneuver
    message_content.current_route = attributes.get_direction_element(input_maneuver.route,
                                                                     input_maneuver.route_phoneme_nt_sampa,
                                                                     input_maneuver.route_phoneme_nt_sampa_lang)
    message_content.turn = attributes.get_turn(input_maneuver.turn)
    message_content.leaving_highway = attributes.get_leaving_highway(input_maneuver.id)
    message_content.exit_name = attributes.get_direction_element(input_maneuver.exit_name,
                                                                 input_maneuver.exit_name_phoneme_nt_sampa,
                                                                 input_maneuver.exit_name_phoneme_nt_sampa_lang)
    message_content.lane_information = attributes.get_lane_information(input_maneuver.lane_information)
    return message_content
end


return instruction
