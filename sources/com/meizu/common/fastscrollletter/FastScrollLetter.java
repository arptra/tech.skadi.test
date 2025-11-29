package com.meizu.common.fastscrollletter;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.meizu.common.R;
import com.meizu.common.fastscrollletter.FastScrollLetterListViewAdapter;
import com.meizu.common.fastscrollletter.NavigationLayout;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.widget.GroupAlphabetIndexer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class FastScrollLetter extends RelativeLayout {
    /* access modifiers changed from: private */
    public FastScrollLetterListViewAdapter adapter;
    /* access modifiers changed from: private */
    public FastScrollLetterCallBack callBack;
    private Context context;
    private ArrayList<ArrayList<Object>> data;
    /* access modifiers changed from: private */
    public FastScrollLetterHeaderObserverCallBack fastScrollLetterHeaderObserverCallBack;
    /* access modifiers changed from: private */
    public IFastScrollLetterListView listView;
    private ArrayList<String> listViewLetters;
    Collator localCollator;
    private FastScrollLetterComparator mComparator;
    /* access modifiers changed from: private */
    public String mCurrentLetter;
    /* access modifiers changed from: private */
    public NavigationLayout navigationLayout;
    private ArrayList<String> navigationLetters;
    private boolean needSetRightPadding;
    private ArrayList<String> overlayLetters;

    public interface FastScrollLetterCallBack {
        int calculatePositionOffset(int i, int i2);
    }

    public class FastScrollLetterComparator implements Comparator<SortModel> {
        Pattern pattern = Pattern.compile("[a-zA-Z]");

        public FastScrollLetterComparator() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r0 = r5.pattern.matcher(r6.dataLetter).matches();
            r1 = r5.pattern.matcher(r7.dataLetter).matches();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
            if (r0 == false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
            return r5.this$0.localCollator.compare(r6.dataLetter, r7.dataLetter);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
            if (r0 != false) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
            return 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
            return -1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0053 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(com.meizu.common.fastscrollletter.FastScrollLetter.SortModel r6, com.meizu.common.fastscrollletter.FastScrollLetter.SortModel r7) {
            /*
                r5 = this;
                java.lang.String r0 = r6.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                if (r0 == 0) goto L_0x0084
                java.lang.String r1 = r7.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                if (r1 == 0) goto L_0x0084
                com.meizu.common.fastscrollletter.FastScrollLetter$SpecialLetters r1 = com.meizu.common.fastscrollletter.FastScrollLetter.SpecialLetters.HASH     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r2 = r1.getLetter()     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r0 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x0051 }
                r2 = 1
                if (r0 == 0) goto L_0x0016
                return r2
            L_0x0016:
                java.lang.String r0 = r6.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                com.meizu.common.fastscrollletter.FastScrollLetter$SpecialLetters r3 = com.meizu.common.fastscrollletter.FastScrollLetter.SpecialLetters.STAR     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r4 = r3.getLetter()     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r0 = r0.equals(r4)     // Catch:{ IllegalArgumentException -> 0x0051 }
                r4 = -1
                if (r0 == 0) goto L_0x0026
                return r4
            L_0x0026:
                java.lang.String r0 = r7.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r1 = r1.getLetter()     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r0 = r0.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0051 }
                if (r0 == 0) goto L_0x0033
                return r4
            L_0x0033:
                java.lang.String r0 = r7.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r1 = r3.getLetter()     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r0 = r0.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0051 }
                if (r0 == 0) goto L_0x0040
                return r2
            L_0x0040:
                java.lang.String r0 = r6.dataLetter     // Catch:{ NumberFormatException -> 0x0053 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0053 }
                java.lang.String r1 = r7.dataLetter     // Catch:{ NumberFormatException -> 0x0053 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0053 }
                int r5 = java.lang.Integer.compare(r0, r1)     // Catch:{ NumberFormatException -> 0x0053 }
                return r5
            L_0x0051:
                r5 = move-exception
                goto L_0x008c
            L_0x0053:
                java.util.regex.Pattern r0 = r5.pattern     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r1 = r6.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.util.regex.Matcher r0 = r0.matcher(r1)     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r0 = r0.matches()     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.util.regex.Pattern r1 = r5.pattern     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r3 = r7.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.util.regex.Matcher r1 = r1.matcher(r3)     // Catch:{ IllegalArgumentException -> 0x0051 }
                boolean r1 = r1.matches()     // Catch:{ IllegalArgumentException -> 0x0051 }
                if (r0 == 0) goto L_0x006f
                if (r1 != 0) goto L_0x0073
            L_0x006f:
                if (r0 != 0) goto L_0x0080
                if (r1 != 0) goto L_0x0080
            L_0x0073:
                com.meizu.common.fastscrollletter.FastScrollLetter r5 = com.meizu.common.fastscrollletter.FastScrollLetter.this     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.text.Collator r5 = r5.localCollator     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r6 = r6.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r7 = r7.dataLetter     // Catch:{ IllegalArgumentException -> 0x0051 }
                int r5 = r5.compare(r6, r7)     // Catch:{ IllegalArgumentException -> 0x0051 }
                return r5
            L_0x0080:
                if (r0 == 0) goto L_0x0083
                return r2
            L_0x0083:
                return r4
            L_0x0084:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0051 }
                java.lang.String r6 = "dataLetter can't be null"
                r5.<init>(r6)     // Catch:{ IllegalArgumentException -> 0x0051 }
                throw r5     // Catch:{ IllegalArgumentException -> 0x0051 }
            L_0x008c:
                r5.printStackTrace()
                r5 = 0
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.fastscrollletter.FastScrollLetter.FastScrollLetterComparator.compare(com.meizu.common.fastscrollletter.FastScrollLetter$SortModel, com.meizu.common.fastscrollletter.FastScrollLetter$SortModel):int");
        }
    }

    public interface FastScrollLetterHeaderObserverCallBack {
        void bindItemView(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4);

        void bindPinnedSectionHeaderView(View view, int i, String str);

        void bindScrollSectionHeaderView(View view, Context context, int i, int i2, String str);

        View createItemView(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup);

        View createPinnedSectionHeaderView(Context context, ViewGroup viewGroup);

        View createScrollSectionHeaderView(Context context, int i, int i2, ViewGroup viewGroup);

        void disposeScrollSectionHeaderView(ListView listView, int i, int i2, boolean z);
    }

    public class SortModel {
        public String dataLetter;
        /* access modifiers changed from: private */
        public ArrayList<Object> dataList;

        public SortModel() {
        }
    }

    public enum SpecialLetters {
        HASH("#"),
        STAR("★");
        
        private final String letter;

        private SpecialLetters(String str) {
            this.letter = str;
        }

        public String getLetter() {
            return this.letter;
        }
    }

    public FastScrollLetter(Context context2) {
        super(context2);
        this.context = context2;
        this.localCollator = Collator.getInstance(context2.getResources().getConfiguration().locale);
        initializeNavigationView((AttributeSet) null);
    }

    private void addListener() {
        FastScrollLetterListViewAdapter fastScrollLetterListViewAdapter = this.adapter;
        if (fastScrollLetterListViewAdapter != null) {
            fastScrollLetterListViewAdapter.setCallBack(new FastScrollLetterListViewAdapter.FastScrollLetterListViewAdapterCallBack() {
                public void bindItemView(View view, Context context, int i, int i2, Cursor cursor, int i3, int i4) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.bindItemView(view, context, i, i2, cursor, i3, i4);
                    }
                }

                public void bindPinnedSectionHeaderView(View view, int i, String str) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.bindPinnedSectionHeaderView(view, i, str);
                    }
                    if (FastScrollLetter.this.navigationLayout != null) {
                        FastScrollLetter.this.navigationLayout.setCurrentLetterFormScrolling(i, str);
                    }
                }

                public void bindScrollSectionHeaderView(View view, Context context, int i, int i2, String str) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.bindScrollSectionHeaderView(view, context, i, i2, str);
                    }
                }

                public View createItemView(Context context, int i, int i2, Cursor cursor, int i3, int i4, ViewGroup viewGroup) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        return FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.createItemView(context, i, i2, cursor, i3, i4, viewGroup);
                    }
                    return null;
                }

                public View createPinnedSectionHeaderView(Context context, ViewGroup viewGroup) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        return FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.createPinnedSectionHeaderView(context, viewGroup);
                    }
                    return null;
                }

                public View createScrollSectionHeaderView(Context context, int i, int i2, ViewGroup viewGroup) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        return FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.createScrollSectionHeaderView(context, i, i2, viewGroup);
                    }
                    return null;
                }

                public void disposeScrollSectionHeaderView(ListView listView, int i, int i2, boolean z) {
                    if (FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack != null) {
                        FastScrollLetter.this.fastScrollLetterHeaderObserverCallBack.disposeScrollSectionHeaderView(listView, i, i2, z);
                    }
                }
            });
        }
        this.navigationLayout.setCallBack(new NavigationLayout.NavigationLayoutCallBack() {
            public int getListViewFirstVisiblePosition() {
                if (FastScrollLetter.this.listView instanceof ListView) {
                    return ((ListView) FastScrollLetter.this.listView).getFirstVisiblePosition();
                }
                return -1;
            }

            public int getListViewHeightNow() {
                return ((View) FastScrollLetter.this.listView).getHeight();
            }

            public int getListViewItemCount() {
                if (FastScrollLetter.this.listView instanceof ListView) {
                    return ((ListView) FastScrollLetter.this.listView).getCount();
                }
                return -1;
            }

            public int getListViewLastVisiblePosition() {
                if (FastScrollLetter.this.listView instanceof ListView) {
                    return ((ListView) FastScrollLetter.this.listView).getLastVisiblePosition();
                }
                return -1;
            }

            public void location(String str) {
                int access$400 = FastScrollLetter.this.getHeaderIndex(str);
                int access$500 = FastScrollLetter.this.getPositionFromLetter(access$400);
                if (!(FastScrollLetter.this.listView instanceof FastScrollLetterListView)) {
                    FastScrollLetter.this.listView.setSelection(FastScrollLetter.this.callBack.calculatePositionOffset(access$400, access$500));
                } else if (access$500 != -1) {
                    IFastScrollLetterListView access$600 = FastScrollLetter.this.listView;
                    if (!FastScrollLetter.this.adapter.getNeedSectionHeader()) {
                        access$400 = 0;
                    }
                    access$600.setSelection(access$400 + access$500 + ((FastScrollLetterListView) FastScrollLetter.this.listView).getHeaderViewsCount());
                }
                if (!str.equals(FastScrollLetter.this.mCurrentLetter)) {
                    String unused = FastScrollLetter.this.mCurrentLetter = str;
                    CommonUtils.shakeForFlymeFeature(FastScrollLetter.this);
                }
            }

            public void stopListViewScroll() {
                FastScrollLetter.this.cancelFling();
            }
        });
    }

    /* access modifiers changed from: private */
    public void cancelFling() {
        MotionEvent obtain = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0);
        this.listView.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* access modifiers changed from: private */
    public int getHeaderIndex(String str) {
        if (!this.listViewLetters.contains(str)) {
            return -1;
        }
        for (int i = 0; i < this.listViewLetters.size(); i++) {
            if (this.listViewLetters.get(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int getPositionFromLetter(int i) {
        if (i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.data.size() && i2 < i) {
            i3 += this.data.get(i2).size();
            i2++;
        }
        return i3;
    }

    private void initializeNavigationView(AttributeSet attributeSet) {
        NavigationLayout navigationLayout2 = new NavigationLayout(this.context);
        this.navigationLayout = navigationLayout2;
        addView(navigationLayout2);
        this.navigationLayout.initializeFromAttrs(attributeSet);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.navigationLayout.getLayoutParams();
        layoutParams.addRule(21);
        layoutParams.height = -1;
        layoutParams.width = -2;
        this.navigationLayout.setLayoutParams(layoutParams);
    }

    private void initializeViews() {
        if (this.listView == null) {
            this.listView = (IFastScrollLetterListView) getChildAt(1);
        }
        String str = "";
        if (this.listView == null) {
            this.listView = new FastScrollLetterListView(this.context);
            Cursor makeCursor = makeCursor();
            Iterator<String> it = this.listViewLetters.iterator();
            while (it.hasNext()) {
                str = str + it.next();
            }
            GroupAlphabetIndexer groupAlphabetIndexer = new GroupAlphabetIndexer(makeCursor, 1, str);
            FastScrollLetterListViewAdapter fastScrollLetterListViewAdapter = new FastScrollLetterListViewAdapter(this.context, this.listViewLetters, this.navigationLayout);
            this.adapter = fastScrollLetterListViewAdapter;
            fastScrollLetterListViewAdapter.setNotificationsEnabled(false);
            this.adapter.addPartition(false, false, makeCursor);
            this.adapter.setNotificationsEnabled(true);
            this.adapter.setIndexer(groupAlphabetIndexer);
            this.adapter.setIndexedPartition(0);
            this.adapter.setNeedSetNormativeRightPaddingForItem(this.needSetRightPadding);
            ((FastScrollLetterListView) this.listView).setAdapter((ListAdapter) this.adapter);
            CommonUtils.setScrollBarThumbVertical((View) this.listView, R.drawable.fastscrollletter_listview_scrollbar_style);
            ((FastScrollLetterListView) this.listView).setScrollBarSize(this.context.getResources().getDimensionPixelSize(R.dimen.mc_fastscroll_letter_scroll_bar_width));
        } else {
            FastScrollLetterListViewAdapter fastScrollLetterListViewAdapter2 = this.adapter;
            if (fastScrollLetterListViewAdapter2 != null) {
                fastScrollLetterListViewAdapter2.updateLetters(this.listViewLetters);
                Cursor makeCursor2 = makeCursor();
                Iterator<String> it2 = this.listViewLetters.iterator();
                while (it2.hasNext()) {
                    str = str + it2.next();
                }
                GroupAlphabetIndexer groupAlphabetIndexer2 = new GroupAlphabetIndexer(makeCursor2, 1, str);
                this.adapter.setNotificationsEnabled(false);
                this.adapter.clearPartitions();
                this.adapter.addPartition(false, false, makeCursor2);
                this.adapter.setNotificationsEnabled(true);
                this.adapter.setIndexer(groupAlphabetIndexer2);
                this.adapter.notifyDataSetChanged();
            }
        }
        if (((View) this.listView).getParent() == null) {
            addView((View) this.listView, 0);
        }
        ViewGroup.LayoutParams layoutParams = this.listView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.listView.setLayoutParams(layoutParams);
        this.navigationLayout.bringToFront();
        this.navigationLayout.setOverlayLetters(this.overlayLetters);
        this.navigationLayout.setNavigationLetters(this.navigationLetters);
        this.navigationLayout.initialized();
        ArrayList<String> arrayList = this.listViewLetters;
        if (arrayList != null && arrayList.size() > 0) {
            this.navigationLayout.setCurrentLetter(this.listViewLetters.get(0));
        }
    }

    private void internalSorting(ArrayList<String> arrayList, ArrayList<ArrayList<Object>> arrayList2) {
        if (arrayList != null && arrayList2 != null && arrayList.size() == arrayList2.size()) {
            if (this.mComparator == null) {
                this.mComparator = new FastScrollLetterComparator();
            }
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                SortModel sortModel = new SortModel();
                ArrayList unused = sortModel.dataList = arrayList2.get(i);
                sortModel.dataLetter = arrayList.get(i);
                arrayList3.add(sortModel);
            }
            Collections.sort(arrayList3, this.mComparator);
            ArrayList<String> arrayList4 = new ArrayList<>();
            ArrayList<ArrayList<Object>> arrayList5 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                arrayList4.add(((SortModel) arrayList3.get(i2)).dataLetter);
                arrayList5.add(((SortModel) arrayList3.get(i2)).dataList);
            }
            this.listViewLetters = arrayList4;
            this.data = arrayList5;
        }
    }

    private Cursor makeCursor() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{FastScrollLetterCursorColumn.LETTER_INDEX, FastScrollLetterCursorColumn.LETTER, FastScrollLetterCursorColumn.DATA_INDEX, "data"});
        int i = 0;
        for (int i2 = 0; i2 < this.listViewLetters.size(); i2++) {
            for (int i3 = 0; i3 < this.data.get(i2).size(); i3++) {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i2), this.listViewLetters.get(i2), Integer.valueOf(i), this.data.get(i2).get(i3)});
                i++;
            }
        }
        return matrixCursor;
    }

    public IFastScrollLetterListView getListView() {
        return this.listView;
    }

    public NavigationLayout getNavigationLayout() {
        return this.navigationLayout;
    }

    public void initialize(ArrayList<String> arrayList, ArrayList<ArrayList<Object>> arrayList2) {
        initialize(arrayList, arrayList2, true);
    }

    public void setAutoHideLetter(boolean z) {
        this.navigationLayout.setAutoHideLetter(z);
    }

    public void setCallBack(FastScrollLetterHeaderObserverCallBack fastScrollLetterHeaderObserverCallBack2) {
        this.fastScrollLetterHeaderObserverCallBack = fastScrollLetterHeaderObserverCallBack2;
    }

    public void setHideBottomPassCount(int i) {
        this.navigationLayout.setHideBottomPassCount(i);
    }

    @Deprecated
    public void setHideNavigationBitmap(Bitmap bitmap) {
    }

    public void setHideNavigationLetter(String... strArr) {
        this.navigationLayout.setHideNavigationLetter(strArr);
    }

    public void setHideTopPassCount(int i) {
        this.navigationLayout.setHideTopPassCount(i);
    }

    public void setIntervalHide(int i) {
        this.navigationLayout.setIntervalHide(i);
    }

    public void setListView(IFastScrollLetterListView iFastScrollLetterListView) {
        this.listView = iFastScrollLetterListView;
    }

    public void setNavigationLetterRightMargin(int i) {
        this.navigationLayout.setNavigationLetterRightMargin(i);
    }

    public void setNavigationLetterRightPadding(int i) {
        this.navigationLayout.setNavigationLetterRightPadding(i);
    }

    public void setNavigationLetterWidth(int i) {
        this.navigationLayout.setNavigationLetterWidth(i);
    }

    public void setNavigationLetters(ArrayList<String> arrayList) {
        this.navigationLetters = arrayList;
        this.navigationLayout.setNavigationLetters(arrayList);
    }

    public void setNeedSetNormativeRightPaddingForItem(boolean z) {
        this.needSetRightPadding = z;
        FastScrollLetterListViewAdapter fastScrollLetterListViewAdapter = this.adapter;
        if (fastScrollLetterListViewAdapter != null) {
            fastScrollLetterListViewAdapter.setNeedSetNormativeRightPaddingForItem(z);
        }
    }

    public void setOffsetCallBack(FastScrollLetterCallBack fastScrollLetterCallBack) {
        this.callBack = fastScrollLetterCallBack;
    }

    public void setOverlayLetters(ArrayList<String> arrayList) {
        this.overlayLetters = arrayList;
        this.navigationLayout.setOverlayLetters(arrayList);
    }

    public void initialize(ArrayList<String> arrayList, ArrayList<ArrayList<Object>> arrayList2, boolean z) {
        if (z) {
            internalSorting(arrayList, arrayList2);
        } else {
            this.listViewLetters = arrayList;
            this.data = arrayList2;
        }
        initializeViews();
        addListener();
        setOverlayLetters(arrayList);
    }

    public void setHideNavigationLetter(String str, Bitmap bitmap, Bitmap bitmap2) {
        this.navigationLayout.setHideNavigationLetter(str, bitmap, bitmap2);
    }

    public FastScrollLetter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        this.localCollator = Collator.getInstance(context2.getResources().getConfiguration().locale);
        initializeNavigationView(attributeSet);
    }

    public void initialize(LinkedHashMap<String, Integer> linkedHashMap, ArrayList<Object> arrayList) {
        this.listViewLetters = new ArrayList<>();
        this.data = new ArrayList<>();
        int i = 0;
        for (String next : linkedHashMap.keySet()) {
            this.listViewLetters.add(next);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList.subList(i, linkedHashMap.get(next).intValue() + i));
            this.data.add(arrayList2);
            i += linkedHashMap.get(next).intValue();
        }
        initialize(this.listViewLetters, this.data);
    }

    public FastScrollLetter(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        this.localCollator = Collator.getInstance(context2.getResources().getConfiguration().locale);
        initializeNavigationView(attributeSet);
    }

    public void initialize(LinkedHashMap<String, Integer> linkedHashMap) {
        this.listViewLetters = new ArrayList<>();
        this.data = new ArrayList<>();
        for (String next : linkedHashMap.keySet()) {
            this.listViewLetters.add(next);
            this.data.add(new ArrayList(Collections.nCopies(linkedHashMap.get(next).intValue(), (Object) null)));
        }
        initialize(this.listViewLetters, this.data);
    }
}
