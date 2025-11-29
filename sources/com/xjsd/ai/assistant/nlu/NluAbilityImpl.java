package com.xjsd.ai.assistant.nlu;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.core.util.UrlParamsAppender;
import com.xjsd.ai.assistant.encrypt.DigestUtils;
import com.xjsd.ai.assistant.env.EnvAbility;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.net.http.OkHttpClientManager;
import com.xjsd.ai.assistant.nlu.bean.HeaderData;
import com.xjsd.ai.assistant.nlu.bean.LocationInfo;
import com.xjsd.ai.assistant.nlu.bean.MetaData;
import com.xjsd.ai.assistant.nlu.bean.NluRequest;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import com.xjsd.ai.assistant.nlu.bean.PayloadData;
import com.xjsd.ai.assistant.nlu.bean.TalkInfo;
import com.xjsd.ai.assistant.nlu.bean.UploadInfo;
import com.xjsd.ai.assistant.nlu.util.StringUtil;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NluAbilityImpl implements NluAbility {
    private static final String TAG = "NluAbilityImpl";
    private final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");
    private final Map<String, Call> callMap = new ConcurrentHashMap();
    private final ExecutorService mCachedThreadPool = ThreadPoolFactory.a("NLU");
    private final HeaderData mHeaderData = createHeaderData();
    private final MetaData mMetaData = createMetaData();
    private final PayloadData mPayloadData = createPayload();

    public final class NlpRequestTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public TalkInfo f8511a;
        public Consumer b;

        public NlpRequestTask(TalkInfo talkInfo, Consumer consumer) {
            this.f8511a = talkInfo;
            this.b = consumer;
        }

        public void run() {
            NluResponse talkNlu = NluAbilityImpl.this.talkNlu(this.f8511a);
            if (this.b != null) {
                talkNlu.setSessionId(this.f8511a.getId());
                this.b.accept(talkNlu);
            }
        }
    }

    private HeaderData createHeaderData() {
        HeaderData headerData = new HeaderData();
        headerData.setNamespace("nlp");
        headerData.setName("text-req");
        headerData.setMsgId("");
        return headerData;
    }

    private MetaData createMetaData() {
        MetaData metaData = new MetaData();
        metaData.setAccountId("");
        metaData.setDeviceId("");
        metaData.setTimeZone(TimeZone.getDefault().getID());
        metaData.setLatitude("0.0");
        metaData.setLongitude("0.0");
        return metaData;
    }

    private PayloadData createPayload() {
        PayloadData payloadData = new PayloadData();
        payloadData.setType("block");
        payloadData.setQ("");
        return payloadData;
    }

    private String getCommonParams() {
        return "tk=" + "akprefix60e4883c92d1ed3f97e875df7662fe2ac8209e0c" + "&v=" + "1" + "&" + UrlParamsAppender.a();
    }

    private String getNluUrl() {
        return ((EnvAbility) AbilityManager.b.b(EnvAbility.class)).getCurrentEnv().getNluUrl() + "/ai-xr/";
    }

    private String submitQuery(NluRequest nluRequest) {
        String msgId = nluRequest.getHeader().getMsgId();
        String terminalTraceId = nluRequest.getHeader().getTerminalTraceId();
        String c = JsonUtil.c(nluRequest);
        if (c == null) {
            ILog.m(TAG, "talk request为空");
            return null;
        }
        try {
            String str = getNluUrl() + "talk?" + getCommonParams();
            Request build = new Request.Builder().header("content-type", "application/json; charset=utf-8").header("MsgId", msgId).header("TerminalTraceId", terminalTraceId).header("AccountId", getAccountId()).header("DeviceId", getDeviceId()).header("IotDeviceId", getIotDeviceId()).url(str).post(RequestBody.create(this.APPLICATION_JSON, c)).build();
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            cacheAbility.cache("traceId", terminalTraceId);
            cacheAbility.cache(AssistantConstants.Key.CLEAN_CONTEXT, Boolean.FALSE);
            OkHttpClientManager okHttpClientManager = OkHttpClientManager.f8504a;
            Call newCall = okHttpClientManager.d().newCall(build);
            this.callMap.put(terminalTraceId, newCall);
            ILog.j(TAG, "execute http call for session->" + terminalTraceId);
            String b = okHttpClientManager.b(newCall);
            this.callMap.remove(terminalTraceId);
            ILog.j(TAG, "talk url->" + str);
            ILog.j(TAG, "talk body->" + c);
            ILog.j(TAG, "talk terminalTraceId->" + terminalTraceId);
            ILog.j(TAG, "talk response->" + b);
            return b;
        } catch (Exception e) {
            ILog.h(TAG, "talk error", e);
            return null;
        }
    }

    public void cancel(String str) {
        Call remove = this.callMap.remove(str);
        ILog.j(TAG, "cancel call id->" + str + ", call->" + remove);
        if (remove != null && remove.isExecuted()) {
            remove.cancel();
        }
    }

    public String getAccountId() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        return !cacheAbility.isProxyInstance() ? (String) cacheAbility.getCacheWithDefault("mzUid", "") : "";
    }

    public String getDeviceId() {
        return DeviceUtils.a();
    }

    public String getIotDeviceId() {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        return !cacheAbility.isProxyInstance() ? (String) cacheAbility.getCacheWithDefault("IotDeviceId", "") : "";
    }

    public NluRequest getTalkReq(TalkInfo talkInfo) {
        String id = talkInfo.getId();
        String text = talkInfo.getText();
        String str = getDeviceId() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + id;
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        this.mMetaData.setAccountId(getAccountId());
        this.mMetaData.setDeviceId(getDeviceId());
        this.mMetaData.setTimeZone(TimeZone.getDefault().getID());
        LocationInfo locationInfo = (LocationInfo) cacheAbility.getCache("locationInfo");
        if (locationInfo != null) {
            this.mMetaData.setLatitude(locationInfo.getLatitude());
            this.mMetaData.setLongitude(locationInfo.getLongitude());
        }
        this.mMetaData.setMsgId(str);
        this.mMetaData.setTraceId(id);
        this.mHeaderData.setMsgId(str);
        this.mHeaderData.setTerminalTraceId(id);
        this.mPayloadData.setQ(text);
        NluRequest nluRequest = new NluRequest();
        nluRequest.setMetadata(this.mMetaData);
        nluRequest.setHeader(this.mHeaderData);
        nluRequest.setContext(NluContextDataMaintainer.f8512a.b());
        nluRequest.setPayload(this.mPayloadData);
        cacheAbility.cache("lastNluQuery", text);
        return nluRequest;
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void talkNlu(TalkInfo talkInfo, Consumer<NluResponse> consumer) {
        this.mCachedThreadPool.execute(new NlpRequestTask(talkInfo, consumer));
    }

    public Object uploadNlu(UploadInfo uploadInfo) {
        MetaData metaData = new MetaData();
        metaData.setAccountId(getAccountId());
        metaData.setDeviceId(getDeviceId());
        HeaderData headerData = new HeaderData();
        headerData.setNamespace("upload");
        headerData.setName(uploadInfo.getType());
        String i = DigestUtils.i(JsonUtil.c(uploadInfo.getData()));
        PayloadData payloadData = new PayloadData();
        payloadData.setSign(i);
        payloadData.setIncrement(uploadInfo.isIncrement());
        payloadData.setData(uploadInfo.getData());
        NluRequest nluRequest = new NluRequest();
        nluRequest.setMetadata(metaData);
        nluRequest.setHeader(headerData);
        nluRequest.setPayload(payloadData);
        String c = JsonUtil.c(nluRequest);
        if (c == null) {
            ILog.g(TAG, "upload request is null");
            return null;
        }
        try {
            String str = getNluUrl() + "upload?type=" + StringUtil.b(uploadInfo.getType(), "contact") + "&action=add&" + getCommonParams();
            String c2 = OkHttpClientManager.f8504a.c(new Request.Builder().url(str).post(RequestBody.create(this.APPLICATION_JSON, c)).header("content-type", "application/json; charset=utf-8").header("IotDeviceId", getIotDeviceId()).build());
            ILog.j(TAG, "upload url->" + str);
            ILog.j(TAG, "upload body->" + c);
            ILog.j(TAG, "upload response->" + c2);
            return c2 != null ? (NluResponse) JsonUtil.b().readValue(c2, NluResponse.class) : new NluResponse();
        } catch (Exception e) {
            ILog.h(TAG, "upload error", e);
            return null;
        }
    }

    public NluResponse talkNlu(TalkInfo talkInfo) {
        if (!talkInfo.isFinal()) {
            return null;
        }
        String id = talkInfo.getId();
        try {
            if (!TextUtils.isEmpty(id)) {
                if (!TextUtils.isEmpty(talkInfo.getText())) {
                    String submitQuery = submitQuery(getTalkReq(talkInfo));
                    if (submitQuery != null) {
                        NluResponse nluResponse = (NluResponse) JSON.parseObject(submitQuery, NluResponse.class);
                        nluResponse.setSessionId(id);
                        return nluResponse;
                    }
                    NluResponse a2 = NluDataCreator.a("NLU_ERROR");
                    a2.setSessionId(id);
                    return a2;
                }
            }
            ILog.g(TAG, "talk messageId or text is empty");
            NluResponse a3 = NluDataCreator.a("ASR_RESULT_IS_EMPTY");
            a3.setSessionId(id);
            return a3;
        } catch (Exception e) {
            ILog.g(TAG, "take response Exception->" + e.getMessage());
        }
    }
}
