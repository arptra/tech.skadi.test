package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    public static HashMap b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap f556a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor((Class[]) null));
            b.put("KeyPosition", KeyPosition.class.getConstructor((Class[]) null));
            b.put("KeyCycle", KeyCycle.class.getConstructor((Class[]) null));
            b.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor((Class[]) null));
            b.put("KeyTrigger", KeyTrigger.class.getConstructor((Class[]) null));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public KeyFrames() {
    }

    public void a(MotionController motionController) {
        ArrayList arrayList = (ArrayList) this.f556a.get(-1);
        if (arrayList != null) {
            motionController.b(arrayList);
        }
    }

    public void b(MotionController motionController) {
        ArrayList arrayList = (ArrayList) this.f556a.get(Integer.valueOf(motionController.c));
        if (arrayList != null) {
            motionController.b(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) this.f556a.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                if (key.f(((ConstraintLayout.LayoutParams) motionController.b.getLayoutParams()).c0)) {
                    motionController.a(key);
                }
            }
        }
    }

    public void c(Key key) {
        if (!this.f556a.containsKey(Integer.valueOf(key.b))) {
            this.f556a.put(Integer.valueOf(key.b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.f556a.get(Integer.valueOf(key.b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList d(int i) {
        return (ArrayList) this.f556a.get(Integer.valueOf(i));
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap hashMap;
        HashMap hashMap2;
        Exception e;
        Key key;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (b.containsKey(name)) {
                        try {
                            Constructor constructor = (Constructor) b.get(name);
                            if (constructor != null) {
                                key = (Key) constructor.newInstance((Object[]) null);
                                try {
                                    key.e(context, Xml.asAttributeSet(xmlPullParser));
                                    c(key);
                                } catch (Exception e2) {
                                    e = e2;
                                    Log.e("KeyFrames", "unable to create ", e);
                                    key2 = key;
                                    eventType = xmlPullParser.next();
                                }
                                key2 = key;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e3) {
                            Key key3 = key2;
                            e = e3;
                            key = key3;
                            Log.e("KeyFrames", "unable to create ", e);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (!(key2 == null || (hashMap2 = key2.e) == null)) {
                            ConstraintAttribute.i(context, xmlPullParser, hashMap2);
                        }
                    } else if (!(!name.equalsIgnoreCase("CustomMethod") || key2 == null || (hashMap = key2.e) == null)) {
                        ConstraintAttribute.i(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
