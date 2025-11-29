package org.apache.tika.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.utils.ServiceLoaderUtils;

public class ServiceLoader {
    public static final Map e = new HashMap();
    public static final Pattern f = Pattern.compile("#.*");
    public static final Pattern g = Pattern.compile("\\s+");
    public static volatile ClassLoader h = null;

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f4136a;
    public final LoadErrorHandler b;
    public final InitializableProblemHandler c;
    public final boolean d;

    public static class RankedService implements Comparable<RankedService> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f4137a;
        public final int b;

        /* renamed from: b */
        public int compareTo(RankedService rankedService) {
            return rankedService.b - this.b;
        }

        public boolean d(Class cls) {
            return cls.isAssignableFrom(this.f4137a.getClass());
        }
    }

    public ServiceLoader(ClassLoader classLoader, LoadErrorHandler loadErrorHandler, InitializableProblemHandler initializableProblemHandler, boolean z) {
        this.f4136a = classLoader;
        this.b = loadErrorHandler;
        this.c = initializableProblemHandler;
        this.d = z;
    }

    public static ClassLoader c() {
        ClassLoader classLoader = h;
        if (classLoader == null) {
            classLoader = ServiceLoader.class.getClassLoader();
        }
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    public final void a(URL url, Collection collection) {
        BufferedReader bufferedReader;
        InputStream openStream = url.openStream();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(openStream, StandardCharsets.UTF_8));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String replaceAll = g.matcher(f.matcher(readLine).replaceFirst("")).replaceAll("");
                if (replaceAll.length() > 0) {
                    collection.add(replaceAll);
                }
            }
            bufferedReader.close();
            if (openStream != null) {
                openStream.close();
                return;
            }
            return;
        } catch (Throwable th) {
            if (openStream != null) {
                try {
                    openStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
        throw th;
    }

    public Enumeration b(String str) {
        try {
            return this.f4136a.getResources(str);
        } catch (IOException unused) {
            return Collections.enumeration(Collections.emptyList());
        }
    }

    public InitializableProblemHandler d() {
        return this.c;
    }

    public LoadErrorHandler e() {
        return this.b;
    }

    public ClassLoader f() {
        return this.f4136a;
    }

    public InputStream g(String str) {
        ClassLoader classLoader = this.f4136a;
        if (classLoader != null) {
            return classLoader.getResourceAsStream(str);
        }
        return null;
    }

    public Class h(Class cls, String str) {
        ClassLoader classLoader = this.f4136a;
        if (classLoader != null) {
            Class<?> cls2 = Class.forName(str, true, classLoader);
            if (cls2.isInterface()) {
                throw new ClassNotFoundException("Service class " + str + " is an interface");
            } else if (cls.isAssignableFrom(cls2)) {
                return cls2;
            } else {
                throw new ClassNotFoundException("Service class " + str + " does not implement " + cls.getName());
            }
        } else {
            throw new ClassNotFoundException("Service class " + str + " is not available");
        }
    }

    public List i(Class cls) {
        ArrayList arrayList = new ArrayList();
        if (this.f4136a != null) {
            String name = cls.getName();
            Iterator it = Collections.list(b("META-INF/services/" + name)).iterator();
            while (it.hasNext()) {
                try {
                    a((URL) it.next(), arrayList);
                } catch (IOException e2) {
                    this.b.a(name, e2);
                }
            }
        }
        return arrayList;
    }

    public boolean j() {
        return this.d;
    }

    public List k(Class cls) {
        ArrayList arrayList;
        if (!this.d) {
            return Collections.EMPTY_LIST;
        }
        Map map = e;
        synchronized (map) {
            try {
                ArrayList<RankedService> arrayList2 = new ArrayList<>(map.values());
                Collections.sort(arrayList2);
                arrayList = new ArrayList(arrayList2.size());
                for (RankedService rankedService : arrayList2) {
                    if (rankedService.d(cls)) {
                        arrayList.add(rankedService.f4137a);
                    }
                }
            } finally {
            }
        }
        return arrayList;
    }

    public List l(Class cls) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(k(cls));
        arrayList.addAll(m(cls));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Object next : arrayList) {
            if (!hashSet.contains(next.getClass().getCanonicalName())) {
                arrayList2.add(next);
                hashSet.add(next.getClass().getCanonicalName());
            }
        }
        return arrayList2;
    }

    public List m(Class cls) {
        return n(cls, Collections.EMPTY_SET);
    }

    public List n(Class cls, Collection collection) {
        ArrayList arrayList = new ArrayList();
        if (this.f4136a != null) {
            for (String str : i(cls)) {
                try {
                    Class<?> loadClass = this.f4136a.loadClass(str);
                    if (cls.isAssignableFrom(loadClass)) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((Class) it.next()).isAssignableFrom(loadClass)) {
                                    break;
                                }
                            } else {
                                Object a2 = ServiceLoaderUtils.a(loadClass, this);
                                if (a2 instanceof Initializable) {
                                    ((Initializable) a2).initialize(Collections.EMPTY_MAP);
                                    ((Initializable) a2).checkInitialization(this.c);
                                }
                                arrayList.add(a2);
                            }
                        }
                    } else {
                        throw new TikaConfigException("Class " + str + " is not of type: " + cls);
                    }
                } catch (Throwable th) {
                    this.b.a(str, th);
                }
            }
        }
        return arrayList;
    }

    public ServiceLoader(ClassLoader classLoader, LoadErrorHandler loadErrorHandler, boolean z) {
        this(classLoader, loadErrorHandler, InitializableProblemHandler.c, z);
    }

    public ServiceLoader(ClassLoader classLoader, LoadErrorHandler loadErrorHandler) {
        this(classLoader, loadErrorHandler, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ServiceLoader(java.lang.ClassLoader r2) {
        /*
            r1 = this;
            java.lang.String r0 = "org.apache.tika.service.error.warn"
            boolean r0 = java.lang.Boolean.getBoolean(r0)
            if (r0 == 0) goto L_0x000b
            org.apache.tika.config.LoadErrorHandler r0 = org.apache.tika.config.LoadErrorHandler.b
            goto L_0x000d
        L_0x000b:
            org.apache.tika.config.LoadErrorHandler r0 = org.apache.tika.config.LoadErrorHandler.f4134a
        L_0x000d:
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.config.ServiceLoader.<init>(java.lang.ClassLoader):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ServiceLoader() {
        /*
            r3 = this;
            java.lang.ClassLoader r0 = c()
            java.lang.String r1 = "org.apache.tika.service.error.warn"
            boolean r1 = java.lang.Boolean.getBoolean(r1)
            if (r1 == 0) goto L_0x000f
            org.apache.tika.config.LoadErrorHandler r1 = org.apache.tika.config.LoadErrorHandler.b
            goto L_0x0011
        L_0x000f:
            org.apache.tika.config.LoadErrorHandler r1 = org.apache.tika.config.LoadErrorHandler.f4134a
        L_0x0011:
            r2 = 1
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.config.ServiceLoader.<init>():void");
    }
}
