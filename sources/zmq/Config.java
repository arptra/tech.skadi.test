package zmq;

import com.google.android.gms.common.ConnectionResult;
import com.here.posclient.PositionEstimate;
import kotlin.time.DurationKt;

public enum Config {
    MESSAGE_PIPE_GRANULARITY(256),
    COMMAND_PIPE_GRANULARITY(16),
    INBOUND_POLL_RATE(100),
    IN_BATCH_SIZE(8192),
    OUT_BATCH_SIZE(8192),
    MAX_WM_DELTA(1024),
    MAX_IO_EVENTS(256),
    MAX_COMMAND_DELAY(3000000),
    CLOCK_PRECISION(DurationKt.NANOS_IN_MILLIS),
    PGM_MAX_TPDU(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED),
    SIGNALER_PORT(0),
    MSG_ALLOCATION_HEAP_THRESHOLD(PositionEstimate.Value.SITUATION);
    
    private final int value;

    private Config(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
