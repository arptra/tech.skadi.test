package com.luck.picture.lib.utils;

import com.honey.account.q2.a;
import com.honey.account.q2.b;
import com.luck.picture.lib.entity.LocalMediaFolder;
import java.util.Collections;
import java.util.List;

public class SortUtils {
    public static /* synthetic */ int c(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getFolderTotalNum(), localMediaFolder.getFolderTotalNum());
    }

    public static void e(List list) {
        Collections.sort(list, new b());
    }

    public static void f(List list) {
        Collections.sort(list, new a());
    }
}
