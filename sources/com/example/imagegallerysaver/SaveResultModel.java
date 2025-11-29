package com.example.imagegallerysaver;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\n¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/example/imagegallerysaver/SaveResultModel;", "", "", "isSuccess", "", "filePath", "errorMessage", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "()Ljava/util/HashMap;", "Z", "()Z", "setSuccess", "(Z)V", "b", "Ljava/lang/String;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "c", "getErrorMessage", "setErrorMessage", "image_gallery_saver_release"}, k = 1, mv = {1, 7, 1})
public final class SaveResultModel {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2827a;
    public String b;
    public String c;

    public SaveResultModel(boolean z, String str, String str2) {
        this.f2827a = z;
        this.b = str;
        this.c = str2;
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put("isSuccess", Boolean.valueOf(this.f2827a));
        hashMap.put("filePath", this.b);
        hashMap.put("errorMessage", this.c);
        return hashMap;
    }
}
