package io.netty.handler.codec.dns;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import io.netty.util.collection.IntObjectHashMap;
import java.util.HashMap;
import java.util.Map;

public class DnsRecordType implements Comparable<DnsRecordType> {
    public static final DnsRecordType A;
    public static final DnsRecordType AAAA;
    public static final DnsRecordType AFSDB;
    public static final DnsRecordType ANY;
    public static final DnsRecordType APL;
    public static final DnsRecordType AXFR;
    private static final Map<String, DnsRecordType> BY_NAME = new HashMap();
    private static final IntObjectHashMap<DnsRecordType> BY_TYPE = new IntObjectHashMap<>();
    public static final DnsRecordType CAA;
    public static final DnsRecordType CERT;
    public static final DnsRecordType CNAME;
    public static final DnsRecordType DHCID;
    public static final DnsRecordType DLV;
    public static final DnsRecordType DNAME;
    public static final DnsRecordType DNSKEY;
    public static final DnsRecordType DS;
    private static final String EXPECTED;
    public static final DnsRecordType HIP;
    public static final DnsRecordType IPSECKEY;
    public static final DnsRecordType IXFR;
    public static final DnsRecordType KEY;
    public static final DnsRecordType KX;
    public static final DnsRecordType LOC;
    public static final DnsRecordType MX;
    public static final DnsRecordType NAPTR;
    public static final DnsRecordType NS;
    public static final DnsRecordType NSEC;
    public static final DnsRecordType NSEC3;
    public static final DnsRecordType NSEC3PARAM;
    public static final DnsRecordType OPT;
    public static final DnsRecordType PTR;
    public static final DnsRecordType RP;
    public static final DnsRecordType RRSIG;
    public static final DnsRecordType SIG;
    public static final DnsRecordType SOA;
    public static final DnsRecordType SPF;
    public static final DnsRecordType SRV;
    public static final DnsRecordType SSHFP;
    public static final DnsRecordType TA;
    public static final DnsRecordType TKEY;
    public static final DnsRecordType TLSA;
    public static final DnsRecordType TSIG;
    public static final DnsRecordType TXT;
    private final int intValue;
    private final String name;
    private String text;

    static {
        DnsRecordType dnsRecordType = r1;
        DnsRecordType dnsRecordType2 = new DnsRecordType(1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A = dnsRecordType2;
        DnsRecordType dnsRecordType3 = r2;
        DnsRecordType dnsRecordType4 = new DnsRecordType(2, "NS");
        NS = dnsRecordType4;
        DnsRecordType dnsRecordType5 = r3;
        DnsRecordType dnsRecordType6 = new DnsRecordType(5, "CNAME");
        CNAME = dnsRecordType6;
        DnsRecordType dnsRecordType7 = r4;
        DnsRecordType dnsRecordType8 = new DnsRecordType(6, "SOA");
        SOA = dnsRecordType8;
        DnsRecordType dnsRecordType9 = r5;
        DnsRecordType dnsRecordType10 = new DnsRecordType(12, "PTR");
        PTR = dnsRecordType10;
        DnsRecordType dnsRecordType11 = r6;
        DnsRecordType dnsRecordType12 = new DnsRecordType(15, "MX");
        MX = dnsRecordType12;
        DnsRecordType dnsRecordType13 = r7;
        DnsRecordType dnsRecordType14 = new DnsRecordType(16, "TXT");
        TXT = dnsRecordType14;
        DnsRecordType dnsRecordType15 = r8;
        DnsRecordType dnsRecordType16 = new DnsRecordType(17, "RP");
        RP = dnsRecordType16;
        DnsRecordType dnsRecordType17 = r9;
        DnsRecordType dnsRecordType18 = new DnsRecordType(18, "AFSDB");
        AFSDB = dnsRecordType18;
        DnsRecordType dnsRecordType19 = r10;
        DnsRecordType dnsRecordType20 = new DnsRecordType(24, "SIG");
        SIG = dnsRecordType20;
        DnsRecordType dnsRecordType21 = r11;
        DnsRecordType dnsRecordType22 = new DnsRecordType(25, "KEY");
        KEY = dnsRecordType22;
        DnsRecordType dnsRecordType23 = r12;
        DnsRecordType dnsRecordType24 = new DnsRecordType(28, "AAAA");
        AAAA = dnsRecordType24;
        DnsRecordType dnsRecordType25 = r13;
        DnsRecordType dnsRecordType26 = new DnsRecordType(29, "LOC");
        LOC = dnsRecordType26;
        DnsRecordType dnsRecordType27 = r14;
        DnsRecordType dnsRecordType28 = dnsRecordType;
        DnsRecordType dnsRecordType29 = new DnsRecordType(33, "SRV");
        SRV = dnsRecordType29;
        DnsRecordType dnsRecordType30 = r0;
        DnsRecordType dnsRecordType31 = new DnsRecordType(35, "NAPTR");
        NAPTR = dnsRecordType31;
        DnsRecordType dnsRecordType32 = r0;
        DnsRecordType dnsRecordType33 = new DnsRecordType(36, "KX");
        KX = dnsRecordType33;
        DnsRecordType dnsRecordType34 = r0;
        DnsRecordType dnsRecordType35 = new DnsRecordType(37, "CERT");
        CERT = dnsRecordType35;
        DnsRecordType dnsRecordType36 = r0;
        DnsRecordType dnsRecordType37 = new DnsRecordType(39, "DNAME");
        DNAME = dnsRecordType37;
        DnsRecordType dnsRecordType38 = r0;
        DnsRecordType dnsRecordType39 = new DnsRecordType(41, "OPT");
        OPT = dnsRecordType39;
        DnsRecordType dnsRecordType40 = r0;
        DnsRecordType dnsRecordType41 = new DnsRecordType(42, "APL");
        APL = dnsRecordType41;
        DnsRecordType dnsRecordType42 = r0;
        DnsRecordType dnsRecordType43 = new DnsRecordType(43, "DS");
        DS = dnsRecordType43;
        DnsRecordType dnsRecordType44 = r0;
        DnsRecordType dnsRecordType45 = new DnsRecordType(44, "SSHFP");
        SSHFP = dnsRecordType45;
        DnsRecordType dnsRecordType46 = r0;
        DnsRecordType dnsRecordType47 = new DnsRecordType(45, "IPSECKEY");
        IPSECKEY = dnsRecordType47;
        DnsRecordType dnsRecordType48 = r0;
        DnsRecordType dnsRecordType49 = new DnsRecordType(46, "RRSIG");
        RRSIG = dnsRecordType49;
        DnsRecordType dnsRecordType50 = r0;
        DnsRecordType dnsRecordType51 = new DnsRecordType(47, "NSEC");
        NSEC = dnsRecordType51;
        DnsRecordType dnsRecordType52 = r0;
        DnsRecordType dnsRecordType53 = new DnsRecordType(48, "DNSKEY");
        DNSKEY = dnsRecordType53;
        DnsRecordType dnsRecordType54 = r0;
        DnsRecordType dnsRecordType55 = new DnsRecordType(49, "DHCID");
        DHCID = dnsRecordType55;
        DnsRecordType dnsRecordType56 = r0;
        DnsRecordType dnsRecordType57 = new DnsRecordType(50, "NSEC3");
        NSEC3 = dnsRecordType57;
        DnsRecordType dnsRecordType58 = r0;
        DnsRecordType dnsRecordType59 = new DnsRecordType(51, "NSEC3PARAM");
        NSEC3PARAM = dnsRecordType59;
        DnsRecordType dnsRecordType60 = r0;
        DnsRecordType dnsRecordType61 = new DnsRecordType(52, "TLSA");
        TLSA = dnsRecordType61;
        DnsRecordType dnsRecordType62 = r0;
        DnsRecordType dnsRecordType63 = new DnsRecordType(55, "HIP");
        HIP = dnsRecordType63;
        DnsRecordType dnsRecordType64 = r0;
        DnsRecordType dnsRecordType65 = new DnsRecordType(99, "SPF");
        SPF = dnsRecordType65;
        DnsRecordType dnsRecordType66 = r0;
        DnsRecordType dnsRecordType67 = new DnsRecordType(249, "TKEY");
        TKEY = dnsRecordType67;
        DnsRecordType dnsRecordType68 = r0;
        DnsRecordType dnsRecordType69 = new DnsRecordType(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "TSIG");
        TSIG = dnsRecordType69;
        DnsRecordType dnsRecordType70 = r0;
        DnsRecordType dnsRecordType71 = new DnsRecordType(251, "IXFR");
        IXFR = dnsRecordType71;
        DnsRecordType dnsRecordType72 = r0;
        DnsRecordType dnsRecordType73 = new DnsRecordType(252, "AXFR");
        AXFR = dnsRecordType73;
        DnsRecordType dnsRecordType74 = r0;
        DnsRecordType dnsRecordType75 = new DnsRecordType(255, "ANY");
        ANY = dnsRecordType75;
        DnsRecordType dnsRecordType76 = r0;
        DnsRecordType dnsRecordType77 = new DnsRecordType(257, "CAA");
        CAA = dnsRecordType77;
        DnsRecordType dnsRecordType78 = r0;
        DnsRecordType dnsRecordType79 = new DnsRecordType(32768, "TA");
        TA = dnsRecordType79;
        DnsRecordType dnsRecordType80 = r0;
        DnsRecordType dnsRecordType81 = new DnsRecordType(32769, "DLV");
        DLV = dnsRecordType81;
        DnsRecordType[] dnsRecordTypeArr = {dnsRecordType28, dnsRecordType3, dnsRecordType5, dnsRecordType7, dnsRecordType9, dnsRecordType11, dnsRecordType13, dnsRecordType15, dnsRecordType17, dnsRecordType19, dnsRecordType21, dnsRecordType23, dnsRecordType25, dnsRecordType27, dnsRecordType30, dnsRecordType32, dnsRecordType34, dnsRecordType36, dnsRecordType38, dnsRecordType40, dnsRecordType42, dnsRecordType44, dnsRecordType46, dnsRecordType48, dnsRecordType50, dnsRecordType52, dnsRecordType54, dnsRecordType56, dnsRecordType58, dnsRecordType60, dnsRecordType62, dnsRecordType64, dnsRecordType66, dnsRecordType68, dnsRecordType70, dnsRecordType72, dnsRecordType74, dnsRecordType76, dnsRecordType78, dnsRecordType80};
        StringBuilder sb = new StringBuilder(512);
        sb.append(" (expected: ");
        for (int i = 0; i < 40; i++) {
            DnsRecordType dnsRecordType82 = dnsRecordTypeArr[i];
            BY_NAME.put(dnsRecordType82.name(), dnsRecordType82);
            BY_TYPE.put(dnsRecordType82.intValue(), dnsRecordType82);
            sb.append(dnsRecordType82.name());
            sb.append('(');
            sb.append(dnsRecordType82.intValue());
            sb.append("), ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(')');
        EXPECTED = sb.toString();
    }

    private DnsRecordType(int i) {
        this(i, "UNKNOWN");
    }

    public static DnsRecordType valueOf(int i) {
        DnsRecordType dnsRecordType = BY_TYPE.get(i);
        return dnsRecordType == null ? new DnsRecordType(i) : dnsRecordType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DnsRecordType) && ((DnsRecordType) obj).intValue == this.intValue;
    }

    public int hashCode() {
        return this.intValue;
    }

    public int intValue() {
        return this.intValue;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = this.name + '(' + intValue() + ')';
        this.text = str2;
        return str2;
    }

    public DnsRecordType(int i, String str) {
        if ((65535 & i) == i) {
            this.intValue = i;
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("intValue: " + i + " (expected: 0 ~ 65535)");
    }

    public int compareTo(DnsRecordType dnsRecordType) {
        return intValue() - dnsRecordType.intValue();
    }

    public static DnsRecordType valueOf(String str) {
        DnsRecordType dnsRecordType = BY_NAME.get(str);
        if (dnsRecordType != null) {
            return dnsRecordType;
        }
        throw new IllegalArgumentException("name: " + str + EXPECTED);
    }
}
