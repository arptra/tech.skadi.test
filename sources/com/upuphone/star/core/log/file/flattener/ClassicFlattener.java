package com.upuphone.star.core.log.file.flattener;

public class ClassicFlattener extends PatternFlattener {
    public ClassicFlattener() {
        super("{d} {l}/{t} {P} {T}: {m}");
    }
}
