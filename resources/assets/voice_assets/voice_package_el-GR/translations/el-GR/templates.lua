local templates = {
    ['nav.-.follow.-.-'] = 'Ακολουθήστε {DIRECTION}',
    ['nav.-.follow.-.distance'] = 'Ακολουθήστε {DIRECTION} για {DISTANCE}',
    ['nav.-.follow.-.distance-highway'] = 'Ακολουθήστε τον {HIGHWAY} για {DISTANCE}',
    ['nav.-.follow.-.distance-road'] = 'Ακολουθήστε το δρόμο για {DISTANCE}',
    ['nav.-.follow.-.highway'] = 'Ακολουθήστε τον {HIGHWAY}',
    ['nav.-.follow.-.road'] = 'Ακολουθήστε το δρόμο',

    ['nav.-.head.-.-'] = 'Κατευθυνθείτε {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} κάντε αναστροφή {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} μπείτε στο φέριμποτ {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP}, για να εισέλθετε {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP}, για να εισέλθετε στον {HIGHWAY} {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} θα φτάσετε στον {GOAL} σας {DIRECTION}. Ο {GOAL} σας θα βρίσκεται {SIDE}',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} θα φτάσετε στον {GOAL} σας {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} μπείτε στον κυκλικό κόμβο {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} στον κυκλικό κόμβο {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} εισέλθετε στον {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} κάντε αναστροφή {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} βγείτε στην έξοδο {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} take the ferry {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} {TURN_KEEP}, για να συνεχίσετε {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP}, για να βγείτε στην έξοδο και συνεχίστε {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP}, για να βγείτε στην έξοδο {EXIT} και συνεχίστε {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} {TURN_KEEP}, για να βγείτε στην έξοδο {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP}, για να βγείτε στην έξοδο {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, για να εισέλθετε στον {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK}, για να εισέλθετε στον {HIGHWAY} {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', και στη συνέχεια θα φτάσετε στον {NEXT_GOAL} {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', και στη συνέχεια μπείτε στον κυκλικό κόμβο',
    ['nav.second.exitroundabout.-.-'] = ', και στη συνέχεια {NEXT_TAKE_NTH_EXIT} στον κυκλικό κόμβο {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', και στη συνέχεια εισέλθετε στον {NEXT_HIGHWAY}',
    ['nav.second.makeuturn.-.-'] = ', και στη συνέχεια κάντε αναστροφή {NEXT_LANDMARK} {IMMEDIATELY}',
    ['nav.second.takeexit.-.-'] = ', και στη συνέχεια βγείτε στην έξοδο',
    ['nav.second.takeferry.-.-'] = ', και στη συνέχεια μπείτε στο φέριμποτ {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP}, για να συνεχίσετε {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP}, για να βγείτε στην έξοδο {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.exit'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP}, για να βγείτε στην έξοδο {NEXT_EXIT} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, για να εισέλθετε {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.highway'] = ', και στη συνέχεια {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}, για να εισέλθετε στον {NEXT_HIGHWAY} {NEXT_DIRECTION}',

    ['nav.arrival'] = 'Φτάσατε στον {GOAL} σας',
    ['nav.arrival-side'] = 'Φτάσατε στον {GOAL} σας. Είναι {SIDE}',
    ['nav.gpslost'] = 'Το σήμα του GPS χάθηκε',
    ['nav.gpsrestored'] = 'Το σήμα του GPS αποκαταστάθηκε',
    ['nav.newroute'] = 'Εύρεση νέας διαδρομής',
    ['nav.speedcamera'] = 'Πλησιάζετε κάμερα ταχύτητας',
}

return templates
