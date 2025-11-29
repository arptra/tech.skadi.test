package com.hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class NodeListWithPosition {
    private static final Integer EIGHT = new Integer(8);
    private static final Integer FIVE = new Integer(5);
    private static final Integer FOUR = new Integer(4);
    private static final Integer NINE = new Integer(9);
    private static final Integer ONE = new Integer(1);
    private static final Integer SEVEN = new Integer(7);
    private static final Integer SIX = new Integer(6);
    private static final Integer TEN = new Integer(10);
    private static final Integer THREE = new Integer(3);
    private static final Integer TWO = new Integer(2);
    private Hashtable positions_ = new Hashtable();
    private final Vector vector_ = new Vector();

    private static Integer identity(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    public void add(Node node, int i) {
        Integer num;
        this.vector_.addElement(node);
        switch (i) {
            case 1:
                num = ONE;
                break;
            case 2:
                num = TWO;
                break;
            case 3:
                num = THREE;
                break;
            case 4:
                num = FOUR;
                break;
            case 5:
                num = FIVE;
                break;
            case 6:
                num = SIX;
                break;
            case 7:
                num = SEVEN;
                break;
            case 8:
                num = EIGHT;
                break;
            case 9:
                num = NINE;
                break;
            case 10:
                num = TEN;
                break;
            default:
                num = new Integer(i);
                break;
        }
        this.positions_.put(identity(node), num);
    }

    public Enumeration iterator() {
        return this.vector_.elements();
    }

    public int position(Node node) {
        return ((Integer) this.positions_.get(identity(node))).intValue();
    }

    public void removeAllElements() {
        this.vector_.removeAllElements();
        this.positions_.clear();
    }

    public String toString() {
        String stringBuffer;
        try {
            StringBuffer stringBuffer2 = new StringBuffer("{ ");
            Enumeration elements = this.vector_.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("String(");
                    stringBuffer3.append(nextElement);
                    stringBuffer3.append(") ");
                    stringBuffer = stringBuffer3.toString();
                } else {
                    Node node = (Node) nextElement;
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Node(");
                    stringBuffer4.append(node.toXml());
                    stringBuffer4.append(")[");
                    stringBuffer4.append(this.positions_.get(identity(node)));
                    stringBuffer4.append("] ");
                    stringBuffer = stringBuffer4.toString();
                }
                stringBuffer2.append(stringBuffer);
            }
            stringBuffer2.append("}");
            return stringBuffer2.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

    public void add(String str) {
        this.vector_.addElement(str);
    }
}
