package com.upuphone.ar.navi.lite.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.ar.navi.lite.AddressActivity;
import com.upuphone.ar.navi.lite.AddressSettingActivity;
import com.upuphone.ar.navi.lite.NaviFragmentActivity;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;

public class SearchMenuView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f5850a;
    public MenuView b;
    public MenuView c;
    public View d;
    public Activity e;
    public OnMenuClicked f;

    public interface OnMenuClicked {
        void a(int i);
    }

    public SearchMenuView(@NonNull Context context) {
        super(context);
        this.f5850a = context;
        i(context);
        l();
    }

    public final void g(Context context, SearchModel searchModel, int i) {
        OnMenuClicked onMenuClicked = this.f;
        if (onMenuClicked != null) {
            onMenuClicked.a(i);
        }
        k(context, searchModel, i);
    }

    public Activity getActivity() {
        return this.e;
    }

    public MenuView getNaviSetting() {
        return this.c;
    }

    public OnMenuClicked getOnMenuClicked() {
        return this.f;
    }

    public final void h(Context context) {
        this.e.startActivityForResult(new Intent(context, AddressActivity.class), 1);
    }

    public final void i(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.search_menu_panel_layout, this);
        MenuView menuView = (MenuView) findViewById(R.id.home);
        menuView.setVisibility(0);
        menuView.setOnClickListener(this);
        MenuView menuView2 = (MenuView) findViewById(R.id.company);
        menuView2.setVisibility(0);
        menuView2.setOnClickListener(this);
        MenuView menuView3 = (MenuView) findViewById(R.id.custom);
        this.b = menuView3;
        menuView3.setVisibility(8);
        this.b.setOnClickListener(this);
        this.b.setText(NaviManager.getInstance(context).getCustomName());
        MenuView menuView4 = (MenuView) findViewById(R.id.navi_setting);
        this.c = menuView4;
        menuView4.setVisibility(8);
        this.c.setOnClickListener(this);
        this.d = findViewById(R.id.bottom_line);
        ((MenuView) findViewById(R.id.common_address_Menu)).setOnClickListener(this);
    }

    public final void j(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

    public final void k(Context context, SearchModel searchModel, int i) {
        if (searchModel.getLatitude() == 0.0d && searchModel.getLongitude() == 0.0d) {
            if (this.e != null) {
                Intent intent = new Intent(this.e, AddressSettingActivity.class);
                intent.putExtra("MODEL", i == 1 ? NaviUtil.J() : NaviUtil.w());
                intent.putExtra("name", "");
                this.e.startActivityForResult(intent, 0);
            }
        } else if (NaviUtil.x0(searchModel)) {
            UToast.e(context.getApplicationContext(), R.string.near_location_info, 0);
        } else {
            Intent intent2 = new Intent(context, NaviFragmentActivity.class);
            intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            searchModel.setNaviMode(CSharedPreferences.j(context));
            intent2.putExtra("search_info_key", searchModel);
            intent2.putExtra("direct_navi_key", false);
            intent2.putExtra("navi_from_quik_key", 0);
            context.startActivity(intent2);
        }
    }

    public void l() {
        Resources resources;
        int i;
        MenuView menuView = (MenuView) findViewById(R.id.home);
        MenuView menuView2 = (MenuView) findViewById(R.id.company);
        boolean hasAddress = NaviOperatorManager.getInstance(this.f5850a.getApplicationContext()).hasAddress(1);
        boolean hasAddress2 = NaviOperatorManager.getInstance(this.f5850a.getApplicationContext()).hasAddress(2);
        if (hasAddress) {
            resources = getResources();
            i = R.string.home;
        } else {
            resources = getResources();
            i = R.string.add_home;
        }
        menuView.setText(resources.getString(i));
        menuView2.setText(getResources().getString(hasAddress2 ? R.string.go_company : R.string.add_company));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.home) {
            Context context = this.f5850a;
            g(context, NaviOperatorManager.getInstance(context.getApplicationContext()).getHomeModel(), 1);
        } else if (id == R.id.company) {
            Context context2 = this.f5850a;
            g(context2, NaviOperatorManager.getInstance(context2.getApplicationContext()).getCompanyModel(), 2);
        } else if (id == R.id.custom) {
            Context context3 = this.f5850a;
            g(context3, NaviOperatorManager.getInstance(context3.getApplicationContext()).getCustomModel(), 3);
        } else if (id == R.id.navi_setting) {
            j(this.f5850a);
        } else if (id == R.id.common_address_Menu) {
            h(this.f5850a);
        }
    }

    public void setActivity(Activity activity) {
        this.e = activity;
    }

    public void setBottomLineVisible(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    public void setCustomText(String str) {
        this.b.setText(str);
    }

    public void setNaviSetting(MenuView menuView) {
        this.c = menuView;
    }

    public void setOnMenuClicked(OnMenuClicked onMenuClicked) {
        this.f = onMenuClicked;
    }

    public SearchMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5850a = context;
        i(context);
        l();
    }
}
