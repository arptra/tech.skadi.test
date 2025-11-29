local templates = {
    ['nav.-.follow.-.-'] = 'Продолжайте движение {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Продолжайте движение {DIRECTION} еще {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Продолжайте двигаться по {HIGHWAY} еще {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Продолжайте двигаться по дороге еще {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Продолжайте двигаться по {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Продолжайте двигаться по дороге',

    ['nav.-.head.-.-'] = 'Двигайтесь на {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} развернитесь {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} воспользуйтесь паромом {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, чтобы начать движение {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, чтобы начать движение по {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} вы прибудете на {GOAL} {DIRECTION}. {GOAL} находится {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} вы прибудете на {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} въедьте на круговой перекресток {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} на круговом перекрестке поверните на {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} начните движение по {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} развернитесь {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} поверните на съезд {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} воспользуйтесь паромом {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} и продолжайте движение {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, чтобы повернуть на съезд и продолжайте движение {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, чтобы повернуть на съезд {EXIT} и продолжайте движение {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, чтобы повернуть на съезд {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, чтобы повернуть на съезд {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, чтобы начать движение {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, чтобы начать движение по {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', и вы прибудете на {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', а затем въедьте на круговой перекресток',
    ['nav.second.exitroundabout.-.-'] = ', а затем на круговом перекрестке поверните на {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', а затем начните движение по {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', а затем {IMMEDIATELY} развернитесь {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', а затем поверните на съезд',
    ['nav.second.takeferry.-.-'] = ', а затем воспользуйтесь паромом {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP}, чтобы продолжить движение {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP}, чтобы повернуть на съезд {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP}, чтобы повернуть на съезд {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, чтобы начать движение {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', а затем {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, чтобы начать движение по {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Вы прибыли на {GOAL}',
    ['nav.arrival-side'] = 'Вы прибыли на {GOAL}. оно находится {SIDE}',
    ['nav.gpslost'] = 'GPS-сигнал потерян',
    ['nav.gpsrestored'] = 'GPS-сигнал восстановлен',
    ['nav.newroute'] = 'Поиск нового маршрута',
    ['nav.speedcamera'] = 'Впереди камера контроля скорости',
}

return templates
