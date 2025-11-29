package com.tencent.mm.opensdk.diffdev.a;

import com.xjsd.ai.assistant.protocol.CmdCode;

public enum d {
    UUID_EXPIRED(CmdCode.CODE_WAKEUP_AUDIO),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    

    /* renamed from: a  reason: collision with root package name */
    private int f9612a;

    private d(int i) {
        this.f9612a = i;
    }

    public int a() {
        return this.f9612a;
    }

    public String toString() {
        return "UUIDStatusCode:" + this.f9612a;
    }
}
