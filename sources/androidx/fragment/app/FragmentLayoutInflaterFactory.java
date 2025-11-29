package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;

class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentManager f1276a;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.f1276a = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final FragmentStateManager fragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f1276a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f1276a.o0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f1276a.p0(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f1276a.o0(id);
        }
        if (fragment == null) {
            fragment = this.f1276a.D0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f1276a;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.G0();
            fragment.onInflate(this.f1276a.G0().f(), attributeSet, fragment.mSavedFragmentState);
            fragmentStateManager = this.f1276a.l(fragment);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f1276a;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.G0();
            fragment.onInflate(this.f1276a.G0().f(), attributeSet, fragment.mSavedFragmentState);
            fragmentStateManager = this.f1276a.C(fragment);
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.i(fragment, viewGroup);
        fragment.mContainer = viewGroup;
        fragmentStateManager.m();
        fragmentStateManager.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    Fragment k = fragmentStateManager.k();
                    fragmentStateManager.m();
                    SpecialEffectsController.u((ViewGroup) k.mView.getParent(), FragmentLayoutInflaterFactory.this.f1276a).q();
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
