_package_settings = {}
main_attribute_array = {}
voice_settings = {}

language = "Portuguese"
language_id = "46"
language_loc = "Português"
main_attribute_array["LocalizedType"] = "síntese de fala"
main_attribute_array["language_code"] = "pt-PT"
main_attribute_array["ngLangCode"] = "por"
marc_code = "POR"
speed_camera = "true"
speed_warner = "true"

config_file = "main.lua"
description = "voice package for "..language_loc
feature_list = { "metric", "imperial_uk", "imperial_us" }
id = language_id..marc_code
output_type = "tts"
voice_settings["nguidance"] = "true"
voice_settings["nguidance_junction"] = "true"
voice_settings["nguidance_stop_sign"] = "true"
voice_settings["nguidance_trafficlights"] = "true"
voice_settings["prompt_mode"] = "1"
