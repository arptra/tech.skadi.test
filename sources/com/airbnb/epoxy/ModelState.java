package com.airbnb.epoxy;

class ModelState {

    /* renamed from: a  reason: collision with root package name */
    public long f2311a;
    public int b;
    public int c;
    public EpoxyModel d;
    public ModelState e;
    public int f;

    public static ModelState a(EpoxyModel epoxyModel, int i, boolean z) {
        ModelState modelState = new ModelState();
        modelState.f = 0;
        modelState.e = null;
        modelState.f2311a = epoxyModel.D();
        modelState.c = i;
        if (z) {
            modelState.d = epoxyModel;
        } else {
            modelState.b = epoxyModel.hashCode();
        }
        return modelState;
    }

    public String toString() {
        return "ModelState{id=" + this.f2311a + ", model=" + this.d + ", hashCode=" + this.b + ", position=" + this.c + ", pair=" + this.e + ", lastMoveOp=" + this.f + '}';
    }
}
