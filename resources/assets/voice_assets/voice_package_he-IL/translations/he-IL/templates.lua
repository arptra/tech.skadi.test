local templates = {
    ['nav.-.follow.-.-'] = 'סע ב-{DIRECTION}',
    ['nav.-.follow.-.distance'] = 'סע ב-{DIRECTION} מרחק של {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'סע ב-{HIGHWAY} מרחק של {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'המשך בכביש למשך {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'סע ב-{HIGHWAY}',
    ['nav.-.follow.-.road'] = 'סע בכביש',

    ['nav.-.head.-.-'] = 'סע {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} פנה פניית פרסה {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} עלה על המעבורת {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} כדי לעלות על {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} כדי לעלות על {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} תגיע אל {GOAL} {DIRECTION}. {GOAL} יהיה {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} תגיע אל {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} היכנס לכיכר {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} בכיכר {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} עלה על {HIGHWAY}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} פנה פניית פרסה {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} צא ביציאה {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} עלה על המעבורת {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} כדי להמשיך {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} כדי לצאת ביציאה והמשך {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} כדי לצאת ביציאה {EXIT} והמשך {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} כדי לצאת ביציאה {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} כדי לצאת ביציאה {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} כדי לעלות על {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {TURN_KEEP} {LANDMARK} כדי לעלות על {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'ואז תגיע אל {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'ואז היכנס לכיכר',
    ['nav.second.exitroundabout.-.-'] = 'ואז {NEXT_TAKE_NTH_EXIT} בכיכר {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'ואז עלה על {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'ואז פנה פניית פרסה {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'ואז צא ביציאה',
    ['nav.second.takeferry.-.-'] = 'ואז עלה על המעבורת {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} כדי להמשיך {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} כדי לצאת ביציאה {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} כדי לצאת ביציאה {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} כדי לעלות על {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'ואז {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} כדי לעלות על {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'הגעת אל {GOAL}',
    ['nav.arrival-side'] = 'הגעת אל {GOAL}. הוא {SIDE}',
    ['nav.gpslost'] = 'אין אות GPS',
    ['nav.gpsrestored'] = 'אות GPS חזר',
    ['nav.newroute'] = 'מוצא מסלול חדש',
    ['nav.speedcamera'] = 'מכמונת מהירות לפניך',
}

return templates
