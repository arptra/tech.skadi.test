local templates = {
    ['nav.-.follow.-.-'] = 'Slijedite {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Slijedite {DIRECTION} {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Slijedite {HIGHWAY} {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Slijedite cestu {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Slijedite {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Slijedite cestu',

    ['nav.-.head.-.-'] = 'Krenite na {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} polukružno se okrenite',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} ukrcajte se na trajekt {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} kako biste se uključili {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} kako biste se uključili na {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} stići ćete na {GOAL} {DIRECTION}. {GOAL} će biti {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} stići ćete na {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} uđite u kružni tok {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} iz kružnog toka {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} uključite se na {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} polukružno se okrenite {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} izađite (na izlazu) {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ukrcajte se na trajekt {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} kako biste nastavili {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} kako biste izašli na izlazu i nastavili {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} kako biste izašli na izlazu {EXIT} i nastavili {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} kako biste izašli (na izlazu) {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} kako biste izašli na izlazu {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} kako biste se uključili {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} kako biste se uključili na {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'i stići ćete na {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'i uđite u kružni tok',
    ['nav.second.exitroundabout.-.-'] = 'i {NEXT_TAKE_NTH_EXIT} iz kružnog toka {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'i uključite se na {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'i {IMMEDIATELY} polukružno se okrenite {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'i izađite na izlazu',
    ['nav.second.takeferry.-.-'] = 'i ukrcajte se na trajekt {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} kako biste nastavili {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} kako biste izašli (na izlazu) {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} kako biste izašli na izlazu {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} kako biste se uključili {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'i {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} kako biste se uključili na {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Stigli ste na {GOAL}',
    ['nav.arrival-side'] = 'Stigli ste na {GOAL}. Nalazi se {SIDE}',
    ['nav.gpslost'] = 'Izgubljen je signal GPS-a',
    ['nav.gpsrestored'] = 'Ponovno je primljen signal GPS-a',
    ['nav.newroute'] = 'Traženje nove rute',
    ['nav.speedcamera'] = 'Slijedi kamera za mjerenje brzine',
}

return templates
