local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} को फॉलो करें',
    ['nav.-.follow.-.distance'] = '{DIRECTION} को {DISTANCE} तक फॉलो करें',
    ['nav.-.follow.-.distance-highway'] = '{HIGHWAY} को {DISTANCE} तक फॉलो करें',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} तक रोड पर चलते रहें',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} को फॉलो करें',
    ['nav.-.follow.-.road'] = 'रोड को फ़ॉलो करें',

    ['nav.-.head.-.-'] = '{ORIENTATION} {DIRECTION} पर आगे बढ़ें',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} यू-टर्न लें {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} {DIRECTION} फेरी लें {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} ताकि {DIRECTION} से मिले {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} ताकि {HIGHWAY} {DIRECTION} से मिले {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} आप अपने {GOAL} {DIRECTION} पर पहुंच जाएंगे। {GOAL} यह {SIDE} होगी',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} आप अपने {GOAL} {DIRECTION} पर पहुंच जाएंगे',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} गोलचक्कर में प्रवेश करें {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} गोलचक्कर पर {TAKE_NTH_EXIT} {DIRECTION} लें {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY} से मिले {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} यू-टर्न लें {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} {DIRECTION} निकास लें {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} फेरी लें {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} {DIRECTION} बने रहें {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} निकास लेने के लिए और {DIRECTION} बने रहें',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} निकास {EXIT} लेने के लिए और {DIRECTION} बने रहें',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {DIRECTION} निकास लेने के लिए {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {DIRECTION} निकास {EXIT} लेने के लिए {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} और {DIRECTION} से मिले {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} और {HIGHWAY} {DIRECTION} से मिले {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'और फिर आप अपने {NEXT_GOAL} {NEXT_DIRECTION} पर पहुंच जाएंगे',
    ['nav.second.enterroundabout.-.-'] = 'और फिर गोलचक्कर में प्रवेश करें',
    ['nav.second.exitroundabout.-.-'] = 'और फिर गोलचक्कर पर {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION} लें',
    ['nav.second.join.-.highway'] = 'और फिर {NEXT_HIGHWAY} से मिले',
    ['nav.second.makeuturn.-.-'] = 'और फिर {IMMEDIATELY} {NEXT_LANDMARK} यू-टर्न लें',
    ['nav.second.takeexit.-.-'] = 'और फिर निकास लें',
    ['nav.second.takeferry.-.-'] = 'और फिर {NEXT_LANDMARK} {NEXT_DIRECTION} फेरी लें',
    ['nav.second.turnkeep.-.-'] = 'और फिर {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'और फिर {IMMEDIATELY} {NEXT_TURN_KEEP} ताकि {NEXT_DIRECTION} बने रहें',
    ['nav.second.turnkeep.toexit.-'] = 'और फिर {IMMEDIATELY} {NEXT_TURN_KEEP} ताकि {NEXT_DIRECTION} निकास लेने के लि',
    ['nav.second.turnkeep.toexit.exit'] = 'और फिर {IMMEDIATELY} {NEXT_TURN_KEEP} ताकि {NEXT_DIRECTION} निकास {NEXT_EXIT} लेने के लि',
    ['nav.second.turnkeep.tojoin.-'] = 'और फिर {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} ताकि {NEXT_DIRECTION} से मिले',
    ['nav.second.turnkeep.tojoin.highway'] = 'और फिर {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} ताकि {NEXT_HIGHWAY} {NEXT_DIRECTION} से मिले',

    ['nav.arrival'] = 'आप अपने {GOAL} पर पहुंच गए हैं',
    ['nav.arrival-side'] = 'आप अपने {GOAL} पर पहुंच गए हैं। यह {SIDE} है',
    ['nav.gpslost'] = 'GPS सिग्नल उपलब्ध नहीं',
    ['nav.gpsrestored'] = 'GPS सिग्नल फिर से उपलब्ध',
    ['nav.newroute'] = 'नए मार्ग का निर्धारण जारी',
    ['nav.speedcamera'] = 'स्पीड कैमरा आगे है',
}

return templates
