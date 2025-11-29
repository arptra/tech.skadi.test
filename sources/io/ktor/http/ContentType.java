package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.eclipse.jetty.util.URIUtil;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\t\u001f !\"#$%&'B1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001e\u0010\u001d¨\u0006("}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "", "contentType", "contentSubtype", "existingContent", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "name", "value", "h", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/ContentType;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "g", "(Ljava/lang/String;Ljava/lang/String;)Z", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "e", "Application", "Audio", "Companion", "Font", "Image", "Message", "MultiPart", "Text", "Video", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nContentTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentTypes.kt\nio/ktor/http/ContentType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,318:1\n1#2:319\n1747#3,3:320\n1747#3,3:323\n*S KotlinDebug\n*F\n+ 1 ContentTypes.kt\nio/ktor/http/ContentType\n*L\n44#1:320,3\n72#1:323,3\n*E\n"})
public final class ContentType extends HeaderValueWithParameters {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final ContentType g = new ContentType("*", "*", (List) null, 4, (DefaultConstructorMarker) null);
    public final String d;
    public final String e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bB\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010$\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\bR\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\bR\u0017\u0010*\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\bR\u0017\u0010-\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\bR\u0017\u00100\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\bR\u0017\u00103\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\bR\u0017\u00106\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b4\u0010\u0006\u001a\u0004\b5\u0010\bR\u0017\u00109\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\bR\u0017\u0010<\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\bR\u0017\u0010?\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\u0006\u001a\u0004\b>\u0010\bR\u0017\u0010B\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b@\u0010\u0006\u001a\u0004\bA\u0010\bR\u0017\u0010E\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bC\u0010\u0006\u001a\u0004\bD\u0010\b¨\u0006F"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getAtom", "Atom", "d", "getCbor", "Cbor", "e", "getJson", "Json", "f", "getHalJson", "HalJson", "g", "getJavaScript", "JavaScript", "h", "a", "OctetStream", "i", "getRss", "Rss", "j", "getXml", "Xml", "k", "getXml_Dtd", "Xml_Dtd", "l", "getZip", "Zip", "m", "getGZip", "GZip", "n", "getFormUrlEncoded", "FormUrlEncoded", "o", "getPdf", "Pdf", "p", "getXlsx", "Xlsx", "q", "getDocx", "Docx", "r", "getPptx", "Pptx", "s", "getProtoBuf", "ProtoBuf", "t", "getWasm", "Wasm", "u", "getProblemJson", "ProblemJson", "v", "getProblemXml", "ProblemXml", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Application {

        /* renamed from: a  reason: collision with root package name */
        public static final Application f8945a = new Application();
        public static final ContentType b = new ContentType(VuiModelType.APPLICATION, "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType(VuiModelType.APPLICATION, "atom+xml", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType(VuiModelType.APPLICATION, "cbor", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType(VuiModelType.APPLICATION, "json", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType(VuiModelType.APPLICATION, "hal+json", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType g = new ContentType(VuiModelType.APPLICATION, "javascript", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType h = new ContentType(VuiModelType.APPLICATION, "octet-stream", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType i = new ContentType(VuiModelType.APPLICATION, "rss+xml", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType j = new ContentType(VuiModelType.APPLICATION, "xml", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType k = new ContentType(VuiModelType.APPLICATION, "xml-dtd", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType l = new ContentType(VuiModelType.APPLICATION, "zip", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType m = new ContentType(VuiModelType.APPLICATION, "gzip", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType n = new ContentType(VuiModelType.APPLICATION, "x-www-form-urlencoded", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType o = new ContentType(VuiModelType.APPLICATION, "pdf", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType p = new ContentType(VuiModelType.APPLICATION, "vnd.openxmlformats-officedocument.spreadsheetml.sheet", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType q = new ContentType(VuiModelType.APPLICATION, "vnd.openxmlformats-officedocument.wordprocessingml.document", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType r = new ContentType(VuiModelType.APPLICATION, "vnd.openxmlformats-officedocument.presentationml.presentation", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType s = new ContentType(VuiModelType.APPLICATION, "protobuf", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType t = new ContentType(VuiModelType.APPLICATION, "wasm", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType u = new ContentType(VuiModelType.APPLICATION, "problem+json", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType v = new ContentType(VuiModelType.APPLICATION, "problem+xml", (List) null, 4, (DefaultConstructorMarker) null);

        public final ContentType a() {
            return h;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getMP4", "MP4", "d", "getMPEG", "MPEG", "e", "getOGG", "OGG", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Audio {

        /* renamed from: a  reason: collision with root package name */
        public static final Audio f8946a = new Audio();
        public static final ContentType b = new ContentType("audio", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("audio", "mp4", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("audio", "mpeg", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("audio", "ogg", (List) null, 4, (DefaultConstructorMarker) null);
    }

    @SourceDebugExtension({"SMAP\nContentTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentTypes.kt\nio/ktor/http/ContentType$Companion\n+ 2 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParameters$Companion\n*L\n1#1,318:1\n63#2,2:319\n*S KotlinDebug\n*F\n+ 1 ContentTypes.kt\nio/ktor/http/ContentType$Companion\n*L\n117#1:319,2\n*E\n"})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "<init>", "()V", "", "value", "Lio/ktor/http/ContentType;", "b", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "a", "()Lio/ktor/http/ContentType;", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContentType a() {
            return ContentType.g;
        }

        public final ContentType b(String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            if (StringsKt.isBlank(str)) {
                return a();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.c;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.b(str));
            String c = headerValue.c();
            List a2 = headerValue.a();
            int indexOf$default = StringsKt.indexOf$default((CharSequence) c, '/', 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                String substring = c.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String obj = StringsKt.trim((CharSequence) substring).toString();
                if (obj.length() != 0) {
                    String substring2 = c.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    String obj2 = StringsKt.trim((CharSequence) substring2).toString();
                    if (StringsKt.contains$default((CharSequence) obj, ' ', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) obj2, ' ', false, 2, (Object) null)) {
                        throw new BadContentTypeFormatException(str);
                    } else if (obj2.length() != 0 && !StringsKt.contains$default((CharSequence) obj2, '/', false, 2, (Object) null)) {
                        return new ContentType(obj, obj2, a2);
                    } else {
                        throw new BadContentTypeFormatException(str);
                    }
                } else {
                    throw new BadContentTypeFormatException(str);
                }
            } else if (Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) c).toString(), (Object) "*")) {
                return ContentType.f.a();
            } else {
                throw new BadContentTypeFormatException(str);
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lio/ktor/http/ContentType$Font;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getCollection", "Collection", "d", "getOtf", "Otf", "e", "getSfnt", "Sfnt", "f", "getTtf", "Ttf", "g", "getWoff", "Woff", "h", "getWoff2", "Woff2", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Font {

        /* renamed from: a  reason: collision with root package name */
        public static final Font f8947a = new Font();
        public static final ContentType b = new ContentType("font", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("font", "collection", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("font", "otf", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("font", "sfnt", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType("font", "ttf", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType g = new ContentType("font", "woff", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType h = new ContentType("font", "woff2", (List) null, 4, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getGIF", "GIF", "d", "getJPEG", "JPEG", "e", "getPNG", "PNG", "f", "getSVG", "SVG", "g", "getXIcon", "XIcon", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Image {

        /* renamed from: a  reason: collision with root package name */
        public static final Image f8948a = new Image();
        public static final ContentType b = new ContentType("image", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("image", "gif", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("image", "jpeg", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("image", "png", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType("image", "svg+xml", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType g = new ContentType("image", "x-icon", (List) null, 4, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getHttp", "Http", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Message {

        /* renamed from: a  reason: collision with root package name */
        public static final Message f8949a = new Message();
        public static final ContentType b = new ContentType("message", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("message", URIUtil.HTTP, (List) null, 4, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\b¨\u0006\u001f"}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getMixed", "Mixed", "d", "getAlternative", "Alternative", "e", "getRelated", "Related", "f", "getFormData", "FormData", "g", "getSigned", "Signed", "h", "getEncrypted", "Encrypted", "i", "getByteRanges", "ByteRanges", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class MultiPart {

        /* renamed from: a  reason: collision with root package name */
        public static final MultiPart f8950a = new MultiPart();
        public static final ContentType b = new ContentType("multipart", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("multipart", "mixed", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("multipart", "alternative", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("multipart", "related", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType("multipart", "form-data", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType g = new ContentType("multipart", "signed", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType h = new ContentType("multipart", "encrypted", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType i = new ContentType("multipart", "byteranges", (List) null, 4, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b¨\u0006\""}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "a", "Plain", "d", "getCSS", "CSS", "e", "getCSV", "CSV", "f", "getHtml", "Html", "g", "getJavaScript", "JavaScript", "h", "getVCard", "VCard", "i", "getXml", "Xml", "j", "getEventStream", "EventStream", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Text {

        /* renamed from: a  reason: collision with root package name */
        public static final Text f8951a = new Text();
        public static final ContentType b = new ContentType("text", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("text", "plain", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("text", "css", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("text", "csv", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType("text", "html", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType g = new ContentType("text", "javascript", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType h = new ContentType("text", "vcard", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType i = new ContentType("text", "xml", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType j = new ContentType("text", "event-stream", (List) null, 4, (DefaultConstructorMarker) null);

        public final ContentType a() {
            return c;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "b", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Any", "c", "getMPEG", "MPEG", "d", "getMP4", "MP4", "e", "getOGG", "OGG", "f", "getQuickTime", "QuickTime", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Video {

        /* renamed from: a  reason: collision with root package name */
        public static final Video f8952a = new Video();
        public static final ContentType b = new ContentType("video", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType c = new ContentType("video", "mpeg", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType d = new ContentType("video", "mp4", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType e = new ContentType("video", "ogg", (List) null, 4, (DefaultConstructorMarker) null);
        public static final ContentType f = new ContentType("video", "quicktime", (List) null, 4, (DefaultConstructorMarker) null);
    }

    public ContentType(String str, String str2, String str3, List list) {
        super(str3, list);
        this.d = str;
        this.e = str2;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentType) {
            ContentType contentType = (ContentType) obj;
            return StringsKt.equals(this.d, contentType.d, true) && StringsKt.equals(this.e, contentType.e, true) && Intrinsics.areEqual((Object) b(), (Object) contentType.b());
        }
    }

    public final String f() {
        return this.d;
    }

    public final boolean g(String str, String str2) {
        int size = b().size();
        if (size == 0) {
            return false;
        }
        if (size != 1) {
            List<HeaderValueParam> b = b();
            if ((b instanceof Collection) && b.isEmpty()) {
                return false;
            }
            for (HeaderValueParam headerValueParam : b) {
                if (!StringsKt.equals(headerValueParam.a(), str, true) || !StringsKt.equals(headerValueParam.b(), str2, true)) {
                }
            }
            return false;
        }
        HeaderValueParam headerValueParam2 = (HeaderValueParam) b().get(0);
        if (!StringsKt.equals(headerValueParam2.a(), str, true) || !StringsKt.equals(headerValueParam2.b(), str2, true)) {
            return false;
        }
        return true;
    }

    public final ContentType h(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        return g(str, str2) ? this : new ContentType(this.d, this.e, a(), CollectionsKt.plus(b(), new HeaderValueParam(str, str2)));
    }

    public int hashCode() {
        String str = this.d;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.e.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return hashCode + (hashCode * 31) + lowerCase2.hashCode() + (b().hashCode() * 31);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentType(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContentType(String str, String str2, List list) {
        this(str, str2, str + '/' + str2, list);
        Intrinsics.checkNotNullParameter(str, "contentType");
        Intrinsics.checkNotNullParameter(str2, "contentSubtype");
        Intrinsics.checkNotNullParameter(list, "parameters");
    }
}
