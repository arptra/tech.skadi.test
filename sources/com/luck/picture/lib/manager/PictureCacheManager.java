package com.luck.picture.lib.manager;

import android.content.Context;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import java.io.File;

public class PictureCacheManager {

    /* renamed from: com.luck.picture.lib.manager.PictureCacheManager$1  reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9434a;
        public final /* synthetic */ File b;

        public void run() {
            new PictureMediaScannerConnection(this.f9434a, this.b.getAbsolutePath());
        }
    }

    /* renamed from: com.luck.picture.lib.manager.PictureCacheManager$2  reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9435a;
        public final /* synthetic */ File b;

        public void run() {
            new PictureMediaScannerConnection(this.f9435a, this.b.getAbsolutePath());
        }
    }

    /* renamed from: com.luck.picture.lib.manager.PictureCacheManager$3  reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9436a;
        public final /* synthetic */ File b;

        public void run() {
            new PictureMediaScannerConnection(this.f9436a, this.b.getAbsolutePath());
        }
    }

    /* renamed from: com.luck.picture.lib.manager.PictureCacheManager$4  reason: invalid class name */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9437a;
        public final /* synthetic */ File b;

        public void run() {
            new PictureMediaScannerConnection(this.f9437a, this.b.getAbsolutePath());
        }
    }
}
