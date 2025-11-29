package com.honey.account.dc;

import org.apache.commons.lang3.function.FailableDoubleBinaryOperator;
import org.apache.commons.lang3.function.FailableDoubleSupplier;

public final /* synthetic */ class l implements FailableDoubleSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FailableDoubleBinaryOperator f7256a;
    public final /* synthetic */ double b;
    public final /* synthetic */ double c;

    public /* synthetic */ l(FailableDoubleBinaryOperator failableDoubleBinaryOperator, double d, double d2) {
        this.f7256a = failableDoubleBinaryOperator;
        this.b = d;
        this.c = d2;
    }

    public final double getAsDouble() {
        return this.f7256a.applyAsDouble(this.b, this.c);
    }
}
