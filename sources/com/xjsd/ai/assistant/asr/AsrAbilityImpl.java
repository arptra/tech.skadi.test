package com.xjsd.ai.assistant.asr;

import android.app.Application;
import com.honey.account.x9.a;
import com.honey.account.x9.b;
import com.xjsd.ai.assistant.asr.engine.AsrEngine;
import com.xjsd.ai.assistant.asr.engine.AsrEngineImpl;
import com.xjsd.ai.assistant.core.factory.ThreadPoolFactory;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class AsrAbilityImpl implements AsrAbility {
    private final AsrEngine mAsrEngine = new AsrEngineImpl();
    private final ExecutorService mExecutorService = ThreadPoolFactory.b("ASR");

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$startRecognize$0(String str, List list) throws Exception {
        return Boolean.valueOf(this.mAsrEngine.startRecognize(str, list));
    }

    public void feedData(byte[] bArr, int i) {
        this.mAsrEngine.feedData(bArr, i);
    }

    public void flush() {
        this.mAsrEngine.flush();
    }

    public int getErrorCode() {
        return this.mAsrEngine.getErrorCode();
    }

    public void init(Application application) {
        this.mAsrEngine.init(application);
    }

    public /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    public boolean isReady() {
        return this.mAsrEngine.isReady();
    }

    public /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    public void setOnAsrEventListener(AsrEventListener asrEventListener) {
        this.mAsrEngine.setOnAsrEventListener(asrEventListener);
    }

    public boolean startRecognize(String str, List<String> list) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new b(this, str, list));
        this.mExecutorService.submit(futureTask);
        return ((Boolean) futureTask.get()).booleanValue();
    }

    public void stopRecognize() {
        ExecutorService executorService = this.mExecutorService;
        AsrEngine asrEngine = this.mAsrEngine;
        Objects.requireNonNull(asrEngine);
        executorService.submit(new a(asrEngine));
    }
}
