_package_settings = {}
main_attribute_array = {}
voice_settings = {}

language = "Japanese"
language_id = "23"
language_loc = "日本語"
main_attribute_array["LocalizedType"] = "街道名付き"
main_attribute_array["language_code"] = "ja-JP"
main_attribute_array["ngLangCode"] = "jpj"
marc_code = "JPN"
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
