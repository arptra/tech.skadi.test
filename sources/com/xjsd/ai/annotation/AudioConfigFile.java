package com.xjsd.ai.annotation;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE_PARAMETER, ElementType.PARAMETER})
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface AudioConfigFile {
    public static final String GLOABLE_AEC_BFVAD_ASSISTANT_STAR = "gloable-aec-bfvad-assistant-star.config";
    public static final String GLOABLE_AEC_BFVAD_ASSISTANT_STAR_SIGWKPONLY = "gloable-aec-bfvad-assistant-star-sigwkponly.config";
    public static final String GLOABLE_AEC_GEVNNBF_TRANS_STAR = "gloable-aec-gevnnbf-trans-star.config";
    public static final String GLOABLE_AEC_VADON_BFVAD_ASSISTANT_STAR_SIGWKPONLY = "gloable-aec-vadon-bfvad-assistant-star-sigwkponly.config";
    public static final String GLOABLE_ASSISTANT_AIR = "gloable-assistant-air.config";
    public static final String GLOABLE_ASSISTANT_AIR_EN = "gloable-assistant-air-en.config";
    public static final String GLOABLE_ASSISTANT_STAR_WKPVADCWRONLY = "gloable-assistant-star-wkpvadcwronly.config";
    public static final String GLOABLE_ASSISTANT_STAR_WKPVADCWRONLY_EN = "gloable-assistant-star-wkpvadcwronly-en.config";
    public static final String GLOABLE_ASSISTANT_VADONLY = "gloable-assistant-vadonly.config";
    public static final String GLOABLE_BFVAD_ASSISTANT_STAR = "gloable-bfvad-assistant-star.config";
    public static final String GLOABLE_BFVAD_ASSISTANT_STAR_SIGONLY = "gloable-bfvad-assistant-star-sigonly.config";
    public static final String GLOABLE_BFVAD_TRANS_STAR = "gloable-bfvad-trans-star.config";
    public static final String GLOABLE_BFVAD_TRANS_STAR_EN = "gloable-bfvad-trans-star-en.config";
    public static final String GLOABLE_BFVAD_TRANS_STAR_SIGNOLY = "gloable-bfvad-trans-star-signoly.config";
    public static final String GLOABLE_BFVAD_WECHAT_STAR = "gloable-bfvad-wechat-star.config";
    public static final String GLOABLE_GEVNNBF_ASSISTANT_CONCEPT = "gloable-gevnnbf-assistant-concept.config";
    public static final String GLOABLE_GEVNNBF_ASSISTANT_CONCEPT_SIGONLY = "gloable-gevnnbf-assistant-concept-sigonly.config";
    public static final String GLOABLE_GEVNNBF_TRANS_CONCEPT = "gloable-gevnnbf-trans-concept.config";
    public static final String GLOABLE_GEVNNBF_TRANS_CONCEPT_SIGONLY = "gloable-gevnnbf-trans-concept-sigonly.config";
    public static final String GLOABLE_GEVNNBF_TRANS_STAR = "gloable-gevnnbf-trans-star.config";
    public static final String GLOABLE_GEVNNBF_TRANS_STAR_SIGONLY = "gloable-gevnnbf-trans-star-sigonly.config";
    public static final String GLOABLE_GEVNNBF_TRANS_STAR_SIGONLY_EN = "gloable-gevnnbf-trans-star-sigonly-en.config";
    public static final String GLOABLE_GEVNNBF_WECHAT_CONCEPT = "gloable-gevnnbf-wechat-concept.config";
    public static final String GLOABLE_VADCWRONLY = "gloable-vadcwronly.config";
    public static final String GLOABLE_VADONLY = "gloable-vadonly.config";
    public static final String GLOABLE_VADONLY_AIR = "gloable-vadonly-air.config";
    public static final String GLOABLE_VADONLY_AIR_EN = "gloable-vadonly-air-en.config";
}
