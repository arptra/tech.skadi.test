package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.m;
import com.sina.weibo.sdk.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;

public class ImageObject extends MediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 204800;
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() {
        /* renamed from: a */
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        /* renamed from: b */
        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int PATH_LENGTH_LIMIT = 512;
    private static final String TAG = n.b;
    private static final long serialVersionUID = 8760548583231081050L;
    public byte[] imageData;
    public String imagePath;

    public ImageObject() {
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return (int) file.length();
    }

    public static boolean isSafeContentBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length;
            boolean z = length > 0 && length < CONTENT_LENGTH_LIMIT;
            byteArrayOutputStream.close();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public boolean checkArgs() {
        int fileSize;
        String str;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            n.a(TAG, "checkArgs fail, all arguments are null", (Throwable) null);
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            String str2 = this.imagePath;
            if (str2 == null || str2.length() <= 512) {
                String str3 = this.imagePath;
                if (str3 == null || (fileSize = getFileSize(str3)) <= CONTENT_LENGTH_LIMIT) {
                    return true;
                }
                String str4 = TAG;
                n.a(str4, "checkArgs fail, image content is too large " + fileSize + "b", (Throwable) null);
                return false;
            }
            n.a(TAG, "checkArgs fail, path is invalid", (Throwable) null);
            return false;
        }
        String str5 = TAG;
        n.a(str5, "checkArgs fail, content is too large " + this.imageData.length + "b", (Throwable) null);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void setImageData(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            n.a(TAG, "ImageObject", e);
        }
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageObject{imageData=");
        sb.append(Arrays.toString(this.imageData));
        sb.append(", imagePath='");
        StringBuilder a2 = m.a(m.a(m.a(m.a(m.a(m.a(sb, this.imagePath, '\'', ", actionUrl='"), this.actionUrl, '\'', ", schema='"), this.schema, '\'', ", identify='"), this.identify, '\'', ", title='"), this.title, '\'', ", description='"), this.description, '\'', ", thumbData=");
        a2.append(Arrays.toString(this.thumbData));
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }
}
