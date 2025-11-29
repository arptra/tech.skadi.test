package com.xjsd.ai.assistant.phone.media;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.actions.SearchIntents;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import com.xjsd.ai.assistant.common.SessionHelper;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.connect.SendMsgCallback;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.music.MediaModel;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/phone/media/MediaHelper;", "", "<init>", "()V", "", "name", "nlgId", "Lcom/alibaba/fastjson/JSONObject;", "payload", "Lcom/xjsd/ai/assistant/core/api/music/MediaModel;", "b", "(Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)Lcom/xjsd/ai/assistant/core/api/music/MediaModel;", "mediaModel", "", "isDialogFlow", "", "e", "(Lcom/xjsd/ai/assistant/core/api/music/MediaModel;Z)V", "player", "c", "(Ljava/lang/String;)Z", "d", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaHelper f8572a = new MediaHelper();

    public static final MediaModel b(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "nlgId");
        Intrinsics.checkNotNullParameter(jSONObject, "payload");
        MediaModel mediaModel = new MediaModel();
        mediaModel.setNlgId(str2);
        String string = jSONObject.getString("player");
        String str3 = "";
        if (string == null) {
            string = str3;
        }
        mediaModel.setPlayer(string);
        String string2 = jSONObject.getString("artist");
        if (string2 == null) {
            string2 = str3;
        }
        mediaModel.setArtist(string2);
        String string3 = jSONObject.getString("title");
        if (string3 == null) {
            string3 = str3;
        }
        mediaModel.setTitle(string3);
        String string4 = jSONObject.getString("album");
        if (string4 == null) {
            string4 = str3;
        }
        mediaModel.setAlbum(string4);
        String string5 = jSONObject.getString("genre");
        if (string5 == null) {
            string5 = str3;
        }
        mediaModel.setGenre(string5);
        String string6 = jSONObject.getString("source");
        if (string6 == null) {
            string6 = str3;
        }
        mediaModel.setSource(string6);
        String string7 = jSONObject.getString("list");
        if (string7 == null) {
            string7 = str3;
        }
        mediaModel.setList(string7);
        String string8 = jSONObject.getString("plate");
        if (string8 == null) {
            string8 = str3;
        }
        mediaModel.setPlate(string8);
        String string9 = jSONObject.getString("target_device");
        if (string9 == null) {
            string9 = str3;
        }
        mediaModel.setTarget_device(string9);
        String string10 = jSONObject.getString("tag");
        if (string10 == null) {
            string10 = str3;
        }
        mediaModel.setTag(string10);
        String string11 = jSONObject.getString(SearchIntents.EXTRA_QUERY);
        if (string11 != null) {
            str3 = string11;
        }
        mediaModel.setQuery(str3);
        MediaHelper mediaHelper = f8572a;
        String player = mediaModel.getPlayer();
        Intrinsics.checkNotNullExpressionValue(player, "getPlayer(...)");
        if (mediaHelper.c(player)) {
            switch (str.hashCode()) {
                case -1545654688:
                    if (str.equals("RemoveFavorite")) {
                        mediaModel.setCmdType("RemoveFavorite");
                        mediaModel.setFavoriteType(jSONObject.getString("name"));
                        break;
                    }
                    break;
                case 2490196:
                    if (str.equals("Play")) {
                        mediaModel.setCmdType("Play");
                        if (TextUtils.isEmpty(mediaModel.getAlbum())) {
                            if (TextUtils.isEmpty(mediaModel.getGenre())) {
                                if (TextUtils.isEmpty(mediaModel.getList())) {
                                    if (TextUtils.isEmpty(mediaModel.getTag())) {
                                        if (TextUtils.isEmpty(mediaModel.getSource())) {
                                            if (TextUtils.isEmpty(mediaModel.getArtist()) && TextUtils.isEmpty(mediaModel.getTitle())) {
                                                mediaModel.setCmdType("Control");
                                                mediaModel.setControlType("Open");
                                                break;
                                            } else {
                                                mediaModel.setPlayQueryType("song");
                                                break;
                                            }
                                        } else {
                                            mediaModel.setPlayQueryType("source");
                                            break;
                                        }
                                    } else {
                                        mediaModel.setPlayQueryType("tag");
                                        break;
                                    }
                                } else {
                                    mediaModel.setPlayQueryType("list");
                                    break;
                                }
                            } else {
                                mediaModel.setPlayQueryType("genre");
                                break;
                            }
                        } else {
                            mediaModel.setPlayQueryType("album");
                            break;
                        }
                    }
                    break;
                case 78391464:
                    if (str.equals("Query")) {
                        mediaModel.setCmdType("Query");
                        mediaModel.setQueryTarget(jSONObject.getString("target"));
                        break;
                    }
                    break;
                case 1115434428:
                    if (str.equals("Favorite")) {
                        mediaModel.setCmdType("Favorite");
                        mediaModel.setFavoriteType(jSONObject.getString("name"));
                        break;
                    }
                    break;
                case 1943200535:
                    if (str.equals("PlayMode")) {
                        mediaModel.setCmdType("PlayMode");
                        mediaModel.setPlayMode(jSONObject.getString(RtspHeaders.Values.MODE));
                        break;
                    }
                    break;
            }
        }
        return mediaModel;
    }

    public static final void e(MediaModel mediaModel, boolean z) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        mediaModel.setSessionId(SessionHelper.f8413a.a());
        String e = GsonUtils.e(mediaModel);
        HashMap hashMap = new HashMap();
        hashMap.put("msgCmd", 101);
        hashMap.put("fromType", 2000);
        hashMap.put("data", e);
        String e2 = GsonUtils.e(hashMap);
        ILog.a("MediaHelper", "发送给随身听的数据->" + e2);
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setMessage(e2);
        starryNetMessage.setReceiverPkg("com.upuphone.ar.music.phone");
        starryNetMessage.setTarget(1);
        InterconnectAbility interconnectAbility = (InterconnectAbility) AbilityManager.b.b(InterconnectAbility.class);
        if (interconnectAbility != null) {
            interconnectAbility.send(starryNetMessage, (SendMsgCallback) new MediaHelper$sendMediaData2Walkman$1(z));
        }
    }

    public static /* synthetic */ void f(MediaModel mediaModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        e(mediaModel, z);
    }

    public final boolean c(String str) {
        ILog.j("MediaHelper", "checkPlayerSupport:player=" + str);
        return TextUtils.isEmpty(str) || Intrinsics.areEqual((Object) "QQ音乐", (Object) str) || Intrinsics.areEqual((Object) "qq音乐", (Object) str);
    }

    public final void d() {
        ContinuousDialogDispatcher.d(false, 1, (Object) null);
    }
}
