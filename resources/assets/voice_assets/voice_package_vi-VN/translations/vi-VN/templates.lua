local templates = {
    ['nav.-.follow.-.-'] = 'Đi theo {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Đi theo {DIRECTION} {DISTANCE} nữa',
    ['nav.-.follow.-.distance-highway'] = 'Tiếp tục đi theo {HIGHWAY} {DISTANCE} nữa',
    ['nav.-.follow.-.distance-road'] = 'Tiếp tục đi theo đường này {DISTANCE} nữa',
    ['nav.-.follow.-.highway'] = 'Tiếp tục đi theo {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Tiếp tục đi theo đường này',

    ['nav.-.head.-.-'] = 'Đi theo hướng {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK}, vòng ngược lại {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK}, lên phà {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK}, {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK}, {TURN_KEEP} để vào {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK}, {TURN_KEEP} để vào {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} bạn sẽ đến {GOAL} {DIRECTION}. {GOAL} sẽ ở {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} bạn sẽ đến {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} đi vào vòng xuyến {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} tại vòng xuyến {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} vào {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} vòng ngược lại {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} đi theo lối ra {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} lên phà {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} để đi tiếp {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} để đi theo lối ra và đi tiếp {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} để đi theo lối ra {EXIT} và đi tiếp {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} để đi theo lối ra {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} để đi theo lối ra {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} để vào {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} để vào {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', sau đó bạn sẽ đến {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', sau đó đi vào vòng xuyến',
    ['nav.second.exitroundabout.-.-'] = ', sau đó {NEXT_TAKE_NTH_EXIT} tại vòng xuyến {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', sau đó nhập vào {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', sau đó vòng ngược lại {IMMEDIATELY} {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', sau đó đi theo lối ra',
    ['nav.second.takeferry.-.-'] = ', sau đó lên phà {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} để đi tiếp {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} để đi theo lối ra {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} để đi theo lối ra {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} để vào {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', sau đó {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} để vào {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Bạn đã đến {GOAL}',
    ['nav.arrival-side'] = 'Bạn đã đến {GOAL}. {GOAL} ở {SIDE}',
    ['nav.gpslost'] = 'Mất tín hiệu GPS',
    ['nav.gpsrestored'] = 'Đã khôi phục tín hiệu GPS',
    ['nav.newroute'] = 'Đang tìm tuyến đường mới',
    ['nav.speedcamera'] = 'Chú ý, camera bắn tốc độ ở phía trước',
}

return templates
