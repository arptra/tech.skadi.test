package com.hp.hpl.sparta.xpath;

public abstract class TextCompareExpr extends BooleanExpr {
    private final String value_;

    public TextCompareExpr(String str) {
        this.value_ = str;
    }

    public String getValue() {
        return this.value_;
    }

    public String toString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[text()");
        stringBuffer.append(str);
        stringBuffer.append("'");
        stringBuffer.append(this.value_);
        stringBuffer.append("']");
        return stringBuffer.toString();
    }
}
