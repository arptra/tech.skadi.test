local templates = {
    ['nav.-.follow.-.-'] = 'Siga {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Siga {DIRECTION} durante {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Siga por la {HIGHWAY} durante {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Siga por la carretera durante {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Siga por la {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Siga por la carretera',

    ['nav.-.head.-.-'] = 'Diríjase al {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}, haga un cambio de sentido {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}, tome el ferry {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}, {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}, {TURN_KEEP} para incorporarse a {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}, {TURN_KEEP} para incorporarse a la {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} habrá llegado a su {GOAL} {DIRECTION}. El {GOAL} estará {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} habrá llegado a su {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entre en la rotonda {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} en la rotonda {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} incorpórese a la {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} haga un cambio de sentido {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} tome la salida {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} tome el ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} para continuar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} para tomar la salida y continúe {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {EXIT} y continúe {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para incorporarse a {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para incorporarse a la {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'y casi habrá llegado a su {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'y luego entre en la rotonda',
    ['nav.second.exitroundabout.-.-'] = 'y luego {NEXT_TAKE_NTH_EXIT} en la rotonda {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'y luego incorpórese a la {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'y luego haga un cambio de sentido {IMMEDIATELY} {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'y luego tome la salida',
    ['nav.second.takeferry.-.-'] = 'y luego tome el ferry {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} para continuar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} para tomar la salida {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} para tomar la salida {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} para incorporarse a {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'y luego {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} para incorporarse a la {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Ha llegado a su {GOAL}',
    ['nav.arrival-side'] = 'Ha llegado a su {GOAL}. Está {SIDE}',
    ['nav.gpslost'] = 'Se ha perdido la señal del GPS',
    ['nav.gpsrestored'] = 'Se ha recuperado la señal del GPS',
    ['nav.newroute'] = 'Buscando una nueva ruta',
    ['nav.speedcamera'] = 'Se aproxima a un radar',
}

return templates
