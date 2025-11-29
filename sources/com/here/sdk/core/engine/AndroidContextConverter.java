package com.here.sdk.core.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import com.here.sdk.engine.InitProvider;

final class AndroidContextConverter {

    public static class AndroidContextHolderImpl implements AndroidContextHolder {
        private final Context mContext;

        public AndroidContextHolderImpl(@NonNull Context context) {
            this.mContext = context;
        }

        @NonNull
        public Context context() {
            return this.mContext;
        }
    }

    @NonNull
    public static Context convertFromInternal(@NonNull AndroidContext androidContext) {
        return ((AndroidContextHolderImpl) androidContext.contextHolder).context();
    }

    @NonNull
    public static AndroidContext convertToInternal(@NonNull Context context) {
        InitProvider.initialize(context);
        return new AndroidContext(new AndroidContextHolderImpl(context));
    }
}
