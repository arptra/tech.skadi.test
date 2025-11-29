package org.eclipse.jetty.util;

import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class IPAddressMap<TYPE> extends HashMap<String, TYPE> {
    private final HashMap<String, IPAddrPattern> _patterns = new HashMap<>();

    public static class IPAddrPattern {
        private final OctetPattern[] _octets = new OctetPattern[4];

        public IPAddrPattern(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid IP address pattern: " + str);
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
                for (int i = 0; i < 4; i++) {
                    String str2 = "0-255";
                    String trim = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken().trim() : str2;
                    int length = trim.length();
                    if (length == 0) {
                        if (stringTokenizer.hasMoreTokens()) {
                            throw new IllegalArgumentException("Invalid IP address pattern: " + str);
                        }
                    }
                    OctetPattern[] octetPatternArr = this._octets;
                    if (length != 0) {
                        str2 = trim;
                    }
                    octetPatternArr[i] = new OctetPattern(str2);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid IP address pattern: " + str, e);
            }
        }

        public boolean match(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid IP address: " + str);
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
                boolean z = true;
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        break;
                    } else if (stringTokenizer.hasMoreTokens()) {
                        z &= this._octets[i].match(stringTokenizer.nextToken());
                        if (!z) {
                            break;
                        }
                        i++;
                    } else {
                        throw new IllegalArgumentException("Invalid IP address: " + str);
                    }
                }
                return z;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid IP address: " + str, e);
            }
        }
    }

    public IPAddressMap() {
        super(11);
    }

    public TYPE get(Object obj) {
        return super.get(obj);
    }

    public Object getLazyMatches(String str) {
        if (str == null) {
            return LazyList.getList(super.entrySet());
        }
        Object obj = null;
        for (Map.Entry entry : super.entrySet()) {
            if (this._patterns.get(entry.getKey()).match(str)) {
                obj = LazyList.add(obj, entry);
            }
        }
        return obj;
    }

    public Map.Entry<String, TYPE> getMatch(String str) {
        if (str == null) {
            return null;
        }
        for (Map.Entry<String, TYPE> entry : super.entrySet()) {
            if (this._patterns.get(entry.getKey()).match(str)) {
                return entry;
            }
        }
        return null;
    }

    public TYPE match(String str) {
        Map.Entry match = getMatch(str);
        if (match == null) {
            return null;
        }
        return match.getValue();
    }

    public TYPE put(String str, TYPE type) throws IllegalArgumentException {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid IP address pattern: " + str);
        }
        String trim = str.trim();
        if (this._patterns.get(trim) == null) {
            this._patterns.put(trim, new IPAddrPattern(trim));
        }
        return super.put(trim, type);
    }

    public IPAddressMap(int i) {
        super(i);
    }

    public static class OctetPattern extends BitSet {
        private final BitSet _mask;

        public OctetPattern(String str) throws IllegalArgumentException {
            BitSet bitSet = new BitSet(256);
            this._mask = bitSet;
            if (str != null) {
                try {
                    String trim = str.trim();
                    if (trim.length() == 0) {
                        bitSet.set(0, 255);
                        return;
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    while (stringTokenizer.hasMoreTokens()) {
                        String trim2 = stringTokenizer.nextToken().trim();
                        if (trim2.length() > 0) {
                            if (trim2.indexOf(45) < 0) {
                                this._mask.set(Integer.valueOf(trim2).intValue());
                            } else {
                                String[] split = trim2.split(LunarCalendar.DATE_SEPARATOR, -2);
                                if (split.length == 2) {
                                    int parseInt = split[0].length() > 0 ? Integer.parseInt(split[0]) : 0;
                                    int parseInt2 = split[1].length() > 0 ? Integer.parseInt(split[1]) : 255;
                                    if (parseInt <= parseInt2) {
                                        this._mask.set(parseInt, parseInt2 + 1);
                                    } else {
                                        throw new IllegalArgumentException("Invalid octet spec: " + str);
                                    }
                                } else {
                                    throw new IllegalArgumentException("Invalid octet spec: " + str);
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid octet spec: " + str, e);
                }
            }
        }

        public boolean match(String str) throws IllegalArgumentException {
            if (str == null || str.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid octet: " + str);
            }
            try {
                return match(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Invalid octet: " + str);
            }
        }

        public boolean match(int i) throws IllegalArgumentException {
            if (i >= 0 && i <= 255) {
                return this._mask.get(i);
            }
            throw new IllegalArgumentException("Invalid octet: " + i);
        }
    }
}
