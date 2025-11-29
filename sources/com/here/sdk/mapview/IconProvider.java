package com.here.sdk.mapview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.mapview.IconProviderInternal;

public class IconProvider {
    private IconProviderInternal mIconProviderInternal;

    @FunctionalInterface
    public interface IconCallback {
        void onCreateIconReply(@Nullable Bitmap bitmap, @Nullable String str, @Nullable IconProviderError iconProviderError);
    }

    public IconProvider(MapContext mapContext) {
        this.mIconProviderInternal = new IconProviderInternal(mapContext);
    }

    public void createRoadShieldIcon(@NonNull RoadShieldIconProperties roadShieldIconProperties, @NonNull MapScheme mapScheme, long j, long j2, @NonNull final IconCallback iconCallback) {
        this.mIconProviderInternal.createRoadShieldIcon(roadShieldIconProperties, mapScheme, j, j2, new IconProviderInternal.CreateIconCallback() {
            public void onCreateIconReply(@Nullable byte[] bArr, @Nullable String str, @Nullable IconProviderError iconProviderError) {
                if (bArr == null || bArr.length == 0) {
                    iconCallback.onCreateIconReply((Bitmap) null, (String) null, iconProviderError);
                    return;
                }
                iconCallback.onCreateIconReply(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), str, (IconProviderError) null);
            }
        });
    }
}
