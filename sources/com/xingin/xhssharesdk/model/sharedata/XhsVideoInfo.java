package com.xingin.xhssharesdk.model.sharedata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

@Keep
public class XhsVideoInfo implements Parcelable {
    public static final Parcelable.Creator<XhsVideoInfo> CREATOR = new a();
    @Nullable
    private final XhsImageResourceBean cover;
    @NonNull
    private final XhsVideoResourceBean video;

    public class a implements Parcelable.Creator<XhsVideoInfo> {
        public final Object createFromParcel(Parcel parcel) {
            return new XhsVideoInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new XhsVideoInfo[i];
        }
    }

    public XhsVideoInfo(Parcel parcel) {
        this.video = (XhsVideoResourceBean) parcel.readParcelable(XhsVideoResourceBean.class.getClassLoader());
        this.cover = (XhsImageResourceBean) parcel.readParcelable(XhsImageResourceBean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public XhsImageResourceBean getCover() {
        return this.cover;
    }

    @NonNull
    public XhsVideoResourceBean getVideo() {
        return this.video;
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("video", this.video.toJsonForDeeplink());
        XhsImageResourceBean xhsImageResourceBean = this.cover;
        if (xhsImageResourceBean != null) {
            jSONObject.putOpt("cover", xhsImageResourceBean.toJsonForDeeplink());
        }
        return jSONObject;
    }

    public String toString() {
        return "XhsVideoInfo{video=" + this.video + ", cover=" + this.cover + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.video, i);
        parcel.writeParcelable(this.cover, i);
    }

    public XhsVideoInfo(@NonNull XhsVideoResourceBean xhsVideoResourceBean) {
        this(xhsVideoResourceBean, (XhsImageResourceBean) null);
    }

    public XhsVideoInfo(@NonNull XhsVideoResourceBean xhsVideoResourceBean, @Nullable XhsImageResourceBean xhsImageResourceBean) {
        this.video = xhsVideoResourceBean;
        this.cover = xhsImageResourceBean;
    }
}
