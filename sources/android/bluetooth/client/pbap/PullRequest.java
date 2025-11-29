package android.bluetooth.client.pbap;

import java.util.List;

public abstract class PullRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f80a;
    public List b;

    public void a(List list) {
        this.b = list;
    }

    public String toString() {
        return "PullRequest: { path=" + this.f80a + " }";
    }
}
