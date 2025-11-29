package com.upuphone.ar.transcribe.phone.activity;

import com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding;
import com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.transcribe.phone.bean.NoteDetailBean;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeDetailActivity$initialRecyclerView$1", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "onModeChange", "", "isEdit", "", "view", "Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "onTextChange", "position", "", "item", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "newStr", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeDetailActivity$initialRecyclerView$1 implements NoteDetailAdapter.OnItemEditListener {
    final /* synthetic */ TranscribeDetailActivity this$0;

    public TranscribeDetailActivity$initialRecyclerView$1(TranscribeDetailActivity transcribeDetailActivity) {
        this.this$0 = transcribeDetailActivity;
    }

    public void onModeChange(boolean z, @NotNull ClipboardEditText clipboardEditText) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "view");
        TranscribeDetailActivity transcribeDetailActivity = this.this$0;
        transcribeDetailActivity.changeMode(transcribeDetailActivity.isInEditModel());
    }

    public void onTextChange(int i, @NotNull NoteDetailBean noteDetailBean, @Nullable String str, @NotNull ClipboardEditText clipboardEditText) {
        Intrinsics.checkNotNullParameter(noteDetailBean, "item");
        Intrinsics.checkNotNullParameter(clipboardEditText, "view");
        TranscribeDetailActivity transcribeDetailActivity = this.this$0;
        Long id = noteDetailBean.getId();
        if (str == null) {
            str = "";
        }
        String str2 = str;
        int ownerType = noteDetailBean.getOwnerType();
        TranscribeBean access$getMTranscribeBean$p = this.this$0.mTranscribeBean;
        ActivityTranscribeDetailBinding activityTranscribeDetailBinding = null;
        Long id2 = access$getMTranscribeBean$p != null ? access$getMTranscribeBean$p.getId() : null;
        Intrinsics.checkNotNull(id2);
        transcribeDetailActivity.updatingMessage = new MessageEntity(id, str2, ownerType, 0, id2.longValue());
        ActivityTranscribeDetailBinding access$getMBinding$p = this.this$0.mBinding;
        if (access$getMBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeDetailBinding = access$getMBinding$p;
        }
        activityTranscribeDetailBinding.i.setTextMenuEnable(this.this$0.isEditTextChange());
    }
}
