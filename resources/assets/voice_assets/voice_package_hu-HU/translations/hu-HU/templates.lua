local templates = {
    ['nav.-.follow.-.-'] = 'Kövesse {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Haladjon {DIRECTION}, {DISTANCE} keresztül',
    ['nav.-.follow.-.distance-highway'] = 'Haladjon {HIGHWAY} {DISTANCE} keresztül',
    ['nav.-.follow.-.distance-road'] = 'Kövesse az utat {DISTANCE} keresztül',
    ['nav.-.follow.-.highway'] = 'Haladjon az {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Kövesse az utat',

    ['nav.-.head.-.-'] = 'Tartson {ORIENTATION} irányába {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} forduljon meg',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} hajtson fel a kompra {DIRECTION}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, és haladjon tovább {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, és haladjon tovább {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} eléri {GOAL} {DIRECTION} mely a {SIDE} van',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} eléri {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} hajtson be a körforgalomba {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} a körforgalomban {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} haladjon tovább {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} forduljon meg {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} hajtson ki {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} hajtson fel a kompra {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP}, és haladjon tovább {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} és hajtson ki, majd haladjon {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} és hajtson ki a {EXIT} kijáraton, majd haladjon {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} és hajtson ki {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} és hajtson ki a {EXIT} kijáraton {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, és haladjon tovább {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, és haladjon tovább {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', majd eléri {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', majd hajtson be a körforgalomba',
    ['nav.second.exitroundabout.-.-'] = ', majd {NEXT_TAKE_NTH_EXIT} a körforgalomban {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', majd haladjon tovább {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', majd {IMMEDIATELY} forduljon meg {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', majd hajtson ki',
    ['nav.second.takeferry.-.-'] = ', majd hajtson fel a kompra {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP}, és haladjon tovább {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP}, majd hajtson ki {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP}, és hajtson ki a {NEXT_EXIT} kijáraton {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, és haladjon tovább {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', majd {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, és haladjon tovább {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Elérte {GOAL}',
    ['nav.arrival-side'] = 'Elérte {GOAL} mely a {SIDE} van',
    ['nav.gpslost'] = 'A GPS-jel megszűnt',
    ['nav.gpsrestored'] = 'A GPS-jel helyreállt',
    ['nav.newroute'] = 'Új útvonal keresése',
    ['nav.speedcamera'] = 'Traffipax következik',
}

return templates
