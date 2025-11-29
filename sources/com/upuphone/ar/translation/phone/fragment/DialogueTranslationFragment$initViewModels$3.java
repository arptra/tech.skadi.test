package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DialogueTranslationFragment$initViewModels$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ DialogueTranslationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueTranslationFragment$initViewModels$3(DialogueTranslationFragment dialogueTranslationFragment) {
        super(1);
        this.this$0 = dialogueTranslationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        if (num != null && num.intValue() == 0) {
            LogExt.j("playTts tts播报开始", "DialogueTranslationFragment");
            this.this$0.S1();
        } else if (num != null && num.intValue() == 1) {
            LogExt.j("playTts tts播报完成", "DialogueTranslationFragment");
            this.this$0.T1();
        } else if (num != null && num.intValue() == 2) {
            LogExt.j("playTts tts播报异常", "DialogueTranslationFragment");
            if (this.this$0.p) {
                this.this$0.p = false;
                LogExt.j("playTts tts播报异常[被其他tts打断]", "DialogueTranslationFragment");
                return;
            }
            this.this$0.T1();
        }
    }
}
