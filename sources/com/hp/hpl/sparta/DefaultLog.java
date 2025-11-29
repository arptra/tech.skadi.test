package com.hp.hpl.sparta;

import java.io.PrintStream;

class DefaultLog implements ParseLog {
    public void error(String str, String str2, int i) {
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append("(");
        stringBuffer.append(i);
        stringBuffer.append("): ");
        stringBuffer.append(str);
        stringBuffer.append(" (ERROR)");
        printStream.println(stringBuffer.toString());
    }

    public void note(String str, String str2, int i) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append("(");
        stringBuffer.append(i);
        stringBuffer.append("): ");
        stringBuffer.append(str);
        stringBuffer.append(" (NOTE)");
        printStream.println(stringBuffer.toString());
    }

    public void warning(String str, String str2, int i) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append("(");
        stringBuffer.append(i);
        stringBuffer.append("): ");
        stringBuffer.append(str);
        stringBuffer.append(" (WARNING)");
        printStream.println(stringBuffer.toString());
    }
}
