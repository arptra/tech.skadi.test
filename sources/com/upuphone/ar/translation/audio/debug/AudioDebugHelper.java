package com.upuphone.ar.translation.audio.debug;

import android.content.Context;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec;
import com.upuphone.ar.translation.utils.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u0003J\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0010J'\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0018J'\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\"\u0010\u0003J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0003J\u001d\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b%\u0010\u0010J\u001d\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b&\u0010\u0010J\u001d\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b'\u0010\u0010J\u001d\u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b(\u0010\u0010J\u001d\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b)\u0010\u0010J\u001d\u0010*\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b*\u0010\u0010J\u001d\u0010+\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b+\u0010\u0010J\u001d\u0010,\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b,\u0010\u0010J\u001d\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0010J\u001d\u0010.\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b.\u0010\u0010J\u001d\u0010/\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b/\u0010\u0010J\u001d\u00100\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b0\u0010\u0010J\u001d\u00101\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b1\u0010\u0010J\u001d\u00102\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b2\u0010\u0010R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u00103R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u00108R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u00108R\u0018\u0010=\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u00108R\u0018\u0010>\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u00108R\u0018\u0010?\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00108R\u0018\u0010@\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u00108R\u0018\u0010A\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u00108R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00108R\u0018\u0010C\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u00108R\u0018\u0010D\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u00108R\u0018\u0010E\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u00108R\u0018\u0010F\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u00108R\u0018\u0010G\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u00108R\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u00108R\u0018\u0010I\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u00108R\u0018\u0010J\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u00108R\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010LR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010RR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010V¨\u0006Y"}, d2 = {"Lcom/upuphone/ar/translation/audio/debug/AudioDebugHelper;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)V", "a", "e", "", "byteArray", "", "fileName", "f", "([BLjava/lang/String;)V", "r", "i", "s", "content", "", "isEnd", "o", "(Ljava/lang/String;Ljava/lang/String;Z)V", "m", "l", "j", "b", "()Z", "Lkotlin/Function0;", "audioSwitch", "d", "(Lkotlin/jvm/functions/Function0;)V", "C", "B", "bytes", "n", "h", "k", "g", "p", "q", "v", "y", "t", "u", "A", "z", "x", "w", "Ljava/lang/String;", "bleSaveFolder", "Z", "audioDebug", "Ljava/io/FileOutputStream;", "Ljava/io/FileOutputStream;", "sourceAudioFos", "sourceSecondAudioFos", "opusFos", "opusSecondFos", "remoteNoiseAfterFos", "muteRemoteNoiseAfterFos", "proximalNoiseAfterFos", "muteProximalNoiseAfterFos", "roleProximalAfterFos", "roleRemoteAfterFos", "teleOpusProximalAfterFos", "teleOpusRemoteAfterFos", "teleProximalAfterFos", "teleRemoteAfterFos", "teleRemoteTtsOpusFos", "teleRemoteTtsFos", "teleProximalTtsOpusFos", "teleProximalTtsFos", "Ljava/io/BufferedWriter;", "Ljava/io/BufferedWriter;", "remoteSrcBw", "remoteDstBw", "proximalSrcBw", "proximalDstBw", "", "I", "saveCount", "Lkotlin/jvm/functions/Function0;", "Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "Lcom/upuphone/ar/translation/phone/helper/TranslatorOpusCodec;", "mRemoteOpusCodec", "mProximalOpusCodec", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioDebugHelper {
    public static Function0 A;
    public static TranslatorOpusCodec B;
    public static TranslatorOpusCodec C;

    /* renamed from: a  reason: collision with root package name */
    public static final AudioDebugHelper f6196a = new AudioDebugHelper();
    public static String b;
    public static boolean c;
    public static FileOutputStream d;
    public static FileOutputStream e;
    public static FileOutputStream f;
    public static FileOutputStream g;
    public static FileOutputStream h;
    public static FileOutputStream i;
    public static FileOutputStream j;
    public static FileOutputStream k;
    public static FileOutputStream l;
    public static FileOutputStream m;
    public static FileOutputStream n;
    public static FileOutputStream o;
    public static FileOutputStream p;
    public static FileOutputStream q;
    public static FileOutputStream r;
    public static FileOutputStream s;
    public static FileOutputStream t;
    public static FileOutputStream u;
    public static BufferedWriter v;
    public static BufferedWriter w;
    public static BufferedWriter x;
    public static BufferedWriter y;
    public static int z;

    public static final void C() {
        A = null;
    }

    public static final boolean b() {
        return c;
    }

    public static final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        c = true;
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String str = File.separator;
        String str2 = absolutePath + str + "audio" + str;
        b = str2;
        LogExt.j("openDebug: audioDebug: " + c + ", path: " + str2, "AudioDebugHelper");
        e();
        z = 0;
        TranslatorOpusCodec translatorOpusCodec = new TranslatorOpusCodec();
        translatorOpusCodec.c(TranslatorConstants.isMono());
        B = translatorOpusCodec;
        TranslatorOpusCodec translatorOpusCodec2 = new TranslatorOpusCodec();
        translatorOpusCodec2.c(TranslatorConstants.isMono());
        C = translatorOpusCodec2;
        Function0 function0 = A;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void d(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "audioSwitch");
        A = function0;
    }

    public static final void e() {
        f6196a.a();
        File file = new File(b, "");
        if (file.exists()) {
            FileUtils.f6363a.a(file);
        }
        boolean mkdirs = file.mkdirs();
        String str = b;
        LogExt.j("重建audio音频文件目录:" + mkdirs + ", mRootAudioPath:: " + str, "AudioDebugHelper");
    }

    public static final void f(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (d == null) {
                d = new FileOutputStream(new File(b, str), true);
            }
            int i2 = z;
            z = i2 + 1;
            LogExt.f("saveAudioSource:  " + i2, "AudioDebugHelper", "saveAudioSource", 0, 4, (Object) null);
            FileOutputStream fileOutputStream = d;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public static final void i(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (f == null) {
                f = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = f;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public static final void j(String str, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (y == null) {
                y = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = y;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z2) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static final void l(String str, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (x == null) {
                x = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = x;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z2) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static final void m(String str, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (w == null) {
                w = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = w;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z2) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static final void o(String str, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        if (c && !StringsKt.isBlank(str)) {
            if (v == null) {
                v = new BufferedWriter(new FileWriter(new File(b, str2), true));
            }
            BufferedWriter bufferedWriter = v;
            if (bufferedWriter != null) {
                bufferedWriter.append(str).append(" ");
                bufferedWriter.flush();
                if (z2) {
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static final void r(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (e == null) {
                e = new FileOutputStream(new File(b, str), true);
            }
            int i2 = z;
            z = i2 + 1;
            LogExt.f("saveSecondAudioSource:  " + i2, "AudioDebugHelper", "saveSecondAudioSource", 0, 4, (Object) null);
            FileOutputStream fileOutputStream = e;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public static final void s(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        Intrinsics.checkNotNullParameter(str, "fileName");
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
    }

    public final void A(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (r == null) {
                r = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = r;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void B() {
        c = false;
        a();
        z = 0;
        TranslatorOpusCodec translatorOpusCodec = B;
        if (translatorOpusCodec != null) {
            translatorOpusCodec.e();
        }
        B = null;
        TranslatorOpusCodec translatorOpusCodec2 = C;
        if (translatorOpusCodec2 != null) {
            translatorOpusCodec2.e();
        }
        C = null;
        Function0 function0 = A;
        if (function0 != null) {
            function0.invoke();
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
        FileOutputStream fileOutputStream3 = f;
        if (fileOutputStream3 != null) {
            fileOutputStream3.close();
        }
        f = null;
        FileOutputStream fileOutputStream4 = g;
        if (fileOutputStream4 != null) {
            fileOutputStream4.close();
        }
        g = null;
        FileOutputStream fileOutputStream5 = h;
        if (fileOutputStream5 != null) {
            fileOutputStream5.close();
        }
        h = null;
        FileOutputStream fileOutputStream6 = i;
        if (fileOutputStream6 != null) {
            fileOutputStream6.close();
        }
        i = null;
        FileOutputStream fileOutputStream7 = j;
        if (fileOutputStream7 != null) {
            fileOutputStream7.close();
        }
        j = null;
        FileOutputStream fileOutputStream8 = k;
        if (fileOutputStream8 != null) {
            fileOutputStream8.close();
        }
        k = null;
        FileOutputStream fileOutputStream9 = l;
        if (fileOutputStream9 != null) {
            fileOutputStream9.close();
        }
        l = null;
        FileOutputStream fileOutputStream10 = m;
        if (fileOutputStream10 != null) {
            fileOutputStream10.close();
        }
        m = null;
        FileOutputStream fileOutputStream11 = n;
        if (fileOutputStream11 != null) {
            fileOutputStream11.close();
        }
        n = null;
        FileOutputStream fileOutputStream12 = o;
        if (fileOutputStream12 != null) {
            fileOutputStream12.close();
        }
        o = null;
        FileOutputStream fileOutputStream13 = p;
        if (fileOutputStream13 != null) {
            fileOutputStream13.close();
        }
        p = null;
        FileOutputStream fileOutputStream14 = q;
        if (fileOutputStream14 != null) {
            fileOutputStream14.close();
        }
        q = null;
        FileOutputStream fileOutputStream15 = r;
        if (fileOutputStream15 != null) {
            fileOutputStream15.close();
        }
        r = null;
        FileOutputStream fileOutputStream16 = s;
        if (fileOutputStream16 != null) {
            fileOutputStream16.close();
        }
        s = null;
        FileOutputStream fileOutputStream17 = t;
        if (fileOutputStream17 != null) {
            fileOutputStream17.close();
        }
        t = null;
        FileOutputStream fileOutputStream18 = u;
        if (fileOutputStream18 != null) {
            fileOutputStream18.close();
        }
        u = null;
        BufferedWriter bufferedWriter = v;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        v = null;
        BufferedWriter bufferedWriter2 = w;
        if (bufferedWriter2 != null) {
            bufferedWriter2.close();
        }
        w = null;
        BufferedWriter bufferedWriter3 = x;
        if (bufferedWriter3 != null) {
            bufferedWriter3.close();
        }
        x = null;
        BufferedWriter bufferedWriter4 = y;
        if (bufferedWriter4 != null) {
            bufferedWriter4.close();
        }
        y = null;
    }

    public final void g(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (k == null) {
                k = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = k;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void h(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
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
    }

    public final void k(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
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
    }

    public final void n(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
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
    }

    public final void p(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (l == null) {
                l = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = l;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void q(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (m == null) {
                m = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = m;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void t(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (n == null) {
                n = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = n;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void u(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (o == null) {
                o = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = o;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void v(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (p == null) {
                p = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = p;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(byte[] r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            boolean r2 = c     // Catch:{ Exception -> 0x0026 }
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            int r2 = r3.length     // Catch:{ Exception -> 0x0026 }
            byte[] r2 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0026 }
            com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec r3 = C     // Catch:{ Exception -> 0x0026 }
            if (r3 == 0) goto L_0x0028
            r0 = 40
            byte[] r2 = r3.a(r2, r0)     // Catch:{ Exception -> 0x0026 }
            if (r2 != 0) goto L_0x002b
            goto L_0x0028
        L_0x0026:
            r2 = move-exception
            goto L_0x0049
        L_0x0028:
            r2 = 0
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0026 }
        L_0x002b:
            java.io.FileOutputStream r3 = u     // Catch:{ Exception -> 0x0026 }
            if (r3 != 0) goto L_0x003e
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0026 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = b     // Catch:{ Exception -> 0x0026 }
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0026 }
            r4 = 1
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0026 }
            u = r3     // Catch:{ Exception -> 0x0026 }
        L_0x003e:
            java.io.FileOutputStream r3 = u     // Catch:{ Exception -> 0x0026 }
            if (r3 == 0) goto L_0x0063
            r3.write(r2)     // Catch:{ Exception -> 0x0026 }
            r3.flush()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0063
        L_0x0049:
            java.lang.String r2 = kotlin.ExceptionsKt.stackTraceToString(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveTeleProximalTts error="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AudioDebugHelper"
            com.upuphone.ar.translation.ext.LogExt.j(r2, r3)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.audio.debug.AudioDebugHelper.w(byte[], java.lang.String):void");
    }

    public final void x(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (t == null) {
                t = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = t;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    public final void y(byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "fileName");
        if (c) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            if (q == null) {
                q = new FileOutputStream(new File(b, str), true);
            }
            FileOutputStream fileOutputStream = q;
            if (fileOutputStream != null) {
                fileOutputStream.write(copyOf);
                fileOutputStream.flush();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(byte[] r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            boolean r2 = c     // Catch:{ Exception -> 0x0026 }
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            int r2 = r3.length     // Catch:{ Exception -> 0x0026 }
            byte[] r2 = java.util.Arrays.copyOf(r3, r2)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r3 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0026 }
            com.upuphone.ar.translation.phone.helper.TranslatorOpusCodec r3 = B     // Catch:{ Exception -> 0x0026 }
            if (r3 == 0) goto L_0x0028
            r0 = 40
            byte[] r2 = r3.a(r2, r0)     // Catch:{ Exception -> 0x0026 }
            if (r2 != 0) goto L_0x002b
            goto L_0x0028
        L_0x0026:
            r2 = move-exception
            goto L_0x0049
        L_0x0028:
            r2 = 0
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0026 }
        L_0x002b:
            java.io.FileOutputStream r3 = s     // Catch:{ Exception -> 0x0026 }
            if (r3 != 0) goto L_0x003e
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0026 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = b     // Catch:{ Exception -> 0x0026 }
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0026 }
            r4 = 1
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0026 }
            s = r3     // Catch:{ Exception -> 0x0026 }
        L_0x003e:
            java.io.FileOutputStream r3 = s     // Catch:{ Exception -> 0x0026 }
            if (r3 == 0) goto L_0x0063
            r3.write(r2)     // Catch:{ Exception -> 0x0026 }
            r3.flush()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0063
        L_0x0049:
            java.lang.String r2 = kotlin.ExceptionsKt.stackTraceToString(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveTeleRemoteTts error="
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AudioDebugHelper"
            com.upuphone.ar.translation.ext.LogExt.j(r2, r3)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.audio.debug.AudioDebugHelper.z(byte[], java.lang.String):void");
    }
}
