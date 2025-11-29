package org.apache.commons.csv;

import com.honey.account.qb.c;
import com.honey.account.qb.d;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public final class CSVPrinter implements Flushable, Closeable {
    private final Appendable appendable;
    private final CSVFormat format;
    private boolean newRecord = true;

    public CSVPrinter(Appendable appendable2, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(appendable2, "appendable");
        Objects.requireNonNull(cSVFormat, "format");
        this.appendable = appendable2;
        this.format = cSVFormat.copy();
        String[] headerComments = cSVFormat.getHeaderComments();
        if (headerComments != null) {
            for (String printComment : headerComments) {
                printComment(printComment);
            }
        }
        if (cSVFormat.getHeader() != null && !cSVFormat.getSkipHeaderRecord()) {
            printRecord((Object[]) cSVFormat.getHeader());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$printRecord$0(Object obj) {
        try {
            print(obj);
        } catch (IOException e) {
            throw IOUtils.rethrow(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$printRecords$1(Object obj) {
        try {
            printRecordObject(obj);
        } catch (IOException e) {
            throw IOUtils.rethrow(e);
        }
    }

    private void printRecordObject(Object obj) throws IOException {
        if (obj instanceof Object[]) {
            printRecord((Object[]) obj);
        } else if (obj instanceof Iterable) {
            printRecord((Iterable<?>) (Iterable) obj);
        } else {
            printRecord(obj);
        }
    }

    public void close() throws IOException {
        close(false);
    }

    public void flush() throws IOException {
        Appendable appendable2 = this.appendable;
        if (appendable2 instanceof Flushable) {
            ((Flushable) appendable2).flush();
        }
    }

    public Appendable getOut() {
        return this.appendable;
    }

    public synchronized void print(Object obj) throws IOException {
        this.format.print(obj, this.appendable, this.newRecord);
        this.newRecord = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void printComment(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x0075
            org.apache.commons.csv.CSVFormat r0 = r5.format     // Catch:{ all -> 0x0014 }
            boolean r0 = r0.isCommentMarkerSet()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x000c
            goto L_0x0075
        L_0x000c:
            boolean r0 = r5.newRecord     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0016
            r5.println()     // Catch:{ all -> 0x0014 }
            goto L_0x0016
        L_0x0014:
            r6 = move-exception
            goto L_0x0073
        L_0x0016:
            java.lang.Appendable r0 = r5.appendable     // Catch:{ all -> 0x0014 }
            org.apache.commons.csv.CSVFormat r1 = r5.format     // Catch:{ all -> 0x0014 }
            java.lang.Character r1 = r1.getCommentMarker()     // Catch:{ all -> 0x0014 }
            char r1 = r1.charValue()     // Catch:{ all -> 0x0014 }
            r0.append(r1)     // Catch:{ all -> 0x0014 }
            java.lang.Appendable r0 = r5.appendable     // Catch:{ all -> 0x0014 }
            r1 = 32
            r0.append(r1)     // Catch:{ all -> 0x0014 }
            r0 = 0
        L_0x002d:
            int r2 = r6.length()     // Catch:{ all -> 0x0014 }
            if (r0 >= r2) goto L_0x006e
            char r2 = r6.charAt(r0)     // Catch:{ all -> 0x0014 }
            r3 = 10
            if (r2 == r3) goto L_0x0054
            r4 = 13
            if (r2 == r4) goto L_0x0045
            java.lang.Appendable r3 = r5.appendable     // Catch:{ all -> 0x0014 }
            r3.append(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x006b
        L_0x0045:
            int r2 = r0 + 1
            int r4 = r6.length()     // Catch:{ all -> 0x0014 }
            if (r2 >= r4) goto L_0x0054
            char r4 = r6.charAt(r2)     // Catch:{ all -> 0x0014 }
            if (r4 != r3) goto L_0x0054
            r0 = r2
        L_0x0054:
            r5.println()     // Catch:{ all -> 0x0014 }
            java.lang.Appendable r2 = r5.appendable     // Catch:{ all -> 0x0014 }
            org.apache.commons.csv.CSVFormat r3 = r5.format     // Catch:{ all -> 0x0014 }
            java.lang.Character r3 = r3.getCommentMarker()     // Catch:{ all -> 0x0014 }
            char r3 = r3.charValue()     // Catch:{ all -> 0x0014 }
            r2.append(r3)     // Catch:{ all -> 0x0014 }
            java.lang.Appendable r2 = r5.appendable     // Catch:{ all -> 0x0014 }
            r2.append(r1)     // Catch:{ all -> 0x0014 }
        L_0x006b:
            int r0 = r0 + 1
            goto L_0x002d
        L_0x006e:
            r5.println()     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)
            return
        L_0x0073:
            monitor-exit(r5)
            throw r6
        L_0x0075:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVPrinter.printComment(java.lang.String):void");
    }

    public synchronized void printHeaders(ResultSet resultSet) throws IOException, SQLException {
        printRecord((Object[]) this.format.builder().setHeader(resultSet).build().getHeader());
    }

    public synchronized void printRecord(Iterable<?> iterable) throws IOException {
        try {
            for (Object print : iterable) {
                print(print);
            }
            println();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void printRecords(Iterable<?> iterable) throws IOException {
        for (Object printRecordObject : iterable) {
            printRecordObject(printRecordObject);
        }
    }

    public synchronized void println() throws IOException {
        this.format.println(this.appendable);
        this.newRecord = true;
    }

    public void close(boolean z) throws IOException {
        if (z || this.format.getAutoFlush()) {
            flush();
        }
        Appendable appendable2 = this.appendable;
        if (appendable2 instanceof Closeable) {
            ((Closeable) appendable2).close();
        }
    }

    public void printRecords(Object... objArr) throws IOException {
        printRecords((Iterable<?>) Arrays.asList(objArr));
    }

    public void printRecords(ResultSet resultSet) throws SQLException, IOException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object object = resultSet.getObject(i);
                if (object instanceof Clob) {
                    object = ((Clob) object).getCharacterStream();
                }
                print(object);
            }
            println();
        }
    }

    public void printRecord(Object... objArr) throws IOException {
        printRecord((Iterable<?>) Arrays.asList(objArr));
    }

    public synchronized void printRecord(Stream<?> stream) throws IOException {
        stream.forEachOrdered(new d(this));
        println();
    }

    public void printRecords(ResultSet resultSet, boolean z) throws SQLException, IOException {
        if (z) {
            printHeaders(resultSet);
        }
        printRecords(resultSet);
    }

    public void printRecords(Stream<?> stream) throws IOException {
        stream.forEachOrdered(new c(this));
    }
}
