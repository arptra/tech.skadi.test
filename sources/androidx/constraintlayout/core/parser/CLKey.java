package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

public class CLKey extends CLContainer {
    public static ArrayList f;

    static {
        ArrayList arrayList = new ArrayList();
        f = arrayList;
        arrayList.add("ConstraintSets");
        f.add("Variables");
        f.add("Generate");
        f.add("Transitions");
        f.add("KeyFrames");
        f.add("KeyAttributes");
        f.add("KeyPositions");
        f.add("KeyCycles");
    }
}
