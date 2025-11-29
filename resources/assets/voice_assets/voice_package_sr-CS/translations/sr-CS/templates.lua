local templates = {
    ['nav.-.follow.-.-'] = 'pratite {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'pratite {DIRECTION} narednih {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'pratite {HIGHWAY} narednih {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'pratite put narednih {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'pratite {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'pratite put',

    ['nav.-.head.-.-'] = 'idite na {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} napravite polukružno okretanje {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} ukrcajte se na trajekt {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} da biste se uključili na {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} da biste se uključili na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} stići ćete na {GOAL} {DIRECTION}. {GOAL} će biti {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} stići ćete na {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} uđite u kružni tok {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} u kružnom toku {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} uključite se na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} napravite polukružno okretanje {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} skrenite kod izlaza {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ukrcajte se na trajekt {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} da biste nastavili {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} da biste skrenuli kod izlaza i zatim nastavite {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} da biste skrenuli kod izlaza {EXIT} i zatim nastavite {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} da biste skrenuli kod izlaza {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} da biste skrenuli kod izlaza {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} da biste se uključili na {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} da biste se uključili na {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'i zatim stići ćete na {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'i zatim uđite u kružni tok',
    ['nav.second.exitroundabout.-.-'] = 'i zatim {NEXT_TAKE_NTH_EXIT} u kružnom toku {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'i zatim se uključite na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'i zatim {IMMEDIATELY} napravite polukružno okretanje {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'i zatim skrenite kod izlaza',
    ['nav.second.takeferry.-.-'] = 'i zatim se ukrcajte na trajekt {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'i zatim {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'i zatim {IMMEDIATELY} {NEXT_TURN_KEEP} da biste nastavili {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'i zatim {IMMEDIATELY} {NEXT_TURN_KEEP} da biste skrenuli kod izlaza {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'i zatim {IMMEDIATELY} {NEXT_TURN_KEEP} da biste skrenuli kod izlaza {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'i zatim se {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} da biste uključili na {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'i zatim se {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} da biste uključili na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Stigli ste na {GOAL}',
    ['nav.arrival-side'] = 'Stigli ste na {GOAL}. Ono je {SIDE}',
    ['nav.gpslost'] = 'GPS signal je prekinut',
    ['nav.gpsrestored'] = 'GPS signal je ponovo uspostavljen',
    ['nav.newroute'] = 'Pronalaženje nove rute',
    ['nav.speedcamera'] = 'Kamera za prekoračenje brzine je ispred vas',
}

return templates
