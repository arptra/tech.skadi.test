package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.gson.JsonObject;
import com.honey.account.h8.l7;
import com.honey.account.h8.m7;
import com.honey.account.h8.n7;
import com.honey.account.h8.o7;
import com.honey.account.h8.p7;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.FeedbackViewAdapter;
import com.upuphone.xr.sapp.databinding.FragmentOpinionFeedbackBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0003¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J;\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\f2\"\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\"j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R&\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010>¨\u0006D"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/OpinionFeedbackFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outView", "K0", "(Landroid/view/View;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "onActivityResult", "(IILandroid/content/Intent;)V", "L0", "", "S0", "()Z", "N0", "buttonView", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "I0", "(Landroid/view/View;Ljava/util/HashMap;)V", "O0", "Lcom/upuphone/xr/sapp/databinding/FragmentOpinionFeedbackBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentOpinionFeedbackBinding;", "binding", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "mData", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter;", "l", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter;", "viewAdapter", "Lcom/google/gson/JsonObject;", "m", "Lcom/google/gson/JsonObject;", "feedbackJson", "n", "Landroid/view/View;", "lastFrequencyView", "o", "Z", "problemTypeCheck", "p", "problemFrequencyCheck", "q", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nOpinionFeedbackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpinionFeedbackFragment.kt\ncom/upuphone/xr/sapp/fragment/OpinionFeedbackFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
public final class OpinionFeedbackFragment extends BaseFragment {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public FragmentOpinionFeedbackBinding j;
    public ArrayList k;
    public FeedbackViewAdapter l;
    public JsonObject m = new JsonObject();
    public View n;
    public boolean o;
    public boolean p;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/OpinionFeedbackFragment$Companion;", "", "()V", "ADD_SCREENSHOT", "", "DES_COUNT_LIMIT", "", "PERMISSION_ADD_PICTURE_REQUEST_CODE", "PIC_COUNT_LIMIT", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void J0(OpinionFeedbackFragment opinionFeedbackFragment, HashMap hashMap, View view) {
        Intrinsics.checkNotNullParameter(opinionFeedbackFragment, "this$0");
        Intrinsics.checkNotNullParameter(hashMap, "$map");
        Drawable drawable = null;
        if (view != null) {
            Context context = opinionFeedbackFragment.getContext();
            view.setBackground(context != null ? context.getDrawable(R.drawable.bg_confirm_button) : null);
        }
        View view2 = opinionFeedbackFragment.n;
        if (view2 != null) {
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFrequencyView");
                view2 = null;
            }
            if (view2.getId() != view.getId()) {
                View view3 = opinionFeedbackFragment.n;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastFrequencyView");
                    view3 = null;
                }
                Context context2 = opinionFeedbackFragment.getContext();
                if (context2 != null) {
                    drawable = context2.getDrawable(R.drawable.bg_card_item);
                }
                view3.setBackground(drawable);
            }
        }
        opinionFeedbackFragment.m.addProperty("frequency", (Number) hashMap.get(Integer.valueOf(view.getId())));
        Intrinsics.checkNotNull(view);
        opinionFeedbackFragment.n = view;
        opinionFeedbackFragment.p = true;
        ULog.f6446a.g("AppFragment", "frequency: " + hashMap.get(Integer.valueOf(view.getId())));
    }

    public static final boolean M0(OpinionFeedbackFragment opinionFeedbackFragment, View view, MotionEvent motionEvent) {
        View currentFocus;
        View currentFocus2;
        Intrinsics.checkNotNullParameter(opinionFeedbackFragment, "this$0");
        FragmentActivity activity = opinionFeedbackFragment.getActivity();
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = null;
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (motionEvent.getAction() != 0) {
            return false;
        }
        FragmentActivity activity2 = opinionFeedbackFragment.getActivity();
        if ((activity2 != null ? activity2.getCurrentFocus() : null) == null) {
            return false;
        }
        FragmentActivity activity3 = opinionFeedbackFragment.getActivity();
        if (((activity3 == null || (currentFocus2 = activity3.getCurrentFocus()) == null) ? null : currentFocus2.getWindowToken()) == null) {
            return false;
        }
        FragmentActivity activity4 = opinionFeedbackFragment.getActivity();
        inputMethodManager.hideSoftInputFromWindow((activity4 == null || (currentFocus = activity4.getCurrentFocus()) == null) ? null : currentFocus.getWindowToken(), 2);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding2 = opinionFeedbackFragment.j;
        if (fragmentOpinionFeedbackBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentOpinionFeedbackBinding = fragmentOpinionFeedbackBinding2;
        }
        fragmentOpinionFeedbackBinding.m.clearFocus();
        return false;
    }

    public static final void P0(OpinionFeedbackFragment opinionFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(opinionFeedbackFragment, "this$0");
        StaticMethodUtilsKt.q(opinionFeedbackFragment);
    }

    public static final void Q0(OpinionFeedbackFragment opinionFeedbackFragment, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(opinionFeedbackFragment, "this$0");
        if (i == R.id.star_device_problem) {
            opinionFeedbackFragment.m.addProperty("problemType", Constants.GLASS_DEVICE_STAR);
        } else if (i == R.id.superapp_problem) {
            opinionFeedbackFragment.m.addProperty("problemType", "superapp");
        }
        opinionFeedbackFragment.o = true;
        ULog.Delegate delegate = ULog.f6446a;
        JsonObject jsonObject = opinionFeedbackFragment.m;
        delegate.a("AppFragment", jsonObject + " -------");
    }

    public static final void R0(OpinionFeedbackFragment opinionFeedbackFragment, View view) {
        Intrinsics.checkNotNullParameter(opinionFeedbackFragment, "this$0");
        if (!opinionFeedbackFragment.o || !opinionFeedbackFragment.p || !opinionFeedbackFragment.S0()) {
            Context context = opinionFeedbackFragment.getContext();
            if (context != null) {
                UToast.f6444a.d(context, "请完成所有必填项");
                return;
            }
            return;
        }
        ULog.f6446a.a("AppFragment", "commit to server");
    }

    private final void initView() {
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding2 = null;
        if (fragmentOpinionFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding = null;
        }
        fragmentOpinionFeedbackBinding.j.setOnClickListener(new l7(this));
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding3 = this.j;
        if (fragmentOpinionFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding3 = null;
        }
        fragmentOpinionFeedbackBinding3.t.setOnCheckedChangeListener(new m7(this));
        N0();
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding4 = this.j;
        if (fragmentOpinionFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding4 = null;
        }
        fragmentOpinionFeedbackBinding4.m.addTextChangedListener(new OpinionFeedbackFragment$initView$3(this));
        O0();
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding5 = this.j;
        if (fragmentOpinionFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentOpinionFeedbackBinding2 = fragmentOpinionFeedbackBinding5;
        }
        fragmentOpinionFeedbackBinding2.b.setOnClickListener(new n7(this));
    }

    public final void I0(View view, HashMap hashMap) {
        view.setOnClickListener(new p7(this, hashMap));
    }

    public final void K0(View view) {
        Intrinsics.checkNotNullParameter(view, "outView");
        L0(view);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
        if (fragmentOpinionFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding = null;
        }
        NestedScrollView nestedScrollView = fragmentOpinionFeedbackBinding.v;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "scrollView");
        L0(nestedScrollView);
    }

    public final void L0(View view) {
        view.setOnTouchListener(new o7(this));
    }

    public final void N0() {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(R.id.frequency_few), 1);
        hashMap.put(Integer.valueOf(R.id.frequency_once_a_day), 2);
        hashMap.put(Integer.valueOf(R.id.frequency_mul_a_day), 3);
        hashMap.put(Integer.valueOf(R.id.frequency_always), 4);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding2 = null;
        if (fragmentOpinionFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding = null;
        }
        Button button = fragmentOpinionFeedbackBinding.f;
        Intrinsics.checkNotNullExpressionValue(button, "frequencyFew");
        I0(button, hashMap);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding3 = this.j;
        if (fragmentOpinionFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding3 = null;
        }
        Button button2 = fragmentOpinionFeedbackBinding3.i;
        Intrinsics.checkNotNullExpressionValue(button2, "frequencyOnceADay");
        I0(button2, hashMap);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding4 = this.j;
        if (fragmentOpinionFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding4 = null;
        }
        Button button3 = fragmentOpinionFeedbackBinding4.h;
        Intrinsics.checkNotNullExpressionValue(button3, "frequencyMulADay");
        I0(button3, hashMap);
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding5 = this.j;
        if (fragmentOpinionFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentOpinionFeedbackBinding2 = fragmentOpinionFeedbackBinding5;
        }
        Button button4 = fragmentOpinionFeedbackBinding2.e;
        Intrinsics.checkNotNullExpressionValue(button4, "frequencyAlways");
        I0(button4, hashMap);
    }

    public final void O0() {
        ULog.f6446a.a("AppFragment", "initRecyclerView");
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
        FeedbackViewAdapter feedbackViewAdapter = null;
        if (fragmentOpinionFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding = null;
        }
        MzRecyclerView mzRecyclerView = fragmentOpinionFeedbackBinding.u;
        Intrinsics.checkNotNullExpressionValue(mzRecyclerView, "screenshotRecyclerview");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        mzRecyclerView.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        arrayList.add("addScreenshotPic");
        ArrayList arrayList2 = this.k;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            arrayList2 = null;
        }
        FeedbackViewAdapter feedbackViewAdapter2 = new FeedbackViewAdapter(arrayList2);
        this.l = feedbackViewAdapter2;
        feedbackViewAdapter2.l(new OpinionFeedbackFragment$initRecyclerView$1(this));
        FeedbackViewAdapter feedbackViewAdapter3 = this.l;
        if (feedbackViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            feedbackViewAdapter = feedbackViewAdapter3;
        }
        mzRecyclerView.setAdapter(feedbackViewAdapter);
    }

    public final boolean S0() {
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
        FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding2 = null;
        if (fragmentOpinionFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentOpinionFeedbackBinding = null;
        }
        Editable text = fragmentOpinionFeedbackBinding.m.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() > 0) {
            JsonObject jsonObject = this.m;
            FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding3 = this.j;
            if (fragmentOpinionFeedbackBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentOpinionFeedbackBinding2 = fragmentOpinionFeedbackBinding3;
            }
            jsonObject.addProperty("problemDesc", fragmentOpinionFeedbackBinding2.m.getText().toString());
            return true;
        }
        ULog.f6446a.a("AppFragment", "problemDesc is null");
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppFragment", "requestCode:" + i + ",resultCode:" + i2 + ",data:" + intent);
        if (i2 == -1) {
            ArrayList arrayList = null;
            Uri data = intent != null ? intent.getData() : null;
            ArrayList arrayList2 = this.k;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                arrayList2 = null;
            }
            int size = arrayList2.size();
            delegate.a("AppFragment", "uri:" + data + ", num:" + size);
            if (data != null) {
                if (size == 9) {
                    ArrayList arrayList3 = this.k;
                    if (arrayList3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mData");
                        arrayList3 = null;
                    }
                    int i3 = size - 1;
                    arrayList3.remove(i3);
                    ArrayList arrayList4 = this.k;
                    if (arrayList4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mData");
                        arrayList4 = null;
                    }
                    arrayList4.add(i3, data.toString());
                    FeedbackViewAdapter feedbackViewAdapter = this.l;
                    if (feedbackViewAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                        feedbackViewAdapter = null;
                    }
                    feedbackViewAdapter.notifyItemChanged(i3);
                } else {
                    ArrayList arrayList5 = this.k;
                    if (arrayList5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mData");
                        arrayList5 = null;
                    }
                    int i4 = size - 1;
                    arrayList5.add(i4, data.toString());
                    FeedbackViewAdapter feedbackViewAdapter2 = this.l;
                    if (feedbackViewAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                        feedbackViewAdapter2 = null;
                    }
                    feedbackViewAdapter2.notifyItemInserted(i4);
                }
                FragmentOpinionFeedbackBinding fragmentOpinionFeedbackBinding = this.j;
                if (fragmentOpinionFeedbackBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentOpinionFeedbackBinding = null;
                }
                TextView textView = fragmentOpinionFeedbackBinding.r;
                ArrayList arrayList6 = this.k;
                if (arrayList6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mData");
                } else {
                    arrayList = arrayList6;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(arrayList.size() - 1);
                sb.append("/9");
                textView.setText(sb.toString());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOpinionFeedbackBinding c = FragmentOpinionFeedbackBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        K0(view);
    }
}
