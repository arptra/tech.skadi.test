package com.xjsd.ai.assistant.skill.call.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import androidx.core.content.ContextCompat;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjsd/ai/assistant/skill/call/util/CallLogUtil;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "a", "(Landroid/content/Context;)Ljava/util/Set;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CallLogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final CallLogUtil f8676a = new CallLogUtil();

    public static final Set a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (VoiceAssistantApi.isOversea) {
            return new HashSet();
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_CALL_LOG") != 0) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        Cursor query = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"name", "number", "date"}, (String) null, (String[]) null, "date DESC");
        if (query != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault(Locale.Category.FORMAT));
            while (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                String format = simpleDateFormat.format(new Date(query.getLong(2)));
                ILog.j("PhoneCall#CallLogUtil", "通话记录 姓名->" + string + "，电话->" + string2 + "，日期->" + format);
                treeSet.add(query.getString(1));
            }
            query.close();
        }
        return treeSet;
    }
}
