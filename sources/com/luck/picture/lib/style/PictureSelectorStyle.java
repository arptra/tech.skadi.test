package com.luck.picture.lib.style;

public class PictureSelectorStyle {

    /* renamed from: a  reason: collision with root package name */
    public AlbumWindowStyle f9455a;
    public TitleBarStyle b;
    public SelectMainStyle c;
    public BottomNavBarStyle d;
    public PictureWindowAnimationStyle e;

    public AlbumWindowStyle a() {
        AlbumWindowStyle albumWindowStyle = this.f9455a;
        return albumWindowStyle == null ? new AlbumWindowStyle() : albumWindowStyle;
    }

    public BottomNavBarStyle b() {
        BottomNavBarStyle bottomNavBarStyle = this.d;
        return bottomNavBarStyle == null ? new BottomNavBarStyle() : bottomNavBarStyle;
    }

    public SelectMainStyle c() {
        SelectMainStyle selectMainStyle = this.c;
        return selectMainStyle == null ? new SelectMainStyle() : selectMainStyle;
    }

    public TitleBarStyle d() {
        TitleBarStyle titleBarStyle = this.b;
        return titleBarStyle == null ? new TitleBarStyle() : titleBarStyle;
    }

    public PictureWindowAnimationStyle e() {
        if (this.e == null) {
            this.e = PictureWindowAnimationStyle.a();
        }
        return this.e;
    }
}
