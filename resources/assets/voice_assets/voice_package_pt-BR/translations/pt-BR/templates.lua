local templates = {
    ['nav.-.follow.-.-'] = 'Siga {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Siga {DIRECTION} por {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Siga na {HIGHWAY} por {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Siga na estrada por {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Siga pela {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Siga na estrada',

    ['nav.-.head.-.-'] = 'Siga para o {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} faça um retorno {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} pegue a balsa {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} para pegar {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} para pegar a {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} você chegará ao seu {GOAL} {DIRECTION}. O {GOAL} estará {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} você chegará ao seu {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entre na rotatória {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} na rotatória {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} entre na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} faça um retorno {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} pegue a saída {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} pegue a balsa {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} para continuar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} para pegar a saída e continue {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} para pegar a saída {EXIT} e continue {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} para pegar a saída {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} para pegar a saída {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para pegar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} para pegar a {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'e em seguida você chegará ao seu {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'e em seguida entre na rotatória',
    ['nav.second.exitroundabout.-.-'] = 'e em seguida {NEXT_TAKE_NTH_EXIT} na rotatória {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'e em seguida entre na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'e {IMMEDIATELY} em seguida faça um retorno {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'e em seguida pegue a saída',
    ['nav.second.takeferry.-.-'] = 'e em seguida pegue a balsa {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ' e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} para continuar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} para pegar a saída {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} para pegar a saída {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} {NEXT_LANDMARK} para pegar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'e {IMMEDIATELY} em seguida {NEXT_TURN_KEEP} {NEXT_LANDMARK} para pegar a {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Você chegou ao seu {GOAL}',
    ['nav.arrival-side'] = 'Você chegou ao seu {GOAL}. Ele está {SIDE}',
    ['nav.gpslost'] = 'Sinal de GPS perdido',
    ['nav.gpsrestored'] = 'O sinal de GPS foi recuperado',
    ['nav.newroute'] = 'Recalculando rota',
    ['nav.speedcamera'] = 'Radar à frente',
}

return templates
