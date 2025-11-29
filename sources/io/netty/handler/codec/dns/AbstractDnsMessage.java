package io.netty.handler.codec.dns;

import com.upuphone.starrynet.api.StConstant;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.UShort;

public abstract class AbstractDnsMessage extends AbstractReferenceCounted implements DnsMessage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SECTION_COUNT = 4;
    private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();
    private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
    private Object additionals;
    private Object answers;
    private Object authorities;
    private short id;
    private final ResourceLeakTracker<DnsMessage> leak;
    private DnsOpCode opCode;
    private Object questions;
    private boolean recursionDesired;
    private byte z;

    public AbstractDnsMessage(int i) {
        this(i, DnsOpCode.QUERY);
    }

    private static <T extends DnsRecord> T castRecord(Object obj) {
        return (DnsRecord) obj;
    }

    private static DnsRecord checkQuestion(int i, DnsRecord dnsRecord) {
        if (i != SECTION_QUESTION || (ObjectUtil.checkNotNull(dnsRecord, "record") instanceof DnsQuestion)) {
            return dnsRecord;
        }
        throw new IllegalArgumentException("record: " + dnsRecord + " (expected: " + StringUtil.simpleClassName((Class<?>) DnsQuestion.class) + ')');
    }

    private static ArrayList<DnsRecord> newRecordList() {
        return new ArrayList<>(2);
    }

    private Object sectionAt(int i) {
        if (i == 0) {
            return this.questions;
        }
        if (i == 1) {
            return this.answers;
        }
        if (i == 2) {
            return this.authorities;
        }
        if (i == 3) {
            return this.additionals;
        }
        throw new Error();
    }

    private static int sectionOrdinal(DnsSection dnsSection) {
        return ((DnsSection) ObjectUtil.checkNotNull(dnsSection, "section")).ordinal();
    }

    private void setSection(int i, Object obj) {
        if (i == 0) {
            this.questions = obj;
        } else if (i == 1) {
            this.answers = obj;
        } else if (i == 2) {
            this.authorities = obj;
        } else if (i == 3) {
            this.additionals = obj;
        } else {
            throw new Error();
        }
    }

    public DnsMessage addRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    public DnsMessage clear(DnsSection dnsSection) {
        clear(sectionOrdinal(dnsSection));
        return this;
    }

    public int count(DnsSection dnsSection) {
        return count(sectionOrdinal(dnsSection));
    }

    public void deallocate() {
        clear();
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        DnsMessage dnsMessage = (DnsMessage) obj;
        if (id() != dnsMessage.id()) {
            return false;
        }
        if (this instanceof DnsQuery) {
            if (!(dnsMessage instanceof DnsQuery)) {
                return false;
            }
        } else if (dnsMessage instanceof DnsQuery) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (id() * 31) + ((this instanceof DnsQuery) ^ true ? 1 : 0);
    }

    public int id() {
        return this.id & UShort.MAX_VALUE;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public DnsOpCode opCode() {
        return this.opCode;
    }

    public <T extends DnsRecord> T recordAt(DnsSection dnsSection) {
        return recordAt(sectionOrdinal(dnsSection));
    }

    public <T extends DnsRecord> T removeRecord(DnsSection dnsSection, int i) {
        return removeRecord(sectionOrdinal(dnsSection), i);
    }

    public DnsMessage setId(int i) {
        this.id = (short) i;
        return this;
    }

    public DnsMessage setOpCode(DnsOpCode dnsOpCode) {
        this.opCode = (DnsOpCode) ObjectUtil.checkNotNull(dnsOpCode, StConstant.STARRY_MESSAGE_OP_CODE);
        return this;
    }

    public DnsMessage setRecord(DnsSection dnsSection, DnsRecord dnsRecord) {
        setRecord(sectionOrdinal(dnsSection), dnsRecord);
        return this;
    }

    public DnsMessage setRecursionDesired(boolean z2) {
        this.recursionDesired = z2;
        return this;
    }

    public DnsMessage setZ(int i) {
        this.z = (byte) (i & 7);
        return this;
    }

    public int z() {
        return this.z;
    }

    public AbstractDnsMessage(int i, DnsOpCode dnsOpCode) {
        this.leak = leakDetector.track(this);
        setId(i);
        setOpCode(dnsOpCode);
    }

    private void addRecord(int i, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            setSection(i, dnsRecord);
        } else if (sectionAt instanceof DnsRecord) {
            ArrayList<DnsRecord> newRecordList = newRecordList();
            newRecordList.add(castRecord(sectionAt));
            newRecordList.add(dnsRecord);
            setSection(i, newRecordList);
        } else {
            ((List) sectionAt).add(dnsRecord);
        }
    }

    private int count(int i) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            return 0;
        }
        if (sectionAt instanceof DnsRecord) {
            return 1;
        }
        return ((List) sectionAt).size();
    }

    private <T extends DnsRecord> T recordAt(int i) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            return null;
        }
        if (sectionAt instanceof DnsRecord) {
            return castRecord(sectionAt);
        }
        List list = (List) sectionAt;
        if (list.isEmpty()) {
            return null;
        }
        return castRecord(list.get(0));
    }

    private <T extends DnsRecord> T removeRecord(int i, int i2) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
        } else if (!(sectionAt instanceof DnsRecord)) {
            return castRecord(((List) sectionAt).remove(i2));
        } else {
            if (i2 == 0) {
                T castRecord = castRecord(sectionAt);
                setSection(i, (Object) null);
                return castRecord;
            }
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
        }
    }

    private void setRecord(int i, DnsRecord dnsRecord) {
        clear(i);
        setSection(i, checkQuestion(i, dnsRecord));
    }

    public DnsMessage clear() {
        for (int i = 0; i < 4; i++) {
            clear(i);
        }
        return this;
    }

    private void clear(int i) {
        Object sectionAt = sectionAt(i);
        setSection(i, (Object) null);
        if (sectionAt instanceof ReferenceCounted) {
            ((ReferenceCounted) sectionAt).release();
        } else if (sectionAt instanceof List) {
            List<Object> list = (List) sectionAt;
            if (!list.isEmpty()) {
                for (Object release : list) {
                    ReferenceCountUtil.release(release);
                }
            }
        }
    }

    public DnsMessage retain() {
        return (DnsMessage) super.retain();
    }

    public DnsMessage touch() {
        return (DnsMessage) super.touch();
    }

    public DnsMessage retain(int i) {
        return (DnsMessage) super.retain(i);
    }

    public <T extends DnsRecord> T setRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        return setRecord(sectionOrdinal(dnsSection), i, dnsRecord);
    }

    public DnsMessage touch(Object obj) {
        ResourceLeakTracker<DnsMessage> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }

    private <T extends DnsRecord> T setRecord(int i, int i2, DnsRecord dnsRecord) {
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
        } else if (!(sectionAt instanceof DnsRecord)) {
            return castRecord(((List) sectionAt).set(i2, dnsRecord));
        } else {
            if (i2 == 0) {
                setSection(i, dnsRecord);
                return castRecord(sectionAt);
            }
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
        }
    }

    public int count() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += count(i2);
        }
        return i;
    }

    public <T extends DnsRecord> T recordAt(DnsSection dnsSection, int i) {
        return recordAt(sectionOrdinal(dnsSection), i);
    }

    private <T extends DnsRecord> T recordAt(int i, int i2) {
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: none)");
        } else if (!(sectionAt instanceof DnsRecord)) {
            return castRecord(((List) sectionAt).get(i2));
        } else {
            if (i2 == 0) {
                return castRecord(sectionAt);
            }
            throw new IndexOutOfBoundsException("index: " + i2 + "' (expected: 0)");
        }
    }

    public DnsMessage addRecord(DnsSection dnsSection, int i, DnsRecord dnsRecord) {
        addRecord(sectionOrdinal(dnsSection), i, dnsRecord);
        return this;
    }

    private void addRecord(int i, int i2, DnsRecord dnsRecord) {
        ArrayList<DnsRecord> arrayList;
        checkQuestion(i, dnsRecord);
        Object sectionAt = sectionAt(i);
        if (sectionAt == null) {
            if (i2 == 0) {
                setSection(i, dnsRecord);
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0)");
        } else if (sectionAt instanceof DnsRecord) {
            if (i2 == 0) {
                arrayList = newRecordList();
                arrayList.add(dnsRecord);
                arrayList.add(castRecord(sectionAt));
            } else if (i2 == 1) {
                arrayList = newRecordList();
                arrayList.add(castRecord(sectionAt));
                arrayList.add(dnsRecord);
            } else {
                throw new IndexOutOfBoundsException("index: " + i2 + " (expected: 0 or 1)");
            }
            setSection(i, arrayList);
        } else {
            ((List) sectionAt).add(i2, dnsRecord);
        }
    }
}
