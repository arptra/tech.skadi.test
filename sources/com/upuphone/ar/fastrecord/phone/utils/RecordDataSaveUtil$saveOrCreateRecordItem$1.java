package com.upuphone.ar.fastrecord.phone.utils;

import android.text.TextUtils;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil$saveOrCreateRecordItem$1", f = "RecordDataSaveUtil.kt", i = {2}, l = {191, 216, 232}, m = "invokeSuspend", n = {"recordHistoryInfo"}, s = {"L$0"})
public final class RecordDataSaveUtil$saveOrCreateRecordItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ RecordGlassStatus $mRecordGlassStatus;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordDataSaveUtil$saveOrCreateRecordItem$1(RecordGlassStatus recordGlassStatus, Function1<? super Integer, Unit> function1, Continuation<? super RecordDataSaveUtil$saveOrCreateRecordItem$1> continuation) {
        super(2, continuation);
        this.$mRecordGlassStatus = recordGlassStatus;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordDataSaveUtil$saveOrCreateRecordItem$1(this.$mRecordGlassStatus, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RecordEntity recordEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            long id = this.$mRecordGlassStatus.getId();
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.findRecordEntityById$default(fastRecordDao, id, (String) null, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.$callback.invoke(Boxing.boxInt(1));
            return Unit.INSTANCE;
        } else if (i == 3) {
            recordEntity = (RecordEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.$callback.invoke(Boxing.boxInt(4));
            FastRecordManager.Companion.getInstance().appViewModel().setRecordIngTimeEntity(recordEntity);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecordEntity recordEntity2 = (RecordEntity) obj;
        if (this.$mRecordGlassStatus.getId() == 0) {
            final long access$getMaxRecordId = RecordDataSaveUtil.INSTANCE.getMaxRecordId() + 1;
            this.$mRecordGlassStatus.setId(access$getMaxRecordId);
            RecordInterConnectHelper instance = RecordInterConnectHelper.Companion.getInstance();
            final RecordGlassStatus recordGlassStatus = this.$mRecordGlassStatus;
            final Function1<Integer, Unit> function1 = this.$callback;
            instance.sendMsgRecordId(access$getMaxRecordId, new SendMessageListener() {
                public void onFail(@Nullable String str, int i) {
                    if (str == null) {
                        str = "";
                    }
                    LogExt.logE("RecordDataSaveUtil error msg = " + str + ",code = " + i, RecordDataSaveUtil.TAG);
                }

                public void onSuccess(@Nullable String str) {
                    if (str == null) {
                        str = "";
                    }
                    LogExt.logE("RecordDataSaveUtil onSuccess msg = " + str, RecordDataSaveUtil.TAG);
                    RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
                    recordDataSaveUtil.saveRecordData(recordDataSaveUtil.createRecordEntity(access$getMaxRecordId, recordGlassStatus.getType()), recordGlassStatus, function1);
                    recordDataSaveUtil.saveMaxRecordId(access$getMaxRecordId);
                }
            });
            return Unit.INSTANCE;
        } else if (recordEntity2 == null) {
            LogExt.logW("recordHistoryInfo is not exist", RecordDataSaveUtil.TAG);
            RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
            long access$getMaxRecordId2 = recordDataSaveUtil.getMaxRecordId();
            if (access$getMaxRecordId2 < this.$mRecordGlassStatus.getId()) {
                long id2 = this.$mRecordGlassStatus.getId();
                LogExt.logW("maxId = " + access$getMaxRecordId2 + "  < mRecordGlassStatus.id = " + id2, RecordDataSaveUtil.TAG);
                if (this.$mRecordGlassStatus.getId() < 100000000) {
                    LogExt.logE("saveMaxRecordId", RecordDataSaveUtil.TAG);
                    recordDataSaveUtil.saveMaxRecordId(this.$mRecordGlassStatus.getId());
                }
            }
            if (100 > this.$mRecordGlassStatus.getId()) {
                LogExt.logW("MIN_RECORD_ID > mRecordGlassStatus.id", RecordDataSaveUtil.TAG);
                this.$mRecordGlassStatus.setId(recordDataSaveUtil.getMaxRecordIdAndSave());
            }
            long id3 = this.$mRecordGlassStatus.getId();
            LogExt.logW("mRecordGlassStatus.id  = " + id3, RecordDataSaveUtil.TAG);
            RecordEntity createRecordEntity = recordDataSaveUtil.createRecordEntity(this.$mRecordGlassStatus.getId(), this.$mRecordGlassStatus.getType());
            FastRecordDao fastRecordDao2 = FastRecordManager.Companion.getInstance().fastRecordDao();
            this.label = 2;
            if (fastRecordDao2.insert(createRecordEntity, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.$callback.invoke(Boxing.boxInt(1));
            return Unit.INSTANCE;
        } else {
            LogExt.logW("recordHistoryInfo is  exist recordHistoryInfo = " + recordEntity2, RecordDataSaveUtil.TAG);
            recordEntity2.setLastModified(System.currentTimeMillis());
            recordEntity2.setRecordStatus(4);
            recordEntity2.setFinishFileMerge(false);
            if (TextUtils.isEmpty(recordEntity2.getShortHandTitle())) {
                String shortHandTitle = recordEntity2.getShortHandTitle();
                String name = Thread.currentThread().getName();
                LogExt.logW("recordHistoryInfo is  exist recordHistoryInfo.shortHandTitle = " + shortHandTitle + ",thread name =" + name, RecordDataSaveUtil.TAG);
                String str = null;
                List allRecordEntity$default = FastRecordDao.DefaultImpls.getAllRecordEntity$default(FastRecordManager.Companion.getInstance().fastRecordDao(), (String) null, 1, (Object) null);
                FastRecordTitleHelper instance2 = FastRecordTitleHelper.Companion.getInstance();
                if (instance2 != null) {
                    str = instance2.getTitle(this.$mRecordGlassStatus.getType(), allRecordEntity$default);
                }
                recordEntity2.setShortHandTitle(str);
            }
            FastRecordDao fastRecordDao3 = FastRecordManager.Companion.getInstance().fastRecordDao();
            this.L$0 = recordEntity2;
            this.label = 3;
            if (fastRecordDao3.update(recordEntity2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            recordEntity = recordEntity2;
            this.$callback.invoke(Boxing.boxInt(4));
            FastRecordManager.Companion.getInstance().appViewModel().setRecordIngTimeEntity(recordEntity);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordDataSaveUtil$saveOrCreateRecordItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
