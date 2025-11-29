local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} folgen',
    ['nav.-.follow.-.distance'] = '{DIRECTION} {DISTANCE} folgen',
    ['nav.-.follow.-.distance-highway'] = 'folgen Sie der {HIGHWAY} für {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'folgen Sie dem Straßenverlauf für {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'folgen Sie der {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'folgen Sie dem Straßenverlauf',

    ['nav.-.head.-.-'] = 'nach {ORIENTATION} {DIRECTION} fahren',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} eine Kehrtwendung machen {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} die Fähre {DIRECTION} nehmen {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = ' {LANDMARK} {TURN_KEEP}, um auf {DIRECTION} aufzufahren. {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, um auf die {HIGHWAY} {DIRECTION} aufzufahren. {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} erreichen Sie {GOAL} {DIRECTION}. Es befindet sich {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} erreichen Sie {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} in den Kreisverkehr fahren {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} im Kreisverkehr {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} auf die {HIGHWAY} auffahren {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} eine Kehrtwendung machen {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} die Ausfahrt {DIRECTION} nehmen {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} die Fähre {DIRECTION} nehmen {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}, um weiter {DIRECTION} zu fahren. {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, um die Ausfahrt zu nehmen. Dann weiter {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, um die Ausfahrt {EXIT} zu nehmen. Dann weiter {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, um die Ausfahrt {DIRECTION} zu nehmen. {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, um die Ausfahrt {EXIT} {DIRECTION} zu nehmen. {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {LANDMARK} {TURN_KEEP}, um auf {DIRECTION} aufzufahren. {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {LANDMARK} {TURN_KEEP}, um auf die {HIGHWAY} {DIRECTION} aufzufahren. {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'danach haben Sie {NEXT_GOAL} {NEXT_DIRECTION} erreicht',
    ['nav.second.enterroundabout.-.-'] = 'und danach in den Kreisverkehr fahren',
    ['nav.second.exitroundabout.-.-'] = 'danach im Kreisverkehr {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'und danach auf die {NEXT_HIGHWAY} auffahren',
    ['nav.second.makeuturn.-.-'] = ' und danach {IMMEDIATELY} {NEXT_LANDMARK} eine Kehrtwendung machen',
    ['nav.second.takeexit.-.-'] = 'und danach die Ausfahrt nehmen',
    ['nav.second.takeferry.-.-'] = 'und danach {NEXT_LANDMARK} die Fähre {NEXT_DIRECTION} nehmen',
    ['nav.second.turnkeep.-.-'] = 'und danach {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ' und danach {IMMEDIATELY} {NEXT_TURN_KEEP}, um weiter {NEXT_DIRECTION} zu fahren',
    ['nav.second.turnkeep.toexit.-'] = 'und danach {IMMEDIATELY} {NEXT_TURN_KEEP}, um die Ausfahrt {NEXT_DIRECTION} zu nehmen',
    ['nav.second.turnkeep.toexit.exit'] = 'und danach {IMMEDIATELY} {NEXT_TURN_KEEP}, um die Ausfahrt {NEXT_EXIT} {NEXT_DIRECTION} zu nehmen',
    ['nav.second.turnkeep.tojoin.-'] = 'und danach {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP}, um auf {NEXT_DIRECTION} aufzufahren',
    ['nav.second.turnkeep.tojoin.highway'] = 'und danach {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP}, um auf die {NEXT_HIGHWAY} {NEXT_DIRECTION} aufzufahren',

    ['nav.arrival'] = 'Sie haben {GOAL} erreicht.',
    ['nav.arrival-side'] = 'Sie haben {GOAL} erreicht. Es befindet sich {SIDE}',
    ['nav.gpslost'] = 'Kein GPS-Signal',
    ['nav.gpsrestored'] = 'Das GPS-Signal ist wieder verfügbar',
    ['nav.newroute'] = 'Eine neue Route wird berechnet',
    ['nav.speedcamera'] = 'Radarkamera voraus.',
}

return templates
