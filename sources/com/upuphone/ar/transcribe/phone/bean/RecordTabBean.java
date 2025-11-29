package com.upuphone.ar.transcribe.phone.bean;

import com.upuphone.ar.transcribe.phone.activity.TranscribeRecordFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/RecordTabBean;", "", "tabName", "", "fragment", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment;", "(Ljava/lang/String;Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment;)V", "getFragment", "()Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment;", "getTabName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordTabBean {
    @NotNull
    private final TranscribeRecordFragment fragment;
    @NotNull
    private final String tabName;

    public RecordTabBean(@NotNull String str, @NotNull TranscribeRecordFragment transcribeRecordFragment) {
        Intrinsics.checkNotNullParameter(str, "tabName");
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "fragment");
        this.tabName = str;
        this.fragment = transcribeRecordFragment;
    }

    public static /* synthetic */ RecordTabBean copy$default(RecordTabBean recordTabBean, String str, TranscribeRecordFragment transcribeRecordFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordTabBean.tabName;
        }
        if ((i & 2) != 0) {
            transcribeRecordFragment = recordTabBean.fragment;
        }
        return recordTabBean.copy(str, transcribeRecordFragment);
    }

    @NotNull
    public final String component1() {
        return this.tabName;
    }

    @NotNull
    public final TranscribeRecordFragment component2() {
        return this.fragment;
    }

    @NotNull
    public final RecordTabBean copy(@NotNull String str, @NotNull TranscribeRecordFragment transcribeRecordFragment) {
        Intrinsics.checkNotNullParameter(str, "tabName");
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "fragment");
        return new RecordTabBean(str, transcribeRecordFragment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordTabBean)) {
            return false;
        }
        RecordTabBean recordTabBean = (RecordTabBean) obj;
        return Intrinsics.areEqual((Object) this.tabName, (Object) recordTabBean.tabName) && Intrinsics.areEqual((Object) this.fragment, (Object) recordTabBean.fragment);
    }

    @NotNull
    public final TranscribeRecordFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    public int hashCode() {
        return (this.tabName.hashCode() * 31) + this.fragment.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.tabName;
        TranscribeRecordFragment transcribeRecordFragment = this.fragment;
        return "RecordTabBean(tabName=" + str + ", fragment=" + transcribeRecordFragment + ")";
    }
}
