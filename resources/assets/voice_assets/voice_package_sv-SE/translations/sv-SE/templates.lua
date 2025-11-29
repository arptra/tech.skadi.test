local templates = {
    ['nav.-.follow.-.-'] = 'följ {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'följ {DIRECTION} i {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'följ {HIGHWAY} i {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'följ vägen i {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'följ {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'följ vägen',

    ['nav.-.head.-.-'] = 'kör {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = 'gör en U-sväng {LANDMARK} {SECOND}',
    ['nav.landmark.takeferry.-.-'] = 'ta färjan {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{TURN_KEEP} {LANDMARK} och kör ut på {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{TURN_KEEP} {LANDMARK} och kör ut på {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} är du framme vid {GOAL} {DIRECTION}. {GOAL} finns {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} är du framme vid {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} kör in i rondellen {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} i rondellen {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} kör sedan ut på {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} gör en U-sväng {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} ta avfart {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ta färjan {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = 'kör {INTERVAL} och {TURN_KEEP} (nu) {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = 'kör {INTERVAL}, {TURN_KEEP} och fortsätt {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = 'kör {INTERVAL}, {TURN_KEEP}, ta avfart och fortsätt {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = 'kör {INTERVAL}, {TURN_KEEP} mot avfart {EXIT} och fortsätt {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = 'kör {INTERVAL}, {TURN_KEEP} och ta avfart {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = 'kör {INTERVAL} och {TURN_KEEP} mot avfart {EXIT} {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = 'kör {INTERVAL}, {TURN_KEEP} {LANDMARK} och kör ut på {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = 'kör {INTERVAL}, {TURN_KEEP} {LANDMARK} och kör ut på {HIGHWAY} {DIRECTION}. {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'och sedan är du framme vid {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'och kör in i rondellen',
    ['nav.second.exitroundabout.-.-'] = 'och {NEXT_TAKE_NTH_EXIT} i rondellen {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'och kör därefter ut på {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'och gör sedan {IMMEDIATELY} en U-sväng {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'och ta sedan avfart',
    ['nav.second.takeferry.-.-'] = 'och ta sedan färjan {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'och sedan {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'och sedan {NEXT_TURN_KEEP} {IMMEDIATELY} och fortsätt {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'och sedan {NEXT_TURN_KEEP}, och ta avfart {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'och sedan {NEXT_TURN_KEEP} mot avfart {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'och sedan {NEXT_TURN_KEEP} {NEXT_LANDMARK}, och kör sedan ut på {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'och sedan {NEXT_TURN_KEEP} {NEXT_LANDMARK}, och kör sedan ut på {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Du är nu framme vid {GOAL}',
    ['nav.arrival-side'] = 'Du är nu framme vid {GOAL}. Det finns {SIDE}',
    ['nav.gpslost'] = 'Ingen GPS-signal',
    ['nav.gpsrestored'] = 'GPS-signalen har återställts',
    ['nav.newroute'] = 'Söker efter en ny rutt',
    ['nav.speedcamera'] = 'Fartkamera längre fram',
}

return templates
