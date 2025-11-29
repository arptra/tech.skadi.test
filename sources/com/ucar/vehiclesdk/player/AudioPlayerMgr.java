package com.ucar.vehiclesdk.player;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.k3.a;
import com.honey.account.k3.b;
import com.honey.account.k3.c;
import com.honey.account.k3.d;
import com.honey.account.k3.e;
import com.honey.account.k3.f;
import com.honey.account.k3.g;
import com.ucar.vehiclesdk.MDevice;
import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.audio.UCarAudioManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AudioPlayerMgr {

    /* renamed from: a  reason: collision with root package name */
    public final Map f5460a;
    public final Map b;
    public final Map c;
    public final Map d;
    public volatile boolean e;
    public volatile boolean f;
    public long g;
    public final AudioManager h;
    public final UCarAudioManager.IUCarAudioListener i;
    public AudioFocusState j;
    public final Handler k;
    public int l;
    public final Context m;
    public String n;
    public boolean o;

    /* renamed from: com.ucar.vehiclesdk.player.AudioPlayerMgr$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5461a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ucar.vehiclesdk.audio.UCarAudioManager$PlayerState[] r0 = com.ucar.vehiclesdk.audio.UCarAudioManager.PlayerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5461a = r0
                com.ucar.vehiclesdk.audio.UCarAudioManager$PlayerState r1 = com.ucar.vehiclesdk.audio.UCarAudioManager.PlayerState.START_PLAYER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5461a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ucar.vehiclesdk.audio.UCarAudioManager$PlayerState r1 = com.ucar.vehiclesdk.audio.UCarAudioManager.PlayerState.RESUME_PLAYER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5461a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ucar.vehiclesdk.audio.UCarAudioManager$PlayerState r1 = com.ucar.vehiclesdk.audio.UCarAudioManager.PlayerState.PAUSE_PLAYER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5461a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ucar.vehiclesdk.audio.UCarAudioManager$PlayerState r1 = com.ucar.vehiclesdk.audio.UCarAudioManager.PlayerState.STOP_PLAYER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerMgr.AnonymousClass1.<clinit>():void");
        }
    }

    public class AudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final AudioFocusState f5462a;
        public final List b;
        public final UCarCommon.AudioAttributes c;

        public /* synthetic */ AudioFocusChangeListener(AudioPlayerMgr audioPlayerMgr, AudioFocusState audioFocusState, UCarCommon.AudioAttributes audioAttributes, UCarCommon.AudioType audioType, AnonymousClass1 r5) {
            this(audioFocusState, audioAttributes, audioType);
        }

        public final void e(UCarCommon.AudioType audioType) {
            if (!this.b.contains(audioType)) {
                this.b.add(audioType);
                AudioPlayerMgr.this.H(this.b, 1);
            }
        }

        public final /* synthetic */ void f(int i) {
            EasyLog.a("AudioPlayerMgr", "onAudioFocusChange, audioTypes: " + this.b + " new focus: " + i);
            if (this.b.isEmpty()) {
                EasyLog.i("AudioPlayerMgr", "player has been released, no need notify audio focus change event.");
                return;
            }
            if (i == -3) {
                EasyLog.a("AudioPlayerMgr", "onAudioFocus loss transient can duck, need pause or lower the volume");
            } else if (i == -2) {
                EasyLog.a("AudioPlayerMgr", "onAudioFocus loss transient, need pause");
                AudioPlayerMgr.this.t(this.c, this.f5462a, true);
            } else if (i == -1) {
                EasyLog.a("AudioPlayerMgr", "onAudioFocus loss, need stop");
                AudioPlayerMgr.this.t(this.c, this.f5462a, false);
            } else if (i != 1) {
                EasyLog.a("AudioPlayerMgr", "onAudioFocusChange:" + i);
            } else {
                EasyLog.a("AudioPlayerMgr", "onAudioFocus gain, now play");
                AudioPlayerMgr.this.s(this.c, this.f5462a);
            }
            AudioPlayerMgr.this.H(this.b, i);
        }

        public void onAudioFocusChange(int i) {
            AudioPlayerMgr.this.k.post(new b(this, i));
        }

        public AudioFocusChangeListener(AudioFocusState audioFocusState, UCarCommon.AudioAttributes audioAttributes, UCarCommon.AudioType audioType) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.f5462a = audioFocusState;
            arrayList.add(audioType);
            this.c = audioAttributes;
        }
    }

    public static class AudioFocusState {

        /* renamed from: a  reason: collision with root package name */
        public AudioFocusChangeListener f5463a;
        public AudioFocusRequest b;
        public boolean c;
        public boolean d;

        public AudioFocusState() {
        }

        public /* synthetic */ AudioFocusState(AnonymousClass1 r1) {
            this();
        }
    }

    public static String r(UCarCommon.AudioAttributes audioAttributes) {
        return audioAttributes.e() + AccountConstantKt.DEFAULT_SEGMENT + audioAttributes.c().getUsage() + AccountConstantKt.DEFAULT_SEGMENT + audioAttributes.c().getContentType();
    }

    public final /* synthetic */ void A(int i2, UCarCommon.AudioType audioType) {
        this.i.a(audioType, i2);
    }

    public final /* synthetic */ void B(boolean z) {
        this.o = z;
        AudioPlayerV2 q = q(UCarCommon.AudioType.STREAM_CAST_MUSIC);
        if (q != null) {
            q.i(z);
        }
    }

    public final /* synthetic */ void C() {
        EasyLog.a("AudioPlayerMgr", "stopAndClearAudioPlayers");
        for (AudioPlayerV2 audioPlayerV2 : this.f5460a.values()) {
            if (audioPlayerV2 != null) {
                audioPlayerV2.j();
                audioPlayerV2.g();
            }
        }
        this.f5460a.clear();
        this.c.clear();
        i();
        this.l = 0;
        this.o = false;
    }

    public final /* synthetic */ void D(UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        if (audioPlayerControl.a() == UCarCommon.AudioType.STREAM_UNDEFINED) {
            for (Map.Entry key : this.f5460a.entrySet()) {
                Q((UCarCommon.AudioType) key.getKey(), audioPlayerControl.b(), audioPlayerControl.c());
            }
        } else {
            if (audioPlayerControl.a() == UCarCommon.AudioType.STREAM_CAST_MUSIC) {
                M(audioPlayerControl.d());
            }
            Q(audioPlayerControl.a(), audioPlayerControl.b(), audioPlayerControl.c());
        }
        this.b.put(audioPlayerControl.a(), audioPlayerControl);
    }

    public final /* synthetic */ void E(UCarCommon.AudioType audioType, ByteBuffer byteBuffer) {
        AudioFocusChangeListener audioFocusChangeListener;
        AudioPlayerV2 q = q(audioType);
        if (q != null) {
            UCarCommon.AudioAttributes audioAttributes = (UCarCommon.AudioAttributes) this.c.get(audioType);
            if (audioAttributes != null) {
                String r = r(audioAttributes);
                AudioFocusState audioFocusState = (AudioFocusState) this.d.get(r);
                if (audioFocusState == null) {
                    audioFocusState = new AudioFocusState((AnonymousClass1) null);
                    this.d.put(r, audioFocusState);
                }
                if (audioAttributes.e() != 1) {
                    boolean z = audioFocusState.c;
                    if (!z && !audioFocusState.d) {
                        J(audioType, audioFocusState, audioAttributes);
                    } else if (z && (audioFocusChangeListener = audioFocusState.f5463a) != null) {
                        audioFocusChangeListener.e(audioType);
                    }
                } else if (audioFocusState.c) {
                    AudioFocusChangeListener audioFocusChangeListener2 = audioFocusState.f5463a;
                    if (audioFocusChangeListener2 != null) {
                        audioFocusChangeListener2.e(audioType);
                    }
                } else if (!v()) {
                    J(audioType, audioFocusState, audioAttributes);
                } else {
                    return;
                }
                if (audioFocusState.c) {
                    q.l(byteBuffer);
                    return;
                }
            }
            EasyLog.e("AudioPlayerMgr", "no focus, drop data, type = " + audioType);
            return;
        }
        EasyLog.e("AudioPlayerMgr", "no player, drop data, type = " + audioType);
    }

    public void F(UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat, UCarAudioManager.PlayerState playerState, UCarCommon.AudioAttributes audioAttributes, boolean z) {
        this.k.post(new g(this, audioFormat, audioType, playerState, audioAttributes, z));
    }

    public final void G(UCarCommon.AudioType audioType, int i2) {
        if (this.i != null) {
            EasyLog.a("AudioPlayerMgr", "notifyAudioFocusChanged, audioType: " + audioType + ", focusChange: " + i2);
            this.i.a(audioType, i2);
        }
    }

    public final void H(List list, int i2) {
        if (this.i != null) {
            EasyLog.a("AudioPlayerMgr", "notifyAudioFocusChanged, audioTypes: " + list + ", focusChange: " + i2);
            list.forEach(new a(this, i2));
        }
    }

    public final void I(UCarCommon.AudioType audioType) {
        AudioPlayerV2 audioPlayerV2 = (AudioPlayerV2) this.f5460a.get(audioType);
        if (audioPlayerV2 != null) {
            audioPlayerV2.e();
            EasyLog.a("AudioPlayerMgr", "pausePlayer, audioType: " + audioType);
        }
    }

    public final void J(UCarCommon.AudioType audioType, AudioFocusState audioFocusState, UCarCommon.AudioAttributes audioAttributes) {
        EasyLog.a("AudioPlayerMgr", "requestAudioFocus, type: " + audioType);
        G(audioType, 0);
        if (audioFocusState.b == null) {
            AudioFocusChangeListener audioFocusChangeListener = new AudioFocusChangeListener(this, audioFocusState, audioAttributes, audioType, (AnonymousClass1) null);
            audioFocusState.b = new AudioFocusRequest.Builder(audioAttributes.e()).setAudioAttributes(audioAttributes.c()).setOnAudioFocusChangeListener(audioFocusChangeListener).build();
            audioFocusState.f5463a = audioFocusChangeListener;
        }
        int requestAudioFocus = (audioAttributes.e() != 1 || this.e) ? this.h.requestAudioFocus(audioFocusState.b) : -1;
        if (requestAudioFocus == 1) {
            s(audioAttributes, audioFocusState);
            H(audioFocusState.f5463a.b, 1);
            return;
        }
        if (requestAudioFocus == 0) {
            u(audioAttributes, audioFocusState);
        }
        H(audioFocusState.f5463a.b, requestAudioFocus == -1 ? -6 : -4);
    }

    public final void K(UCarCommon.AudioType audioType) {
        AudioPlayerV2 audioPlayerV2 = (AudioPlayerV2) this.f5460a.get(audioType);
        if (audioPlayerV2 != null) {
            audioPlayerV2.h();
            EasyLog.a("AudioPlayerMgr", "resumePlayer, audioType: " + audioType);
        }
    }

    public final void L() {
        this.g = SystemClock.uptimeMillis();
        UCarAdapter R0 = UCarAdapter.R0();
        UCarCommon.KeyEventActionType keyEventActionType = UCarCommon.KeyEventActionType.KEY_EVENT_ACTION_DOWN;
        UCarCommon.KeyCodeType keyCodeType = UCarCommon.KeyCodeType.KEY_CODE_MEDIA_PAUSE;
        R0.i2(keyEventActionType, keyCodeType, 0);
        UCarAdapter.R0().i2(UCarCommon.KeyEventActionType.KEY_EVENT_ACTION_UP, keyCodeType, 0);
    }

    public final void M(boolean z) {
        this.k.post(new e(this, z));
    }

    public void N() {
        this.k.post(new d(this));
    }

    public final void O(UCarCommon.AudioType audioType) {
        AudioFocusChangeListener audioFocusChangeListener;
        EasyLog.a("AudioPlayerMgr", "stopPlayer, audioType: " + audioType);
        AudioPlayerV2 audioPlayerV2 = (AudioPlayerV2) this.f5460a.remove(audioType);
        if (audioPlayerV2 != null) {
            audioPlayerV2.j();
            audioPlayerV2.g();
            UCarCommon.AudioAttributes audioAttributes = (UCarCommon.AudioAttributes) this.c.remove(audioType);
            if (audioAttributes != null) {
                String r = r(audioAttributes);
                AudioFocusState audioFocusState = (AudioFocusState) this.d.get(r);
                if (audioFocusState != null && (audioFocusChangeListener = audioFocusState.f5463a) != null && audioFocusChangeListener.b.contains(audioType)) {
                    if (audioFocusState.f5463a.b.size() != 1) {
                        G(audioType, -5);
                        audioFocusState.f5463a.b.remove(audioType);
                    } else if (j(audioFocusState)) {
                        audioFocusState.f5463a.b.remove(audioType);
                        this.d.remove(r);
                        if (audioAttributes.e() == 1) {
                            this.g = 0;
                        }
                    }
                }
            }
        }
    }

    public final void P(UCarCommon.AudioAttributes audioAttributes) {
        if (audioAttributes.g() && this.h.getMode() == 3 && this.f) {
            this.h.setMode(0);
        }
    }

    public final void Q(UCarCommon.AudioType audioType, int i2, int i3) {
        AudioPlayerV2 q = q(audioType);
        if (q == null) {
            EasyLog.i("AudioPlayerMgr", "player is not created: " + audioType);
        } else if (audioType == UCarCommon.AudioType.STREAM_CAST_MUSIC) {
            q.k(i2, this.l, i3);
        } else {
            q.k(i2, 0, i3);
        }
    }

    public void R(UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        this.k.post(new c(this, audioPlayerControl));
    }

    public void S(UCarCommon.AudioType audioType, ByteBuffer byteBuffer) {
        this.k.post(new b(this, audioType, byteBuffer));
    }

    public boolean i() {
        f fVar = new f(this);
        if (Thread.currentThread() == this.k.getLooper().getThread()) {
            fVar.run();
            return true;
        }
        this.k.post(fVar);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r6.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(com.ucar.vehiclesdk.player.AudioPlayerMgr.AudioFocusState r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000e
            android.media.AudioFocusRequest r1 = r6.b
            if (r1 == 0) goto L_0x000e
            android.media.AudioManager r2 = r5.h
            int r1 = r2.abandonAudioFocusRequest(r1)
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            r2 = 1
            java.lang.String r3 = "AudioPlayerMgr"
            if (r1 != r2) goto L_0x0044
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "abandon audio focus succeed, audioAttributes: "
            r1.append(r4)
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r4 = r6.f5463a
            com.ucar.vehiclesdk.UCarCommon$AudioAttributes r4 = r4.c
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.easy.logger.EasyLog.a(r3, r1)
            r6.c = r0
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r0 = r6.f5463a
            com.ucar.vehiclesdk.UCarCommon$AudioAttributes r0 = r0.c
            r5.P(r0)
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r6 = r6.f5463a
            java.util.List r6 = r6.b
            r0 = -5
            r5.H(r6, r0)
            return r2
        L_0x0044:
            if (r6 == 0) goto L_0x0065
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r5 = r6.f5463a
            if (r5 == 0) goto L_0x0065
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "abandon audio focus failed, audioAttributes: "
            r5.append(r1)
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r6 = r6.f5463a
            com.ucar.vehiclesdk.UCarCommon$AudioAttributes r6 = r6.c
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.easy.logger.EasyLog.c(r3, r5)
            goto L_0x006a
        L_0x0065:
            java.lang.String r5 = "abandon audio focus failed"
            com.easy.logger.EasyLog.c(r3, r5)
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerMgr.j(com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState):boolean");
    }

    public void o(boolean z) {
        EasyLog.a("AudioPlayerMgr", "allowSetCallMode: " + z);
        this.f = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0078 A[Catch:{ Exception -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081 A[Catch:{ Exception -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(com.ucar.vehiclesdk.UCarCommon.AudioType r17, com.ucar.vehiclesdk.UCarCommon.AudioFormat r18, com.ucar.vehiclesdk.UCarCommon.AudioAttributes r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r9 = r17
            r1 = r19
            java.util.Map r2 = r0.f5460a
            java.lang.Object r2 = r2.get(r9)
            r10 = 0
            r3 = 1
            if (r2 != 0) goto L_0x00d7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "createPlayer, type: "
            r2.append(r4)
            r2.append(r9)
            java.lang.String r4 = ", format: "
            r2.append(r4)
            r5 = r18
            r2.append(r5)
            java.lang.String r4 = ", audioAttributes: "
            r2.append(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r11 = "AudioPlayerMgr"
            com.easy.logger.EasyLog.e(r11, r2)
            if (r1 != 0) goto L_0x0052
            com.ucar.vehiclesdk.UCarCommon$AudioAttributes r1 = new com.ucar.vehiclesdk.UCarCommon$AudioAttributes
            android.media.AudioAttributes$Builder r2 = new android.media.AudioAttributes$Builder
            r2.<init>()
            android.media.AudioAttributes$Builder r2 = r2.setUsage(r3)
            r4 = 2
            android.media.AudioAttributes$Builder r2 = r2.setContentType(r4)
            android.media.AudioAttributes r2 = r2.build()
            r4 = 3
            r1.<init>(r2, r3, r4)
        L_0x0052:
            r12 = r1
            boolean r1 = r12.g()
            if (r1 == 0) goto L_0x005f
            int r1 = r12.d()
        L_0x005d:
            r6 = r1
            goto L_0x006b
        L_0x005f:
            boolean r1 = r12.f()
            if (r1 == 0) goto L_0x006a
            int r1 = r12.a()
            goto L_0x005d
        L_0x006a:
            r6 = r10
        L_0x006b:
            com.ucar.vehiclesdk.player.AudioPlayerV2 r13 = new com.ucar.vehiclesdk.player.AudioPlayerV2     // Catch:{ Exception -> 0x007f }
            android.content.Context r2 = r0.m     // Catch:{ Exception -> 0x007f }
            android.media.AudioAttributes r3 = r12.b()     // Catch:{ Exception -> 0x007f }
            com.ucar.vehiclesdk.UCarCommon$AudioType r14 = com.ucar.vehiclesdk.UCarCommon.AudioType.STREAM_CAST_MUSIC     // Catch:{ Exception -> 0x007f }
            r15 = 0
            if (r9 != r14) goto L_0x0081
            com.ucar.vehiclesdk.player.a r1 = new com.ucar.vehiclesdk.player.a     // Catch:{ Exception -> 0x007f }
            r1.<init>(r0)     // Catch:{ Exception -> 0x007f }
            r8 = r1
            goto L_0x0082
        L_0x007f:
            r0 = move-exception
            goto L_0x00d1
        L_0x0081:
            r8 = r15
        L_0x0082:
            r1 = r13
            r4 = r17
            r5 = r18
            r7 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007f }
            java.util.Map r1 = r0.f5460a
            r1.put(r9, r13)
            java.util.Map r1 = r0.b
            java.lang.Object r1 = r1.get(r9)
            com.ucar.vehiclesdk.audio.UCarAudioManager$AudioPlayerControl r1 = (com.ucar.vehiclesdk.audio.UCarAudioManager.AudioPlayerControl) r1
            if (r1 == 0) goto L_0x00a6
            int r2 = r1.b()
            int r1 = r1.c()
            r0.Q(r9, r2, r1)
        L_0x00a6:
            if (r9 != r14) goto L_0x00ad
            boolean r1 = r0.o
            r13.i(r1)
        L_0x00ad:
            r13.f()
            java.util.Map r1 = r0.c
            r1.put(r9, r12)
            java.lang.String r1 = r(r12)
            java.util.Map r2 = r0.d
            java.lang.Object r2 = r2.get(r1)
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState r2 = (com.ucar.vehiclesdk.player.AudioPlayerMgr.AudioFocusState) r2
            if (r2 == 0) goto L_0x00c6
            r2.d = r10
            goto L_0x00ef
        L_0x00c6:
            java.util.Map r0 = r0.d
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState r2 = new com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState
            r2.<init>(r15)
            r0.put(r1, r2)
            goto L_0x00ef
        L_0x00d1:
            java.lang.String r1 = "create audio player failed."
            com.easy.logger.EasyLog.d(r11, r1, r0)
            return
        L_0x00d7:
            if (r1 == 0) goto L_0x00ef
            int r2 = r19.e()
            if (r2 == r3) goto L_0x00ef
            java.util.Map r0 = r0.d
            java.lang.String r1 = r(r19)
            java.lang.Object r0 = r0.get(r1)
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState r0 = (com.ucar.vehiclesdk.player.AudioPlayerMgr.AudioFocusState) r0
            if (r0 == 0) goto L_0x00ef
            r0.d = r10
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerMgr.p(com.ucar.vehiclesdk.UCarCommon$AudioType, com.ucar.vehiclesdk.UCarCommon$AudioFormat, com.ucar.vehiclesdk.UCarCommon$AudioAttributes, boolean):void");
    }

    public final AudioPlayerV2 q(UCarCommon.AudioType audioType) {
        return (AudioPlayerV2) this.f5460a.get(audioType);
    }

    public final void s(UCarCommon.AudioAttributes audioAttributes, AudioFocusState audioFocusState) {
        int i2 = (audioAttributes.g() || w()) ? 3 : 0;
        if (this.h.getMode() != i2 && this.f) {
            this.h.setMode(i2);
        }
        audioFocusState.c = true;
        if (audioAttributes.g()) {
            this.j = audioFocusState;
        }
        this.h.setSpeakerphoneOn(w());
        for (UCarCommon.AudioType q : audioFocusState.f5463a.b) {
            AudioPlayerV2 q2 = q(q);
            if (q2 != null) {
                q2.h();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r7 == false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(com.ucar.vehiclesdk.UCarCommon.AudioAttributes r5, com.ucar.vehiclesdk.player.AudioPlayerMgr.AudioFocusState r6, boolean r7) {
        /*
            r4 = this;
            int r0 = r5.e()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x000e
            if (r7 != 0) goto L_0x000e
            r4.L()
            goto L_0x0018
        L_0x000e:
            int r0 = r5.e()
            r3 = 3
            if (r0 != r3) goto L_0x0018
            if (r7 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            if (r7 != 0) goto L_0x0021
            r6.c = r1
            r7 = r2 ^ 1
            r6.d = r7
        L_0x0021:
            r4.P(r5)
            if (r2 != 0) goto L_0x004a
            com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusChangeListener r5 = r6.f5463a
            java.util.List r5 = r5.b
            java.util.Iterator r5 = r5.iterator()
        L_0x0030:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x004a
            java.lang.Object r6 = r5.next()
            com.ucar.vehiclesdk.UCarCommon$AudioType r6 = (com.ucar.vehiclesdk.UCarCommon.AudioType) r6
            java.util.Map r7 = r4.f5460a
            java.lang.Object r6 = r7.get(r6)
            com.ucar.vehiclesdk.player.AudioPlayerV2 r6 = (com.ucar.vehiclesdk.player.AudioPlayerV2) r6
            if (r6 == 0) goto L_0x0030
            r6.e()
            goto L_0x0030
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.player.AudioPlayerMgr.t(com.ucar.vehiclesdk.UCarCommon$AudioAttributes, com.ucar.vehiclesdk.player.AudioPlayerMgr$AudioFocusState, boolean):void");
    }

    public final void u(UCarCommon.AudioAttributes audioAttributes, AudioFocusState audioFocusState) {
        if (audioAttributes.e() == 1) {
            Iterator it = this.d.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((AudioFocusState) it.next()).c) {
                        break;
                    }
                } else {
                    L();
                    break;
                }
            }
            for (UCarCommon.AudioType audioType : audioFocusState.f5463a.b) {
                AudioPlayerV2 audioPlayerV2 = (AudioPlayerV2) this.f5460a.get(audioType);
                if (audioPlayerV2 != null) {
                    audioPlayerV2.e();
                }
            }
        }
    }

    public final boolean v() {
        int i2 = (TextUtils.equals(MDevice.MANUFACTURERS_OPPO, this.n) || TextUtils.equals(MDevice.MANUFACTURERS_VIVO, this.n) || TextUtils.equals(MDevice.MANUFACTURERS_XIAOMI, this.n)) ? 4000 : 2000;
        if (SystemClock.uptimeMillis() - this.g >= ((long) i2)) {
            return false;
        }
        EasyLog.i("AudioPlayerMgr", "we should drop audio data if the last focus loss time is less than " + i2 + " ms.");
        return true;
    }

    public final boolean w() {
        AudioFocusState audioFocusState = this.j;
        return (audioFocusState != null && audioFocusState.c) || this.h.getMode() == 3;
    }

    public final /* synthetic */ void x() {
        EasyLog.a("AudioPlayerMgr", "abandonAudioFocus");
        this.e = true;
        this.g = 0;
        for (AudioFocusState j2 : this.d.values()) {
            j(j2);
        }
        this.j = null;
        this.d.clear();
        for (AudioPlayerV2 audioPlayerV2 : this.f5460a.values()) {
            if (audioPlayerV2 != null) {
                audioPlayerV2.e();
            }
        }
    }

    public final /* synthetic */ void y(int i2) {
        this.l = i2;
    }

    public final /* synthetic */ void z(UCarCommon.AudioFormat audioFormat, UCarCommon.AudioType audioType, UCarAudioManager.PlayerState playerState, UCarCommon.AudioAttributes audioAttributes, boolean z) {
        if (audioFormat == null) {
            EasyLog.c("AudioPlayerMgr", "format null");
            return;
        }
        EasyLog.a("AudioPlayerMgr", "managePlayer, type: " + audioType + ", format: " + audioFormat + ", state: " + playerState);
        int i2 = AnonymousClass1.f5461a[playerState.ordinal()];
        if (i2 == 1) {
            p(audioType, audioFormat, audioAttributes, z);
        } else if (i2 == 2) {
            K(audioType);
        } else if (i2 == 3) {
            I(audioType);
        } else if (i2 != 4) {
            EasyLog.c("AudioPlayerMgr", "player state is unknown!");
        } else {
            O(audioType);
        }
    }
}
