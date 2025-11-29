package io.flutter.plugins.imagepicker;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.db.g;
import com.honey.account.db.h;
import com.honey.account.db.i;
import com.honey.account.db.j;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Messages {

    public static final class CacheRetrievalError {
        @NonNull
        private String code;
        @Nullable
        private String message;

        public static final class Builder {
            @Nullable
            private String code;
            @Nullable
            private String message;

            @NonNull
            public CacheRetrievalError build() {
                CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
                cacheRetrievalError.setCode(this.code);
                cacheRetrievalError.setMessage(this.message);
                return cacheRetrievalError;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setCode(@NonNull String str) {
                this.code = str;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setMessage(@Nullable String str) {
                this.message = str;
                return this;
            }
        }

        @NonNull
        public static CacheRetrievalError fromList(@NonNull ArrayList<Object> arrayList) {
            CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
            cacheRetrievalError.setCode((String) arrayList.get(0));
            cacheRetrievalError.setMessage((String) arrayList.get(1));
            return cacheRetrievalError;
        }

        @NonNull
        public String getCode() {
            return this.code;
        }

        @Nullable
        public String getMessage() {
            return this.message;
        }

        public void setCode(@NonNull String str) {
            if (str != null) {
                this.code = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void setMessage(@Nullable String str) {
            this.message = str;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.code);
            arrayList.add(this.message);
            return arrayList;
        }
    }

    public static final class CacheRetrievalResult {
        @Nullable
        private CacheRetrievalError error;
        @NonNull
        private List<String> paths;
        @NonNull
        private CacheRetrievalType type;

        public static final class Builder {
            @Nullable
            private CacheRetrievalError error;
            @Nullable
            private List<String> paths;
            @Nullable
            private CacheRetrievalType type;

            @NonNull
            public CacheRetrievalResult build() {
                CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
                cacheRetrievalResult.setType(this.type);
                cacheRetrievalResult.setError(this.error);
                cacheRetrievalResult.setPaths(this.paths);
                return cacheRetrievalResult;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setError(@Nullable CacheRetrievalError cacheRetrievalError) {
                this.error = cacheRetrievalError;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setPaths(@NonNull List<String> list) {
                this.paths = list;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setType(@NonNull CacheRetrievalType cacheRetrievalType) {
                this.type = cacheRetrievalType;
                return this;
            }
        }

        @NonNull
        public static CacheRetrievalResult fromList(@NonNull ArrayList<Object> arrayList) {
            CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
            cacheRetrievalResult.setType(CacheRetrievalType.values()[((Integer) arrayList.get(0)).intValue()]);
            Object obj = arrayList.get(1);
            cacheRetrievalResult.setError(obj == null ? null : CacheRetrievalError.fromList((ArrayList) obj));
            cacheRetrievalResult.setPaths((List) arrayList.get(2));
            return cacheRetrievalResult;
        }

        @Nullable
        public CacheRetrievalError getError() {
            return this.error;
        }

        @NonNull
        public List<String> getPaths() {
            return this.paths;
        }

        @NonNull
        public CacheRetrievalType getType() {
            return this.type;
        }

        public void setError(@Nullable CacheRetrievalError cacheRetrievalError) {
            this.error = cacheRetrievalError;
        }

        public void setPaths(@NonNull List<String> list) {
            if (list != null) {
                this.paths = list;
                return;
            }
            throw new IllegalStateException("Nonnull field \"paths\" is null.");
        }

        public void setType(@NonNull CacheRetrievalType cacheRetrievalType) {
            if (cacheRetrievalType != null) {
                this.type = cacheRetrievalType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            CacheRetrievalType cacheRetrievalType = this.type;
            ArrayList<Object> arrayList2 = null;
            arrayList.add(cacheRetrievalType == null ? null : Integer.valueOf(cacheRetrievalType.index));
            CacheRetrievalError cacheRetrievalError = this.error;
            if (cacheRetrievalError != null) {
                arrayList2 = cacheRetrievalError.toList();
            }
            arrayList.add(arrayList2);
            arrayList.add(this.paths);
            return arrayList;
        }
    }

    public enum CacheRetrievalType {
        IMAGE(0),
        VIDEO(1);
        
        final int index;

        private CacheRetrievalType(int i) {
            this.index = i;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public static final class GeneralOptions {
        @NonNull
        private Boolean allowMultiple;
        @Nullable
        private Long limit;
        @NonNull
        private Boolean usePhotoPicker;

        public static final class Builder {
            @Nullable
            private Boolean allowMultiple;
            @Nullable
            private Long limit;
            @Nullable
            private Boolean usePhotoPicker;

            @NonNull
            public GeneralOptions build() {
                GeneralOptions generalOptions = new GeneralOptions();
                generalOptions.setAllowMultiple(this.allowMultiple);
                generalOptions.setUsePhotoPicker(this.usePhotoPicker);
                generalOptions.setLimit(this.limit);
                return generalOptions;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setAllowMultiple(@NonNull Boolean bool) {
                this.allowMultiple = bool;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setLimit(@Nullable Long l) {
                this.limit = l;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setUsePhotoPicker(@NonNull Boolean bool) {
                this.usePhotoPicker = bool;
                return this;
            }
        }

        @NonNull
        public static GeneralOptions fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            GeneralOptions generalOptions = new GeneralOptions();
            generalOptions.setAllowMultiple((Boolean) arrayList.get(0));
            generalOptions.setUsePhotoPicker((Boolean) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            generalOptions.setLimit(l);
            return generalOptions;
        }

        @NonNull
        public Boolean getAllowMultiple() {
            return this.allowMultiple;
        }

        @Nullable
        public Long getLimit() {
            return this.limit;
        }

        @NonNull
        public Boolean getUsePhotoPicker() {
            return this.usePhotoPicker;
        }

        public void setAllowMultiple(@NonNull Boolean bool) {
            if (bool != null) {
                this.allowMultiple = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
        }

        public void setLimit(@Nullable Long l) {
            this.limit = l;
        }

        public void setUsePhotoPicker(@NonNull Boolean bool) {
            if (bool != null) {
                this.usePhotoPicker = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.allowMultiple);
            arrayList.add(this.usePhotoPicker);
            arrayList.add(this.limit);
            return arrayList;
        }
    }

    public interface ImagePickerApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return ImagePickerApiCodec.INSTANCE;
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickImages((SourceSpecification) arrayList2.get(0), (ImageSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() {
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickVideos((SourceSpecification) arrayList2.get(0), (VideoSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() {
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickMedia((MediaSelectionOptions) arrayList2.get(0), (GeneralOptions) arrayList2.get(1), new Result<List<String>>() {
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, imagePickerApi.retrieveLostResults());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable ImagePickerApi imagePickerApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickImages", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (imagePickerApi != null) {
                basicMessageChannel.setMessageHandler(new g(imagePickerApi));
            } else {
                basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickVideos", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (imagePickerApi != null) {
                basicMessageChannel2.setMessageHandler(new h(imagePickerApi));
            } else {
                basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickMedia", getCodec());
            if (imagePickerApi != null) {
                basicMessageChannel3.setMessageHandler(new i(imagePickerApi));
            } else {
                basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.retrieveLostResults", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (imagePickerApi != null) {
                basicMessageChannel4.setMessageHandler(new j(imagePickerApi));
            } else {
                basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
            }
        }

        void pickImages(@NonNull SourceSpecification sourceSpecification, @NonNull ImageSelectionOptions imageSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        void pickMedia(@NonNull MediaSelectionOptions mediaSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        void pickVideos(@NonNull SourceSpecification sourceSpecification, @NonNull VideoSelectionOptions videoSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        @Nullable
        CacheRetrievalResult retrieveLostResults();
    }

    public static class ImagePickerApiCodec extends StandardMessageCodec {
        public static final ImagePickerApiCodec INSTANCE = new ImagePickerApiCodec();

        private ImagePickerApiCodec() {
        }

        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            switch (b) {
                case Byte.MIN_VALUE:
                    return CacheRetrievalError.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return CacheRetrievalResult.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return GeneralOptions.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return ImageSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return MediaSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return SourceSpecification.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return VideoSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CacheRetrievalError) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CacheRetrievalError) obj).toList());
            } else if (obj instanceof CacheRetrievalResult) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((CacheRetrievalResult) obj).toList());
            } else if (obj instanceof GeneralOptions) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((GeneralOptions) obj).toList());
            } else if (obj instanceof ImageSelectionOptions) {
                byteArrayOutputStream.write(TrackerEvent.PositioningOfflineOutdoor);
                writeValue(byteArrayOutputStream, ((ImageSelectionOptions) obj).toList());
            } else if (obj instanceof MediaSelectionOptions) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((MediaSelectionOptions) obj).toList());
            } else if (obj instanceof SourceSpecification) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((SourceSpecification) obj).toList());
            } else if (obj instanceof VideoSelectionOptions) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((VideoSelectionOptions) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public static final class ImageSelectionOptions {
        @Nullable
        private Double maxHeight;
        @Nullable
        private Double maxWidth;
        @NonNull
        private Long quality;

        public static final class Builder {
            @Nullable
            private Double maxHeight;
            @Nullable
            private Double maxWidth;
            @Nullable
            private Long quality;

            @NonNull
            public ImageSelectionOptions build() {
                ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
                imageSelectionOptions.setMaxWidth(this.maxWidth);
                imageSelectionOptions.setMaxHeight(this.maxHeight);
                imageSelectionOptions.setQuality(this.quality);
                return imageSelectionOptions;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setMaxHeight(@Nullable Double d) {
                this.maxHeight = d;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setMaxWidth(@Nullable Double d) {
                this.maxWidth = d;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setQuality(@NonNull Long l) {
                this.quality = l;
                return this;
            }
        }

        @NonNull
        public static ImageSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
            imageSelectionOptions.setMaxWidth((Double) arrayList.get(0));
            imageSelectionOptions.setMaxHeight((Double) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            imageSelectionOptions.setQuality(l);
            return imageSelectionOptions;
        }

        @Nullable
        public Double getMaxHeight() {
            return this.maxHeight;
        }

        @Nullable
        public Double getMaxWidth() {
            return this.maxWidth;
        }

        @NonNull
        public Long getQuality() {
            return this.quality;
        }

        public void setMaxHeight(@Nullable Double d) {
            this.maxHeight = d;
        }

        public void setMaxWidth(@Nullable Double d) {
            this.maxWidth = d;
        }

        public void setQuality(@NonNull Long l) {
            if (l != null) {
                this.quality = l;
                return;
            }
            throw new IllegalStateException("Nonnull field \"quality\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.maxWidth);
            arrayList.add(this.maxHeight);
            arrayList.add(this.quality);
            return arrayList;
        }
    }

    public static final class MediaSelectionOptions {
        @NonNull
        private ImageSelectionOptions imageSelectionOptions;

        public static final class Builder {
            @Nullable
            private ImageSelectionOptions imageSelectionOptions;

            @NonNull
            public MediaSelectionOptions build() {
                MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
                mediaSelectionOptions.setImageSelectionOptions(this.imageSelectionOptions);
                return mediaSelectionOptions;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setImageSelectionOptions(@NonNull ImageSelectionOptions imageSelectionOptions2) {
                this.imageSelectionOptions = imageSelectionOptions2;
                return this;
            }
        }

        @NonNull
        public static MediaSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
            Object obj = arrayList.get(0);
            mediaSelectionOptions.setImageSelectionOptions(obj == null ? null : ImageSelectionOptions.fromList((ArrayList) obj));
            return mediaSelectionOptions;
        }

        @NonNull
        public ImageSelectionOptions getImageSelectionOptions() {
            return this.imageSelectionOptions;
        }

        public void setImageSelectionOptions(@NonNull ImageSelectionOptions imageSelectionOptions2) {
            if (imageSelectionOptions2 != null) {
                this.imageSelectionOptions = imageSelectionOptions2;
                return;
            }
            throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            ImageSelectionOptions imageSelectionOptions2 = this.imageSelectionOptions;
            arrayList.add(imageSelectionOptions2 == null ? null : imageSelectionOptions2.toList());
            return arrayList;
        }
    }

    public interface NullableResult<T> {
        void error(@NonNull Throwable th);

        void success(@Nullable T t);
    }

    public interface Result<T> {
        void error(@NonNull Throwable th);

        void success(@NonNull T t);
    }

    public enum SourceCamera {
        REAR(0),
        FRONT(1);
        
        final int index;

        private SourceCamera(int i) {
            this.index = i;
        }
    }

    public static final class SourceSpecification {
        @Nullable
        private SourceCamera camera;
        @NonNull
        private SourceType type;

        public static final class Builder {
            @Nullable
            private SourceCamera camera;
            @Nullable
            private SourceType type;

            @NonNull
            public SourceSpecification build() {
                SourceSpecification sourceSpecification = new SourceSpecification();
                sourceSpecification.setType(this.type);
                sourceSpecification.setCamera(this.camera);
                return sourceSpecification;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setCamera(@Nullable SourceCamera sourceCamera) {
                this.camera = sourceCamera;
                return this;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setType(@NonNull SourceType sourceType) {
                this.type = sourceType;
                return this;
            }
        }

        @NonNull
        public static SourceSpecification fromList(@NonNull ArrayList<Object> arrayList) {
            SourceSpecification sourceSpecification = new SourceSpecification();
            sourceSpecification.setType(SourceType.values()[((Integer) arrayList.get(0)).intValue()]);
            Object obj = arrayList.get(1);
            sourceSpecification.setCamera(obj == null ? null : SourceCamera.values()[((Integer) obj).intValue()]);
            return sourceSpecification;
        }

        @Nullable
        public SourceCamera getCamera() {
            return this.camera;
        }

        @NonNull
        public SourceType getType() {
            return this.type;
        }

        public void setCamera(@Nullable SourceCamera sourceCamera) {
            this.camera = sourceCamera;
        }

        public void setType(@NonNull SourceType sourceType) {
            if (sourceType != null) {
                this.type = sourceType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            SourceType sourceType = this.type;
            Integer num = null;
            arrayList.add(sourceType == null ? null : Integer.valueOf(sourceType.index));
            SourceCamera sourceCamera = this.camera;
            if (sourceCamera != null) {
                num = Integer.valueOf(sourceCamera.index);
            }
            arrayList.add(num);
            return arrayList;
        }
    }

    public enum SourceType {
        CAMERA(0),
        GALLERY(1);
        
        final int index;

        private SourceType(int i) {
            this.index = i;
        }
    }

    public static final class VideoSelectionOptions {
        @Nullable
        private Long maxDurationSeconds;

        public static final class Builder {
            @Nullable
            private Long maxDurationSeconds;

            @NonNull
            public VideoSelectionOptions build() {
                VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
                videoSelectionOptions.setMaxDurationSeconds(this.maxDurationSeconds);
                return videoSelectionOptions;
            }

            @CanIgnoreReturnValue
            @NonNull
            public Builder setMaxDurationSeconds(@Nullable Long l) {
                this.maxDurationSeconds = l;
                return this;
            }
        }

        @NonNull
        public static VideoSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            Long l;
            VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l = null;
            } else {
                l = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            videoSelectionOptions.setMaxDurationSeconds(l);
            return videoSelectionOptions;
        }

        @Nullable
        public Long getMaxDurationSeconds() {
            return this.maxDurationSeconds;
        }

        public void setMaxDurationSeconds(@Nullable Long l) {
            this.maxDurationSeconds = l;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.maxDurationSeconds);
            return arrayList;
        }
    }

    public interface VoidResult {
        void error(@NonNull Throwable th);

        void success();
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
