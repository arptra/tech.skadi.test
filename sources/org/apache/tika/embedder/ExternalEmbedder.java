package org.apache.tika.embedder;

import com.honey.account.hc.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.external.ExternalParser;

public class ExternalEmbedder implements Embedder {
    public static final String METADATA_COMMAND_ARGUMENTS_SERIALIZED_TOKEN = "${METADATA_SERIALIZED}";
    public static final String METADATA_COMMAND_ARGUMENTS_TOKEN = "${METADATA}";
    private static final long serialVersionUID = -2828829275642475697L;
    private String[] command = {"sed", "-e", "$a\\\n${METADATA_SERIALIZED}", ExternalParser.INPUT_FILE_TOKEN};
    private String commandAppendOperator = "=";
    private String commandAssignmentDelimeter = ", ";
    private String commandAssignmentOperator = "=";
    private Map<Property, String[]> metadataCommandArguments = null;
    private boolean quoteAssignmentValues = false;
    private Set<MediaType> supportedEmbedTypes = Collections.emptySet();
    private final TemporaryResources tmp = new TemporaryResources();

    public static boolean check(String str, int... iArr) {
        return check(new String[]{str}, iArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$multiThreadedStreamCopy$0(InputStream inputStream, OutputStream outputStream) {
        try {
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            PrintStream printStream = System.out;
            printStream.println("ERROR: " + e.getMessage());
        }
    }

    private void multiThreadedStreamCopy(InputStream inputStream, OutputStream outputStream) {
        new Thread(new a(inputStream, outputStream)).start();
    }

    private void sendInputStreamToStdIn(InputStream inputStream, Process process) {
        multiThreadedStreamCopy(inputStream, process.getOutputStream());
    }

    private void sendStdErrToOutputStream(Process process, OutputStream outputStream) {
        multiThreadedStreamCopy(process.getErrorStream(), outputStream);
    }

    private void sendStdOutToOutputStream(Process process, OutputStream outputStream) {
        try {
            IOUtils.copy(process.getInputStream(), outputStream);
        } catch (IOException e) {
            PrintStream printStream = System.out;
            printStream.println("ERROR: " + e.getMessage());
        }
    }

    public static String serializeMetadata(List<String> list) {
        return list != null ? Arrays.toString(list.toArray()) : "";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:56|57|58|59|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0110 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void embed(org.apache.tika.metadata.Metadata r20, java.io.InputStream r21, java.io.OutputStream r22, org.apache.tika.parser.ParseContext r23) throws java.io.IOException, org.apache.tika.exception.TikaException {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            java.lang.String r2 = "\nExecutable Error:\n\n"
            java.lang.String r3 = "There was an error executing the command line\nExecutable Command:\n\n"
            java.util.Map<org.apache.tika.metadata.Property, java.lang.String[]> r4 = r0.metadataCommandArguments
            if (r4 == 0) goto L_0x0014
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0014
            r4 = 1
            goto L_0x0015
        L_0x0014:
            r4 = 0
        L_0x0015:
            org.apache.tika.io.TikaInputStream r7 = org.apache.tika.io.TikaInputStream.d(r21)
            r8 = 0
            if (r4 == 0) goto L_0x0021
            java.util.List r9 = r19.getCommandMetadataSegments(r20)
            goto L_0x0022
        L_0x0021:
            r9 = r8
        L_0x0022:
            java.lang.String[] r10 = r0.command
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            int r12 = r10.length
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 1
        L_0x0031:
            java.lang.String r5 = "${METADATA_SERIALIZED}"
            if (r13 >= r12) goto L_0x008c
            r6 = r10[r13]
            r20 = r10
            java.lang.String r10 = "${INPUT}"
            boolean r18 = r6.contains(r10)
            if (r18 == 0) goto L_0x0052
            java.io.File r16 = r7.u()
            r18 = r12
            java.lang.String r12 = r16.toString()
            java.lang.String r6 = r6.replace(r10, r12)
            r16 = 0
            goto L_0x0054
        L_0x0052:
            r18 = r12
        L_0x0054:
            java.lang.String r10 = "${OUTPUT}"
            boolean r12 = r6.contains(r10)
            if (r12 == 0) goto L_0x006c
            org.apache.tika.io.TemporaryResources r8 = r0.tmp
            java.io.File r8 = r8.i()
            java.lang.String r12 = r8.toString()
            java.lang.String r6 = r6.replace(r10, r12)
            r17 = 0
        L_0x006c:
            boolean r5 = r6.contains(r5)
            if (r5 == 0) goto L_0x0073
            r14 = 1
        L_0x0073:
            java.lang.String r5 = "${METADATA}"
            boolean r5 = r6.contains(r5)
            if (r5 == 0) goto L_0x0082
            if (r4 == 0) goto L_0x0080
            r11.addAll(r9)
        L_0x0080:
            r15 = 1
            goto L_0x0085
        L_0x0082:
            r11.add(r6)
        L_0x0085:
            int r13 = r13 + 1
            r10 = r20
            r12 = r18
            goto L_0x0031
        L_0x008c:
            if (r4 == 0) goto L_0x00bc
            if (r14 == 0) goto L_0x00b5
            java.util.Iterator r4 = r11.iterator()
            r6 = 0
        L_0x0095:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x00bc
            java.lang.Object r10 = r4.next()
            java.lang.String r10 = (java.lang.String) r10
            boolean r12 = r10.contains(r5)
            if (r12 == 0) goto L_0x00b2
            java.lang.String r12 = serializeMetadata(r9)
            java.lang.String r10 = r10.replace(r5, r12)
            r11.set(r6, r10)
        L_0x00b2:
            int r6 = r6 + 1
            goto L_0x0095
        L_0x00b5:
            if (r15 != 0) goto L_0x00bc
            if (r14 != 0) goto L_0x00bc
            r11.addAll(r9)
        L_0x00bc:
            java.lang.Object[] r4 = r11.toArray()
            int r4 = r4.length
            r5 = 1
            if (r4 != r5) goto L_0x00d8
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            r5 = 0
            java.lang.String[] r6 = new java.lang.String[r5]
            java.lang.Object[] r6 = r11.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            r5 = r6[r5]
            java.lang.Process r4 = r4.exec(r5)
            goto L_0x00e9
        L_0x00d8:
            r5 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r5 = r11.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.lang.Process r4 = r4.exec(r5)
        L_0x00e9:
            org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream r5 = new org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream
            r5.<init>()
            r0.sendStdErrToOutputStream(r4, r5)     // Catch:{ all -> 0x00f9 }
            if (r16 == 0) goto L_0x00fb
            r6 = r21
            r0.sendInputStreamToStdIn(r6, r4)     // Catch:{ all -> 0x00f9 }
            goto L_0x0102
        L_0x00f9:
            r0 = move-exception
            goto L_0x0157
        L_0x00fb:
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ all -> 0x00f9 }
            r6.close()     // Catch:{ all -> 0x00f9 }
        L_0x0102:
            if (r17 == 0) goto L_0x0108
            r0.sendStdOutToOutputStream(r4, r1)     // Catch:{ all -> 0x00f9 }
            goto L_0x0117
        L_0x0108:
            org.apache.tika.io.TemporaryResources r0 = r0.tmp     // Catch:{ all -> 0x00f9 }
            r0.dispose()     // Catch:{ all -> 0x00f9 }
            r4.waitFor()     // Catch:{ InterruptedException -> 0x0110 }
        L_0x0110:
            org.apache.tika.io.TikaInputStream r0 = org.apache.tika.io.TikaInputStream.b(r8)     // Catch:{ all -> 0x00f9 }
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r1)     // Catch:{ all -> 0x00f9 }
        L_0x0117:
            if (r17 == 0) goto L_0x011d
            r4.waitFor()     // Catch:{ InterruptedException -> 0x0120 }
            goto L_0x0120
        L_0x011d:
            r8.delete()     // Catch:{  }
        L_0x0120:
            if (r16 != 0) goto L_0x0125
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r7)
        L_0x0125:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r22)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r5)
            int r0 = r4.exitValue()
            if (r0 != 0) goto L_0x0132
            return
        L_0x0132:
            org.apache.tika.exception.TikaException r0 = new org.apache.tika.exception.TikaException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r11)
            r1.append(r2)
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r2 = r2.name()
            java.lang.String r2 = r5.toString((java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0157:
            if (r17 == 0) goto L_0x015d
            r4.waitFor()     // Catch:{ InterruptedException -> 0x0160 }
            goto L_0x0160
        L_0x015d:
            r8.delete()     // Catch:{  }
        L_0x0160:
            if (r16 != 0) goto L_0x0165
            org.apache.commons.io.IOUtils.closeQuietly((java.io.InputStream) r7)
        L_0x0165:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r22)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r5)
            int r1 = r4.exitValue()
            if (r1 == 0) goto L_0x0196
            org.apache.tika.exception.TikaException r0 = new org.apache.tika.exception.TikaException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r11)
            r1.append(r2)
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r2 = r2.name()
            java.lang.String r2 = r5.toString((java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0196:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.embedder.ExternalEmbedder.embed(org.apache.tika.metadata.Metadata, java.io.InputStream, java.io.OutputStream, org.apache.tika.parser.ParseContext):void");
    }

    public String[] getCommand() {
        return this.command;
    }

    public String getCommandAppendOperator() {
        return this.commandAppendOperator;
    }

    public String getCommandAssignmentDelimeter() {
        return this.commandAssignmentDelimeter;
    }

    public String getCommandAssignmentOperator() {
        return this.commandAssignmentOperator;
    }

    public List<String> getCommandMetadataSegments(Metadata metadata) {
        String[] strArr;
        Iterator<Property> it;
        int i;
        String[] strArr2;
        Metadata metadata2 = metadata;
        ArrayList arrayList = new ArrayList();
        if (!(metadata2 == null || metadata.names() == null)) {
            String[] names = metadata.names();
            int length = names.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = names[i2];
                Iterator<Property> it2 = getMetadataCommandArguments().keySet().iterator();
                while (it2.hasNext()) {
                    Property next = it2.next();
                    if (str.equals(next.getName()) && (strArr = getMetadataCommandArguments().get(next)) != null) {
                        int length2 = strArr.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            String str2 = strArr[i3];
                            if (metadata2.isMultiValued(str)) {
                                String[] values = metadata2.getValues(str);
                                int length3 = values.length;
                                int i4 = 0;
                                while (true) {
                                    strArr2 = names;
                                    if (i4 >= length3) {
                                        break;
                                    }
                                    String str3 = values[i4];
                                    int i5 = length;
                                    if (this.quoteAssignmentValues) {
                                        str3 = "'" + str3 + "'";
                                    }
                                    arrayList.add(str2 + this.commandAppendOperator + str3);
                                    i4++;
                                    names = strArr2;
                                    length = i5;
                                    it2 = it2;
                                }
                                i = length;
                                it = it2;
                            } else {
                                strArr2 = names;
                                i = length;
                                it = it2;
                                String str4 = metadata2.get(str);
                                if (this.quoteAssignmentValues) {
                                    str4 = "'" + str4 + "'";
                                }
                                arrayList.add(str2 + this.commandAssignmentOperator + str4);
                            }
                            i3++;
                            names = strArr2;
                            length = i;
                            it2 = it;
                        }
                    }
                    names = names;
                    length = length;
                    it2 = it2;
                }
                String[] strArr3 = names;
                int i6 = length;
            }
        }
        return arrayList;
    }

    public Map<Property, String[]> getMetadataCommandArguments() {
        return this.metadataCommandArguments;
    }

    public Set<MediaType> getSupportedEmbedTypes(ParseContext parseContext) {
        return getSupportedEmbedTypes();
    }

    public boolean isQuoteAssignmentValues() {
        return this.quoteAssignmentValues;
    }

    public void setCommand(String... strArr) {
        this.command = strArr;
    }

    public void setCommandAppendOperator(String str) {
        this.commandAppendOperator = str;
    }

    public void setCommandAssignmentDelimeter(String str) {
        this.commandAssignmentDelimeter = str;
    }

    public void setCommandAssignmentOperator(String str) {
        this.commandAssignmentOperator = str;
    }

    public void setMetadataCommandArguments(Map<Property, String[]> map) {
        this.metadataCommandArguments = map;
    }

    public void setQuoteAssignmentValues(boolean z) {
        this.quoteAssignmentValues = z;
    }

    public void setSupportedEmbedTypes(Set<MediaType> set) {
        this.supportedEmbedTypes = Collections.unmodifiableSet(new HashSet(set));
    }

    public static boolean check(String[] strArr, int... iArr) {
        Process process;
        if (iArr.length == 0) {
            iArr = new int[]{127};
        }
        try {
            if (strArr.length == 1) {
                process = Runtime.getRuntime().exec(strArr[0]);
            } else {
                process = Runtime.getRuntime().exec(strArr);
            }
            int waitFor = process.waitFor();
            for (int i : iArr) {
                if (waitFor == i) {
                    return false;
                }
            }
            return true;
        } catch (IOException | InterruptedException unused) {
            return false;
        }
    }

    public Set<MediaType> getSupportedEmbedTypes() {
        return this.supportedEmbedTypes;
    }
}
