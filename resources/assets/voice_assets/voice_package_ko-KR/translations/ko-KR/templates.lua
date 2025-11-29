local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} 계속 가십시오',
    ['nav.-.follow.-.distance'] = '{DIRECTION} {DISTANCE} 계속 가십시오',
    ['nav.-.follow.-.distance-highway'] = '{HIGHWAY}를 따라 {DISTANCE} 계속 가십시오',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} 동안 계속 진행합니다',
    ['nav.-.follow.-.highway'] = '{HIGHWAY}를 따라 계속 가세요',
    ['nav.-.follow.-.road'] = '도로를 따라 계속 가세요',

    ['nav.-.head.-.-'] = '{DIRECTION} {ORIENTATION} (으)로 가세요',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} U턴하십시오 {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} {DIRECTION} 페리를 타십시오 {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION}. {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}. 그리고 {DIRECTION} 진입하십시오 {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}. 그리고 {DIRECTION} {HIGHWAY}에 진입하십시오 {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} {DIRECTION} {GOAL}에 도착할 것입니다. {GOAL}는 {SIDE}에 있습니다',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} {DIRECTION} {GOAL}에 도착할 것입니다',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} 회전교차로에 진입하십시오 {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} 회전교차로에서 {DIRECTION} {TAKE_NTH_EXIT} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY}에 진입하십시오 {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} U턴하십시오 {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} {DIRECTION} 출구로 나가십시오 {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} 페리를 타십시오 {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} {TURN_KEEP}. {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} {DIRECTION} 따라 계속 주행하십시오. {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} 따라 출구로 나간 다음, {DIRECTION} 따라 계속 주행하십시오.',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} 따라 {EXIT} 출구로 나간 다음, {DIRECTION} 따라 계속 주행하십시오.',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}. 그리고 {DIRECTION} 출구로 나가십시오 {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}. 그리고 {DIRECTION} {EXIT} 출구로 나가십시오 {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {LANDMARK} {TURN_KEEP}. 그리고 {DIRECTION} 진입하십시오 {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {LANDMARK} {TURN_KEEP}. 그리고 {DIRECTION} {HIGHWAY}에 진입하십시오 {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = '그러면 {NEXT_DIRECTION} {NEXT_GOAL}에 도착할 것입니다',
    ['nav.second.enterroundabout.-.-'] = '그런 다음 회전교차로로 진입하십시오',
    ['nav.second.exitroundabout.-.-'] = '그런 다음 회전교차로에서 {NEXT_DIRECTION} {NEXT_TAKE_NTH_EXIT}',
    ['nav.second.join.-.highway'] = '그런 다음 {NEXT_HIGHWAY}에 진입하십시오',
    ['nav.second.makeuturn.-.-'] = '그런 다음 {NEXT_LANDMARK} {IMMEDIATELY} U턴하십시오',
    ['nav.second.takeexit.-.-'] = '그런 다음 출구로 나가십시오',
    ['nav.second.takeferry.-.-'] = '그런 다음 {NEXT_DIRECTION} 페리를 타십시오',
    ['nav.second.turnkeep.-.-'] = '그런 다음 {NEXT_LANDMARK} {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = '그런 다음 {IMMEDIATELY} {NEXT_DIRECTION} 계속 {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.-'] = '그런 다음 {IMMEDIATELY} {NEXT_TURN_KEEP}. 그리고 {NEXT_DIRECTION} 출구로 나가십시오.',
    ['nav.second.turnkeep.toexit.exit'] = '그런 다음 {IMMEDIATELY} {NEXT_TURN_KEEP}. 그리고 {NEXT_DIRECTION} {NEXT_EXIT} 출구로 나가십시오',
    ['nav.second.turnkeep.tojoin.-'] = '그런 다음 {NEXT_LANDMARK} {IMMEDIATELY} {NEXT_TURN_KEEP}. 그리고 {NEXT_DIRECTION} 진입하십시오',
    ['nav.second.turnkeep.tojoin.highway'] = '그런 다음 {NEXT_LANDMARK} {IMMEDIATELY} {NEXT_TURN_KEEP}. 그리고 {NEXT_DIRECTION} {NEXT_HIGHWAY}에 진입하십시오',

    ['nav.arrival'] = '{GOAL}에 도착했습니다',
    ['nav.arrival-side'] = '{GOAL}에 도착했습니다. {SIDE} 있습니다',
    ['nav.gpslost'] = 'GPS 신호가 끊겼습니다',
    ['nav.gpsrestored'] = 'GPS 신호가 복원되었습니다',
    ['nav.newroute'] = '새 경로를 찾는 중입니다',
    ['nav.speedcamera'] = '속도 카메라가 전방에 있습니다',
}

return templates
