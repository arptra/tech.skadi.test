package com.upuphone.ar.tici.phone.data;

import android.net.Uri;
import androidx.annotation.Keep;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.runasone.share.lib.bean.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "", "()V", "Fail", "Importing", "ImportingUri", "Success", "Lcom/upuphone/ar/tici/phone/data/ImportFileState$Fail;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState$Importing;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState$ImportingUri;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState$Success;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public abstract class ImportFileState {

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFileState$Fail;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "failReason", "Lcom/upuphone/ar/tici/phone/data/ImportFailReason;", "fileInfo", "Lcom/upuphone/ar/tici/phone/data/ImportFileInfo;", "(Lcom/upuphone/ar/tici/phone/data/ImportFailReason;Lcom/upuphone/ar/tici/phone/data/ImportFileInfo;)V", "getFailReason", "()Lcom/upuphone/ar/tici/phone/data/ImportFailReason;", "getFileInfo", "()Lcom/upuphone/ar/tici/phone/data/ImportFileInfo;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Fail extends ImportFileState {
        @NotNull
        private final ImportFailReason failReason;
        @NotNull
        private final ImportFileInfo fileInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Fail(@NotNull ImportFailReason importFailReason, @NotNull ImportFileInfo importFileInfo) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(importFailReason, Constants.EXTRA_FAIL_REASON);
            Intrinsics.checkNotNullParameter(importFileInfo, "fileInfo");
            this.failReason = importFailReason;
            this.fileInfo = importFileInfo;
        }

        @NotNull
        public final ImportFailReason getFailReason() {
            return this.failReason;
        }

        @NotNull
        public final ImportFileInfo getFileInfo() {
            return this.fileInfo;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFileState$Importing;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "fileInfo", "Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "(Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;)V", "getFileInfo", "()Lcom/upuphone/ar/tici/phone/data/SystemFileInfo;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Importing extends ImportFileState {
        @NotNull
        private final SystemFileInfo fileInfo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Importing(@NotNull SystemFileInfo systemFileInfo) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(systemFileInfo, "fileInfo");
            this.fileInfo = systemFileInfo;
        }

        @NotNull
        public final SystemFileInfo getFileInfo() {
            return this.fileInfo;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFileState$ImportingUri;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "uri", "Landroid/net/Uri;", "fileName", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ImportingUri extends ImportFileState {
        @Nullable
        private final String fileName;
        @NotNull
        private final Uri uri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImportingUri(@NotNull Uri uri2, @Nullable String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(uri2, "uri");
            this.uri = uri2;
            this.fileName = str;
        }

        @Nullable
        public final String getFileName() {
            return this.fileName;
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/ImportFileState$Success;", "Lcom/upuphone/ar/tici/phone/data/ImportFileState;", "ticiEntity", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "filePath", "", "formattedTextLength", "", "rawTextLength", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Ljava/lang/String;II)V", "getFilePath", "()Ljava/lang/String;", "getFormattedTextLength", "()I", "getRawTextLength", "getTiciEntity", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success extends ImportFileState {
        @NotNull
        private final String filePath;
        private final int formattedTextLength;
        private final int rawTextLength;
        @NotNull
        private final TiciEntity ticiEntity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull TiciEntity ticiEntity2, @NotNull String str, int i, int i2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(ticiEntity2, "ticiEntity");
            Intrinsics.checkNotNullParameter(str, "filePath");
            this.ticiEntity = ticiEntity2;
            this.filePath = str;
            this.formattedTextLength = i;
            this.rawTextLength = i2;
        }

        @NotNull
        public final String getFilePath() {
            return this.filePath;
        }

        public final int getFormattedTextLength() {
            return this.formattedTextLength;
        }

        public final int getRawTextLength() {
            return this.rawTextLength;
        }

        @NotNull
        public final TiciEntity getTiciEntity() {
            return this.ticiEntity;
        }
    }

    public /* synthetic */ ImportFileState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImportFileState() {
    }
}
