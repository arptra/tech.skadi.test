local templates = {
    ['nav.-.follow.-.-'] = 'Volg {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Volg {DIRECTION} gedurende {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Volg de {HIGHWAY} gedurende {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Volg de weg gedurende {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Volg de {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Volg de weg',

    ['nav.-.head.-.-'] = 'Rij richting het {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} maak een U-bocht {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} neem de veerboot {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} om in te voegen op {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} om in te voegen op de {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} bereikt u uw {GOAL} {DIRECTION}. Uw {GOAL} ligt {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} bereikt u uw {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} de rotonde opgaan {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} op de rotonde {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} invoegen op de {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} maak een U-bocht {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} neem de afslag {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} neem de veerboot {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{TURN_KEEP} {INTERVAL} om verder te rijden {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{TURN_KEEP} {INTERVAL} om de afslag te nemen en verder rijden {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{TURN_KEEP} {INTERVAL} om de afslag {EXIT} te nemen en verder rijden {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{TURN_KEEP} {INTERVAL} om de afslag te nemen {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{TURN_KEEP} {INTERVAL} om de afslag {EXIT} te nemen {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{TURN_KEEP} {INTERVAL} {LANDMARK} om in te voegen op {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{TURN_KEEP} {INTERVAL} {LANDMARK} om in te voegen op de {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'en vervolgens bereikt u uw {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'en vervolgens de rotonde opgaan',
    ['nav.second.exitroundabout.-.-'] = 'en vervolgens {NEXT_TAKE_NTH_EXIT} op de rotonde {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'en vervolgens invoegen op de {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'en vervolgens {IMMEDIATELY} een U-bocht maken {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'en vervolgens de afslag nemen',
    ['nav.second.takeferry.-.-'] = 'en vervolgens de veerboot nemen {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} om verder te rijden {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} om de afslag te nemen {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} om de afslag {NEXT_EXIT} te nemen {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} om in te voegen op {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'en vervolgens {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} om in te voegen op de {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'U heeft uw {GOAL} bereikt',
    ['nav.arrival-side'] = 'U heeft uw {GOAL} bereikt. Deze bevindt zich {SIDE}',
    ['nav.gpslost'] = 'Geen GPS-signaal',
    ['nav.gpsrestored'] = 'GPS-signaal is hersteld',
    ['nav.newroute'] = 'Een nieuwe route zoeken',
    ['nav.speedcamera'] = 'Flitspaal in aantocht',
}

return templates
