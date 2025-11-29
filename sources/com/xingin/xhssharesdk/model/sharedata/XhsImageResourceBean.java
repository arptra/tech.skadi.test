package com.xingin.xhssharesdk.model.sharedata;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;
import org.json.JSONObject;

@Keep
public class XhsImageResourceBean implements Parcelable {
    public static final Parcelable.Creator<XhsImageResourceBean> CREATOR = new a();
    private static final String TAG = "XhsShare_XhsImageResourceBean";
    @Nullable
    private String networkUrl;
    @Nullable
    private Uri uri;

    public class a implements Parcelable.Creator<XhsImageResourceBean> {
        public final Object createFromParcel(Parcel parcel) {
            return new XhsImageResourceBean(parcel);
        }

        public final Object[] newArray(int i) {
            return new XhsImageResourceBean[i];
        }
    }

    public XhsImageResourceBean(@Nullable Uri uri2) {
        this.uri = uri2;
    }

    public static XhsImageResourceBean fromUrl(String str) {
        return XhsShareSdkTools.isNetworkUrl(str) ? new XhsImageResourceBean(str) : new XhsImageResourceBean(new File(str));
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getNetworkUrl() {
        return this.networkUrl;
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public boolean isValid() {
        return this.uri != null || !TextUtils.isEmpty(this.networkUrl);
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        Uri uri2 = this.uri;
        if (uri2 != null) {
            jSONObject.putOpt("uri", uri2.toString());
        }
        if (!TextUtils.isEmpty(this.networkUrl)) {
            jSONObject.putOpt("url", this.networkUrl);
        }
        return jSONObject;
    }

    public String toString() {
        return "XhsImageResourceBean{uri=" + this.uri + ", networkUrl='" + this.networkUrl + "'}";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.networkUrl);
    }

    public XhsImageResourceBean(Parcel parcel) {
        try {
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.networkUrl = parcel.readString();
        } catch (Throwable th) {
            XhsShareSdk.c(TAG, "XhsImageResourceBean from Parcel error!", th);
        }
    }

    public XhsImageResourceBean(File file) {
        this(Uri.fromFile(file));
    }

    private XhsImageResourceBean(String str) {
        this.networkUrl = str;
    }
}
