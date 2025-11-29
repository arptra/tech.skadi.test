package com.upuphone.ar.translation.phone.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.honey.account.e5.a;
import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fBÃ\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u00128\b\u0002\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00128\b\u0002\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u00128\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013RG\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017RG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017RG\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "", "data", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "extnTodo", "", "disableEdit", "deleteTodo", "isDoneTodo", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "", "z0", "(Ljava/util/List;I)I", "D", "Lkotlin/jvm/functions/Function2;", "D0", "()Lkotlin/jvm/functions/Function2;", "E", "C0", "F", "E0", "G", "AiReminderItemProvider", "Companion", "TodoItemProvider", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class IntelExtnTodoAdapter extends BaseProviderMultiAdapter<IntelExtnTodo> {
    public static final Companion G = new Companion((DefaultConstructorMarker) null);
    public final Function2 D;
    public final Function2 E;
    public final Function2 F;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter$AiReminderItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class AiReminderItemProvider extends BaseItemProvider<IntelExtnTodo> {
        public AiReminderItemProvider() {
        }

        public int g() {
            return 1;
        }

        public int h() {
            return R.layout.item_intel_extn_to_do_ai_reminder;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, IntelExtnTodo intelExtnTodo) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(intelExtnTodo, "item");
            baseViewHolder.setText(R.id.tv_ai_reminder, R.string.tl_intel_extn_content_reminder);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter$Companion;", "", "()V", "ITEM_AI_REMINDER", "", "ITEM_TODO", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter$TodoItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/IntelExtnTodoAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "u", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class TodoItemProvider extends BaseItemProvider<IntelExtnTodo> {
        public TodoItemProvider() {
        }

        public static final void v(IntelExtnTodoAdapter intelExtnTodoAdapter, int i, IntelExtnTodo intelExtnTodo, CheckBox checkBox, View view) {
            Intrinsics.checkNotNullParameter(intelExtnTodoAdapter, "this$0");
            Intrinsics.checkNotNullParameter(intelExtnTodo, "$item");
            Intrinsics.checkNotNullParameter(checkBox, "$cbTodo");
            Function2 E0 = intelExtnTodoAdapter.E0();
            Integer valueOf = Integer.valueOf(i);
            Object a2 = AnyExtKt.a(intelExtnTodo, IntelExtnTodo.class);
            ((IntelExtnTodo) a2).setIsDone(checkBox.isChecked());
            Unit unit = Unit.INSTANCE;
            E0.invoke(valueOf, a2);
        }

        public int g() {
            return 0;
        }

        public int h() {
            return R.layout.item_intel_extn_to_do;
        }

        /* renamed from: u */
        public void a(BaseViewHolder baseViewHolder, IntelExtnTodo intelExtnTodo) {
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(intelExtnTodo, "item");
            int Q = IntelExtnTodoAdapter.this.Q(intelExtnTodo);
            baseViewHolder.setGone(R.id.tv_add_schedule, intelExtnTodo.isIsDone());
            if (intelExtnTodo.isAddedSchedule()) {
                baseViewHolder.setTextColor(R.id.tv_add_schedule, f().getColor(R.color.color_intel_extn_todo_add_schedule_done));
                baseViewHolder.setText(R.id.tv_add_schedule, R.string.tl_added);
            } else {
                baseViewHolder.setTextColor(R.id.tv_add_schedule, f().getColor(R.color.color_intel_extn_todo_add_schedule));
                baseViewHolder.setText(R.id.tv_add_schedule, R.string.tl_add_schedule);
            }
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_todo_title);
            ClipboardEditText clipboardEditText = (ClipboardEditText) baseViewHolder.getView(R.id.et_todo_content);
            textView.setText(intelExtnTodo.getTitle());
            clipboardEditText.setText(intelExtnTodo.getContent());
            CheckBox checkBox = (CheckBox) baseViewHolder.getView(R.id.cb_todo);
            checkBox.setChecked(intelExtnTodo.isIsDone());
            textView.setSelected(intelExtnTodo.isIsDone());
            clipboardEditText.setSelected(intelExtnTodo.isIsDone());
            checkBox.setOnClickListener(new a(IntelExtnTodoAdapter.this, Q, intelExtnTodo, checkBox));
            clipboardEditText.setEnableClickEdit(!intelExtnTodo.isIsDone());
            clipboardEditText.i(new IntelExtnTodoAdapter$TodoItemProvider$convert$2(clipboardEditText, intelExtnTodo, IntelExtnTodoAdapter.this, Q));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoAdapter(List list, Function2 function2, Function2 function22, Function2 function23) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(function2, "disableEdit");
        Intrinsics.checkNotNullParameter(function22, "deleteTodo");
        Intrinsics.checkNotNullParameter(function23, "isDoneTodo");
        this.D = function2;
        this.E = function22;
        this.F = function23;
        v0(new TodoItemProvider());
        v0(new AiReminderItemProvider());
        o(R.id.tv_add_schedule);
    }

    public final Function2 C0() {
        return this.E;
    }

    public final Function2 D0() {
        return this.D;
    }

    public final Function2 E0() {
        return this.F;
    }

    public int z0(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        int itemType = ((IntelExtnTodo) list.get(i)).getItemType();
        return (itemType == 0 || itemType != 1) ? 0 : 1;
    }
}
