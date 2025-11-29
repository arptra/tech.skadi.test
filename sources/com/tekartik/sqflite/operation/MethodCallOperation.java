package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MethodCallOperation extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final Result f10050a;
    public final MethodCall b;

    public class Result implements OperationResult {

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f10051a;

        public Result(MethodChannel.Result result) {
            this.f10051a = result;
        }

        public void error(String str, String str2, Object obj) {
            this.f10051a.error(str, str2, obj);
        }

        public void success(Object obj) {
            this.f10051a.success(obj);
        }
    }

    public MethodCallOperation(MethodCall methodCall, MethodChannel.Result result) {
        this.b = methodCall;
        this.f10050a = new Result(result);
    }

    public Object a(String str) {
        return this.b.argument(str);
    }

    public boolean b(String str) {
        return this.b.hasArgument(str);
    }

    public String getMethod() {
        return this.b.method;
    }

    public OperationResult l() {
        return this.f10050a;
    }
}
