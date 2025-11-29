package com.honey.account.q2;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((LocalMedia) obj2).getDateAddedTime(), ((LocalMedia) obj).getDateAddedTime());
    }
}
