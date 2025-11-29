package com.upuphone.ar.translation.phone.adapter;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.Space;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003:;<B\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u00126\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010!J\u0017\u0010$\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010!J\u0017\u0010%\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b%\u0010!J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0018RG\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00078\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100RG\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u00078\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010+R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010+¨\u0006="}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "", "isEnableEdit", "", "data", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Landroid/text/Editable;", "editable", "", "onTextChanged", "isEdited", "onCallbackEdit", "<init>", "(ZLjava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "", "z0", "(Ljava/util/List;I)I", "M0", "()Z", "isRecordRtl", "isViewRtl", "R0", "(ZZ)V", "", "src", "Landroid/text/SpannableString;", "O0", "(Ljava/lang/String;)Landroid/text/SpannableString;", "dst", "N0", "Q0", "P0", "Lcom/upuphone/ar/translation/phone/view/ClipboardEditText;", "et", "K0", "(Lcom/upuphone/ar/translation/phone/view/ClipboardEditText;)V", "D", "Z", "L0", "E", "Lkotlin/jvm/functions/Function2;", "J0", "()Lkotlin/jvm/functions/Function2;", "F", "I0", "G", "mIsItemEdited", "H", "mIsRecordRtl", "I", "mIsViewRtl", "J", "Companion", "ProximalItemProvider", "RemoteItemProvider", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NoteDetailAdapter extends BaseProviderMultiAdapter<NoteDetailBean> {
    public static final Companion J = new Companion((DefaultConstructorMarker) null);
    public final boolean D;
    public final Function2 E;
    public final Function2 F;
    public boolean G;
    public boolean H;
    public boolean I;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$Companion;", "", "()V", "ITEM_PROXIMAL", "", "ITEM_REMOTE", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nNoteDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$ProximalItemProvider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,347:1\n262#2,2:348\n262#2,2:350\n262#2,2:352\n262#2,2:354\n262#2,2:356\n262#2,2:358\n65#3,16:360\n93#3,3:376\n*S KotlinDebug\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$ProximalItemProvider\n*L\n107#1:348,2\n108#1:350,2\n119#1:352,2\n120#1:354,2\n130#1:356,2\n131#1:358,2\n139#1:360,16\n139#1:376,3\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$ProximalItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ProximalItemProvider extends BaseItemProvider<NoteDetailBean> {
        public ProximalItemProvider() {
        }

        public int g() {
            return 0;
        }

        public int h() {
            return R.layout.item_record_detail_proximal;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, NoteDetailBean noteDetailBean) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(noteDetailBean, "item");
            int Q = NoteDetailAdapter.this.Q(noteDetailBean);
            int i = 0;
            baseViewHolder.setGone(R.id.v_me_last_divider, Q != CollectionsKt.getLastIndex(NoteDetailAdapter.this.getData()));
            Space space = (Space) baseViewHolder.getView(R.id.v_me_divider);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.et_me_dst);
            clipboardEditText.setEnableClickEdit(NoteDetailAdapter.this.L0());
            NoteDetailAdapter.this.K0(clipboardEditText);
            String obj = StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString();
            String obj2 = StringsKt.trim((CharSequence) noteDetailBean.getDst()).toString();
            if (noteDetailBean.getTransType() == 1) {
                clipboardEditText.setText(obj);
            } else if (noteDetailBean.getNoteStatus() != 2) {
                SpannableString E0 = NoteDetailAdapter.this.O0(obj);
                SpannableString D0 = NoteDetailAdapter.this.N0(obj2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (noteDetailBean.isDisplaySrc()) {
                    boolean z = (StringsKt.isBlank(E0) ^ true) || (StringsKt.isBlank(D0) ^ true);
                    space.setVisibility(z ? 0 : 8);
                    if (!z) {
                        i = 8;
                    }
                    clipboardEditText.setVisibility(i);
                    if ((!StringsKt.isBlank(E0)) && (!StringsKt.isBlank(D0))) {
                        spannableStringBuilder.append(E0).append(StringUtils.LF).append(D0);
                    } else if (!StringsKt.isBlank(E0)) {
                        spannableStringBuilder.append(E0);
                    } else if (!StringsKt.isBlank(D0)) {
                        spannableStringBuilder.append(D0);
                    }
                } else {
                    boolean z2 = !StringsKt.isBlank(D0);
                    space.setVisibility(z2 ? 0 : 8);
                    if (!z2) {
                        i = 8;
                    }
                    clipboardEditText.setVisibility(i);
                    spannableStringBuilder.append(D0);
                }
                clipboardEditText.setText(spannableStringBuilder);
                if (noteDetailBean.getNoteStatus() == 0 && clipboardEditText.q()) {
                    clipboardEditText.j();
                }
            } else {
                space.setVisibility(8);
                clipboardEditText.setVisibility(8);
                clipboardEditText.setText("");
            }
            clipboardEditText.i(new NoteDetailAdapter$ProximalItemProvider$convert$2(NoteDetailAdapter.this, Q));
            clipboardEditText.addTextChangedListener(new NoteDetailAdapter$ProximalItemProvider$convert$$inlined$addTextChangedListener$default$1(clipboardEditText, NoteDetailAdapter.this, Q));
        }
    }

    @SourceDebugExtension({"SMAP\nNoteDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$RemoteItemProvider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,347:1\n262#2,2:348\n262#2,2:350\n262#2,2:352\n262#2,2:354\n262#2,2:356\n262#2,2:358\n65#3,16:360\n93#3,3:376\n*S KotlinDebug\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$RemoteItemProvider\n*L\n187#1:348,2\n188#1:350,2\n199#1:352,2\n200#1:354,2\n210#1:356,2\n211#1:358,2\n219#1:360,16\n219#1:376,3\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter$RemoteItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/NoteDetailAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class RemoteItemProvider extends BaseItemProvider<NoteDetailBean> {
        public RemoteItemProvider() {
        }

        public int g() {
            return 1;
        }

        public int h() {
            return R.layout.item_record_detail_remote;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, NoteDetailBean noteDetailBean) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(noteDetailBean, "item");
            int Q = NoteDetailAdapter.this.Q(noteDetailBean);
            int i = 0;
            baseViewHolder.setGone(R.id.v_other_last_divider, Q != CollectionsKt.getLastIndex(NoteDetailAdapter.this.getData()));
            Space space = (Space) baseViewHolder.getView(R.id.v_other_divider);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.et_other_dst);
            clipboardEditText.setEnableClickEdit(NoteDetailAdapter.this.L0());
            NoteDetailAdapter.this.K0(clipboardEditText);
            String obj = StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString();
            String obj2 = StringsKt.trim((CharSequence) noteDetailBean.getDst()).toString();
            if (noteDetailBean.getTransType() == 1) {
                clipboardEditText.setText(obj);
            } else if (noteDetailBean.getNoteStatus() != 2) {
                SpannableString G0 = NoteDetailAdapter.this.Q0(obj);
                SpannableString F0 = NoteDetailAdapter.this.P0(obj2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (noteDetailBean.isDisplaySrc()) {
                    boolean z = (StringsKt.isBlank(G0) ^ true) || (StringsKt.isBlank(F0) ^ true);
                    space.setVisibility(z ? 0 : 8);
                    if (!z) {
                        i = 8;
                    }
                    clipboardEditText.setVisibility(i);
                    if ((!StringsKt.isBlank(G0)) && (!StringsKt.isBlank(F0))) {
                        spannableStringBuilder.append(G0).append(StringUtils.LF).append(F0);
                    } else if (!StringsKt.isBlank(G0)) {
                        spannableStringBuilder.append(G0);
                    } else if (!StringsKt.isBlank(F0)) {
                        spannableStringBuilder.append(F0);
                    }
                } else {
                    boolean z2 = !StringsKt.isBlank(F0);
                    space.setVisibility(z2 ? 0 : 8);
                    if (!z2) {
                        i = 8;
                    }
                    clipboardEditText.setVisibility(i);
                    spannableStringBuilder.append(F0);
                }
                clipboardEditText.setText(spannableStringBuilder);
                if (noteDetailBean.getNoteStatus() == 0 && clipboardEditText.q()) {
                    clipboardEditText.j();
                }
            } else {
                space.setVisibility(8);
                clipboardEditText.setVisibility(8);
                clipboardEditText.setText("");
            }
            clipboardEditText.i(new NoteDetailAdapter$RemoteItemProvider$convert$2(NoteDetailAdapter.this, Q));
            clipboardEditText.addTextChangedListener(new NoteDetailAdapter$RemoteItemProvider$convert$$inlined$addTextChangedListener$default$1(NoteDetailAdapter.this, Q));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteDetailAdapter(boolean z, List list, Function2 function2, Function2 function22) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(function2, "onTextChanged");
        Intrinsics.checkNotNullParameter(function22, "onCallbackEdit");
        this.D = z;
        this.E = function2;
        this.F = function22;
        v0(new ProximalItemProvider());
        v0(new RemoteItemProvider());
    }

    public final Function2 I0() {
        return this.F;
    }

    public final Function2 J0() {
        return this.E;
    }

    public final void K0(ClipboardEditText clipboardEditText) {
        int i = 6;
        int i2 = 8388613;
        if (this.H) {
            if (this.I) {
                i2 = 8388611;
            }
            clipboardEditText.setGravity(i2);
            if (this.I) {
                i = 5;
            }
            clipboardEditText.setTextAlignment(i);
            return;
        }
        if (!this.I) {
            i2 = 8388611;
        }
        clipboardEditText.setGravity(i2);
        if (!this.I) {
            i = 5;
        }
        clipboardEditText.setTextAlignment(i);
    }

    public final boolean L0() {
        return this.D;
    }

    public final boolean M0() {
        return this.G;
    }

    public final SpannableString N0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_me_dst)), 0, spannableString.length(), 18);
        return spannableString;
    }

    public final SpannableString O0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_me_src)), 0, str.length(), 18);
        return spannableString;
    }

    public final SpannableString P0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_other_dst)), 0, spannableString.length(), 18);
        return spannableString;
    }

    public final SpannableString Q0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_other_src)), 0, str.length(), 18);
        return spannableString;
    }

    public final void R0(boolean z, boolean z2) {
        this.H = z;
        this.I = z2;
        if (!getData().isEmpty()) {
            notifyDataSetChanged();
        }
    }

    public int z0(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        int speaker = ((NoteDetailBean) list.get(i)).getSpeaker();
        return (speaker == 0 || speaker != 1) ? 0 : 1;
    }
}
