package io.netty.resolver.dns;

final class UnixResolverOptions {
    private final int attempts;
    private final int ndots;
    private final int timeout;

    public static final class Builder {
        private int attempts;
        private int ndots;
        private int timeout;

        public UnixResolverOptions build() {
            return new UnixResolverOptions(this.ndots, this.timeout, this.attempts);
        }

        public void setAttempts(int i) {
            this.attempts = i;
        }

        public void setNdots(int i) {
            this.ndots = i;
        }

        public void setTimeout(int i) {
            this.timeout = i;
        }

        private Builder() {
            this.ndots = 1;
            this.timeout = 5;
            this.attempts = 16;
        }
    }

    public UnixResolverOptions(int i, int i2, int i3) {
        this.ndots = i;
        this.timeout = i2;
        this.attempts = i3;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int attempts() {
        return this.attempts;
    }

    public int ndots() {
        return this.ndots;
    }

    public int timeout() {
        return this.timeout;
    }
}
