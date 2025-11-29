package com.google.i18n.phonenumbers.prefixmapper;

import com.meizu.common.widget.MzContactsContract;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.SortedMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

abstract class PhonePrefixMapStorageStrategy {
    protected int numOfEntries = 0;
    protected final TreeSet<Integer> possibleLengths = new TreeSet<>();

    public abstract String getDescription(int i);

    public int getNumOfEntries() {
        return this.numOfEntries;
    }

    public TreeSet<Integer> getPossibleLengths() {
        return this.possibleLengths;
    }

    public abstract int getPrefix(int i);

    public abstract void readExternal(ObjectInput objectInput) throws IOException;

    public abstract void readFromSortedMap(SortedMap<Integer, String> sortedMap);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int numOfEntries2 = getNumOfEntries();
        for (int i = 0; i < numOfEntries2; i++) {
            sb.append(getPrefix(i));
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            sb.append(getDescription(i));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    public abstract void writeExternal(ObjectOutput objectOutput) throws IOException;
}
