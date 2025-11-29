local templates = {
    ['nav.-.follow.-.-'] = 'seguiu {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'seguiu {DIRECTION} durant {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'seguiu l\'{HIGHWAY} durant {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'seguiu la carretera durant {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'seguiu l\'{HIGHWAY}',
    ['nav.-.follow.-.road'] = 'seguiu la carretera',

    ['nav.-.head.-.-'] = 'dirigiu-vos en sentit {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}, feu un canvi de sentit {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}, agafeu el ferri {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}, {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}, {TURN_KEEP} per incorporar-vos {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}, {TURN_KEEP} per incorporar-vos a l\'{HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} arribareu a la vostra {GOAL} {DIRECTION}. La {GOAL} li quedarà {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} arribareu a la vostra {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entreu a la rotonda {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} a la rotonda {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} incorporeu-vos a l\'{HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} feu un canvi de sentit {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} agafeu la sortida {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} agafeu el ferri {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} per continuar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} per agafar la sortida i continueu {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} per agafar la sortida {EXIT} i continueu {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} per agafar la sortida {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} per agafar la sortida {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} per incorporar-vos {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} per incorporar-vos a l\'{HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'i haureu arribat a la vostra {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'i després entreu a la rotonda',
    ['nav.second.exitroundabout.-.-'] = 'i després {NEXT_TAKE_NTH_EXIT} a la rotonda {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'i després incorporeu-vos a l\'{NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'i després feu un canvi de sentit {NEXT_LANDMARK} {IMMEDIATELY}',
    ['nav.second.takeexit.-.-'] = 'i després agafeu la sortida',
    ['nav.second.takeferry.-.-'] = 'i després agafeu el ferri {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} per continuar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} per agafar la sortida {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} per agafar la sortida {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} per incorporar-vos a {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'i després {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} per incorporar-vos a l\'{NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'heu arribat a la vostra {GOAL}',
    ['nav.arrival-side'] = 'heu arribat a la vostra {GOAL}. Li queda {SIDE}',
    ['nav.gpslost'] = 's\'ha perdut el senyal del GPS',
    ['nav.gpsrestored'] = 's\'ha recuperat el senyal del GPS',
    ['nav.newroute'] = 's\'està cercant una nova ruta',
    ['nav.speedcamera'] = 'us acosteu a un radar',
}

return templates
