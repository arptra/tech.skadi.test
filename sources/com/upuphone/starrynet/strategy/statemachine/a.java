package com.upuphone.starrynet.strategy.statemachine;

import com.upuphone.starrynet.strategy.statemachine.StateMachine;
import java.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StateMachine.SmHandler.StateInfo f6543a;

    public /* synthetic */ a(StateMachine.SmHandler.StateInfo stateInfo) {
        this.f6543a = stateInfo;
    }

    public final boolean test(Object obj) {
        return StateMachine.SmHandler.lambda$removeState$0(this.f6543a, (StateMachine.SmHandler.StateInfo) obj);
    }
}
