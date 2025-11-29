package com.xjmz.ai.vprint;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/xjmz/ai/vprint/Output;", "", "()V", "interfOutput", "", "getInterfOutput", "()[B", "setInterfOutput", "([B)V", "targetOutput", "getTargetOutput", "setTargetOutput", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Output {
    @Nullable
    private byte[] interfOutput;
    @Nullable
    private byte[] targetOutput;

    @Nullable
    public final byte[] getInterfOutput() {
        return this.interfOutput;
    }

    @Nullable
    public final byte[] getTargetOutput() {
        return this.targetOutput;
    }

    public final void setInterfOutput(@Nullable byte[] bArr) {
        this.interfOutput = bArr;
    }

    public final void setTargetOutput(@Nullable byte[] bArr) {
        this.targetOutput = bArr;
    }
}
