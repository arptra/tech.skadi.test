package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;

public class BasicMarkerFactory implements IMarkerFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap f3460a = new ConcurrentHashMap();
}
