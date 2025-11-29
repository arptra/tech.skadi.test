local templates = {
    ['nav.-.follow.-.-'] = 'Pokračujte {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Pokračujte {DIRECTION} {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Pokračujte {DISTANCE} po {HIGHWAY}',
    ['nav.-.follow.-.distance-road'] = 'Pokračujte {DISTANCE} po této silnici',
    ['nav.-.follow.-.highway'] = 'Pokračujte po {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Pokračujte po této silnici',

    ['nav.-.head.-.-'] = 'Pokračujte na {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} se otočte a pokračujte opačným směrem {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} použijte trajekt {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} a vjeďte {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} a vjeďte na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} a poté dojedete do {GOAL} {DIRECTION}. Do {GOAL} se dostanete {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} a poté dojedete do {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} a poté vjeďte na kruhový objezd',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} na kruhovém objezdu {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} a poté vjeďte na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} se otočte a pokračujte opačným směrem {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} sjeďte na výjezdu {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} použijte trajekt {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {LANDMARK} (poté) {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} poté {TURN_KEEP} a pokračujte {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} poté {TURN_KEEP}, sjeďte na výjezdu a pokračujte {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} poté {TURN_KEEP}, sjeďte na výjezdu {EXIT} a pokračujte {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} poté {TURN_KEEP} a sjeďte na výjezdu {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} poté {TURN_KEEP} a sjeďte na výjezdu {EXIT} {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {LANDMARK} (poté) {TURN_KEEP} a vjeďte {DIRECTION}. {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {LANDMARK} (poté) {TURN_KEEP} a vjeďte na {HIGHWAY} {DIRECTION}. {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'a poté dojedete do {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'a poté vjeďte na kruhový objezd',
    ['nav.second.exitroundabout.-.-'] = 'a poté na kruhovém objezdu {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'a vjeďte na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'a poté se {IMMEDIATELY} {NEXT_LANDMARK} otočte a pokračujte opačným směrem',
    ['nav.second.takeexit.-.-'] = 'a poté sjeďte na výjezdu',
    ['nav.second.takeferry.-.-'] = 'a poté {NEXT_LANDMARK} použijte trajekt {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'a poté {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'poté {IMMEDIATELY} {NEXT_TURN_KEEP} a pokračujte {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'poté {IMMEDIATELY} {NEXT_TURN_KEEP} a sjeďte na výjezdu {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'poté {IMMEDIATELY} {NEXT_TURN_KEEP} a sjeďte na výjezdu {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'poté {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} a vjeďte {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'poté {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} a vjeďte na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Dojeli jste do {GOAL}',
    ['nav.arrival-side'] = 'Dojeli jste do {GOAL}. Je {SIDE}',
    ['nav.gpslost'] = 'GPS signál byl ztracen',
    ['nav.gpsrestored'] = 'GPS signál byl obnoven',
    ['nav.newroute'] = 'Vyhledávám novou trasu',
    ['nav.speedcamera'] = 'Před vámi je rychlostní kamera',
}

return templates
