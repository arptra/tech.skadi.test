package io.flutter.embedding.engine.systemchannels;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SettingsChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
    private static final String BRIEFLY_SHOW_PASSWORD = "brieflyShowPassword";
    public static final String CHANNEL_NAME = "flutter/settings";
    private static final String CONFIGURATION_ID = "configurationId";
    /* access modifiers changed from: private */
    public static final ConfigurationQueue CONFIGURATION_QUEUE = new ConfigurationQueue();
    private static final String NATIVE_SPELL_CHECK_SERVICE_DEFINED = "nativeSpellCheckServiceDefined";
    private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
    private static final String TAG = "SettingsChannel";
    private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
    @NonNull
    public final BasicMessageChannel<Object> channel;

    @VisibleForTesting
    public static class ConfigurationQueue {
        private SentConfiguration currentConfiguration;
        private SentConfiguration previousEnqueuedConfiguration;
        /* access modifiers changed from: private */
        public final ConcurrentLinkedQueue<SentConfiguration> sentQueue = new ConcurrentLinkedQueue<>();

        public static class SentConfiguration {
            private static int nextConfigGeneration = Integer.MIN_VALUE;
            /* access modifiers changed from: private */
            @NonNull
            public final DisplayMetrics displayMetrics;
            @NonNull
            public final int generationNumber;

            public SentConfiguration(@NonNull DisplayMetrics displayMetrics2) {
                int i = nextConfigGeneration;
                nextConfigGeneration = i + 1;
                this.generationNumber = i;
                this.displayMetrics = displayMetrics2;
            }
        }

        @UiThread
        @Nullable
        public BasicMessageChannel.Reply enqueueConfiguration(SentConfiguration sentConfiguration) {
            this.sentQueue.add(sentConfiguration);
            final SentConfiguration sentConfiguration2 = this.previousEnqueuedConfiguration;
            this.previousEnqueuedConfiguration = sentConfiguration;
            if (sentConfiguration2 == null) {
                return null;
            }
            return new BasicMessageChannel.Reply() {
                @UiThread
                public void reply(Object obj) {
                    ConfigurationQueue.this.sentQueue.remove(sentConfiguration2);
                    if (!ConfigurationQueue.this.sentQueue.isEmpty()) {
                        Log.e(SettingsChannel.TAG, "The queue becomes empty after removing config generation " + String.valueOf(sentConfiguration2.generationNumber));
                    }
                }
            };
        }

        public SentConfiguration getConfiguration(int i) {
            SentConfiguration sentConfiguration;
            if (this.currentConfiguration == null) {
                this.currentConfiguration = this.sentQueue.poll();
            }
            while (true) {
                sentConfiguration = this.currentConfiguration;
                if (sentConfiguration != null && sentConfiguration.generationNumber < i) {
                    this.currentConfiguration = this.sentQueue.poll();
                }
            }
            if (sentConfiguration == null) {
                Log.e(SettingsChannel.TAG, "Cannot find config with generation: " + String.valueOf(i) + ", after exhausting the queue.");
                return null;
            } else if (sentConfiguration.generationNumber == i) {
                return sentConfiguration;
            } else {
                Log.e(SettingsChannel.TAG, "Cannot find config with generation: " + String.valueOf(i) + ", the oldest config is now: " + String.valueOf(this.currentConfiguration.generationNumber));
                return null;
            }
        }
    }

    public static class MessageBuilder {
        @NonNull
        private final BasicMessageChannel<Object> channel;
        @Nullable
        private DisplayMetrics displayMetrics;
        @NonNull
        private Map<String, Object> message = new HashMap();

        public MessageBuilder(@NonNull BasicMessageChannel<Object> basicMessageChannel) {
            this.channel = basicMessageChannel;
        }

        public void send() {
            Log.v(SettingsChannel.TAG, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.TEXT_SCALE_FACTOR) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT) + "\nplatformBrightness: " + this.message.get(SettingsChannel.PLATFORM_BRIGHTNESS));
            DisplayMetrics displayMetrics2 = this.displayMetrics;
            if (!SettingsChannel.hasNonlinearTextScalingSupport() || displayMetrics2 == null) {
                this.channel.send(this.message);
                return;
            }
            ConfigurationQueue.SentConfiguration sentConfiguration = new ConfigurationQueue.SentConfiguration(displayMetrics2);
            BasicMessageChannel.Reply enqueueConfiguration = SettingsChannel.CONFIGURATION_QUEUE.enqueueConfiguration(sentConfiguration);
            this.message.put(SettingsChannel.CONFIGURATION_ID, Integer.valueOf(sentConfiguration.generationNumber));
            this.channel.send(this.message, enqueueConfiguration);
        }

        @NonNull
        public MessageBuilder setBrieflyShowPassword(@NonNull boolean z) {
            this.message.put(SettingsChannel.BRIEFLY_SHOW_PASSWORD, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public MessageBuilder setDisplayMetrics(@NonNull DisplayMetrics displayMetrics2) {
            this.displayMetrics = displayMetrics2;
            return this;
        }

        @NonNull
        public MessageBuilder setNativeSpellCheckServiceDefined(boolean z) {
            this.message.put(SettingsChannel.NATIVE_SPELL_CHECK_SERVICE_DEFINED, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public MessageBuilder setPlatformBrightness(@NonNull PlatformBrightness platformBrightness) {
            this.message.put(SettingsChannel.PLATFORM_BRIGHTNESS, platformBrightness.name);
            return this;
        }

        @NonNull
        public MessageBuilder setTextScaleFactor(float f) {
            this.message.put(SettingsChannel.TEXT_SCALE_FACTOR, Float.valueOf(f));
            return this;
        }

        @NonNull
        public MessageBuilder setUse24HourFormat(boolean z) {
            this.message.put(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT, Boolean.valueOf(z));
            return this;
        }
    }

    public enum PlatformBrightness {
        light("light"),
        dark("dark");
        
        @NonNull
        public String name;

        private PlatformBrightness(@NonNull String str) {
            this.name = str;
        }
    }

    public SettingsChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    public static DisplayMetrics getPastDisplayMetrics(int i) {
        ConfigurationQueue.SentConfiguration configuration = CONFIGURATION_QUEUE.getConfiguration(i);
        if (configuration == null) {
            return null;
        }
        return configuration.displayMetrics;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    public static boolean hasNonlinearTextScalingSupport() {
        return Build.VERSION.SDK_INT >= 34;
    }

    @NonNull
    public MessageBuilder startMessage() {
        return new MessageBuilder(this.channel);
    }
}
