package com.upuphone.ar.navi.lite.car.keyboard;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.navi.lite.R;
import com.upuphone.ar.navi.lite.car.view.VehicleInput;
import com.upuphone.ar.navi.lite.util.CSharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class LicensePlateView extends LinearLayout implements View.OnClickListener, VehicleInput.VehicleListener {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f5659a;
    public String[] b = {"京", "沪", "浙", "苏", "粤", "鲁", "晋", "冀", "豫", "川", "渝", "辽", "吉", "黑", "皖", "鄂", "湘", "赣", "闽", "陕", "甘", "宁", "蒙", "津", "贵", "云", "桂", "", "琼", "青", "新", "藏", "DEL", "dismiss"};
    public String[] c = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public String[] d = {"Q", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_DIRECTION_TRUE, "Y", "U", "I", "O", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LATITUDE_SOUTH, "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "B", "N", "M", "DEL", "dismiss"};
    public List e = new ArrayList();
    public List f = new ArrayList();
    public List g = new ArrayList();
    public int h;
    public int i;
    public int j;
    public int k;
    public Context l;
    public GridLayoutManager m;
    public OnKeyClickListener n;
    public KeyAdapter o;
    public GridLayoutManager.SpanSizeLookup p;
    public GridLayoutManager.SpanSizeLookup q;

    public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public List f5662a = new ArrayList();
        public View.OnClickListener b;
        public int c = -1;

        public class KeyViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f5663a;
            public ImageView b;

            public KeyViewHolder(View view) {
                super(view);
                this.f5663a = (TextView) view.findViewById(R.id.tv_key);
                this.b = (ImageView) view.findViewById(R.id.item_img);
            }
        }

        public KeyAdapter(View.OnClickListener onClickListener) {
            this.b = onClickListener;
        }

        public int getItemCount() {
            return this.f5662a.size();
        }

        public String h(int i) {
            return ((KeyItem) this.f5662a.get(i)).f5664a;
        }

        public final /* synthetic */ boolean i(KeyItem keyItem, KeyViewHolder keyViewHolder, View view, MotionEvent motionEvent) {
            return n(keyItem, keyViewHolder.f5663a, motionEvent);
        }

        /* renamed from: j */
        public void onBindViewHolder(KeyViewHolder keyViewHolder, int i) {
            KeyItem keyItem = (KeyItem) this.f5662a.get(i);
            String str = keyItem.f5664a;
            keyViewHolder.f5663a.setText(str);
            keyViewHolder.itemView.setOnClickListener(this.b);
            keyViewHolder.itemView.setOnTouchListener(new a(this, keyItem, keyViewHolder));
            keyViewHolder.f5663a.setVisibility(0);
            keyViewHolder.b.setVisibility(8);
            keyViewHolder.itemView.setVisibility(0);
            keyViewHolder.itemView.setClickable(keyItem.b);
            if (TextUtils.isEmpty(str)) {
                keyViewHolder.itemView.setBackgroundResource(0);
                keyViewHolder.itemView.setVisibility(4);
            } else if (keyItem.d != 0) {
                keyViewHolder.f5663a.setVisibility(8);
                keyViewHolder.b.setVisibility(0);
                keyViewHolder.b.setImageDrawable(LicensePlateView.this.l.getDrawable(keyItem.d));
            } else {
                keyViewHolder.f5663a.setTextSize(1, 16.0f);
                int f = this.c == i ? LicensePlateView.this.k : LicensePlateView.this.i;
                TextView b2 = keyViewHolder.f5663a;
                if (!keyItem.b) {
                    f = LicensePlateView.this.j;
                }
                b2.setTextColor(f);
            }
        }

        /* renamed from: k */
        public KeyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new KeyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_key, viewGroup, false));
        }

        public void l(List list, boolean z, String str) {
            this.f5662a.clear();
            this.f5662a.addAll(list);
            GridLayoutManager d2 = LicensePlateView.this.m;
            LicensePlateView licensePlateView = LicensePlateView.this;
            d2.setSpanSizeLookup(z ? licensePlateView.p : licensePlateView.q);
            LicensePlateView.this.m.setSpanCount(z ? 9 : 10);
            m(str);
            notifyDataSetChanged();
        }

        public void m(String str) {
            int i = 0;
            while (true) {
                if (i >= this.f5662a.size()) {
                    i = -1;
                    break;
                } else if (str.equals(((KeyItem) this.f5662a.get(i)).f5664a)) {
                    break;
                } else {
                    i++;
                }
            }
            this.c = i;
        }

        public final boolean n(KeyItem keyItem, TextView textView, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                boolean z = keyItem.b;
                LicensePlateView licensePlateView = LicensePlateView.this;
                textView.setTextColor(z ? licensePlateView.k : licensePlateView.j);
                return false;
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            } else {
                boolean z2 = keyItem.b;
                LicensePlateView licensePlateView2 = LicensePlateView.this;
                textView.setTextColor(z2 ? licensePlateView2.i : licensePlateView2.j);
                return false;
            }
        }
    }

    public class KeyItem {

        /* renamed from: a  reason: collision with root package name */
        public String f5664a;
        public boolean b;
        public boolean c;
        public int d;

        public KeyItem(String str, boolean z, int i) {
            this.f5664a = str;
            this.b = z;
            this.c = TextUtils.isEmpty(str);
            this.d = i;
        }
    }

    public interface OnKeyClickListener {
        void a();

        void b();

        void c(String str);
    }

    public class RecycleGridDivider extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f5665a;

        public RecycleGridDivider(int i) {
            this.f5665a = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            int i = this.f5665a / 2;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition < spanCount) {
                int i2 = childAdapterPosition % spanCount;
                if (i2 == 0) {
                    rect.set(0, 0, i, 0);
                } else if (i2 == spanCount - 1) {
                    rect.set(i, 0, 0, 0);
                } else {
                    rect.set(i, 0, i, 0);
                }
            } else {
                int i3 = childAdapterPosition % spanCount;
                if (i3 == 0) {
                    rect.set(0, this.f5665a, i, 0);
                } else if (i3 == spanCount - 1) {
                    rect.set(i, this.f5665a, 0, 0);
                } else {
                    rect.set(i, this.f5665a, i, 0);
                }
            }
        }
    }

    public LicensePlateView(Context context) {
        super(context);
        o(context);
        n(context);
    }

    public static int k(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a(int i2, String str) {
        if (i2 == 0) {
            this.o.l(this.e, true, str);
        } else if (1 == i2) {
            this.o.l(this.g, false, "");
        } else {
            this.o.l(this.f, false, "");
        }
        this.n.a();
    }

    public final KeyItem l(String str) {
        return m(str, false);
    }

    public final KeyItem m(String str, boolean z) {
        boolean z2 = true;
        boolean z3 = !"I".equalsIgnoreCase(str) && !"O".equalsIgnoreCase(str);
        if ("DEL".equalsIgnoreCase(str)) {
            return new KeyItem(str, true, R.drawable.vehicle_key_delete);
        }
        if ("dismiss".equalsIgnoreCase(str)) {
            return new KeyItem(str, true, R.drawable.ic_arrow_down);
        }
        if (!z3 && !z) {
            z2 = false;
        }
        return new KeyItem(str, z2, 0);
    }

    public final void n(Context context) {
        this.l = context;
        setOrientation(1);
        setBackgroundColor(this.h);
        q();
        RecyclerView recyclerView = new RecyclerView(context);
        this.f5659a = recyclerView;
        recyclerView.setBackgroundColor(this.h);
        this.f5659a.setOverScrollMode(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 9);
        this.m = gridLayoutManager;
        this.f5659a.setLayoutManager(gridLayoutManager);
        this.f5659a.addItemDecoration(new RecycleGridDivider(5));
        int k2 = k(context, 10.0f);
        this.f5659a.setPadding(k2, k2, k2, k2);
        addView(this.f5659a);
        KeyAdapter keyAdapter = new KeyAdapter(this);
        this.o = keyAdapter;
        this.f5659a.setAdapter(keyAdapter);
        r();
        p();
    }

    public final void o(Context context) {
        this.h = context.getColor(R.color.theme_color_6);
        this.i = context.getColor(R.color.theme_color_2);
        this.j = context.getColor(R.color.theme_white_alpha_color);
        this.k = context.getColor(R.color.text_blue);
    }

    public void onClick(View view) {
        int childAdapterPosition = this.f5659a.getChildAdapterPosition(view);
        if (childAdapterPosition >= 0 && childAdapterPosition < this.o.getItemCount()) {
            String h2 = this.o.h(childAdapterPosition);
            if ("dismiss".equalsIgnoreCase(h2)) {
                this.n.b();
                return;
            }
            OnKeyClickListener onKeyClickListener = this.n;
            if (onKeyClickListener != null) {
                onKeyClickListener.c(h2);
            }
        }
    }

    public final void p() {
        String c2 = CSharedPreferences.c(getContext().getApplicationContext());
        this.o.l(this.e, true, TextUtils.isEmpty(c2) ? "" : c2.substring(0, 1));
    }

    public final void q() {
        for (String l2 : this.b) {
            this.e.add(l(l2));
        }
        for (String str : this.c) {
            this.f.add(l(str));
            this.g.add(new KeyItem(str, false, 0));
        }
        for (String str2 : this.d) {
            this.f.add(l(str2));
            this.g.add(m(str2, true));
        }
    }

    public final void r() {
        this.p = new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return (i == LicensePlateView.this.e.size() - 1 || i == LicensePlateView.this.e.size() - 2) ? 2 : 1;
            }
        };
        this.q = new GridLayoutManager.SpanSizeLookup() {
            public int getSpanSize(int i) {
                return (i == LicensePlateView.this.f.size() - 1 || i == LicensePlateView.this.f.size() - 2) ? 2 : 1;
            }
        };
    }

    public void setOnKeyClickListener(OnKeyClickListener onKeyClickListener) {
        this.n = onKeyClickListener;
    }

    public LicensePlateView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        o(context);
        n(context);
    }
}
