local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} പിന്തുടരുക',
    ['nav.-.follow.-.distance'] = '{DIRECTION} എന്നതിനായി {DISTANCE} പിന്തുടരുക',
    ['nav.-.follow.-.distance-highway'] = '{DISTANCE} എന്നതിനായി {HIGHWAY} പിന്തുടരുക',
    ['nav.-.follow.-.distance-road'] = '{DISTANCE} എന്നതിനായി റോഡ് പിന്തുടരുക',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} പിന്തുടരുക',
    ['nav.-.follow.-.road'] = 'റോഡ് പിന്തുടരുക',

    ['nav.-.head.-.-'] = 'മുന്നോട്ട് {ORIENTATION} {DIRECTION}',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} ഒരു U-ടേൺ എടുക്കുക {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} ഫെറി {DIRECTION} എടുക്കുക {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{DIRECTION} ൽ ചേരാൻ {LANDMARK} {TURN_KEEP} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{HIGHWAY} {DIRECTION} ൽ ചേരാൻ {LANDMARK} {TURN_KEEP} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} നിങ്ങളുടെ {GOAL} {DIRECTION} നിങ്ങൾ എത്തും. {GOAL} {SIDE} ആയിരിക്കും',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} നിങ്ങളുടെ {GOAL} {DIRECTION} നിങ്ങൾ എത്തും',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} റൗണ്ട്എബൗട്ടിൽ പ്രവേശിക്കുക {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = 'റൗണ്ട്എബൗട്ടിൽ {DIRECTION} {INTERVAL} {TAKE_NTH_EXIT} {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} {HIGHWAY} ൽ ചേരുക {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} ഒരു U-ടേൺ {LANDMARK} എടുക്കുക {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} {DIRECTION} പുറത്തുകടക്കുക {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} ഫെറി {LANDMARK} {DIRECTION} എടുക്കുക {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} {DIRECTION} ല്‍ തുടരു {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} {TURN_KEEP} എക്സിറ്റ് എടുത്ത് {DIRECTION} ല്‍ തുടരുക',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} {TURN_KEEP} എക്സിറ്റ് {EXIT} എടുത്ത് {DIRECTION} ല്‍ തുടരുക',
    ['nav.interval.turnkeep.toexit.-'] = 'പുറത്തുകടക്കാൻ {DIRECTION} {INTERVAL} {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{EXIT} ൽ നിന്ന് പുറത്തുകടക്കാൻ {DIRECTION} {INTERVAL} {TURN_KEEP} {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{DIRECTION} ൽ ചേരുന്നതിന് {INTERVAL} {TURN_KEEP} {LANDMARK} {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{HIGHWAY} {DIRECTION} ൽ ചേരുന്നതിന് {INTERVAL} {TURN_KEEP} {LANDMARK} {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', തുടർന്ന് നിങ്ങൾ {NEXT_GOAL} {NEXT_DIRECTION} ൽ എത്തും',
    ['nav.second.enterroundabout.-.-'] = ', തുടർന്ന് റൗണ്ട്എബൗട്ടിൽ പ്രവേശിക്കുക',
    ['nav.second.exitroundabout.-.-'] = ', തുടർന്ന് {NEXT_TAKE_NTH_EXIT} റൗണ്ട്എബൗട്ടിൽ {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', തുടർന്ന് {NEXT_HIGHWAY} ൽ ചേരുക',
    ['nav.second.makeuturn.-.-'] = ', തുടർന്ന് {IMMEDIATELY} U-ടേൺ {NEXT_LANDMARK} എടുക്കുക',
    ['nav.second.takeexit.-.-'] = ', തുടർന്ന് പുറത്തുകടക്കുക',
    ['nav.second.takeferry.-.-'] = ', തുടർന്ന് ഫെറി {NEXT_LANDMARK} {NEXT_DIRECTION} എടുക്കുക',
    ['nav.second.turnkeep.-.-'] = ', തുടർന്ന് {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.tocontinue.-'] = ', തുടര്‍ന്ന് {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_DIRECTION} ല്‍ തുടരുക',
    ['nav.second.turnkeep.toexit.-'] = ', തുടര്‍ന് പുറത്തുകടക്കാൻ {NEXT_DIRECTION} {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.exit'] = ', തുടര്‍ന് {NEXT_EXIT} ൽ നിന്ന് പുറത്തുകടക്കാൻ {NEXT_DIRECTION} {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tojoin.-'] = ', തുടര്‍ന് {NEXT_DIRECTION} ൽ ചേരുന്നതിന് {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}',
    ['nav.second.turnkeep.tojoin.highway'] = ', തുടര്‍ന് {NEXT_HIGHWAY} {NEXT_DIRECTION} ൽ ചേരുന്നതിന് {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}',

    ['nav.arrival'] = 'നിങ്ങളുടെ {GOAL} എത്തി',
    ['nav.arrival-side'] = 'നിങ്ങളുടെ {GOAL} എത്തി. ഇത് {SIDE} ആണ്',
    ['nav.gpslost'] = 'GPS സിഗ്നൽ നഷ്‌ടപ്പെട്ടു',
    ['nav.gpsrestored'] = 'GPS സിഗ്നൽ പുന സ്ഥാപിച്ചു',
    ['nav.newroute'] = 'ഒരു പുതിയ റൂട്ട് കണ്ടെത്തുന്നു',
    ['nav.speedcamera'] = 'സ്പീഡ് ക്യാമറ മുന്നിലാണ്',
}

return templates
