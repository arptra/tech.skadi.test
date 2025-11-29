package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager c;

    /* renamed from: a  reason: collision with root package name */
    public ResourceManagerInternal f282a;

    public static synchronized AppCompatDrawableManager b() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (c == null) {
                    h();
                }
                appCompatDrawableManager = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter k;
        synchronized (AppCompatDrawableManager.class) {
            k = ResourceManagerInternal.k(i, mode);
        }
        return k;
    }

    public static synchronized void h() {
        synchronized (AppCompatDrawableManager.class) {
            if (c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                c = appCompatDrawableManager;
                appCompatDrawableManager.f282a = ResourceManagerInternal.g();
                c.f282a.t(new ResourceManagerInternal.ResourceManagerHooks() {

                    /* renamed from: a  reason: collision with root package name */
                    public final int[] f283a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                    public final int[] b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                    public final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                    public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                    public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                    public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    public Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                        if (i == R.drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.i(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.i(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                        }
                        if (i == R.drawable.abc_ratingbar_material) {
                            return l(resourceManagerInternal, context, R.dimen.abc_star_big);
                        }
                        if (i == R.drawable.abc_ratingbar_indicator_material) {
                            return l(resourceManagerInternal, context, R.dimen.abc_star_medium);
                        }
                        if (i == R.drawable.abc_ratingbar_small_material) {
                            return l(resourceManagerInternal, context, R.dimen.abc_star_small);
                        }
                        return null;
                    }

                    public ColorStateList b(Context context, int i) {
                        if (i == R.drawable.abc_edit_text_material) {
                            return AppCompatResources.a(context, R.color.abc_tint_edittext);
                        }
                        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                            return AppCompatResources.a(context, R.color.abc_tint_switch_track);
                        }
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return k(context);
                        }
                        if (i == R.drawable.abc_btn_default_mtrl_shape) {
                            return j(context);
                        }
                        if (i == R.drawable.abc_btn_borderless_material) {
                            return g(context);
                        }
                        if (i == R.drawable.abc_btn_colored_material) {
                            return i(context);
                        }
                        if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                            return AppCompatResources.a(context, R.color.abc_tint_spinner);
                        }
                        if (f(this.b, i)) {
                            return ThemeUtils.e(context, R.attr.colorControlNormal);
                        }
                        if (f(this.e, i)) {
                            return AppCompatResources.a(context, R.color.abc_tint_default);
                        }
                        if (f(this.f, i)) {
                            return AppCompatResources.a(context, R.color.abc_tint_btn_checkable);
                        }
                        if (i == R.drawable.abc_seekbar_thumb_material) {
                            return AppCompatResources.a(context, R.color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    public PorterDuff.Mode c(int i) {
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    public boolean d(Context context, int i, Drawable drawable) {
                        if (i == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            m(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.c(context, R.attr.colorControlNormal), AppCompatDrawableManager.b);
                            m(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.c(context, R.attr.colorControlNormal), AppCompatDrawableManager.b);
                            m(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.c(context, R.attr.colorControlActivated), AppCompatDrawableManager.b);
                            return true;
                        } else if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            m(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.b(context, R.attr.colorControlNormal), AppCompatDrawableManager.b);
                            m(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.c(context, R.attr.colorControlActivated), AppCompatDrawableManager.b);
                            m(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.c(context, R.attr.colorControlActivated), AppCompatDrawableManager.b);
                            return true;
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
                    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean e(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.b
                            int[] r1 = r6.f283a
                            boolean r1 = r6.f(r1, r8)
                            r2 = 1
                            r3 = 0
                            r4 = -1
                            if (r1 == 0) goto L_0x0014
                            int r6 = androidx.appcompat.R.attr.colorControlNormal
                        L_0x0011:
                            r1 = r2
                        L_0x0012:
                            r8 = r4
                            goto L_0x0049
                        L_0x0014:
                            int[] r1 = r6.c
                            boolean r1 = r6.f(r1, r8)
                            if (r1 == 0) goto L_0x001f
                            int r6 = androidx.appcompat.R.attr.colorControlActivated
                            goto L_0x0011
                        L_0x001f:
                            int[] r1 = r6.d
                            boolean r6 = r6.f(r1, r8)
                            r1 = 16842801(0x1010031, float:2.3693695E-38)
                            if (r6 == 0) goto L_0x002e
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                        L_0x002c:
                            r6 = r1
                            goto L_0x0011
                        L_0x002e:
                            int r6 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                            if (r8 != r6) goto L_0x0041
                            r6 = 1109603123(0x42233333, float:40.8)
                            int r6 = java.lang.Math.round(r6)
                            r8 = 16842800(0x1010030, float:2.3693693E-38)
                            r1 = r2
                            r5 = r8
                            r8 = r6
                            r6 = r5
                            goto L_0x0049
                        L_0x0041:
                            int r6 = androidx.appcompat.R.drawable.abc_dialog_material_background
                            if (r8 != r6) goto L_0x0046
                            goto L_0x002c
                        L_0x0046:
                            r6 = r3
                            r1 = r6
                            goto L_0x0012
                        L_0x0049:
                            if (r1 == 0) goto L_0x0066
                            boolean r1 = androidx.appcompat.widget.DrawableUtils.a(r9)
                            if (r1 == 0) goto L_0x0055
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0055:
                            int r6 = androidx.appcompat.widget.ThemeUtils.c(r7, r6)
                            android.graphics.PorterDuffColorFilter r6 = androidx.appcompat.widget.AppCompatDrawableManager.e(r6, r0)
                            r9.setColorFilter(r6)
                            if (r8 == r4) goto L_0x0065
                            r9.setAlpha(r8)
                        L_0x0065:
                            return r2
                        L_0x0066:
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.e(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public final boolean f(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public final ColorStateList g(Context context) {
                        return h(context, 0);
                    }

                    public final ColorStateList h(Context context, int i) {
                        int c2 = ThemeUtils.c(context, R.attr.colorControlHighlight);
                        int b2 = ThemeUtils.b(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{ThemeUtils.b, ThemeUtils.e, ThemeUtils.c, ThemeUtils.i}, new int[]{b2, ColorUtils.g(c2, i), ColorUtils.g(c2, i), i});
                    }

                    public final ColorStateList i(Context context) {
                        return h(context, ThemeUtils.c(context, R.attr.colorAccent));
                    }

                    public final ColorStateList j(Context context) {
                        return h(context, ThemeUtils.c(context, R.attr.colorButtonNormal));
                    }

                    public final ColorStateList k(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList e2 = ThemeUtils.e(context, R.attr.colorSwitchThumbNormal);
                        if (e2 == null || !e2.isStateful()) {
                            iArr[0] = ThemeUtils.b;
                            iArr2[0] = ThemeUtils.b(context, R.attr.colorSwitchThumbNormal);
                            iArr[1] = ThemeUtils.f;
                            iArr2[1] = ThemeUtils.c(context, R.attr.colorControlActivated);
                            iArr[2] = ThemeUtils.i;
                            iArr2[2] = ThemeUtils.c(context, R.attr.colorSwitchThumbNormal);
                        } else {
                            int[] iArr3 = ThemeUtils.b;
                            iArr[0] = iArr3;
                            iArr2[0] = e2.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.f;
                            iArr2[1] = ThemeUtils.c(context, R.attr.colorControlActivated);
                            iArr[2] = ThemeUtils.i;
                            iArr2[2] = e2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    public final LayerDrawable l(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                        Drawable i2 = resourceManagerInternal.i(context, R.drawable.abc_star_black_48dp);
                        Drawable i3 = resourceManagerInternal.i(context, R.drawable.abc_star_half_black_48dp);
                        if ((i2 instanceof BitmapDrawable) && i2.getIntrinsicWidth() == dimensionPixelSize && i2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable2 = (BitmapDrawable) i2;
                            bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            i2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            i2.draw(canvas);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                        if ((i3 instanceof BitmapDrawable) && i3.getIntrinsicWidth() == dimensionPixelSize && i3.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) i3;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            i3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            i3.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    public final void m(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (DrawableUtils.a(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.b;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.e(i, mode));
                    }
                });
            }
        }
    }

    public static void i(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.v(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.f282a.i(context, i);
    }

    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.f282a.j(context, i, z);
    }

    public synchronized ColorStateList f(Context context, int i) {
        return this.f282a.l(context, i);
    }

    public synchronized void g(Context context) {
        this.f282a.r(context);
    }
}
