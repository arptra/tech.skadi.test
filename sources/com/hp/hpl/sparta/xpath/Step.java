package com.hp.hpl.sparta.xpath;

import java.io.IOException;

public class Step {
    public static Step DOT = new Step(ThisNodeTest.INSTANCE, TrueExpr.INSTANCE);
    private final boolean multiLevel_;
    private final NodeTest nodeTest_;
    private final BooleanExpr predicate_;

    public Step(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.nodeTest_ = nodeTest;
        this.predicate_ = booleanExpr;
        this.multiLevel_ = false;
    }

    public NodeTest getNodeTest() {
        return this.nodeTest_;
    }

    public BooleanExpr getPredicate() {
        return this.predicate_;
    }

    public boolean isMultiLevel() {
        return this.multiLevel_;
    }

    public boolean isStringValue() {
        return this.nodeTest_.isStringValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.nodeTest_.toString());
        stringBuffer.append(this.predicate_.toString());
        return stringBuffer.toString();
    }

    public Step(XPath xPath, boolean z, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        NodeTest elementTest;
        this.multiLevel_ = z;
        int i = simpleStreamTokenizer.ttype;
        if (i != -3) {
            if (i == 42) {
                elementTest = AllElementTest.INSTANCE;
            } else if (i != 46) {
                if (i != 64) {
                    throw new XPathException(xPath, "at begininning of step", simpleStreamTokenizer, "'.' or '*' or name");
                } else if (simpleStreamTokenizer.nextToken() == -3) {
                    elementTest = new AttrTest(simpleStreamTokenizer.sval);
                } else {
                    throw new XPathException(xPath, "after @ in node test", simpleStreamTokenizer, "name");
                }
            } else if (simpleStreamTokenizer.nextToken() == 46) {
                elementTest = ParentNodeTest.INSTANCE;
            } else {
                simpleStreamTokenizer.pushBack();
                elementTest = ThisNodeTest.INSTANCE;
            }
        } else if (!simpleStreamTokenizer.sval.equals("text")) {
            elementTest = new ElementTest(simpleStreamTokenizer.sval);
        } else if (simpleStreamTokenizer.nextToken() == 40 && simpleStreamTokenizer.nextToken() == 41) {
            elementTest = TextTest.INSTANCE;
        } else {
            throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
        }
        this.nodeTest_ = elementTest;
        if (simpleStreamTokenizer.nextToken() == 91) {
            simpleStreamTokenizer.nextToken();
            this.predicate_ = ExprFactory.createExpr(xPath, simpleStreamTokenizer);
            if (simpleStreamTokenizer.ttype == 93) {
                simpleStreamTokenizer.nextToken();
                return;
            }
            throw new XPathException(xPath, "after predicate expression", simpleStreamTokenizer, "]");
        }
        this.predicate_ = TrueExpr.INSTANCE;
    }
}
