package com.upuphone.ar.transcribe.utils;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/DataStoreUtils;", "", "<init>", "()V", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "b", "Landroidx/datastore/preferences/core/Preferences$Key;", "DEBUG_AUDIO", "", "c", "AUDIO_SAVE_TYPE", "d", "IS_LANG_TYPE_TIPS_SHOWN", "e", "USE_BLE", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataStoreUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/ar/transcribe/utils/DataStoreUtils\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,136:1\n53#2:137\n55#2:141\n53#2:142\n55#2:146\n53#2:147\n55#2:151\n53#2:152\n55#2:156\n50#3:138\n55#3:140\n50#3:143\n55#3:145\n50#3:148\n55#3:150\n50#3:153\n55#3:155\n106#4:139\n106#4:144\n106#4:149\n106#4:154\n*S KotlinDebug\n*F\n+ 1 DataStoreUtils.kt\ncom/upuphone/ar/transcribe/utils/DataStoreUtils\n*L\n45#1:137\n45#1:141\n70#1:142\n70#1:146\n95#1:147\n95#1:151\n120#1:152\n120#1:156\n45#1:138\n45#1:140\n70#1:143\n70#1:145\n95#1:148\n95#1:150\n120#1:153\n120#1:155\n45#1:139\n70#1:144\n95#1:149\n120#1:154\n*E\n"})
public final class DataStoreUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final DataStoreUtils f6174a = new DataStoreUtils();
    public static final Preferences.Key b = PreferencesKeys.a("debug_audio");
    public static final Preferences.Key c = PreferencesKeys.d("audio_save_type");
    public static final Preferences.Key d = PreferencesKeys.a("is_lang_type_tips_shown");
    public static final Preferences.Key e = PreferencesKeys.a("use_ble");
}
