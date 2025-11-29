package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    public static class AvailableProcessorsHolder {
        private int availableProcessors;

        @SuppressForbidden(reason = "to obtain default number of available processors")
        public synchronized int availableProcessors() {
            try {
                if (this.availableProcessors == 0) {
                    setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.availableProcessors;
        }

        public synchronized void setAvailableProcessors(int i) {
            ObjectUtil.checkPositive(i, "availableProcessors");
            int i2 = this.availableProcessors;
            if (i2 == 0) {
                this.availableProcessors = i;
            } else {
                throw new IllegalStateException(String.format(Locale.ROOT, "availableProcessors is already set to [%d], rejecting [%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}));
            }
        }
    }

    private NettyRuntime() {
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    public static void setAvailableProcessors(int i) {
        holder.setAvailableProcessors(i);
    }
}
