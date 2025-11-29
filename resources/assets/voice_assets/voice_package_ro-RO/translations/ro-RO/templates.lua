local templates = {
    ['nav.-.follow.-.-'] = 'Continuați pe {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Continuați pe {DIRECTION} încă {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Continuați pe {HIGHWAY} încă {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Continuați pe acest drum încă {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Continuați pe {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Continuați pe acest drum',

    ['nav.-.head.-.-'] = 'Îndreptați-vă spre {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} întoarceți {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} luați feribotul spre {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} pentru a intra pe {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} pentru a intra pe {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} veți ajunge la {GOAL} {DIRECTION}. {GOAL} va fi {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} veți ajunge la {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} intrați în sensul giratoriu {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} la sensul giratoriu {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} intrați pe {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} întoarceți {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} folosiți ieșireaa {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} luați feribotul {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} pentru a continua {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, folosiți ieșirea și continuați {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, folosiți ieșirea {EXIT} și continuați {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} și folosiți ieșirea {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, folosiți ieșirea {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pentru a intra pe {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} pentru a intra pe {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'și apoi veți ajunge la {NEXT_GOAL} dumneavoastră {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = 'și apoi intrați în sensul giratoriu',
    ['nav.second.exitroundabout.-.-'] = 'și apoi {NEXT_TAKE_NTH_EXIT} la sensul giratoriu {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'și apoi intrați pe {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = 'și apoi {IMMEDIATELY} întoarceți {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'și apoi folosiți ieșirea',
    ['nav.second.takeferry.-.-'] = 'și apoi luați feribotul {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'și apoi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'și apoi {IMMEDIATELY} {NEXT_TURN_KEEP} pentru a continua {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', apoi {IMMEDIATELY} {NEXT_TURN_KEEP} și folosiți ieșirea {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', apoi {IMMEDIATELY} {NEXT_TURN_KEEP} și folosiți ieșirea {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = 'și apoi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} pentru a intra pe {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = 'și apoi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} pentru a intra pe {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Ați ajuns la {GOAL}',
    ['nav.arrival-side'] = 'Ați ajuns la {GOAL}. Este {SIDE}',
    ['nav.gpslost'] = 'Semnal GPS pierdut',
    ['nav.gpsrestored'] = 'Semnalul GPS a fost restabilit',
    ['nav.newroute'] = 'Se caută o nouă rută',
    ['nav.speedcamera'] = 'Cameră radar în față',
}

return templates
