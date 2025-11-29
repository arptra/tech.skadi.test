local templates = {
    ['nav.-.follow.-.-'] = 'Volg {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Volg {DIRECTION} gedurende {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Volg de {HIGHWAY} gedurende {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Volg de weg gedurende {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Volg de {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Volg de weg',

    ['nav.-.head.-.-'] = 'Ga richting {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} keer om {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} neem de veerboot {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} en volg {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} en volg de {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} bereikt u uw {GOAL} {DIRECTION}. De {GOAL} is {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} bereikt u uw {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} rij de rotonde op {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} aan de rotonde {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} volg de {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} keer om {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} neem de afrit {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} neem de veerboot {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{TURN_KEEP} {INTERVAL} en ga verder {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{TURN_KEEP} {INTERVAL} en neem de afrit en ga verder {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{TURN_KEEP} {INTERVAL} en neem afrit {EXIT} en ga verder {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{TURN_KEEP} {INTERVAL} en neem de afrit {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{TURN_KEEP} {INTERVAL} en neem afrit {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{TURN_KEEP} {INTERVAL} {LANDMARK} en volg {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{TURN_KEEP} {INTERVAL} {LANDMARK} en volg de {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'en dan bereikt u uw {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'en rij vervolgens de rotonde op',
    ['nav.second.exitroundabout.-.-'] = 'en dan {NEXT_TAKE_NTH_EXIT} aan de rotonde {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'en volg de {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'en dan {IMMEDIATELY} keer om {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'en neem dan de afrit',
    ['nav.second.takeferry.-.-'] = 'en neem dan de veerboot {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} en ga verder {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} en neem de afrit {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} en neem afrit {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} en volg {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'en dan {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} en volg de {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'U hebt uw {GOAL} bereikt',
    ['nav.arrival-side'] = 'U hebt uw {GOAL} bereikt. De bestemming bevindt zich {SIDE}',
    ['nav.gpslost'] = 'Geen GPS signaal',
    ['nav.gpsrestored'] = 'GPS signaal is hersteld',
    ['nav.newroute'] = 'Er wordt een nieuwe route gezocht',
    ['nav.speedcamera'] = 'U nadert een flitscamera',
}

return templates
