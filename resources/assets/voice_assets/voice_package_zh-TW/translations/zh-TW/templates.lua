local templates = {
    ['nav.-.follow.-.-'] = '沿{DIRECTION}行駛',
    ['nav.-.follow.-.distance'] = '沿{DIRECTION}行駛{DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = '沿{HIGHWAY}行駛{DISTANCE}',
    ['nav.-.follow.-.distance-road'] = '沿道路行駛{DISTANCE}',
    ['nav.-.follow.-.highway'] = '沿{HIGHWAY}行駛',
    ['nav.-.follow.-.road'] = '沿道路行駛',

    ['nav.-.head.-.-'] = '向{ORIENTATION}前往{DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}迴轉{SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}搭乘渡輪{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}{TURN_KEEP}{DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}{TURN_KEEP}行駛至{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}{TURN_KEEP}行駛至{HIGHWAY}{DIRECTION}{SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL}抵達{DIRECTION}上您的{GOAL}。{GOAL}在{SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL}抵達{DIRECTION}上您的{GOAL}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL}進入圓環{SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL}從圓環的{TAKE_NTH_EXIT}{DIRECTION}{SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL}行駛至{HIGHWAY}{SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL}{LANDMARK}迴轉{SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL}到出口{DIRECTION}{SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL}{LANDMARK}搭乘渡輪{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL}{TURN_KEEP}繼續{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL}{TURN_KEEP}到出口並繼續{DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL}{TURN_KEEP}到出口{EXIT}並繼續{DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL}{TURN_KEEP}到出口{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL}{TURN_KEEP}到出口{EXIT}{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}行駛至{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}行駛至{HIGHWAY}{DIRECTION}{SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '即可抵達您的{NEXT_GOAL}{NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = '，然後進入圓環',
    ['nav.second.exitroundabout.-.-'] = '，然後從圓環的{NEXT_TAKE_NTH_EXIT}{NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = '，然後行駛至{NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}迴轉',
    ['nav.second.takeexit.-.-'] = '，然後到出口',
    ['nav.second.takeferry.-.-'] = '，然後{NEXT_LANDMARK}搭乘渡輪{NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}繼續{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}到出口{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}到出口{NEXT_EXIT}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}行駛至{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}行駛至{NEXT_HIGHWAY}{NEXT_DIRECTION}',

    ['nav.arrival'] = '您已抵達{GOAL}',
    ['nav.arrival-side'] = '您已抵達{GOAL}。它在{SIDE}',
    ['nav.gpslost'] = '失去GPS訊號',
    ['nav.gpsrestored'] = 'GPS訊號已恢復',
    ['nav.newroute'] = '正在尋找新路線',
    ['nav.speedcamera'] = '前方有測速照相',
}

return templates
