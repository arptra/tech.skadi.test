package com.upuphone.xr.sapp.contract;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.e8.a;
import com.honey.account.e8.b;
import com.honey.account.e8.c;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.ItemTtsTimbreBinding;
import com.upuphone.xr.sapp.utils.DimensExtKt;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.tts.TtsAbility;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.api.tts.TtsListener;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00072\u00020\u0001:\u0006()*+,-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0010j\b\u0012\u0004\u0012\u00020\t`\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00060\u0015R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR#\u0010$\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010&¨\u0006."}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;", "", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "h", "()V", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;", "ttsTimbreItem", "g", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;)V", "i", "a", "Landroid/app/Activity;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "ttsTimbreItems", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreAdapter;", "c", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreAdapter;", "ttsTimbreAdapter", "", "d", "Ljava/lang/String;", "timbreUserInText", "e", "timbreUserNotText", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "()Lflyme/support/v7/app/AlertDialog;", "mSelectDialog", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", "Companion", "PlayTask", "TtsTimbreAdapter", "TtsTimbreItem", "TtsTimbreItemDecoration", "VH", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantTtsTimbreSelector {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Activity f6679a;
    public final ArrayList b;
    public TtsTimbreAdapter c;
    public final String d;
    public final String e;
    public final Lazy f = LazyKt.lazy(new AssistantTtsTimbreSelector$mSelectDialog$2(this));
    public Job g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0002@BX\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$PlayTask;", "Lcom/xjsd/ai/assistant/core/api/tts/TtsListener;", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;", "ttsTimbreItem", "<init>", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;)V", "", "onDiscard", "()V", "onSpeakStart", "onSpeakEnd", "", "error", "onSpeakError", "(Ljava/lang/String;)V", "a", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;", "", "value", "b", "Z", "c", "(Z)V", "playEnd", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PlayTask implements TtsListener {

        /* renamed from: a  reason: collision with root package name */
        public final TtsTimbreItem f6682a;
        public boolean b;
        public final /* synthetic */ AssistantTtsTimbreSelector c;

        public PlayTask(AssistantTtsTimbreSelector assistantTtsTimbreSelector, TtsTimbreItem ttsTimbreItem) {
            Intrinsics.checkNotNullParameter(ttsTimbreItem, "ttsTimbreItem");
            this.c = assistantTtsTimbreSelector;
            this.f6682a = ttsTimbreItem;
        }

        public static final void b(AssistantTtsTimbreSelector assistantTtsTimbreSelector) {
            Intrinsics.checkNotNullParameter(assistantTtsTimbreSelector, "this$0");
            assistantTtsTimbreSelector.c.notifyDataSetChanged();
        }

        public final void c(boolean z) {
            this.b = z;
            this.f6682a.g(!z);
            this.c.f6679a.runOnUiThread(new a(this.c));
        }

        public void onDiscard() {
            ILog.a("AssistantTtsTimbreSelector", "onDiscard");
            c(true);
        }

        public void onSpeakEnd() {
            ILog.a("AssistantTtsTimbreSelector", "onSpeakEnd");
            c(true);
        }

        public void onSpeakError(String str) {
            ILog.a("AssistantTtsTimbreSelector", "onSpeakError: " + str);
            c(true);
        }

        public void onSpeakStart() {
            ILog.a("AssistantTtsTimbreSelector", "onSpeakStart");
            c(false);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$VH;", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;", "", "Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;", "data", "<init>", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;Ljava/util/List;)V", "", "index", "", "m", "(I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "l", "(Landroid/view/ViewGroup;I)Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$VH;", "getItemCount", "()I", "holder", "position", "i", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$VH;I)V", "a", "Ljava/util/List;", "getData", "()Ljava/util/List;", "b", "I", "selectIndex", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TtsTimbreAdapter extends RecyclerView.Adapter<VH> {

        /* renamed from: a  reason: collision with root package name */
        public final List f6683a;
        public int b;
        public final /* synthetic */ AssistantTtsTimbreSelector c;

        public TtsTimbreAdapter(AssistantTtsTimbreSelector assistantTtsTimbreSelector, List list) {
            Intrinsics.checkNotNullParameter(list, "data");
            this.c = assistantTtsTimbreSelector;
            this.f6683a = list;
        }

        public static final void j(TtsTimbreAdapter ttsTimbreAdapter, VH vh, View view) {
            Intrinsics.checkNotNullParameter(ttsTimbreAdapter, "this$0");
            Intrinsics.checkNotNullParameter(vh, "$holder");
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            ttsTimbreAdapter.b = ((Integer) tag).intValue();
            SdkContext.f6675a.d().a("App_status_VoiceAssistantPage", MapsKt.mapOf(TuplesKt.to("voiceType", Integer.valueOf(ttsTimbreAdapter.b + 1))));
            AssistantSettingUtils.b.d(vh.a().getRoot().getContext(), ttsTimbreAdapter.b);
            ttsTimbreAdapter.notifyDataSetChanged();
        }

        public static final void k(AssistantTtsTimbreSelector assistantTtsTimbreSelector, TtsTimbreItem ttsTimbreItem, View view) {
            Intrinsics.checkNotNullParameter(assistantTtsTimbreSelector, "this$0");
            Intrinsics.checkNotNullParameter(ttsTimbreItem, "$item");
            assistantTtsTimbreSelector.g(ttsTimbreItem);
        }

        public int getItemCount() {
            return this.f6683a.size();
        }

        /* renamed from: i */
        public void onBindViewHolder(VH vh, int i) {
            Intrinsics.checkNotNullParameter(vh, "holder");
            TtsTimbreItem ttsTimbreItem = (TtsTimbreItem) this.f6683a.get(i);
            vh.a().c.setImageResource(ttsTimbreItem.a());
            vh.a().d.setImageResource(ttsTimbreItem.f() ? R.drawable.ic_timbre_parse : R.drawable.ic_play);
            vh.a().f.setText(ttsTimbreItem.d());
            vh.a().e.setText(ttsTimbreItem.b());
            vh.a().b.setText(this.b == i ? this.c.d : this.c.e);
            vh.a().b.setChecked(this.b == i);
            vh.a().b.setTag(Integer.valueOf(i));
            vh.a().b.setOnClickListener(new b(this, vh));
            vh.a().d.setOnClickListener(new c(this.c, ttsTimbreItem));
        }

        /* renamed from: l */
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            ItemTtsTimbreBinding c2 = ItemTtsTimbreBinding.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
            return new VH(this.c, c2);
        }

        public final void m(int i) {
            this.b = i;
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001a\u0010\u000eR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItem;", "", "", "src", "", "title", "subTitle", "tts", "", "isPlaying", "timbre", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "d", "c", "e", "Z", "f", "()Z", "g", "(Z)V", "setTimbre", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class TtsTimbreItem {

        /* renamed from: a  reason: collision with root package name */
        public final int f6684a;
        public final String b;
        public final String c;
        public final String d;
        public boolean e;
        public String f;

        public TtsTimbreItem(int i, String str, String str2, String str3, boolean z, String str4) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "subTitle");
            Intrinsics.checkNotNullParameter(str3, "tts");
            Intrinsics.checkNotNullParameter(str4, "timbre");
            this.f6684a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = z;
            this.f = str4;
        }

        public final int a() {
            return this.f6684a;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.f;
        }

        public final String d() {
            return this.b;
        }

        public final String e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TtsTimbreItem)) {
                return false;
            }
            TtsTimbreItem ttsTimbreItem = (TtsTimbreItem) obj;
            return this.f6684a == ttsTimbreItem.f6684a && Intrinsics.areEqual((Object) this.b, (Object) ttsTimbreItem.b) && Intrinsics.areEqual((Object) this.c, (Object) ttsTimbreItem.c) && Intrinsics.areEqual((Object) this.d, (Object) ttsTimbreItem.d) && this.e == ttsTimbreItem.e && Intrinsics.areEqual((Object) this.f, (Object) ttsTimbreItem.f);
        }

        public final boolean f() {
            return this.e;
        }

        public final void g(boolean z) {
            this.e = z;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.f6684a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
        }

        public String toString() {
            int i = this.f6684a;
            String str = this.b;
            String str2 = this.c;
            String str3 = this.d;
            boolean z = this.e;
            String str4 = this.f;
            return "TtsTimbreItem(src=" + i + ", title=" + str + ", subTitle=" + str2 + ", tts=" + str3 + ", isPlaying=" + z + ", timbre=" + str4 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$TtsTimbreItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class TtsTimbreItemDecoration extends RecyclerView.ItemDecoration {
        public TtsTimbreItemDecoration() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildPosition(view) > 0) {
                rect.top = DimensExtKt.b(12);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/upuphone/xr/sapp/databinding/ItemTtsTimbreBinding;", "bind", "<init>", "(Lcom/upuphone/xr/sapp/contract/AssistantTtsTimbreSelector;Lcom/upuphone/xr/sapp/databinding/ItemTtsTimbreBinding;)V", "a", "Lcom/upuphone/xr/sapp/databinding/ItemTtsTimbreBinding;", "()Lcom/upuphone/xr/sapp/databinding/ItemTtsTimbreBinding;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class VH extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final ItemTtsTimbreBinding f6686a;
        public final /* synthetic */ AssistantTtsTimbreSelector b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VH(AssistantTtsTimbreSelector assistantTtsTimbreSelector, ItemTtsTimbreBinding itemTtsTimbreBinding) {
            super(itemTtsTimbreBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemTtsTimbreBinding, "bind");
            this.b = assistantTtsTimbreSelector;
            this.f6686a = itemTtsTimbreBinding;
        }

        public final ItemTtsTimbreBinding a() {
            return this.f6686a;
        }
    }

    public AssistantTtsTimbreSelector(Activity activity) {
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.f6679a = activity2;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        String string = activity2.getString(R.string.timbre_use_in);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.d = string;
        String string2 = activity2.getString(R.string.timbre_use_not);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.e = string2;
        int i = R.drawable.tts_timbre00;
        String string3 = activity2.getString(R.string.timbre_zxns);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = activity2.getString(R.string.timbre_category_normal);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new TtsTimbreItem(i, string3, string4, "让我们一起探索未来新世界！", false, "BV700_streaming"));
        int i2 = R.drawable.tts_timbre01;
        String string5 = activity2.getString(R.string.timbre_csyj);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = activity2.getString(R.string.timbre_category_nature);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new TtsTimbreItem(i2, string5, string6, "我们一起发现生活中的美好，好吗？", false, "female-yujie"));
        int i3 = R.drawable.tts_timbre02;
        String string7 = activity2.getString(R.string.timbre_tmns);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = activity2.getString(R.string.timbre_category_nature);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new TtsTimbreItem(i3, string7, string8, "很高兴见到你，愿你今天充满阳光和甜蜜！", false, "female-tianmei"));
        int i4 = R.drawable.tts_timbre03;
        String string9 = activity2.getString(R.string.timbre_kamt);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        String string10 = activity2.getString(R.string.timbre_category_nature);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        arrayList.add(new TtsTimbreItem(i4, string9, string10, "一起去玩耍吧！每一处都有新奇等着我们呢！", false, "cute_boy"));
        int i5 = R.drawable.tts_timbre04;
        String string11 = activity2.getString(R.string.timbre_qnns);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        String string12 = activity2.getString(R.string.timbre_category_nature);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        arrayList.add(new TtsTimbreItem(i5, string11, string12, "跟我来，开启智慧生活的新旅程。", false, "male-qn-qingse"));
        this.c = new TtsTimbreAdapter(this, arrayList);
    }

    public final AlertDialog f() {
        return (AlertDialog) this.f.getValue();
    }

    public final void g(TtsTimbreItem ttsTimbreItem) {
        Intrinsics.checkNotNullParameter(ttsTimbreItem, "ttsTimbreItem");
        TtsAbility ttsAbility = (TtsAbility) AbilityManager.b.b(TtsAbility.class);
        if (ttsAbility != null) {
            ttsAbility.stopSpeak();
        }
        if (ttsTimbreItem.f()) {
            ttsTimbreItem.g(false);
            this.c.notifyDataSetChanged();
            return;
        }
        ttsTimbreItem.g(true);
        this.c.notifyDataSetChanged();
        TtsData ttsData = new TtsData();
        ttsData.setText(ttsTimbreItem.e());
        ttsData.setTimbre(ttsTimbreItem.c());
        PlayTask playTask = new PlayTask(this, ttsTimbreItem);
        if (ttsAbility != null) {
            ttsAbility.startSpeak(ttsData, playTask);
        }
    }

    public final void h() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new AssistantTtsTimbreSelector$showSelector$1(this, (Continuation<? super AssistantTtsTimbreSelector$showSelector$1>) null), 3, (Object) null);
        if (!f().isShowing()) {
            i();
            f().show();
        }
    }

    public final void i() {
        this.g = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new AssistantTtsTimbreSelector$startObserving$1(this, (Continuation<? super AssistantTtsTimbreSelector$startObserving$1>) null), 3, (Object) null);
    }
}
