local templates = {
    ['nav.-.follow.-.-'] = 'Следвайте {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Следвайте {DIRECTION} в продължение на {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Следвайте {HIGHWAY} в продължение на {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Следвайте пътя в продължение на {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Следвайте {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Следвайте пътя',

    ['nav.-.head.-.-'] = 'Насочете се на {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} направете обратен завой {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} се качете на ферибота {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, за да се включите в {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, за да се включите в {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} ще достигнете вашата {GOAL} {DIRECTION}. Тя ще бъде {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} ще достигнете вашата {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} влезте в кръговото кръстовище {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} на кръговото кръстовище {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} се включете в {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} направете обратен завой {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} поемете към изхода {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} се качете на ферибота {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}, за да продължите {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, за да поемете към изхода и продължете {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, за да поемете към изход изход {EXIT} и продължете {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, за да поемете към изхода {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, за да поемете към изход {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, за да се включите в {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, за да се включите в {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'и след това ще достигнете вашата {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'и след това влезте в кръговото кръстовище',
    ['nav.second.exitroundabout.-.-'] = 'и след това {NEXT_TAKE_NTH_EXIT} на кръговото кръстовище {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'и след това се присъединете към {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'и след това {IMMEDIATELY} направете обратен завой {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'и след това поемете към изхода',
    ['nav.second.takeferry.-.-'] = 'и след това се качете на ферибота {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'и след това {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'и след това {IMMEDIATELY} {NEXT_TURN_KEEP}, за да продължите {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'и след това {IMMEDIATELY} {NEXT_TURN_KEEP}, за да поемете към изхода {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'и след това {IMMEDIATELY} {NEXT_TURN_KEEP}, за да поемете към изход {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'и след това {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP}, за да се включите в {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'и след това {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_TURN_KEEP}, за да се включите в {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Достигнахте вашата {GOAL}.',
    ['nav.arrival-side'] = 'Достигнахте вашата {GOAL}. Тя се намира {SIDE}.',
    ['nav.gpslost'] = 'GPS сигналът е изгубен.',
    ['nav.gpsrestored'] = 'GPS сигналът е възстановен.',
    ['nav.newroute'] = 'Търсене на нов маршрут.',
    ['nav.speedcamera'] = 'Пред вас има пътна камера.',
}

return templates
