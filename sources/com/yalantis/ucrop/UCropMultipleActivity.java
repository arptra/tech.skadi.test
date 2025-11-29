package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.UCropGalleryAdapter;
import com.yalantis.ucrop.decoration.GridSpacingItemDecoration;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.statusbar.ImmersiveManager;
import com.yalantis.ucrop.util.DensityUtil;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class UCropMultipleActivity extends AppCompatActivity implements UCropFragmentCallback {

    /* renamed from: a  reason: collision with root package name */
    public String f8741a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public final List i = new ArrayList();
    public UCropFragment j;
    public int k;
    public ArrayList l;
    public ArrayList m;
    public final LinkedHashMap n = new LinkedHashMap();
    public String o;
    public UCropGalleryAdapter p;
    public boolean q;
    public boolean r;
    public ArrayList s;
    public final HashSet t = new HashSet();

    static {
        AppCompatDelegate.G(true);
    }

    private void D0() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("com.yalantis.ucrop.isDarkStatusBarBlack", false);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.d = intExtra;
        ImmersiveManager.a(this, intExtra, intExtra, booleanExtra);
    }

    private void I0() {
        setStatusBarColor(this.d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.c);
        toolbar.setTitleTextColor(this.g);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.g);
        textView.setText(this.f8741a);
        textView.setTextSize((float) this.b);
        Drawable mutate = AppCompatResources.b(this, this.e).mutate();
        mutate.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(false);
        }
    }

    private void J0(Intent intent) {
        this.s = getIntent().getParcelableArrayListExtra("com.yalantis.ucrop.MultipleAspectRatio");
        this.q = intent.getBooleanExtra("com.yalantis.ucrop.ForbidCropGifWebp", false);
        this.o = intent.getStringExtra("com.yalantis.ucrop.CropOutputFileName");
        this.d = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.c = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.g = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.e = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.f = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        this.f8741a = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.b = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarTitleTextSize", 18);
        String str = this.f8741a;
        if (str == null) {
            str = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.f8741a = str;
        I0();
    }

    private void setStatusBarColor(int i2) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
        }
    }

    public final String A0(String str) {
        return FileUtils.j(str) ? FileUtils.f(this, Uri.parse(str)) : FileUtils.f(this, Uri.fromFile(new File(str)));
    }

    public final String B0() {
        String stringExtra = getIntent().getStringExtra("com.yalantis.ucrop.CropOutputDir");
        File file = (stringExtra == null || "".equals(stringExtra)) ? new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "Sandbox") : new File(stringExtra);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    public final void C0(Intent intent) {
        Throwable a2 = UCrop.a(intent);
        if (a2 != null) {
            Toast.makeText(this, a2.getMessage(), 1).show();
        } else {
            Toast.makeText(this, "Unexpected error", 0).show();
        }
    }

    public final void E0(Intent intent) {
        String str;
        int i2 = 0;
        this.r = intent.getBooleanExtra("com.yalantis.ucrop.ForbidSkipCrop", false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.yalantis.ucrop.CropTotalDataSource");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            throw new IllegalArgumentException("Missing required parameters, count cannot be less than 1");
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        while (i2 < stringArrayListExtra.size()) {
            String str2 = stringArrayListExtra.get(i2);
            this.n.put(str2, new JSONObject());
            String g2 = FileUtils.j(str2) ? FileUtils.g(this, Uri.parse(str2)) : str2;
            String A0 = A0(str2);
            if (FileUtils.s(g2) || FileUtils.q(A0) || FileUtils.o(A0)) {
                this.m.add(str2);
            } else {
                this.l.add(str2);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Uri parse = (FileUtils.j(str2) || FileUtils.p(str2)) ? Uri.parse(str2) : Uri.fromFile(new File(str2));
                    String i3 = FileUtils.i(this, this.q, parse);
                    if (TextUtils.isEmpty(this.o)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(FileUtils.c("CROP_" + (i2 + 1)));
                        sb.append(i3);
                        str = sb.toString();
                    } else {
                        str = (i2 + 1) + FileUtils.b() + AccountConstantKt.DEFAULT_SEGMENT + this.o;
                    }
                    Uri fromFile = Uri.fromFile(new File(B0(), str));
                    extras.putParcelable("com.yalantis.ucrop.InputUri", parse);
                    extras.putParcelable("com.yalantis.ucrop.OutputUri", fromFile);
                    ArrayList arrayList = this.s;
                    AspectRatio aspectRatio = (arrayList == null || arrayList.size() <= i2) ? null : (AspectRatio) this.s.get(i2);
                    float f2 = -1.0f;
                    extras.putFloat("com.yalantis.ucrop.AspectRatioX", aspectRatio != null ? aspectRatio.getAspectRatioX() : -1.0f);
                    if (aspectRatio != null) {
                        f2 = aspectRatio.getAspectRatioY();
                    }
                    extras.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
                    this.i.add(UCropFragment.C0(extras));
                }
            }
            i2++;
        }
        if (this.l.size() != 0) {
            H0();
            K0((UCropFragment) this.i.get(z0()), z0());
            this.p.k(z0());
            return;
        }
        throw new IllegalArgumentException("No clipping data sources are available");
    }

    public final void F0(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CropInputOriginal");
            JSONObject jSONObject = (JSONObject) this.n.get(stringExtra);
            Uri b2 = UCrop.b(intent);
            jSONObject.put("outPutPath", b2 != null ? b2.getPath() : "");
            jSONObject.put("imageWidth", UCrop.g(intent));
            jSONObject.put("imageHeight", UCrop.d(intent));
            jSONObject.put("offsetX", UCrop.e(intent));
            jSONObject.put("offsetY", UCrop.f(intent));
            jSONObject.put("aspectRatio", (double) UCrop.c(intent));
            this.n.put(stringExtra, jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void G0() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry value : this.n.entrySet()) {
            jSONArray.put((JSONObject) value.getValue());
        }
        Intent intent = new Intent();
        intent.putExtra("output", jSONArray.toString());
        setResult(-1, intent);
        finish();
    }

    public final void H0() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_gallery);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(Integer.MAX_VALUE, DensityUtil.a(this, 6.0f), true));
        }
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this, R.anim.ucrop_layout_animation_fall_down));
        recyclerView.setBackgroundResource(getIntent().getIntExtra("com.yalantis.ucrop.GalleryBarBackground", R.drawable.ucrop_gallery_bg));
        UCropGalleryAdapter uCropGalleryAdapter = new UCropGalleryAdapter(this.l);
        this.p = uCropGalleryAdapter;
        uCropGalleryAdapter.l(new UCropGalleryAdapter.OnItemClickListener() {
            public void a(int i, View view) {
                if (!UCropMultipleActivity.this.r) {
                    if (UCropMultipleActivity.this.t.contains(UCropMultipleActivity.this.A0((String) UCropMultipleActivity.this.l.get(i)))) {
                        Toast.makeText(UCropMultipleActivity.this.getApplicationContext(), UCropMultipleActivity.this.getString(R.string.ucrop_not_crop), 0).show();
                    } else if (UCropMultipleActivity.this.p.h() != i) {
                        UCropMultipleActivity.this.p.notifyItemChanged(UCropMultipleActivity.this.p.h());
                        UCropMultipleActivity.this.p.k(i);
                        UCropMultipleActivity.this.p.notifyItemChanged(i);
                        UCropMultipleActivity.this.K0((UCropFragment) UCropMultipleActivity.this.i.get(i), i);
                    }
                }
            }
        });
        recyclerView.setAdapter(this.p);
    }

    public final void K0(UCropFragment uCropFragment, int i2) {
        FragmentTransaction s2 = getSupportFragmentManager().s();
        if (!uCropFragment.isAdded()) {
            UCropFragment uCropFragment2 = this.j;
            if (uCropFragment2 != null) {
                s2.q(uCropFragment2);
            }
            int i3 = R.id.fragment_container;
            s2.c(i3, uCropFragment, UCropFragment.A + LunarCalendar.DATE_SEPARATOR + i2);
        } else {
            s2.q(this.j).B(uCropFragment);
            uCropFragment.y0();
        }
        this.k = i2;
        this.j = uCropFragment;
        s2.k();
    }

    public void n(boolean z) {
        this.h = z;
        supportInvalidateOptionsMenu();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D0();
        setContentView(R.layout.ucrop_activity_multiple);
        J0(getIntent());
        E0(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
                findItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.f);
        if (drawable == null) {
            return true;
        }
        drawable.mutate();
        drawable.setColorFilter(BlendModeColorFilterCompat.a(this.g, BlendModeCompat.SRC_ATOP));
        findItem2.setIcon(drawable);
        return true;
    }

    public void onDestroy() {
        UCropDevelopConfig.a();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            UCropFragment uCropFragment = this.j;
            if (uCropFragment != null && uCropFragment.isAdded()) {
                this.j.w0();
            }
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.h);
        menu.findItem(R.id.menu_loader).setVisible(this.h);
        return super.onPrepareOptionsMenu(menu);
    }

    public void v(UCropFragment.UCropResult uCropResult) {
        int i2 = uCropResult.f8737a;
        if (i2 == -1) {
            int size = this.k + this.m.size();
            int size2 = (this.m.size() + this.l.size()) - 1;
            F0(uCropResult.b);
            if (size == size2) {
                G0();
                return;
            }
            int i3 = this.k + 1;
            String A0 = A0((String) this.l.get(i3));
            while (this.t.contains(A0)) {
                if (i3 == size2) {
                    G0();
                    return;
                } else {
                    i3++;
                    A0 = A0((String) this.l.get(i3));
                }
            }
            K0((UCropFragment) this.i.get(i3), i3);
            UCropGalleryAdapter uCropGalleryAdapter = this.p;
            uCropGalleryAdapter.notifyItemChanged(uCropGalleryAdapter.h());
            this.p.k(i3);
            UCropGalleryAdapter uCropGalleryAdapter2 = this.p;
            uCropGalleryAdapter2.notifyItemChanged(uCropGalleryAdapter2.h());
        } else if (i2 == 96) {
            C0(uCropResult.b);
        }
    }

    public final int z0() {
        ArrayList<String> stringArrayList;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList("com.yalantis.ucrop.SkipCropMimeType")) == null || stringArrayList.size() <= 0) {
            return 0;
        }
        this.t.addAll(stringArrayList);
        int i2 = -1;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            i2++;
            if (!this.t.contains(A0((String) this.l.get(i3)))) {
                break;
            }
        }
        if (i2 == -1 || i2 > this.i.size()) {
            return 0;
        }
        return i2;
    }
}
