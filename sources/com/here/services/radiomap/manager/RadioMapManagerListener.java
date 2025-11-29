package com.here.services.radiomap.manager;

import androidx.annotation.NonNull;
import com.here.odnp.util.Log;

public interface RadioMapManagerListener {

    public enum Status {
        Ok(0),
        Error(1),
        NotFoundError(4),
        InputOutputError(12),
        ConnectionError(13),
        DataTransferError(14),
        CancelError(15),
        DataCorruptedError(17),
        NoConnectionFoundError(20);
        
        private static final String TAG = "RadioMapManagerListener.Status";
        final int mCode;

        private Status(int i) {
            this.mCode = i;
        }

        public static Status fromInt(int i) {
            for (Status status : values()) {
                if (status.mCode == i) {
                    return status;
                }
            }
            Integer valueOf = Integer.valueOf(i);
            Status status2 = Error;
            Log.w(TAG, "Unexpected error code: %d converted to: %s (%d)", valueOf, status2, Integer.valueOf(status2.toInt()));
            return status2;
        }

        public int toInt() {
            return this.mCode;
        }
    }

    void onProgress(int i);

    void onQueryCompleted(@NonNull Status status, long j);

    void onUpdateCompleted(@NonNull Status status);
}
