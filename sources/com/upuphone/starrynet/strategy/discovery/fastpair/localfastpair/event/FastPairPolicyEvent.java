package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event;

public class FastPairPolicyEvent {
    private boolean policy;
    private boolean visible;

    public FastPairPolicyEvent(boolean z) {
        this.policy = z;
    }

    public boolean getPolicy() {
        return this.policy;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setPolicy(boolean z) {
        this.policy = z;
    }

    public void setVisible(boolean z) {
        this.visible = z;
    }

    public FastPairPolicyEvent() {
    }
}
