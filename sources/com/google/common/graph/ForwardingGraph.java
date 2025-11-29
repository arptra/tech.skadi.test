package com.google.common.graph;

import java.util.Set;

abstract class ForwardingGraph<N> extends AbstractGraph<N> {
    public Set<N> adjacentNodes(N n) {
        return delegate().adjacentNodes(n);
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public int degree(N n) {
        return delegate().degree(n);
    }

    public abstract BaseGraph<N> delegate();

    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    public int inDegree(N n) {
        return delegate().inDegree(n);
    }

    public ElementOrder<N> incidentEdgeOrder() {
        return delegate().incidentEdgeOrder();
    }

    public Set<EndpointPair<N>> incidentEdges(N n) {
        return delegate().incidentEdges(n);
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public int outDegree(N n) {
        return delegate().outDegree(n);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    public Set<N> predecessors(N n) {
        return delegate().predecessors(n);
    }

    public Set<N> successors(N n) {
        return delegate().successors(n);
    }
}
