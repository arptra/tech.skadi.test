package com.upuphone.ar.transcribe.phone.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.honey.account.w4.a;
import com.honey.account.w4.b;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0018\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*BÍ\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00128\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017RG\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bRG\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "", "data", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "todo", "", "disableEdit", "deleteTodo", "isDoneTodo", "Lkotlin/Function0;", "feedBack", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "", "z0", "(Ljava/util/List;I)I", "H0", "()Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "D", "Lkotlin/jvm/functions/Function2;", "F0", "()Lkotlin/jvm/functions/Function2;", "E", "E0", "F", "I0", "G", "Lkotlin/jvm/functions/Function0;", "G0", "()Lkotlin/jvm/functions/Function0;", "H", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "updatingTodo", "I", "AiReminderItemProvider", "Companion", "TodoItemProvider", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AiTodoAdapter extends BaseProviderMultiAdapter<AiTodoEntity> {
    public static final Companion I = new Companion((DefaultConstructorMarker) null);
    public final Function2 D;
    public final Function2 E;
    public final Function2 F;
    public final Function0 G;
    public AiTodoEntity H;

    @SourceDebugExtension({"SMAP\nAiTodoAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiTodoAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$AiReminderItemProvider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,177:1\n262#2,2:178\n262#2,2:180\n262#2,2:182\n262#2,2:184\n*S KotlinDebug\n*F\n+ 1 AiTodoAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$AiReminderItemProvider\n*L\n163#1:178,2\n164#1:180,2\n166#1:182,2\n167#1:184,2\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$AiReminderItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "<init>", "(Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "u", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class AiReminderItemProvider extends BaseItemProvider<AiTodoEntity> {
        public AiReminderItemProvider() {
        }

        public static final void v(AiTodoAdapter aiTodoAdapter, View view) {
            Intrinsics.checkNotNullParameter(aiTodoAdapter, "this$0");
            aiTodoAdapter.G0().invoke();
        }

        public int g() {
            return 1;
        }

        public int h() {
            return R.layout.transcribe_item_to_do_reminder;
        }

        /* renamed from: u */
        public void a(BaseViewHolder baseViewHolder, AiTodoEntity aiTodoEntity) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(aiTodoEntity, "item");
            baseViewHolder.setText(R.id.tv_ai_reminder, R.string.tl_intel_extn_content_reminder);
            View view = baseViewHolder.getView(R.id.iv_feedback);
            View view2 = baseViewHolder.getView(R.id.tv_feedback);
            Integer reported = aiTodoEntity.getReported();
            if (reported != null && reported.intValue() == 1) {
                view.setVisibility(8);
                view2.setVisibility(0);
            } else {
                view.setVisibility(0);
                view2.setVisibility(8);
                view.setOnClickListener(new a(AiTodoAdapter.this));
            }
            baseViewHolder.setGone(R.id.feedback_iv_tv, !TranscribeConstants.f6027a.m());
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$Companion;", "", "()V", "ITEM_AI_REMINDER", "", "ITEM_TODO", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nAiTodoAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiTodoAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$TodoItemProvider\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,177:1\n65#2,16:178\n93#2,3:194\n*S KotlinDebug\n*F\n+ 1 AiTodoAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$TodoItemProvider\n*L\n121#1:178,16\n121#1:194,3\n*E\n"})
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$TodoItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "<init>", "(Lcom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "w", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;)V", "", "e", "J", "lastDeleteTime", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TodoItemProvider extends BaseItemProvider<AiTodoEntity> {
        public long e;

        public TodoItemProvider() {
        }

        public static final void x(AiTodoAdapter aiTodoAdapter, int i, AiTodoEntity aiTodoEntity, CheckBox checkBox, View view) {
            Intrinsics.checkNotNullParameter(aiTodoAdapter, "this$0");
            Intrinsics.checkNotNullParameter(aiTodoEntity, "$item");
            Intrinsics.checkNotNullParameter(checkBox, "$cbTodo");
            Function2 I0 = aiTodoAdapter.I0();
            Integer valueOf = Integer.valueOf(i);
            aiTodoEntity.setIsDone(checkBox.isChecked());
            Unit unit = Unit.INSTANCE;
            I0.invoke(valueOf, aiTodoEntity);
        }

        public int g() {
            return 0;
        }

        public int h() {
            return R.layout.transcribe_todo_item;
        }

        /* renamed from: w */
        public void a(BaseViewHolder baseViewHolder, AiTodoEntity aiTodoEntity) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(aiTodoEntity, "item");
            int Q = AiTodoAdapter.this.Q(aiTodoEntity);
            baseViewHolder.setGone(R.id.tv_add_schedule, aiTodoEntity.isIsDone());
            if (aiTodoEntity.isAddedSchedule()) {
                baseViewHolder.setTextColor(R.id.tv_add_schedule, f().getColor(R.color.color_intel_extn_todo_add_schedule_done));
                baseViewHolder.setText(R.id.tv_add_schedule, R.string.tl_added);
                baseViewHolder.setEnabled(R.id.tv_add_schedule, false);
            } else {
                baseViewHolder.setTextColor(R.id.tv_add_schedule, f().getColor(R.color.color_intel_extn_todo_add_schedule));
                baseViewHolder.setText(R.id.tv_add_schedule, R.string.tl_add_schedule);
                baseViewHolder.setEnabled(R.id.tv_add_schedule, true);
            }
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_todo_title);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.et_todo_content);
            textView.setText(aiTodoEntity.getTitle());
            clipboardEditText.setText(aiTodoEntity.getContent());
            CheckBox checkBox = (CheckBox) baseViewHolder.getView(R.id.cb_todo);
            checkBox.setClickable(false);
            checkBox.setChecked(aiTodoEntity.isIsDone());
            textView.setSelected(aiTodoEntity.isIsDone());
            clipboardEditText.setSelected(aiTodoEntity.isIsDone());
            checkBox.setOnClickListener(new b(AiTodoAdapter.this, Q, aiTodoEntity, checkBox));
            clipboardEditText.setEnableClickEdit(!aiTodoEntity.isIsDone());
            clipboardEditText.h(new AiTodoAdapter$TodoItemProvider$convert$2(clipboardEditText, aiTodoEntity, AiTodoAdapter.this, Q));
            clipboardEditText.addTextChangedListener(new AiTodoAdapter$TodoItemProvider$convert$$inlined$addTextChangedListener$default$1(AiTodoAdapter.this, aiTodoEntity, this));
            clipboardEditText.setOnFocusChangeListener(new AiTodoAdapter$TodoItemProvider$convert$4(clipboardEditText, AiTodoAdapter.this, Q, aiTodoEntity));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoAdapter(List list, Function2 function2, Function2 function22, Function2 function23, Function0 function0) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(function2, "disableEdit");
        Intrinsics.checkNotNullParameter(function22, "deleteTodo");
        Intrinsics.checkNotNullParameter(function23, "isDoneTodo");
        Intrinsics.checkNotNullParameter(function0, "feedBack");
        this.D = function2;
        this.E = function22;
        this.F = function23;
        this.G = function0;
        v0(new TodoItemProvider());
        v0(new AiReminderItemProvider());
        o(R.id.tv_add_schedule);
    }

    public final Function2 E0() {
        return this.E;
    }

    public final Function2 F0() {
        return this.D;
    }

    public final Function0 G0() {
        return this.G;
    }

    public final AiTodoEntity H0() {
        return this.H;
    }

    public final Function2 I0() {
        return this.F;
    }

    public int z0(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        int itemType = ((AiTodoEntity) list.get(i)).getItemType();
        return (itemType == 0 || itemType != 1) ? 0 : 1;
    }
}
