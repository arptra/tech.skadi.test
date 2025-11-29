local templates = {
    ['nav.-.follow.-.-'] = 'Suivez {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Suivez {DIRECTION} sur {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Suivez {HIGHWAY} pendant {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Suivez la route sur {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Suivez {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Suivez la route',

    ['nav.-.head.-.-'] = 'Prenez la direction {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}, faites demi-tour {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}, prenez le traversier {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}, {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}, {TURN_KEEP} pour prendre {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}, {TURN_KEEP} pour prendre {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} vous arriverez à votre {GOAL} {DIRECTION}. Votre {GOAL} sera {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} vous arriverez à votre {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} prenez le rond-point {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} au rond-point {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} prenez {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} faites demi-tour {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} prenez la sortie {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} prenez le traversier {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} pour continuer {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie et continuer {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {EXIT} et continuer {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pour prendre {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pour prendre {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '. Vous arriverez ensuite à votre {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'puis prenez le rond-point',
    ['nav.second.exitroundabout.-.-'] = 'puis {NEXT_TAKE_NTH_EXIT} au rond-point {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'puis prenez {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'puis faites {IMMEDIATELY} demi-tour {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'puis prenez la sortie',
    ['nav.second.takeferry.-.-'] = 'puis prenez le traversier {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'puis {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION} {IMMEDIATELY}',
    ['nav.second.turnkeep.tocontinue.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour continuer {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour prendre la sortie {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour prendre la sortie {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} pour prendre {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} pour prendre {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Vous êtes arrivé à votre {GOAL}',
    ['nav.arrival-side'] = 'Vous êtes arrivé à votre {GOAL}. Elle est {SIDE}',
    ['nav.gpslost'] = 'Signal GPS perdu',
    ['nav.gpsrestored'] = 'Signal GPS rétabli',
    ['nav.newroute'] = 'Recherche d\'un nouvel itinéraire',
    ['nav.speedcamera'] = 'Vous approchez d\'une caméra de surveillance de la vitesse',
}

return templates
