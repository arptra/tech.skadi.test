package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set set;
        int i = variablesToRemoveIndex;
        Object indexedVariable = internalThreadLocalMap.indexedVariable(i);
        if (indexedVariable == InternalThreadLocalMap.UNSET || indexedVariable == null) {
            set = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i, set);
        } else {
            set = (Set) indexedVariable;
        }
        set.add(fastThreadLocal);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V v;
        try {
            v = initialValue();
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            v = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, v);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return v;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet != null) {
            try {
                Object indexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
                if (!(indexedVariable == null || indexedVariable == InternalThreadLocalMap.UNSET)) {
                    for (FastThreadLocal remove : (FastThreadLocal[]) ((Set) indexedVariable).toArray(new FastThreadLocal[0])) {
                        remove.remove(ifSet);
                    }
                }
            } finally {
                InternalThreadLocalMap.remove();
            }
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object indexedVariable = internalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (indexedVariable != InternalThreadLocalMap.UNSET && indexedVariable != null) {
            ((Set) indexedVariable).remove(fastThreadLocal);
        }
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V indexedVariable = internalThreadLocalMap.indexedVariable(this.index);
        if (indexedVariable != InternalThreadLocalMap.UNSET) {
            return indexedVariable;
        }
        return initialize(internalThreadLocalMap);
    }

    public final V getIfExists() {
        V indexedVariable;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null || (indexedVariable = ifSet.indexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return null;
        }
        return indexedVariable;
    }

    public V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    public void onRemoval(V v) throws Exception {
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v) {
        if (v != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v);
        } else {
            remove();
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    public final void remove(InternalThreadLocalMap internalThreadLocalMap) {
        if (internalThreadLocalMap != null) {
            Object removeIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index);
            removeFromVariablesToRemove(internalThreadLocalMap, this);
            if (removeIndexedVariable != InternalThreadLocalMap.UNSET) {
                try {
                    onRemoval(removeIndexedVariable);
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
            }
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V indexedVariable = internalThreadLocalMap.indexedVariable(this.index);
        if (indexedVariable != InternalThreadLocalMap.UNSET) {
            return indexedVariable;
        }
        return initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v) {
        if (v != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v);
        } else {
            remove(internalThreadLocalMap);
        }
    }
}
