package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import com.here.posclient.PositionEstimate;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    public static final PreQAutoCompleteTextViewReflector h0 = null;
    public boolean A;
    public boolean B;
    public CursorAdapter C;
    public boolean D;
    public CharSequence E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public CharSequence J;
    public CharSequence K;
    public boolean L;
    public int M;
    public SearchableInfo N;
    public Bundle O;
    public final Runnable P;
    public Runnable Q;
    public final WeakHashMap R;
    public final View.OnClickListener S;
    public View.OnKeyListener T;
    public final TextView.OnEditorActionListener U;
    public final AdapterView.OnItemClickListener V;
    public final AdapterView.OnItemSelectedListener W;

    /* renamed from: a  reason: collision with root package name */
    public final SearchAutoComplete f343a;
    public final View b;
    public final View c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public TextWatcher g0;
    public final ImageView h;
    public final View i;
    public UpdatableTouchDelegate j;
    public Rect k;
    public Rect l;
    public int[] m;
    public int[] n;
    public final ImageView o;
    public final Drawable p;
    public final int q;
    public final int r;
    public final Intent s;
    public final Intent t;
    public final CharSequence u;
    public OnQueryTextListener v;
    public OnCloseListener w;
    public View.OnFocusChangeListener x;
    public OnSuggestionListener y;
    public View.OnClickListener z;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @DoNotInline
        public static void b(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    public static class PreQAutoCompleteTextViewReflector {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isIconified;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.isIconified + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    @RestrictTo
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a  reason: collision with root package name */
        public int f354a;
        public SearchView b;
        public boolean c;
        public final Runnable d;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void a() {
            Api29Impl.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void c() {
            if (this.c) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.c = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f354a <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.c) {
                removeCallbacks(this.d);
                post(this.d);
            }
            return onCreateInputConnection;
        }

        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.b.B();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b.hasFocus() && getVisibility() == 0) {
                this.c = true;
                if (SearchView.o(getContext())) {
                    a();
                }
            }
        }

        public void performCompletion() {
        }

        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.c = false;
                removeCallbacks(this.d);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.c = false;
                removeCallbacks(this.d);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.c = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f354a = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.d = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.c();
                }
            };
            this.f354a = getThreshold();
        }
    }

    public static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final View f356a;
        public final Rect b = new Rect();
        public final Rect c = new Rect();
        public final Rect d = new Rect();
        public final int e;
        public boolean f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f356a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0032
                if (r2 == r5) goto L_0x0023
                if (r2 == r3) goto L_0x0023
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003e
            L_0x001b:
                boolean r2 = r8.f
                r8.f = r4
            L_0x001f:
                r7 = r5
                r5 = r2
                r2 = r7
                goto L_0x0040
            L_0x0023:
                boolean r2 = r8.f
                if (r2 == 0) goto L_0x001f
                android.graphics.Rect r6 = r8.d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x001f
                r5 = r2
                r2 = r4
                goto L_0x0040
            L_0x0032:
                android.graphics.Rect r2 = r8.b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003e
                r8.f = r5
                r2 = r5
                goto L_0x0040
            L_0x003e:
                r2 = r5
                r5 = r4
            L_0x0040:
                if (r5 == 0) goto L_0x0073
                if (r2 == 0) goto L_0x0060
                android.graphics.Rect r2 = r8.c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0060
                android.view.View r0 = r8.f356a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.f356a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                goto L_0x006d
            L_0x0060:
                android.graphics.Rect r2 = r8.c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r9.setLocation(r0, r1)
            L_0x006d:
                android.view.View r8 = r8.f356a
                boolean r4 = r8.dispatchTouchEvent(r9)
            L_0x0073:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    public static boolean o(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private void setQuery(CharSequence charSequence) {
        this.f343a.setText(charSequence);
        this.f343a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void A(CharSequence charSequence) {
        Editable text = this.f343a.getText();
        this.K = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        L(!isEmpty);
        N(isEmpty);
        G();
        K();
        if (this.v != null && !TextUtils.equals(charSequence, this.J)) {
            this.v.onQueryTextChange(charSequence.toString());
        }
        this.J = charSequence.toString();
    }

    public void B() {
        M(n());
        D();
        if (this.f343a.hasFocus()) {
            j();
        }
    }

    public void C() {
        SearchableInfo searchableInfo = this.N;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(h(this.s, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(g(this.t, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public final void D() {
        post(this.P);
    }

    public final void E(int i2) {
        Editable text = this.f343a.getText();
        Cursor cursor = this.C.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i2)) {
                CharSequence convertToString = this.C.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    public void F(CharSequence charSequence, boolean z2) {
        this.f343a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f343a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.K = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            y();
        }
    }

    public final void G() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f343a.getText());
        int i2 = 0;
        if (!z3 && (!this.A || this.L)) {
            z2 = false;
        }
        ImageView imageView = this.g;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.g.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void H() {
        int[] iArr = this.f343a.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.c.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.d.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void I() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f343a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(l(queryHint));
    }

    public final void J() {
        this.f343a.setThreshold(this.N.getSuggestThreshold());
        this.f343a.setImeOptions(this.N.getImeOptions());
        int inputType = this.N.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.N.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f343a.setInputType(inputType);
        CursorAdapter cursorAdapter = this.C;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor((Cursor) null);
        }
        if (this.N.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.N, this.R);
            this.C = suggestionsAdapter;
            this.f343a.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.C;
            if (this.F) {
                i2 = 2;
            }
            suggestionsAdapter2.t(i2);
        }
    }

    public final void K() {
        this.d.setVisibility((!p() || !(this.f.getVisibility() == 0 || this.h.getVisibility() == 0)) ? 8 : 0);
    }

    public final void L(boolean z2) {
        this.f.setVisibility((!this.D || !p() || !hasFocus() || (!z2 && this.I)) ? 8 : 0);
    }

    public final void M(boolean z2) {
        this.B = z2;
        int i2 = 8;
        int i3 = z2 ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.f343a.getText());
        this.e.setVisibility(i3);
        L(!isEmpty);
        this.b.setVisibility(z2 ? 8 : 0);
        if (this.o.getDrawable() != null && !this.A) {
            i2 = 0;
        }
        this.o.setVisibility(i2);
        G();
        N(isEmpty);
        K();
    }

    public final void N(boolean z2) {
        int i2 = 8;
        if (this.I && !n() && z2) {
            this.f.setVisibility(8);
            i2 = 0;
        }
        this.h.setVisibility(i2);
    }

    public void clearFocus() {
        this.G = true;
        super.clearFocus();
        this.f343a.clearFocus();
        this.f343a.setImeVisibility(false);
        this.G = false;
    }

    public void d() {
        if (this.i.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.c.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = ViewUtils.b(this);
            int dimensionPixelSize = this.A ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f343a.getDropDownBackground().getPadding(rect);
            this.f343a.setDropDownHorizontalOffset(b2 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f343a.setDropDownWidth((((this.i.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent e(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.K);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.O;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.N.getSearchActivity());
        return intent;
    }

    public final Intent f(Cursor cursor, int i2, String str) {
        int i3;
        String k2;
        try {
            String k3 = SuggestionsAdapter.k(cursor, "suggest_intent_action");
            if (k3 == null) {
                k3 = this.N.getSuggestIntentAction();
            }
            if (k3 == null) {
                k3 = "android.intent.action.SEARCH";
            }
            String str2 = k3;
            String k4 = SuggestionsAdapter.k(cursor, "suggest_intent_data");
            if (k4 == null) {
                k4 = this.N.getSuggestIntentData();
            }
            if (!(k4 == null || (k2 = SuggestionsAdapter.k(cursor, "suggest_intent_data_id")) == null)) {
                k4 = k4 + "/" + Uri.encode(k2);
            }
            return e(str2, k4 == null ? null : Uri.parse(k4), SuggestionsAdapter.k(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.k(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    public final Intent g(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.O;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public int getImeOptions() {
        return this.f343a.getImeOptions();
    }

    public int getInputType() {
        return this.f343a.getInputType();
    }

    public int getMaxWidth() {
        return this.H;
    }

    public CharSequence getQuery() {
        return this.f343a.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.E;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.N;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.u : getContext().getText(this.N.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.r;
    }

    public int getSuggestionRowLayout() {
        return this.q;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.C;
    }

    public final Intent h(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void i() {
        this.f343a.dismissDropDown();
    }

    public void j() {
        Api29Impl.a(this.f343a);
    }

    public final void k(View view, Rect rect) {
        view.getLocationInWindow(this.m);
        getLocationInWindow(this.n);
        int[] iArr = this.m;
        int i2 = iArr[1];
        int[] iArr2 = this.n;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    public final CharSequence l(CharSequence charSequence) {
        if (!this.A || this.p == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f343a.getTextSize()) * 1.25d);
        this.p.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.p), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean m() {
        SearchableInfo searchableInfo = this.N;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.N.getVoiceSearchLaunchWebSearch() ? this.s : this.N.getVoiceSearchLaunchRecognizer() ? this.t : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean n() {
        return this.B;
    }

    public void onActionViewCollapsed() {
        F("", false);
        clearFocus();
        M(true);
        this.f343a.setImeOptions(this.M);
        this.L = false;
    }

    public void onActionViewExpanded() {
        if (!this.L) {
            this.L = true;
            int imeOptions = this.f343a.getImeOptions();
            this.M = imeOptions;
            this.f343a.setImeOptions(imeOptions | PositionEstimate.Value.GNSS_TIME);
            this.f343a.setText("");
            setIconified(false);
        }
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.P);
        post(this.Q);
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            k(this.f343a, this.k);
            Rect rect = this.l;
            Rect rect2 = this.k;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            UpdatableTouchDelegate updatableTouchDelegate = this.j;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.l, this.k, this.f343a);
                this.j = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.a(this.l, this.k);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        if (n()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.H;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.H;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.H) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        M(savedState.isIconified);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = n();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        D();
    }

    public final boolean p() {
        return (this.D || this.I) && !n();
    }

    public final void q(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.e("SearchView", "Failed launch activity: " + intent, e2);
            }
        }
    }

    public void r(int i2, String str, String str2) {
        getContext().startActivity(e("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.G || !isFocusable()) {
            return false;
        }
        if (n()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.f343a.requestFocus(i2, rect);
        if (requestFocus) {
            M(false);
        }
        return requestFocus;
    }

    public final boolean s(int i2, int i3, String str) {
        Cursor cursor = this.C.getCursor();
        if (cursor == null || !cursor.moveToPosition(i2)) {
            return false;
        }
        q(f(cursor, i3, str));
        return true;
    }

    @RestrictTo
    public void setAppSearchData(Bundle bundle) {
        this.O = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            t();
        } else {
            x();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            M(z2);
            I();
        }
    }

    public void setImeOptions(int i2) {
        this.f343a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f343a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.H = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.w = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.x = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.v = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.y = onSuggestionListener;
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.E = charSequence;
        I();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.F = z2;
        CursorAdapter cursorAdapter = this.C;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).t(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.N = searchableInfo;
        if (searchableInfo != null) {
            J();
            I();
        }
        boolean m2 = m();
        this.I = m2;
        if (m2) {
            this.f343a.setPrivateImeOptions("nm");
        }
        M(n());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.D = z2;
        M(n());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.C = cursorAdapter;
        this.f343a.setAdapter(cursorAdapter);
    }

    public void t() {
        if (!TextUtils.isEmpty(this.f343a.getText())) {
            this.f343a.setText("");
            this.f343a.requestFocus();
            this.f343a.setImeVisibility(true);
        } else if (this.A) {
            OnCloseListener onCloseListener = this.w;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                M(true);
            }
        }
    }

    public boolean u(int i2, int i3, String str) {
        OnSuggestionListener onSuggestionListener = this.y;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i2)) {
            return false;
        }
        s(i2, 0, (String) null);
        this.f343a.setImeVisibility(false);
        i();
        return true;
    }

    public boolean v(int i2) {
        OnSuggestionListener onSuggestionListener = this.y;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i2)) {
            return false;
        }
        E(i2);
        return true;
    }

    public void w(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void x() {
        M(false);
        this.f343a.requestFocus();
        this.f343a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.z;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void y() {
        Editable text = this.f343a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.v;
            if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
                if (this.N != null) {
                    r(0, (String) null, text.toString());
                }
                this.f343a.setImeVisibility(false);
                i();
            }
        }
    }

    public boolean z(View view, int i2, KeyEvent keyEvent) {
        if (this.N != null && this.C != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return u(this.f343a.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f343a.setSelection(i2 == 21 ? 0 : this.f343a.length());
                this.f343a.setListSelection(0);
                this.f343a.clearListSelection();
                this.f343a.a();
                return true;
            } else if (i2 == 19) {
                this.f343a.getListSelection();
                return false;
            }
        }
        return false;
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new Rect();
        this.l = new Rect();
        this.m = new int[2];
        this.n = new int[2];
        this.P = new Runnable() {
            public void run() {
                SearchView.this.H();
            }
        };
        this.Q = new Runnable() {
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.C;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.changeCursor((Cursor) null);
                }
            }
        };
        this.R = new WeakHashMap();
        AnonymousClass5 r8 = new View.OnClickListener() {
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.e) {
                    searchView.x();
                } else if (view == searchView.g) {
                    searchView.t();
                } else if (view == searchView.f) {
                    searchView.y();
                } else if (view == searchView.h) {
                    searchView.C();
                } else if (view == searchView.f343a) {
                    searchView.j();
                }
            }
        };
        this.S = r8;
        this.T = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.N == null) {
                    return false;
                }
                if (searchView.f343a.isPopupShowing() && SearchView.this.f343a.getListSelection() != -1) {
                    return SearchView.this.z(view, i, keyEvent);
                }
                if (SearchView.this.f343a.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.r(0, (String) null, searchView2.f343a.getText().toString());
                return true;
            }
        };
        AnonymousClass7 r9 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.y();
                return true;
            }
        };
        this.U = r9;
        AnonymousClass8 r10 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SearchView.this.u(i, 0, (String) null);
            }
        };
        this.V = r10;
        AnonymousClass9 r11 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
                SearchView.this.v(i);
            }

            public void onNothingSelected(AdapterView adapterView) {
            }
        };
        this.W = r11;
        this.g0 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.A(charSequence);
            }
        };
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet2, R.styleable.SearchView, i3, 0);
        ViewCompat.s0(this, context, R.styleable.SearchView, attributeSet2, v2.r(), i3, 0);
        LayoutInflater.from(context).inflate(v2.n(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f343a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.b = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.c = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.d = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.g = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.h = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.o = imageView5;
        ViewCompat.z0(findViewById, v2.g(R.styleable.SearchView_queryBackground));
        ViewCompat.z0(findViewById2, v2.g(R.styleable.SearchView_submitBackground));
        imageView.setImageDrawable(v2.g(R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(v2.g(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(v2.g(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(v2.g(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(v2.g(R.styleable.SearchView_searchIcon));
        this.p = v2.g(R.styleable.SearchView_searchHintIcon);
        TooltipCompat.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.q = v2.n(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.r = v2.n(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(r8);
        imageView3.setOnClickListener(r8);
        imageView2.setOnClickListener(r8);
        imageView4.setOnClickListener(r8);
        searchAutoComplete.setOnClickListener(r8);
        searchAutoComplete.addTextChangedListener(this.g0);
        searchAutoComplete.setOnEditorActionListener(r9);
        searchAutoComplete.setOnItemClickListener(r10);
        searchAutoComplete.setOnItemSelectedListener(r11);
        searchAutoComplete.setOnKeyListener(this.T);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.x;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                }
            }
        });
        setIconifiedByDefault(v2.a(R.styleable.SearchView_iconifiedByDefault, true));
        int f2 = v2.f(R.styleable.SearchView_android_maxWidth, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.u = v2.p(R.styleable.SearchView_defaultQueryHint);
        this.E = v2.p(R.styleable.SearchView_queryHint);
        int k2 = v2.k(R.styleable.SearchView_android_imeOptions, -1);
        if (k2 != -1) {
            setImeOptions(k2);
        }
        int k3 = v2.k(R.styleable.SearchView_android_inputType, -1);
        if (k3 != -1) {
            setInputType(k3);
        }
        setFocusable(v2.a(R.styleable.SearchView_android_focusable, true));
        v2.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.s = intent;
        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.t = intent2;
        intent2.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.i = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.d();
                }
            });
        }
        M(this.A);
        I();
    }
}
