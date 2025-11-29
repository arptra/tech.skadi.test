package flyme.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.Calendar;

class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static final TwilightState sTwilightState = new TwilightState();
    private final Context mContext;

    public static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        private TwilightState() {
        }
    }

    public TwilightManager(Context context) {
        this.mContext = context;
    }

    private Location getLastKnownLocation() {
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocationForProvider(String str) {
        return null;
    }

    private boolean isStateValid(TwilightState twilightState) {
        return twilightState != null && twilightState.nextUpdate > System.currentTimeMillis();
    }

    public boolean isNight() {
        TwilightState twilightState = sTwilightState;
        if (isStateValid(twilightState)) {
            return twilightState.isNight;
        }
        if (getLastKnownLocation() != null) {
            return twilightState.isNight;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
