package com.here.sdk.core.threading;

import androidx.annotation.NonNull;

@FunctionalInterface
public interface OnTaskCompleted {
    void onTaskCompleted(@NonNull TaskOutcome taskOutcome);
}
