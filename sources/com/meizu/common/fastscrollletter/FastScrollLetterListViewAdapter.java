package com.meizu.common.fastscrollletter;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.meizu.common.R;
import com.meizu.common.widget.PinnedHeaderIndexerListAdapter;
import java.util.ArrayList;

public class FastScrollLetterListViewAdapter extends PinnedHeaderIndexerListAdapter {
    private FastScrollLetterListViewAdapterCallBack callBack;
    private Context context;
    private LayoutInflater inflater;
    private final boolean isRTL;
    private String[] letters;
    private NavigationLayout navigationLayout;
    private boolean needSectionHeader;
    private boolean needSetRightPadding;
    private int rightPaddingForCheckBox;

    public interface FastScrollLetterListViewAdapterCallBack {
        void bindItemView(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

        void bindPinnedSectionHeaderView(View view, int i, String str);

        void bindScrollSectionHeaderView(View view, Context context, int i, int i2, String str);

        View createItemView(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

        View createPinnedSectionHeaderView(Context context, ViewGroup viewGroup);

        View createScrollSectionHeaderView(Context context, int i, int i2, ViewGroup viewGroup);

        void disposeScrollSectionHeaderView(ListView listView, int i, int i2, boolean z);
    }

    public FastScrollLetterListViewAdapter(Context context2, ArrayList<String> arrayList, NavigationLayout navigationLayout2) {
        super(context2);
        this.context = context2;
        this.letters = new String[arrayList.size()];
        this.navigationLayout = navigationLayout2;
        this.rightPaddingForCheckBox = context2.getResources().getDimensionPixelSize(R.dimen.mc_fastscroll_letter_right_padding_for_checkbox);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            this.letters[i] = arrayList.get(i);
        }
        this.inflater = LayoutInflater.from(context2);
        setNeedSectionHeader(true);
        this.isRTL = context2.getResources().getConfiguration().getLayoutDirection() == 1 ? true : z;
    }

    @TargetApi(16)
    private void setHeaderViewDrawableAndSectionLetter(View view, int i) {
        TextView textView = (TextView) view.findViewById(R.id.mc_list_category_partition_contact_text1);
        if (textView != null) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(this.context.getResources().getColor(R.color.fd_sys_color_surface_container_high_default));
            textView.setBackground(shapeDrawable);
            textView.setText(this.letters[i]);
        }
    }

    public void bindSectionHeaderView(View view, Context context2, int i, int i2) {
        setHeaderViewDrawableAndSectionLetter(view, i2);
        this.callBack.bindScrollSectionHeaderView(view, context2, i, i2, this.letters[i2]);
    }

    public void bindView(View view, Context context2, int i, int i2, Cursor cursor, int i3, int i4) {
        if (this.needSetRightPadding) {
            if (this.isRTL) {
                view.setPadding(this.rightPaddingForCheckBox, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), this.rightPaddingForCheckBox, view.getPaddingBottom());
            }
        }
        this.callBack.bindItemView(view, context2, i, i2, cursor, i3, i4);
    }

    public void configureItemHeader(ListView listView, int i, int i2, boolean z) {
        this.callBack.disposeScrollSectionHeaderView(listView, i, i2, z);
    }

    public View createPinnedSectionHeaderView(Context context2, ViewGroup viewGroup) {
        View createPinnedSectionHeaderView = this.callBack.createPinnedSectionHeaderView(context2, viewGroup);
        if (createPinnedSectionHeaderView == null) {
            createPinnedSectionHeaderView = this.inflater.inflate(R.layout.mc_list_category_contact_partition_header, viewGroup, false);
        }
        if (this.isRTL) {
            ViewCompat.L0(createPinnedSectionHeaderView, 1);
        }
        return createPinnedSectionHeaderView;
    }

    public boolean getNeedSectionHeader() {
        return this.needSectionHeader;
    }

    public View newSectionHeaderView(Context context2, int i, int i2, ViewGroup viewGroup) {
        View createScrollSectionHeaderView = this.callBack.createScrollSectionHeaderView(context2, i, i2, viewGroup);
        if (createScrollSectionHeaderView == null) {
            LayoutInflater from = LayoutInflater.from(context2);
            this.inflater = from;
            createScrollSectionHeaderView = from.inflate(R.layout.mc_list_category_contact_partition_header, viewGroup, false);
        }
        if (this.isRTL) {
            ViewCompat.L0(createScrollSectionHeaderView, 1);
        }
        return createScrollSectionHeaderView;
    }

    public View newView(Context context2, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup) {
        return this.callBack.createItemView(context2, i, i2, cursor, i3, i4, viewGroup);
    }

    public void setCallBack(FastScrollLetterListViewAdapterCallBack fastScrollLetterListViewAdapterCallBack) {
        this.callBack = fastScrollLetterListViewAdapterCallBack;
    }

    public void setNeedSectionHeader(boolean z) {
        this.needSectionHeader = z;
        if (z) {
            showSectionHeaders(true);
            setSectionHeaderDisplayEnabled(true);
            setPinnedPartitionHeadersEnabled(true);
            return;
        }
        showSectionHeaders(false);
        setSectionHeaderDisplayEnabled(false);
        setPinnedPartitionHeadersEnabled(false);
    }

    public void setNeedSetNormativeRightPaddingForItem(boolean z) {
        this.needSetRightPadding = z;
    }

    public void setPinnedSectionHeaderView(View view, int i) {
        setHeaderViewDrawableAndSectionLetter(view, i);
        this.callBack.bindPinnedSectionHeaderView(view, i, this.letters[i]);
    }

    public void updateLetters(ArrayList<String> arrayList) {
        this.letters = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.letters[i] = arrayList.get(i);
        }
        invalidate();
    }
}
