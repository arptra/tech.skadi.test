package io.flutter.embedding.android;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.wa.h;
import com.honey.account.wa.i;
import com.honey.account.wa.j;
import io.flutter.Log;
import io.flutter.embedding.android.KeyData;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";
    @NonNull
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();
    @NonNull
    private final BinaryMessenger messenger;
    @NonNull
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();
    @NonNull
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();

    /* renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.flutter.embedding.android.KeyData$Type[] r0 = io.flutter.embedding.android.KeyData.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$android$KeyData$Type = r0
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kDown     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kUp     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kRepeat     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.AnonymousClass1.<clinit>():void");
        }
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z ? KeyData.Type.kRepeat : KeyData.Type.kDown;
        }
        if (action == 1) {
            return KeyData.Type.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long getLogicalKey(@NonNull KeyEvent keyEvent) {
        Long l = KeyboardMap.keyCodeToLogical.get(Long.valueOf((long) keyEvent.getKeyCode()));
        return l != null ? l : Long.valueOf(keyOfPlane((long) keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getPhysicalKey(@NonNull KeyEvent keyEvent) {
        long scanCode = (long) keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(keyOfPlane((long) keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
        }
        Long l = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode));
        return l != null ? l : Long.valueOf(keyOfPlane((long) keyEvent.getScanCode(), KeyboardMap.kAndroidPlane));
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014c A[LOOP:2: B:66:0x0146->B:68:0x014c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleEventImpl(@androidx.annotation.NonNull android.view.KeyEvent r18, @androidx.annotation.NonNull io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback r19) {
        /*
            r17 = this;
            r9 = r17
            int r0 = r18.getScanCode()
            r10 = 0
            if (r0 != 0) goto L_0x0010
            int r0 = r18.getKeyCode()
            if (r0 != 0) goto L_0x0010
            return r10
        L_0x0010:
            java.lang.Long r11 = r17.getPhysicalKey(r18)
            java.lang.Long r12 = r17.getLogicalKey(r18)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            io.flutter.embedding.android.KeyboardMap$PressingGoal[] r14 = io.flutter.embedding.android.KeyboardMap.pressingGoals
            int r15 = r14.length
            r8 = r10
        L_0x0021:
            r6 = 1
            if (r8 >= r15) goto L_0x0047
            r1 = r14[r8]
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0031
            r2 = r6
            goto L_0x0032
        L_0x0031:
            r2 = r10
        L_0x0032:
            long r3 = r12.longValue()
            long r5 = r11.longValue()
            r0 = r17
            r7 = r18
            r16 = r8
            r8 = r13
            r0.synchronizePressingKey(r1, r2, r3, r5, r7, r8)
            int r8 = r16 + 1
            goto L_0x0021
        L_0x0047:
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r0 = r9.togglingGoals
            java.util.Collection r0 = r0.values()
            java.util.Iterator r7 = r0.iterator()
        L_0x0051:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r7.next()
            r1 = r0
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r1 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r1
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0069
            r2 = r6
            goto L_0x006a
        L_0x0069:
            r2 = r10
        L_0x006a:
            long r3 = r12.longValue()
            r0 = r17
            r5 = r18
            r0.synchronizeTogglingKey(r1, r2, r3, r5)
            goto L_0x0051
        L_0x0076:
            int r0 = r18.getAction()
            if (r0 == 0) goto L_0x0081
            if (r0 == r6) goto L_0x007f
            return r10
        L_0x007f:
            r7 = r10
            goto L_0x0082
        L_0x0081:
            r7 = r6
        L_0x0082:
            java.util.HashMap<java.lang.Long, java.lang.Long> r0 = r9.pressingRecords
            java.lang.Object r0 = r0.get(r11)
            r2 = r0
            java.lang.Long r2 = (java.lang.Long) r2
            r8 = 0
            if (r7 == 0) goto L_0x00cb
            if (r2 != 0) goto L_0x0093
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kDown
            goto L_0x00a9
        L_0x0093:
            int r0 = r18.getRepeatCount()
            if (r0 <= 0) goto L_0x009c
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kRepeat
            goto L_0x00a9
        L_0x009c:
            r1 = 0
            long r4 = r18.getEventTime()
            r0 = r17
            r3 = r11
            r0.synthesizeEvent(r1, r2, r3, r4)
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kDown
        L_0x00a9:
            io.flutter.embedding.android.KeyboardManager$CharacterCombiner r1 = r9.characterCombiner
            int r2 = r18.getUnicodeChar()
            java.lang.Character r1 = r1.applyCombiningCharacterToBaseCharacter(r2)
            char r1 = r1.charValue()
            if (r1 == 0) goto L_0x00d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x00d1
        L_0x00cb:
            if (r2 != 0) goto L_0x00ce
            return r10
        L_0x00ce:
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kUp
        L_0x00d0:
            r1 = r8
        L_0x00d1:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kRepeat
            if (r0 == r2) goto L_0x00db
            if (r7 == 0) goto L_0x00d8
            r8 = r12
        L_0x00d8:
            r9.updatePressingState(r11, r8)
        L_0x00db:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kDown
            if (r0 != r2) goto L_0x00ee
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r2 = r9.togglingGoals
            java.lang.Object r2 = r2.get(r12)
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r2 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r2
            if (r2 == 0) goto L_0x00ee
            boolean r3 = r2.enabled
            r3 = r3 ^ r6
            r2.enabled = r3
        L_0x00ee:
            io.flutter.embedding.android.KeyData r2 = new io.flutter.embedding.android.KeyData
            r2.<init>()
            int r3 = r18.getSource()
            r4 = 513(0x201, float:7.19E-43)
            if (r3 == r4) goto L_0x011d
            r4 = 1025(0x401, float:1.436E-42)
            if (r3 == r4) goto L_0x0118
            r4 = 16777232(0x1000010, float:2.3509932E-38)
            if (r3 == r4) goto L_0x0113
            r4 = 33554433(0x2000001, float:9.403956E-38)
            if (r3 == r4) goto L_0x010e
            io.flutter.embedding.android.KeyData$DeviceType r3 = io.flutter.embedding.android.KeyData.DeviceType.kKeyboard
            r2.deviceType = r3
            goto L_0x0121
        L_0x010e:
            io.flutter.embedding.android.KeyData$DeviceType r3 = io.flutter.embedding.android.KeyData.DeviceType.kHdmi
            r2.deviceType = r3
            goto L_0x0121
        L_0x0113:
            io.flutter.embedding.android.KeyData$DeviceType r3 = io.flutter.embedding.android.KeyData.DeviceType.kJoystick
            r2.deviceType = r3
            goto L_0x0121
        L_0x0118:
            io.flutter.embedding.android.KeyData$DeviceType r3 = io.flutter.embedding.android.KeyData.DeviceType.kGamepad
            r2.deviceType = r3
            goto L_0x0121
        L_0x011d:
            io.flutter.embedding.android.KeyData$DeviceType r3 = io.flutter.embedding.android.KeyData.DeviceType.kDirectionalPad
            r2.deviceType = r3
        L_0x0121:
            long r3 = r18.getEventTime()
            r2.timestamp = r3
            r2.type = r0
            long r3 = r12.longValue()
            r2.logicalKey = r3
            long r3 = r11.longValue()
            r2.physicalKey = r3
            r2.character = r1
            r2.synthesized = r10
            io.flutter.embedding.android.KeyData$DeviceType r0 = io.flutter.embedding.android.KeyData.DeviceType.kKeyboard
            r2.deviceType = r0
            r0 = r19
            r9.sendKeyEvent(r2, r0)
            java.util.Iterator r0 = r13.iterator()
        L_0x0146:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0156
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0146
        L_0x0156:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.handleEventImpl(android.view.KeyEvent, io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback):boolean");
    }

    private static long keyOfPlane(long j, long j2) {
        return (j & 4294967295L) | j2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                bool = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            Log.w(TAG, "A null reply was received when sending a key event to the framework.");
        }
        onKeyEventHandledCallback.onKeyEventHandled(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$0(KeyboardMap.KeyPair keyPair, long j, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j), keyEvent.getEventTime());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$1(KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(keyPair.physicalKey), keyEvent.getEventTime());
    }

    private void sendKeyEvent(KeyData keyData, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), onKeyEventHandledCallback == null ? null : new h(onKeyEventHandledCallback));
    }

    private void synthesizeEvent(boolean z, Long l, Long l2, long j) {
        KeyData keyData = new KeyData();
        keyData.timestamp = j;
        keyData.type = z ? KeyData.Type.kDown : KeyData.Type.kUp;
        keyData.logicalKey = l.longValue();
        keyData.physicalKey = l2.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        keyData.deviceType = KeyData.DeviceType.kKeyboard;
        if (!(l2.longValue() == 0 || l.longValue() == 0)) {
            if (!z) {
                l = null;
            }
            updatePressingState(l2, l);
        }
        sendKeyEvent(keyData, (KeyboardManager.Responder.OnKeyEventHandledCallback) null);
    }

    public Map<Long, Long> getPressedState() {
        return Collections.unmodifiableMap(this.pressingRecords);
    }

    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (!handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            synthesizeEvent(true, 0L, 0L, 0);
            onKeyEventHandledCallback.onKeyEventHandled(true);
        }
    }

    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z, long j, long j2, KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        KeyboardMap.PressingGoal pressingGoal2 = pressingGoal;
        ArrayList<Runnable> arrayList2 = arrayList;
        KeyboardMap.KeyPair[] keyPairArr = pressingGoal2.keys;
        boolean[] zArr = new boolean[keyPairArr.length];
        Boolean[] boolArr = new Boolean[keyPairArr.length];
        boolean z2 = false;
        int i = 0;
        while (true) {
            KeyboardMap.KeyPair[] keyPairArr2 = pressingGoal2.keys;
            boolean z3 = true;
            if (i >= keyPairArr2.length) {
                break;
            }
            KeyboardMap.KeyPair keyPair = keyPairArr2[i];
            boolean containsKey = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            zArr[i] = containsKey;
            if (keyPair.logicalKey == j) {
                int i2 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        KeyEvent keyEvent2 = keyEvent;
                        boolArr[i] = Boolean.valueOf(zArr[i]);
                    } else if (i2 != 3) {
                        KeyEvent keyEvent3 = keyEvent;
                    } else {
                        if (!z) {
                            arrayList2.add(new j(this, keyPair, keyEvent));
                        } else {
                            KeyEvent keyEvent4 = keyEvent;
                        }
                        boolArr[i] = Boolean.valueOf(zArr[i]);
                    }
                    i++;
                } else {
                    KeyEvent keyEvent5 = keyEvent;
                    boolArr[i] = Boolean.FALSE;
                    if (!z) {
                        arrayList2.add(new i(this, keyPair, j2, keyEvent));
                    }
                }
            } else {
                KeyEvent keyEvent6 = keyEvent;
                if (!z2 && !containsKey) {
                    z3 = false;
                }
            }
            z2 = z3;
            i++;
        }
        KeyEvent keyEvent7 = keyEvent;
        if (z) {
            for (int i3 = 0; i3 < pressingGoal2.keys.length; i3++) {
                if (boolArr[i3] == null) {
                    if (z2) {
                        boolArr[i3] = Boolean.valueOf(zArr[i3]);
                    } else {
                        boolArr[i3] = Boolean.TRUE;
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i4 = 0; i4 < pressingGoal2.keys.length; i4++) {
                if (boolArr[i4] == null) {
                    boolArr[i4] = Boolean.FALSE;
                }
            }
        }
        for (int i5 = 0; i5 < pressingGoal2.keys.length; i5++) {
            if (zArr[i5] != boolArr[i5].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal2.keys[i5];
                synthesizeEvent(boolArr[i5].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z, long j, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey != j && togglingGoal.enabled != z) {
            boolean containsKey = this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
            boolean z2 = !containsKey;
            if (z2) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(z2, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
            if (!z2) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(containsKey, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        }
    }

    public void updatePressingState(@NonNull Long l, @Nullable Long l2) {
        if (l2 != null) {
            if (this.pressingRecords.put(l, l2) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
