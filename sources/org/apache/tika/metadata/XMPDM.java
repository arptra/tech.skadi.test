package org.apache.tika.metadata;

import androidx.exifinterface.media.ExifInterface;

public interface XMPDM {
    public static final Property A = Property.g("xmpDM:releaseDate");
    public static final Property B = Property.t("xmpDM:scaleType", "Major", "Minor", "Both", "Neither");
    public static final Property C = Property.k("xmpDM:scene");
    public static final Property D = Property.g("xmpDM:shotDate");
    public static final Property E = Property.k("xmpDM:shotLocation");
    public static final Property F = Property.k("xmpDM:shotName");
    public static final Property G = Property.k("xmpDM:speakerPlacement");
    public static final Property H = Property.t("xmpDM:stretchMode", "Fixed length", "Time-Scale", "Resample", "Beat Splice", "Hybrid");
    public static final Property I = Property.k("xmpDM:tapeName");
    public static final Property J = Property.z("xmpDM:tempo");
    public static final Property K = Property.t("xmpDM:timeSignature", "2/4", "3/4", "4/4", "5/4", "7/4", "6/8", "9/8", "12/8", "other");
    public static final Property L = Property.h("xmpDM:trackNumber");
    public static final Property M = Property.f("xmpDM:videoAlphaMode", "straight", "pre-multiplied");
    public static final Property N = Property.s("xmpDM:videoAlphaUnityIsTransparent");
    public static final Property O = Property.t("xmpDM:videoColorSpace", "sRGB", "CCIR-601", "CCIR-709");
    public static final Property P = Property.A("xmpDM:videoCompressor");
    public static final Property Q = Property.t("xmpDM:videoFieldOrder", "Upper", "Lower", "Progressive");
    public static final Property R = Property.x("xmpDM:videoFrameRate", "24", "NTSC", "PAL");
    public static final Property S = Property.u("xmpDM:videoModDate");
    public static final Property T = Property.t("xmpDM:videoPixelDepth", "8Int", "16Int", "32Int", "32Float");
    public static final Property U = Property.y("xmpDM:videoPixelAspectRatio");

    /* renamed from: a  reason: collision with root package name */
    public static final Property f7115a = Property.C("xmpDM:absPeakAudioFilePath");
    public static final Property b = Property.k("xmpDM:album");
    public static final Property c = Property.k("xmpDM:altTapeName");
    public static final Property d = Property.k("xmpDM:artist");
    public static final Property e = Property.k("xmpDM:albumArtist");
    public static final Property f = Property.u("xmpDM:audioModDate");
    public static final Property g = Property.w("xmpDM:audioSampleRate");
    public static final Property h = Property.t("xmpDM:audioSampleType", "8Int", "16Int", "32Int", "32Float");
    public static final Property i = Property.t("xmpDM:audioChannelType", "Mono", "Stereo", "5.1", "7.1");
    public static final Property j = Property.A("xmpDM:audioCompressor");
    public static final Property k = Property.h("xmpDM:compilation");
    public static final Property l = Property.k("xmpDM:composer");
    public static final Property m = Property.k("xmpDM:copyright");
    public static final Property n = Property.h("xmpDM:discNumber");
    public static final Property o = Property.i("xmpDM:duration");
    public static final Property p = Property.k("xmpDM:engineer");
    public static final Property q = Property.y("xmpDM:fileDataRate");
    public static final Property r = Property.k("xmpDM:genre");
    public static final Property s = Property.k("xmpDM:instrument");
    public static final Property t = Property.t("xmpDM:key", "C", "C#", "D", "D#", ExifInterface.LONGITUDE_EAST, "F", "F#", "G", "G#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "A#", "B");
    public static final Property u = Property.k("xmpDM:logComment");
    public static final Property v = Property.s("xmpDM:loop");
    public static final Property w = Property.z("xmpDM:numberOfBeats");
    public static final Property x = Property.u("xmpDM:metadataModDate");
    public static final Property y = Property.t("xmpDM:pullDown", "WSSWW", "SSWWW", "SWWWS", "WWWSS", "WWSSW", "WSSWW_24p", "SSWWW_24p", "SWWWS_24p", "WWWSS_24p", "WWSSW_24p");
    public static final Property z = Property.C("xmpDM:relativePeakAudioFilePath");

    @Deprecated
    public static class ChannelTypePropertyConverter {

        /* renamed from: a  reason: collision with root package name */
        public static final Property f7116a = XMPDM.i;
    }
}
