package com.xjsd.ai.assistant.phone;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.common.AudioFocusManager;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/phone/AudioFocusManageDelegate;", "", "<init>", "()V", "", "node", "", "a", "(I)V", "b", "d", "c", "I", "mShortFocusId", "mMixFocusId", "ControlNode", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioFocusManageDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static final AudioFocusManageDelegate f8517a = new AudioFocusManageDelegate();
    public static int b = -1;
    public static int c = -1;

    @Keep
    @Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/ai/assistant/phone/AudioFocusManageDelegate$ControlNode;", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface ControlNode {
    }

    public static final void a(int i) {
        ILog.a("AudioFocusManageDelegate", "音频焦点控制节点->" + i);
        if (i == 0) {
            f8517a.b();
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        ILog.a("AudioFocusManageDelegate", "不支持该音频焦点控制类型->" + i);
                        return;
                    }
                    f8517a.c();
                } else if (DeviceUtils.d()) {
                    f8517a.b();
                    c = AudioFocusManager.a().f(ContextHelper.a(), (AudioFocusManager.RequestAudioFocusCallback) null);
                }
            } else if (DeviceUtils.d()) {
                f8517a.d();
            }
        } else if (DeviceUtils.d()) {
            f8517a.b();
            b = AudioFocusManager.a().g(ContextHelper.a(), (AudioFocusManager.RequestAudioFocusCallback) null);
        }
    }

    public final void b() {
        d();
        c();
    }

    public final void c() {
        int i = c;
        if (i != -1) {
            ILog.a("AudioFocusManageDelegate", "释放混音音频焦点->" + i);
            AudioFocusManager.a().c(ContextHelper.a(), c);
            c = -1;
        }
    }

    public final void d() {
        int i = b;
        if (i != -1) {
            ILog.a("AudioFocusManageDelegate", "释放短音频焦点->" + i);
            AudioFocusManager.a().d(ContextHelper.a(), b);
            b = -1;
        }
    }
}
