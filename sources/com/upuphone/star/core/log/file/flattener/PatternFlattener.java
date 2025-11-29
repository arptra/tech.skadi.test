package com.upuphone.star.core.log.file.flattener;

import androidx.exifinterface.media.ExifInterface;
import com.geetest.sdk.t;
import com.upuphone.star.core.log.LogLevel;
import com.upuphone.star.core.log.file.LogItem;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFlattener implements Flattener {
    public static final Pattern c = Pattern.compile("\\{([^{}]*)\\}");

    /* renamed from: a  reason: collision with root package name */
    public String f6452a;
    public List b;

    public static class DateFiller extends ParameterFiller {
        public String c;
        public ThreadLocal d;

        public DateFiller(String str, String str2, String str3) {
            super(str, str2);
            AnonymousClass1 r2 = new ThreadLocal<SimpleDateFormat>() {
                /* renamed from: a */
                public SimpleDateFormat initialValue() {
                    return new SimpleDateFormat(DateFiller.this.c, Locale.US);
                }
            };
            this.d = r2;
            this.c = str3;
            try {
                ((SimpleDateFormat) r2.get()).format(new Date());
            } catch (Exception e) {
                throw new IllegalArgumentException("Bad date pattern: " + str3, e);
            }
        }

        public String a(String str, LogItem logItem) {
            return str.replace(this.f6454a, ((SimpleDateFormat) this.d.get()).format(new Date(logItem.f6449a)));
        }
    }

    public static class LevelFiller extends ParameterFiller {
        public boolean c;

        public LevelFiller(String str, String str2, boolean z) {
            super(str, str2);
            this.c = z;
        }

        public String a(String str, LogItem logItem) {
            return this.c ? str.replace(this.f6454a, LogLevel.a(logItem.b)) : str.replace(this.f6454a, LogLevel.b(logItem.b));
        }
    }

    public static class MessageFiller extends ParameterFiller {
        public MessageFiller(String str, String str2) {
            super(str, str2);
        }

        public String a(String str, LogItem logItem) {
            return str.replace(this.f6454a, logItem.d);
        }
    }

    public static abstract class ParameterFiller {

        /* renamed from: a  reason: collision with root package name */
        public String f6454a;
        public String b;

        public ParameterFiller(String str, String str2) {
            this.f6454a = str;
            this.b = str2;
        }

        public abstract String a(String str, LogItem logItem);
    }

    public static class PidFiller extends ParameterFiller {
        public PidFiller(String str, String str2) {
            super(str, str2);
        }

        public String a(String str, LogItem logItem) {
            String str2 = this.f6454a;
            return str.replace(str2, "Pid-" + logItem.e);
        }
    }

    public static class TagFiller extends ParameterFiller {
        public TagFiller(String str, String str2) {
            super(str, str2);
        }

        public String a(String str, LogItem logItem) {
            return str.replace(this.f6454a, logItem.c);
        }
    }

    public static class ThreadFiller extends ParameterFiller {
        public ThreadFiller(String str, String str2) {
            super(str, str2);
        }

        public String a(String str, LogItem logItem) {
            String str2 = this.f6454a;
            return str.replace(str2, "" + logItem.f);
        }
    }

    public PatternFlattener(String str) {
        if (str != null) {
            this.f6452a = str;
            List f = f(g(str));
            this.b = f;
            if (f.size() == 0) {
                throw new IllegalArgumentException("No recognizable parameter found in the pattern " + str);
            }
            return;
        }
        throw new NullPointerException("Pattern should not be null");
    }

    public static DateFiller b(String str, String str2) {
        if (str2.startsWith("d ") && str2.length() > 2) {
            return new DateFiller(str, str2, str2.substring(2));
        }
        if (str2.equals("d")) {
            return new DateFiller(str, str2, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }

    public static LevelFiller c(String str, String str2) {
        if (str2.equals("l")) {
            return new LevelFiller(str, str2, false);
        }
        if (str2.equals("L")) {
            return new LevelFiller(str, str2, true);
        }
        return null;
    }

    public static MessageFiller d(String str, String str2) {
        if (str2.equals(ProtocolVersions.PROTOCOL_KEY_MAX_MTU_SIZE)) {
            return new MessageFiller(str, str2);
        }
        return null;
    }

    public static ParameterFiller e(String str) {
        String str2 = "{" + str + "}";
        String trim = str.trim();
        DateFiller b2 = b(str2, trim);
        if (b2 != null) {
            return b2;
        }
        LevelFiller c2 = c(str2, trim);
        if (c2 != null) {
            return c2;
        }
        TagFiller i = i(str2, trim);
        if (i != null) {
            return i;
        }
        PidFiller h = h(str2, trim);
        if (h != null) {
            return h;
        }
        ThreadFiller j = j(str2, trim);
        if (j != null) {
            return j;
        }
        MessageFiller d = d(str2, trim);
        if (d != null) {
            return d;
        }
        return null;
    }

    public static List f(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ParameterFiller e = e((String) it.next());
            if (e != null) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static List g(String str) {
        ArrayList arrayList = new ArrayList(4);
        Matcher matcher = c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    public static PidFiller h(String str, String str2) {
        if (str2.equals("P")) {
            return new PidFiller(str, str2);
        }
        return null;
    }

    public static TagFiller i(String str, String str2) {
        if (str2.equals(t.f)) {
            return new TagFiller(str, str2);
        }
        return null;
    }

    public static ThreadFiller j(String str, String str2) {
        if (str2.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
            return new ThreadFiller(str, str2);
        }
        return null;
    }

    public CharSequence a(LogItem logItem) {
        String str = this.f6452a;
        for (ParameterFiller a2 : this.b) {
            str = a2.a(str, logItem);
        }
        return str;
    }
}
