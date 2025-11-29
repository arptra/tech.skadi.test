package javax.xml.stream;

class FactoryFinder {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3697a = false;

    public static abstract class ClassLoaderFinder {
    }

    public static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
    }

    static {
        try {
            f3697a = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }
}
