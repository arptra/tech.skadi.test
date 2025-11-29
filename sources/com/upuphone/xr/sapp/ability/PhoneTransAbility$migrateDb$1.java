package com.upuphone.xr.sapp.ability;

import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.bean.TranscribeStoreExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.TranslatorLitePalHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPhoneTransAbility.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneTransAbility.kt\ncom/upuphone/xr/sapp/ability/PhoneTransAbility$migrateDb$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n1549#2:159\n1620#2,3:160\n*S KotlinDebug\n*F\n+ 1 PhoneTransAbility.kt\ncom/upuphone/xr/sapp/ability/PhoneTransAbility$migrateDb$1\n*L\n136#1:159\n136#1:160,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.ability.PhoneTransAbility$migrateDb$1", f = "PhoneTransAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneTransAbility$migrateDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PhoneTransAbility this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneTransAbility$migrateDb$1(PhoneTransAbility phoneTransAbility, Continuation<? super PhoneTransAbility$migrateDb$1> continuation) {
        super(2, continuation);
        this.this$0 = phoneTransAbility;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PhoneTransAbility$migrateDb$1 phoneTransAbility$migrateDb$1 = new PhoneTransAbility$migrateDb$1(this.this$0, continuation);
        phoneTransAbility$migrateDb$1.L$0 = obj;
        return phoneTransAbility$migrateDb$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            LogExt.d("migrate transcribe db", "Sapp-PhoneTransAbility");
            if (PreferencesUtils.f6190a.h(this.this$0.b())) {
                LogExt.d("db has already migrated", "Sapp-PhoneTransAbility");
                return Unit.INSTANCE;
            }
            PhoneTransAbility phoneTransAbility = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                TranslatorLitePalHelper translatorLitePalHelper = TranslatorLitePalHelper.f6309a;
                translatorLitePalHelper.g(phoneTransAbility.b());
                List<NoteBean> k = translatorLitePalHelper.k();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(k, 10));
                for (NoteBean noteBean : k) {
                    TranscribeBean transcribeBean = r6;
                    TranscribeBean transcribeBean2 = new TranscribeBean((Long) null, (String) null, 0, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
                    TranscribeBean transcribeBean3 = transcribeBean;
                    transcribeBean3.setRecordTime(noteBean.getRecordTime());
                    transcribeBean3.setXrType(noteBean.getXrType());
                    transcribeBean3.setSuperTitle(noteBean.getTitle());
                    transcribeBean3.setTitle(TranscribeStoreExtKt.getAirRecordContent(noteBean.getSrcContent()));
                    transcribeBean3.setLocation(noteBean.getGeoLocation());
                    transcribeBean3.setAccount(noteBean.getAccountId());
                    transcribeBean3.setLanguage(noteBean.getSrcLanguage());
                    transcribeBean3.setRecognizeId(noteBean.getRecognizeId());
                    arrayList.add(transcribeBean3);
                }
                TranscribeApp.migrateDb(phoneTransAbility.b(), arrayList);
                obj2 = Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m20constructorimpl(ResultKt.createFailure(th));
            }
            PhoneTransAbility phoneTransAbility2 = this.this$0;
            if (Result.m27isSuccessimpl(obj2)) {
                Unit unit = (Unit) obj2;
                LogExt.d("db migrated success", "Sapp-PhoneTransAbility");
                PreferencesUtils.f6190a.k(phoneTransAbility2.b());
            }
            Throwable r0 = Result.m23exceptionOrNullimpl(obj2);
            if (r0 != null) {
                String message = r0.getMessage();
                LogExt.e("db migrated failed: " + message, "Sapp-PhoneTransAbility");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PhoneTransAbility$migrateDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
