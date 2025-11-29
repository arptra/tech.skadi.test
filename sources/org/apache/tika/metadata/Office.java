package org.apache.tika.metadata;

public interface Office {

    /* renamed from: a  reason: collision with root package name */
    public static final Property f7110a = Property.b(Property.B("meta:keyword"), new Property[]{DublinCore.o});
    public static final Property b = Property.A("meta:initial-author");
    public static final Property c = Property.A("meta:last-author");
    public static final Property d = Property.B("meta:author");
    public static final Property e = Property.u("meta:creation-date");
    public static final Property f = Property.u("meta:save-date");
    public static final Property g = Property.u("meta:print-date");
    public static final Property h = Property.w("meta:slide-count");
    public static final Property i = Property.w("meta:page-count");
    public static final Property j = Property.w("meta:paragraph-count");
    public static final Property k = Property.w("meta:line-count");
    public static final Property l = Property.w("meta:word-count");
    public static final Property m = Property.w("meta:character-count");
    public static final Property n = Property.w("meta:character-count-with-spaces");
    public static final Property o = Property.w("meta:table-count");
    public static final Property p = Property.w("meta:image-count");
    public static final Property q = Property.w("meta:object-count");
    public static final Property r = Property.t("meta:mapi-message-class", "APPOINTMENT", "CONTACT", "NOTE", "STICKY_NOTE", "POST", "TASK", "UNKNOWN", "UNSPECIFIED");
    public static final Property s = Property.A("meta:mapi-sent-by-server-type");
    public static final Property t = Property.A("meta:mapi-from-representing-name");
    public static final Property u = Property.A("meta:mapi-from-representing-email");
    public static final Property v = Property.u("meta:mapi-msg-client-submit-time");
    public static final Property w = Property.A("msoffice:progID");
}
