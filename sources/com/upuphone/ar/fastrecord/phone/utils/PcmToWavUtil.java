package com.upuphone.ar.fastrecord.phone.utils;

import android.media.AudioRecord;
import java.io.FileOutputStream;
import java.io.IOException;

public class PcmToWavUtil {
    private static String TAG = "PcmToWavUtil";
    private int mBufferSize;
    private int mChannel;
    private int mSampleRate;

    public PcmToWavUtil(int i, int i2, int i3) {
        this.mSampleRate = i;
        this.mChannel = i2;
        this.mBufferSize = AudioRecord.getMinBufferSize(i, i2, i3);
    }

    private void writeWaveFileHeader(FileOutputStream fileOutputStream, long j, long j2, long j3, int i, long j4) throws IOException {
        byte b = (byte) ((int) ((j2 >> 24) & 255));
        byte b2 = (byte) ((int) ((j4 >> 24) & 255));
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) ((int) (j2 & 255)), (byte) ((int) ((j2 >> 8) & 255)), (byte) ((int) ((j2 >> 16) & 255)), b, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i, 0, (byte) ((int) (j3 & 255)), (byte) ((int) ((j3 >> 8) & 255)), (byte) ((int) ((j3 >> 16) & 255)), (byte) ((int) ((j3 >> 24) & 255)), (byte) ((int) (j4 & 255)), (byte) ((int) ((j4 >> 8) & 255)), (byte) ((int) ((j4 >> 16) & 255)), b2, 4, 0, 16, 0, 100, 97, 116, 97, (byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255))}, 0, 44);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae A[SYNTHETIC, Splitter:B:42:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6 A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A[SYNTHETIC, Splitter:B:54:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e7 A[Catch:{ Exception -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f5 A[SYNTHETIC, Splitter:B:62:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fd A[Catch:{ Exception -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0092=Splitter:B:39:0x0092, B:51:0x00c3=Splitter:B:51:0x00c3} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pcmToWav(java.lang.String r17, java.lang.String r18, java.lang.Boolean r19) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r12 = "pcmToWav error = "
            int r1 = r0.mSampleRate
            long r7 = (long) r1
            boolean r1 = r19.booleanValue()
            if (r1 != 0) goto L_0x0010
            r1 = 2
        L_0x000e:
            r9 = r1
            goto L_0x0012
        L_0x0010:
            r1 = 1
            goto L_0x000e
        L_0x0012:
            int r1 = r0.mSampleRate
            long r1 = (long) r1
            r3 = 16
            long r1 = r1 * r3
            long r3 = (long) r9
            long r1 = r1 * r3
            r3 = 8
            long r10 = r1 / r3
            int r1 = r0.mBufferSize
            byte[] r13 = new byte[r1]
            r1 = 0
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x008c, all -> 0x0087 }
            r2 = r17
            r14.<init>(r2)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x008c, all -> 0x0087 }
            java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0084, IOException -> 0x0081, all -> 0x007d }
            r2 = r18
            r15.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0084, IOException -> 0x0081, all -> 0x007d }
            java.nio.channels.FileChannel r1 = r14.getChannel()     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0053, all -> 0x004e }
            long r3 = r1.size()     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0053, all -> 0x004e }
            r1 = 36
            long r5 = r3 + r1
            r1 = r16
            r2 = r15
            r1.writeWaveFileHeader(r2, r3, r5, r7, r9, r10)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0053, all -> 0x004e }
        L_0x0043:
            int r0 = r14.read(r13)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0053, all -> 0x004e }
            r1 = -1
            if (r0 == r1) goto L_0x005a
            r15.write(r13)     // Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0053, all -> 0x004e }
            goto L_0x0043
        L_0x004e:
            r0 = move-exception
            r2 = r0
        L_0x0050:
            r1 = r14
            goto L_0x00f3
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            r1 = r14
            goto L_0x0092
        L_0x0056:
            r0 = move-exception
        L_0x0057:
            r1 = r14
            goto L_0x00c3
        L_0x005a:
            r14.close()     // Catch:{ Exception -> 0x0062 }
            r15.close()     // Catch:{ Exception -> 0x0062 }
            goto L_0x00f2
        L_0x0062:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x0068:
            r1.append(r12)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = TAG
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            goto L_0x00f2
        L_0x007d:
            r0 = move-exception
            r2 = r0
            r15 = r1
            goto L_0x0050
        L_0x0081:
            r0 = move-exception
            r15 = r1
            goto L_0x0054
        L_0x0084:
            r0 = move-exception
            r15 = r1
            goto L_0x0057
        L_0x0087:
            r0 = move-exception
            r2 = r0
            r15 = r1
            goto L_0x00f3
        L_0x008c:
            r0 = move-exception
            r15 = r1
            goto L_0x0092
        L_0x008f:
            r0 = move-exception
            r15 = r1
            goto L_0x00c3
        L_0x0092:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r2.<init>()     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = "pcmToWav IOException error = "
            r2.append(r3)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00c0 }
            r2.append(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00c0 }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r2)     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b4
        L_0x00b2:
            r0 = move-exception
            goto L_0x00ba
        L_0x00b4:
            if (r15 == 0) goto L_0x00f2
            r15.close()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00f2
        L_0x00ba:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0068
        L_0x00c0:
            r0 = move-exception
            r2 = r0
            goto L_0x00f3
        L_0x00c3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r2.<init>()     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = "pcmToWav FileNotFound error = "
            r2.append(r3)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00c0 }
            r2.append(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00c0 }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r2)     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x00e5
            r1.close()     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00e5
        L_0x00e3:
            r0 = move-exception
            goto L_0x00eb
        L_0x00e5:
            if (r15 == 0) goto L_0x00f2
            r15.close()     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00f2
        L_0x00eb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0068
        L_0x00f2:
            return
        L_0x00f3:
            if (r1 == 0) goto L_0x00fb
            r1.close()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00fb
        L_0x00f9:
            r0 = move-exception
            goto L_0x0101
        L_0x00fb:
            if (r15 == 0) goto L_0x0119
            r15.close()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x0119
        L_0x0101:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = TAG
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
        L_0x0119:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.PcmToWavUtil.pcmToWav(java.lang.String, java.lang.String, java.lang.Boolean):void");
    }
}
