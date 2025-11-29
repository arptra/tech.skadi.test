local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} ಅನ್ನು ಹಿಂಬಾಲಿಸಿ',
    ['nav.-.follow.-.distance'] = '{DIRECTION} ಅನ್ನು {DISTANCE} ವರೆಗೆ ಹಿಂಬಾಲಿಸಿ',
    ['nav.-.follow.-.distance-highway'] = '{HIGHWAY} ಯಲ್ಲಿ {DISTANCE} ವರೆಗೆ ಅನುಸರಿಸಿ',
    ['nav.-.follow.-.distance-road'] = 'ರಸ್ತೆಯನ್ನು {DISTANCE} ವರೆಗೆ ಅನುಸರಿಸಿ',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} ಅನುಸರಿಸಿ',
    ['nav.-.follow.-.road'] = 'ರಸ್ತೆಯನ್ನು ಅನುಸರಿಸಿ',

    ['nav.-.head.-.-'] = '{ORIENTATION} {DIRECTION} ಕಡೆಗೆ ತೆರಳಿ',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} ಯು ಟರ್ನ್ ತೆಗೆದುಕೊಳ್ಳಿ {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} {DIRECTION} ಬೋಟ್‌ನಲ್ಲಿ ಪ್ರಯಾಣಿಸಿ {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} ಗೆ ಸೇರಿ {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} {TURN_KEEP} {HIGHWAY} ಗೆ ಸೇರಿ {DIRECTION} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} ನೀವು {GOAL} {DIRECTION} ತಲುಪುತ್ತೀರಿ. {GOAL} {SIDE}ಇರುತ್ತದೆ',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} ನೀವು {GOAL} {DIRECTION} ತಲುಪುತ್ತೀರಿ',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} ವೃತ್ತ ಪ್ರವೇಶಿಸಿ {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} ವೃತ್ತದಲ್ಲಿ {TAKE_NTH_EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY} ಗೆ ಸೇರಿ {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} {LANDMARK} ಯು ಟರ್ನ್ ತೆಗೆದುಕೊಳ್ಳಿ {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} ನಿರ್ಗಮಿಸಿ {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} {LANDMARK} {DIRECTION} ನಲ್ಲಿ ಬೋಟ್‌ನಲ್ಲಿ ಪ್ರಯಾಣಿಸಿ {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} {DIRECTION} ಗೆ ಮುಂದುವರಿಯಿರಿ {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} ನಿರ್ಗಮಿಸಿ ಮತ್ತು {DIRECTION} ಗೆ ಮುಂದುವರಿಯಿರಿ',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} ನಿರ್ಗಮಿಸಲು {EXIT} ಮತ್ತು {DIRECTION} ಗೆ ಮುಂದುವರಿಯಿರಿ',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} ನಿರ್ಗಮಿಸಲು {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} ನಿರ್ಗಮಿಸಲು {TURN_KEEP} {EXIT} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} ಗೆ ಸೇರಿ {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {HIGHWAY} ಗೆ ಸೇರಿ {DIRECTION} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = 'ಮತ್ತು ನಂತರ ನೀವು ನಿಮ್ಮ {NEXT_GOAL} {NEXT_DIRECTION} ತಲುಪುತ್ತೀರಿ',
    ['nav.second.enterroundabout.-.-'] = 'ಮತ್ತು ನಂತರ ವೃತ್ತವನ್ನು ಪ್ರವೇಶಿಸಿ',
    ['nav.second.exitroundabout.-.-'] = 'ಮತ್ತು ನಂತರ ವೃತ್ತದಲ್ಲಿ {NEXT_TAKE_NTH_EXIT} {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = 'ಮತ್ತು ನಂತರ {NEXT_HIGHWAY} ಗೆ ಸೇರಿ',
    ['nav.second.makeuturn.-.-'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} ಯು ಟರ್ನ್‌ ತೆಗೆದುಕೊಳ್ಳಿ {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = 'ಮತ್ತು ನಂತರ ನಿರ್ಗಮಿಸಿ',
    ['nav.second.takeferry.-.-'] = 'ಮತ್ತು ನಂತರ ಬೋಟ್‌ನಲ್ಲಿ ಪ್ರಯಾಣಿಸಿ {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_DIRECTION} ಗೆ ಮುಂದುವರಿಯಿರಿ',
    ['nav.second.turnkeep.toexit.-'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_DIRECTION} ನಿರ್ಗಮಿಸಲು',
    ['nav.second.turnkeep.toexit.exit'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_EXIT} {NEXT_DIRECTION} ನಿರ್ಗಮಿಸಲು',
    ['nav.second.turnkeep.tojoin.-'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION} ಗೆ ಸೇರಿ',
    ['nav.second.turnkeep.tojoin.highway'] = 'ಮತ್ತು ನಂತರ {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_HIGHWAY} ಗೆ ಸೇರಿ {NEXT_DIRECTION}',

    ['nav.arrival'] = 'ನೀವು ನಿಮ್ಮ {GOAL} ತಲುಪಿದ್ದೀರಿ',
    ['nav.arrival-side'] = 'ನೀವು ನಿಮ್ಮ {GOAL} ತಲುಪಿದ್ದೀರಿ. ಇದು {SIDE} ಇದೆ',
    ['nav.gpslost'] = 'ಜಿಪಿಎಸ್ ಸಂಕೇತ ಸ್ಥಗಿತಗೊಂಡಿದೆ',
    ['nav.gpsrestored'] = 'ಜಿಪಿಎಸ್ ಸಂಕೇತ ಮರುಸ್ಥಾಪನೆಗೊಂಡಿದೆ',
    ['nav.newroute'] = 'ಹೊಸ ಮಾರ್ಗವನ್ನು ಹುಡುಕಲಾಗುತ್ತಿದೆ',
    ['nav.speedcamera'] = 'ವೇಗ ಅಳೆಯುವ ಕ್ಯಾಮೆರಾ ಮುಂದಿದೆ',
}

return templates
