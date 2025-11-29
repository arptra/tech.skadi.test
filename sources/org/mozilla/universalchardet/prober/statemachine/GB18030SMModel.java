package org.mozilla.universalchardet.prober.statemachine;

import org.mozilla.universalchardet.Constants;

public class GB18030SMModel extends SMModel {
    public static int[] f = {PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.b(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.b(3, 3, 1, 1, 1, 1, 1, 1), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 2, 2, 4), PkgInt.b(5, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.b(6, 6, 6, 6, 6, 6, 6, 0)};
    public static int[] g = {PkgInt.b(1, 0, 0, 0, 0, 0, 3, 1), PkgInt.b(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.b(2, 2, 2, 2, 2, 1, 1, 0), PkgInt.b(4, 1, 0, 0, 1, 1, 1, 1), PkgInt.b(1, 1, 5, 1, 1, 1, 2, 1), PkgInt.b(1, 1, 0, 0, 0, 0, 0, 0)};
    public static int[] h = {0, 1, 1, 1, 1, 1, 2};

    public GB18030SMModel() {
        super(new PkgInt(3, 7, 2, 15, f), 7, new PkgInt(3, 7, 2, 15, g), h, Constants.h);
    }
}
