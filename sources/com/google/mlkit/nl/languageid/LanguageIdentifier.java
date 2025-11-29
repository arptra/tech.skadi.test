package com.google.mlkit.nl.languageid;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.util.List;

public interface LanguageIdentifier extends Closeable, LifecycleObserver, OptionalModuleApi {
    public static final float DEFAULT_IDENTIFY_LANGUAGE_CONFIDENCE_THRESHOLD = 0.5f;
    public static final float DEFAULT_IDENTIFY_POSSIBLE_LANGUAGES_CONFIDENCE_THRESHOLD = 0.01f;
    @NonNull
    public static final String UNDETERMINED_LANGUAGE_TAG = "und";

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void close();

    @NonNull
    Task<String> identifyLanguage(@NonNull String str);

    @NonNull
    Task<List<IdentifiedLanguage>> identifyPossibleLanguages(@NonNull String str);
}
