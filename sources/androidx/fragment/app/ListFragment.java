package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1315a = new Handler();
    public final Runnable b = new Runnable() {
        public void run() {
            ListView listView = ListFragment.this.e;
            listView.focusableViewAvailable(listView);
        }
    };
    public final AdapterView.OnItemClickListener c = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            ListFragment.this.h0((ListView) adapterView, view, i, j);
        }
    };
    public ListAdapter d;
    public ListView e;
    public View f;
    public TextView g;
    public View h;
    public View i;
    public CharSequence j;
    public boolean k;

    public final void g0() {
        if (this.e == null) {
            View view = getView();
            if (view != null) {
                if (view instanceof ListView) {
                    this.e = (ListView) view;
                } else {
                    TextView textView = (TextView) view.findViewById(16711681);
                    this.g = textView;
                    if (textView == null) {
                        this.f = view.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.h = view.findViewById(16711682);
                    this.i = view.findViewById(16711683);
                    View findViewById = view.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        ListView listView = (ListView) findViewById;
                        this.e = listView;
                        View view2 = this.f;
                        if (view2 != null) {
                            listView.setEmptyView(view2);
                        } else {
                            CharSequence charSequence = this.j;
                            if (charSequence != null) {
                                this.g.setText(charSequence);
                                this.e.setEmptyView(this.g);
                            }
                        }
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.k = true;
                this.e.setOnItemClickListener(this.c);
                ListAdapter listAdapter = this.d;
                if (listAdapter != null) {
                    this.d = null;
                    i0(listAdapter);
                } else if (this.h != null) {
                    j0(false, false);
                }
                this.f1315a.post(this.b);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }

    public void h0(ListView listView, View view, int i2, long j2) {
    }

    public void i0(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.d != null;
        this.d = listAdapter;
        ListView listView = this.e;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.k && !z2) {
                if (requireView().getWindowToken() != null) {
                    z = true;
                }
                j0(true, z);
            }
        }
    }

    public final void j0(boolean z, boolean z2) {
        g0();
        View view = this.h;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.k != z) {
            this.k = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.i.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.i.clearAnimation();
                }
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.i.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.i.clearAnimation();
            }
            this.h.setVisibility(0);
            this.i.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f1315a.removeCallbacks(this.b);
        this.e = null;
        this.k = false;
        this.i = null;
        this.h = null;
        this.f = null;
        this.g = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g0();
    }
}
