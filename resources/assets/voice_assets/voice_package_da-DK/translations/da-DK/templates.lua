local templates = {
    ['nav.-.follow.-.-'] = 'Følg {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Følg {DIRECTION} i {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Følg {HIGHWAY} {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Følg vejen {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Følg {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Følg vejen',

    ['nav.-.head.-.-'] = 'Kør mod {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} foretag en U-vending {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} tag færgen {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} for at køre ind på {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} for at køre ind på {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} vil du nå dit {GOAL} {DIRECTION}. {GOAL} vil være {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} vil du nå dit {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} kør ind i rundkørslen {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} i rundkørslen {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} kør ind på {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} foretag en U-vending {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} tag frakørslen {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} tag færgen {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} (nu) {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} (nu) for at fortsætte {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} for at tage frakørslen, og fortsæt {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} for at tage frakørsel {EXIT}, og fortsæt {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} (nu) for at tage frakørslen {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} for at tage frakørsel {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} for at køre ind på {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} (nu) {LANDMARK} for at køre ind på {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', hvorefter du vil nå dit {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', og kør derefter ind i rundkørslen',
    ['nav.second.exitroundabout.-.-'] = ', og derefter {NEXT_TAKE_NTH_EXIT} i rundkørslen {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', og kør derefter ind på {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', og foretag {IMMEDIATELY} derefter en U-vending {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', og tag derefter frakørslen',
    ['nav.second.takeferry.-.-'] = ', og tag derefter færgen {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', og {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION} {IMMEDIATELY} derefter',
    ['nav.second.turnkeep.tocontinue.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} derefter for at fortsætte {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} derefter for at tage frakørslen {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} derefter for at tage frakørsel {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} derefter {NEXT_LANDMARK} for at køre ind på {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} derefter {NEXT_LANDMARK} for at køre ind på {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Du har nået dit {GOAL}',
    ['nav.arrival-side'] = 'Du har nået dit {GOAL}. Det er {SIDE}',
    ['nav.gpslost'] = 'GPS-signal tabt',
    ['nav.gpsrestored'] = 'GPS-signal er gendannet',
    ['nav.newroute'] = 'Finder en ny rute',
    ['nav.speedcamera'] = 'Hastighedskontrol forude',
}

return templates
