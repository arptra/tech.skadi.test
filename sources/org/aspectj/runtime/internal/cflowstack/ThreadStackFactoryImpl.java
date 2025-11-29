package org.aspectj.runtime.internal.cflowstack;

import java.util.Stack;

public class ThreadStackFactoryImpl implements ThreadStackFactory {

    public static class ThreadCounterImpl extends ThreadLocal<Counter> implements ThreadCounter {

        public static class Counter {
            protected int value = 0;
        }

        private ThreadCounterImpl() {
        }

        public void dec() {
            Counter threadCounter = getThreadCounter();
            threadCounter.value--;
        }

        public Counter getThreadCounter() {
            return (Counter) get();
        }

        public void inc() {
            getThreadCounter().value++;
        }

        public boolean isNotZero() {
            return getThreadCounter().value != 0;
        }

        public void removeThreadCounter() {
            remove();
        }

        public Counter initialValue() {
            return new Counter();
        }
    }

    public static class ThreadStackImpl extends ThreadLocal<Stack> implements ThreadStack {
        private ThreadStackImpl() {
        }

        public Stack getThreadStack() {
            return (Stack) get();
        }

        public void removeThreadStack() {
            remove();
        }

        public Stack initialValue() {
            return new Stack();
        }
    }

    public ThreadCounter getNewThreadCounter() {
        return new ThreadCounterImpl();
    }

    public ThreadStack getNewThreadStack() {
        return new ThreadStackImpl();
    }
}
