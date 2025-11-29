local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} istikametini takip edin',
    ['nav.-.follow.-.distance'] = '{DISTANCE} boyunca {DIRECTION} istikametini takip edin',
    ['nav.-.follow.-.distance-highway'] = '{DISTANCE} boyunca {HIGHWAY} yolunu takip edin',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} boyunca yolu takip edin',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} yolunu takip edin',
    ['nav.-.follow.-.road'] = 'Yolu takip edin',

    ['nav.-.head.-.-'] = '{DIRECTION} {ORIENTATION} yönüne gidin',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} U dönüşü yapın {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} {DIRECTION} feribota binin {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {DIRECTION} {TURN_KEEP} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {DIRECTION} istikametine girmek için {TURN_KEEP} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {DIRECTION} {HIGHWAY} yoluna girmek için {TURN_KEEP} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} {DIRECTION} {GOAL} hedefinize ulaşacaksınız. {GOAL} hedefi {SIDE} olacak',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} y{DIRECTION} {GOAL} hedefinize ulaşacaksınız',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} döner kavşağa girin {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} döner kavşakta {DIRECTION} {TAKE_NTH_EXIT} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY} yoluna girin {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} U dönüşü yapın {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} {DIRECTION} çıkıştan çıkın {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} feribota binin {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {DIRECTION} yönünde devam etmek için {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} çıkıştan çıkmak için {TURN_KEEP} ve {DIRECTION} istikametine devam edin',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {EXIT} çıkışından çıkmak için {TURN_KEEP} ve {DIRECTION} istikametine devam edin',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {DIRECTION} çıkıştan çıkmak için {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {DIRECTION} {EXIT} çıkışından çıkmak için {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} istikametine girmek için {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {LANDMARK} {DIRECTION} {HIGHWAY} yoluna girmek için {TURN_KEEP} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 've daha sonra {NEXT_DIRECTION} {NEXT_GOAL} hedefinize ulaşacaksınız',
    ['nav.second.enterroundabout.-.-'] = 've daha sonra döner kavşağa girin',
    ['nav.second.exitroundabout.-.-'] = 've daha sonra {NEXT_DIRECTION} döner kavşakta {NEXT_TAKE_NTH_EXIT}',
    ['nav.second.join.-.highway'] = 've daha sonra {NEXT_HIGHWAY} yoluna girin',
    ['nav.second.makeuturn.-.-'] = 've (daha) {IMMEDIATELY} sonra {NEXT_LANDMARK} U dönüşü yapın',
    ['nav.second.takeexit.-.-'] = 've ardından çıkıştan çıkın',
    ['nav.second.takeferry.-.-'] = 've daha sonra {NEXT_LANDMARK} {NEXT_DIRECTION} feribota binin',
    ['nav.second.turnkeep.-.-'] = 've (daha) {IMMEDIATELY} sonra {NEXT_LANDMARK} {NEXT_DIRECTION} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tocontinue.-'] = 've {IMMEDIATELY} sonra {NEXT_DIRECTION} istikametinde devam etmek için {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.-'] = 've (daha) {IMMEDIATELY} sonra {NEXT_DIRECTION} çıkıştan çıkmak için {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.exit'] = 've (daha) {IMMEDIATELY} sonra {NEXT_DIRECTION} {NEXT_EXIT} çıkışından çıkmak için {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tojoin.-'] = 've (daha) {IMMEDIATELY} sonra {NEXT_LANDMARK} {NEXT_DIRECTION} istikametine girmek için {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tojoin.highway'] = 've (daha) {IMMEDIATELY} sonra {NEXT_LANDMARK} {NEXT_DIRECTION} {NEXT_HIGHWAY} yoluna girmek için {NEXT_TURN_KEEP}',

    ['nav.arrival'] = '{GOAL} hedefinize ulaştınız',
    ['nav.arrival-side'] = '{SIDE} bulunan {GOAL} hedefinize ulaştınız',
    ['nav.gpslost'] = 'GPS sinyali kayboldu',
    ['nav.gpsrestored'] = 'GPS sinyali tekrar alındı',
    ['nav.newroute'] = 'Yeni güzergah aranıyor',
    ['nav.speedcamera'] = 'İleride hız kamerası var',
}

return templates
