package com.hp.hpl.sparta.xpath;

public abstract class AttrExpr extends BooleanExpr {
    private final String attrName_;

    public AttrExpr(String str) {
        this.attrName_ = str;
    }

    public String getAttrName() {
        return this.attrName_;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(this.attrName_);
        return stringBuffer.toString();
    }
}
