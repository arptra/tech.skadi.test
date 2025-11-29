package rxhttp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rxhttp.wrapper.CallFactory;
import rxhttp.wrapper.ITag;
import rxhttp.wrapper.callback.FileOutputStreamFactory;
import rxhttp.wrapper.callback.OutputStreamFactory;
import rxhttp.wrapper.coroutines.CallAwait;
import rxhttp.wrapper.coroutines.CallFlow;
import rxhttp.wrapper.parse.Parser;
import rxhttp.wrapper.parse.StreamParser;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\b\u0010\t\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0007*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lrxhttp/wrapper/CallFactory;", "Lrxhttp/wrapper/parse/Parser;", "parser", "Lrxhttp/wrapper/coroutines/CallAwait;", "a", "(Lrxhttp/wrapper/CallFactory;Lrxhttp/wrapper/parse/Parser;)Lrxhttp/wrapper/coroutines/CallAwait;", "Lrxhttp/wrapper/coroutines/CallFlow;", "d", "(Lrxhttp/wrapper/CallFactory;Lrxhttp/wrapper/parse/Parser;)Lrxhttp/wrapper/coroutines/CallFlow;", "", "destPath", "", "append", "b", "(Lrxhttp/wrapper/CallFactory;Ljava/lang/String;Z)Lrxhttp/wrapper/coroutines/CallFlow;", "Lrxhttp/wrapper/callback/OutputStreamFactory;", "osFactory", "c", "(Lrxhttp/wrapper/CallFactory;Lrxhttp/wrapper/callback/OutputStreamFactory;Z)Lrxhttp/wrapper/coroutines/CallFlow;", "rxhttp"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCallFactoryExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallFactoryExt.kt\nrxhttp/CallFactoryExtKt\n+ 2 Utils.kt\nrxhttp/wrapper/utils/Utils\n*L\n1#1,84:1\n25#1:86\n25#1:88\n55#1:91\n55#1:93\n85#2:85\n85#2:87\n85#2:89\n85#2:90\n85#2:92\n85#2:94\n*S KotlinDebug\n*F\n+ 1 CallFactoryExt.kt\nrxhttp/CallFactoryExtKt\n*L\n27#1:86\n29#1:88\n57#1:91\n59#1:93\n25#1:85\n27#1:87\n29#1:89\n55#1:90\n57#1:92\n59#1:94\n*E\n"})
public final class CallFactoryExtKt {
    public static final CallAwait a(CallFactory callFactory, Parser parser) {
        Intrinsics.checkNotNullParameter(callFactory, "<this>");
        Intrinsics.checkNotNullParameter(parser, "parser");
        return new CallAwait(callFactory, parser);
    }

    public static final CallFlow b(CallFactory callFactory, String str, boolean z) {
        Intrinsics.checkNotNullParameter(callFactory, "<this>");
        Intrinsics.checkNotNullParameter(str, "destPath");
        return c(callFactory, new FileOutputStreamFactory(str), z);
    }

    public static final CallFlow c(CallFactory callFactory, OutputStreamFactory outputStreamFactory, boolean z) {
        Intrinsics.checkNotNullParameter(callFactory, "<this>");
        Intrinsics.checkNotNullParameter(outputStreamFactory, "osFactory");
        if (z && (callFactory instanceof ITag)) {
            ((ITag) callFactory).b(OutputStreamFactory.class, outputStreamFactory);
        }
        return d(callFactory, new StreamParser(outputStreamFactory));
    }

    public static final CallFlow d(CallFactory callFactory, Parser parser) {
        Intrinsics.checkNotNullParameter(callFactory, "<this>");
        Intrinsics.checkNotNullParameter(parser, "parser");
        return new CallFlow(callFactory, parser);
    }
}
