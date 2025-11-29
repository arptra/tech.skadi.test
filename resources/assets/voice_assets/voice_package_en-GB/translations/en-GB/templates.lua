local templates = {
    ['nav.-.follow.-.-'] = 'Follow {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Follow {DIRECTION} for {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Follow the {HIGHWAY} for {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Follow the road for {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Follow the {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Follow the road',

    ['nav.-.head.-.-'] = 'Head {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} make a U-turn {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} take the ferry {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} to join {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} to join the {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} you will reach your {GOAL} {DIRECTION}. The {GOAL} will be {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} you will reach your {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} enter the roundabout {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} at the roundabout {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} join the {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} make a U-turn {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} take the exit {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} take the ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} to continue {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} to take the exit and continue {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} to take exit {EXIT} and continue {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} to take the exit {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} to take exit {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} to join {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} to join the {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'and then you will reach your {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'and then enter the roundabout',
    ['nav.second.exitroundabout.-.-'] = 'and then {NEXT_TAKE_NTH_EXIT} at the roundabout {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'and then join the {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'and then {IMMEDIATELY} make a U-turn {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'and then take the exit',
    ['nav.second.takeferry.-.-'] = 'and then take the ferry {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'and then {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ' and then {IMMEDIATELY} {NEXT_TURN_KEEP} to continue {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'and then {IMMEDIATELY} {NEXT_TURN_KEEP} to take the exit {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'and then {IMMEDIATELY} {NEXT_TURN_KEEP} to take exit {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'and then {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} to join {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'and then {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} to join the {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'You have reached your {GOAL}',
    ['nav.arrival-side'] = 'You have reached your {GOAL}. It\'s {SIDE}',
    ['nav.gpslost'] = 'GPS signal lost',
    ['nav.gpsrestored'] = 'GPS signal has been restored',
    ['nav.newroute'] = 'Finding a new route',
    ['nav.speedcamera'] = 'Speed camera ahead',
}

return templates
