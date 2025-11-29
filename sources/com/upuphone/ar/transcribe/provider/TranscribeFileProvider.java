package com.upuphone.ar.transcribe.provider;

import androidx.core.content.FileProvider;
import com.upuphone.ar.transcribe.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/transcribe/provider/TranscribeFileProvider;", "Landroidx/core/content/FileProvider;", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeFileProvider extends FileProvider {
    public TranscribeFileProvider() {
        super(R.xml.transcribe_file_paths);
    }
}
