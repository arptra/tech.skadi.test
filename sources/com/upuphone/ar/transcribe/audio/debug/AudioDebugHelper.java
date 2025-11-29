package com.upuphone.ar.transcribe.audio.debug;

import android.content.Context;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003J+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0003J+\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001cJ+\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ+\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0016\u0010$\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010&R\u0018\u0010,\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010&R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00104\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010/R\u0018\u00106\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"Lcom/upuphone/ar/transcribe/audio/debug/AudioDebugHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "b", "(Landroid/content/Context;)V", "c", "", "byteArray", "", "channel", "Lkotlin/Result;", "f", "([BI)Ljava/lang/Object;", "", "content", "fileName", "", "isEnd", "j", "(Ljava/lang/String;Ljava/lang/String;Z)V", "h", "k", "bytes", "i", "([BLjava/lang/String;)Ljava/lang/Object;", "e", "g", "d", "a", "Ljava/lang/String;", "bleSaveFolder", "Z", "audioDebug", "Ljava/io/FileOutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", "opusFileOutputStream", "opusFileOutputStream1", "remoteNoiseAfterFos", "muteRemoteNoiseAfterFos", "proximalNoiseAfterFos", "muteProximalNoiseAfterFos", "Ljava/io/BufferedWriter;", "Ljava/io/BufferedWriter;", "remoteSrcBw", "l", "remoteDstBw", "m", "proximalSrcBw", "n", "proximalDstBw", "o", "I", "saveCount", "Lkotlin/Function0;", "p", "Lkotlin/jvm/functions/Function0;", "audioSwitch", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAudioDebugHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioDebugHelper.kt\ncom/upuphone/ar/transcribe/audio/debug/AudioDebugHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
public final class AudioDebugHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final AudioDebugHelper f6022a = new AudioDebugHelper();
    public static String b;
    public static boolean c;
    public static FileOutputStream d;
    public static FileOutputStream e;
    public static FileOutputStream f;
    public static FileOutputStream g;
    public static FileOutputStream h;
    public static FileOutputStream i;
    public static FileOutputStream j;
    public static BufferedWriter k;
    public static BufferedWriter l;
    public static BufferedWriter m;
    public static BufferedWriter n;
    public static int o;
    public static Function0 p;

    public static final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c = true;
        String str = null;
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        String str2 = File.separator;
        String str3 = str + str2 + "audio" + str2;
        b = str3;
        LogExt.g("openDebug: audioDebug: " + c + ", path: " + str3, "AudioDebugHelper");
        c();
        o = 0;
        Function0 function0 = p;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void c() {
        f6022a.a();
        File file = new File(b, "");
        if (file.exists()) {
            FileUtils.f6184a.a(file);
        }
        boolean mkdirs = file.mkdirs();
        String str = b;
        LogExt.g("重建audio音频文件目录:" + mkdirs + ", mRootAudioPath:: " + str, "AudioDebugHelper");
    }

    public static final Object f(byte[] bArr, int i2) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        try {
            Result.Companion companion = Result.Companion;
            if (c) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                if (i2 == 0) {
                    fileOutputStream = e;
                    if (fileOutputStream == null) {
                        fileOutputStream = new FileOutputStream(new File(b, "trc_opus_ai_audio_phone_0.pcm"), true);
                        e = fileOutputStream;
                    }
                } else {
                    fileOutputStream = f;
                    if (fileOutputStream == null) {
                        fileOutputStream = new FileOutputStream(new File(b, "trc_opus_ai_audio_phone_1.pcm"), true);
                        f = fileOutputStream;
                    }
                }
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
            return Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final void h(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (m == null) {
                m = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = m;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static final void j(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (k == null) {
                k = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = k;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public final void a() {
        FileOutputStream fileOutputStream = d;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        d = null;
        FileOutputStream fileOutputStream2 = e;
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
        e = null;
        FileOutputStream fileOutputStream3 = g;
        if (fileOutputStream3 != null) {
            fileOutputStream3.close();
        }
        g = null;
        FileOutputStream fileOutputStream4 = h;
        if (fileOutputStream4 != null) {
            fileOutputStream4.close();
        }
        h = null;
        FileOutputStream fileOutputStream5 = i;
        if (fileOutputStream5 != null) {
            fileOutputStream5.close();
        }
        i = null;
        FileOutputStream fileOutputStream6 = j;
        if (fileOutputStream6 != null) {
            fileOutputStream6.close();
        }
        j = null;
        BufferedWriter bufferedWriter = k;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        k = null;
        BufferedWriter bufferedWriter2 = l;
        if (bufferedWriter2 != null) {
            bufferedWriter2.close();
        }
        l = null;
        BufferedWriter bufferedWriter3 = m;
        if (bufferedWriter3 != null) {
            bufferedWriter3.close();
        }
        m = null;
        BufferedWriter bufferedWriter4 = n;
        if (bufferedWriter4 != null) {
            bufferedWriter4.close();
        }
        n = null;
    }

    public final Object d(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            if (c) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                if (j == null) {
                    j = new FileOutputStream(new File(b, str), true);
                }
                FileOutputStream fileOutputStream = j;
                if (fileOutputStream != null) {
                    fileOutputStream.write(copyOf);
                    fileOutputStream.flush();
                }
            }
            return Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final Object e(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            if (c) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                if (h == null) {
                    h = new FileOutputStream(new File(b, str), true);
                }
                FileOutputStream fileOutputStream = h;
                if (fileOutputStream != null) {
                    fileOutputStream.write(copyOf);
                    fileOutputStream.flush();
                }
            }
            return Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final Object g(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            if (c) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                if (i == null) {
                    i = new FileOutputStream(new File(b, str), true);
                }
                FileOutputStream fileOutputStream = i;
                if (fileOutputStream != null) {
                    fileOutputStream.write(copyOf);
                    fileOutputStream.flush();
                }
            }
            return Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final Object i(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        try {
            Result.Companion companion = Result.Companion;
            if (c) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                if (g == null) {
                    g = new FileOutputStream(new File(b, str), true);
                }
                FileOutputStream fileOutputStream = g;
                if (fileOutputStream != null) {
                    fileOutputStream.write(copyOf);
                    fileOutputStream.flush();
                }
            }
            return Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void k() {
        c = false;
        a();
        o = 0;
        Function0 function0 = p;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
