package com.upuphone.starrynet.strategy.protocol;

import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.protocol.simpleble.MyvuRingBleProtocol;
import com.upuphone.starrynet.strategy.protocol.simpleble.SimpleBleProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.CarStarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.PadStarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.XRStarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.uupshare.UupShareProtocol;

public class ProtocolManager {
    private final MyvuRingBleProtocol mMyvuRingBleProtocol;
    private final SimpleBleProtocol mSimpleProtocol;
    private final StarryNetProtocol mStarryNetProtocol;
    private final UupShareProtocol mUupShareProtocol;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final ProtocolManager INSTANCE = new ProtocolManager();

        private Holder() {
        }
    }

    public static ProtocolManager getInstance() {
        return Holder.INSTANCE;
    }

    public MyvuRingBleProtocol getMyvuRingBleProtocol() {
        return this.mMyvuRingBleProtocol;
    }

    public SimpleBleProtocol getSimpleProtocol() {
        return this.mSimpleProtocol;
    }

    public StarryNetProtocol getStarryNetProtocol() {
        return this.mStarryNetProtocol;
    }

    public UupShareProtocol getUupShareProtocol() {
        return this.mUupShareProtocol;
    }

    private ProtocolManager() {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (terminalType == 1) {
            this.mStarryNetProtocol = new PhoneStarryNetProtocol();
            this.mUupShareProtocol = new UupShareProtocol();
            this.mMyvuRingBleProtocol = new MyvuRingBleProtocol();
            this.mSimpleProtocol = null;
        } else if (terminalType == 2) {
            this.mStarryNetProtocol = new XRStarryNetProtocol();
            this.mUupShareProtocol = null;
            this.mSimpleProtocol = new SimpleBleProtocol();
            this.mMyvuRingBleProtocol = null;
        } else if (terminalType == 9) {
            this.mStarryNetProtocol = new PadStarryNetProtocol();
            this.mSimpleProtocol = null;
            this.mUupShareProtocol = null;
            this.mMyvuRingBleProtocol = null;
        } else if (terminalType == 3) {
            this.mStarryNetProtocol = new CarStarryNetProtocol();
            this.mSimpleProtocol = null;
            this.mUupShareProtocol = null;
            this.mMyvuRingBleProtocol = null;
        } else {
            this.mStarryNetProtocol = new StarryNetProtocol();
            this.mMyvuRingBleProtocol = new MyvuRingBleProtocol();
            this.mUupShareProtocol = null;
            this.mSimpleProtocol = null;
        }
    }
}
