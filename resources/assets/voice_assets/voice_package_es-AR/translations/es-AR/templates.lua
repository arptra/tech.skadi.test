local templates = {
    ['nav.-.follow.-.-'] = 'Siga {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Siga {DIRECTION} durante {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Siga por la {HIGHWAY} durante {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Siga el camino durante {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Siga la {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Siga el camino',

    ['nav.-.head.-.-'] = 'Vaya al {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} gire en U {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} tome el ferry {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} para entrar a {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} para entrar a la {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} llegará a su {GOAL} {DIRECTION}. El {GOAL} estará {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} llegará a su {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entre a la rotonda {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} en la rotonda {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} entre a la {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} gire en U {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} salga {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} tome el ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} para continuar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} para tomar la salida y siga {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {EXIT} y siga {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} para tomar la salida {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para entrar a {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para entrar a la {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'y después llegará a su {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'y luego entre en la rotonda',
    ['nav.second.exitroundabout.-.-'] = 'y después {NEXT_TAKE_NTH_EXIT} en la rotonda {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'y después entre a la {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'y {IMMEDIATELY} después gire en U {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'y después salga',
    ['nav.second.takeferry.-.-'] = 'y después tome el ferry {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} para continuar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} para tomar la salida {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} para tomar la salida {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} {NEXT_LANDMARK} para entrar a {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'y {IMMEDIATELY} después {NEXT_TURN_KEEP} {NEXT_LANDMARK} para entrar a la {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Ha llegado a su {GOAL}',
    ['nav.arrival-side'] = 'Ha llegado a su {GOAL}. Está {SIDE}',
    ['nav.gpslost'] = 'Se ha perdido la señal del GPS',
    ['nav.gpsrestored'] = 'Se ha recuperado la señal del GPS',
    ['nav.newroute'] = 'Buscando una nueva ruta',
    ['nav.speedcamera'] = 'Camara más adelante',
}

return templates
