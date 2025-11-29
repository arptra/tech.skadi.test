package com.here.sdk.animation;

public enum EasingFunction {
    LINEAR(0),
    IN_QUAD(1),
    OUT_QUAD(2),
    IN_OUT_QUAD(3),
    OUT_IN_QUAD(4),
    IN_CUBIC(5),
    OUT_CUBIC(6),
    IN_OUT_CUBIC(7),
    OUT_IN_CUBIC(8),
    IN_QUART(9),
    OUT_QUART(10),
    IN_OUT_QUART(11),
    OUT_IN_QUART(12),
    IN_QUINT(13),
    OUT_QUINT(14),
    IN_OUT_QUINT(15),
    OUT_IN_QUINT(16),
    IN_SINE(17),
    OUT_SINE(18),
    IN_OUT_SINE(19),
    OUT_IN_SINE(20),
    IN_EXP(21),
    OUT_EXP(22),
    IN_OUT_EXP(23),
    OUT_IN_EXP(24),
    IN_CIRC(25),
    OUT_CIRC(26),
    IN_OUT_CIRC(27),
    OUT_IN_CIRC(28),
    IN_BACK(29),
    OUT_BACK(30),
    IN_OUT_BACK(31),
    OUT_IN_BACK(32),
    IN_BOUNCE(33),
    OUT_BOUNCE(34),
    IN_OUT_BOUNCE(35),
    OUT_IN_BOUNCE(36),
    IN_ELASTIC(37),
    OUT_ELASTIC(38),
    IN_OUT_ELASTIC(39),
    OUT_IN_ELASTIC(40);
    
    public final int value;

    private EasingFunction(int i) {
        this.value = i;
    }
}
