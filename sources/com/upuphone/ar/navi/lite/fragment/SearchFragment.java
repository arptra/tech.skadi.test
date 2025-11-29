package com.upuphone.ar.navi.lite.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.honey.account.g4.a0;
import com.honey.account.g4.b0;
import com.honey.account.g4.c0;
import com.honey.account.g4.d0;
import com.honey.account.g4.e0;
import com.honey.account.g4.f0;
import com.honey.account.g4.g0;
import com.honey.account.g4.h0;
import com.honey.account.g4.i0;
import com.honey.account.g4.j0;
import com.honey.account.g4.k0;
import com.honey.account.g4.l0;
import com.honey.account.g4.m0;
import com.honey.account.g4.n0;
import com.honey.account.g4.o0;
import com.honey.account.g4.p;
import com.honey.account.g4.q;
import com.honey.account.g4.r;
import com.honey.account.g4.s;
import com.honey.account.g4.t;
import com.honey.account.g4.u;
import com.honey.account.g4.v;
import com.honey.account.g4.w;
import com.honey.account.g4.x;
import com.honey.account.g4.y;
import com.honey.account.g4.z;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.adapter.SearchAdapter;
import com.upuphone.ar.navi.lite.adapter.SearchCommonAdapter;
import com.upuphone.ar.navi.lite.base.CommonAddress;
import com.upuphone.ar.navi.lite.base.PlaceBean;
import com.upuphone.ar.navi.lite.base.Record;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.dao.NaviDatabase;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.mapview.BaseMapView;
import com.upuphone.ar.navi.lite.model.LocationClickImpl;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.DensityUtils;
import com.upuphone.ar.navi.lite.util.LocationUtil;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.ar.navi.lite.util.PermissionUtil;
import com.upuphone.ar.navi.lite.util.SensorEventHelper;
import com.upuphone.ar.navi.lite.view.ContentRecyclerView;
import com.upuphone.ar.navi.lite.view.CustomDialog;
import com.upuphone.ar.navi.lite.view.EmptyDataView;
import com.upuphone.ar.navi.lite.view.NaviProgressView;
import com.upuphone.ar.navi.lite.view.NoConnectedView;
import com.upuphone.ar.navi.lite.view.ScrollLayout;
import com.upuphone.ar.navi.lite.view.SearchCommonView;
import com.upuphone.ar.navi.lite.view.SearchMenuView;
import com.upuphone.ar.navi.lite.view.SlideRecyclerView;
import com.upuphone.ar.navi.lite.view.TitleView;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends BaseFragment implements TextWatcher, View.OnClickListener, SearchAdapter.ItemClickListener, ScrollLayout.OnScrollChangedListener, LocationClickImpl {
    public static final String t0 = ("NAVI-" + SearchFragment.class.getSimpleName());
    public ImageView A;
    public ImageView B;
    public SearchMenuView C;
    public NestedScrollView D;
    public SlideRecyclerView E;
    public SearchAdapter F;
    public EmptyDataView G;
    public ConstraintLayout H;
    public ImageView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public ScrollLayout N;
    public ContentRecyclerView O;
    public SearchAdapter P;
    public RelativeLayout Q;
    public SearchCommonView R;
    public RelativeLayout S;
    public View T;
    public String U = "";
    public String V = "";
    public int W = 1;
    public SearchModel X;
    public boolean Y = false;
    public boolean Z = false;
    public boolean g0 = false;
    public boolean h0 = false;
    public int i = 0;
    public boolean i0 = false;
    public View j;
    public ViewHandler j0 = new ViewHandler(this);
    public LinearLayout k;
    public boolean k0 = false;
    public ConstraintLayout l;
    public NoConnectedView l0;
    public BaseMapView m;
    public ImageView m0;
    public EmptyDataView n;
    public boolean n0;
    public FrameLayout o;
    public boolean o0 = false;
    public ConstraintLayout p;
    public boolean p0 = false;
    public SearchMenuView q;
    public NoConnectedView.NoConnectedViewActionistener q0 = new NoConnectedView.NoConnectedViewActionistener() {
        public void a() {
            SearchFragment.this.getActivity().startActivityForResult(new Intent("android.settings.WIRELESS_SETTINGS"), 888);
        }

        public void b() {
            SearchFragment.this.l0.h(false);
        }
    };
    public AutoCompleteTextView r;
    public SearchCommonAdapter.ItemClickListener r0 = new SearchCommonAdapter.ItemClickListener() {
        public void a(CommonAddress commonAddress, int i) {
            SearchModel Z1 = SearchFragment.this.O2(commonAddress);
            SearchFragment.this.X = Z1;
            SearchFragment.this.S.setVisibility(8);
            SearchFragment.this.d4(Z1);
            SearchFragment.this.y4(Z1);
            SearchFragment.this.k0();
            SearchFragment.this.l.setVisibility(0);
            SearchFragment.this.k.setBackgroundColor(SearchFragment.this.getActivity().getApplicationContext().getColor(R.color.transparent));
            SearchFragment.this.l.setBackgroundColor(SearchFragment.this.getActivity().getApplicationContext().getColor(R.color.transparent));
            SearchFragment.this.f4(true);
            SearchFragment.this.C.setVisibility(8);
            SearchFragment.this.D.setVisibility(8);
            SearchFragment.this.E.setVisibility(8);
            SearchFragment.this.m0.setImageResource(R.drawable.ic_arrow_back);
            SearchFragment.this.n0 = true;
            SearchFragment.this.R.setVisibility(8);
            SearchFragment.this.Q.setVisibility(8);
            SearchFragment.this.w.setVisibility(0);
            SearchFragment.this.x.setVisibility(8);
            SearchFragment.this.y.setVisibility(8);
            SearchFragment.this.z.setVisibility(0);
            SearchFragment.this.H.setVisibility(0);
            SearchFragment.this.A.setVisibility(8);
            SearchFragment.this.J.setText(commonAddress.j());
            String h2 = SearchFragment.t0;
            CLog.b(h2, "SearchCommonAdapter.ItemClickListener() &&&&&&& distance==" + Z1.getDistance() + " commonAddress.getName()=" + commonAddress.j());
            TextView v1 = SearchFragment.this.K;
            v1.setText(NaviUtil.r(SearchFragment.this.getActivity().getApplicationContext(), Z1.getDistance()) + "   " + commonAddress.c());
            SearchFragment.this.u.setText(commonAddress.j());
            SearchFragment.this.u.setSelection(commonAddress.j().length());
            SearchFragment.this.k2(Z1);
            SearchFragment.this.f4(true);
        }
    };
    public TitleView s;
    public SearchAdapter.ItemClickListener s0 = new SearchAdapter.ItemClickListener() {
        public void B(RecyclerView recyclerView, View view, int i, SearchModel searchModel) {
            String h2 = SearchFragment.t0;
            CLog.b(h2, "poiItemClickListener  onEditAddressClick position=" + i);
        }

        public void F(RecyclerView recyclerView, View view, int i, SearchModel searchModel) {
            String h2 = SearchFragment.t0;
            CLog.b(h2, "poiItemClickListener  onDeleteClick position=" + i);
        }

        public void d(RecyclerView recyclerView, View view, int i, SearchModel searchModel) {
            int type = searchModel.getType();
            String h2 = SearchFragment.t0;
            CLog.b(h2, "onItemClick  poiItemClickListener viewType=" + type);
            if (type == 0) {
                SearchFragment.this.N.setVisibility(8);
                SearchFragment.this.P.A(new ArrayList());
                SearchFragment.this.P.notifyDataSetChanged();
                NaviUtil.h0(SearchFragment.this.getContext(), searchModel);
                SearchFragment.this.W3(searchModel, i);
            } else if (type == 2) {
                SearchFragment.this.Z = true;
                SearchFragment.this.L3();
            }
        }

        public void e(RecyclerView recyclerView, View view, int i, SearchModel searchModel) {
            NaviUtil.h0(SearchFragment.this.getContext(), searchModel);
            SearchFragment.this.q4(searchModel, false);
        }
    };
    public LinearLayout t;
    public AutoCompleteTextView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public TextView y;
    public ImageView z;

    public static class ViewHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f5774a;

        public ViewHandler(SearchFragment searchFragment) {
            this.f5774a = new WeakReference(searchFragment);
        }

        public void handleMessage(Message message) {
            SearchFragment searchFragment = (SearchFragment) this.f5774a.get();
            if (searchFragment != null) {
                int i = message.what;
                if (i == 1100) {
                    searchFragment.N.setMaxOffset(DensityUtils.b(searchFragment.getContext().getApplicationContext()) / 2);
                    searchFragment.N.u();
                    String h2 = SearchFragment.t0;
                    CLog.b(h2, "showSearchScrollView  scrollLayout.getCurrentStatus()=" + searchFragment.N.getCurrentStatus());
                } else if (i == 1200) {
                    searchFragment.h0 = false;
                } else if (i == 1300) {
                    searchFragment.i0 = false;
                } else if (i == 1400) {
                    searchFragment.j.findViewById(R.id.search_fragement_mask).setVisibility(8);
                } else if (i == 1500) {
                    searchFragment.l4();
                } else if (i != 1600) {
                    CLog.b(SearchFragment.t0, "handleMessage  default.");
                } else {
                    searchFragment.p0 = false;
                }
            }
        }
    }

    private void H3() {
        I3(false);
    }

    private void J2() {
        if (getArguments() != null) {
            this.k0 = getArguments().getBoolean("map_navi_key", false);
            String str = t0;
            CLog.b(str, "getBundleData  showMap=" + this.k0);
        }
    }

    private List L2() {
        int i2 = 0;
        while (i2 < this.e.size()) {
            SearchModel searchModel = (SearchModel) this.e.get(i2);
            if (searchModel != null && (searchModel.getType() == 3 || searchModel.getType() == 2)) {
                this.e.remove(searchModel);
                i2 = 0;
            }
            i2++;
        }
        List M2 = M2(this.f);
        if (M2(this.f + 1).size() > 0) {
            M2.add(u0(2, getString(R.string.more_history)));
            M2.add(u0(3, getString(R.string.clear_history)));
        } else if (M2.size() > 0) {
            M2.add(u0(3, getString(R.string.clear_history)));
        }
        this.e.addAll(M2);
        CLog.b(t0, "getHistorylist() &&&&&&& modelList size is:" + M2.size());
        return this.e;
    }

    private List M2(int i2) {
        List i3 = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase().f().i(NaviUtil.t(), i2, 12);
        int size = i3.size();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(v0((Record) i3.get(i4)));
        }
        String str = t0;
        CLog.b(str, "getPageHistorylist() &&&&&&& size is:" + arrayList.size() + " pageIndex=" + i2);
        return arrayList;
    }

    private List S3() {
        int i2;
        this.e.clear();
        int i3 = 1;
        while (true) {
            i2 = this.f;
            if (i3 > i2) {
                break;
            }
            this.e.addAll(M2(i3));
            i3++;
        }
        if (M2(i2 + 1).size() > 0) {
            this.e.add(u0(2, getString(R.string.more_history)));
            this.e.add(u0(3, getString(R.string.clear_history)));
        } else if (this.e.size() > 0) {
            this.e.add(u0(3, getString(R.string.clear_history)));
        } else if (this.e.size() <= 0) {
            this.e.add(u0(4, getString(R.string.no_history_title)));
        }
        CLog.b(t0, "reLoadHistoryList() ############# historyList size is:" + this.e.size());
        return this.e;
    }

    private void T2() {
        this.j0.sendEmptyMessageDelayed(1400, 150);
    }

    private void U2() {
        String str = t0;
        CLog.b(str, "initMap() &&&&&&& Enter.");
        if (!NaviUtil.S0(getContext().getApplicationContext())) {
            CLog.b(str, "initMap() &&&&&&& #######.");
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).startLocation(getContext().getApplicationContext());
        }
        this.m.f();
        this.m.setPoiClickListener(new t(this));
    }

    private void Z2() {
        this.o.addView(DensityUtils.d(getContext()));
    }

    private boolean a3(int i2) {
        if (i2 != 6) {
            return false;
        }
        D2();
        return false;
    }

    private void b3(List list) {
        String str = t0;
        CLog.b(str, "inputTipQueryResult  list.size()=" + list.size());
        M0(false);
        int i2 = 8;
        if (TextUtils.isEmpty(this.u.getText().toString())) {
            CLog.b(str, "inputTipQueryResult() @@@@@@@@@@@");
            this.R.setVisibility(w2() ? 0 : 8);
            this.S.setVisibility(p4() ? 0 : 8);
            this.F.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            EmptyDataView emptyDataView = this.G;
            if (S3.size() <= 0) {
                i2 = 0;
            }
            emptyDataView.setVisibility(i2);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
            this.i = 1;
        } else if (list.size() > 0) {
            this.R.setVisibility(8);
            this.C.setVisibility(8);
            this.i = 2;
            z2(list);
        } else {
            this.i = 2;
            this.R.setVisibility(8);
            this.S.setVisibility(p4() ? 0 : 8);
            this.V = "";
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            EmptyDataView emptyDataView2 = this.G;
            if (this.F.n().size() <= 0) {
                i2 = 0;
            }
            emptyDataView2.setVisibility(i2);
            this.G.setIconImage(R.drawable.no_data);
        }
        this.p0 = false;
        list.clear();
    }

    private void g4() {
        BaseMapView baseMapView = this.m;
        if (baseMapView != null && !this.i0) {
            this.i0 = true;
            boolean n2 = baseMapView.n();
            String str = t0;
            CLog.b(str, "setTrafficStatus  enabled=" + n2);
            this.A.setImageResource(n2 ? R.drawable.traffic_off : R.drawable.traffic_on);
            UToast.e(getContext().getApplicationContext(), !n2 ? R.string.traffic_on_msg : R.string.traffic_off_msg, 0);
            this.j0.sendEmptyMessageDelayed(1300, AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    private void i2(ULocation uLocation, boolean z2) {
        BaseMapView baseMapView = this.m;
        if (baseMapView != null) {
            baseMapView.o(uLocation, (SensorEventHelper) null, z2, true, false);
        }
        T0(this.d);
    }

    private void j4() {
        if (getActivity() != null) {
            PermissionUtil.f(getActivity(), 100008, new PermissionUtil.IPermissionSettings() {
                public void a() {
                    CLog.b(SearchFragment.t0, "onSettings   ");
                    SearchFragment.this.g0 = true;
                }

                public void b() {
                    CLog.b(SearchFragment.t0, "onQuit   ");
                    if (SearchFragment.this.getActivity() != null) {
                        SearchFragment.this.I2();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void k2(SearchModel searchModel) {
        ULatLng uLatLng = new ULatLng(searchModel.getLatitude(), searchModel.getLongitude());
        this.m.a(uLatLng);
        this.m.h(uLatLng);
    }

    private void r2() {
        this.j0.removeMessages(Ring2TrackerConstant.MSG_CONNECT_TIMEOUT);
        this.j0.removeMessages(1200);
        this.j0.removeMessages(1300);
        this.j0.removeMessages(1400);
        this.j0.removeMessages(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        this.j0.removeMessages(1600);
    }

    private void t2() {
        if (getActivity() != null) {
            this.T.setVisibility(0);
            CustomDialog customDialog = new CustomDialog(getActivity());
            customDialog.setOnDismissListener(new w(this));
            customDialog.c(true);
            customDialog.j(getString(R.string.clear_history_title)).e(getString(R.string.navi_cancel), new x(this, customDialog)).f(getString(R.string.clear_desp), new y(this, customDialog)).show();
            f4(false);
        }
    }

    private void x2() {
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase().f().c(NaviUtil.t());
        NaviUtil.i(getContext().getApplicationContext());
        this.e.clear();
        this.f = 1;
        List S3 = S3();
        this.F.n().clear();
        this.F.A(S3);
        this.F.notifyDataSetChanged();
        this.S.setVisibility(p4() ? 0 : 8);
        if (S3.size() > 0) {
            this.E.setVisibility(0);
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
        this.G.setIconImage(R.drawable.no_data);
        this.G.setDesp(R.string.no_data);
    }

    private void z2(List list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            PlaceBean placeBean = (PlaceBean) list.get(i3);
            CLog.b(t0, "dealWithInputqueryResult  item[" + i3 + "] getName=" + placeBean.getPoiName() + " getAddress=" + placeBean.getAddress() + " getDistrict=" + placeBean.getDistrict() + " getAdcode=" + placeBean.getAdCode() + " getPoiID=" + placeBean.getPoiId() + " getTypeCode=" + placeBean.getPoiTypeCode() + " getLatitude=" + placeBean.getLatitude() + " getLongitude=" + placeBean.getLongitude());
        }
        O0(list);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            PlaceBean placeBean2 = (PlaceBean) list.get(i4);
            if (!TextUtils.isEmpty(placeBean2.getPoiName())) {
                arrayList.add(n0(this.u, placeBean2));
            }
        }
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.G.setVisibility(8);
        if (arrayList.size() > 0) {
            arrayList.add(u0(2, getString(R.string.more_search_results)));
            this.F.A(arrayList);
            this.F.notifyDataSetChanged();
        } else {
            this.F.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.G.setVisibility(S3.size() > 0 ? 8 : 0);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
        }
        RelativeLayout relativeLayout = this.S;
        if (!p4()) {
            i2 = 8;
        }
        relativeLayout.setVisibility(i2);
    }

    private void z4(boolean z2) {
        int X2 = NaviUtil.X(getContext().getApplicationContext(), this.X);
        if (X2 == 0) {
            CLog.c(t0, "SearchFragment NAV_MODE_DRIVE");
            if (NaviUtil.E0(getContext().getApplicationContext())) {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.car : R.drawable.car_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.car_light : R.drawable.car_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.M.setBackgroundResource(R.drawable.navi_drive_btn_bg);
        } else if (X2 == 1) {
            CLog.c(t0, "SearchFragment NAV_MODE_RIDE");
            if (NaviUtil.E0(getContext().getApplicationContext())) {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.bike : R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.bike_light : R.drawable.bike_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.M.setBackgroundResource(R.drawable.navi_ride_btn_bg);
        } else if (X2 != 2) {
            CLog.b(t0, "setNavModeSelect  default.");
        } else {
            CLog.c(t0, "SearchFragment NAV_MODE_WALK");
            if (NaviUtil.E0(getContext().getApplicationContext())) {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.walk : R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getApplicationContext().getResources().getDrawable(z2 ? R.drawable.walk_light : R.drawable.walk_icon, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.M.setBackgroundResource(R.drawable.navi_walk_btn_bg);
        }
        this.L.setTextColor(getContext().getApplicationContext().getResources().getColor(z2 ? R.color.theme_color_2 : R.color.del_nor_address_color));
    }

    public final void A2(List list) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(y2((PlaceBean) list.get(i3)));
        }
        ArrayList arrayList2 = new ArrayList(this.P.n());
        String str = t0;
        CLog.b(str, "dealWithPoiResult()  modelList.size()=" + arrayList2.size() + " currentPage=" + this.W + " listSearchModel.size()=" + arrayList.size());
        if (this.W * 10 > 10) {
            CLog.b(str, "dealWithPoiResult()  #############  111111111111 ");
            arrayList2.remove(arrayList2.size() - 1);
            arrayList2.addAll(arrayList);
            if (arrayList.size() >= 10) {
                arrayList2.add(u0(2, getString(R.string.more_search_results)));
            }
            this.P.A(arrayList2);
        } else {
            CLog.b(str, "dealWithPoiResult()  #############  22222222222 ");
            if (arrayList.size() >= 10) {
                arrayList.add(u0(2, getString(R.string.more_search_results)));
            }
            this.P.A(arrayList);
        }
        if (!this.Z) {
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            EmptyDataView emptyDataView = this.G;
            if (list.size() > 0) {
                i2 = 8;
            }
            emptyDataView.setVisibility(i2);
            this.G.setIconImage(R.drawable.no_data);
        } else if (list.size() > 0) {
            this.P.notifyDataSetChanged();
            o4();
            this.Z = false;
        } else {
            this.V = "";
            this.F.n().clear();
            this.F.A(new ArrayList());
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.G.setVisibility(0);
        }
    }

    public final /* synthetic */ void A3(CustomDialog customDialog, NaviDatabase naviDatabase, SearchModel searchModel, CommonAddress commonAddress, View view) {
        customDialog.dismiss();
        this.T.setVisibility(8);
        naviDatabase.d().h(NaviUtil.t(), searchModel.getName(), searchModel.getAddress());
        naviDatabase.d().c(commonAddress);
        NaviUtil.E1(getContext().getApplicationContext());
        UToast.e(getContext().getApplicationContext(), R.string.add_common_addr_result, 0);
        this.I.setImageResource(R.drawable.add_address_icon_s);
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).initCommonAddr();
        this.q.l();
        this.C.l();
        SlideRecyclerView slideRecyclerView = this.E;
        if (slideRecyclerView != null) {
            slideRecyclerView.a();
        }
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null) {
            searchAdapter.notifyDataSetChanged();
        }
    }

    public final void A4(int i2) {
        String str = t0;
        CLog.b(str, "updateNaviModeUi mode=" + i2);
        boolean E0 = NaviUtil.E0(getContext().getApplicationContext());
        if (i2 == 0) {
            this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getResources().getDrawable(E0 ? R.drawable.car : R.drawable.car_light, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (i2 == 1) {
            this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getResources().getDrawable(E0 ? R.drawable.bike : R.drawable.bike_light, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (i2 == 2) {
            this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getResources().getDrawable(E0 ? R.drawable.walk : R.drawable.walk_light, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.L.setCompoundDrawablesRelativeWithIntrinsicBounds(getActivity().getResources().getDrawable(E0 ? R.drawable.car : R.drawable.car_light, (Resources.Theme) null), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void B(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        CLog.b(t0, "onEditAddressClick default ############## ");
        u4(searchModel);
        this.E.a();
        this.F.notifyDataSetChanged();
    }

    public void B0(boolean z2) {
        String str = t0;
        CLog.b(str, "onBleConnectState Connected=" + z2);
    }

    public final void B2(int i2) {
        if (i2 == 1804) {
            this.V = "";
            this.F.n().clear();
            this.F.A(new ArrayList());
            this.F.notifyDataSetChanged();
            this.C.setVisibility(8);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.G.setVisibility(0);
            this.G.setIconImage(R.drawable.poor_network);
            this.G.setDesp(R.string.poor_network);
            return;
        }
        this.V = "";
        this.F.n().clear();
        this.F.A(new ArrayList());
        this.F.notifyDataSetChanged();
        this.C.setVisibility(8);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.G.setVisibility(0);
        this.G.setIconImage(R.drawable.no_data);
    }

    public final /* synthetic */ void B3() {
        UToast.e(getContext().getApplicationContext(), R.string.please_disconnected, 0);
    }

    public final void B4() {
        SearchCommonView searchCommonView = this.R;
        if (searchCommonView == null) {
            CLog.b(t0, "updatesCommonAddressView() ######## searchCommonView is null!");
            return;
        }
        List<CommonAddress> aliasCustomInfo = searchCommonView.getAliasCustomInfo();
        String str = t0;
        CLog.b(str, "updatesCommonAddressView() ######## list.size()" + aliasCustomInfo.size() + " showMap=" + this.k0);
        this.R.setVisibility((aliasCustomInfo.size() <= 0 || this.k0) ? 8 : 0);
        this.R.setCommonAddressList(aliasCustomInfo);
        this.R.setListData(aliasCustomInfo);
        this.R.getAdapter().k(this.r0);
        this.R.getAdapter().notifyDataSetChanged();
    }

    public void C0(boolean z2) {
        String str = t0;
        CLog.b(str, "onDeviceConnectState: isOnline=" + z2 + " this.isHidden()=" + isHidden() + " isDeviceConnected()=" + w0());
        if (getActivity() == null) {
            CLog.b(str, "onDeviceConnectState  this.getContext() == null.");
            return;
        }
        getActivity().runOnUiThread(new z(this, z2));
        if (!z2 && !isHidden() && w0() && !NaviUtil.u0()) {
            getActivity().runOnUiThread(new b0(this));
        }
        K0(z2);
        z4(z2);
    }

    public final void C2(List list) {
        int i2 = 8;
        if (TextUtils.isEmpty(this.u.getText().toString())) {
            CLog.b(t0, "dealWithSearchSuccess() @@@@@@@@@@@");
            this.F.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            EmptyDataView emptyDataView = this.G;
            if (S3.size() <= 0) {
                i2 = 0;
            }
            emptyDataView.setVisibility(i2);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
            this.i = 1;
        } else if (list != null) {
            this.C.setVisibility(8);
            this.i = 3;
            A2(list);
        } else {
            this.i = 3;
            this.V = "";
            this.F.notifyDataSetChanged();
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            EmptyDataView emptyDataView2 = this.G;
            if (this.F.n().size() <= 0) {
                i2 = 0;
            }
            emptyDataView2.setVisibility(i2);
            this.G.setIconImage(R.drawable.no_data);
        }
    }

    public final /* synthetic */ void C3(float f) {
        ULocation g = LocationManager.f().g();
        if (g != null && this.m != null) {
            g.setBearing(((double) f) * 1.0d);
            this.m.p(g, false, false);
        }
    }

    public void D0() {
        CLog.b(t0, "onGpsStateChanged");
    }

    public final void D2() {
        if (getActivity() != null) {
            LocationUtil.e(getActivity(), 1003, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(SearchFragment.t0, "doButtonSearch onRefuseOpenGps() ");
                }

                public void b() {
                    SearchFragment.this.V3();
                    SearchFragment.this.m0.setImageResource(R.drawable.ic_arrow_back);
                    SearchFragment.this.n0 = true;
                    SearchFragment.this.S.setVisibility(8);
                    SearchFragment.this.R.setVisibility(8);
                    SearchFragment.this.Q.setVisibility(8);
                }
            });
        }
    }

    public final void D3(SearchModel searchModel) {
        this.X = searchModel;
        k0();
        if (this.k0) {
            this.o0 = true;
            this.v.setVisibility(0);
            this.u.setEnabled(false);
        }
        String str = t0;
        CLog.b(str, "isBackMapPage=" + this.o0);
        this.t.setVisibility(0);
        this.l.setVisibility(0);
        this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.transparent));
        this.l.setBackgroundColor(getActivity().getApplicationContext().getColor(R.color.transparent));
        f4(true);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.H.setVisibility(0);
        this.A.setVisibility(8);
        this.J.setText(searchModel.getName());
        this.v.setText(searchModel.getName());
        TextView textView = this.K;
        textView.setText(NaviUtil.r(getContext().getApplicationContext(), searchModel.getDistance()) + "   " + searchModel.getAddress());
        this.u.setText(searchModel.getName());
        this.u.setSelection(searchModel.getName().length());
        y4(searchModel);
        k2(searchModel);
    }

    public void E0(ULocation uLocation, PlaceBean placeBean) {
        if (uLocation != null && !this.Y) {
            this.Y = true;
            H3();
        }
        if (uLocation != null && uLocation.getErrorCode() == 0) {
            i2(uLocation, false);
        }
    }

    public final void E2() {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(t0, " doInputQuery() location is null object.");
            return;
        }
        M0(true);
        PoiSearchManager.f().b(getContext().getApplicationContext(), g.getCity(), this.U, new ULatLng(g.getLatitude(), g.getLongitude()), 1, new v(this));
    }

    public final void E3(PlaceBean placeBean, PlaceBean placeBean2) {
        String str = t0;
        CLog.b(str, "mapMark  ############## isDeviceConnected=" + StarryNetManger.getInstance().isDeviceConnected());
        placeBean.setPoiName(!TextUtils.isEmpty(placeBean2.getPoiName()) ? placeBean2.getPoiName() : placeBean.getPoiName());
        placeBean.setPoiId(!TextUtils.isEmpty(placeBean2.getPoiId()) ? placeBean2.getPoiId() : placeBean.getPoiId());
        SearchModel N2 = N2(placeBean);
        this.X = N2;
        this.m.d();
        G3();
        if (!this.H.isShown()) {
            this.i = 5;
            D3(N2);
        } else {
            this.i = 4;
            P2(N2, placeBean);
        }
        z4(StarryNetManger.getInstance().isDeviceConnected());
        NaviUtil.h0(getContext(), N2);
        this.S.setVisibility(8);
        this.Q.setVisibility(8);
        this.l0.setVisibility(8);
    }

    public void F(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        NaviDatabase naviDatabase = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase();
        String str = t0;
        CLog.b(str, "onDeleteClick data.toString()=" + searchModel.toString());
        List g = naviDatabase.f().g(NaviUtil.t());
        for (int i3 = 0; i3 < g.size(); i3++) {
            Record record = (Record) g.get(i3);
            if (searchModel.getName().equals(record.getName()) && searchModel.getAddress().equals(record.e()) && searchModel.getLatitude() == record.n() && searchModel.getLongitude() == record.p()) {
                String str2 = t0;
                CLog.b(str2, "onDeleteClick record is searched! record[" + i3 + "]=" + record.toString());
                naviDatabase.f().b(record);
                NaviUtil.l(getContext(), searchModel);
            }
        }
        if (this.F.n().size() == 2) {
            this.f = 1;
            List S3 = S3();
            this.F.n().clear();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.S.setVisibility(p4() ? 0 : 8);
            if (S3.size() > 0) {
                this.E.setVisibility(0);
                this.G.setVisibility(8);
                return;
            }
            this.G.setVisibility(8);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
            return;
        }
        this.E.a();
        this.F.n().clear();
        this.F.A(S3());
        this.F.notifyDataSetChanged();
    }

    public void F2() {
        if (getContext() == null) {
            CLog.b(t0, " doSearchQuery() getContext is null object.");
            return;
        }
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(t0, " doSearchQuery() location is null object.");
            return;
        }
        M0(true);
        ULatLng uLatLng = new ULatLng(g.getLatitude(), g.getLongitude());
        PoiSearchManager.f().k(this.W);
        PoiSearchManager.f().d(getContext().getApplicationContext(), g.getCity(), this.U, NaviUtil.V(this.g), uLatLng, 1, NaviUtil.R0(this.g), new f0(this));
    }

    public final void F3(List list, PlaceBean placeBean) {
        String str = t0;
        CLog.b(str, "mapPOIDeal   isShown()=" + this.E.isShown() + " isHidden=" + isHidden());
        M0(false);
        if (getContext() != null && list != null && list.size() != 0) {
            if (!this.E.isShown() && !isHidden()) {
                E3((PlaceBean) list.get(0), placeBean);
            }
            list.clear();
        }
    }

    public void G0(boolean z2) {
        if (!isHidden()) {
            p2();
        }
        v3(StarryNetManger.getInstance().isDeviceConnected());
    }

    public final boolean G2(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.m.d();
            H3();
            if (this.N.isShown()) {
                CLog.b(t0, "editOnTouch() &&&&&&& scrollLayout.isShown().");
                this.N.setVisibility(8);
                this.P.A(new ArrayList());
                this.P.notifyDataSetChanged();
                this.x.setVisibility(0);
                this.y.setVisibility(0);
                this.z.setVisibility(8);
                F2();
            } else if (this.H.isShown()) {
                CLog.b(t0, "editOnTouch() &&&&&&& bottmPanel.isShown().");
                this.H.setVisibility(8);
                this.x.setVisibility(0);
                this.y.setVisibility(0);
                this.z.setVisibility(8);
                F2();
            } else if (!this.E.isShown()) {
                CLog.b(t0, "editOnTouch() &&&&&&& !searchList.isShown().");
                this.w.setVisibility(0);
            }
        }
        return false;
    }

    public final void G3() {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            String str = t0;
            CLog.a(str, "markMyLocation: " + g.toString());
            if (g.getLatitude() != 0.0d || g.getLongitude() != 0.0d) {
                i2(g, false);
                return;
            }
            return;
        }
        CLog.b(t0, "markMyLocation() location is null. ");
    }

    public void H(float f) {
    }

    public final void H2() {
        getActivity().startActivityForResult(new Intent(getContext(), SettingActivity.class), 888);
    }

    public void I(int i2) {
    }

    public final void I2() {
        String str = t0;
        CLog.b(str, " fragmentBack() ##########   showMap=" + this.k0);
        getActivity().finish();
    }

    public final void I3(boolean z2) {
        ULocation g = LocationManager.f().g();
        if (g == null || this.m == null) {
            CLog.b(t0, "moveToMyLocation() location is null. ");
            return;
        }
        String str = t0;
        CLog.a(str, "moveToMyLocation location:" + g.toString());
        ULatLng uLatLng = new ULatLng(g.getLatitude(), g.getLongitude());
        if (uLatLng.latitude != 0.0d || uLatLng.longitude != 0.0d) {
            this.m.h(uLatLng);
            i2(g, false);
        }
    }

    public final void J3() {
        SearchModel searchModel = this.X;
        if (searchModel != null && this.m != null) {
            this.m.h(new ULatLng(searchModel.getLatitude(), this.X.getLongitude()));
        }
    }

    public final CommonAddress K2(SearchModel searchModel) {
        if (searchModel == null) {
            return null;
        }
        CommonAddress commonAddress = new CommonAddress();
        commonAddress.q(searchModel.getCity());
        commonAddress.o(searchModel.getAddress());
        commonAddress.n(searchModel.getAcode());
        commonAddress.p("custom_" + System.currentTimeMillis());
        commonAddress.t(searchModel.getLatitude());
        commonAddress.u(searchModel.getLongitude());
        commonAddress.s(searchModel.getDistrict());
        commonAddress.v(PoiSearchManager.f().i(searchModel.getName()) ? searchModel.getAddress() : searchModel.getName());
        commonAddress.x(System.currentTimeMillis());
        return commonAddress;
    }

    public final void K3() {
        if (getActivity() != null) {
            LocationUtil.e(getActivity(), 1003, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(SearchFragment.t0, "naviRoute onRefuseOpenGps() ");
                }

                public void b() {
                    if (SearchFragment.this.X != null) {
                        String h2 = SearchFragment.t0;
                        CLog.b(h2, "naviRoute poiSelectedModel is not null. poiSelectedModel=" + SearchFragment.this.X.toString());
                        SearchFragment searchFragment = SearchFragment.this;
                        searchFragment.q4(searchFragment.X, false);
                        return;
                    }
                    CLog.b(SearchFragment.t0, "naviRoute poiSelectedModel is null.");
                }
            });
        }
    }

    public void L3() {
        int e = PoiSearchManager.f().e();
        this.W++;
        CLog.b(t0, "nextButton() pageNum:" + e + " currentPage=" + this.W);
        F2();
    }

    public final void M3() {
        k0();
        this.u.setEnabled(true);
        this.v.setVisibility(8);
        this.v.setText("");
        this.p.setVisibility(0);
        this.t.setVisibility(8);
        this.l.setVisibility(0);
        f4(true);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.w.setVisibility(8);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.H.setVisibility(8);
        this.A.setVisibility(8);
        this.m.d();
        this.u.setText("");
        I3(true);
        this.i = 0;
        v3(StarryNetManger.getInstance().isDeviceConnected());
    }

    public final SearchModel N2(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setAcode(placeBean.getPoiId());
        searchModel.setAddress(placeBean.getAddress());
        searchModel.setName(placeBean.getPoiName());
        searchModel.setCity(placeBean.getCity());
        searchModel.setDistrict(placeBean.getDistrict());
        ULocation g = LocationManager.f().g();
        if (g != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g.getLatitude(), g.getLongitude()), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()))));
        }
        String str = t0;
        CLog.b(str, "getPoiSelectMode  ############## model=" + searchModel.toString());
        return searchModel;
    }

    public void N3(int i2) {
        if (!NaviUtil.D0(getContext().getApplicationContext())) {
            if (!this.h0) {
                this.h0 = true;
                UToast.e(getContext().getApplicationContext(), R.string.network_no_available, 0);
                this.j0.sendEmptyMessageDelayed(1200, AssistantConstants.TIMEOUT_VAD_MUTE);
            }
        } else if (getActivity() != null) {
            LocationUtil.e(getActivity(), i2, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(SearchFragment.t0, "onClickLocation onRefuseOpenGps() ");
                }

                public void b() {
                    SearchFragment.this.I3(true);
                }
            });
        }
    }

    public final SearchModel O2(CommonAddress commonAddress) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(commonAddress.j());
        searchModel.setAcode(commonAddress.b());
        searchModel.setAddress(commonAddress.c());
        searchModel.setDistrict(commonAddress.g());
        searchModel.setKeywords(this.u.getText().toString());
        searchModel.setLatitude(commonAddress.h());
        searchModel.setLongitude(commonAddress.i());
        searchModel.setCity(commonAddress.e());
        searchModel.setType(0);
        searchModel.setDistance(a4(commonAddress));
        return searchModel;
    }

    /* renamed from: O3 */
    public final void t3(PlaceBean placeBean) {
        if (getContext() == null || placeBean == null) {
            CLog.b(t0, "onMapPOIClick  this Context or poi object is null.");
            return;
        }
        String str = t0;
        CLog.b(str, "onMapPOIClick  poi.getPoiName()=" + placeBean.getPoiName() + " getPoiId=" + placeBean.getPoiId() + " getLatitude=" + placeBean.getLatitude() + " getLongitude=" + placeBean.getLongitude() + " scrollLayout.isShown()" + this.N.isShown() + " isHidden()=" + isHidden());
        if (!NaviUtil.D0(getContext().getApplicationContext())) {
            CLog.b(str, "onMapPOIClick  netWork not Available hasShowToast=" + this.h0);
            if (!this.h0) {
                this.h0 = true;
                UToast.e(getContext().getApplicationContext(), R.string.network_no_available, 0);
                this.j0.sendEmptyMessageDelayed(1200, AssistantConstants.TIMEOUT_VAD_MUTE);
            }
        } else if (!this.N.isShown() && getContext() != null) {
            M0(true);
            PoiSearchManager.f().c(getContext().getApplicationContext(), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()), new g0(this, placeBean));
        }
    }

    public void P0(boolean z2) {
        this.k0 = z2;
    }

    public final void P2(SearchModel searchModel, PlaceBean placeBean) {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g.getLatitude(), g.getLongitude()), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()))));
        }
        String str = t0;
        CLog.b(str, "gotoDetail  model=" + searchModel.toString());
        this.J.setText(searchModel.getName());
        TextView textView = this.K;
        textView.setText(NaviUtil.r(getContext().getApplicationContext(), searchModel.getDistance()) + "   " + searchModel.getAddress());
        this.u.setText(searchModel.getName());
        this.v.setText(searchModel.getName());
        this.u.setSelection(searchModel.getName().length());
        y4(searchModel);
        k2(searchModel);
    }

    public void P3(List list) {
        M0(false);
        this.S.setVisibility(8);
        if (list == null || list.size() <= 0) {
            B2(1084);
        } else {
            C2(list);
        }
    }

    public final void Q2(int i2) {
        String str = t0;
        CLog.b(str, "historyItemClick() #######  enabledDetail =" + this.p0);
        if (!this.p0) {
            this.p0 = true;
            this.E.a();
            SearchModel searchModel = (SearchModel) this.F.n().get(i2);
            if (searchModel.getDistance() == -2) {
                this.u.setText(searchModel.getName());
                this.u.setSelection(searchModel.getName().length());
                NaviUtil.h0(getContext(), searchModel);
                this.j0.sendEmptyMessageDelayed(1600, 500);
                return;
            }
            NaviUtil.h0(getContext(), searchModel);
            W3(searchModel, i2);
            this.j0.sendEmptyMessageDelayed(1600, 250);
        }
    }

    public final void Q3() {
        this.t.setVisibility(0);
        this.D.setVisibility(0);
        this.Q.setVisibility(0);
        this.E.setVisibility(0);
        this.S.setVisibility(8);
        this.n0 = false;
        f4(false);
        B4();
        this.m0.setImageResource(R.drawable.btn_search);
        this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.theme_black_3_color));
        this.l.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.theme_black_3_color));
    }

    public final void R2() {
        if (!this.n0) {
            return;
        }
        if (this.o0) {
            M3();
        } else {
            onBackPressed();
        }
    }

    public final void R3() {
        f4(false);
        this.t.setVisibility(0);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        this.m0.setImageResource(R.drawable.ic_arrow_back);
        this.n0 = true;
        this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.theme_black_3_color));
        this.l.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.theme_black_3_color));
    }

    public void S0(SearchModel searchModel, boolean z2, int i2) {
        String str = t0;
        CLog.b(str, "updateFragmentData   direct=" + z2 + " quikType=" + i2 + " showMap=" + this.k0);
        if (!z2) {
            return;
        }
        if (this.H.isShown()) {
            m2();
            U3();
            Y3();
        } else if (this.N.isShown()) {
            U3();
            Y3();
        } else if (this.D.isShown()) {
            Y3();
        } else if (getActivity() != null) {
            I2();
        }
    }

    public final void S2(Bundle bundle, View view) {
        TitleView titleView = (TitleView) view.findViewById(R.id.title_panel);
        this.s = titleView;
        titleView.setActivity(getActivity());
        this.s.setOnMenueClickListener(new h0(this));
        BaseMapView baseMapView = (BaseMapView) view.findViewById(R.id.mapView);
        this.m = baseMapView;
        baseMapView.i(bundle);
        EmptyDataView emptyDataView = (EmptyDataView) view.findViewById(R.id.netWorkNo);
        this.n = emptyDataView;
        emptyDataView.setIconImage(R.drawable.invalide_network);
        this.n.setDesp(R.string.network_no_available);
        this.o = (FrameLayout) view.findViewById(R.id.statusBarFrame);
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.search_list_layout);
        this.D = nestedScrollView;
        nestedScrollView.setOnTouchListener(new j0(this));
        SlideRecyclerView slideRecyclerView = (SlideRecyclerView) view.findViewById(R.id.search_list);
        this.E = slideRecyclerView;
        slideRecyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        this.E.setOnTouchListener(new k0(this));
        this.G = (EmptyDataView) view.findViewById(R.id.search_empty_data);
        this.k = (LinearLayout) view.findViewById(R.id.search_top_panel_layout);
        this.l = (ConstraintLayout) view.findViewById(R.id.top_layout);
        this.p = (ConstraintLayout) view.findViewById(R.id.search_bottom_edit_layout);
        SearchMenuView searchMenuView = (SearchMenuView) view.findViewById(R.id.bottomSearchMenuView);
        this.q = searchMenuView;
        searchMenuView.setActivity(getActivity());
        this.q.setBottomLineVisible(false);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.bottom_edit);
        this.r = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new l0(this));
        this.r.setFocusable(false);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) view.findViewById(R.id.keyWord);
        this.u = autoCompleteTextView2;
        autoCompleteTextView2.addTextChangedListener(this);
        this.u.setOnTouchListener(new m0(this));
        this.u.setOnEditorActionListener(new n0(this));
        this.v = (TextView) view.findViewById(R.id.map_poi_desp);
        ImageView imageView = (ImageView) view.findViewById(R.id.search_title_back);
        this.w = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.trafficStatus);
        this.A = imageView2;
        imageView2.setOnClickListener(this);
        this.A.setVisibility(8);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.my_location);
        this.B = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.content_clean);
        this.x = imageView4;
        imageView4.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.search);
        this.y = textView;
        textView.setOnClickListener(this);
        ImageView imageView5 = (ImageView) view.findViewById(R.id.search_edit_close);
        this.z = imageView5;
        imageView5.setOnClickListener(this);
        SearchMenuView searchMenuView2 = (SearchMenuView) view.findViewById(R.id.searchmenu);
        this.C = searchMenuView2;
        searchMenuView2.getNaviSetting().setVisibility(8);
        this.C.setActivity(getActivity());
        this.C.setBottomLineVisible(true);
        this.C.setOnMenuClicked(new o0(this));
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.bottm_panel);
        this.H = constraintLayout;
        constraintLayout.setOnClickListener((View.OnClickListener) null);
        ImageView imageView6 = (ImageView) view.findViewById(R.id.add_nor_address);
        this.I = imageView6;
        imageView6.setOnClickListener(new q(this));
        TextView textView2 = (TextView) view.findViewById(R.id.place_name);
        this.J = textView2;
        textView2.setOnClickListener(this);
        this.K = (TextView) view.findViewById(R.id.address);
        TextView textView3 = (TextView) view.findViewById(R.id.navigation);
        this.L = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) view.findViewById(R.id.navi_route);
        this.M = textView4;
        textView4.setOnClickListener(this);
        this.b = (NaviProgressView) view.findViewById(R.id.loadingProgress);
        this.T = view.findViewById(R.id.viewMask);
        ((ImageView) view.findViewById(R.id.search_title_setting)).setOnClickListener(new r(this));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.search_title_layout);
        this.Q = relativeLayout;
        relativeLayout.setOnTouchListener(new s(this));
        this.R = (SearchCommonView) view.findViewById(R.id.search_common_view);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.search_want_view);
        this.S = relativeLayout2;
        relativeLayout2.setOnClickListener(new i0());
        view.findViewById(R.id.title_panel_layout).setOnClickListener((View.OnClickListener) null);
        NoConnectedView noConnectedView = (NoConnectedView) view.findViewById(R.id.not_connected_view);
        this.l0 = noConnectedView;
        noConnectedView.setNoConnectedViewActionistener(this.q0);
        ImageView imageView7 = (ImageView) view.findViewById(R.id.home_panel_icon);
        this.m0 = imageView7;
        imageView7.setOnClickListener(this);
    }

    public void T0(float f) {
        super.T0(f);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new p(this, f));
        }
    }

    public final void T3() {
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null && searchAdapter.n() != null) {
            CLog.b(t0, "resetSearch() ############# @@@@@@@@@@@");
            this.F.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.S.setVisibility(p4() ? 0 : 8);
            if (!this.k0 && this.R.getCommonAddressList().size() > 0) {
                this.R.setVisibility(0);
            }
            if (S3.size() > 0) {
                this.E.setVisibility(0);
                this.G.setVisibility(8);
            } else {
                this.E.setVisibility(8);
                this.R.setVisibility(8);
                this.Q.setVisibility(8);
                this.G.setVisibility(8);
                this.G.setIconImage(R.drawable.no_data);
                this.G.setDesp(R.string.no_data);
            }
            this.x.setVisibility(8);
            this.y.setVisibility(8);
        }
    }

    public final void U3() {
        this.m.d();
        H3();
        this.N.setVisibility(8);
        this.P.A(new ArrayList());
        this.P.notifyDataSetChanged();
        this.k.setBackgroundResource(R.drawable.edit_scroll_bg);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.u.setText(this.V);
        this.u.setSelection(this.V.length());
        this.U = j0(this.u);
        this.V = "";
        this.W = 1;
        if (this.H.isShown() || TextUtils.isEmpty(this.u.getText())) {
            k4();
        } else {
            E2();
        }
    }

    public final void V2() {
        ((FrameLayout) this.j.findViewById(R.id.marginTopView)).addView(DensityUtils.d(getContext()));
    }

    public void V3() {
        String j02 = j0(this.u);
        this.U = j02;
        this.V = j02;
        String str = t0;
        CLog.b(str, " searchButton() keyWord=" + this.U);
        if ("".equals(this.U)) {
            UToast.e(getContext().getApplicationContext().getApplicationContext(), R.string.navi_search_keyword_desp, 1);
            return;
        }
        NaviUtil.k0(getContext(), this.U);
        this.Z = true;
        this.N.setMaxOffset(DensityUtils.b(getContext().getApplicationContext()) / 2);
        this.N.u();
        F2();
    }

    public final void W2(View view) {
        ScrollLayout scrollLayout = (ScrollLayout) view.findViewById(R.id.layout_scroll);
        this.N = scrollLayout;
        scrollLayout.setMinOffset(0);
        this.N.setIsSupportExit(true);
        this.N.setAllowHorizontalScroll(true);
        this.N.t();
        this.N.setOnScrollChangedListener(this);
        this.O = (ContentRecyclerView) view.findViewById(R.id.search_result_recycler);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext().getApplicationContext(), 1);
        dividerItemDecoration.setDrawable(getContext().getApplicationContext().getDrawable(R.drawable.divider_bg));
        this.O.addItemDecoration(dividerItemDecoration);
        this.O.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        SearchAdapter searchAdapter = new SearchAdapter(getActivity(), new ArrayList(), true);
        this.P = searchAdapter;
        searchAdapter.B(this.s0);
        this.O.setAdapter(this.P);
    }

    public final void W3(SearchModel searchModel, int i2) {
        this.i = 4;
        this.m.d();
        G3();
        this.X = searchModel;
        k0();
        this.m0.setImageResource(R.drawable.ic_arrow_back);
        this.n0 = true;
        this.S.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.transparent));
        this.l.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.transparent));
        f4(true);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.R.setVisibility(8);
        this.Q.setVisibility(8);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(0);
        this.H.setVisibility(0);
        this.A.setVisibility(8);
        this.J.setText(searchModel.getName());
        TextView textView = this.K;
        textView.setText(NaviUtil.r(getContext().getApplicationContext(), searchModel.getDistance()) + "   " + searchModel.getAddress());
        this.u.setText(searchModel.getName());
        this.u.setSelection(searchModel.getName().length());
        y4(searchModel);
        k2(searchModel);
        z4(StarryNetManger.getInstance().isDeviceConnected());
    }

    public final void X2(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.search_scroll);
        this.t = linearLayout;
        linearLayout.setOnTouchListener(new u(this));
    }

    public final void X3() {
        CLog.b(t0, "searchEditClose() ##########");
        int i2 = 8;
        this.N.setVisibility(8);
        SearchAdapter searchAdapter = this.P;
        if (searchAdapter != null) {
            searchAdapter.A(new ArrayList());
            this.P.notifyDataSetChanged();
        }
        this.l.setVisibility(0);
        this.k.setBackgroundResource(R.drawable.edit_scroll_bg);
        this.E.setVisibility(0);
        this.D.setVisibility(0);
        this.S.setVisibility(p4() ? 0 : 8);
        SearchAdapter searchAdapter2 = this.F;
        if (searchAdapter2 != null) {
            this.G.setVisibility(searchAdapter2.n().size() > 0 ? 0 : 8);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
            this.F.notifyDataSetChanged();
        }
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.u.setText("");
        this.H.setVisibility(8);
        this.m.d();
        H3();
        SearchAdapter searchAdapter3 = this.F;
        if (searchAdapter3 != null) {
            searchAdapter3.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            SlideRecyclerView slideRecyclerView = this.E;
            if (S3.size() > 0) {
                i2 = 0;
            }
            slideRecyclerView.setVisibility(i2);
        }
    }

    public final void Y2() {
        CLog.b(t0, "initSearchViewData() ##########");
        List S3 = S3();
        if (p4()) {
            this.S.setVisibility(0);
            this.E.setVisibility(8);
        } else {
            this.S.setVisibility(8);
            this.E.setVisibility(0);
        }
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter == null) {
            SearchAdapter searchAdapter2 = new SearchAdapter(getContext(), S3, false);
            this.F = searchAdapter2;
            searchAdapter2.B(this);
            this.E.setAdapter(this.F);
        } else {
            searchAdapter.n().clear();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
        }
        this.C.setVisibility(TextUtils.isEmpty(this.u.getText().toString()) ? 0 : 8);
        if (S3.size() > 0) {
            this.E.setVisibility(0);
            if (this.k0) {
                this.Q.setVisibility(8);
                this.R.setVisibility(8);
                this.m0.setImageResource(R.drawable.ic_arrow_back);
                this.n0 = true;
                this.C.l();
            } else {
                this.R.setVisibility(0);
            }
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(8);
        this.G.setIconImage(R.drawable.no_data);
        this.G.setDesp(R.string.no_data);
    }

    public final void Y3() {
        String str = t0;
        CLog.b(str, " searchListLayoutBack() @@@  keyWord " + this.U + " latestKeyWord=" + this.V);
        if (!TextUtils.isEmpty(this.U) && !TextUtils.isEmpty(this.V) && !this.U.equals(this.V)) {
            CLog.b(str, " searchListLayoutBack() &&&&&&&&&&");
            String str2 = this.V;
            this.U = str2;
            this.u.setText(str2);
            this.u.setSelection(this.U.length());
            E2();
            this.V = "";
        } else if (!TextUtils.isEmpty(this.u.getText())) {
            CLog.b(str, " searchListLayoutBack() ####");
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            List S3 = S3();
            if (this.F != null) {
                CLog.b(str, " searchListLayoutBack() %%%%%%%%%%%%");
                this.F.n().clear();
                this.F.A(S3);
                this.F.notifyDataSetChanged();
            }
            this.S.setVisibility(p4() ? 0 : 8);
            this.G.setVisibility(S3.size() > 0 ? 8 : 0);
            this.G.setIconImage(R.drawable.no_data);
            this.G.setDesp(R.string.no_data);
            this.w.setVisibility(0);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.l.setVisibility(0);
            this.k.setBackgroundResource(R.drawable.edit_scroll_bg);
            this.U = j0(this.u);
            this.W = 1;
            this.u.setText("");
            this.i = 1;
        } else if (this.t.isShown()) {
            CLog.b(str, " searchListLayoutBack() %%%%%");
            this.V = "";
            k0();
            this.t.setVisibility(8);
            this.p.setVisibility(0);
            this.f = 1;
            this.u.setText("");
            this.i = 0;
        } else {
            CLog.b(str, " searchListLayoutBack() ********");
            onBackPressed();
        }
    }

    public final void Z3() {
        String str = t0;
        CLog.b(str, " searchListLayoutBackPress()  searchCommonView.isShown()=" + this.R.isShown() + " getCommonAddressList().size=" + this.R.getCommonAddressList().size());
        if (this.k0) {
            Y3();
            this.m.setVisibility(0);
            this.l0.setVisibility(0);
        } else if (!this.R.isShown() && this.R.getCommonAddressList().size() > 0) {
            this.R.setVisibility(0);
            n4();
        } else if (!TextUtils.isEmpty(this.u.getText().toString())) {
            n4();
        } else {
            getActivity().finish();
        }
    }

    public final int a4(CommonAddress commonAddress) {
        ULocation g = LocationManager.f().g();
        if (g == null) {
            CLog.b(t0, "searchModelDistance() location object is null. ");
            return 0;
        }
        float e = NaviUtil.e(new ULatLng(commonAddress.h(), commonAddress.i()), new ULatLng(g.getLatitude(), g.getLongitude()));
        String str = t0;
        CLog.b(str, "searchModelDistance  distance==" + e);
        return (int) e;
    }

    public void afterTextChanged(Editable editable) {
    }

    public final void b4() {
        if (this.k0) {
            onBackPressed();
        } else {
            getActivity().finish();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void c3() {
        if (this.H.isShown() || TextUtils.isEmpty(this.u.getText())) {
            CLog.b(t0, "itemMoreClick searchAdapter ##############");
            this.E.a();
            if (M2(this.f + 1).size() > 0) {
                this.f++;
            }
            this.F.A(L2());
            this.F.notifyDataSetChanged();
            return;
        }
        CLog.b(t0, "itemMoreClick searchAdapter @@@@@@@@@@@@@@");
        D2();
    }

    public final void c4() {
        if (this.k0) {
            R3();
        } else {
            Q3();
        }
    }

    public void d(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        int type = searchModel.getType();
        String str = t0;
        CLog.b(str, "onItemClick() ####### other. viewType=" + type + " enabledDetail=" + this.p0);
        if (type == 0) {
            v2(i2, searchModel);
        } else if (type == 1) {
            Q2(i2);
        } else if (type == 2) {
            c3();
        } else if (type != 3) {
            CLog.b(str, "onItemClick default ############## viewType=" + type);
        } else {
            t2();
        }
    }

    public final /* synthetic */ void d3(DialogInterface dialogInterface) {
        this.T.setVisibility(8);
    }

    public final void d4(SearchModel searchModel) {
        String str = t0;
        CLog.b(str, "setNaviModeUi() &&&&&&& model=" + searchModel.toString());
        A4(NaviUtil.X(getContext().getApplicationContext(), searchModel));
    }

    public void e(RecyclerView recyclerView, View view, int i2, SearchModel searchModel) {
        SearchModel searchModel2 = (SearchModel) this.F.n().get(i2);
        NaviUtil.h0(getContext(), searchModel2);
        q4(searchModel2, false);
    }

    public final /* synthetic */ void e3(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        this.T.setVisibility(8);
        k0();
    }

    public final void e4() {
        CLog.b(t0, "showSearchList() ##### Enter.");
        this.Z = false;
        this.p.setVisibility(8);
        this.t.setVisibility(0);
        this.l0.setVisibility(8);
        this.r.setFocusable(false);
    }

    public final /* synthetic */ void f3(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        k0();
        x2();
        int i2 = 8;
        this.T.setVisibility(8);
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null) {
            searchAdapter.n();
        } else {
            new ArrayList();
        }
        RelativeLayout relativeLayout = this.S;
        if (p4()) {
            i2 = 0;
        }
        relativeLayout.setVisibility(i2);
    }

    public final void f4(boolean z2) {
        LinearLayout linearLayout = this.t;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(getContext().getColor(z2 ? R.color.transparent : R.color.theme_black_3_color));
        }
    }

    public final /* synthetic */ void g3(List list) {
        if (getContext() != null) {
            b3(list);
        }
        if (list != null) {
            list.clear();
        }
    }

    public final /* synthetic */ void h3(List list) {
        if (getContext() != null) {
            P3(list);
        }
        if (list != null) {
            list.clear();
        }
    }

    public final boolean h4() {
        if (!NaviUtil.m0(getContext().getApplicationContext())) {
            return false;
        }
        UToast.g(getContext().getApplicationContext(), String.format(getContext().getString(R.string.addr_more_full), new Object[]{"12"}), 0);
        return true;
    }

    public final /* synthetic */ void i3(View view) {
        getActivity().finish();
    }

    public final void i4(NaviDatabase naviDatabase, SearchModel searchModel, CommonAddress commonAddress) {
        this.T.setVisibility(0);
        CustomDialog customDialog = new CustomDialog(getActivity());
        customDialog.setOnDismissListener(new c0(this));
        customDialog.j(NaviUtil.A(getContext().getApplicationContext(), searchModel, true, searchModel.getAlias())).i(NaviUtil.A(getContext().getApplicationContext(), searchModel, false, searchModel.getAlias())).e(getString(17039360), new d0(this, customDialog)).f(getString(17039370), new e0(this, customDialog, naviDatabase, searchModel, commonAddress)).show();
    }

    public final void j2() {
        SearchModel searchModel = (SearchModel) this.P.n().get(0);
        int i2 = 5;
        int i3 = 1;
        while (i3 < this.P.n().size() && i3 < i2) {
            SearchModel searchModel2 = (SearchModel) this.P.n().get(i3);
            int e = (int) NaviUtil.e(new ULatLng(searchModel2.getLatitude(), searchModel2.getLongitude()), new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
            if (!searchModel2.getAddress().equals(searchModel.getAddress()) || e >= 10) {
                l2(searchModel2);
            } else {
                i2++;
            }
            i3++;
        }
    }

    public final /* synthetic */ boolean j3(View view, MotionEvent motionEvent) {
        return t4();
    }

    public void k0() {
        CLog.b(t0, "closeInputMethod");
        ((InputMethodManager) getContext().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(this.u.getWindowToken(), 0);
    }

    public final void k4() {
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        f4(false);
        String str = t0;
        CLog.b(str, "showRecord() ##########");
        List S3 = S3();
        if (this.F != null) {
            CLog.b(str, "showRecord() ####&&&&&&&&&&######");
            this.F.n().clear();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
        }
        this.S.setVisibility(p4() ? 0 : 8);
        this.G.setVisibility(S3.size() > 0 ? 8 : 0);
        this.G.setIconImage(R.drawable.no_data);
        this.G.setDesp(R.string.no_data);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setBackgroundResource(R.drawable.edit_scroll_bg);
        this.i = 1;
    }

    public final void l2(SearchModel searchModel) {
        if (searchModel != null) {
            this.m.c(new ULatLng(searchModel.getLatitude(), searchModel.getLongitude()));
        }
    }

    public final /* synthetic */ boolean l3(View view, MotionEvent motionEvent) {
        return t4();
    }

    public final void l4() {
        this.u.requestFocus();
        this.u.setSelection(0);
        ((InputMethodManager) getContext().getApplicationContext().getSystemService("input_method")).showSoftInput(this.u, 0);
    }

    public final void m2() {
        this.m.d();
        this.H.setVisibility(8);
        this.A.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setBackgroundResource(R.drawable.edit_scroll_bg);
        H3();
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.u.setText(this.V);
        this.u.setSelection(this.V.length());
        this.U = j0(this.u);
        this.V = "";
        this.W = 1;
        if (this.H.isShown() || TextUtils.isEmpty(this.u.getText())) {
            k4();
        } else {
            E2();
        }
    }

    public final /* synthetic */ boolean m3(View view, MotionEvent motionEvent) {
        return t4();
    }

    public final void m4() {
        this.Z = false;
        String str = t0;
        CLog.b(str, "showSearchList() searchBottomEditLayout.  isShown=" + this.p.isShown());
        if (this.p.isShown()) {
            e4();
            Y2();
            l4();
            this.C.setVisibility(0);
            this.i = 1;
        }
    }

    public final void n2() {
        if (this.o0) {
            M3();
            return;
        }
        m2();
        this.D.setVisibility(0);
    }

    public final /* synthetic */ boolean n3(View view, MotionEvent motionEvent) {
        return o2(motionEvent);
    }

    public final void n4() {
        this.u.setText("");
        this.W = 1;
        k4();
    }

    public final boolean o2(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            String str = t0;
            CLog.b(str, "bottomEditOnTouch isBackMapPage=" + this.o0);
            M0(false);
            f4(false);
            this.o0 = false;
            this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.theme_black_3_color));
            m4();
        }
        return false;
    }

    public final /* synthetic */ boolean o3(View view, MotionEvent motionEvent) {
        return G2(motionEvent);
    }

    public final void o4() {
        k0();
        this.N.setVisibility(0);
        this.E.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setBackgroundColor(getContext().getApplicationContext().getColor(R.color.transparent));
        this.l.setBackgroundColor(getActivity().getApplicationContext().getColor(R.color.transparent));
        f4(true);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.G.setVisibility(8);
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(0);
        this.t.setVisibility(0);
        String str = t0;
        CLog.b(str, "showSearchScrollView  scrollLayout.getCurrentStatus()=" + this.N.getCurrentStatus());
        if (this.N.getCurrentStatus() != ScrollLayout.Status.CLOSED) {
            this.j0.sendEmptyMessageDelayed(Ring2TrackerConstant.MSG_CONNECT_TIMEOUT, 500);
        }
        SearchModel searchModel = (SearchModel) this.P.n().get(0);
        y4(searchModel);
        k2(searchModel);
        j2();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String str = t0;
        CLog.b(str, "onActivityCreated() &&&&&&& Enter.  showMap=" + this.k0);
        if (!this.k0) {
            e4();
            Y2();
            this.j0.sendEmptyMessageDelayed(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, 250);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        String str = t0;
        CLog.b(str, "onActivityResult   requestCode=" + i2 + " resultCode=" + i3);
        if (1003 == i2) {
            N3(i2);
        }
    }

    public void onBackPressed() {
        String str = t0;
        CLog.b(str, " onBackPressed() isBackMapPage=" + this.o0 + " showMap" + this.k0 + " bottmPanel.isShown()=" + this.H.isShown() + " searchTopPanelLayout.isShown()=" + this.k.isShown());
        SlideRecyclerView slideRecyclerView = this.E;
        if (slideRecyclerView != null) {
            slideRecyclerView.a();
        }
        if (this.H.isShown()) {
            n2();
        } else if (this.N.isShown()) {
            U3();
        } else if (this.D.isShown()) {
            Z3();
        } else if (getActivity() != null) {
            I2();
        }
        if (this.k.isShown()) {
            c4();
        }
        v3(StarryNetManger.getInstance().isDeviceConnected());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.search) {
            D2();
        } else if (id == R.id.search_title_back) {
            b4();
        } else if (id == R.id.content_clean) {
            s2();
        } else if (id == R.id.search_edit_close) {
            u2();
        } else if (id == R.id.navigation) {
            r4(this.X);
        } else if (id == R.id.navi_route) {
            K3();
        } else if (id == R.id.trafficStatus) {
            g4();
        } else if (id == R.id.my_location) {
            N3(1003);
        } else if (id == R.id.place_name) {
            J3();
        } else if (id == R.id.home_panel_icon) {
            R2();
        }
    }

    public void onCreate(Bundle bundle) {
        CLog.b(t0, "onCreate() &&&&&&& Enter.");
        NaviUtil.s1(false);
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).setEnterType(0);
        super.onCreate(bundle);
        J2();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CLog.b(t0, "onCreateView() &&&&&&& Enter.");
        View inflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
        this.j = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        String str = t0;
        CLog.b(str, " onDestroy()  isHidden=" + isHidden());
        r2();
        q2();
        NaviUtil.s1(true);
        CLog.b(str, " onDestroy() finish!");
    }

    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        String str = t0;
        CLog.b(str, " onHiddenChanged() hidden=" + z2);
        if (!z2) {
            A4(NaviUtil.X(getContext().getApplicationContext(), this.X));
            CLog.c(str, "onHiddenChanged updateNaviBtnState");
            z4(StarryNetManger.getInstance().isDeviceConnected());
        }
    }

    public void onPause() {
        super.onPause();
        BaseMapView baseMapView = this.m;
        if (baseMapView != null) {
            baseMapView.k();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        String str = t0;
        CLog.b(str, "onRequestPermissionsResult  requestCode " + i2);
        if (508 == i2 && NaviUtil.S0(getContext().getApplicationContext())) {
            j4();
        }
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).startLocation(getContext().getApplicationContext());
    }

    public void onResume() {
        super.onResume();
        BaseMapView baseMapView = this.m;
        if (baseMapView != null) {
            baseMapView.l();
        }
        w4();
        NaviOperatorManager.getInstance(getContext().getApplicationContext()).initCommonAddr();
        this.q.setCustomText(NaviManager.getInstance(getContext().getApplicationContext()).getCustomName());
        this.q.l();
        if (!this.k0) {
            f4(this.Q.getVisibility() != 0);
        }
        this.C.setCustomText(NaviManager.getInstance(getContext().getApplicationContext()).getCustomName());
        this.C.l();
        if (this.g0 && NaviUtil.S0(getContext().getApplicationContext())) {
            this.g0 = false;
            j4();
        }
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null) {
            searchAdapter.notifyDataSetChanged();
        }
        B4();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseMapView baseMapView = this.m;
        if (baseMapView != null) {
            baseMapView.m(bundle);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!TextUtils.isEmpty(charSequence.toString().trim())) {
            s4();
            return;
        }
        this.C.setVisibility(this.k0 ? 0 : 8);
        T3();
        this.i = 1;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        CLog.b(t0, "onViewCreated() &&&&&&& Enter.");
        T2();
        S2(bundle, view);
        U2();
        Z2();
        V2();
        X2(view);
        W2(view);
        p2();
        T0(this.d);
        H3();
        v3(StarryNetManger.getInstance().isDeviceConnected());
    }

    public void p(ScrollLayout.Status status) {
        if (status == ScrollLayout.Status.EXIT) {
            this.N.setVisibility(8);
            this.P.A(new ArrayList());
            this.P.notifyDataSetChanged();
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(8);
            this.U = j0(this.u);
            this.W = 1;
            if (!this.H.isShown()) {
                E2();
            }
        }
    }

    public final void p2() {
        if (getContext() == null) {
            CLog.b(t0, "checkNetWorkAndDisplay  this.getContext() == null.");
            return;
        }
        boolean D0 = NaviUtil.D0(getContext().getApplicationContext());
        if (!D0 && this.m.isShown()) {
            CLog.b(t0, "checkNetWorkAndDisplay: network_anomaly!");
            UToast.e(getContext().getApplicationContext(), R.string.network_anomaly, 0);
        }
        if (!CSharedPreferences.b(getContext().getApplicationContext(), "has_enter_navi", false)) {
            if (D0) {
                CLog.b(t0, "checkNetWork: NetWork Available!");
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                this.B.setVisibility(0);
                CSharedPreferences.p(getContext().getApplicationContext(), "has_enter_navi", true);
                return;
            }
            CLog.b(t0, "checkNetWork: NetWork not Available!");
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            this.B.setVisibility(8);
        }
    }

    public final /* synthetic */ boolean p3(TextView textView, int i2, KeyEvent keyEvent) {
        return a3(i2);
    }

    public final boolean p4() {
        if (this.F == null) {
            return true;
        }
        if (this.R.getCommonAddressList().size() > 0 || this.F.n().size() > 1) {
            return false;
        }
        String str = t0;
        CLog.b(str, "showWantView getCommonAddressList.size=" + this.R.getCommonAddressList().size() + " getModelList=" + this.F.n().size());
        return this.F.n().size() == 1 && this.F.getItemViewType(0) == 4;
    }

    public final void q2() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        FrameLayout frameLayout = this.o;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        AutoCompleteTextView autoCompleteTextView = this.u;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.removeTextChangedListener(this);
        }
        ContentRecyclerView contentRecyclerView = this.O;
        if (contentRecyclerView != null) {
            contentRecyclerView.removeAllViews();
        }
        BaseMapView baseMapView = this.m;
        if (baseMapView != null) {
            baseMapView.d();
            this.m.j();
        }
        this.g.clear();
        NaviProgressView naviProgressView = this.b;
        if (naviProgressView != null) {
            naviProgressView.b();
        }
    }

    public final /* synthetic */ void q3(int i2) {
        x4();
    }

    public final void q4(SearchModel searchModel, boolean z2) {
        if (searchModel == null) {
            CLog.b(t0, "startNaviActivity()  model is empty.");
            return;
        }
        k0();
        SearchModel j2 = NaviUtil.j(searchModel);
        if (NaviUtil.x0(j2)) {
            CLog.b(t0, "startNaviActivity()  show near place toast.");
            UToast.e(getContext().getApplicationContext(), R.string.near_location_info, 0);
        } else if (o0() != null) {
            j2.setNaviMode(NaviUtil.X(getContext().getApplicationContext(), j2));
            o0().a(j2, z2, 0, 1);
        } else {
            CLog.b(t0, "startNaviActivity() ####### other.");
        }
    }

    public final /* synthetic */ void r3(View view) {
        u4(this.X);
    }

    public final void r4(final SearchModel searchModel) {
        String str = t0;
        CLog.b(str, "startNavigation isDeviceConnected=" + StarryNetManger.getInstance().isDeviceConnected());
        if (!StarryNetManger.getInstance().isDeviceConnected()) {
            getActivity().runOnUiThread(new a0(this));
        } else if (getActivity() != null) {
            LocationUtil.e(getActivity(), 1003, new LocationUtil.LocationCallback() {
                public void a() {
                    CLog.b(SearchFragment.t0, "startNavigation onRefuseOpenGps() ");
                }

                public void b() {
                    SearchFragment.this.q4(searchModel, true);
                }
            });
        }
    }

    public final void s2() {
        String str = t0;
        CLog.b(str, "cleanSearchContent() ########## showMap=" + this.k0 + " getCommonAddressList().size()=" + this.R.getCommonAddressList().size());
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null) {
            searchAdapter.n().clear();
            List S3 = S3();
            this.F.A(S3);
            this.F.notifyDataSetChanged();
            this.E.setVisibility(S3.size() > 0 ? 0 : 8);
        }
        if (!this.k0 && this.R.getCommonAddressList().size() > 0) {
            this.R.setVisibility(0);
        }
        this.u.setText("");
    }

    public final /* synthetic */ void s3(View view) {
        H2();
    }

    public final void s4() {
        int i2 = 0;
        this.x.setVisibility(this.H.isShown() ? 8 : 0);
        TextView textView = this.y;
        if (this.H.isShown()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        this.U = j0(this.u);
        this.W = 1;
        if (!this.H.isShown()) {
            E2();
        }
    }

    public boolean t4() {
        CLog.b(t0, "touchCloseInputMethod");
        k0();
        return false;
    }

    public final void u2() {
        X3();
        if (this.k0) {
            M3();
        } else {
            Q3();
        }
    }

    public final /* synthetic */ boolean u3(View view, MotionEvent motionEvent) {
        this.H.isShown();
        return false;
    }

    public final void u4(SearchModel searchModel) {
        if (searchModel != null && getActivity() != null) {
            NaviDatabase naviDatabase = NaviOperatorManager.getInstance(getContext().getApplicationContext()).getNaviDatabase();
            CommonAddress K2 = K2(searchModel);
            searchModel.setAlias(K2.d());
            CommonAddress M2 = NaviUtil.M(getContext().getApplicationContext(), searchModel);
            String str = t0;
            CLog.b(str, "updateAddress searchModel=" + searchModel.toString());
            if (M2 != null) {
                if (!NaviUtil.P0(getContext().getApplicationContext(), searchModel, searchModel.getAlias())) {
                    naviDatabase.d().h(NaviUtil.t(), searchModel.getName(), searchModel.getAddress());
                    this.I.setImageResource(R.drawable.add_address_icon_n);
                    UToast.e(getContext().getApplicationContext(), R.string.del_common_addr_result, 0);
                } else if (!h4()) {
                    i4(naviDatabase, searchModel, K2);
                }
            } else if (!h4()) {
                naviDatabase.d().c(K2);
                this.I.setImageResource(R.drawable.add_address_icon_s);
                UToast.e(getContext().getApplicationContext(), R.string.add_common_addr_result, 0);
            }
            NaviUtil.E1(getContext().getApplicationContext());
            NaviOperatorManager.getInstance(getContext().getApplicationContext()).initCommonAddr();
            this.q.l();
            this.C.l();
            B4();
        }
    }

    public final void v2(int i2, SearchModel searchModel) {
        String str = t0;
        CLog.b(str, "commonItemClick() #######  position =" + i2);
        this.E.a();
        NaviUtil.h0(getContext(), searchModel);
        W3((SearchModel) this.F.n().get(i2), i2);
    }

    /* renamed from: v4 */
    public final void v3(boolean z2) {
        String str = t0;
        CLog.b(str, "updateConnectedView  viewShowType=" + this.i);
        NoConnectedView noConnectedView = this.l0;
        if (noConnectedView == null) {
            CLog.b(str, "updateConnectedView  notConnectedView is null.");
            return;
        }
        int i2 = 8;
        if (this.i != 0) {
            noConnectedView.setVisibility(8);
            return;
        }
        boolean D0 = NaviUtil.D0(getContext().getApplicationContext());
        boolean z3 = z2 && D0;
        CLog.b(str, "updateConnectedView isOnline=" + z2 + " netWorkAvailable=" + D0 + " needShow=" + z3);
        NoConnectedView noConnectedView2 = this.l0;
        if (!z3) {
            i2 = 0;
        }
        noConnectedView2.setVisibility(i2);
        this.l0.c(!z2);
        this.l0.h(!D0);
        this.l0.setConnected(z2);
    }

    public final boolean w2() {
        return !this.k0 && this.R.getCommonAddressList().size() > 0;
    }

    public final /* synthetic */ void w3() {
        UToast.e(getContext().getApplicationContext(), R.string.please_disconnected, 0);
    }

    public final void w4() {
        int i2 = this.i;
        boolean z2 = i2 == 4 || i2 == 5;
        String str = t0;
        CLog.b(str, "updateDataAndShow() ##########  viewShowType=" + this.i + " isDetailShow=" + z2);
        if (!z2) {
            this.E.a();
            Y2();
        }
    }

    public final /* synthetic */ void x3(PlaceBean placeBean, List list) {
        String str = t0;
        CLog.b(str, "onMapPOIClick  onPlaceSearched isShown()=" + this.E.isShown() + " isHidden=" + isHidden());
        F3(list, placeBean);
    }

    public void x4() {
        CLog.b(t0, "updateListMenuDisPlay");
        k0();
        SlideRecyclerView slideRecyclerView = this.E;
        if (slideRecyclerView != null) {
            slideRecyclerView.a();
        }
        SearchAdapter searchAdapter = this.F;
        if (searchAdapter != null) {
            searchAdapter.notifyDataSetChanged();
        }
    }

    public final SearchModel y2(PlaceBean placeBean) {
        SearchModel searchModel = new SearchModel();
        searchModel.setName(placeBean.getPoiName());
        searchModel.setAcode(placeBean.getPoiId());
        searchModel.setAddress(placeBean.getAddress());
        searchModel.setDistrict(placeBean.getDistrict());
        searchModel.setKeywords(this.u.getText().toString());
        searchModel.setLatitude(placeBean.getLatitude());
        searchModel.setLongitude(placeBean.getLongitude());
        searchModel.setCity(placeBean.getCity());
        searchModel.setType(0);
        ULocation g = LocationManager.f().g();
        if (g != null) {
            searchModel.setDistance(Math.round(NaviUtil.e(new ULatLng(g.getLatitude(), g.getLongitude()), new ULatLng(placeBean.getLatitude(), placeBean.getLongitude()))));
        }
        searchModel.setAlias(NaviUtil.v(getContext().getApplicationContext(), searchModel));
        String str = t0;
        CLog.b(str, "&&&&&&& searchModel:" + searchModel.toString());
        return searchModel;
    }

    public final /* synthetic */ void y3(DialogInterface dialogInterface) {
        this.T.setVisibility(8);
    }

    public final void y4(SearchModel searchModel) {
        A4(NaviUtil.X(getContext().getApplicationContext(), searchModel));
        CommonAddress M2 = NaviUtil.M(getContext().getApplicationContext(), searchModel);
        if (M2 == null) {
            this.I.setImageResource(R.drawable.add_address_icon_n);
        } else if (TextUtils.isEmpty(M2.d()) || !M2.d().contains(SchedulerSupport.CUSTOM)) {
            this.I.setImageResource(R.drawable.add_address_icon_n);
        } else {
            this.I.setImageResource(R.drawable.add_address_icon_s);
        }
    }

    public final /* synthetic */ void z3(CustomDialog customDialog, View view) {
        customDialog.dismiss();
        this.T.setVisibility(8);
    }
}
