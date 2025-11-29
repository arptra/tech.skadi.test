local templates = {
    ['nav.-.follow.-.-'] = 'Ikuti {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Ikuti {DIRECTION} sejauh {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Ikuti {HIGHWAY} sejauh {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Ikuti jalan sejauh {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Ikuti {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Ikuti jalan',

    ['nav.-.head.-.-'] = 'Kemudi {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} putar balik {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} naik feri {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} untuk masuk ke {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} untuk masuk ke {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} Anda akan tiba di {GOAL} {DIRECTION}. {GOAL} berada {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} Anda akan tiba di {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} masuk ke bundaran {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} di bundaran {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} masuk ke {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} putar balik {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} ambil jalur keluar {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} naik feri {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} untuk lanjut {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} untuk mengambil jalur keluar, dan terus lanjut {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} untuk mengambil pintu keluar {EXIT} dan terus lanjut {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} untuk mengambil jalur keluar {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} untuk mengambil pintu keluar {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} untuk masuk ke {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} untuk masuk ke {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', dan Anda akan tiba di {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', lalu masuk ke bundaran',
    ['nav.second.exitroundabout.-.-'] = ', lalu {NEXT_TAKE_NTH_EXIT} di bundaran {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', lalu masuk ke {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', lalu putar balik {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', lalu ambil jalur keluar',
    ['nav.second.takeferry.-.-'] = ', lalu naik feri {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', lalu {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', lalu {NEXT_TURN_KEEP} untuk terus lanjut {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', lalu {NEXT_TURN_KEEP} untuk mengambil jalur keluar {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', lalu {NEXT_TURN_KEEP} untuk mengambil pintu keluar {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', lalu {NEXT_TURN_KEEP} {NEXT_LANDMARK} untuk masuk ke {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', lalu {NEXT_TURN_KEEP} {NEXT_LANDMARK} untuk masuk ke {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Anda telah tiba di {GOAL}',
    ['nav.arrival-side'] = 'Anda telah tiba di {GOAL}. Posisinya {SIDE}',
    ['nav.gpslost'] = 'Sinyal GPS terputus',
    ['nav.gpsrestored'] = 'Sinyal GPS tersambung',
    ['nav.newroute'] = 'Mencari rute baru',
    ['nav.speedcamera'] = 'Awas, kamera kecepatan',
}

return templates
