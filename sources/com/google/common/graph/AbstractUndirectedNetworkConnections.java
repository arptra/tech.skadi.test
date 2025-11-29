package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public void addInEdge(E e, N n, boolean z) {
        if (!z) {
            addOutEdge(e, n);
        }
    }

    public void addOutEdge(E e, N n) {
        Preconditions.checkState(this.incidentEdgeMap.put(e, n) == null);
    }

    public N adjacentNode(E e) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.get(e));
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    public N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    public N removeOutEdge(E e) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.remove(e));
    }

    public Set<N> successors() {
        return adjacentNodes();
    }
}
