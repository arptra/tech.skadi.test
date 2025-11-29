local common = require 'content.select.common'

local lane_information = {}

function lane_information.use(trigger, lane_recommendation, turn_action, turn_bearing, road_class, distance_in_meters, use_lane_information, lane_information_limit)
    if not _is_lane_information_switched_on(use_lane_information) then return false end
    if not _is_distance_within_lane_information_limit(trigger, road_class, distance_in_meters, lane_information_limit) then return false end
    if not _is_lane_information_relevant_for_turn(lane_recommendation, turn_action, turn_bearing) then return false end
    return true
end


function _is_lane_information_switched_on(use_lane_information)
    local attributes = {}
    return common.get_config_value(use_lane_information, attributes) == true
end


function _is_distance_within_lane_information_limit(trigger, road_class, distance_in_meters, lane_information_limit)
    local attributes = {['trigger'] = trigger, ['road_class'] = road_class}
    local lane_information_threshold = common.get_config_value(lane_information_limit, attributes)
    return lane_information_threshold == nil or distance_in_meters <= lane_information_threshold
end


function _is_lane_information_relevant_for_turn(lane_recommendation, turn_action, turn_bearing)
    if not lane_recommendation or not turn_action or not turn_bearing then return false end
    if lane_recommendation.total <= 1 then return false end
    if lane_recommendation.count < 1 then return false end
    if turn_bearing == 'middle' or turn_bearing == 'straight' then return false end
    if turn_bearing == 'left' and lane_recommendation.left_gap > 0 then return false end
    if turn_bearing == 'right' and lane_recommendation.right_gap > 0 then return false end
    return true
end


function lane_information.is_available(action_content)
    return (action_content ~= nil) and (action_content.turn_information ~= nil) and (action_content.turn_information.lane_phrase_id ~= nil)
end


function lane_information.get_lane_phrase_id(lane_recommendation, turn_bearing, lane_count_limit)
    if not lane_recommendation then return nil end

    local side = _get_lane_side(lane_recommendation, turn_bearing)
    if side == 'any' then return 'nav.variable.LANE.any' end

    local count = lane_recommendation.count
    if (side == 'left' and lane_recommendation.decreasing) then
        count = lane_recommendation.step - 1
    elseif (side == 'right' and lane_recommendation.increasing) then
        count = count - lane_recommendation.step + 1
    end

    if _is_within_lane_count_limit(count, lane_count_limit) then
        return table.concat({'nav.variable.LANE', side, count}, '.')
    else
        return nil
    end
end


function _is_within_lane_count_limit(lane_count, lane_count_limit)
    local attributes = {}
    local count_limit = common.get_config_value(lane_count_limit, attributes)
    return lane_count <= count_limit
end


function lane_information.get_recommended_lanes(lane_information_table)
    if not lane_information_table then return nil end
    local RECOMMENDATION_THRESHOLD = 1
    local length = #lane_information_table
    local sequence_start = _get_leftmost_recommended_lane(lane_information_table, 1, length, RECOMMENDATION_THRESHOLD)
    local recommended_sequence = _get_recommended_sequence(lane_information_table, sequence_start, length, RECOMMENDATION_THRESHOLD)

    local left_gap = sequence_start - 1
    recommended_sequence.left_gap = left_gap
    recommended_sequence.right_gap = length - recommended_sequence.count - left_gap
    recommended_sequence.step = recommended_sequence.step - left_gap
    recommended_sequence.total = length

    local after_sequence = left_gap + recommended_sequence.count + 1
    local next_recommended_lane = _get_leftmost_recommended_lane(lane_information_table, after_sequence, length, RECOMMENDATION_THRESHOLD)
    if next_recommended_lane >= after_sequence and next_recommended_lane <= length then
        return nil
    end

    return recommended_sequence
end


function _get_leftmost_recommended_lane(lane_information_table, start, length, RECOMMENDATION_THRESHOLD)
    local index = start
    while index <= length do
        if lane_information_table[index] >= RECOMMENDATION_THRESHOLD then
            return index
        end
        index = index + 1
    end
    return index
end


function _get_recommended_sequence(lane_information_table, start, length, RECOMMENDATION_THRESHOLD)
    local count = 0
    local increase = false
    local decrease = false
    local step = 0
    local last_recommendation = lane_information_table[start]
    local index = start
    while index <= length and lane_information_table[index] >= RECOMMENDATION_THRESHOLD do
        count = count + 1
        if lane_information_table[index] > last_recommendation then
            increase = true
            step = index
        elseif lane_information_table[index] < last_recommendation then
            decrease = true
            step = index
        end
        last_recommendation = lane_information_table[index]
        index = index + 1
    end

    return {count = count,
            increasing = increase and not decrease,
            decreasing = decrease and not increase,
            step = step}
end


function _get_lane_side(lane_recommendation, turn_bearing)
    if lane_recommendation.count == lane_recommendation.total then
        if turn_bearing == 'left' and not lane_recommendation.decreasing then
            return 'any'
        elseif turn_bearing == 'right' and not lane_recommendation.increasing then
            return 'any'
        end
    end
    return turn_bearing
end

return lane_information
