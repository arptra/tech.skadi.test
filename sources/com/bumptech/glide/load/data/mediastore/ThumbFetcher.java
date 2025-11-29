package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f2464a;
    public final ThumbnailStreamOpener b;
    public InputStream c;

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        public static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f2465a;

        public ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f2465a = contentResolver;
        }

        public Cursor a(Uri uri) {
            return this.f2465a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        public static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f2466a;

        public VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f2466a = contentResolver;
        }

        public Cursor a(Uri uri) {
            return this.f2466a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    public ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f2464a = uri;
        this.b = thumbnailStreamOpener;
    }

    public static ThumbFetcher e(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.c(context).j().g(), thumbnailQuery, Glide.c(context).e(), context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return e(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher g(Context context, Uri uri) {
        return e(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    public Class a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public DataSource c() {
        return DataSource.LOCAL;
    }

    public void cancel() {
    }

    public void d(Priority priority, DataFetcher.DataCallback dataCallback) {
        try {
            InputStream h = h();
            this.c = h;
            dataCallback.e(h);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dataCallback.f(e);
        }
    }

    public final InputStream h() {
        InputStream d = this.b.d(this.f2464a);
        int a2 = d != null ? this.b.a(this.f2464a) : -1;
        return a2 != -1 ? new ExifOrientationStream(d, a2) : d;
    }
}
