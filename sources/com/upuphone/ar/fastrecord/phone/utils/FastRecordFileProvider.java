package com.upuphone.ar.fastrecord.phone.utils;

import androidx.core.content.FileProvider;
import com.upuphone.ar.fastrecord.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/FastRecordFileProvider;", "Landroidx/core/content/FileProvider;", "()V", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFileProvider extends FileProvider {
    public FastRecordFileProvider() {
        super(R.xml.feast_record_file_paths);
    }
}
