local templates = {
    ['nav.-.follow.-.-'] = 'أُسلُك {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'أُسلُك {DIRECTION} لمسافة {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'أُسلُك {HIGHWAY} لمسافة {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'أُسلُك الطريق لمسافة {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'أُسلُك {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'أُسلُك الطريق',

    ['nav.-.head.-.-'] = 'إِتّجِهْ {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} قم بالدوران لِلخَلف {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} استقل العبارة {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} لتسلك {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} لتسلك {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} ستصل إلى {GOAL} {DIRECTION}. سيكون {GOAL} {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} ستصل إلى {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} ادخل الدوران {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} عند الدوار {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} أُسلُك {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} قم بالدوران لِلخَلف {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} أُسلُك المَخرَج {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} استقل العبارة {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} لتواصل السير {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} لتسلك المَخرَج وتواصل السير {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} لتسلك المَخرَج {EXIT} وتواصل السير {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} لتسلك المَخرَج {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} لتسلك المَخرَج {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} لتسلك {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} لتسلك {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'وستصل إلى {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'ثم ادخل الدوران',
    ['nav.second.exitroundabout.-.-'] = 'ثم {NEXT_TAKE_NTH_EXIT} عند الدوار {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'ثم أُسلُك {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'ثم قم بالدوران لِلخَلف {NEXT_LANDMARK} {IMMEDIATELY}',
    ['nav.second.takeexit.-.-'] = 'ثم أُسلُك المَخرَج',
    ['nav.second.takeferry.-.-'] = 'ثم استقل العبارة {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'ثم {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'ثم {IMMEDIATELY} {NEXT_TURN_KEEP} لتواصل السير {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ' ثم {IMMEDIATELY} {NEXT_TURN_KEEP} لتسلك المَخرَج {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'ثم {IMMEDIATELY} {NEXT_TURN_KEEP} لتسلك المَخرَج {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'ثم {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} لتسلك {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'ثم {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} لتسلك {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'لقد وصلت إلى {GOAL}.',
    ['nav.arrival-side'] = 'لقد وصلت إلى {GOAL}. إنها {SIDE}.',
    ['nav.gpslost'] = 'تم فقد إشارة GPS.',
    ['nav.gpsrestored'] = 'تمت استعادة إشارة GPS.',
    ['nav.newroute'] = 'يتم الآن البحث عن مسار جديد.',
    ['nav.speedcamera'] = 'أمامك كاميرا سرعة.',
}

return templates
