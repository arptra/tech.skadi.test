package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo
interface Quantizer {
    QuantizerResult quantize(int[] iArr, int i);
}
