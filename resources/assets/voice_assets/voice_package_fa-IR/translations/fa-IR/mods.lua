local mods = require('translations.mods')

function mods.apply_language_specific_mods(sentence)
    -- Add the 'use' word - 'استفاده کنید' - to the template: 'After {DISTANCE} {TURN_KEEP} to take the exit.'
    -- when the {TURN_KEEP} is one of the left|right line.
    sentence = sentence:gsub("(پس از )([0-9]+)(.-)(خط سمت چپ)(.-)( تا از خروجی خارج شوید.)", "%1%2%3%4%5 استفاده کنید %6")
    sentence = sentence:gsub("(پس از )([0-9]+)(.-)(خط سمت راست)(.-)( تا از خروجی خارج شوید.)", "%1%2%3%4%5 استفاده کنید %6")

    sentence = sentence:gsub('{[NEXT_]*DIRECTION} شوید', '')

    sentence = sentence:gsub('به سمت {ORIENTATION}', '')

    -- Remove the subject 'مقصد' from the second sentence in the template:
    -- 'You have reached your {GOAL}. It's {SIDE}.' only if {GOAL} is a waypoint.
    return sentence:gsub("(.-)(نقطه جهت‌یابی)(.-)(. مقصد)(.-)", "%1%2%3. %5")
end

return mods
