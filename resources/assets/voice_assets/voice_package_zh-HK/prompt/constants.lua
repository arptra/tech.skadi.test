local constants = {}

constants.order_prefix = {
    ['0'] = '',
    ['1'] = 'next',
    ['2'] = 'second',
    ['3'] = 'third'
}

constants.marc_to_nuance = {
    ['010'] = 'ENU',     -- English (US)
    ['019'] = 'DUB',     -- Dutch (Belgium)
    ['051'] = 'FRC',     -- French (Canada)
    ['076'] = 'PTB',     -- Portuguese (Brazil)
    ['083'] = 'SPM',     -- Spanish (Mexico)
    ['ARG'] = 'SPA',     -- Spanish (Argentina)
    ['BUL'] = 'BGB',     -- Bulgarian
    ['BRA'] = 'PTB',     -- Brazilian Portuguese
    ['CAT'] = 'CAE',     -- Catalan (Spain)
    ['CHN'] = 'MNC',     -- Mandarin (China)
    ['CZE'] = 'CZC',     -- Czech
    ['DAN'] = 'DAD',     -- Danish
    ['DUT'] = 'DUN',     -- Dutch (Netherlands)
    ['ENG'] = 'ENG',     -- English (UK)
    ['FIN'] = 'FIF',     -- Finnish
    ['FRE'] = 'FRF',     -- French
    ['GER'] = 'GED',     -- German
    ['GRE'] = 'GRG',     -- Greek
    ['HKG'] = 'CAH',     -- Cantonese (Hong Kong)
    ['HUN'] = 'HUH',     -- Hungarian
    ['ARA'] = 'GFA',     -- (Gulf) Arabic
    ['IND'] = 'IDI',     -- Bahasa Indonesia
    ['ITA'] = 'ITI',     -- Italian
    ['JPN'] = 'JPJ',     -- Japanese
    ['KOR'] = 'KOK',     -- Korean
    ['NOR'] = 'NON',     -- Norwegian
    ['POL'] = 'PLP',     -- Polish
    ['POR'] = 'PTP',     -- Portuguese
    ['RUM'] = 'RUR',     -- Romanian
    ['RUS'] = 'RUR',     -- Russian
    ['SLO'] = 'SKS',     -- Slovak
    ['SPA'] = 'SPE',     -- Spanish
    ['SWE'] = 'SWS',     -- Swedish
    ['THA'] = 'THT',     -- Thai
    ['TUR'] = 'TRT',     -- Turkish
    ['TWN'] = 'MNT'      -- Mandarin (Taiwan)
}

constants.phoneme_lang_to_nuance = {
    ['EN'] = 'ENG',     -- English
    ['ES'] = 'SPE',     -- Spanish
    ['DE'] = 'GED',     -- German
    ['FR'] = 'FRF',     -- French
    ['PT'] = 'PTP',     -- Brazilian Portuguese
    ['AR'] = 'GFA',     -- (Gulf) Arabic
    ['BG'] = 'BGB',     -- Bulgarian
    ['CA'] = 'CAE',     -- Catalan
    ['ZH'] = 'MNC',     -- Mandarin
    ['CZ'] = 'CZC',     -- Czech
    ['DA'] = 'DAD',     -- Danish
    ['NL'] = 'DUN',     -- Dutch
    ['FI'] = 'FIF',     -- Finnish
    ['GL'] = 'PTP',     -- Galician
    ['EL'] = 'GRG',     -- Greek
    ['HE'] = 'ENU',     -- Hebrew
    ['HU'] = 'HUH',     -- Hungarian
    ['ID'] = 'IDI',     -- Bahasa Indonesia
    ['IT'] = 'ITI',     -- Italian
    ['JP'] = 'JPJ',     -- Japanese
    ['KO'] = 'KOK',     -- Korean
    ['MS'] = 'IDI',     -- Bahasa Malaysia
    ['NB'] = 'NON',     -- Norwegian
    ['PL'] = 'PLP',     -- Polish
    ['RO'] = 'ROR',     -- Romanian
    ['RU'] = 'RUR',     -- Russian
    ['SR'] = 'SRP',     -- Serbian
    ['SK'] = 'SKS',     -- Slovak
    ['SV'] = 'SWS',     -- Swedish
    ['TH'] = 'THT',     -- Thai
    ['TR'] = 'TRT',     -- Turkish
    ['UK'] = 'RUR'      -- Ukrainian
}

constants.supported_abbreviation_languages = { 'de', 'en', 'es', 'fr' }


return constants
