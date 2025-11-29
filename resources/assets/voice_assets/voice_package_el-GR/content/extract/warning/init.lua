local common = require 'content.extract.common.init'

local warning = {}


function warning.extract_warning(input)
    local message_content = common.extract_common_content(input)
    return message_content
end


return warning
