local templates = {
    ['nav.-.follow.-.-'] = 'Jedź dalej {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Jedź dalej {DIRECTION} przez {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Jedź przez {HIGHWAY} zgodnie z jej kierunkiem przez {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Trzymaj się drogi przez {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Jedź przez {HIGHWAY} zgodnie z jej kierunkiem',
    ['nav.-.follow.-.road'] = 'Trzymaj się drogi',

    ['nav.-.head.-.-'] = 'Kieruj się na {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} zawróć {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} wjedź na prom {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, aby jechać {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, aby wjechać na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} osiągniesz {GOAL} {DIRECTION}. {GOAL} będzie {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} osiągniesz {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} wjedź na rondo {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} na rondzie {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} wjedź na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} zawróć {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} zjedź zjazdem {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} wjedź na prom {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}, kontynuując jazdę {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, aby zjechać zjazdem, a następnie kontynuuj jazdę {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, aby zjechać zjazdem {EXIT}, a następnie kontynuuj jazdę {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, aby zjechać zjazdem {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, aby zjechać zjazdem {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, aby jechać {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, aby wjechać na {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', a następnie osiągniesz {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', a następnie wjedź na rondo',
    ['nav.second.exitroundabout.-.-'] = ', a następnie na rondzie {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', a następnie wjedź na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', a następnie {IMMEDIATELY} zawróć {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', a następnie zjedź zjazdem',
    ['nav.second.takeferry.-.-'] = ', a następnie wjedź na prom {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP}, kontynuując jazdę {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP}, aby zjechać zjazdem {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP}, aby zjechać zjazdem {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, aby jechać {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', a następnie {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, aby wjechać na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = '{GOAL} został osiągnięty',
    ['nav.arrival-side'] = '{GOAL} został osiągnięty. Znajduje się on {SIDE}',
    ['nav.gpslost'] = 'Utracono sygnał GPS',
    ['nav.gpsrestored'] = 'Odzyskano sygnał GPS',
    ['nav.newroute'] = 'Trwa wyszukiwanie nowej trasy',
    ['nav.speedcamera'] = 'Przed Tobą fotoradar',
}

return templates
