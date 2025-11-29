local templates = {
    ['nav.-.follow.-.-'] = 'Aja {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Aja tietä {DIRECTION} {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Aja {HIGHWAY} seuraten {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Aja tietä {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Aja {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Aja tietä',

    ['nav.-.head.-.-'] = 'Suuntaa {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} tee U-käännös {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} aja lautalle {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} ja jatka {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} ja jatka {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} {GOAL} tulee vastaan {DIRECTION}. {GOAL} on {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} {GOAL} tulee vastaan {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} aja liikenneympyrään {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} liikenneympyrässä {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} jatka {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} tee U-käännös {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} aja liittymästä {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} aja lautalle {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} ja jatka {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, aja liittymästä ja jatka {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, aja liittymästä {EXIT} ja jatka {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} ja aja liittymästä {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} ja aja liittymästä {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} ja jatka {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} ja jatka {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'niin saavut |{NEXT_GOAL}| {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'ja aja sitten liikenneympyrään',
    ['nav.second.exitroundabout.-.-'] = 'ja sitten liikenneympyrässä {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'ja jatka sitten {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'ja tee sitten U-käännös {IMMEDIATELY} {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'ja aja sitten liittymästä',
    ['nav.second.takeferry.-.-'] = 'ja aja sitten lautalle {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} ja jatka {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} ja aja liittymästä {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} ja aja liittymästä {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} ja jatka {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'ja sitten {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} ja jatka {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = '{GOAL} on saavutettu',
    ['nav.arrival-side'] = '{GOAL} on saavutettu. Se on {SIDE}',
    ['nav.gpslost'] = 'GPS-signaali hävisi',
    ['nav.gpsrestored'] = 'GPS-signaali on palautunut',
    ['nav.newroute'] = 'Haetaan uutta reittiä',
    ['nav.speedcamera'] = 'Valvontakamera edessä',
}

return templates
