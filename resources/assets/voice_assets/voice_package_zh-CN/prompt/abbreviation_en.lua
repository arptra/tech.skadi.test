local utils = require 'content.utils'


local abbreviation  = {}


-- abbreviations which are at the end of street names
abbreviation._last_word_abbr = {
    ['Aly'] = 'Alley',
    ['Anx'] = 'Annex',
    ['Arc'] = 'Arcade',
    ['Ave'] = 'Avenue',
    ['Byu'] = 'Bayou',
    ['Bch'] = 'Beach',
    ['Bnd'] = 'Bend',
    ['Blf'] = 'Bluff',
    ['Blfs'] = 'Bluffs',
    ['Btm'] = 'Bottom',
    ['Bldg'] = 'Building',
    ['Blvd'] = 'Boulevard',
    ['Br'] = 'Branch',
    ['Brg'] = 'Bridge',
    ['Brk'] = 'Brook',
    ['Brks'] = 'Brooks',
    ['Bg'] = 'Burg',
    ['Bgs'] = 'Burgs',
    ['Byp'] = 'Bypass',
    ['Cp'] = 'Camp',
    ['Cyn'] = 'Canyon',
    ['Cpe'] = 'Cape',
    ['Crt'] = 'Court',
    ['Cswy'] = 'Causeway',
    ['Ctr'] = 'Center',
    ['Ctrs'] = 'Centers',
    ['Cir'] = 'Circle',
    ['Cirs'] = 'Circles',
    ['Clf'] = 'Cliff',
    ['Clfs'] = 'Cliffs',
    ['Clb'] = 'Club',
    ['Cmn'] = 'Common',
    ['Cmns'] = 'Commons',
    ['Cntr'] = 'Center',
    ['Cor'] = 'Corner',
    ['Cors'] = 'Corners',
    ['Crse'] = 'Course',
    ['Ct'] = 'Court',
    ['Cts'] = 'Courts',
    ['Cv'] = 'Cove',
    ['Cvs'] = 'Coves',
    ['Crk'] = 'Creek',
    ['Cres'] = 'Crescent',
    ['Crst'] = 'Crest',
    ['Xing'] = 'Crossing',
    ['Xrd'] = 'Crossroad',
    ['Xrds'] = 'Crossroads',
    ['Curv'] = 'Curve',
    ['Dl'] = 'Dale',
    ['Dm'] = 'Dam',
    ['Dvsn'] = 'Diversion',
    ['Dv'] = 'Divide',
    ['Dr'] = 'Drive',
    ['Drs'] = 'Drives',
    ['Est'] = 'Estate',
    ['Ests'] = 'Estates',
    ['Expwy'] = 'Expressway',
    ['Expy'] = 'Expressway',
    ['Ext'] = 'Extension',
    ['Exts'] = 'Extensions',
    ['Fall'] = 'Fall',
    ['Fls'] = 'Falls',
    ['Fry'] = 'Ferry',
    ['Fld'] = 'Field',
    ['Flds'] = 'Fields',
    ['Flt'] = 'Flat',
    ['Flts'] = 'Flats',
    ['Frd'] = 'Ford',
    ['Frds'] = 'Fords',
    ['Frst'] = 'Forest',
    ['Frg'] = 'Forge',
    ['Frgs'] = 'Forges',
    ['Frk'] = 'Fork',
    ['Frks'] = 'Forks',
    ['Ft'] = 'Fort',
    ['Fwy'] = 'Freeway',
    ['Gdn'] = 'Garden',
    ['Gdns'] = 'Gardens',
    ['Gtwy'] = 'Gateway',
    ['Gln'] = 'Glen',
    ['Glns'] = 'Glens',
    ['Grn'] = 'Green',
    ['Grns'] = 'Greens',
    ['Grv'] = 'Grove',
    ['Grvs'] = 'Groves',
    ['Hbr'] = 'Harbor',
    ['Hbrs'] = 'Harbors',
    ['Hvn'] = 'Haven',
    ['Hts'] = 'Heights',
    ['Hwy'] = 'Highway',
    ['Hl'] = 'Hill',
    ['Hls'] = 'Hills',
    ['Holw'] = 'Hollow',
    ['Inlt'] = 'Inlet',
    ['Int\'L'] = 'International',
    ['Int\'l'] = 'International',
    ['Intl'] = 'International',
    ['Is'] = 'Island',
    ['Iss'] = 'Islands',
    ['Jct'] = 'Junction',
    ['Jcts'] = 'Junctions',
    ['Ky'] = 'Key',
    ['Kys'] = 'Keys',
    ['Knl'] = 'Knoll',
    ['Knls'] = 'Knolls',
    ['Lk'] = 'Lake',
    ['Lks'] = 'Lakes',
    ['Lndg'] = 'Landing',
    ['Ln'] = 'Lane',
    ['Lgt'] = 'Light',
    ['Lgts'] = 'Lights',
    ['Lf'] = 'Loaf',
    ['Lck'] = 'Lock',
    ['Lcks'] = 'Locks',
    ['Ldg'] = 'Lodge',
    ['Ltn'] = 'Longturn',
    ['Mkt'] = 'Market',
    ['Mnr'] = 'Manor',
    ['Mnrs'] = 'Manors',
    ['Mdw'] = 'Meadow',
    ['Mdws'] = 'Meadows',
    ['Ml'] = 'Mill',
    ['Mls'] = 'Mills',
    ['Msn'] = 'Mission',
    ['Mtwy'] = 'Motorway',
    ['Mt'] = 'Mount',
    ['Mtn'] = 'Mountain',
    ['Mtns'] = 'Mountains',
    ['Nck'] = 'Neck',
    ['Orch'] = 'Orchard',
    ['Ovl'] = 'Oval',
    ['Opas'] = 'Overpass',
    ['Orgn'] = 'Organization',
    ['Pky'] = 'Parkway',
    ['Pkw'] = 'Parkway',
    ['Pkwy'] = 'Parkway',
    ['Pass'] = 'Pass',
    ['Psge'] = 'Passage',
    ['Pne'] = 'Pine',
    ['Pnes'] = 'Pines',
    ['Pl'] = 'Place',
    ['Pln'] = 'Plain',
    ['Plns'] = 'Plains',
    ['Plz'] = 'Plaza',
    ['Pt'] = 'Point',
    ['Pts'] = 'Points',
    ['Prt'] = 'Port',
    ['Prts'] = 'Ports',
    ['Pr'] = 'Prairie',
    ['Radl'] = 'Radial',
    ['Rnch'] = 'Ranch',
    ['Rpd'] = 'Rapid',
    ['Rpds'] = 'Rapids',
    ['Rst'] = 'Rest',
    ['Rdg'] = 'Ridge',
    ['Rdgs'] = 'Ridges',
    ['Riv'] = 'River',
    ['Rd'] = 'Road',
    ['Rds'] = 'Roads',
    ['Rng'] = 'Range',
    ['Rte'] = 'Route',
    ['Shl'] = 'Shoal',
    ['Shls'] = 'Shoals',
    ['Shr'] = 'Shore',
    ['Shrs'] = 'Shores',
    ['Skwy'] = 'Skyway',
    ['Spg'] = 'Spring',
    ['Spgs'] = 'Springs',
    ['Sq'] = 'Square',
    ['Sqs'] = 'Squares',
    ['Sta'] = 'Station',
    ['Stra'] = 'Stravenue',
    ['Strm'] = 'Stream',
    ['St'] = 'Street',
    ['Sts'] = 'Streets',
    ['Smt'] = 'Summit',
    ['Ter'] = 'Terrace',
    ['Terr'] = 'Terrace',
    ['Trwy'] = 'Throughway',
    ['Trce'] = 'Trace',
    ['Trak'] = 'Track',
    ['Trfy'] = 'Trafficway',
    ['Trl'] = 'Trail',
    ['Tunl'] = 'Tunnel',
    ['Trlr'] = 'Trailer',
    ['Tpk'] = 'Turnpike',
    ['Tpke'] = 'Turnpike',
    ['Upas'] = 'Underpass',
    ['Un'] = 'Union',
    ['Uns'] = 'Unions',
    ['Vly'] = 'Valley',
    ['Vlys'] = 'Valleys',
    ['Via'] = 'Viaduct',
    ['Vw'] = 'View',
    ['Vws'] = 'Views',
    ['Vlg'] = 'Village',
    ['Vlgs'] = 'Villages',
    ['Vl'] = 'Ville',
    ['Vis'] = 'Vista',
    ['Whse'] = 'Warehouse',
    ['Wl'] = 'Well',
    ['Wls'] = 'Wells'
}


function abbreviation._has_cardinal(words)
    local cardinals = { 'N', 'S', 'E', 'W', 'NE', 'NW', 'SE', 'SW', 'North', 'South', 'East', 'West', 'Northeast', 'Northwest', 'Southeast', 'Southwest' }
    -- check if the last word is a cardinal direction
    return utils.contains(cardinals, words[#words][1], false)
end


function abbreviation._process_all_except_last_words_rules(word)
    local modified_word = word
    modified_word, _ = utils.replace(modified_word, '[Dd][Rr]', 'Doctor')
    modified_word, _ = utils.replace(modified_word, '[Ss][Tt]', 'Saint')
    modified_word, _ = utils.replace(modified_word, 'SF', 'San Francisco ')
    modified_word, _ = utils.replace(modified_word, 'NY', 'New York ')
    modified_word, _ = utils.replace(modified_word, 'NJ', 'New Jersey ')
    modified_word, _ = utils.replace(modified_word, 'Int\'L', 'International')
    modified_word, _ = utils.replace(modified_word, 'Int\'l', 'International')
    modified_word, _ = utils.replace(modified_word, 'Intl', 'International')
    modified_word, _ = utils.replace(modified_word, 'SR', 'State Road')
    return modified_word
end


function abbreviation._process_all_words_rules(word)
    local modified_word = word
    -- all words rules
    -- replaces I-[0-9] with 'Interstate [0-9]'
    modified_word, _ = utils.replace(modified_word, 'I[-](%d+)', 'Interstate %1')
    -- replaces HWY-[0-9] with 'Highway [0-9]'
    modified_word, _ = utils.replace(modified_word, 'HWY[-](%d+)', 'Highway %1')
    -- I-90/I-94, has to be split before the slash handling
    modified_word, _ = utils.replace(modified_word, 'I-(%d+)/I-(%d+)', 'Interstate %1, %2')
    -- replaces globally Jr with Junior
    modified_word, _ = utils.replace(modified_word, '[Jj][Rr]', 'Junior')
    -- use 'double oh' if the middle 2 digits are zero of a 4 digit number following a capital letter
    modified_word, _ = utils.replace(modified_word, '([A-Z]%d)00(%d)', '%1 double oh %2')
    -- pronounce 0 in 2nd position of a 4 digit number following a capital letter as 'Oh'
    modified_word, _ = utils.replace(modified_word, '([A-Z]%d)0(%d)(%d)', '%1 oh %2 %3')
    -- pronounce 0 in 3rd position of a 4 digit number following a capital letter as 'Oh',
    -- knowing that a 3 digit number with 0 in the middle is pronounced correctly in address mode
    modified_word, _ = utils.replace(modified_word, '([A-Z]%d)(%d)0(%d)', '%1 %2 oh %3')

    modified_word = abbreviation._process_cardinal_rules(modified_word)
    return modified_word
end


function abbreviation._process_cardinal_rules(word)
    -- compass directions
    local modified_word = word
    modified_word, _ = utils.replace(modified_word, 'N%-?E', 'North East')
    modified_word, _ = utils.replace(modified_word, 'N%-?W', 'North West')
    modified_word, _ = utils.replace(modified_word, 'S%-?E', 'South East')
    modified_word, _ = utils.replace(modified_word, 'S%-?W', 'South West')
    modified_word, _ = utils.replace(modified_word, 'N', 'North')
    modified_word, _ = utils.replace(modified_word, 'S', 'South')
    modified_word, _ = utils.replace(modified_word, 'E', 'East')
    modified_word, _ = utils.replace(modified_word, 'W', 'West')
    return modified_word
end


function abbreviation.expand_abbreviation(phrase)
    local words = utils.split_phrase(phrase)
    local has_cardinal = abbreviation._has_cardinal(words)
    for i = 1, #words do
        local word = words[i][1]
        -- process all except last word rules
        if ((has_cardinal == false and i < #words)
            or (has_cardinal == true and i < #words - 1))
            and not words[i][2]:find('/') then
            word = abbreviation._process_all_except_last_words_rules(word)
        end

        -- process last word rules
        if ((has_cardinal == false and i == #words)
            or (has_cardinal == true and i == #words - 1)
            or words[i][2]:find('/')) then
            for abbr,expansion in pairs(abbreviation._last_word_abbr) do
                word, _ = utils.replace(word, abbr, expansion)
            end
        end

        -- process all word rules
        word = abbreviation._process_all_words_rules(word)

        -- eliminate the dot if the abbreviation was expanded
        if ( word ~= words[i][1] ) then
            words[i][2] = utils.replace(words[i][2], '(%s*)%.(%s*)', ' ')
        end
        words[i][1] = word
    end

    -- re-construct the phrase based on the components
    local expanded_phrase = utils.reconstruct_phrase(words)

    return expanded_phrase
end


return abbreviation
