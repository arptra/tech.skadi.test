package com.here.odnp.debug;

import java.io.BufferedReader;
import java.io.IOException;

public class ProcessUtils {
    private static final int COLUMN_INDEX_NAME = 8;
    private static final int COLUMN_INDEX_PID = 1;
    private static final int COLUMN_INDEX_USER = 0;
    private static final String TAG = "odnp.debug.ProcessUtils";

    public static class ProcessInfo {
        public String name;
        public int pid;
        public String user;

        public String toString() {
            return "user: " + this.user + ", pid: " + this.pid + ", name: " + this.name;
        }
    }

    public static ProcessInfo[] getProcess(String str, String str2) {
        return null;
    }

    private static ProcessInfo parsePsLine(String str) throws IOException {
        return null;
    }

    private static void validatePsHeader(BufferedReader bufferedReader) throws IOException {
    }
}
