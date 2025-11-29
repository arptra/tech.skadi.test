package org.apache.tika.metadata;

public interface TikaCoreProperties {
    public static final Property A = DublinCore.d;
    public static final Property B = DublinCore.e;
    public static final Property C = DublinCore.f;
    public static final Property D = Office.c;
    public static final Property E = XMP.d;
    public static final Property F = DublinCore.j;
    public static final Property G = DublinCore.k;
    public static final Property H = DublinCore.l;
    public static final Property I = DublinCore.m;
    public static final Property J = DublinCore.n;
    public static final Property K = DublinCore.q;
    public static final Property L = DublinCore.p;
    public static final Property M = DublinCore.i;
    public static final Property N = DublinCore.o;
    public static final Property O = DublinCore.g;
    public static final Property P = DublinCore.c;
    public static final Property Q = Office.g;
    public static final Property R = XMP.g;
    public static final Property S = Geographic.d0;
    public static final Property T = Geographic.e0;
    public static final Property U = Geographic.f0;
    public static final Property V = XMP.j;
    public static final Property W = Property.w("imagereader:NumImages");
    public static final Property X = OfficeOpenXMLExtended.l;
    public static final Property Y = Property.t("embeddedResourceType", EmbeddedResourceType.ATTACHMENT.toString(), EmbeddedResourceType.INLINE.toString(), EmbeddedResourceType.METADATA.toString(), EmbeddedResourceType.MACRO.toString(), EmbeddedResourceType.THUMBNAIL.toString(), EmbeddedResourceType.RENDERING.toString());
    public static final Property Z = Property.s("hasSignature");

    /* renamed from: a  reason: collision with root package name */
    public static final Property f7113a = Property.w("X-TIKA:embedded_depth");
    public static final Property a0 = Property.B("signature:name");
    public static final Property b = Property.A("X-TIKA:embedded_resource_path");
    public static final Property b0 = Property.v("signature:date");
    public static final Property c = Property.A("X-TIKA:embedded_id_path");
    public static final Property c0 = Property.B("signature:location");
    public static final Property d = Property.w("X-TIKA:embedded_id");
    public static final Property d0 = Property.B("signature:reason");
    public static final Property e = Property.A("X-TIKA:parse_time_millis");
    public static final Property e0 = Property.B("signature:filter");
    public static final Property f = Property.A("X-TIKA:content_handler");
    public static final Property f0 = Property.B("signature:contact-info");
    public static final Property g = Property.A("X-TIKA:content");
    public static final Property g0 = Property.s("X-TIKA:encrypted");
    public static final Property h = Property.A("X-TIKA:EXCEPTION:container_exception");
    public static final Property h0 = Property.h("X-TIKA:versionCount");
    public static final Property i = Property.B("X-TIKA:EXCEPTION:embedded_exception");
    public static final Property i0 = Property.h("X-TIKA:versionNumber");
    public static final Property j = Property.B("X-TIKA:EXCEPTION:embedded_warning");
    public static final Property k = Property.s("X-TIKA:EXCEPTION:write_limit_reached");
    public static final Property l = Property.B("X-TIKA:EXCEPTION:warn");
    public static final Property m = Property.s("X-TIKA:WARN:truncated_metadata");
    public static final Property n = Property.B("X-TIKA:EXCEPTION:embedded_stream_exception");
    public static final Property o = Property.B("X-TIKA:Parsed-By");
    public static final Property p = Property.B("X-TIKA:Parsed-By-Full-Set");
    public static final Property q = Property.l("X-TIKA:detected_language");
    public static final Property r = Property.l("X-TIKA:detected_language_confidence");
    public static final Property s = Property.j("X-TIKA:detected_language_confidence_raw");
    public static final Property t = Property.B("X-TIKA:origResourceName");
    public static final Property u = Property.A("X-TIKA:sourcePath");
    public static final Property v = Property.A("Content-Type-Hint");
    public static final Property w = Property.A("Content-Type-Override");
    public static final Property x = Property.A("Content-Type-Parser-Override");
    public static final Property y = DublinCore.f7107a;
    public static final Property z = DublinCore.b;

    public enum EmbeddedResourceType {
        INLINE,
        ATTACHMENT,
        MACRO,
        METADATA,
        FONT,
        THUMBNAIL,
        RENDERING,
        VERSION
    }
}
