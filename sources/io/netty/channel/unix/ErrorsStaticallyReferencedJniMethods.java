package io.netty.channel.unix;

final class ErrorsStaticallyReferencedJniMethods {
    private ErrorsStaticallyReferencedJniMethods() {
    }

    public static native int errnoEAGAIN();

    public static native int errnoEBADF();

    public static native int errnoECONNRESET();

    public static native int errnoEINPROGRESS();

    public static native int errnoENOENT();

    public static native int errnoENOTCONN();

    public static native int errnoEPIPE();

    public static native int errnoEWOULDBLOCK();

    public static native int errorEALREADY();

    public static native int errorECONNREFUSED();

    public static native int errorEISCONN();

    public static native int errorENETUNREACH();

    public static native String strError(int i);
}
