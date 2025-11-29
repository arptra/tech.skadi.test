package com.upuphone.runasone.uupcast;

import androidx.annotation.NonNull;

public class CastAudioAttributes {
    /* access modifiers changed from: private */
    public final int mAudioUsage;
    /* access modifiers changed from: private */
    public final int mContentType;
    /* access modifiers changed from: private */
    public final int mFocusType;
    /* access modifiers changed from: private */
    public final int mOutputGain;
    /* access modifiers changed from: private */
    public final int mStreamType;

    public int getAudioUsage() {
        return this.mAudioUsage;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public int getFocusType() {
        return this.mFocusType;
    }

    public int getOutputGain() {
        return this.mOutputGain;
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    private CastAudioAttributes(@NonNull Builder builder) {
        this.mAudioUsage = builder.mAudioUsage;
        this.mContentType = builder.mContentType;
        this.mFocusType = builder.mFocusType;
        this.mStreamType = builder.mStreamType;
        this.mOutputGain = builder.mOutputGain;
    }

    public static class Builder {
        private static final int OUTPUT_GAIN_MAX = 100;
        private static final int VALUE_INVALID = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mAudioUsage = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mContentType = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mFocusType = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mOutputGain = 100;
        /* access modifiers changed from: private */
        public int mStreamType = Integer.MIN_VALUE;

        public Builder() {
        }

        public CastAudioAttributes build() {
            if (this.mAudioUsage == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("audioUsage not set");
            } else if (this.mContentType == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("contentType not set");
            } else if (this.mFocusType == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("focusType not set");
            } else if (this.mStreamType != Integer.MIN_VALUE) {
                return new CastAudioAttributes(this);
            } else {
                throw new IllegalArgumentException("streamType not set");
            }
        }

        public Builder setAudioUsage(int i) {
            this.mAudioUsage = i;
            return this;
        }

        public Builder setContentType(int i) {
            this.mContentType = i;
            return this;
        }

        public Builder setFocusType(int i) {
            this.mFocusType = i;
            return this;
        }

        public Builder setOutputGain(int i) {
            if (i < 0 || i > 100) {
                throw new IllegalArgumentException("invalid output gain: " + i);
            }
            this.mOutputGain = i;
            return this;
        }

        public Builder setStreamType(int i) {
            this.mStreamType = i;
            return this;
        }

        public Builder(CastAudioAttributes castAudioAttributes) {
            if (castAudioAttributes != null) {
                this.mAudioUsage = castAudioAttributes.mAudioUsage;
                this.mContentType = castAudioAttributes.mContentType;
                this.mFocusType = castAudioAttributes.mFocusType;
                this.mStreamType = castAudioAttributes.mStreamType;
                this.mOutputGain = castAudioAttributes.mOutputGain;
            }
        }
    }
}
