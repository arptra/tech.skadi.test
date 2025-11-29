local templates = {
    ['nav.-.follow.-.-'] = 'Suivez {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Suivez {DIRECTION} sur {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Suivez {HIGHWAY} sur {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Suivez la route sur {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Suivez {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Suivez la route',

    ['nav.-.head.-.-'] = 'Prenez la direction {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}, faites demi-tour',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}, prenez le ferry {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}, {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}, {TURN_KEEP} pour rejoindre {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}, {TURN_KEEP} pour rejoindre {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} vous atteindrez votre {GOAL} {DIRECTION}. Votre {GOAL} se trouvera {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} vous atteindrez votre {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} prenez le rond-point {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} au rond-point {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} rejoignez {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} faites demi-tour {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} prenez la sortie {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} prenez le ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} pour continuer {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie et continuer {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {EXIT} et continuer {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} pour prendre la sortie {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pour rejoindre {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pour rejoindre {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'et vous aurez atteint votre {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'puis prenez le rond-point',
    ['nav.second.exitroundabout.-.-'] = 'puis {NEXT_TAKE_NTH_EXIT} au rond-point {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'puis rejoignez {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'puis faites demi-tour {IMMEDIATELY} {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'puis prenez la sortie',
    ['nav.second.takeferry.-.-'] = 'puis prenez le ferry {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour continuer {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour prendre la sortie {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} pour prendre la sortie {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} pour rejoindre {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'puis {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} pour rejoindre {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Vous avez atteint votre {GOAL}',
    ['nav.arrival-side'] = 'Vous avez atteint votre {GOAL}, qui se trouve {SIDE}',
    ['nav.gpslost'] = 'Signal GPS perdu',
    ['nav.gpsrestored'] = 'Signal GPS restauré',
    ['nav.newroute'] = 'Calcul d\'un nouvel itinéraire',
    ['nav.speedcamera'] = 'Vous approchez d\'un radar de vitesse',
}

return templates
