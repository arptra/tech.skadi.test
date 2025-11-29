package com.upuphone.xr.sapp.fragment;

import com.meizu.common.app.LoadingDialog;
import com.upuphone.xr.sapp.databinding.FragmentFontSizeBinding;
import com.upuphone.xr.sapp.entity.GlassFontSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassFontSize;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FontSizeFragment$initView$1 extends Lambda implements Function1<GlassFontSize, Unit> {
    final /* synthetic */ FontSizeFragment this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.upuphone.xr.sapp.entity.GlassFontSize[] r0 = com.upuphone.xr.sapp.entity.GlassFontSize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.sapp.entity.GlassFontSize r1 = com.upuphone.xr.sapp.entity.GlassFontSize.BIG     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.sapp.entity.GlassFontSize r1 = com.upuphone.xr.sapp.entity.GlassFontSize.NORMAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.FontSizeFragment$initView$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontSizeFragment$initView$1(FontSizeFragment fontSizeFragment) {
        super(1);
        this.this$0 = fontSizeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassFontSize) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassFontSize glassFontSize) {
        int i;
        FragmentFontSizeBinding E0 = this.this$0.j;
        FragmentFontSizeBinding fragmentFontSizeBinding = null;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        E0.c.setChecked(false);
        FragmentFontSizeBinding E02 = this.this$0.j;
        if (E02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E02 = null;
        }
        E02.d.setChecked(false);
        if (glassFontSize == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[glassFontSize.ordinal()];
        }
        if (i == 1) {
            FragmentFontSizeBinding E03 = this.this$0.j;
            if (E03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentFontSizeBinding = E03;
            }
            fragmentFontSizeBinding.c.setChecked(true);
        } else if (i == 2) {
            FragmentFontSizeBinding E04 = this.this$0.j;
            if (E04 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentFontSizeBinding = E04;
            }
            fragmentFontSizeBinding.d.setChecked(true);
        }
        LoadingDialog F0 = this.this$0.m;
        if (F0 != null) {
            F0.dismiss();
        }
    }
}
