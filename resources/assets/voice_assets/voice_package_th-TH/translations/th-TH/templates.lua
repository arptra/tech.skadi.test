local templates = {
    ['nav.-.follow.-.-'] = 'ไปตาม{DIRECTION}',
    ['nav.-.follow.-.distance'] = 'ไปตาม{DIRECTION} เป็นระยะทาง{DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'ไปตาม{HIGHWAY}เป็นระยะทาง{DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'ไปตามถนนเป็นระยะทาง{DISTANCE}',
    ['nav.-.follow.-.highway'] = 'ไปตาม{HIGHWAY}',
    ['nav.-.follow.-.road'] = 'ไปตามถนน',

    ['nav.-.head.-.-'] = 'มุ่งหน้าไป{ORIENTATION}{DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}กลับรถ {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}ขึ้นเรือเฟอร์รี่{DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}{TURN_KEEP}{DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}{TURN_KEEP}เพื่อเข้า{DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}{TURN_KEEP}เพื่อเข้า{HIGHWAY}{DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} คุณจะไปถึง{GOAL}{DIRECTION} {GOAL}จะอยู่{SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} คุณจะไปถึง{GOAL}{DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} เข้าวงเวียน {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT}ที่วงเวียน{DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} เข้า{HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} กลับรถ{LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} ใช้ทางออก{DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ขึ้นเรือเฟอร์รี่{LANDMARK}{DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP}{LANDMARK}{DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}เพื่อไปต่อ{DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}เพื่อใช้ทางออกและไปต่อ{DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}เพื่อใช้ทางออก{EXIT} และไปต่อ{DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}เพื่อใช้ทางออก{DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}เพื่อใช้ทางออก{EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP}{LANDMARK}เพื่อเข้า{DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP}{LANDMARK}เพื่อเข้า{HIGHWAY}{DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'แล้วคุณจะไปถึง{NEXT_GOAL}{NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'แล้วเข้าวงเวียน',
    ['nav.second.exitroundabout.-.-'] = 'แล้ว{NEXT_TAKE_NTH_EXIT}ที่วงเวียน{NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'แล้วเข้า{NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'แล้วกลับรถ{IMMEDIATELY}{NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'แล้วใช้ทางออก',
    ['nav.second.takeferry.-.-'] = 'แล้วขึ้นเรือเฟอร์รี่{NEXT_LANDMARK}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}{NEXT_LANDMARK}{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}เพื่อไปต่อ{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}เพื่อใช้ทางออก{NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}เพื่อใช้ทางออก{NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}{NEXT_LANDMARK}เพื่อเข้า{NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'แล้ว{NEXT_TURN_KEEP}{IMMEDIATELY}{NEXT_LANDMARK}เพื่อเข้า{NEXT_HIGHWAY}{NEXT_DIRECTION}',

    ['nav.arrival'] = 'คุณถึง{GOAL}',
    ['nav.arrival-side'] = 'คุณถึง{GOAL} {GOAL}อยู่{SIDE}',
    ['nav.gpslost'] = 'สัญญาณGPS สูญหาย',
    ['nav.gpsrestored'] = 'สัญญาณGPS กลับมาแล้ว',
    ['nav.newroute'] = 'ค้นหาเส้นทางใหม่',
    ['nav.speedcamera'] = 'ข้างหน้ามีกล้องจับความเร็ว',
}

return templates
