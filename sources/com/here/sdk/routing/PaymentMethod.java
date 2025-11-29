package com.here.sdk.routing;

public enum PaymentMethod {
    UNKNOWN(0),
    CASH(1),
    BANK_CARD(2),
    CREDIT_CARD(3),
    PASS_SUBSCRIPTION(4),
    TRANSPONDER(5),
    VIDEO_TOLL(6),
    CASH_EXACT(7),
    TRAVEL_CARD(8);
    
    public final int value;

    private PaymentMethod(int i) {
        this.value = i;
    }
}
