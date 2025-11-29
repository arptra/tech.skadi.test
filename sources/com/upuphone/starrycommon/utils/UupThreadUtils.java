package com.upuphone.starrycommon.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class UupThreadUtils {

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$1  reason: invalid class name */
    class AnonymousClass1 implements BlockingOperation {
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$1CaughtException  reason: invalid class name */
    class AnonymousClass1CaughtException {

        /* renamed from: a  reason: collision with root package name */
        public Exception f6503a;
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$1Result  reason: invalid class name */
    class AnonymousClass1Result {

        /* renamed from: a  reason: collision with root package name */
        public Object f6504a;
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$2  reason: invalid class name */
    class AnonymousClass2 implements BlockingOperation {
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$2CaughtException  reason: invalid class name */
    class AnonymousClass2CaughtException {

        /* renamed from: a  reason: collision with root package name */
        public Exception f6505a;
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$2Result  reason: invalid class name */
    class AnonymousClass2Result {

        /* renamed from: a  reason: collision with root package name */
        public Object f6506a;
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$3  reason: invalid class name */
    class AnonymousClass3 implements BlockingOperation {
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$4  reason: invalid class name */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AnonymousClass1Result f6507a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ AnonymousClass1CaughtException c;
        public final /* synthetic */ CountDownLatch d;

        public void run() {
            try {
                this.f6507a.f6504a = this.b.call();
            } catch (Exception e) {
                this.c.f6503a = e;
            }
            this.d.countDown();
        }
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$5  reason: invalid class name */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AnonymousClass2Result f6508a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ AnonymousClass2CaughtException c;
        public final /* synthetic */ CountDownLatch d;

        public void run() {
            try {
                this.f6508a.f6506a = this.b.call();
            } catch (Exception e) {
                this.c.f6505a = e;
            }
            this.d.countDown();
        }
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$6  reason: invalid class name */
    class AnonymousClass6 implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6509a;

        /* renamed from: a */
        public Void call() {
            this.f6509a.run();
            return null;
        }
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$7  reason: invalid class name */
    class AnonymousClass7 implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6510a;

        /* renamed from: a */
        public Void call() {
            this.f6510a.run();
            return null;
        }
    }

    /* renamed from: com.upuphone.starrycommon.utils.UupThreadUtils$8  reason: invalid class name */
    class AnonymousClass8 implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6511a;

        /* renamed from: a */
        public Void call() {
            this.f6511a.run();
            return null;
        }
    }

    public interface BlockingOperation {
    }

    public static class ThreadChecker {
    }
}
