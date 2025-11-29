package com.hp.hpl.sparta.xpath;

public class AttrTest extends NodeTest {
    private final String attrName_;

    public AttrTest(String str) {
        this.attrName_ = str;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getAttrName() {
        return this.attrName_;
    }

    public boolean isStringValue() {
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(this.attrName_);
        return stringBuffer.toString();
    }
}
