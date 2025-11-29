package com.hp.hpl.sparta.xpath;

public class AttrExistsExpr extends AttrExpr {
    public AttrExistsExpr(String str) {
        super(str);
    }

    public void accept(BooleanExprVisitor booleanExprVisitor) throws XPathException {
        booleanExprVisitor.visit(this);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(super.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
