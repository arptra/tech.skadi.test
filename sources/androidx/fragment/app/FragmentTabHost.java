package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1302a = new ArrayList();
    public Context b;
    public FragmentManager c;
    public int d;
    public TabHost.OnTabChangeListener e;
    public TabInfo f;
    public boolean g;

    public static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1303a;

        public View createTabContent(String str) {
            View view = new View(this.f1303a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String curTab;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }
    }

    public static final class TabInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f1304a;
        public final Class b;
        public final Bundle c;
        public Fragment d;
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, (AttributeSet) null);
        c(context, (AttributeSet) null);
    }

    public final FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo b2 = b(str);
        if (this.f != b2) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.c.s();
            }
            TabInfo tabInfo = this.f;
            if (!(tabInfo == null || (fragment = tabInfo.d) == null)) {
                fragmentTransaction.n(fragment);
            }
            if (b2 != null) {
                Fragment fragment2 = b2.d;
                if (fragment2 == null) {
                    Fragment a2 = this.c.D0().a(this.b.getClassLoader(), b2.b.getName());
                    b2.d = a2;
                    a2.setArguments(b2.c);
                    fragmentTransaction.c(this.d, b2.d, b2.f1304a);
                } else {
                    fragmentTransaction.i(fragment2);
                }
            }
            this.f = b2;
        }
        return fragmentTransaction;
    }

    public final TabInfo b(String str) {
        int size = this.f1302a.size();
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = (TabInfo) this.f1302a.get(i);
            if (tabInfo.f1304a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f1302a.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = (TabInfo) this.f1302a.get(i);
            Fragment p0 = this.c.p0(tabInfo.f1304a);
            tabInfo.d = p0;
            if (p0 != null && !p0.isDetached()) {
                if (tabInfo.f1304a.equals(currentTabTag)) {
                    this.f = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.c.s();
                    }
                    fragmentTransaction.n(tabInfo.d);
                }
            }
        }
        this.g = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.j();
            this.c.l0();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.g && (a2 = a(str, (FragmentTransaction) null)) != null) {
            a2.j();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }
}
