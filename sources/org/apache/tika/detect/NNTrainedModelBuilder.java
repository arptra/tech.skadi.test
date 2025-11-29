package org.apache.tika.detect;

import org.apache.tika.mime.MediaType;

public class NNTrainedModelBuilder {

    /* renamed from: a  reason: collision with root package name */
    public MediaType f10057a;
    public int b;
    public int c;
    public int d;
    public float[] e;

    public NNTrainedModel a() {
        return new NNTrainedModel(this.b, this.c, this.d, this.e);
    }

    public MediaType b() {
        return this.f10057a;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public void f(float[] fArr) {
        this.e = fArr;
    }

    public void g(MediaType mediaType) {
        this.f10057a = mediaType;
    }
}
