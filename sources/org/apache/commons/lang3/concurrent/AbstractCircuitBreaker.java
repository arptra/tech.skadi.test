package org.apache.commons.lang3.concurrent;

import com.honey.account.x.c;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractCircuitBreaker<T> implements CircuitBreaker<T> {
    public static final String PROPERTY_NAME = "open";
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);

    public enum State {
        CLOSED {
            public State oppositeState() {
                return State.OPEN;
            }
        },
        OPEN {
            public State oppositeState() {
                return State.CLOSED;
            }
        };

        public abstract State oppositeState();
    }

    public void addChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void changeState(State state2) {
        if (c.a(this.state, state2.oppositeState(), state2)) {
            this.changeSupport.firePropertyChange("open", !isOpen(state2), isOpen(state2));
        }
    }

    public abstract boolean checkState();

    public void close() {
        changeState(State.CLOSED);
    }

    public abstract boolean incrementAndCheckState(T t);

    public boolean isClosed() {
        return !isOpen();
    }

    public boolean isOpen() {
        return isOpen(this.state.get());
    }

    public void open() {
        changeState(State.OPEN);
    }

    public void removeChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public static boolean isOpen(State state2) {
        return state2 == State.OPEN;
    }
}
