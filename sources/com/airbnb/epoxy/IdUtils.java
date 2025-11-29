package com.airbnb.epoxy;

public final class IdUtils {
    public static long a(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        int length = charSequence.length();
        long j = -3750763034362895579L;
        for (int i = 0; i < length; i++) {
            j = (j ^ ((long) charSequence.charAt(i))) * 1099511628211L;
        }
        return j;
    }
}
