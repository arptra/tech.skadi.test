local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} అనుసరించండి',
    ['nav.-.follow.-.distance'] = '{DISTANCE} {DIRECTION} అనుసరించండి',
    ['nav.-.follow.-.distance-highway'] = '{DISTANCE} {HIGHWAY} అనుసరించండి',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} రహదారిని అనుసరించండి',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} అనుసరించండి',
    ['nav.-.follow.-.road'] = 'రహదారిని అనుసరించండి',

    ['nav.-.head.-.-'] = '{ORIENTATION} వైపు వెళ్లండి {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} యూ టర్న్ తీసుకోండి {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} ఫెర్రీ తీసుకోం {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION}లో జాయిన్ అవ్వడానికి {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} {HIGHWAY}లో జాయిన్ అవ్వడానికి {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} మీరు మీ {GOAL} చేరుకుంటారు {DIRECTION}.{GOAL} {SIDE} ఉంటుంది',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} మీరు మీ {GOAL} చేరుకుంటారు {DIRECTION}',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} కూడలిలోకి వెళ్లండి {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} కూడలి దగ్గర {TAKE_NTH_EXIT} {DIRECTION} వెళ్లండి {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY}లో జాయిన్ అవ్వండి {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} యూ టర్న్ తీసుకోండి {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} బయటికి వెళ్లే దారి ఉపయోగించండి {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ఫెర్రీ తీసుకోండి {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} కొనసాగడానికి {DIRECTION} {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} బయటికి వెళ్లడానికి {TURN_KEEP}, తర్వాత కొనసాగండి {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} బయటకు వెళే దారి సంఖ్య {EXIT} ద్వారా బయటికి వెళ్లం, తర్వాత కొనసాగండి {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} బయటికి వెళ్లడానికి {DIRECTION} {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} {TURN_KEEP} బయటకు వెళే దారి సంఖ్య {EXIT} ద్వారా బయటికి వెళ్లండి {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION}లో జాయిన్ అవ్వడానికి {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {HIGHWAY}లో జాయిన్ అవ్వడానికి {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', తర్వాత మీరు మీ {NEXT_GOAL} చేరుకుంటారు {NEXT_DIRECTION}',
    ['nav.second.enterroundabout.-.-'] = ', తర్వాత కూడలిలోకి వెళ్లండి',
    ['nav.second.exitroundabout.-.-'] = ', తర్వాత కూడలి దగ్గర {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION} వెళ్లండి',
    ['nav.second.join.-.highway'] = ', తర్వాత {NEXT_HIGHWAY}లో జాయిన్ అవ్వండి',
    ['nav.second.makeuturn.-.-'] = ', తర్వాత యూ టర్న్ తీసుకోండి {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', తర్వాత బయటికి వెళ్లడాని',
    ['nav.second.takeferry.-.-'] = ', తర్వాత ఫెర్రీ తీసుకోండి {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', తర్వాత {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', తర్వాత కొనసాగడానికి {NEXT_TURN_KEEP} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.toexit.-'] = ', తర్వాత బయటికి వెళ్లడానికి {NEXT_DIRECTION} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.exit'] = ', తర్వాత {NEXT_TURN_KEEP} బయటకు వెళే దారి సంఖ్య {NEXT_EXIT} ద్వారా బయటికి వెళ్లండి {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tojoin.-'] = ', తర్వాత {NEXT_DIRECTION}లో జాయిన్ అవ్వడానికి {NEXT_TURN_KEEP} {NEXT_LANDMARK}',
    ['nav.second.turnkeep.tojoin.highway'] = ', తర్వాత {NEXT_HIGHWAY}లో జాయిన్ అవ్వడానికి {NEXT_DIRECTION} {NEXT_LANDMARK} {NEXT_TURN_KEEP}',

    ['nav.arrival'] = 'మీరు మీ {GOAL} చేరుకున్నారు',
    ['nav.arrival-side'] = 'మీరు మీ {GOAL} చేరుకున్నారు. అది {SIDE} ఉంది',
    ['nav.gpslost'] = 'GPS సిగ్నల్ పోయింది',
    ['nav.gpsrestored'] = 'GPS స్నిగ్నల్ మళ్లీ వచ్చింది',
    ['nav.newroute'] = 'కొత్త మార్గాన్ని కనుగొంటోంది',
    ['nav.speedcamera'] = 'స్పీడ్ కెమేరా ముందు ఉంది',
}

return templates
