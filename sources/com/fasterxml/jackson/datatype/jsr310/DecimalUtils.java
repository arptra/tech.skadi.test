package com.fasterxml.jackson.datatype.jsr310;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public final class DecimalUtils {
    private static final BigDecimal ONE_BILLION = new BigDecimal(1000000000);

    private DecimalUtils() {
    }

    public static int extractNanosecondDecimal(BigDecimal bigDecimal, long j) {
        return bigDecimal.subtract(new BigDecimal(j)).multiply(ONE_BILLION).intValue();
    }

    public static <T> T extractSecondsAndNanos(BigDecimal bigDecimal, BiFunction<Long, Integer, T> biFunction) {
        long j;
        BigDecimal scaleByPowerOfTen = bigDecimal.scaleByPowerOfTen(9);
        int i = 0;
        if (scaleByPowerOfTen.precision() - scaleByPowerOfTen.scale() > 0 && bigDecimal.scale() >= -63) {
            long longValue = bigDecimal.longValue();
            j = longValue;
            i = scaleByPowerOfTen.subtract(new BigDecimal(longValue).scaleByPowerOfTen(9)).intValue();
        } else {
            j = (long) 0;
        }
        return biFunction.apply(Long.valueOf(j), Integer.valueOf(i));
    }

    public static BigDecimal toBigDecimal(long j, int i) {
        return ((long) i) == 0 ? j == 0 ? BigDecimal.ZERO.setScale(1) : BigDecimal.valueOf(j).setScale(9) : new BigDecimal(toDecimal(j, i));
    }

    public static String toDecimal(long j, int i) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(j);
        sb.append('.');
        if (((long) i) != 0) {
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append(i);
            int length = 9 - sb2.length();
            while (length > 0) {
                length--;
                sb.append('0');
            }
            sb.append(sb2);
        } else if (j == 0) {
            return "0.0";
        } else {
            sb.append("000000000");
        }
        return sb.toString();
    }
}
