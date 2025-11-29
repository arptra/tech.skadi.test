package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo
public class SupportMenuInflater extends MenuInflater {
    public static final Class[] e;
    public static final Class[] f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f214a;
    public final Object[] b;
    public Context c;
    public Object d;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static final Class[] c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f215a;
        public Method b;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f215a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.f215a, new Object[]{menuItem})).booleanValue();
                }
                this.b.invoke(this.f215a, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class MenuState {
        public ActionProvider A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f216a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public MenuState(Menu menu) {
            this.f216a = menu;
            h();
        }

        public void a() {
            this.h = true;
            i(this.f216a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f216a.addSubMenu(this.b, this.i, this.j, this.k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            TintTypedArray u2 = TintTypedArray.u(SupportMenuInflater.this.c, attributeSet, R.styleable.MenuItem);
            this.i = u2.n(R.styleable.MenuItem_android_id, 0);
            this.j = (u2.k(R.styleable.MenuItem_android_menuCategory, this.c) & -65536) | (u2.k(R.styleable.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = u2.p(R.styleable.MenuItem_android_title);
            this.l = u2.p(R.styleable.MenuItem_android_titleCondensed);
            this.m = u2.n(R.styleable.MenuItem_android_icon, 0);
            this.n = c(u2.o(R.styleable.MenuItem_android_alphabeticShortcut));
            this.o = u2.k(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.p = c(u2.o(R.styleable.MenuItem_android_numericShortcut));
            this.q = u2.k(R.styleable.MenuItem_numericModifiers, 4096);
            if (u2.s(R.styleable.MenuItem_android_checkable)) {
                this.r = u2.a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = u2.a(R.styleable.MenuItem_android_checked, false);
            this.t = u2.a(R.styleable.MenuItem_android_visible, this.f);
            this.u = u2.a(R.styleable.MenuItem_android_enabled, this.g);
            this.v = u2.k(R.styleable.MenuItem_showAsAction, -1);
            this.z = u2.o(R.styleable.MenuItem_android_onClick);
            this.w = u2.n(R.styleable.MenuItem_actionLayout, 0);
            this.x = u2.o(R.styleable.MenuItem_actionViewClass);
            String o2 = u2.o(R.styleable.MenuItem_actionProviderClass);
            this.y = o2;
            boolean z2 = o2 != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (ActionProvider) e(o2, SupportMenuInflater.f, SupportMenuInflater.this.b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = u2.p(R.styleable.MenuItem_contentDescription);
            this.C = u2.p(R.styleable.MenuItem_tooltipText);
            if (u2.s(R.styleable.MenuItem_iconTintMode)) {
                this.E = DrawableUtils.e(u2.k(R.styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (u2.s(R.styleable.MenuItem_iconTint)) {
                this.D = u2.c(R.styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            u2.w();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!SupportMenuInflater.this.c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).q(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).f(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.e, SupportMenuInflater.this.f214a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.d(menuItem, actionProvider);
            }
            MenuItemCompat.h(menuItem, this.B);
            MenuItemCompat.m(menuItem, this.C);
            MenuItemCompat.g(menuItem, this.n, this.o);
            MenuItemCompat.k(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.j(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.i(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.f214a = objArr;
        this.b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            z2 = false;
                            str = null;
                        } else if (name2.equals("group")) {
                            menuState.h();
                        } else if (name2.equals("item")) {
                            if (!menuState.d()) {
                                ActionProvider actionProvider = menuState.A;
                                if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                    menuState.a();
                                } else {
                                    menuState.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        menuState.f(attributeSet);
                    } else if (name3.equals("item")) {
                        menuState.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, menuState.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.c.getResources().getLayout(i);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
