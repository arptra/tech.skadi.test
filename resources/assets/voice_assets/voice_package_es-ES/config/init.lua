local config = {}

function config.get_selection_rules(rules, voice_settings)
    local selection_rules = {}
    selection_rules.suppressing_threshold = rules.suppressing_threshold
    selection_rules.direction_information_limit = rules.direction_information_limit
    selection_rules.use_lane_information = rules.use_lane_information
    selection_rules.lane_information_limit = rules.lane_information_limit
    selection_rules.lane_count_limit = rules.lane_count_limit
    selection_rules.filter_direction_information = rules.filter_direction_information
    selection_rules.filter_highway_exit_information = rules.filter_highway_exit_information
    selection_rules.enter_highway_turn_information = rules.enter_highway_turn_information
    selection_rules.use_exit_roundabout = rules.use_exit_roundabout
    selection_rules.use_continue_purpose = rules.use_continue_purpose
    selection_rules.use_exit_purpose = rules.use_exit_purpose
    selection_rules.arrival_information = rules.arrival_information
    selection_rules.close_distance_limit = rules.close_distance_limit
    selection_rules.use_natural_guidance_with_trigger = rules.use_natural_guidance_with_trigger
    selection_rules.use_natural_guidance_with_direction = rules.use_natural_guidance_with_direction
    selection_rules.use_natural_guidance_with_lane_information = rules.use_natural_guidance_with_lane_information
    selection_rules.use_distance_with_natural_guidance = rules.use_distance_with_natural_guidance
    selection_rules.natural_guidance_importance_threshold = rules.natural_guidance_importance_threshold
    selection_rules.natural_guidance_count_limit = rules.natural_guidance_count_limit
    selection_rules.natural_guidance_distance_limit = rules.natural_guidance_distance_limit
    selection_rules.natural_guidance_distance_to_first_element_threshold = rules.natural_guidance_distance_to_first_element_threshold
    selection_rules.natural_guidance_elements_priority_order = config._configure_natural_guidance_elements_priority_order(rules.natural_guidance_elements_priority_order,
                                                                                                                          { traffic_light = voice_settings.nguidance_trafficlights,
                                                                                                                            stop_sign = voice_settings.nguidance_stop_sign,
                                                                                                                            t_junction = voice_settings.nguidance_t_junction })
    selection_rules.ignore_warning = rules.ignore_warning
    return selection_rules
end

function config._configure_natural_guidance_elements_priority_order(elements_priority_order, elements_voice_settings)
    local order = {}
    for _, element in ipairs(elements_priority_order.Setting) do
        if elements_voice_settings[element] == 'false'  then element = nil end
        table.insert(order, element)
    end
    elements_priority_order.Setting = order
    return elements_priority_order
end

return config
