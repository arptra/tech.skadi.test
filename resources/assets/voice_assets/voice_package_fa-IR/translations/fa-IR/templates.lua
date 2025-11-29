local templates = {
    ['nav.-.follow.-.-'] = '{DIRECTION} را ادامه دهید',
    ['nav.-.follow.-.distance'] = '{DIRECTION} را برای {DISTANCE} ادامه دهید',
    ['nav.-.follow.-.distance-highway'] = '{HIGHWAY} را برای {DISTANCE} ادامه دهید',
    ['nav.-.follow.-.distance-road'] = 'جاده را برای {DISTANCE} ادامه دهید',
    ['nav.-.follow.-.highway'] = '{HIGHWAY} مسیر جاده را دنبال کنید',
    ['nav.-.follow.-.road'] = 'مسیر جاده را دنبال کنید',

    ['nav.-.head.-.-'] = 'به سمت {ORIENTATION} {DIRECTION} حرکت کنید',

    ['nav.landmark.makeuturn.-.-'] = '{LANDMARK} دور بزنید {SECOND}',
    ['nav.landmark.takeferry.-.-'] = '{LANDMARK} سوار کشتی شوید {DIRECTION} {SECOND}',
    ['nav.landmark.turnkeep.-.-'] = '{LANDMARK} {TURN_KEEP} {DIRECTION} شوید {SECOND}',
    ['nav.landmark.turnkeep.tojoin.-'] = '{LANDMARK} تا وارد {DIRECTION} شوید, {TURN_KEEP} {SECOND}',
    ['nav.landmark.turnkeep.tojoin.highway'] = '{LANDMARK} تا وارد {HIGHWAY} {DIRECTION} شوید, {TURN_KEEP} {SECOND}',

    -- First maneuver
    ['nav.interval.arrive.-.side'] = '{INTERVAL} پس از {DISTANCE} به {GOAL} {DIRECTION} خود می رسید. {GOAL} در {SIDE} خواهد بود.',
    ['nav.interval.arrive.-.-'] = '{INTERVAL} پس از {DISTANCE} به {GOAL} {DIRECTION} خود می رسید',
    ['nav.interval.enterroundabout.-.-'] = '{INTERVAL} به میدان می رسید {SECOND}',
    ['nav.interval.exitroundabout.-.-'] = '{INTERVAL} {TAKE_NTH_EXIT} {DIRECTION} خارج شوید {SECOND}',
    ['nav.interval.join.-.highway'] = '{INTERVAL} وارد {HIGHWAY} {SECOND}',
    ['nav.interval.makeuturn.-.-'] = '{INTERVAL} دور بزنید {LANDMARK} {SECOND}',
    ['nav.interval.takeexit.-.-'] = '{INTERVAL} از خروجی خارج شوید {DIRECTION} {SECOND}',
    ['nav.interval.takeferry.-.-'] = '{INTERVAL} سوار کشتی شوید {LANDMARK} {DIRECTION} {SECOND}',
    ['nav.interval.turnkeep.-.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} {DIRECTION} شوید {SECOND}',
    ['nav.interval.turnkeep.tocontinue.-'] = '{INTERVAL} {TURN_KEEP} برای ادامه {DIRECTION} استفاده کنید {SECOND}',
    ['nav.interval.turnkeep.tocontinue-toexit.-'] = '{INTERVAL} برای استفاده از خروجی {TURN_KEEP} و برای ادامه {DIRECTION}',
    ['nav.interval.turnkeep.tocontinue-toexit.exit'] = '{INTERVAL} برای استفاده از خروجی {TURN_KEEP} {EXIT} و برای ادامه {DIRECTION}',
    ['nav.interval.turnkeep.toexit.-'] = '{INTERVAL} برای استفاده از خروجی {TURN_KEEP} {DIRECTION} شوید {SECOND}',
    ['nav.interval.turnkeep.toexit.exit'] = '{INTERVAL} برای استفاده از خروجی {TURN_KEEP} {EXIT} {DIRECTION} شوید {SECOND}',
    ['nav.interval.turnkeep.tojoin.-'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} تا وارد {DIRECTION} شوید {SECOND}',
    ['nav.interval.turnkeep.tojoin.highway'] = '{INTERVAL} {TURN_KEEP} {LANDMARK} تا وارد {HIGHWAY} {DIRECTION} شوید {SECOND}',

    -- Second maneuver
    ['nav.second.arrive.-.-'] = ', سپس به {NEXT_GOAL} {NEXT_DIRECTION} خود می رسید',
    ['nav.second.enterroundabout.-.-'] = ', سپس وارد میدان شوید',
    ['nav.second.exitroundabout.-.-'] = ', سپس {NEXT_TAKE_NTH_EXIT} خارج شوید {NEXT_DIRECTION}',
    ['nav.second.join.-.highway'] = ', و به {NEXT_HIGHWAY} بپیوندید',
    ['nav.second.makeuturn.-.-'] = ', سپس {IMMEDIATELY} دور بزنید {NEXT_LANDMARK}',
    ['nav.second.takeexit.-.-'] = ', سپس از خروجی خارج شوید',
    ['nav.second.takeferry.-.-'] = ', و سپس سوار کشتی شوید {NEXT_LANDMARK} {NEXT_DIRECTION}',
    ['nav.second.turnkeep.-.-'] = ', و سپس {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK} {NEXT_DIRECTION} شوید',
    ['nav.second.turnkeep.tocontinue.-'] = ', سپس  برای ادامه {NEXT_DIRECTION}, {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.-'] = ', سپس  برای استفاده از خروجی {NEXT_DIRECTION}, {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.toexit.exit'] = ', سپس  برای استفاده از خروجی {NEXT_EXIT} {NEXT_DIRECTION}, {IMMEDIATELY} {NEXT_TURN_KEEP}',
    ['nav.second.turnkeep.tojoin.-'] = ', سپس تا وارد {NEXT_DIRECTION} شوید, {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}',
    ['nav.second.turnkeep.tojoin.highway'] = ', سپس تا وارد {NEXT_HIGHWAY} {NEXT_DIRECTION} شوید, {IMMEDIATELY} {NEXT_TURN_KEEP} {NEXT_LANDMARK}',

    ['nav.arrival'] = 'شما به {GOAL} خود رسیده اید',
    ['nav.arrival-side'] = 'شما به {GOAL} خود رسیده اید. مقصد در {SIDE} قرار دارد',
    ['nav.gpslost'] = 'سیگنال GPS قطع شده است',
    ['nav.gpsrestored'] = 'سیگنال GPS بازیابی شده است',
    ['nav.newroute'] = 'در حال یافتن مسیر جدید',
    ['nav.speedcamera'] = 'دوربین کنترل سرعت در پیش رو قرار دارد',
}

return templates
