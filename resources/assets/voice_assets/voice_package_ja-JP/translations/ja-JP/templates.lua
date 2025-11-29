local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION}進みます',
    ['nav.-.follow.-.distance'] = '{DIRECTION}{DISTANCE}進みます',
    ['nav.-.follow.-.distance-highway'] = '{DISTANCE}、{HIGHWAY}を進みます',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE}、道なりに進みます',
    ['nav.-.follow.-.highway'] = '{HIGHWAY}を進みます',
    ['nav.-.follow.-.road'] = '道なりに進みます',

    ['nav.-.head.-.-'] = '{DIRECTION}を{ORIENTATION}へ進みます',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}ユーターンします',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}{DIRECTION}フェリーに乗ります{SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}{DIRECTION}{TURN_KEEP}します{SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}、{TURN_KEEP}し、{DIRECTION}合流します{SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}、{TURN_KEEP}し、{DIRECTION}{HIGHWAY}に合流します{SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL}{DIRECTION}{GOAL}に到着します。{GOAL}は{SIDE}あります',
    ['nav.interval.arrive.-.-'] = '{INTERVAL}{DIRECTION}{GOAL}に到着します',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL}ラウンドアバウトに入ります{SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL}ラウンドアバウトで{DIRECTION}{TAKE_NTH_EXIT}ます{SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL}{HIGHWAY}に合流します{SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL}{LANDMARK}ユーターンします{SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL}{DIRECTION}出口です{SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL}{LANDMARK}{DIRECTION}フェリーに乗ります{SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL}{LANDMARK}{DIRECTION}{TURN_KEEP}します{SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL}{TURN_KEEP}して{DIRECTION}進みます{SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL}{TURN_KEEP}して{DIRECTION}進みます{SECOND}', -- based on feedback, the original phrase is not expected in Japanese
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL}{TURN_KEEP}して{DIRECTION}進みます{SECOND}', -- based on feedback, the original phrase is not expected in Japanese
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL}{TURN_KEEP}して{DIRECTION}出口です{SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL}{TURN_KEEP}して、{DIRECTION}{EXIT}から出ます{SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}し、{DIRECTION}合流します{SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}し、{DIRECTION}{HIGHWAY}に合流します{SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '、(ARRIVE) {NEXT_DIRECTION}{NEXT_GOAL}に到着します',
    ['nav.second.enterroundabout.-.-'] = '、ラウンドアバウトに入ります',
    ['nav.second.exitroundabout.-.-'] = '、ラウンドアバウトで{NEXT_DIRECTION}{NEXT_TAKE_NTH_EXIT}ます',
    ['nav.second.join.-.highway'] = '、{NEXT_HIGHWAY}に合流します',
    ['nav.second.makeuturn.-.-'] = '、{IMMEDIATELY}{NEXT_LANDMARK}ユーターンします',
    ['nav.second.takeexit.-.-'] = '、出口です',
    ['nav.second.takeferry.-.-'] = '、{NEXT_LANDMARK}{NEXT_DIRECTION}フェリーに乗ります',
    ['nav.second.turnkeep.-.-'] = '、{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_DIRECTION}{AGAIN}{NEXT_TURN_KEEP}します',
    ['nav.second.turnkeep.tocontinue.-'] = '、{IMMEDIATELY}{AGAIN}{NEXT_TURN_KEEP}し、{NEXT_DIRECTION}進みます',
    ['nav.second.turnkeep.toexit.-'] = '、{IMMEDIATELY}{AGAIN}{NEXT_TURN_KEEP}して、{NEXT_DIRECTION}出口です',
    ['nav.second.turnkeep.toexit.exit'] = '、{IMMEDIATELY}{AGAIN}{NEXT_TURN_KEEP}して、{NEXT_DIRECTION}{NEXT_EXIT}から出ます',
    ['nav.second.turnkeep.tojoin.-'] = '、{IMMEDIATELY}{NEXT_LANDMARK}{AGAIN}{NEXT_TURN_KEEP}して、{NEXT_DIRECTION}合流します',
    ['nav.second.turnkeep.tojoin.highway'] = '、{IMMEDIATELY}{NEXT_LANDMARK}{AGAIN}{NEXT_TURN_KEEP}して、{NEXT_DIRECTION}{NEXT_HIGHWAY}に合流します',

    ['nav.arrival'] = '{GOAL}に到着しました',
    ['nav.arrival-side'] = '{GOAL}に到着しました。{SIDE}あります',
    ['nav.gpslost'] = 'ジーピーエス信号が失われました',
    ['nav.gpsrestored'] = 'ジーピーエス信号が回復しました',
    ['nav.newroute'] = '新しいルートを探しています',
    ['nav.speedcamera'] = '前方に速度取締機があります',
}

return templates
