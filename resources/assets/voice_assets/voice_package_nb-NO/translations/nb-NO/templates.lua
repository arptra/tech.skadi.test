local templates = {
    ['nav.-.follow.-.-'] = 'Følg {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Følg {DIRECTION} i {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Følg {HIGHWAY} i {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Følg veien i {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Følg {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Følg veien',

    ['nav.-.head.-.-'] = 'Kjør {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = 'ta en u-sving {LANDMARK} {SECOND}',
    ['nav.landmark.takeferry.-.-'] = 'ta fergen {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{TURN_KEEP} {LANDMARK} for å kjør inn på {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{TURN_KEEP} {LANDMARK} for å kjør inn på {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} vil du komme frem til {GOAL} {DIRECTION}. {GOAL} vil være {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} vil du komme frem til {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} kjør inn i rundkjøringen {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} i rundkjøringen {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} kjør inn på {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} ta en u-sving {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} ta avkjøringen {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ta fergen {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} for å fortsette {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} for å ta avkjøringen og fortsett {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} for å ta avkjøring {EXIT} og fortsett {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} for å ta avkjøringen {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} for å ta avkjøring {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} for å kjør inn på {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} for å kjør inn på {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', så kommer du frem til {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', og kjør inn i rundkjøringen',
    ['nav.second.exitroundabout.-.-'] = ', og {NEXT_TAKE_NTH_EXIT} i rundkjøringen {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', og kjør inn på {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', og ta {IMMEDIATELY} en u-sving {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', og ta avkjøringen',
    ['nav.second.takeferry.-.-'] = ', og ta deretter fergen {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} for å fortsette {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} for å ta avkjøringen {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} for å ta avkjøring {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} for å kjør inn på {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', og {NEXT_TURN_KEEP} {IMMEDIATELY} {NEXT_LANDMARK} for å kjør inn på {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Du har kommet til {GOAL}',
    ['nav.arrival-side'] = 'Du har kommet frem til {GOAL}. Det er {SIDE}',
    ['nav.gpslost'] = 'GPS-signal tapt',
    ['nav.gpsrestored'] = 'GPS-signalet er gjenopprettet',
    ['nav.newroute'] = 'Finner en ny rute',
    ['nav.speedcamera'] = 'Du passerer snart en fotoboks',
}

return templates
