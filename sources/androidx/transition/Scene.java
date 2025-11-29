package androidx.transition;

import android.view.ViewGroup;

public class Scene {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f1861a;
    public Runnable b;

    public static Scene b(ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.transition_current_scene);
    }

    public static void c(ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(R.id.transition_current_scene, scene);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f1861a) == this && (runnable = this.b) != null) {
            runnable.run();
        }
    }
}
