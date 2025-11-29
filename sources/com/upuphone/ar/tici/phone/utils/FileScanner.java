package com.upuphone.ar.tici.phone.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/FileScanner;", "", "<init>", "()V", "", "", "pathList", "suffixList", "Ljava/io/File;", "d", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "directoryPath", "", "c", "(Ljava/lang/String;Ljava/util/List;)V", "", "a", "Ljava/util/List;", "filterFiles", "b", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFileScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileScanner.kt\ncom/upuphone/ar/tici/phone/utils/FileScanner\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,50:1\n1747#2,3:51\n13309#3,2:54\n*S KotlinDebug\n*F\n+ 1 FileScanner.kt\ncom/upuphone/ar/tici/phone/utils/FileScanner\n*L\n41#1:51,3\n45#1:54,2\n*E\n"})
public final class FileScanner {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f5990a = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/FileScanner$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void c(String str, List list) {
        File[] listFiles;
        File file = new File(str);
        if (!file.isHidden()) {
            if (file.isFile()) {
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (StringsKt.endsWith$default(name, (String) it.next(), false, 2, (Object) null)) {
                            if (file.length() > 0) {
                                this.f5990a.add(file);
                                return;
                            }
                            return;
                        }
                    }
                }
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File absolutePath : listFiles) {
                    String absolutePath2 = absolutePath.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                    c(absolutePath2, list);
                }
            }
        }
    }

    public final Object d(List list, List list2, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new FileScanner$scanTxtFiles$4(list, this, list2, (Continuation<? super FileScanner$scanTxtFiles$4>) null), continuation);
    }
}
