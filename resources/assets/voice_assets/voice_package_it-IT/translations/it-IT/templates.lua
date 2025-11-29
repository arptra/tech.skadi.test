local templates = {
    ['nav.-.follow.-.-'] = 'Prosegui lungo {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Prosegui lungo {DIRECTION} per {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Prosegui lungo {HIGHWAY} per {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Prosegui lungo la strada per {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Prosegui lungo {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Prosegui lungo la strada',

    ['nav.-.head.-.-'] = 'Procedi verso {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} fai inversione a U {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} prendi il traghetto {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} e prendi la {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} e prendi {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} sarai arrivato alla {GOAL} {DIRECTION}. La {GOAL} sarà {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} sarai arrivato alla {GOAL} {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} entra nella rotonda {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} alla rotonda {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} prendi {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} fai inversione a U {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} prendi l\'uscita {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} prendi il traghetto {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} e continua {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} e prendi l\'uscita, poi continua {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} e prendi l\'uscita {EXIT}, poi continua {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP} e prendi l\'uscita {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} e prendi l\'uscita {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} e prendi {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} e prendi {HIGHWAY} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', poi sarai arrivato alla {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', poi entra nella rotonda',
    ['nav.second.exitroundabout.-.-'] = ', poi alla rotonda {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', poi prendi {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', poi {IMMEDIATELY} fai inversione a U {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', poi prendi l\'uscita',
    ['nav.second.takeferry.-.-'] = ', poi prendi il traghetto {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} e continua {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} e prendi l\'uscita {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} e prendi l\'uscita {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} e prendi {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', poi {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} e prendi {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Sei arrivato alla {GOAL}',
    ['nav.arrival-side'] = 'Sei arrivato alla {GOAL}. È {SIDE}',
    ['nav.gpslost'] = 'Segnale GPS perso',
    ['nav.gpsrestored'] = 'Segnale GPS ripristinato',
    ['nav.newroute'] = 'Calcolo di un nuovo itinerario in corso',
    ['nav.speedcamera'] = 'Controllo elettronico della velocità più avanti',
}

return templates
