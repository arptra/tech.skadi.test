package org.apache.tika.metadata;

public interface ExternalProcess {

    /* renamed from: a  reason: collision with root package name */
    public static final Property f7108a = Property.k("external-process:stdout");
    public static final Property b = Property.k("external-process:stderr");
    public static final Property c = Property.d("external-process:stdout-truncated");
    public static final Property d = Property.d("external-process:stderr-truncated");
    public static final Property e = Property.i("external-process:stdout-length");
    public static final Property f = Property.i("external-process:stderr-length");
    public static final Property g = Property.h("external-process:exit-value");
    public static final Property h = Property.d("external-process:timeout");
}
