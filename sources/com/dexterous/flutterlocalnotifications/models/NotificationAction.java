package com.dexterous.flutterlocalnotifications.models;

import android.graphics.Color;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Keep
public class NotificationAction implements Serializable {
    private static final String ALLOW_GENERATED_REPLIES = "allowGeneratedReplies";
    private static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CONTEXTUAL = "contextual";
    private static final String ICON = "icon";
    private static final String ICON_SOURCE = "iconBitmapSource";
    private static final String ID = "id";
    private static final String INPUTS = "inputs";
    private static final String SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String TITLE = "title";
    private static final String TITLE_COLOR_ALPHA = "titleColorAlpha";
    private static final String TITLE_COLOR_BLUE = "titleColorBlue";
    private static final String TITLE_COLOR_GREEN = "titleColorGreen";
    private static final String TITLE_COLOR_RED = "titleColorRed";
    @Nullable
    public final List<NotificationActionInput> actionInputs = new ArrayList();
    @Nullable
    public final Boolean allowGeneratedReplies;
    @Nullable
    public final Boolean cancelNotification;
    @Nullable
    public final Boolean contextual;
    @Nullable
    public final String icon;
    @Nullable
    public final IconSource iconSource;
    public final String id;
    @Nullable
    public final Boolean showsUserInterface;
    public final String title;
    @Nullable
    public final Integer titleColor;

    public static class NotificationActionInput implements Serializable {
        public final Boolean allowFreeFormInput;
        @Nullable
        public final List<String> allowedMimeTypes;
        @Nullable
        public final List<String> choices;
        public final String label;

        public NotificationActionInput(@Nullable List<String> list, Boolean bool, String str, @Nullable List<String> list2) {
            this.choices = list;
            this.allowFreeFormInput = bool;
            this.label = str;
            this.allowedMimeTypes = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            NotificationActionInput notificationActionInput = (NotificationActionInput) obj;
            List<String> list = this.choices;
            if (list == null ? notificationActionInput.choices != null : !list.equals(notificationActionInput.choices)) {
                return false;
            }
            Boolean bool = this.allowFreeFormInput;
            if (bool == null ? notificationActionInput.allowFreeFormInput != null : !bool.equals(notificationActionInput.allowFreeFormInput)) {
                return false;
            }
            String str = this.label;
            if (str == null ? notificationActionInput.label != null : !str.equals(notificationActionInput.label)) {
                return false;
            }
            List<String> list2 = this.allowedMimeTypes;
            return list2 != null ? list2.equals(notificationActionInput.allowedMimeTypes) : notificationActionInput.allowedMimeTypes == null;
        }

        public int hashCode() {
            List<String> list = this.choices;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            Boolean bool = this.allowFreeFormInput;
            int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            String str = this.label;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list2 = this.allowedMimeTypes;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode3 + i;
        }
    }

    public NotificationAction(Map<String, Object> map) {
        List<Map> list;
        this.id = (String) map.get("id");
        this.cancelNotification = (Boolean) map.get(CANCEL_NOTIFICATION);
        this.title = (String) map.get("title");
        Integer num = (Integer) map.get(TITLE_COLOR_ALPHA);
        Integer num2 = (Integer) map.get(TITLE_COLOR_RED);
        Integer num3 = (Integer) map.get(TITLE_COLOR_GREEN);
        Integer num4 = (Integer) map.get(TITLE_COLOR_BLUE);
        if (num == null || num2 == null || num3 == null || num4 == null) {
            this.titleColor = null;
        } else {
            this.titleColor = Integer.valueOf(Color.argb(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue()));
        }
        this.icon = (String) map.get(ICON);
        this.contextual = (Boolean) map.get(CONTEXTUAL);
        this.showsUserInterface = (Boolean) map.get(SHOWS_USER_INTERFACE);
        this.allowGeneratedReplies = (Boolean) map.get(ALLOW_GENERATED_REPLIES);
        Integer num5 = (Integer) map.get(ICON_SOURCE);
        if (num5 != null) {
            this.iconSource = IconSource.values()[num5.intValue()];
        } else {
            this.iconSource = null;
        }
        if (map.get(INPUTS) != null && (list = (List) map.get(INPUTS)) != null) {
            for (Map map2 : list) {
                Class<String> cls = String.class;
                this.actionInputs.add(new NotificationActionInput(castList(cls, (Collection) map2.get("choices")), (Boolean) map2.get("allowFreeFormInput"), (String) map2.get("label"), castList(cls, (Collection) map2.get("allowedMimeTypes"))));
            }
        }
    }

    public static <T> List<T> castList(Class<? extends T> cls, @Nullable Collection<?> collection) {
        if (collection == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object cast : collection) {
            try {
                arrayList.add(cls.cast(cast));
            } catch (ClassCastException unused) {
            }
        }
        return arrayList;
    }
}
