package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.resources.Compatibility;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

class ResourcesWrapper extends Resources {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f335a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f335a = resources;
    }

    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public XmlResourceParser getAnimation(int i) {
        return this.f335a.getAnimation(i);
    }

    public boolean getBoolean(int i) {
        return this.f335a.getBoolean(i);
    }

    public int getColor(int i) {
        return this.f335a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f335a.getColorStateList(i);
    }

    public Configuration getConfiguration() {
        return this.f335a.getConfiguration();
    }

    public float getDimension(int i) {
        return this.f335a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.f335a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.f335a.getDimensionPixelSize(i);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f335a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i) {
        return this.f335a.getDrawable(i);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return ResourcesCompat.g(this.f335a, i, i2, (Resources.Theme) null);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f335a.getFraction(i, i2, i3);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f335a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i) {
        return this.f335a.getIntArray(i);
    }

    public int getInteger(int i) {
        return this.f335a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.f335a.getLayout(i);
    }

    public Movie getMovie(int i) {
        return this.f335a.getMovie(i);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f335a.getQuantityString(i, i2, objArr);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.f335a.getQuantityText(i, i2);
    }

    public String getResourceEntryName(int i) {
        return this.f335a.getResourceEntryName(i);
    }

    public String getResourceName(int i) {
        return this.f335a.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.f335a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.f335a.getResourceTypeName(i);
    }

    public String getString(int i) {
        return this.f335a.getString(i);
    }

    public String[] getStringArray(int i) {
        return this.f335a.getStringArray(i);
    }

    public CharSequence getText(int i) {
        return this.f335a.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f335a.getTextArray(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f335a.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        Compatibility.Api15Impl.a(this.f335a, i, i2, typedValue, z);
    }

    public XmlResourceParser getXml(int i) {
        return this.f335a.getXml(i);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f335a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.f335a.obtainTypedArray(i);
    }

    public InputStream openRawResource(int i) {
        return this.f335a.openRawResource(i);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f335a.openRawResourceFd(i);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f335a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f335a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f335a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public Drawable getDrawable(int i, Resources.Theme theme) {
        return ResourcesCompat.f(this.f335a, i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return ResourcesCompat.g(this.f335a, i, i2, theme);
    }

    public String getQuantityString(int i, int i2) {
        return this.f335a.getQuantityString(i, i2);
    }

    public String getString(int i, Object... objArr) {
        return this.f335a.getString(i, objArr);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f335a.getText(i, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f335a.getValue(str, typedValue, z);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f335a.openRawResource(i, typedValue);
    }
}
