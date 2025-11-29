local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} এ চলুন',
    ['nav.-.follow.-.distance'] = '{DIRECTION} {DISTANCE} এ চলুন',
    ['nav.-.follow.-.distance-highway'] = '{HIGHWAY} {DISTANCE} চলুন',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} রাস্তা ধরে চলুন',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} চলুন',
    ['nav.-.follow.-.road'] = 'রাস্তা ধরে চলুন',

    ['nav.-.head.-.-'] = '{ORIENTATION} {DIRECTION} এ চলুন',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} এ U-টার্ন নিন {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} এ ফেরি নিন {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} এ {TURN_KEEP} {DIRECTION} নিন {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} যেতে {TURN_KEEP} এ {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} এ {TURN_KEEP}, {HIGHWAY} {DIRECTION} এ উঠুন {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} আপনি আপনার {GOAL} {DIRECTION} পৌঁছাবেন। {GOAL} {SIDE} পড়বে',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} আপনি আপনার {GOAL} {DIRECTION} পৌঁছাবেন',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} গোল চত্বরে ঢুকুন {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT}, গিয়ে গোল চত্বরে ঢুকুন {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY} উঠুন {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} এ U-টার্ন নিন {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} {DIRECTION} দিকে বেরিয়ে যান {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} এ {DIRECTION} এ ফেরি নিন {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP}, {LANDMARK} এ {DIRECTION} এ যান {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} যেতে {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, বেরিয়ে {DIRECTION} এ যান',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, {EXIT}, গিয়ে বেরিয়ে {DIRECTION} এ যান',
    ['nav.interval.turnkeep.toexit.-'] = 'বেরিয়ে যেতে  {INTERVAL} {TURN_KEEP} {DIRECTION} এ যান {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{EXIT} এ বেরিয়ে যেতে {INTERVAL} {TURN_KEEP} {DIRECTION} এ যান {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{DIRECTION} এ যেতে {INTERVAL} {TURN_KEEP}, {LANDMARK} এ আসুন {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{HIGHWAY} {DIRECTION} এ যেতে {INTERVAL} {TURN_KEEP}, {LANDMARK} এ আসুন {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', তারপর আপনি আপনার {NEXT_GOAL} {NEXT_DIRECTION} এ পৌঁছাবেন',
    ['nav.second.enterroundabout.-.-'] = ', তারপর গোল চত্বরে ঢুকুন',
    ['nav.second.exitroundabout.-.-'] = ', তারপর গোল চত্বরে {NEXT_DIRECTION} এ {NEXT_TAKE_NTH_EXIT}',
    ['nav.second.join.-.highway'] = ', তারপর {NEXT_HIGHWAY} উঠুন',
    ['nav.second.makeuturn.-.-'] = ', তারপর {IMMEDIATELY} {NEXT_LANDMARK} এ U-টার্ন নিন',
    ['nav.second.takeexit.-.-'] = ', তারপর বেরিয়ে যান',
    ['nav.second.takeferry.-.-'] = ', তারপর {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION} এ ফেরি নিন',
    ['nav.second.turnkeep.-.-'] = ', তারপর {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} এ {NEXT_DIRECTION} এ যান',
    ['nav.second.turnkeep.tocontinue.-'] = ', {NEXT_DIRECTION} এ যেতে, তারপর {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.-'] = ', {NEXT_DIRECTION} এ বেরিয়ে যেতে, তারপর {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.exit'] = '{NEXT_EXIT}, গিয়ে {NEXT_DIRECTION} এ বেরিয়ে যেতে, তারপর {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tojoin.-'] = '{NEXT_DIRECTION} এ যেতে, তারপর {IMMEDIATELY} {NEXT_TURN_KEEP}, {NEXT_LANDMARK} এ যান',
    ['nav.second.turnkeep.tojoin.highway'] = '{NEXT_HIGHWAY} {NEXT_DIRECTION} এ যেতে, তারপর {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} এ যান',

    ['nav.arrival'] = 'আপনি আপনার {GOAL} পৌঁছেছেন',
    ['nav.arrival-side'] = 'আপনি আপনার {GOAL} পৌঁছেছেন। সেটা {SIDE}',
    ['nav.gpslost'] = 'GPS সিগ্নাল হারিয়েছে',
    ['nav.gpsrestored'] = 'GPS সিগ্নাল ফিরেছে',
    ['nav.newroute'] = 'নতুন রুট খুঁজছি',
    ['nav.now.join.-.highway.-.-.-'] = 'এখন {HIGHWAY} উঠুন',
    ['nav.speedcamera'] = 'সামনে স্পীড ক্যামেরা',
}

return templates
