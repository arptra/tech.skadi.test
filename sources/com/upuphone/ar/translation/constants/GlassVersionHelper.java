package com.upuphone.ar.translation.constants;

import androidx.annotation.IntRange;
import com.meizu.account.oauth.BuildConfig;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/constants/GlassVersionHelper;", "", "()V", "TAG", "", "mGlassVersionCode", "", "getGlassVersionCode", "isDomOta1ForAirPro", "", "isIntlOta1ForAir", "isIntlOta1ForAirPro", "isIntlOta3ForAir", "setGlassVersionCode", "", "versionCode", "GlassVersionCode", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassVersionHelper {
    @NotNull
    public static final GlassVersionHelper INSTANCE = new GlassVersionHelper();
    @NotNull
    private static final String TAG = "GlassVersionHelper";
    @IntRange
    private static int mGlassVersionCode;

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/GlassVersionHelper$GlassVersionCode;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface GlassVersionCode {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int ONE = 1;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/constants/GlassVersionHelper$GlassVersionCode$Companion;", "", "()V", "ONE", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ONE = 1;

            private Companion() {
            }
        }
    }

    private GlassVersionHelper() {
    }

    public final int getGlassVersionCode() {
        return mGlassVersionCode;
    }

    public final boolean isDomOta1ForAirPro() {
        IGlassInfo glassInfo = TranslatorConstants.INSTANCE.getGlassInfo();
        return glassInfo != null && GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(glassInfo.getRomVersion())), "1.1.1") >= 0;
    }

    public final boolean isIntlOta1ForAir() {
        IGlassInfo glassInfo = TranslatorConstants.INSTANCE.getGlassInfo();
        return glassInfo != null && GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(glassInfo.getRomVersion())), "1.0.2") >= 0;
    }

    public final boolean isIntlOta1ForAirPro() {
        IGlassInfo glassInfo = TranslatorConstants.INSTANCE.getGlassInfo();
        return glassInfo != null && GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(glassInfo.getRomVersion())), "1.1.1") >= 0;
    }

    public final boolean isIntlOta3ForAir() {
        IGlassInfo glassInfo = TranslatorConstants.INSTANCE.getGlassInfo();
        return glassInfo != null && GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(glassInfo.getRomVersion())), BuildConfig.VERSION_NAME) >= 0;
    }

    public final void setGlassVersionCode(int i) {
        if (i < 0) {
            i = 0;
        }
        mGlassVersionCode = i;
    }
}
