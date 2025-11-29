package org.apache.tika.utils;

import com.honey.account.oc.b;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;

public class ParserUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Property f3341a = Property.A("X-TIKA:EXCEPTION:embedded_parser");

    public static Metadata a(Metadata metadata) {
        Metadata metadata2 = new Metadata();
        for (String str : metadata.names()) {
            if (!metadata.isMultiValued(str)) {
                metadata2.set(str, metadata.get(str));
            } else {
                for (String add : metadata.getValues(str)) {
                    metadata2.add(str, add);
                }
            }
        }
        return metadata2;
    }

    public static InputStream b(InputStream inputStream, TemporaryResources temporaryResources, Metadata metadata) {
        if (inputStream instanceof RereadableInputStream) {
            return inputStream;
        }
        TikaInputStream a2 = TikaInputStream.a(inputStream);
        if (a2 == null) {
            a2 = TikaInputStream.g(inputStream, temporaryResources, metadata);
        }
        if (a2.v() != null) {
            return a2;
        }
        a2.u();
        a2.mark(-1);
        return a2;
    }

    public static String c(Parser parser) {
        return parser instanceof ParserDecorator ? ((ParserDecorator) parser).getWrappedParser().getClass().getName() : parser.getClass().getName();
    }

    public static void d(String str, Metadata metadata) {
        Property property = TikaCoreProperties.o;
        String[] values = metadata.getValues(property);
        if (values == null || values.length == 0) {
            metadata.add(property, str);
            return;
        }
        Stream stream = Arrays.stream(values);
        Objects.requireNonNull(str);
        if (stream.noneMatch(new b(str))) {
            metadata.add(property, str);
        }
    }

    public static void e(Parser parser, Metadata metadata) {
        d(c(parser), metadata);
    }

    public static void f(Parser parser, Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.i, ExceptionUtils.b(th));
        metadata.add(f3341a, c(parser));
    }

    public static InputStream g(InputStream inputStream, TemporaryResources temporaryResources) {
        if (inputStream instanceof RereadableInputStream) {
            ((RereadableInputStream) inputStream).b();
            return inputStream;
        }
        TikaInputStream tikaInputStream = (TikaInputStream) inputStream;
        if (tikaInputStream.v() != null) {
            return TikaInputStream.n(tikaInputStream.v(), temporaryResources);
        }
        tikaInputStream.reset();
        tikaInputStream.mark(-1);
        return tikaInputStream;
    }
}
