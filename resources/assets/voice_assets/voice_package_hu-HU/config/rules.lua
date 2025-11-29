local rules = {}


rules.ignore_warning = { Attribute = 'trigger_class',
                         Values = { ['safety_camera_warning'] = { Attribute = 'use_speed_camera',
                                                                  Values = { ['false'] = { Setting = true },
                                                                             ['*'] = { Setting= false }
                                                                           }
                                                                },
                                    ['simple_warning'] = { Attribute = 'trigger',
                                                           Values = { ['speed_warner'] = { Attribute = 'use_speed_warner',
                                                                                           Values = { ['false'] = { Setting = true },
                                                                                                      ['*'] = { Setting = false }
                                                                                                    }
                                                                                         }
                                                                    }
                                                         },
                                    ['*'] = { Setting = false }
                                  }
                       }

-- if the distance to maneuver in meters is higher or equal to the threshold, 'follow the road' instruction is used instead of the maneuver
-- if threshold set to nil, 'follow the road' instruction is never used regardless of the distance
-- if threshold set to -1, 'follow the road' instruction is always used, since the distance is always greater than -1
rules.suppressing_threshold = { Attribute = 'distance_flag',
                                 Values = { ['with_distance'] = { Attribute = 'road_class',
                                                                  Values = { ['street'] = { Setting = 3000 }}},
                                            ['without_distance'] = { Setting = 10000 }}}


-- if the distance to maneuver in meters is above the limit, direction is not included in the prompt
-- if limit set to nil, direction is included regardless of the distance
-- if limit set to -1, direction is never included, since the distance is always greater than -1
rules.direction_information_limit = { Attribute = 'trigger',
                                       Values = { ['range'] = { Attribute = 'road_class',
                                                                Values = { ['street'] = { Setting = 500 },
                                                                           ['*'] = { Setting = 650 } }},
                                                      ['*'] = { Setting = nil }}}


-- rules for filtering directions based on the context in which they appear
rules.filter_direction_information = { Attribute = 'instruction_order',
                                       Values = { ['single'] = { Attribute = 'trigger',
                                                                 Values = { ['action'] = { Attribute = 'instruction_class',
                                                                                           Values = { ['exit_roundabout'] = { Attribute = 'direction_info',
                                                                                                                              Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                         ['{route}'] = { Setting = { 'route' } },
                                                                                                                                         ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                         ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                         ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                         ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                         ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                         ['{}'] = { Setting = {} }}},
                                                                                                      ['head'] = { Attribute = 'direction_info',
                                                                                                                    Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                               ['{route}'] = { Setting = { 'route' } },
                                                                                                                               ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                               ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                               ['{street,signpost}'] = { Setting = { 'street' } },
                                                                                                                               ['{route,signpost}'] = { Setting = { 'route' } },
                                                                                                                               ['{street,route,signpost}'] = { Setting = { 'street' } },
                                                                                                                               ['{}'] = { Setting = {} }}},
                                                                                                      ['*'] = { Setting = {} }}},
                                                                            ['reminder'] = { Setting = {} },
                                                                            ['*'] = { Attribute = 'road_class',
                                                                                      Values = { ['street'] = { Attribute = 'instruction_class',
                                                                                                                Values = { ['enter_highway'] = { Attribute = 'direction_info',
                                                                                                                                                 Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                            ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                            ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                            ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                            ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                            ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                            ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                            ['{}'] = { Setting = {} }}},
                                                                                                                           ['ferry'] = { Attribute = 'direction_info',
                                                                                                                                         Values = { ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['*'] = { Setting = {} }}},
                                                                                                                           ['roundabout'] = { Attribute = 'direction_info',
                                                                                                                                              Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                         ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                         ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                         ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{}'] = { Setting = {} }}},
                                                                                                                           ['*'] = { Attribute = 'direction_info',
                                                                                                                                     Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                ['{street,signpost}'] = { Setting = { 'street', 'signpost' } },
                                                                                                                                                ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                ['{street,route,signpost}'] = { Setting = { 'street', 'signpost' } },
                                                                                                                                                ['{}'] = { Setting = {} }}}}},
                                                                                                 ['*'] = { Attribute = 'instruction_class',
                                                                                                           Values = { ['ferry'] = { Attribute = 'direction_info',
                                                                                                                                    Values = { ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                               ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                               ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                               ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                               ['*'] = { Setting = {} }}},
                                                                                                                      ['highway_turn'] = { Attribute = 'direction_info',
                                                                                                                                           Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                      ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                      ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                      ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                      ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                      ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                      ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                      ['{}'] = { Setting = {} }}},
                                                                                                                      ['*'] = { Attribute = 'direction_info',
                                                                                                                                Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                           ['{route}'] = { Setting = { 'route' } },
                                                                                                                                           ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                           ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                           ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                           ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                           ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                           ['{}'] = { Setting = {} }}}}}}}}},
                                                   ['first'] = { Attribute = 'trigger',
                                                                 Values = { ['action'] = { Setting = {} },
                                                                            ['*'] = { Attribute = 'road_class',
                                                                                      Values = { ['street'] = { Attribute = 'instruction_class',
                                                                                                                Values = { ['enter_highway'] = { Attribute = 'direction_info',
                                                                                                                                                 Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                            ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                            ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                            ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                            ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                            ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                            ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                            ['{}'] = { Setting = {} }}},
                                                                                                                           ['ferry'] = { Attribute = 'direction_info',
                                                                                                                                         Values = { ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                    ['*'] = { Setting = {} }}},
                                                                                                                           ['roundabout'] = { Attribute = 'direction_info',
                                                                                                                                              Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                         ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                         ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                         ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                         ['{}'] = { Setting = {} }}},
                                                                                                                           ['*'] = { Attribute = 'direction_info',
                                                                                                                                     Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                ['{street,signpost}'] = { Setting = { 'street', 'signpost' } },
                                                                                                                                                ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                ['{}'] = { Setting = {} }}}}},
                                                                                                 ['*'] = { Attribute = 'instruction_class',
                                                                                                           Values = { ['highway_turn'] = { Attribute = 'direction_info',
                                                                                                                                           Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                      ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                      ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                      ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                      ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                      ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                      ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                      ['{}'] = { Setting = {} }}},
                                                                                                                      ['*'] = { Attribute = 'direction_info',
                                                                                                                                Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                           ['{route}'] = { Setting = { 'route' } },
                                                                                                                                           ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                           ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                           ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                           ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                           ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                           ['{}'] = { Setting = {} }}}}}}}}},
                                                   ['second'] = { Attribute = 'trigger',
                                                                  Values = { ['action'] = { Attribute = 'road_class',
                                                                                             Values = { ['street'] = { Attribute = 'instruction_class',
                                                                                                                       Values = { ['enter_highway'] = { Attribute = 'direction_info',
                                                                                                                                                        Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                                   ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                                   ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                   ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                                   ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                   ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                                   ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                                   ['{}'] = { Setting = {} }}},
                                                                                                                                  ['ferry'] = { Attribute = 'direction_info',
                                                                                                                                                Values = { ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                           ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                           ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                           ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                           ['*'] = { Setting = {} }}},
                                                                                                                                  ['roundabout'] = { Attribute = 'direction_info',
                                                                                                                                                     Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                                ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                                ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                                ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                ['{route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                ['{street,route,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                                ['{}'] = { Setting = {} }}},
                                                                                                                                  ['*'] = { Attribute = 'direction_info',
                                                                                                                                            Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                       ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                       ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                       ['{street,route}'] = { Setting = { 'street' } },
                                                                                                                                                       ['{street,signpost}'] = { Setting = { 'street', 'signpost' } },
                                                                                                                                                       ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                       ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                       ['{}'] = { Setting = {} }}}}},
                                                                                                        ['*'] = { Attribute = 'instruction_class',
                                                                                                                  Values = { ['highway_turn'] = {  Attribute = 'direction_info',
                                                                                                                                                   Values = { ['{street}'] = { Setting = {} },
                                                                                                                                                              ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                              ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                              ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                              ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                              ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                              ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                              ['{}'] = { Setting = {} }}},
                                                                                                                             ['*'] = {  Attribute = 'direction_info',
                                                                                                                                        Values = { ['{street}'] = { Setting = { 'street' } },
                                                                                                                                                   ['{route}'] = { Setting = { 'route' } },
                                                                                                                                                   ['{signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                   ['{street,route}'] = { Setting = { 'route' } },
                                                                                                                                                   ['{street,signpost}'] = { Setting = { 'signpost' } },
                                                                                                                                                   ['{route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                   ['{street,route,signpost}'] = { Setting = { 'route', 'signpost' } },
                                                                                                                                                   ['{}'] = { Setting = {} }}}}}}},
                                                                              ['*'] = { Setting = {} }}}}}


-- rules for filtering highway exits based on the context in which they appear
rules.filter_highway_exit_information = { Attribute = 'instruction_order',
                                          Values = { ['single'] = { Attribute = 'trigger',
                                                                    Values = { ['action'] = { Setting = {} },
                                                                               ['reminder'] = { Setting = {} },
                                                                               ['*'] = { Attribute = 'exit_info',
                                                                                         Values = { ['{exit_name}'] = { Setting = { 'exit_name' } },
                                                                                                    ['{}'] = { Setting = {} }}}}},
                                                      ['first'] = { Attribute = 'trigger',
                                                                    Values = { ['action'] = { Setting = {} },
                                                                               ['*'] = { Attribute = 'exit_info',
                                                                                         Values = { ['{exit_name}'] = { Setting = { 'exit_name' } },
                                                                                                    ['{}'] = { Setting = {} }}}}},
                                                      ['second'] = { Attribute = 'trigger',
                                                                     Values = { ['action'] = { Attribute = 'exit_info',
                                                                                                Values = { ['{exit_name}'] = { Setting = { 'exit_name' } },
                                                                                                           ['{}'] = { Setting = {} }}},
                                                                                ['*'] = { Setting = {} }}}}}


-- rules for using continue in prompt based on context
rules.use_continue_purpose = { Attribute = 'road_change',
                                  Values = { ['false'] = { Attribute = 'instruction_order',
                                                           Values = { ['single'] = { Attribute = 'trigger',
                                                                                 Values = { ['action'] = { Setting = false },
                                                                                            ['reminder'] = { Setting = false },
                                                                                            ['*'] = { Setting = true }}},
                                                                      ['first'] = { Attribute = 'trigger',
                                                                                    Values = { ['action'] = { Setting = false },
                                                                                               ['*'] = { Setting = true }}},
                                                                      ['second'] = { Attribute = 'trigger',
                                                                                     Values = { ['action'] = { Setting = true },
                                                                                                ['*'] = { Setting = false }}}}},
                                             ['true'] = { Setting = false }}}


-- rules for using exit purpose in prompt based on context
rules.use_exit_purpose = { Attribute = 'instruction_order',
                           Values = { ['single'] = { Attribute = 'leaving_highway',
                                                     Values = { ['true'] = { Setting = true },
                                                                ['false'] = { Attribute = 'trigger',
                                                                              Values = { ['action'] = { Setting = false },
                                                                                         ['*'] = { Attribute = 'exit_info',
                                                                                                   Values = { ['{exit_name}'] = { Setting = true },
                                                                                                              ['{}'] = { Setting = false }}}}}}},
                                      ['first'] = { Attribute = 'leaving_highway',
                                                    Values = { ['true'] = { Attribute = 'trigger',
                                                                            Values = { ['action'] = { Setting = false },
                                                                                       ['*'] = { Setting = true }}},
                                                               ['false'] = { Attribute = 'trigger',
                                                                             Values = { ['action'] = { Setting = false },
                                                                                        ['*'] = { Attribute = 'exit_info',
                                                                                                  Values = { ['{exit_name}'] = { Setting = true },
                                                                                                             ['{}'] = { Setting = false }}}}}}},
                                      ['second'] = { Attribute = 'leaving_highway',
                                                     Values = { ['true'] = { Attribute = 'trigger',
                                                                             Values = { ['action'] = { Setting = true },
                                                                                        ['*'] = { Setting = false }}},
                                                                ['false'] = { Attribute = 'trigger',
                                                                              Values = { ['action'] = { Attribute = 'exit_info',
                                                                                                        Values = { ['{exit_name}'] = { Setting = true },
                                                                                                                   ['{}'] = { Setting = false }}},
                                                                                         ['*'] = { Setting = false }}}}}}}


-- decision about whether "keep <side>" should be kept for enter highway actions
rules.enter_highway_turn_information = { Attribute = 'turn',
                                         Values = { ['no_turn'] = { Setting = { action = 'join', purpose = nil } },
                                                    ['undefined'] = { Setting = { action = 'join', purpose = nil } },
                                                    ['*'] = { Attribute = 'trigger',
                                                              Values = { ['action'] = { Attribute = 'instruction_order',
                                                                                        Values = { ['first'] = { Setting = { action = 'turnkeep', purpose = nil } },
                                                                                                   ['*'] = { Setting = { action = 'turnkeep', purpose = 'tojoin' } }}},
                                                                         ['*'] = { Attribute = 'instruction_order',
                                                                                   Values = { ['second'] = { Setting = { action = 'turnkeep', purpose = nil } },
                                                                                              ['*'] = { Setting = { action = 'turnkeep', purpose = 'tojoin' } }}}}}}}


-- rules for using roundabout exits based on the context in which they appear
rules.use_exit_roundabout = { Attribute = 'trigger',
                                 Values = { ['action'] = { Setting = true },
                                            ['*'] = { Setting = false } }}


-- rules for setting information for arrival prompt ids
rules.arrival_information = { Attribute = 'trigger',
                              Values = { ['action'] = { Attribute = 'instruction_order',
                                                        Values = { ['single'] = { Attribute = 'side_of_road',
                                                                                  Values = { ['left'] = { Setting = { action = 'arrival-side', side_of_road = 'left', notification = true } },
                                                                                             ['right'] = { Setting = { action = 'arrival-side', side_of_road = 'right', notification = true } },
                                                                                             ['front'] = { Setting = { action = 'arrival-side', side_of_road = 'front', notification = true } },
                                                                                             ['*'] = { Setting = { action = 'arrival', side_of_road = nil, notification = true } }}},
                                                                   ['second'] = { Setting = { action = 'arrive', side_of_road = nil, notification = false } },
                                                                   ['*'] = { Attribute = 'side_of_road',
                                                                             Values = { ['left'] = { Setting = { action = 'arrive', side_of_road = 'left', notification = false } },
                                                                                        ['right'] = { Setting = { action = 'arrive', side_of_road = 'right', notification = false } },
                                                                                        ['front'] = { Setting = { action = 'arrive', side_of_road = 'front', notification = false } },
                                                                                        ['*'] = { Setting = { action = 'arrive', side_of_road = nil, notification = false } }}}}},
                                         ['*'] = { Attribute = 'instruction_order',
                                                   Values = { ['second'] = { Setting = { action = 'arrive', side_of_road = nil, notification = false } },
                                                              ['*'] = { Attribute = 'side_of_road',
                                                                        Values = { ['left'] = { Setting = { action = 'arrive', side_of_road = 'left', notification = false } },
                                                                                   ['right'] = { Setting = { action = 'arrive', side_of_road = 'right', notification = false } },
                                                                                   ['front'] = { Setting = { action = 'arrive', side_of_road = 'front', notification = false } },
                                                                                   ['*'] = { Setting = { action = 'arrive', side_of_road = nil, notification = false } }}}}}}}


-- if the distance to the second maneuver in meters is lower or equal to the limit, 'immediately' is included in front of the second maneuver phrase
-- if limit set to nil, 'immediately' is included regardless of the distance
-- if limit set to -1, 'immediately' is never included, since the distance is always greater than -1
rules.close_distance_limit = { Attribute = 'road_class',
                               Values = { ['*'] = { Attribute = 'instruction_class',
                                                    Values = { ['junction'] = { Setting = 30 },
                                                               ['uturn'] = { Setting = 30 },
                                                               ['ferry'] = { Setting = 30 },
                                                               ['exit_roundabout'] = { Setting = 30 },
                                                               ['enter_highway'] = { Setting = 30 },
                                                               ['highway_turn'] = { Setting = 30 },
                                                               ['arrival'] = { Setting = -1 },
                                                               ['roundabout'] = { Setting = -1 }}}}}


-- =================== Rules for natural guidance element selection ============


-- threshold for the natural guidance importance - an equal or greater importance makes the element usable
-- if threshold set to nil, natural guidance element is never used regardless of its importance
-- if threshold set to -1, natural guidance element is always used, since the importance is always greater than -1
rules.natural_guidance_importance_threshold = { Setting = 6 }


-- if the traffic control or stop sign order is above the limit, it is not used in the natural guidance phrase
-- if limit set to nil, the natural guidance element is used regardless of its order
-- if limit set to -1, the natural guidance element is never used, since its order is aways greater than -1
rules.natural_guidance_count_limit = { Setting = 3 }


-- if the distance to the first NG element in meters is below the threshold, exclude the first element only
-- if threshold set to nil, the first NG element is included regardless of the distance to it
-- if threshold set to -1, the natural guidance element is never used, since the distance to the first NG element is always grater than -1
rules.natural_guidance_distance_to_first_element_threshold = { Setting = 30 }


-- if the distance to maneuver in meters is above the limit, natural guidance is not included in the prompt
-- if limit set to nil, natural guidance is included regardless of the distance
-- if limit set to -1, natural guidance element is never used, since the distance is always grater than -1
rules.natural_guidance_distance_limit = { Attribute = 'trigger',
                                              Values = { ['range'] = { Setting = 1000 },
                                                         ['*'] = { Setting = nil } }}


-- elements sorted in descending priority order
rules.natural_guidance_elements_priority_order = { Setting = { 't_junction',
                                                               'traffic_light',
                                                               'stop_sign' } }


-- rules for filtering natural guidance based on the context in which it appears
rules.use_natural_guidance_with_trigger = { Attribute = 'instruction_order',
                                            Values = { ['single'] = { Attribute = 'trigger',
                                                                      Values = { ['action'] = { Setting = false },
                                                                                 ['reminder'] = { Setting = false },
                                                                                 ['*'] = { Setting = true } }},
                                                       ['first'] = { Attribute = 'trigger',
                                                                     Values = { ['action'] = { Setting = false },
                                                                                ['reminder'] = { Setting = false },
                                                                                ['*'] = { Setting = true } }},
                                                       ['second'] = { Attribute = 'trigger',
                                                                      Values = { ['action'] = { Setting = true },
                                                                                 ['*'] = { Setting = false }}}}}


-- rules about using natural guidance together with direction
rules.use_natural_guidance_with_direction = { Attribute = 'natural_guidance_type',
                                              Values = { ['*'] = { Attribute = 'direction_info',
                                                                   Values = { ['*'] = { Setting = true }}}}}


-- rules for using the natural guidance together with lane information
rules.use_natural_guidance_with_lane_information = { Attribute = 'instruction_order',
                                                     Values = { ['single'] = { Setting = true },
                                                                ['first'] = { Setting = false },
                                                                ['second'] = { Setting = false } }}


-- if set to true, the distance phrase is included in the range and distance prompts containing natural guidance
-- if set to false, the distance phrase is not included in such cases
rules.use_distance_with_natural_guidance = { Attribute = 'natural_guidance_type',
                                             Values = { ['*'] = { Setting = false }}}

-- =================== Rules for lane information element selection ============

-- decision about whether lane information should be used at all
rules.use_lane_information = { Setting = true }


-- if the distance to maneuver in meters is above the limit, lane information is not included in the prompt
-- if limit set to nil, lane information is included regardless of the distance
-- if limit set to -1, lane information is never included, since the distance is always greater than -1
rules.lane_information_limit = { Attribute = 'trigger',
                                      Values = { ['distance'] = { Setting = nil },
                                                 ['range'] = { Attribute = 'road_class',
                                                               Values = { ['street'] = { Setting = 350 },
                                                                          ['*'] = { Setting = 800 }}},
                                                 ['*'] = { Setting = -1 }}}


-- if the number of the lanes to be used in the lane phrase is above the limit, lane information is not included in the prompt
-- if limit set to nil, lane information is included regardless of the number of the lanes in the phrase
-- if limit set to 0, lane information is never included, since the number of the lanes in the phrase is always greater than 0
-- NOTE: The limit must be accomodated by the translations of the lane phrases: nav.variable.LANE.[left|right].X
rules.lane_count_limit = { Setting = 4 }


return rules
