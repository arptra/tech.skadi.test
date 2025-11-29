local templates = {
    ['nav.-.follow.-.-'] = 'Siga {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Siga {DIRECTION} durante {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Siga a {HIGHWAY} durante {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Siga a estrada durante {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Siga a {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Siga a estrada',

    ['nav.-.head.-.-'] = 'Dirija-se para {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} faça inversão de marcha {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} apanhe o ferry {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} para entrar {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} para entrar na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} chegará ao seu local de {GOAL} {DIRECTION}. O local de {GOAL} ficará {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} chegará ao seu local de {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entre na rotunda {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} na rotunda {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} entre na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} faça inversão de marcha {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} vire na saída {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} apanhe o ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} para continuar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} para virar na saída e continuar {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} para virar na saída {EXIT} e continuar {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} para virar na saída {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} para virar na saída {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para entrar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para entrar na {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'e, em seguida, chegará ao seu local de {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'e, em seguida, entre na rotunda',
    ['nav.second.exitroundabout.-.-'] = 'e, em seguida, {NEXT_TAKE_NTH_EXIT} na rotunda {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'e, em seguida, entre na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'e, em seguida, faça inversão de marcha {IMMEDIATELY} {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'e, em seguida, vire na saída',
    ['nav.second.takeferry.-.-'] = 'e, em seguida, apanhe o ferry {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} para continuar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} para virar na saída {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} para virar na saída {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} para entrar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'e, em seguida, {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} para entrar na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Chegou ao seu local de {GOAL}',
    ['nav.arrival-side'] = 'Chegou ao seu local de {GOAL}. Fica {SIDE}',
    ['nav.gpslost'] = 'Sinal GPS perdido',
    ['nav.gpsrestored'] = 'Sinal GPS restabelecido',
    ['nav.newroute'] = 'A calcular uma nova rota',
    ['nav.speedcamera'] = 'Radar de velocidade mais adiante',
}

return templates
