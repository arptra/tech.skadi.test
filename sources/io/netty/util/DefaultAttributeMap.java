package io.netty.util;

import com.honey.account.i.a;
import com.upuphone.runasone.relay.api.IntentKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultAttributeMap implements AttributeMap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, "attributes");
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    private volatile DefaultAttribute[] attributes = EMPTY_ATTRIBUTES;

    public static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        private static final long serialVersionUID = -2661411462200283011L;
        private volatile DefaultAttributeMap attributeMap;
        /* access modifiers changed from: private */
        public final AttributeKey<T> key;

        public DefaultAttribute(DefaultAttributeMap defaultAttributeMap, AttributeKey<T> attributeKey) {
            this.attributeMap = defaultAttributeMap;
            this.key = attributeKey;
        }

        /* access modifiers changed from: private */
        public boolean isRemoved() {
            return this.attributeMap == null;
        }

        public T getAndRemove() {
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            boolean z = defaultAttributeMap != null && a.a(MAP_UPDATER, this, defaultAttributeMap, (Object) null);
            T andSet = getAndSet((Object) null);
            if (z) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
            return andSet;
        }

        public AttributeKey<T> key() {
            return this.key;
        }

        public void remove() {
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            boolean z = defaultAttributeMap != null && a.a(MAP_UPDATER, this, defaultAttributeMap, (Object) null);
            set((Object) null);
            if (z) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T setIfAbsent(T r3) {
            /*
                r2 = this;
            L_0x0000:
                r0 = 0
                boolean r1 = r2.compareAndSet(r0, r3)
                if (r1 != 0) goto L_0x000d
                java.lang.Object r0 = r2.get()
                if (r0 == 0) goto L_0x0000
            L_0x000d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.DefaultAttributeMap.DefaultAttribute.setIfAbsent(java.lang.Object):java.lang.Object");
        }
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] defaultAttributeArr, int i, DefaultAttribute[] defaultAttributeArr2, DefaultAttribute defaultAttribute) {
        int id = defaultAttribute.key.id();
        int i2 = i - 1;
        while (i2 >= 0 && defaultAttributeArr[i2].key.id() >= id) {
            defaultAttributeArr2[i2 + 1] = defaultAttributeArr[i2];
            i2--;
        }
        int i3 = i2 + 1;
        defaultAttributeArr2[i3] = defaultAttribute;
        if (i3 > 0) {
            System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, i3);
        }
    }

    /* access modifiers changed from: private */
    public <T> void removeAttributeIfMatch(AttributeKey<T> attributeKey, DefaultAttribute<T> defaultAttribute) {
        DefaultAttribute<T>[] defaultAttributeArr;
        DefaultAttribute[] defaultAttributeArr2;
        do {
            defaultAttributeArr = this.attributes;
            int searchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (searchAttributeByKey >= 0 && defaultAttributeArr[searchAttributeByKey] == defaultAttribute) {
                int length = defaultAttributeArr.length;
                int i = length - 1;
                defaultAttributeArr2 = i == 0 ? EMPTY_ATTRIBUTES : new DefaultAttribute[i];
                System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, searchAttributeByKey);
                int i2 = (length - searchAttributeByKey) - 1;
                if (i2 > 0) {
                    System.arraycopy(defaultAttributeArr, searchAttributeByKey + 1, defaultAttributeArr2, searchAttributeByKey, i2);
                }
            } else {
                return;
            }
        } while (!a.a(ATTRIBUTES_UPDATER, this, defaultAttributeArr, defaultAttributeArr2));
    }

    private static int searchAttributeByKey(DefaultAttribute[] defaultAttributeArr, AttributeKey<?> attributeKey) {
        int length = defaultAttributeArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            AttributeKey<?> access$000 = defaultAttributeArr[i2].key;
            if (access$000 == attributeKey) {
                return i2;
            }
            if (access$000.id() < attributeKey.id()) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        DefaultAttribute[] defaultAttributeArr;
        DefaultAttribute[] defaultAttributeArr2;
        ObjectUtil.checkNotNull(attributeKey, IntentKey.ACTIVITY.ACTION_KEY);
        DefaultAttribute defaultAttribute = null;
        do {
            defaultAttributeArr = this.attributes;
            int searchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (searchAttributeByKey >= 0) {
                DefaultAttribute defaultAttribute2 = defaultAttributeArr[searchAttributeByKey];
                if (!defaultAttribute2.isRemoved()) {
                    return defaultAttribute2;
                }
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                defaultAttributeArr2 = (DefaultAttribute[]) Arrays.copyOf(defaultAttributeArr, defaultAttributeArr.length);
                defaultAttributeArr2[searchAttributeByKey] = defaultAttribute;
            } else {
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                int length = defaultAttributeArr.length;
                defaultAttributeArr2 = new DefaultAttribute[(length + 1)];
                orderedCopyOnInsert(defaultAttributeArr, length, defaultAttributeArr2, defaultAttribute);
            }
        } while (!a.a(ATTRIBUTES_UPDATER, this, defaultAttributeArr, defaultAttributeArr2));
        return defaultAttribute;
    }

    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        ObjectUtil.checkNotNull(attributeKey, IntentKey.ACTIVITY.ACTION_KEY);
        return searchAttributeByKey(this.attributes, attributeKey) >= 0;
    }
}
