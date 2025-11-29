local templates = {
    ['nav.-.follow.-.-'] = 'Продовжуйте рух {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Продовжуйте рух {DIRECTION} ще {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Продовжуйте рух {HIGHWAY} ще {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Продовжуйте рух цією дорогою ще {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Продовжуйте рух {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Продовжуйте рух цією дорогою',

    ['nav.-.head.-.-'] = 'Рухайтеся на {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} зробіть розворот {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} скористайтеся поромом {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, щоб почати рух {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, щоб почати рух {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} ви дістанетесь на {GOAL} {DIRECTION}. {GOAL} буде розташовано {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} ви дістанетесь на {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} виїдьте на кільцеву розв’язку {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} на кільцевій розв’язці поверніть на {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} виїдьте на {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} зробіть розворот {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} поверніть на з’їзд {DIRECTION}} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} скористайтеся поромом {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}, щоб продовжити рух {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, щоб повернути на з’їзд і продовжити рух {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, щоб повернути на з’їзд {EXIT} і продовжити рух {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, щоб повернути на з’їзд {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, щоб повернути на з’їзд {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, щоб почати рух {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, щоб почати рух {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', і потім ви дістанетесь на {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'і потім виїдьте на кільцеву розв’язку',
    ['nav.second.exitroundabout.-.-'] = 'і потім на кільцевій розв’язці поверніть на {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'і потім виїдьте на {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'і потім {IMMEDIATELY} зробіть розворот {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'і потім поверніть на з’їзд',
    ['nav.second.takeferry.-.-'] = 'і потім скористайтеся поромом {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP}, щоб продовжити рух {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP}, щоб повернути на з’їзд {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP}, щоб повернути на з’їзд {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, щоб почати рух {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'і потім {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, щоб почати рух {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Ви дісталися на {GOAL}',
    ['nav.arrival-side'] = 'Ви дісталися на {GOAL}. Воно розташоване {SIDE}',
    ['nav.gpslost'] = 'Сигнал GPS відсутній',
    ['nav.gpsrestored'] = 'Сигнал GPS відновлено',
    ['nav.newroute'] = 'Пошук нового маршруту',
    ['nav.speedcamera'] = 'Попереду камера контролю швидкості',
}

return templates
