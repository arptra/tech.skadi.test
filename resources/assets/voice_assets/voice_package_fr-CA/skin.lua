_package_settings = {}
main_attribute_array = {}
voice_settings = {}

language = "French (Canada)"
language_id = "11"
language_loc = "Français (Canada)"
main_attribute_array["LocalizedType"] = "synthèse vocale"
main_attribute_array["language_code"] = "fr-CA"
main_attribute_array["ngLangCode"] = "fre"
marc_code = "051"
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
