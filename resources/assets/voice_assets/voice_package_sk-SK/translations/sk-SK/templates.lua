local templates = {
    ['nav.-.follow.-.-'] = 'pokračujte po {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'pokračujte po {DIRECTION} {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'pokračujte po {HIGHWAY} {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'pokračujte po tejto ceste {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'pokračujte po {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'pokračujte po tejto ceste',

    ['nav.-.head.-.-'] = 'pokračujte na {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} sa otočte a pokračujte opačným smerom {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} použite trajekt {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} a vojdite na {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} a vojdite na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} a potom dorazíte do {GOAL} {DIRECTION}. Bude {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} a potom dorazíte do {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} a potom vojdite na kruhový objazd {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} a potom na kruhovom objazde {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} a potom vojdite na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} potom {LANDMARK} sa otočte a pokračujte opačným smerom {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} zíďte na výjazde {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} a potom použite trajekt {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} a potom {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} a pokračujte {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, zíďte na výjazde a pokračujte {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, zíďte na výjazde {EXIT} a pokračujte {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} potom {TURN_KEEP} a zíďte na výjazde {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} potom {TURN_KEEP} a zíďte na výjazde {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} potom {LANDMARK} {TURN_KEEP} a vojdite na {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} potom {LANDMARK} {TURN_KEEP} a vojdite na {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', a potom dorazíte do {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', a potom vojdite na kruhový objazd',
    ['nav.second.exitroundabout.-.-'] = ', a potom na kruhovom objazde {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', a potom vojdite na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', potom, {NEXT_LANDMARK}, sa {IMMEDIATELY} otočte a pokračujte opačným smerom',
    ['nav.second.takeexit.-.-'] = ', a potom zíďte na výjazde',
    ['nav.second.takeferry.-.-'] = ', a potom použite trajekt {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', a potom, {NEXT_LANDMARK}, {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', potom {IMMEDIATELY} {NEXT_TURN_KEEP} a pokračujte {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', potom {IMMEDIATELY} {NEXT_TURN_KEEP} a zíďte na výjazde {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', potom {IMMEDIATELY} {NEXT_TURN_KEEP} a zíďte na výjazde {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', potom {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} a vojdite na {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', potom {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} a vojdite na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Dorazili ste do {GOAL}',
    ['nav.arrival-side'] = 'Dorazili ste do {GOAL}. Je {SIDE}',
    ['nav.gpslost'] = 'GPS signál sa stratil',
    ['nav.gpsrestored'] = 'GPS signál bol obnovený',
    ['nav.newroute'] = 'Vyhľadávam novú trasu',
    ['nav.speedcamera'] = 'Pred vami je rýchlostná kamera',
}

return templates
