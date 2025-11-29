package org.aspectj.runtime.internal.cflowstack;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class ThreadCounterImpl11 implements ThreadCounter {
    private static final int COLLECT_AT = 20000;
    private static final int MIN_COLLECT_AT = 100;
    private Counter cached_counter;
    private Thread cached_thread;
    private int change_count = 0;
    private Hashtable<Thread, Counter> counters = new Hashtable<>();

    public static class Counter {
        protected int value = 0;
    }

    private synchronized Counter getThreadCounter() {
        try {
            if (Thread.currentThread() != this.cached_thread) {
                Thread currentThread = Thread.currentThread();
                this.cached_thread = currentThread;
                Counter counter = this.counters.get(currentThread);
                this.cached_counter = counter;
                if (counter == null) {
                    Counter counter2 = new Counter();
                    this.cached_counter = counter2;
                    this.counters.put(this.cached_thread, counter2);
                }
                this.change_count++;
                if (this.change_count > Math.max(100, 20000 / Math.max(1, this.counters.size()))) {
                    ArrayList<Thread> arrayList = new ArrayList<>();
                    Enumeration<Thread> keys = this.counters.keys();
                    while (keys.hasMoreElements()) {
                        Thread nextElement = keys.nextElement();
                        if (!nextElement.isAlive()) {
                            arrayList.add(nextElement);
                        }
                    }
                    for (Thread remove : arrayList) {
                        this.counters.remove(remove);
                    }
                    this.change_count = 0;
                }
            }
        } finally {
        }
        return this.cached_counter;
    }

    public void dec() {
        Counter threadCounter = getThreadCounter();
        threadCounter.value--;
    }

    public void inc() {
        getThreadCounter().value++;
    }

    public boolean isNotZero() {
        return getThreadCounter().value != 0;
    }

    public void removeThreadCounter() {
    }
}
