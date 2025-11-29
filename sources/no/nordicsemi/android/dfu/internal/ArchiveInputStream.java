package no.nordicsemi.android.dfu.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead = 0;
    private int bytesReadFromCurrentSource = 0;
    private int bytesReadFromMarkedSource;
    private CRC32 crc32 = new CRC32();
    private byte[] currentSource;
    private Map<String, byte[]> entries = new HashMap();
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0277 A[SYNTHETIC, Splitter:B:100:0x0277] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0210 A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0220 A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0245 A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0255 A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:79:0x0202=Splitter:B:79:0x0202, B:10:0x0033=Splitter:B:10:0x0033} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArchiveInputStream(java.io.InputStream r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.<init>()
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            r0.<init>(r6)
            r5.zipInputStream = r0
            java.util.zip.CRC32 r6 = new java.util.zip.CRC32
            r6.<init>()
            r5.crc32 = r6
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r5.entries = r6
            r6 = 0
            r5.bytesRead = r6
            r5.bytesReadFromCurrentSource = r6
            r5.parseZip(r7)     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.Manifest r7 = r5.manifest     // Catch:{ all -> 0x0060 }
            r1 = 1
            if (r7 == 0) goto L_0x01c0
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r7 = r7.getApplicationInfo()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = " not found."
            if (r7 == 0) goto L_0x0081
            if (r8 == 0) goto L_0x0033
            r7 = r8 & 4
            if (r7 <= 0) goto L_0x0081
        L_0x0033:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r7 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r7 = r7.getApplicationInfo()     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.applicationBytes = r3     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getDatFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.applicationInitBytes = r3     // Catch:{ all -> 0x0060 }
            byte[] r3 = r5.applicationBytes     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0063
            int r7 = r3.length     // Catch:{ all -> 0x0060 }
            r5.applicationSize = r7     // Catch:{ all -> 0x0060 }
            r5.currentSource = r3     // Catch:{ all -> 0x0060 }
            r7 = r1
            goto L_0x0082
        L_0x0060:
            r6 = move-exception
            goto L_0x027f
        L_0x0063:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r8.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "Application file "
            r8.append(r0)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            r8.append(r7)     // Catch:{ all -> 0x0060 }
            r8.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0060 }
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x0081:
            r7 = r6
        L_0x0082:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r3 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r3 = r3.getBootloaderInfo()     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x00e7
            if (r8 == 0) goto L_0x0090
            r3 = r8 & 2
            if (r3 <= 0) goto L_0x00e7
        L_0x0090:
            byte[] r7 = r5.systemInitBytes     // Catch:{ all -> 0x0060 }
            if (r7 != 0) goto L_0x00df
            no.nordicsemi.android.dfu.internal.manifest.Manifest r7 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r7 = r7.getBootloaderInfo()     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.bootloaderBytes = r3     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getDatFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.systemInitBytes = r3     // Catch:{ all -> 0x0060 }
            byte[] r3 = r5.bootloaderBytes     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x00c1
            int r7 = r3.length     // Catch:{ all -> 0x0060 }
            r5.bootloaderSize = r7     // Catch:{ all -> 0x0060 }
            r5.currentSource = r3     // Catch:{ all -> 0x0060 }
            r7 = r1
            goto L_0x00e7
        L_0x00c1:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r8.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "Bootloader file "
            r8.append(r0)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            r8.append(r7)     // Catch:{ all -> 0x0060 }
            r8.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0060 }
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x00df:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = "Manifest: softdevice and bootloader specified. Use softdevice_bootloader instead."
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x00e7:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r3 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r3 = r3.getSoftdeviceInfo()     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0140
            if (r8 == 0) goto L_0x00f5
            r3 = r8 & 1
            if (r3 <= 0) goto L_0x0140
        L_0x00f5:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r7 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.FileInfo r7 = r7.getSoftdeviceInfo()     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.softDeviceBytes = r3     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r7.getDatFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.systemInitBytes = r3     // Catch:{ all -> 0x0060 }
            byte[] r3 = r5.softDeviceBytes     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0122
            int r7 = r3.length     // Catch:{ all -> 0x0060 }
            r5.softDeviceSize = r7     // Catch:{ all -> 0x0060 }
            r5.currentSource = r3     // Catch:{ all -> 0x0060 }
            r7 = r1
            goto L_0x0140
        L_0x0122:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r8.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "SoftDevice file "
            r8.append(r0)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            r8.append(r7)     // Catch:{ all -> 0x0060 }
            r8.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0060 }
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x0140:
            no.nordicsemi.android.dfu.internal.manifest.Manifest r3 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo r3 = r3.getSoftdeviceBootloaderInfo()     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x01b3
            if (r8 == 0) goto L_0x0152
            r3 = r8 & 1
            if (r3 <= 0) goto L_0x01b3
            r8 = r8 & 2
            if (r8 <= 0) goto L_0x01b3
        L_0x0152:
            byte[] r7 = r5.systemInitBytes     // Catch:{ all -> 0x0060 }
            if (r7 != 0) goto L_0x01ab
            no.nordicsemi.android.dfu.internal.manifest.Manifest r7 = r5.manifest     // Catch:{ all -> 0x0060 }
            no.nordicsemi.android.dfu.internal.manifest.SoftDeviceBootloaderFileInfo r7 = r7.getSoftdeviceBootloaderInfo()     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r8 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r8 = r8.get(r3)     // Catch:{ all -> 0x0060 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0060 }
            r5.softDeviceAndBootloaderBytes = r8     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r8 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = r7.getDatFileName()     // Catch:{ all -> 0x0060 }
            java.lang.Object r8 = r8.get(r3)     // Catch:{ all -> 0x0060 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0060 }
            r5.systemInitBytes = r8     // Catch:{ all -> 0x0060 }
            byte[] r8 = r5.softDeviceAndBootloaderBytes     // Catch:{ all -> 0x0060 }
            if (r8 == 0) goto L_0x018d
            int r8 = r7.getSoftdeviceSize()     // Catch:{ all -> 0x0060 }
            r5.softDeviceSize = r8     // Catch:{ all -> 0x0060 }
            int r7 = r7.getBootloaderSize()     // Catch:{ all -> 0x0060 }
            r5.bootloaderSize = r7     // Catch:{ all -> 0x0060 }
            byte[] r7 = r5.softDeviceAndBootloaderBytes     // Catch:{ all -> 0x0060 }
            r5.currentSource = r7     // Catch:{ all -> 0x0060 }
            goto L_0x01b4
        L_0x018d:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r8.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "File "
            r8.append(r0)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r7.getBinFileName()     // Catch:{ all -> 0x0060 }
            r8.append(r7)     // Catch:{ all -> 0x0060 }
            r8.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0060 }
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x01ab:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = "Manifest: The softdevice_bootloader may not be used together with softdevice or bootloader."
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x01b3:
            r1 = r7
        L_0x01b4:
            if (r1 == 0) goto L_0x01b8
            goto L_0x026a
        L_0x01b8:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = "Manifest file must specify at least one file."
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x01c0:
            if (r8 == 0) goto L_0x01c6
            r7 = r8 & 4
            if (r7 <= 0) goto L_0x01f9
        L_0x01c6:
            java.util.Map<java.lang.String, byte[]> r7 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "application.hex"
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0060 }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x0060 }
            r5.applicationBytes = r7     // Catch:{ all -> 0x0060 }
            if (r7 != 0) goto L_0x01e0
            java.util.Map<java.lang.String, byte[]> r7 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "application.bin"
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0060 }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x0060 }
            r5.applicationBytes = r7     // Catch:{ all -> 0x0060 }
        L_0x01e0:
            byte[] r7 = r5.applicationBytes     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x01f9
            int r7 = r7.length     // Catch:{ all -> 0x0060 }
            r5.applicationSize = r7     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r7 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "application.dat"
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0060 }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x0060 }
            r5.applicationInitBytes = r7     // Catch:{ all -> 0x0060 }
            byte[] r7 = r5.applicationBytes     // Catch:{ all -> 0x0060 }
            r5.currentSource = r7     // Catch:{ all -> 0x0060 }
            r7 = r1
            goto L_0x01fa
        L_0x01f9:
            r7 = r6
        L_0x01fa:
            java.lang.String r2 = "system.dat"
            if (r8 == 0) goto L_0x0202
            r3 = r8 & 2
            if (r3 <= 0) goto L_0x0232
        L_0x0202:
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "bootloader.hex"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.bootloaderBytes = r3     // Catch:{ all -> 0x0060 }
            if (r3 != 0) goto L_0x021c
            java.util.Map<java.lang.String, byte[]> r3 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "bootloader.bin"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0060 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0060 }
            r5.bootloaderBytes = r3     // Catch:{ all -> 0x0060 }
        L_0x021c:
            byte[] r3 = r5.bootloaderBytes     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0232
            int r7 = r3.length     // Catch:{ all -> 0x0060 }
            r5.bootloaderSize = r7     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r7 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0060 }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x0060 }
            r5.systemInitBytes = r7     // Catch:{ all -> 0x0060 }
            byte[] r7 = r5.bootloaderBytes     // Catch:{ all -> 0x0060 }
            r5.currentSource = r7     // Catch:{ all -> 0x0060 }
            r7 = r1
        L_0x0232:
            if (r8 == 0) goto L_0x0237
            r8 = r8 & r1
            if (r8 <= 0) goto L_0x0267
        L_0x0237:
            java.util.Map<java.lang.String, byte[]> r8 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "softdevice.hex"
            java.lang.Object r8 = r8.get(r3)     // Catch:{ all -> 0x0060 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0060 }
            r5.softDeviceBytes = r8     // Catch:{ all -> 0x0060 }
            if (r8 != 0) goto L_0x0251
            java.util.Map<java.lang.String, byte[]> r8 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "softdevice.bin"
            java.lang.Object r8 = r8.get(r3)     // Catch:{ all -> 0x0060 }
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0060 }
            r5.softDeviceBytes = r8     // Catch:{ all -> 0x0060 }
        L_0x0251:
            byte[] r8 = r5.softDeviceBytes     // Catch:{ all -> 0x0060 }
            if (r8 == 0) goto L_0x0267
            int r7 = r8.length     // Catch:{ all -> 0x0060 }
            r5.softDeviceSize = r7     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, byte[]> r7 = r5.entries     // Catch:{ all -> 0x0060 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x0060 }
            byte[] r7 = (byte[]) r7     // Catch:{ all -> 0x0060 }
            r5.systemInitBytes = r7     // Catch:{ all -> 0x0060 }
            byte[] r7 = r5.softDeviceBytes     // Catch:{ all -> 0x0060 }
            r5.currentSource = r7     // Catch:{ all -> 0x0060 }
            goto L_0x0268
        L_0x0267:
            r1 = r7
        L_0x0268:
            if (r1 == 0) goto L_0x0277
        L_0x026a:
            r5.mark(r6)     // Catch:{ all -> 0x0060 }
            int r6 = r5.getContentType()
            r5.type = r6
            r0.close()
            return
        L_0x0277:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = "The ZIP file must contain an Application, a Soft Device and/or a Bootloader."
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            throw r6     // Catch:{ all -> 0x0060 }
        L_0x027f:
            int r7 = r5.getContentType()
            r5.type = r7
            java.util.zip.ZipInputStream r5 = r5.zipInputStream
            r5.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                Log.w(TAG, "A directory found in the ZIP: " + name + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = this.zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (name.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, i);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if ("manifest.json".equals(name)) {
                    str = new String(byteArray, "UTF-8");
                } else {
                    this.entries.put(name, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        } else if (str != null) {
            Manifest manifest2 = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
            this.manifest = manifest2;
            if (manifest2 == null) {
                Log.w(TAG, "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
            }
        } else {
            Log.w(TAG, "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
        }
    }

    private int rawRead(@NonNull byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.currentSource;
        int length = bArr2.length;
        int i3 = this.bytesReadFromCurrentSource;
        int i4 = length - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        System.arraycopy(bArr2, i3, bArr, i, i2);
        this.bytesReadFromCurrentSource += i2;
        this.bytesRead += i2;
        this.crc32.update(bArr, i, i2);
        return i2;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 != this.softDeviceBytes || (bArr = this.bootloaderBytes) == null || (this.type & 2) <= 0) {
            bArr = this.applicationBytes;
            if (bArr2 == bArr || bArr == null || (this.type & 4) <= 0) {
                bArr = null;
                this.currentSource = null;
            } else {
                this.currentSource = bArr;
            }
        } else {
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    public int available() {
        int softDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr == null || this.softDeviceSize != 0 || this.bootloaderSize != 0 || (this.type & 3) <= 0) {
            softDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        } else {
            softDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        }
        return softDeviceImageSize - i;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (!(bArr2 == null || (bArr = this.bootloaderBytes) == null || this.currentSource != bArr)) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest2 = this.manifest;
        return manifest2 != null && manifest2.isSecureDfuRequired();
    }

    public void mark(int i) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public void reset() {
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i;
        this.bytesRead = i;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        this.crc32.update(this.currentSource, 0, this.bytesReadFromCurrentSource);
    }

    public int setContentType(int i) {
        byte[] bArr;
        this.type = i;
        int i2 = i & 4;
        if (i2 > 0 && this.applicationBytes == null) {
            this.type = i & -5;
        }
        int i3 = i & 3;
        if (i3 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i3 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((i & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((i & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i2 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    public long skip(long j) {
        return 0;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    public int read(@NonNull byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(@NonNull byte[] bArr, int i, int i2) {
        int rawRead = rawRead(bArr, i, i2);
        return (i2 <= rawRead || startNextFile() == null) ? rawRead : rawRead + rawRead(bArr, i + rawRead, i2 - rawRead);
    }
}
