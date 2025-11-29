package com.rousetime.android_startup.sort;

import androidx.core.os.TraceCompat;
import com.rousetime.android_startup.Startup;
import com.rousetime.android_startup.execption.StartupException;
import com.rousetime.android_startup.extensions.StartupExtensionsKt;
import com.rousetime.android_startup.model.StartupSortStore;
import com.rousetime.android_startup.utils.StartupLogUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u000b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/rousetime/android_startup/sort/TopologySort;", "", "<init>", "()V", "", "Lcom/rousetime/android_startup/Startup;", "startupList", "Lcom/rousetime/android_startup/model/StartupSortStore;", "b", "(Ljava/util/List;)Lcom/rousetime/android_startup/model/StartupSortStore;", "result", "", "a", "(Ljava/util/List;)V", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class TopologySort {

    /* renamed from: a  reason: collision with root package name */
    public static final TopologySort f9834a = new TopologySort();

    public final void a(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("TopologySort result: ");
        sb.append(StringUtils.LF);
        sb.append("|================================================================");
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Startup startup = (Startup) next;
            sb.append(StringUtils.LF);
            sb.append("|         order          |    [" + i2 + "] ");
            sb.append(StringUtils.LF);
            sb.append("|----------------------------------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|        Startup         |    " + startup.getClass().getSimpleName());
            sb.append(StringUtils.LF);
            sb.append("|----------------------------------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|   Dependencies size    |    " + startup.k());
            sb.append(StringUtils.LF);
            sb.append("|----------------------------------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("| callCreateOnMainThread |    " + startup.g());
            sb.append(StringUtils.LF);
            sb.append("|----------------------------------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|    waitOnMainThread    |    " + startup.h());
            sb.append(StringUtils.LF);
            sb.append("|================================================================");
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        StartupLogUtils.b.b(new TopologySort$printResult$1(sb2));
    }

    public final StartupSortStore b(List list) {
        List dependencies;
        TraceCompat.a(TopologySort.class.getSimpleName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayDeque arrayDeque = new ArrayDeque();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Startup startup = (Startup) it.next();
            String a2 = StartupExtensionsKt.a(startup.getClass());
            if (!hashMap.containsKey(a2)) {
                hashMap.put(a2, startup);
                hashMap3.put(a2, Integer.valueOf(startup.k()));
                List f = startup.f();
                if ((f == null || f.isEmpty()) && ((dependencies = startup.dependencies()) == null || dependencies.isEmpty())) {
                    arrayDeque.offer(a2);
                } else {
                    List f2 = startup.f();
                    if (f2 == null || f2.isEmpty()) {
                        List<Class> dependencies2 = startup.dependencies();
                        if (dependencies2 != null) {
                            for (Class a3 : dependencies2) {
                                String a4 = StartupExtensionsKt.a(a3);
                                if (hashMap2.get(a4) == null) {
                                    hashMap2.put(a4, new ArrayList());
                                }
                                List list2 = (List) hashMap2.get(a4);
                                if (list2 != null) {
                                    list2.add(a2);
                                }
                            }
                        }
                    } else {
                        List<String> f3 = startup.f();
                        if (f3 != null) {
                            for (String b : f3) {
                                String b2 = StartupExtensionsKt.b(b);
                                if (hashMap2.get(b2) == null) {
                                    hashMap2.put(b2, new ArrayList());
                                }
                                List list3 = (List) hashMap2.get(b2);
                                if (list3 != null) {
                                    list3.add(a2);
                                }
                            }
                        }
                    }
                }
            } else {
                throw new StartupException(startup + " multiple add.");
            }
        }
        while (!arrayDeque.isEmpty()) {
            String str = (String) arrayDeque.poll();
            if (str != null) {
                Startup startup2 = (Startup) hashMap.get(str);
                if (startup2 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(startup2, "androidStartup");
                    arrayList3.add(startup2);
                    if (startup2.g()) {
                        arrayList.add(startup2);
                    } else {
                        arrayList2.add(startup2);
                    }
                }
                List<String> list4 = (List) hashMap2.get(str);
                if (list4 != null) {
                    for (String str2 : list4) {
                        Integer num = (Integer) hashMap3.get(str2);
                        hashMap3.put(str2, Integer.valueOf(num != null ? num.intValue() - 1 : 0));
                        Integer num2 = (Integer) hashMap3.get(str2);
                        if (num2 != null && num2.intValue() == 0) {
                            arrayDeque.offer(str2);
                        }
                    }
                }
            }
        }
        if (arrayList.size() + arrayList2.size() == list.size()) {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList);
            a(arrayList3);
            TraceCompat.b();
            return new StartupSortStore(arrayList4, hashMap, hashMap2);
        }
        throw new StartupException("lack of dependencies or have circle dependencies.");
    }
}
