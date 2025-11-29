package com.upuphone.ar.transcribe.phone.repo;

import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTranscribeAiRepo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeAiRepo.kt\ncom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo$getTodoFromCloudInternal$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,292:1\n1559#2:293\n1590#2,4:294\n1864#2,3:298\n*S KotlinDebug\n*F\n+ 1 TranscribeAiRepo.kt\ncom/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo$getTodoFromCloudInternal$1$1\n*L\n223#1:293\n223#1:294,4\n240#1:298,3\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo$getTodoFromCloudInternal$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onTodo", "", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAiRepo$getTodoFromCloudInternal$1$1 extends SmartExCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeAiRepo f6124a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TranscribeBean c;

    public TranscribeAiRepo$getTodoFromCloudInternal$1$1(TranscribeAiRepo transcribeAiRepo, String str, TranscribeBean transcribeBean) {
        this.f6124a = transcribeAiRepo;
        this.b = str;
        this.c = transcribeBean;
    }

    public void onTodo(SmartExTodo smartExTodo) {
        this.f6124a.f.remove(this.b);
        if (smartExTodo != null && smartExTodo.getBaseStatus() == 0 && (!smartExTodo.getTodoList().isEmpty())) {
            ArrayList<SmartExTodo.ToDo> todoList = smartExTodo.getTodoList();
            TranscribeAiRepo transcribeAiRepo = this.f6124a;
            TranscribeBean transcribeBean = this.c;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(todoList, 10));
            int i = 0;
            int i2 = 0;
            for (T next : todoList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SmartExTodo.ToDo toDo = (SmartExTodo.ToDo) next;
                AiTodoEntity aiTodoEntity = new AiTodoEntity(0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, false, (String) null, (Integer) null, false, 65535, (DefaultConstructorMarker) null);
                aiTodoEntity.setItemType(0);
                aiTodoEntity.setTitle(transcribeAiRepo.m().getString(R.string.tl_to_do_simple) + " " + i3);
                aiTodoEntity.setContent(toDo.getContent());
                aiTodoEntity.setStartTime(toDo.getStartTime());
                aiTodoEntity.setEndTime(toDo.getEndTime());
                String account = transcribeBean.getAccount();
                String str = "";
                if (account == null) {
                    account = str;
                }
                aiTodoEntity.setAccountId(account);
                String recognizeId = transcribeBean.getRecognizeId();
                if (recognizeId != null) {
                    str = recognizeId;
                }
                aiTodoEntity.setRecognizeId(str);
                aiTodoEntity.setSrc(toDo.getContent());
                aiTodoEntity.setDeleted(0);
                aiTodoEntity.setReported(0);
                aiTodoEntity.setRequestId(smartExTodo.getRequestId());
                arrayList.add(aiTodoEntity);
                i2 = i3;
            }
            TranscribeAiRepo transcribeAiRepo2 = this.f6124a;
            String str2 = this.b;
            Long[] lArr = (Long[]) BuildersKt__BuildersKt.b((CoroutineContext) null, new TranscribeAiRepo$getTodoFromCloudInternal$1$1$onTodo$2$ids$1(transcribeAiRepo2, arrayList, (Continuation<? super TranscribeAiRepo$getTodoFromCloudInternal$1$1$onTodo$2$ids$1>) null), 1, (Object) null);
            for (Object next2 : arrayList) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((AiTodoEntity) next2).setId(lArr[i].longValue());
                i = i4;
            }
            LogExt.d("after insert to db", "TranscribeAiRepo");
            OnDataLoadListener onDataLoadListener = (OnDataLoadListener) transcribeAiRepo2.d.remove(str2);
            if (onDataLoadListener != null) {
                onDataLoadListener.a(arrayList);
            }
        } else if (smartExTodo != null) {
            OnDataLoadListener onDataLoadListener2 = (OnDataLoadListener) this.f6124a.d.remove(this.b);
            if (onDataLoadListener2 != null) {
                onDataLoadListener2.a(new AiResponseTodo(smartExTodo.getVersionCode(), CollectionsKt.emptyList(), smartExTodo.getBaseStatus(), smartExTodo.getRequestId()));
            }
        } else {
            OnDataLoadListener onDataLoadListener3 = (OnDataLoadListener) this.f6124a.d.remove(this.b);
            if (onDataLoadListener3 != null) {
                onDataLoadListener3.a((Object) null);
            }
        }
    }

    public void onTodoSensitive(SensitivePayload sensitivePayload) {
        this.f6124a.f.remove(this.b);
        OnDataLoadListener onDataLoadListener = (OnDataLoadListener) this.f6124a.d.remove(this.b);
        if (onDataLoadListener != null) {
            onDataLoadListener.a(sensitivePayload != null ? new AiResponseSensitive(sensitivePayload.getRequestId(), sensitivePayload.getRequestStatus(), sensitivePayload.getRiskDescription(), sensitivePayload.getRiskLevel()) : null);
        }
    }
}
