_package_settings = {}
main_attribute_array = {}
voice_settings = {}

language = "Turkish"
language_id = "49"
language_loc = "Türkçe"
main_attribute_array["LocalizedType"] = "konuşma sentezi"
main_attribute_array["language_code"] = "tr-TR"
main_attribute_array["ngLangCode"] = "tur"
marc_code = "TUR"
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
