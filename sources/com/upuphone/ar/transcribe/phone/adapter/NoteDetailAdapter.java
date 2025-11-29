package com.upuphone.ar.transcribe.phone.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.bean.NoteDetailBean;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0007*\u0001+\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010 \u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010-\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010,¨\u00061"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "", "data", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "listener", "<init>", "(Ljava/util/List;Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;)V", "", "", "position", "z0", "(Ljava/util/List;I)I", "", "D", "Z", "H0", "()Z", "K0", "(Z)V", "isInEditMode", "E", "G0", "J0", "isEditTextChange", "F", "I", "E0", "()I", "I0", "(I)V", "editPosition", "Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "G", "Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "F0", "()Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "L0", "(Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;)V", "updatingView", "H", "lastEditView", "com/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$editListener$1", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$editListener$1;", "editListener", "OnItemEditListener", "OtherItemProvider", "SelfItemProvider", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NoteDetailAdapter extends BaseProviderMultiAdapter<NoteDetailBean> {
    public boolean D;
    public boolean E;
    public int F = -1;
    public ClipboardEditText G;
    public ClipboardEditText H;
    public final NoteDetailAdapter$editListener$1 I;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "", "onModeChange", "", "isEdit", "", "view", "Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "onTextChange", "position", "", "item", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "newStr", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemEditListener {
        void onModeChange(boolean z, ClipboardEditText clipboardEditText);

        void onTextChange(int i, NoteDetailBean noteDetailBean, String str, ClipboardEditText clipboardEditText);
    }

    @SourceDebugExtension({"SMAP\nNoteDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OtherItemProvider\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,87:1\n58#2,23:88\n93#2,3:111\n*S KotlinDebug\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OtherItemProvider\n*L\n79#1:88,23\n79#1:111,3\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OtherItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "listener", "<init>", "(Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter;Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;)V", "e", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "u", "()Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class OtherItemProvider extends BaseItemProvider<NoteDetailBean> {
        public final OnItemEditListener e;
        public final /* synthetic */ NoteDetailAdapter f;

        public OtherItemProvider(NoteDetailAdapter noteDetailAdapter, OnItemEditListener onItemEditListener) {
            Intrinsics.checkNotNullParameter(onItemEditListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f = noteDetailAdapter;
            this.e = onItemEditListener;
        }

        public int g() {
            return 1;
        }

        public int h() {
            return R.layout.trsb_detail_item_otherside;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, NoteDetailBean noteDetailBean) {
            String str;
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(noteDetailBean, "item");
            int Q = this.f.Q(noteDetailBean);
            baseViewHolder.setGone(R.id.v_last_divider, Q != CollectionsKt.getLastIndex(this.f.getData()));
            int i = R.id.content;
            String content = noteDetailBean.getContent();
            if (content == null || (str = StringsKt.trim((CharSequence) content).toString()) == null) {
                str = "";
            }
            baseViewHolder.setText(i, (CharSequence) str);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.content);
            clipboardEditText.h(new NoteDetailAdapter$OtherItemProvider$convert$1(this, clipboardEditText));
            clipboardEditText.addTextChangedListener(new NoteDetailAdapter$OtherItemProvider$convert$$inlined$doAfterTextChanged$1(this, Q, noteDetailBean, clipboardEditText));
        }

        public final OnItemEditListener u() {
            return this.e;
        }
    }

    @SourceDebugExtension({"SMAP\nNoteDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$SelfItemProvider\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,87:1\n58#2,23:88\n93#2,3:111\n*S KotlinDebug\n*F\n+ 1 NoteDetailAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$SelfItemProvider\n*L\n63#1:88,23\n63#1:111,3\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$SelfItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "listener", "<init>", "(Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter;Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;)V", "e", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "u", "()Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class SelfItemProvider extends BaseItemProvider<NoteDetailBean> {
        public final OnItemEditListener e;
        public final /* synthetic */ NoteDetailAdapter f;

        public SelfItemProvider(NoteDetailAdapter noteDetailAdapter, OnItemEditListener onItemEditListener) {
            Intrinsics.checkNotNullParameter(onItemEditListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.f = noteDetailAdapter;
            this.e = onItemEditListener;
        }

        public int g() {
            return 0;
        }

        public int h() {
            return R.layout.trsb_detial_item_self;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, NoteDetailBean noteDetailBean) {
            String str;
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(noteDetailBean, "item");
            int Q = this.f.Q(noteDetailBean);
            baseViewHolder.setGone(R.id.v_last_divider, Q != CollectionsKt.getLastIndex(this.f.getData()));
            int i = R.id.content;
            String content = noteDetailBean.getContent();
            if (content == null || (str = StringsKt.trim((CharSequence) content).toString()) == null) {
                str = "";
            }
            baseViewHolder.setText(i, (CharSequence) str);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.content);
            clipboardEditText.h(new NoteDetailAdapter$SelfItemProvider$convert$1(this, clipboardEditText));
            clipboardEditText.addTextChangedListener(new NoteDetailAdapter$SelfItemProvider$convert$$inlined$doAfterTextChanged$1(this, Q, noteDetailBean, clipboardEditText));
        }

        public final OnItemEditListener u() {
            return this.e;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteDetailAdapter(List list, OnItemEditListener onItemEditListener) {
        super(list);
        Intrinsics.checkNotNullParameter(onItemEditListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        NoteDetailAdapter$editListener$1 noteDetailAdapter$editListener$1 = new NoteDetailAdapter$editListener$1(this, onItemEditListener);
        this.I = noteDetailAdapter$editListener$1;
        v0(new SelfItemProvider(this, noteDetailAdapter$editListener$1));
        v0(new OtherItemProvider(this, noteDetailAdapter$editListener$1));
    }

    public final int E0() {
        return this.F;
    }

    public final ClipboardEditText F0() {
        return this.G;
    }

    public final boolean G0() {
        return this.E;
    }

    public final boolean H0() {
        return this.D;
    }

    public final void I0(int i) {
        this.F = i;
    }

    public final void J0(boolean z) {
        this.E = z;
    }

    public final void K0(boolean z) {
        this.D = z;
    }

    public final void L0(ClipboardEditText clipboardEditText) {
        this.G = clipboardEditText;
    }

    public int z0(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        return ((NoteDetailBean) list.get(i)).getOwnerType();
    }
}
