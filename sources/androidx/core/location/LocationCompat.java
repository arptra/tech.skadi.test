package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

public final class LocationCompat {

    /* renamed from: a  reason: collision with root package name */
    public static Field f735a;
    public static Integer b;
    public static Integer c;
    public static Integer d;

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        public static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        public static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        public static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        public static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        public static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        public static void g(Location location) {
            try {
                LocationCompat.a().setByte(location, (byte) (LocationCompat.a().getByte(location) & (~LocationCompat.b())));
            } catch (NoSuchFieldException e) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            } catch (IllegalAccessException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        public static void h(Location location) {
            try {
                LocationCompat.a().setByte(location, (byte) (LocationCompat.a().getByte(location) & (~LocationCompat.c())));
            } catch (NoSuchFieldException e) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            } catch (IllegalAccessException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        public static void i(Location location) {
            try {
                LocationCompat.a().setByte(location, (byte) (LocationCompat.a().getByte(location) & (~LocationCompat.d())));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        public static void j(Location location, float f) {
            location.setBearingAccuracyDegrees(f);
        }

        @DoNotInline
        public static void k(Location location, float f) {
            location.setSpeedAccuracyMetersPerSecond(f);
        }

        @DoNotInline
        public static void l(Location location, float f) {
            location.setVerticalAccuracyMeters(f);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static void a(Location location) {
            Location location2 = location;
            if (location.hasBearingAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f2 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f3 = verticalAccuracyMeters;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f2);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f3);
                }
                if (hasSpeedAccuracy) {
                    location2.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        public static void b(Location location) {
            Location location2 = location;
            if (location.hasSpeedAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f2 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f3 = verticalAccuracyMeters;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f2);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f3);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        public static void c(Location location) {
            Location location2 = location;
            if (location.hasVerticalAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f = bearing;
                float accuracy = location.getAccuracy();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f2 = accuracy;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f3 = speedAccuracyMetersPerSecond;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f2);
                }
                if (hasSpeedAccuracy) {
                    location2.setSpeedAccuracyMetersPerSecond(f3);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }
    }

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Location location) {
            if (location.hasBearingAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.a(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        public static void b(Location location) {
            if (location.hasSpeedAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.b(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        public static void c(Location location) {
            if (location.hasVerticalAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.c(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static void a(Location location) {
            location.removeBearingAccuracy();
        }

        @DoNotInline
        public static void b(Location location) {
            location.removeSpeedAccuracy();
        }

        @DoNotInline
        public static void c(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static float a(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        public static double b(Location location) {
            return location.getMslAltitudeMeters();
        }

        @DoNotInline
        public static boolean c(Location location) {
            return location.hasMslAltitude();
        }

        @DoNotInline
        public static boolean d(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        public static void e(Location location) {
            location.removeMslAltitude();
        }

        @DoNotInline
        public static void f(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        public static void g(Location location, float f) {
            location.setMslAltitudeAccuracyMeters(f);
        }

        @DoNotInline
        public static void h(Location location, double d) {
            location.setMslAltitudeMeters(d);
        }
    }

    public static Field a() {
        if (f735a == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            f735a = declaredField;
            declaredField.setAccessible(true);
        }
        return f735a;
    }

    public static int b() {
        if (c == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            c = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return c.intValue();
    }

    public static int c() {
        if (b == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            b = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return b.intValue();
    }

    public static int d() {
        if (d == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            d = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return d.intValue();
    }
}
