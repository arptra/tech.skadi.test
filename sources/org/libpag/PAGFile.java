package org.libpag;

import android.content.res.AssetManager;
import android.text.TextUtils;
import org.extra.tools.a;

public class PAGFile extends PAGComposition {

    public interface LoadListener {
        void onLoad(PAGFile pAGFile);
    }

    static {
        a.e("pag");
        nativeInit();
    }

    private PAGFile(long j) {
        super(j);
    }

    public static PAGFile Load(String str) {
        if (TextUtils.isEmpty(str) || (!str.startsWith("http://") && !str.startsWith("https://"))) {
            return LoadFromPath(str);
        }
        byte[] a2 = b.a(str);
        if (a2 == null) {
            return null;
        }
        return LoadFromBytes(a2, a2.length, str);
    }

    public static void LoadAsync(String str, LoadListener loadListener) {
        NativeTask.Run(new com.honey.account.pc.a(str, loadListener));
    }

    private static native PAGFile LoadFromAssets(AssetManager assetManager, String str);

    private static native PAGFile LoadFromBytes(byte[] bArr, int i, String str);

    private static native PAGFile LoadFromPath(String str);

    public static native int MaxSupportedTagLevel();

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, LoadListener loadListener) {
        PAGFile Load = Load(str);
        if (loadListener != null) {
            loadListener.onLoad(Load);
        }
    }

    private static final native void nativeInit();

    public native PAGFile copyOriginal();

    public native int[] getEditableIndices(int i);

    public native PAGLayer[] getLayersByEditableIndex(int i, int i2);

    public native PAGText getTextData(int i);

    public native void nativeReplaceImage(int i, long j);

    public native void nativeReplaceImageByName(String str, long j);

    public native int numImages();

    public native int numTexts();

    public native int numVideos();

    public native String path();

    public void replaceImage(int i, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImage(i, 0);
        } else {
            nativeReplaceImage(i, pAGImage.nativeContext);
        }
    }

    public void replaceImageByName(String str, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImageByName(str, 0);
        } else {
            nativeReplaceImageByName(str, pAGImage.nativeContext);
        }
    }

    public native void replaceText(int i, PAGText pAGText);

    public native void setDuration(long j);

    public native void setTimeStretchMode(int i);

    public native int tagLevel();

    public native int timeStretchMode();

    public static PAGFile Load(byte[] bArr) {
        return LoadFromBytes(bArr, bArr.length, "");
    }

    public static PAGFile Load(AssetManager assetManager, String str) {
        return LoadFromAssets(assetManager, str);
    }
}
