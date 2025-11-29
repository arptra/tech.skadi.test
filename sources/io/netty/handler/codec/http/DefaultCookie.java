package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Deprecated
public class DefaultCookie extends io.netty.handler.codec.http.cookie.DefaultCookie implements Cookie {
    private String comment;
    private String commentUrl;
    private boolean discard;
    private Set<Integer> ports;
    private Set<Integer> unmodifiablePorts;
    private int version;

    public DefaultCookie(String str, String str2) {
        super(str, str2);
        Set<Integer> emptySet = Collections.emptySet();
        this.ports = emptySet;
        this.unmodifiablePorts = emptySet;
    }

    @Deprecated
    public String comment() {
        return this.comment;
    }

    @Deprecated
    public String commentUrl() {
        return this.commentUrl;
    }

    @Deprecated
    public String getComment() {
        return comment();
    }

    @Deprecated
    public String getCommentUrl() {
        return commentUrl();
    }

    @Deprecated
    public String getDomain() {
        return domain();
    }

    @Deprecated
    public long getMaxAge() {
        return maxAge();
    }

    @Deprecated
    public String getName() {
        return name();
    }

    @Deprecated
    public String getPath() {
        return path();
    }

    @Deprecated
    public Set<Integer> getPorts() {
        return ports();
    }

    @Deprecated
    public String getValue() {
        return value();
    }

    @Deprecated
    public int getVersion() {
        return version();
    }

    @Deprecated
    public boolean isDiscard() {
        return this.discard;
    }

    @Deprecated
    public Set<Integer> ports() {
        if (this.unmodifiablePorts == null) {
            this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
        }
        return this.unmodifiablePorts;
    }

    @Deprecated
    public void setComment(String str) {
        this.comment = validateValue("comment", str);
    }

    @Deprecated
    public void setCommentUrl(String str) {
        this.commentUrl = validateValue("commentUrl", str);
    }

    @Deprecated
    public void setDiscard(boolean z) {
        this.discard = z;
    }

    @Deprecated
    public void setPorts(int... iArr) {
        ObjectUtil.checkNotNull(iArr, "ports");
        int[] iArr2 = (int[]) iArr.clone();
        if (iArr2.length == 0) {
            Set<Integer> emptySet = Collections.emptySet();
            this.ports = emptySet;
            this.unmodifiablePorts = emptySet;
            return;
        }
        TreeSet treeSet = new TreeSet();
        for (int i : iArr2) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("port out of range: " + i);
            }
            treeSet.add(Integer.valueOf(i));
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }

    @Deprecated
    public void setVersion(int i) {
        this.version = i;
    }

    @Deprecated
    public int version() {
        return this.version;
    }

    @Deprecated
    public void setPorts(Iterable<Integer> iterable) {
        TreeSet treeSet = new TreeSet();
        for (Integer next : iterable) {
            int intValue = next.intValue();
            if (intValue <= 0 || intValue > 65535) {
                throw new IllegalArgumentException("port out of range: " + intValue);
            }
            treeSet.add(next);
        }
        if (treeSet.isEmpty()) {
            Set<Integer> emptySet = Collections.emptySet();
            this.ports = emptySet;
            this.unmodifiablePorts = emptySet;
            return;
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }
}
