package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

public class PAGFont {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3418a = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    private static boolean b = false;
    public String fontFamily;
    public String fontStyle;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f3419a;
        String b;
        int c;
        int d;

        private b() {
            this.f3419a = "";
            this.b = "";
            this.c = 0;
            this.d = CmdCode.CODE_WAKEUP_RECORDING;
        }
    }

    static {
        org.extra.tools.a.e("pag");
    }

    public PAGFont() {
        this.fontFamily = "";
        this.fontStyle = "";
    }

    private static void RegisterFallbackFonts() {
        if (!b) {
            b = true;
            int i = 0;
            b[] bVarArr = new b[0];
            if (new File("/system/etc/fonts.xml").exists()) {
                try {
                    bVarArr = b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    bVarArr = a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            b a2 = a(bVarArr, "zh-Hans");
            if (a2 != null) {
                a(a2, arrayList, arrayList2);
            }
            for (b a3 : bVarArr) {
                a(a3, arrayList, arrayList2);
            }
            if (!arrayList.isEmpty()) {
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                int[] iArr = new int[arrayList2.size()];
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    iArr[i] = ((Integer) it.next()).intValue();
                    i++;
                }
                SetFallbackFontPaths(strArr, iArr);
            }
        }
    }

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i, String str2, String str3);

    public static PAGFont RegisterFont(String str) {
        return RegisterFont(str, 0);
    }

    public static native PAGFont RegisterFont(String str, int i, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i, int i2, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void UnregisterFont(String str, String str2);

    public static void UnregisterFont(PAGFont pAGFont) {
        UnregisterFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    private static b[] a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, (String) null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    a(xmlPullParser, arrayList);
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static b[] b() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, (String) null);
                newPullParser.nextTag();
                return a(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    private static b c(XmlPullParser xmlPullParser) {
        b bVar = new b();
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "index");
        bVar.c = attributeValue == null ? 0 : Integer.parseInt(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "weight");
        bVar.d = attributeValue2 == null ? CmdCode.CODE_WAKEUP_RECORDING : Integer.parseInt(attributeValue2);
        StringBuilder sb = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                d(xmlPullParser);
            }
        }
        bVar.b = "/system/fonts/" + f3418a.matcher(sb).replaceAll("");
        return bVar;
    }

    private static void d(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        return RegisterFont(assetManager, str, 0);
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i) {
        return RegisterFont(assetManager, str, i, "", "");
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    public static PAGFont RegisterFont(String str, int i) {
        return RegisterFont(str, i, "", "");
    }

    private static b[] b(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, (String) null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("family")) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                b(xmlPullParser, arrayList);
                            } else {
                                d(xmlPullParser);
                            }
                        }
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.libpag.PAGFont$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(org.xmlpull.v1.XmlPullParser r6, java.util.ArrayList r7) {
        /*
            java.lang.String r0 = "name"
            r1 = 0
            r6.getAttributeValue(r1, r0)
            java.lang.String r0 = "lang"
            java.lang.String r0 = r6.getAttributeValue(r1, r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0011:
            int r3 = r6.next()
            r4 = 3
            if (r3 == r4) goto L_0x0038
            int r3 = r6.getEventType()
            r4 = 2
            if (r3 == r4) goto L_0x0020
            goto L_0x0011
        L_0x0020:
            java.lang.String r3 = r6.getName()
            java.lang.String r4 = "font"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0034
            org.libpag.PAGFont$b r3 = c(r6)
            r2.add(r3)
            goto L_0x0011
        L_0x0034:
            d(r6)
            goto L_0x0011
        L_0x0038:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x003f
            return
        L_0x003f:
            java.util.Iterator r6 = r2.iterator()
        L_0x0043:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r6.next()
            org.libpag.PAGFont$b r3 = (org.libpag.PAGFont.b) r3
            int r4 = r3.d
            r5 = 400(0x190, float:5.6E-43)
            if (r4 != r5) goto L_0x0043
            r1 = r3
        L_0x0056:
            if (r1 != 0) goto L_0x0060
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            r1 = r6
            org.libpag.PAGFont$b r1 = (org.libpag.PAGFont.b) r1
        L_0x0060:
            java.lang.String r6 = r1.b
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0071
            if (r0 != 0) goto L_0x006c
            java.lang.String r0 = ""
        L_0x006c:
            r1.f3419a = r0
            r7.add(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGFont.a(org.xmlpull.v1.XmlPullParser, java.util.ArrayList):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: org.libpag.PAGFont$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(org.xmlpull.v1.XmlPullParser r4, java.util.ArrayList r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            int r1 = r4.next()
            r2 = 3
            if (r1 == r2) goto L_0x002c
            int r1 = r4.getEventType()
            r2 = 2
            if (r1 == r2) goto L_0x0014
            goto L_0x0005
        L_0x0014:
            java.lang.String r1 = r4.getName()
            java.lang.String r2 = "file"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0028
            org.libpag.PAGFont$b r1 = c(r4)
            r0.add(r1)
            goto L_0x0005
        L_0x0028:
            d(r4)
            goto L_0x0005
        L_0x002c:
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0033
            return
        L_0x0033:
            java.util.Iterator r4 = r0.iterator()
        L_0x0037:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x004a
            java.lang.Object r1 = r4.next()
            org.libpag.PAGFont$b r1 = (org.libpag.PAGFont.b) r1
            int r2 = r1.d
            r3 = 400(0x190, float:5.6E-43)
            if (r2 != r3) goto L_0x0037
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            if (r1 != 0) goto L_0x0055
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            r1 = r4
            org.libpag.PAGFont$b r1 = (org.libpag.PAGFont.b) r1
        L_0x0055:
            java.lang.String r4 = r1.b
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0060
            r5.add(r1)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGFont.b(org.xmlpull.v1.XmlPullParser, java.util.ArrayList):void");
    }

    private static b[] a() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, (String) null);
                newPullParser.nextTag();
                return b(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    private static b a(b[] bVarArr, String str) {
        String lowerCase = str.toLowerCase();
        for (b bVar : bVarArr) {
            if (bVar.f3419a.toLowerCase().equals(lowerCase)) {
                return bVar;
            }
        }
        return null;
    }

    private static void a(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.contains(bVar.b) && new File(bVar.b).exists()) {
            arrayList.add(bVar.b);
            arrayList2.add(Integer.valueOf(bVar.c));
        }
    }
}
