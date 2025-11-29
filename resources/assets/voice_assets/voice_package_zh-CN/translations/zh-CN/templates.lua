local templates = {
    ['nav.-.follow.-.-'] = '沿{DIRECTION}行驶',
    ['nav.-.follow.-.distance'] = '沿{DIRECTION}行驶{DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = '沿{HIGHWAY}行驶{DISTANCE}',
    ['nav.-.follow.-.distance-road'] = '沿道路行驶{DISTANCE}',
    ['nav.-.follow.-.highway'] = '沿{HIGHWAY}行驶',
    ['nav.-.follow.-.road'] = '沿道路行驶',

    ['nav.-.head.-.-'] = '向{ORIENTATION}{DIRECTION}行驶',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}调头{SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}搭乘{DIRECTION}的轮渡{SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}{TURN_KEEP}{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}{TURN_KEEP}进入{DIRECTION}{SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}{TURN_KEEP}进入{HIGHWAY}{DIRECTION}{SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL}将达到{DIRECTION}的{GOAL}。{GOAL}{SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL}将达到{DIRECTION}的{GOAL}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL}进入转盘{SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL}在转盘{TAKE_NTH_EXIT}{DIRECTION}{SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL}进入{HIGHWAY}{SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL}{LANDMARK}调头{SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL}走{DIRECTION}出口{SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL}{LANDMARK}搭乘轮渡{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL}{TURN_KEEP}继续{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL}{TURN_KEEP}走出口，然后继续{DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL}{TURN_KEEP}走{EXIT}出口，然后继续{DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL}{TURN_KEEP}走{DIRECTION}出口{SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL}{TURN_KEEP}走{EXIT}{DIRECTION}出口{SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}进入{DIRECTION}{SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL}{LANDMARK}{TURN_KEEP}进入{DIRECTION}{HIGHWAY}{SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '，然后将到达{NEXT_DIRECTION}的{NEXT_GOAL}',
    ['nav.second.enterroundabout.-.-'] = '，然后进入转盘',
    ['nav.second.exitroundabout.-.-'] = '，然后在转盘{NEXT_TAKE_NTH_EXIT}{NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = '，然后进入{NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = '，然后{IMMEDIATELY}{NEXT_LANDMARK}调头',
    ['nav.second.takeexit.-.-'] = '，然后走出口',
    ['nav.second.takeferry.-.-'] = '，然后{NEXT_LANDMARK}搭乘轮渡{NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = '，然后{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = '，然后{IMMEDIATELY}{NEXT_TURN_KEEP}，继续{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = '，然后{IMMEDIATELY}{NEXT_TURN_KEEP}走{NEXT_DIRECTION}出口',
    ['nav.second.turnkeep.toexit.exit'] = '，然后{IMMEDIATELY}{NEXT_TURN_KEEP}走{NEXT_EXIT}{NEXT_DIRECTION}出口',
    ['nav.second.turnkeep.tojoin.-'] = '，然后{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}进入{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = '，然后{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_TURN_KEEP}进入{NEXT_HIGHWAY}{NEXT_DIRECTION}',

    ['nav.arrival'] = '您已到达{GOAL}',
    ['nav.arrival-side'] = '您已到达{GOAL}，就{SIDE}',
    ['nav.gpslost'] = '失去GPS信号',
    ['nav.gpsrestored'] = 'GPS信号已恢复',
    ['nav.newroute'] = '正在查找新路线',
    ['nav.speedcamera'] = '前方有测速摄像头',
}

return templates
