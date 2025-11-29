package com.xjsd.ai.assistant.stks.dto;

import com.meizu.common.util.LunarCalendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HotWord {
    private String extra;
    private String func;
    private String id;
    private Object value;

    public static boolean isNumeric(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HotWord hotWord = (HotWord) obj;
        return this.id.equals(hotWord.id) && this.func.equals(hotWord.func);
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFunc() {
        return this.func;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getListValue() {
        Object obj = this.value;
        return obj instanceof List ? (List) obj : obj instanceof String ? Collections.singletonList((String) obj) : Collections.emptyList();
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id + this.func});
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFunc(String str) {
        this.func = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return "HotWord{id='" + this.id + '\'' + ", func='" + this.func + '\'' + ", value=" + this.value + ", extra='" + this.extra + '\'' + '}';
    }

    public boolean valueEquals(String str) {
        Object obj = this.value;
        if (obj instanceof List) {
            if (isNumeric(str)) {
                for (String contains : (List) this.value) {
                    if (contains.contains(LunarCalendar.DATE_SEPARATOR)) {
                        return true;
                    }
                }
            }
            return ((List) this.value).contains(str);
        } else if (!((String) obj).contains(LunarCalendar.DATE_SEPARATOR) || !isNumeric(str)) {
            return getListValue().contains(str);
        } else {
            return true;
        }
    }
}
