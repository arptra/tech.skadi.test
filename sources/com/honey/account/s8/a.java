package com.honey.account.s8;

import com.upuphone.xr.sapp.request.FileUploadReq;
import com.upuphone.xr.sapp.utils.CountingRequestBody;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements CountingRequestBody.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f7611a;

    public /* synthetic */ a(Function1 function1) {
        this.f7611a = function1;
    }

    public final void a(long j, long j2) {
        FileUploadReq.m(this.f7611a, j, j2);
    }
}
