package com.meizu.common.widget;

import android.database.Cursor;
import android.widget.AlphabetIndexer;
import java.text.Collator;

public class GroupAlphabetIndexer extends AlphabetIndexer {
    private static final String DEFAULT_GROUP_LETTERS = "1234567890";
    private static final String SYMBOL_SLASH = "#";
    private Collator mCollator;
    private String mFirstGroupLetters = DEFAULT_GROUP_LETTERS;

    public GroupAlphabetIndexer(Cursor cursor, int i, CharSequence charSequence) {
        super(cursor, i, charSequence);
        Collator instance = Collator.getInstance();
        this.mCollator = instance;
        instance.setStrength(0);
    }

    public int compare(String str, String str2) {
        return compare(str, str2, this.mFirstGroupLetters);
    }

    public void setFirstGroupLetters(String str) {
        this.mFirstGroupLetters = str;
    }

    public int compare(String str, String str2, String str3) {
        String str4;
        if (str.length() > 0) {
            str4 = str.substring(0, 1);
        } else {
            str4 = " ";
        }
        if (str3.contains(str4)) {
            return str3.contains(str2) ? 0 : 1;
        }
        if (str3.contains(str2)) {
            return -1;
        }
        if (SYMBOL_SLASH.equals(str) || !SYMBOL_SLASH.equals(str2)) {
            return this.mCollator.compare(str4, str2);
        }
        return -1;
    }
}
