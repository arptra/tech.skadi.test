package com.upuphone.ar.navi.lite.protocol;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.navi.lite.base.FreqAddress;
import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.starrynet.core.ble.channel.packet.Packet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtocolUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5799a = ("NAVI-" + ProtocolUtils.class.getSimpleName());

    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", str);
            jSONObject.put("data", str2);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str3 = f5799a;
            CLog.b(str3, "createBaseData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String b(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "interval_camera_info");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("carEnterCameraStatus", i2);
            jSONObject2.put("cameraSpeed", i);
            jSONArray.put(jSONObject2);
            jSONObject.put("intervalCameraInfo", jSONArray);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createCameraInfoData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String c(List list) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FreqAddress freqAddress = (FreqAddress) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("nm", freqAddress.f());
                boolean z = false;
                boolean z2 = freqAddress.c() <= 100;
                if (freqAddress.c() != -1) {
                    z = z2;
                }
                jSONObject.put("near", z);
                jSONObject.put("adr", freqAddress.a());
                jSONObject.put("als", freqAddress.b());
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createFreqAddressData e is:" + e);
        }
        return jSONArray.toString() + "";
    }

    public static String d(NaviLaneInfo naviLaneInfo) {
        return NaviUtil.s0() ? m(naviLaneInfo) : l(naviLaneInfo);
    }

    public static String e(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "navi_location");
            jSONObject.put(MzContactsContract.MzContactColumns.ADDRESS, str);
            jSONObject.put("desp", str2);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str3 = f5799a;
            CLog.b(str3, "createLocationData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String f(SearchModel searchModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", searchModel.getName());
            jSONObject.put(MzContactsContract.MzContactColumns.ADDRESS, searchModel.getAddress());
            jSONObject.put("acode", searchModel.getAcode());
            jSONObject.put("city", searchModel.getCity());
            jSONObject.put("latitude", searchModel.getLatitude());
            jSONObject.put("longitude", searchModel.getLongitude());
            jSONObject.put(MzContactsContract.MzContactColumns.DISTANCE, searchModel.getDistance());
            jSONObject.put("alias", searchModel.getAlias());
            jSONObject.put("naviMode", searchModel.getNaviMode());
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createNaviAbnormalexitRecord e is:" + e);
        }
        return jSONObject.toString();
    }

    public static String g(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", str);
            jSONObject.put("naviMode", i);
            jSONObject.put("data", str2);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str3 = f5799a;
            CLog.b(str3, "createNaviEventData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String h(NaviInfoBean naviInfoBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "navi_info");
            jSONObject.put("ic", naviInfoBean.getIconType());
            jSONObject.put("pd", naviInfoBean.getPathDistance());
            jSONObject.put("prd", naviInfoBean.getPathRetainDistance());
            jSONObject.put("prt", naviInfoBean.getPathRemainTime());
            jSONObject.put("nrn", naviInfoBean.getNextRoadName());
            jSONObject.put("nrd", naviInfoBean.getNextRoadDistance());
            jSONObject.put("ns", naviInfoBean.getNaviSpeed());
            jSONObject.put("rdd", naviInfoBean.getRideDistance());
            jSONObject.put("gs", naviInfoBean.getGpsStatus());
            jSONObject.put("hsr", naviInfoBean.getRoadClass());
            jSONObject.put("bts", naviInfoBean.getAdjustBrightness());
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createNaviInfoData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String i(int i, boolean z, int i2, boolean z2, NaviInfoBean naviInfoBean, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("naviMode", i);
            jSONObject.put("displayPos", i2);
            int i3 = 0;
            jSONObject.put("maskMsg", z ? 1 : 0);
            jSONObject.put("brightness", z2 ? 1 : 0);
            jSONObject.put("ic", naviInfoBean != null ? naviInfoBean.getIconType() : 0);
            jSONObject.put("pd", naviInfoBean != null ? naviInfoBean.getPathDistance() : 0);
            jSONObject.put("prd", naviInfoBean != null ? naviInfoBean.getPathRetainDistance() : 0);
            jSONObject.put("prt", naviInfoBean != null ? naviInfoBean.getPathRemainTime() : 0);
            jSONObject.put("nrn", naviInfoBean != null ? naviInfoBean.getNextRoadName() : "");
            jSONObject.put("nrd", naviInfoBean != null ? naviInfoBean.getNextRoadDistance() : 0);
            jSONObject.put("ns", naviInfoBean != null ? naviInfoBean.getNaviSpeed() : 0);
            jSONObject.put("rdd", naviInfoBean != null ? naviInfoBean.getRideDistance() : 0);
            jSONObject.put("gs", naviInfoBean != null ? naviInfoBean.getGpsStatus() : 0);
            if (naviInfoBean != null) {
                i3 = naviInfoBean.getRoadClass();
            }
            jSONObject.put("hsr", i3);
            jSONObject.put(Packet.ACK, j);
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createPreData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String j(int i, boolean z, int i2, boolean z2, NaviInfoBean naviInfoBean, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "pre_navi");
            jSONObject.put("naviMode", i);
            jSONObject.put("displayPos", i2);
            int i3 = 0;
            jSONObject.put("maskMsg", z ? 1 : 0);
            jSONObject.put("brightness", z2 ? 1 : 0);
            jSONObject.put("ic", naviInfoBean != null ? naviInfoBean.getIconType() : 0);
            jSONObject.put("pd", naviInfoBean != null ? naviInfoBean.getPathDistance() : 0);
            jSONObject.put("prd", naviInfoBean != null ? naviInfoBean.getPathRetainDistance() : 0);
            jSONObject.put("prt", naviInfoBean != null ? naviInfoBean.getPathRemainTime() : 0);
            jSONObject.put("nrn", naviInfoBean != null ? naviInfoBean.getNextRoadName() : "");
            jSONObject.put("nrd", naviInfoBean != null ? naviInfoBean.getNextRoadDistance() : 0);
            jSONObject.put("ns", naviInfoBean != null ? naviInfoBean.getNaviSpeed() : 0);
            jSONObject.put("rdd", naviInfoBean != null ? naviInfoBean.getRideDistance() : 0);
            jSONObject.put("gs", naviInfoBean != null ? naviInfoBean.getGpsStatus() : 0);
            if (naviInfoBean != null) {
                i3 = naviInfoBean.getRoadClass();
            }
            jSONObject.put("hsr", i3);
            jSONObject.put(Packet.ACK, j);
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createPreMessageData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String k(List list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "updateFreqAdr");
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FreqAddress freqAddress = (FreqAddress) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nm", freqAddress.f());
                boolean z = false;
                boolean z2 = freqAddress.c() <= 100;
                if (freqAddress.c() != -1) {
                    z = z2;
                }
                jSONObject2.put("near", z);
                jSONObject2.put("adr", freqAddress.a());
                jSONObject2.put("als", freqAddress.b());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("freqAdrList", jSONArray);
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "createUpdateFreqAddressData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String l(NaviLaneInfo naviLaneInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "show_lane_info");
            jSONObject.put("lc", naviLaneInfo.laneCount);
            int i = 0;
            jSONObject.put("lti", 0);
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (true) {
                int[] iArr = naviLaneInfo.frontLane;
                if (i2 >= iArr.length) {
                    break;
                }
                jSONArray.put(iArr[i2]);
                i2++;
            }
            jSONObject.put("fl", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            while (true) {
                int[] iArr2 = naviLaneInfo.backgroundLane;
                if (i >= iArr2.length) {
                    break;
                }
                jSONArray2.put(iArr2[i]);
                i++;
            }
            jSONObject.put("bl", jSONArray2);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            CLog.b(f5799a, "getAmapLaneInfoData e is:" + e);
        }
        return jSONObject.toString() + "";
    }

    public static String m(NaviLaneInfo naviLaneInfo) {
        ArrayList<Integer> arrayList = naviLaneInfo.lanesIconList;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identity", "show_lane_info");
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                jSONArray.put(arrayList.get(i));
            }
            jSONObject.put("fl", jSONArray);
            jSONObject.put(Packet.ACK, System.currentTimeMillis());
        } catch (JSONException e) {
            String str = f5799a;
            CLog.b(str, "getHereLaneInfoData e is:" + e);
        }
        return jSONObject.toString() + "";
    }
}
