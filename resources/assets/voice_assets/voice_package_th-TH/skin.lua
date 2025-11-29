_package_settings = {}
main_attribute_array = {}
voice_settings = {}

language = "Thai"
language_id = "41"
language_loc = "ไทย"
main_attribute_array["LocalizedType"] = "ประกาศชื่อถนน"
main_attribute_array["language_code"] = "th-TH"
main_attribute_array["ngLangCode"] = "tha"
marc_code = "THA"
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
