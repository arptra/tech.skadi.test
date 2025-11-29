local templates = {
    ['nav.-.follow.-.-'] = '沿住{DIRECTION}行駛',
    ['nav.-.follow.-.distance'] = '沿住{DIRECTION}行駛{DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = '沿住{HIGHWAY}行駛{DISTANCE}',
    ['nav.-.follow.-.distance-road'] = '沿住道路行駛{DISTANCE}',
    ['nav.-.follow.-.highway'] = '沿住{HIGHWAY}行駛',
    ['nav.-.follow.-.road'] = '沿住道路行駛',

    ['nav.-.head.-.-'] = '向{ORIENTATION}行駛{DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}掉頭{SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}乘搭渡海小輪{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}{TURN_KEEP}{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}{TURN_KEEP}駛入{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}{TURN_KEEP}駛入{HIGHWAY}{DIRECTION}{SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL}就會到達{GOAL}{DIRECTION}。{GOAL}會{SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL}就會到達{GOAL}{DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL}進入迴旋處{SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL}喺迴旋處{TAKE_NTH_EXIT}駛出{DIRECTION}{SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL}駛入{HIGHWAY}{SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL}{LANDMARK}掉頭{SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL}喺{DIRECTION}出口離開{SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL}{LANDMARK}乘搭渡海小輪{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL}{TURN_KEEP}繼續{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL}{TURN_KEEP}喺出口離開，然後繼續{DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL}{TURN_KEEP}喺{EXIT}出口離開，然後繼續{DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL}{TURN_KEEP}喺{DIRECTION}出口離開{SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL}{TURN_KEEP}喺{EXIT}{DIRECTION}出口離開{SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}駛入{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}駛入{HIGHWAY}{DIRECTION}{SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '，然後就會到達{NEXT_GOAL}{NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = '，然後進入迴旋處',
    ['nav.second.exitroundabout.-.-'] = '，然後喺迴旋處{NEXT_TAKE_NTH_EXIT}駛出{NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = '，然後駛入{NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}掉頭',
    ['nav.second.takeexit.-.-'] = '，然後喺出口離開',
    ['nav.second.takeferry.-.-'] = '，然後{NEXT_LANDMARK}乘搭渡海小輪{NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}繼續{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}喺{NEXT_DIRECTION}出口離開',
    ['nav.second.turnkeep.toexit.exit'] = '，然後{IMMEDIATELY}{NEXT_TURN_KEEP}喺{NEXT_EXIT}{NEXT_DIRECTION}出口離開',
    ['nav.second.turnkeep.tojoin.-'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}駛入{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = '，然後{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}駛入{NEXT_HIGHWAY}{NEXT_DIRECTION}',

    ['nav.arrival'] = '你已到達{GOAL}',
    ['nav.arrival-side'] = '你已到達{GOAL}，就{SIDE}',
    ['nav.gpslost'] = '無GPS訊號',
    ['nav.gpsrestored'] = 'GPS訊號已經恢復',
    ['nav.newroute'] = '正喺度搵緊新嘅路線',
    ['nav.speedcamera'] = '前面有快相機',
}

return templates
