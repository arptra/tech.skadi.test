package com.hp.hpl.sparta.xpath;

public abstract class AttrRelationalExpr extends AttrExpr {
    private final int attrValue_;

    public AttrRelationalExpr(String str, int i) {
        super(str);
        this.attrValue_ = i;
    }

    public double getAttrValue() {
        return (double) this.attrValue_;
    }

    public String toString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(super.toString());
        stringBuffer.append(str);
        stringBuffer.append("'");
        stringBuffer.append(this.attrValue_);
        stringBuffer.append("']");
        return stringBuffer.toString();
    }
}
