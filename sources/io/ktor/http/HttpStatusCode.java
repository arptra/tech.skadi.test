package io.ktor.http;

import com.google.mlkit.common.MlKitException;
import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;
import com.upuphone.xr.sapp.common.PermissionType;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import okhttp3.internal.http.StatusLine;

@SourceDebugExtension({"SMAP\nHttpStatusCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpStatusCode.kt\nio/ktor/http/HttpStatusCode\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1194#2,2:195\n1222#2,4:197\n*S KotlinDebug\n*F\n+ 1 HttpStatusCode.kt\nio/ktor/http/HttpStatusCode\n*L\n112#1:195,2\n112#1:197,4\n*E\n"})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\t¨\u0006\u001b"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "", "value", "", "description", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "f0", "(Lio/ktor/http/HttpStatusCode;)I", "a", "I", "h0", "b", "Ljava/lang/String;", "g0", "c", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class HttpStatusCode implements Comparable<HttpStatusCode> {
    public static final HttpStatusCode A = new HttpStatusCode(403, "Forbidden");
    public static final HttpStatusCode B = new HttpStatusCode(404, "Not Found");
    public static final HttpStatusCode C = new HttpStatusCode(405, "Method Not Allowed");
    public static final HttpStatusCode D = new HttpStatusCode(406, "Not Acceptable");
    public static final HttpStatusCode E = new HttpStatusCode(407, "Proxy Authentication Required");
    public static final HttpStatusCode F = new HttpStatusCode(408, "Request Timeout");
    public static final HttpStatusCode G = new HttpStatusCode(409, "Conflict");
    public static final HttpStatusCode H = new HttpStatusCode(410, "Gone");
    public static final HttpStatusCode I = new HttpStatusCode(411, "Length Required");
    public static final HttpStatusCode J = new HttpStatusCode(412, "Precondition Failed");
    public static final HttpStatusCode K = new HttpStatusCode(413, "Payload Too Large");
    public static final HttpStatusCode L = new HttpStatusCode(414, "Request-URI Too Long");
    public static final HttpStatusCode M = new HttpStatusCode(415, "Unsupported Media Type");
    public static final HttpStatusCode N = new HttpStatusCode(416, "Requested Range Not Satisfiable");
    public static final HttpStatusCode O = new HttpStatusCode(417, "Expectation Failed");
    public static final HttpStatusCode P = new HttpStatusCode(422, "Unprocessable Entity");
    public static final HttpStatusCode Q = new HttpStatusCode(423, "Locked");
    public static final HttpStatusCode R = new HttpStatusCode(424, "Failed Dependency");
    public static final HttpStatusCode S = new HttpStatusCode(425, "Too Early");
    public static final HttpStatusCode T = new HttpStatusCode(426, "Upgrade Required");
    public static final HttpStatusCode U = new HttpStatusCode(429, "Too Many Requests");
    public static final HttpStatusCode V = new HttpStatusCode(431, "Request Header Fields Too Large");
    public static final HttpStatusCode W = new HttpStatusCode(500, "Internal Server Error");
    public static final HttpStatusCode X = new HttpStatusCode(OpenRemoteStarryNetAppCode.CODE_NO_DEVICE, "Not Implemented");
    public static final HttpStatusCode Y = new HttpStatusCode(OpenRemoteStarryNetAppCode.CODE_STARRY_SDK_NOT_AVAILABLE, "Bad Gateway");
    public static final HttpStatusCode Z = new HttpStatusCode(OpenRemoteStarryNetAppCode.CODE_PULL_MAIN_APP_FAIL, "Service Unavailable");
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final HttpStatusCode d = new HttpStatusCode(100, "Continue");
    public static final HttpStatusCode e = new HttpStatusCode(101, "Switching Protocols");
    public static final HttpStatusCode f = new HttpStatusCode(102, "Processing");
    public static final HttpStatusCode g = new HttpStatusCode(200, PermissionType.OK);
    public static final HttpStatusCode g0 = new HttpStatusCode(OpenRemoteStarryNetAppCode.CODE_SEND_MESSAGE_FAIL, "Gateway Timeout");
    public static final HttpStatusCode h = new HttpStatusCode(201, "Created");
    public static final HttpStatusCode h0 = new HttpStatusCode(505, "HTTP Version Not Supported");
    public static final HttpStatusCode i = new HttpStatusCode(202, "Accepted");
    public static final HttpStatusCode i0 = new HttpStatusCode(506, "Variant Also Negotiates");
    public static final HttpStatusCode j = new HttpStatusCode(203, "Non-Authoritative Information");
    public static final HttpStatusCode j0 = new HttpStatusCode(507, "Insufficient Storage");
    public static final HttpStatusCode k = new HttpStatusCode(204, "No Content");
    public static final List k0;
    public static final HttpStatusCode l = new HttpStatusCode(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, "Reset Content");
    public static final Map l0;
    public static final HttpStatusCode m = new HttpStatusCode(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, "Partial Content");
    public static final HttpStatusCode n = new HttpStatusCode(MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, "Multi-Status");
    public static final HttpStatusCode o = new HttpStatusCode(300, "Multiple Choices");
    public static final HttpStatusCode p = new HttpStatusCode(MlKitException.LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE, "Moved Permanently");
    public static final HttpStatusCode q = new HttpStatusCode(302, "Found");
    public static final HttpStatusCode r = new HttpStatusCode(303, "See Other");
    public static final HttpStatusCode s = new HttpStatusCode(304, "Not Modified");
    public static final HttpStatusCode t = new HttpStatusCode(305, "Use Proxy");
    public static final HttpStatusCode u = new HttpStatusCode(306, "Switch Proxy");
    public static final HttpStatusCode v = new HttpStatusCode(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect");
    public static final HttpStatusCode w = new HttpStatusCode(StatusLine.HTTP_PERM_REDIRECT, "Permanent Redirect");
    public static final HttpStatusCode x = new HttpStatusCode(CmdCode.CODE_WAKEUP_RECORDING, "Bad Request");
    public static final HttpStatusCode y = new HttpStatusCode(CmdCode.CODE_WAKEUP_AUDIO_STATE, "Unauthorized");
    public static final HttpStatusCode z = new HttpStatusCode(CmdCode.CODE_WAKEUP_AUDIO, "Payment Required");

    /* renamed from: a  reason: collision with root package name */
    public final int f8969a;
    public final String b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bl\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\bR\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\bR\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\bR\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\bR\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\bR\u0017\u0010-\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\bR\u0017\u0010/\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\bR\u0017\u00101\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\bR\u0017\u00103\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\bR\u0017\u00105\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u0010\bR\u0017\u00107\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\bR\u0017\u00109\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\u0006\u001a\u0004\b:\u0010\bR\u0017\u0010;\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\bR\u0017\u0010=\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\u0006\u001a\u0004\b>\u0010\bR\u0017\u0010?\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b?\u0010\u0006\u001a\u0004\b@\u0010\bR\u0017\u0010A\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010\bR\u0017\u0010C\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bC\u0010\u0006\u001a\u0004\bD\u0010\bR\u0017\u0010E\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bE\u0010\u0006\u001a\u0004\bF\u0010\bR\u0017\u0010G\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bG\u0010\u0006\u001a\u0004\bH\u0010\bR\u0017\u0010I\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\u0006\u001a\u0004\bJ\u0010\bR\u0017\u0010K\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bK\u0010\u0006\u001a\u0004\bL\u0010\bR\u0017\u0010M\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bM\u0010\u0006\u001a\u0004\bN\u0010\bR\u0017\u0010O\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bO\u0010\u0006\u001a\u0004\bP\u0010\bR\u0017\u0010Q\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\bR\u0017\u0010S\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bS\u0010\u0006\u001a\u0004\bT\u0010\bR\u0017\u0010U\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bU\u0010\u0006\u001a\u0004\bV\u0010\bR\u0017\u0010W\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bW\u0010\u0006\u001a\u0004\bX\u0010\bR\u0017\u0010Y\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bY\u0010\u0006\u001a\u0004\bZ\u0010\bR\u0017\u0010[\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b[\u0010\u0006\u001a\u0004\b\\\u0010\bR\u0017\u0010]\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b]\u0010\u0006\u001a\u0004\b^\u0010\bR\u0017\u0010_\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b_\u0010\u0006\u001a\u0004\b`\u0010\bR\u0017\u0010a\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\ba\u0010\u0006\u001a\u0004\bb\u0010\bR\u0017\u0010c\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bc\u0010\u0006\u001a\u0004\bd\u0010\bR\u0017\u0010e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\be\u0010\u0006\u001a\u0004\bf\u0010\bR\u0017\u0010g\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bg\u0010\u0006\u001a\u0004\bh\u0010\bR\u0017\u0010i\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bi\u0010\u0006\u001a\u0004\bj\u0010\bR\u0017\u0010k\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bk\u0010\u0006\u001a\u0004\bl\u0010\bR\u0017\u0010m\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bm\u0010\u0006\u001a\u0004\bn\u0010\bR\u0017\u0010o\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bo\u0010\u0006\u001a\u0004\bp\u0010\bR \u0010s\u001a\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u00040q8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006u"}, d2 = {"Lio/ktor/http/HttpStatusCode$Companion;", "", "<init>", "()V", "Lio/ktor/http/HttpStatusCode;", "Continue", "Lio/ktor/http/HttpStatusCode;", "e", "()Lio/ktor/http/HttpStatusCode;", "SwitchingProtocols", "Q", "Processing", "G", "OK", "A", "Created", "f", "Accepted", "a", "NonAuthoritativeInformation", "v", "NoContent", "u", "ResetContent", "M", "PartialContent", "B", "MultiStatus", "s", "MultipleChoices", "t", "MovedPermanently", "r", "Found", "j", "SeeOther", "N", "NotModified", "z", "UseProxy", "Y", "SwitchProxy", "P", "TemporaryRedirect", "R", "PermanentRedirect", "E", "BadRequest", "c", "Unauthorized", "U", "PaymentRequired", "D", "Forbidden", "i", "NotFound", "x", "MethodNotAllowed", "q", "NotAcceptable", "w", "ProxyAuthenticationRequired", "H", "RequestTimeout", "J", "Conflict", "d", "Gone", "l", "LengthRequired", "o", "PreconditionFailed", "F", "PayloadTooLarge", "C", "RequestURITooLong", "K", "UnsupportedMediaType", "W", "RequestedRangeNotSatisfiable", "L", "ExpectationFailed", "g", "UnprocessableEntity", "V", "Locked", "p", "FailedDependency", "h", "TooEarly", "S", "UpgradeRequired", "X", "TooManyRequests", "T", "RequestHeaderFieldTooLarge", "I", "InternalServerError", "n", "NotImplemented", "y", "BadGateway", "b", "ServiceUnavailable", "O", "GatewayTimeout", "k", "VersionNotSupported", "a0", "VariantAlsoNegotiates", "Z", "InsufficientStorage", "m", "", "", "statusCodesMap", "Ljava/util/Map;", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HttpStatusCode A() {
            return HttpStatusCode.g;
        }

        public final HttpStatusCode B() {
            return HttpStatusCode.m;
        }

        public final HttpStatusCode C() {
            return HttpStatusCode.K;
        }

        public final HttpStatusCode D() {
            return HttpStatusCode.z;
        }

        public final HttpStatusCode E() {
            return HttpStatusCode.w;
        }

        public final HttpStatusCode F() {
            return HttpStatusCode.J;
        }

        public final HttpStatusCode G() {
            return HttpStatusCode.f;
        }

        public final HttpStatusCode H() {
            return HttpStatusCode.E;
        }

        public final HttpStatusCode I() {
            return HttpStatusCode.V;
        }

        public final HttpStatusCode J() {
            return HttpStatusCode.F;
        }

        public final HttpStatusCode K() {
            return HttpStatusCode.L;
        }

        public final HttpStatusCode L() {
            return HttpStatusCode.N;
        }

        public final HttpStatusCode M() {
            return HttpStatusCode.l;
        }

        public final HttpStatusCode N() {
            return HttpStatusCode.r;
        }

        public final HttpStatusCode O() {
            return HttpStatusCode.Z;
        }

        public final HttpStatusCode P() {
            return HttpStatusCode.u;
        }

        public final HttpStatusCode Q() {
            return HttpStatusCode.e;
        }

        public final HttpStatusCode R() {
            return HttpStatusCode.v;
        }

        public final HttpStatusCode S() {
            return HttpStatusCode.S;
        }

        public final HttpStatusCode T() {
            return HttpStatusCode.U;
        }

        public final HttpStatusCode U() {
            return HttpStatusCode.y;
        }

        public final HttpStatusCode V() {
            return HttpStatusCode.P;
        }

        public final HttpStatusCode W() {
            return HttpStatusCode.M;
        }

        public final HttpStatusCode X() {
            return HttpStatusCode.T;
        }

        public final HttpStatusCode Y() {
            return HttpStatusCode.t;
        }

        public final HttpStatusCode Z() {
            return HttpStatusCode.i0;
        }

        public final HttpStatusCode a() {
            return HttpStatusCode.i;
        }

        public final HttpStatusCode a0() {
            return HttpStatusCode.h0;
        }

        public final HttpStatusCode b() {
            return HttpStatusCode.Y;
        }

        public final HttpStatusCode c() {
            return HttpStatusCode.x;
        }

        public final HttpStatusCode d() {
            return HttpStatusCode.G;
        }

        public final HttpStatusCode e() {
            return HttpStatusCode.d;
        }

        public final HttpStatusCode f() {
            return HttpStatusCode.h;
        }

        public final HttpStatusCode g() {
            return HttpStatusCode.O;
        }

        public final HttpStatusCode h() {
            return HttpStatusCode.R;
        }

        public final HttpStatusCode i() {
            return HttpStatusCode.A;
        }

        public final HttpStatusCode j() {
            return HttpStatusCode.q;
        }

        public final HttpStatusCode k() {
            return HttpStatusCode.g0;
        }

        public final HttpStatusCode l() {
            return HttpStatusCode.H;
        }

        public final HttpStatusCode m() {
            return HttpStatusCode.j0;
        }

        public final HttpStatusCode n() {
            return HttpStatusCode.W;
        }

        public final HttpStatusCode o() {
            return HttpStatusCode.I;
        }

        public final HttpStatusCode p() {
            return HttpStatusCode.Q;
        }

        public final HttpStatusCode q() {
            return HttpStatusCode.C;
        }

        public final HttpStatusCode r() {
            return HttpStatusCode.p;
        }

        public final HttpStatusCode s() {
            return HttpStatusCode.n;
        }

        public final HttpStatusCode t() {
            return HttpStatusCode.o;
        }

        public final HttpStatusCode u() {
            return HttpStatusCode.k;
        }

        public final HttpStatusCode v() {
            return HttpStatusCode.j;
        }

        public final HttpStatusCode w() {
            return HttpStatusCode.D;
        }

        public final HttpStatusCode x() {
            return HttpStatusCode.B;
        }

        public final HttpStatusCode y() {
            return HttpStatusCode.X;
        }

        public final HttpStatusCode z() {
            return HttpStatusCode.s;
        }

        public Companion() {
        }
    }

    static {
        List a2 = HttpStatusCodeKt.a();
        k0 = a2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(a2, 10)), 16));
        for (Object next : a2) {
            linkedHashMap.put(Integer.valueOf(((HttpStatusCode) next).f8969a), next);
        }
        l0 = linkedHashMap;
    }

    public HttpStatusCode(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.f8969a = i2;
        this.b = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpStatusCode) && ((HttpStatusCode) obj).f8969a == this.f8969a;
    }

    /* renamed from: f0 */
    public int compareTo(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "other");
        return this.f8969a - httpStatusCode.f8969a;
    }

    public final String g0() {
        return this.b;
    }

    public final int h0() {
        return this.f8969a;
    }

    public int hashCode() {
        return Integer.hashCode(this.f8969a);
    }

    public String toString() {
        return this.f8969a + ' ' + this.b;
    }
}
