package flyme.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.common.animator.MzPressAnimationDrawable;
import flyme.support.v7.R;
import flyme.support.v7.widget.PinnedHeader.RecyclerPinnedHeaderDecoration;
import flyme.support.v7.widget.RecyclerViewGestureDetector;
import flyme.support.v7.widget.animations.GlobalOverScrollListener;
import flyme.support.v7.widget.animations.SpringAnimationHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MzRecyclerView extends RecyclerView {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int CHOICE_MODE_MULTIPLE_MODAL_MZ = 4;
    public static final int CHOICE_MODE_MULTIPLE_MODAL_MZ_ALWAYS = 5;
    public static final int CHOICE_MODE_NONE = 0;
    private static final String CLASS_NAME_FLYME_FEATURE = "flyme.config.FlymeFeature";
    private static final float DAMPING_DEFAULT = 0.99f;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAG_SCROLL = false;
    public static final float DEFAULTDOWNOFFSETVALUE = 50.0f;
    public static final float DEFAULTUPOFFSETVALUE = -50.0f;
    private static final float EDGE_VELOCITY_FACTOR = 0.5f;
    private static final String FIELD_SUPPORT_MOTOR = "SHELL_HAPTICFEEDBACK_MOTOR";
    private static final String FIELD_USE_QCOM_VIBRATE = "USE_QCOM_VIBRATE";
    private static final int INVALID_POINTER = -1;
    /* access modifiers changed from: private */
    public static float INVALUE_VALUE = Float.MAX_VALUE;
    private static final int MULTI_CHOICE_ACTION_MENU_HEIGHT = 84;
    private static int NOT_SET_OVER_SCROLL_STATUS = -1;
    public static final int OFFSET_DOWN = 1;
    public static final int OFFSET_NO = 3;
    public static final int OFFSET_UP = 2;
    private static final float STIFFNESS_DEFAULT = 228.0f;
    private static final String TAG = "MzRecyclerView";
    private static final int TOUCH_MODE_DONE_WAITING = 2;
    private static final int TOUCH_MODE_DOWN = 0;
    private static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_REST = -1;
    private static final int TOUCH_MODE_SCROLL = 3;
    private static boolean mAvoidNotifyItemRangeChanged = false;
    private static Field mShellHapticFeedBackMotor;
    private static Field mUseQCOMVibrate;
    /* access modifiers changed from: private */
    public boolean isSony;
    protected Rect mCheckRegionRect;
    /* access modifiers changed from: private */
    public SparseBooleanArray mCheckStates;
    protected int mCheckWidth;
    /* access modifiers changed from: private */
    public LongSparseArray<Integer> mCheckedIdStates;
    private int mCheckedItemCount;
    /* access modifiers changed from: private */
    public ActionMode mChoiceActionMode;
    /* access modifiers changed from: private */
    public int mChoiceMode;
    private float mCurrentTouchPosition;
    protected int mDefaultCheckWidth;
    /* access modifiers changed from: private */
    public int mDragDownPosition;
    private int mDragMotionPosition;
    private int mDragMotionViewBottom;
    private int mDragMotionViewTop;
    /* access modifiers changed from: private */
    public int mDragMotionY;
    private OnDragSelectListener mDragSelectListener;
    /* access modifiers changed from: private */
    public boolean mDragSelectionEnable;
    boolean mDrawSelectorOnTop;
    /* access modifiers changed from: private */
    public boolean mEnableHoldPress;
    /* access modifiers changed from: private */
    public boolean mEnableImmersive;
    private boolean mEnableParallax;
    private FeedbackHandlerThread mFeedbackHandlerThread;
    /* access modifiers changed from: private */
    public int mFirstDragSelectStatus;
    /* access modifiers changed from: private */
    public FlingRunnable mFlingRunnable;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private RecyclerViewGestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public boolean mHasCallFinishActionMode;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private StateListDrawable mHoldPressDrawable;
    /* access modifiers changed from: private */
    public HoldView mHoldView;
    /* access modifiers changed from: private */
    public boolean mInCheckRegion;
    /* access modifiers changed from: private */
    public boolean mInMultiChoiceState;
    /* access modifiers changed from: private */
    public boolean mIsBeginDragSelect;
    private boolean mIsCheckBoxAnim;
    private boolean mIsOutOfDragRegion;
    private boolean mIsOutOfListContent;
    /* access modifiers changed from: private */
    public boolean mIsUserEnableOverScroll;
    private int[][] mItemDragSelectStatus;
    /* access modifiers changed from: private */
    public ItemFilter mItemFilter;
    protected int mLastDownSelectPosition;
    private int mLastDragMotionY;
    private float mLastTouchPosition;
    protected int mLastUpSelectPosition;
    protected int mListItemHeight;
    /* access modifiers changed from: private */
    public boolean mLongPressDrag;
    /* access modifiers changed from: private */
    public int mLongPressPosition;
    private float mMoveLength;
    /* access modifiers changed from: private */
    public Runnable mMultiChoiceDelayRunnable;
    /* access modifiers changed from: private */
    public MultiChoiceListener mMultiChoiceListener;
    /* access modifiers changed from: private */
    public MultiChoiceModeWrapper mMultiChoiceModeCallback;
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public OnItemLongClickListener mOnItemLongClickListener;
    private int mOverScrollModeBeforeDrag;
    private final OverScroller mOverScroller;
    /* access modifiers changed from: private */
    public ParallaxAnimationListener mParallaxAnimationListener;
    /* access modifiers changed from: private */
    public int mPressStateDuration;
    private RecyclerPinnedHeaderDecoration mRecyclerPinnedHeaderDecoration;
    private boolean mRequestLayoutWhenSwitchActionMode;
    private ScrollItemManager mScrollItemManager;
    private ScrollSelectionRunnable mScrollSelection;
    private boolean mScrollUpWhenItemCoveredInMultiChoiceEnable;
    private int mScrollbarPadding;
    private Method mScrollbarPaddingMethod;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    Rect mSelectorRect;
    private boolean mShouldRequestDisallow;
    /* access modifiers changed from: private */
    public boolean mShowPressed;
    /* access modifiers changed from: private */
    public final SpringAnimationHelper mSpringAnimationHelper;
    /* access modifiers changed from: private */
    public int mTouchMode;
    private HashSet<RecyclerView.ViewHolder> mViewHolderHashSet;

    public static abstract class Adapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements MzRvAdapterBaseInterface {
        private int mHeadCount;
        private RecyclerView rv;

        public boolean areAllItemsEnabled() {
            return true;
        }

        public int immersiveItemType(int i) {
            return 3;
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public boolean isSelectable(int i) {
            return true;
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.rv = recyclerView;
        }

        public void onBindViewHolder(@NonNull VH vh, int i) {
            MzRecyclerView mzRecyclerView = (MzRecyclerView) this.rv;
            mzRecyclerView.setViewChecked(vh.itemView, this.mHeadCount + i);
            if (mzRecyclerView.mEnableImmersive) {
                mzRecyclerView.setImmersiveItemBackground(vh.itemView, immersiveItemType(i));
            }
        }

        public void setHeadCount(int i) {
            this.mHeadCount = i;
        }
    }

    public class FixedViewInfo {
        public boolean isSelectable;
        public RecyclerView.ViewHolder viewHolder;

        public FixedViewInfo() {
        }
    }

    public class FlingRunnable implements Runnable {
        private int mLastOverFlingY = 0;
        private OverScroller mScroller;

        public FlingRunnable() {
            this.mScroller = new OverScroller(MzRecyclerView.this.getContext());
        }

        public void endFling() {
            int unused = MzRecyclerView.this.mTouchMode = -1;
            MzRecyclerView.this.removeCallbacks(this);
            MzRecyclerViewHelper.invokeRvSetScrollState(0, RecyclerView.class, MzRecyclerView.this);
            this.mScroller.abortAnimation();
        }

        public void run() {
            OverScroller overScroller = this.mScroller;
            if (!overScroller.isFinished()) {
                overScroller.computeScrollOffset();
                int currY = overScroller.getCurrY();
                int currY2 = overScroller.getCurrY() - this.mLastOverFlingY;
                this.mLastOverFlingY = currY;
                if (currY2 != 0) {
                    MzRecyclerView.this.trackMotionScroll(-currY2, true);
                }
                MzRecyclerView.this.invalidate();
                MzRecyclerView.this.postOnAnimation(this);
                return;
            }
            endFling();
        }
    }

    public class HoldView {
        long id;
        int position;
        View view;

        public HoldView(View view2, int i, long j) {
            this.view = view2;
            this.position = i;
            this.id = j;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImmersiveType {
        public static final int IMMERSIVE_ALONE = 3;
        public static final int IMMERSIVE_FOOT = 2;
        public static final int IMMERSIVE_FOOT_RELATED_SETTING = 7;
        public static final int IMMERSIVE_HEAD = 0;
        public static final int IMMERSIVE_HEAD_RELATED_SETTING = 5;
        public static final int IMMERSIVE_NORMAL = 1;
        public static final int IMMERSIVE_NORMAL_RELATED_SETTING = 6;
        public static final int IMMERSIVE_TITLE = 4;
    }

    public static abstract class ItemDecoration extends RecyclerView.ItemDecoration {
        private HashSet<Integer> mNoDividerPositionSync = new HashSet<>();
        private HashSet<Integer> mNoDividerPositions = new HashSet<>();

        public void addNoDividerPosition(int i) {
            this.mNoDividerPositions.add(Integer.valueOf(i));
        }

        public boolean canDrawDivider(int i) {
            return !this.mNoDividerPositions.contains(Integer.valueOf(i)) && !this.mNoDividerPositionSync.contains(Integer.valueOf(i));
        }

        public void clearNoDividerPosition() {
            this.mNoDividerPositions.clear();
        }

        public void clearNoDividerPositionSync() {
            this.mNoDividerPositionSync.clear();
        }

        public HashSet<Integer> getmNoDividerPositions() {
            return this.mNoDividerPositions;
        }

        public void onDrawOverChildren(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void onDrawUnderForeground(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        }

        public void removeNoDividerPosition(int i) {
            this.mNoDividerPositions.remove(new Integer(i));
        }

        public void setNoDividerPositionSync(HashSet<Integer> hashSet) {
            this.mNoDividerPositionSync.addAll(hashSet);
        }
    }

    public interface ItemFilter {
        boolean isLongPressForItem(int i);
    }

    public class ItemGestureDetector extends RecyclerViewGestureDetector {
        private ItemGestureListener itemGestureListener;
        private int lastTouchX;
        private int lastTouchY;
        private int scrollPointerId = -1;
        private int touchSlop;
        private VelocityTracker velocityTracker;

        public ItemGestureDetector(Context context, ItemGestureListener itemGestureListener2) {
            super(context, itemGestureListener2);
            this.itemGestureListener = itemGestureListener2;
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            RecyclerView.LayoutManager layoutManager = MzRecyclerView.this.getLayoutManager();
            boolean z = false;
            if (layoutManager == null) {
                return false;
            }
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = layoutManager.canScrollVertically();
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z2 = true;
                if (action == 1) {
                    this.velocityTracker.computeCurrentVelocity(1000, (float) MzRecyclerView.this.getMaxFlingVelocity());
                    float f = 0.0f;
                    float f2 = canScrollHorizontally ? -this.velocityTracker.getXVelocity(this.scrollPointerId) : 0.0f;
                    if (canScrollVertically) {
                        f = -this.velocityTracker.getYVelocity(this.scrollPointerId);
                    }
                    if ((Math.abs(f) >= ((float) MzRecyclerView.this.getMinFlingVelocity()) || Math.abs(f2) >= ((float) MzRecyclerView.this.getMinFlingVelocity())) && MzRecyclerView.this.mTouchMode == 3) {
                        int unused = MzRecyclerView.this.mTouchMode = 4;
                    }
                    this.itemGestureListener.onUp();
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                    mzRecyclerView.mCheckWidth = mzRecyclerView.mDefaultCheckWidth;
                    mzRecyclerView.ensureCheckRegion(true);
                } else if (action == 2) {
                    int x = (int) (motionEvent.getX() + 0.5f);
                    int y = (int) (motionEvent.getY() + 0.5f);
                    int i = this.lastTouchX - x;
                    int i2 = this.lastTouchY - y;
                    if (canScrollHorizontally && Math.abs(i) > this.touchSlop) {
                        z = true;
                    }
                    if (!canScrollVertically || Math.abs(i2) <= this.touchSlop) {
                        z2 = z;
                    }
                    if (MzRecyclerView.this.mTouchMode == 2 && z2) {
                        this.itemGestureListener.startScrolled();
                    }
                    if (z2) {
                        this.lastTouchX = x;
                        this.lastTouchY = y;
                    }
                } else if (action == 3) {
                    this.itemGestureListener.onCancel();
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    if (velocityTracker3 != null) {
                        velocityTracker3.clear();
                    }
                    MzRecyclerView mzRecyclerView2 = MzRecyclerView.this;
                    mzRecyclerView2.mCheckWidth = mzRecyclerView2.mDefaultCheckWidth;
                    mzRecyclerView2.ensureCheckRegion(true);
                }
            } else {
                this.lastTouchX = (int) (motionEvent.getX() + 0.5f);
                this.lastTouchY = (int) (motionEvent.getY() + 0.5f);
                this.scrollPointerId = MotionEventCompat.b(motionEvent, 0);
            }
            return onTouchEvent;
        }
    }

    public class ItemGestureListener implements RecyclerViewGestureDetector.OnGestureListener {
        /* access modifiers changed from: private */
        public View clickView;
        /* access modifiers changed from: private */
        public boolean isTapDown;

        private ItemGestureListener() {
            this.isTapDown = false;
        }

        /* access modifiers changed from: private */
        public boolean performItemClick(RecyclerView recyclerView, View view, int i, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            if (MzRecyclerView.this.mzIsHeaderOrFooter(i)) {
                return true;
            }
            if (MzRecyclerView.this.mChoiceMode != 0) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                boolean isSelectable = adapter instanceof MzRvAdapterBaseInterface ? ((MzRvAdapterBaseInterface) adapter).isSelectable(i) : true;
                if ((MzRecyclerView.this.mChoiceMode == 4 || MzRecyclerView.this.mChoiceMode == 5) && ((MzRecyclerView.this.mChoiceActionMode != null || MzRecyclerView.this.mInMultiChoiceState) && isSelectable)) {
                    boolean z4 = !MzRecyclerView.this.mCheckStates.get(i, false);
                    MzRecyclerView.this.mCheckStates.put(i, z4);
                    if (MzRecyclerView.this.mCheckedIdStates != null && adapter.hasStableIds()) {
                        if (z4) {
                            MzRecyclerView.this.mCheckedIdStates.put(adapter.getItemId(i), Integer.valueOf(i));
                        } else {
                            MzRecyclerView.this.mCheckedIdStates.delete(adapter.getItemId(i));
                        }
                    }
                    if (z4) {
                        MzRecyclerView.access$2808(MzRecyclerView.this);
                    } else {
                        MzRecyclerView.access$2810(MzRecyclerView.this);
                    }
                    if (MzRecyclerView.this.mChoiceActionMode != null) {
                        MzRecyclerView.this.mMultiChoiceModeCallback.onItemCheckedStateChanged(MzRecyclerView.this.mChoiceActionMode, i, j, z4);
                    } else if (!MzRecyclerView.this.mInMultiChoiceState || MzRecyclerView.this.mMultiChoiceListener == null) {
                        z2 = true;
                        z3 = true;
                    } else {
                        MzRecyclerView.this.mMultiChoiceListener.onItemCheckedStateChanged(i, j, z4);
                    }
                    z2 = false;
                    z3 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
                if (z3) {
                    MzRecyclerView.this.updateOnScreenCheckedViews();
                }
                z = true;
            } else {
                z2 = true;
                z = false;
            }
            if (z2 && MzRecyclerView.this.mOnItemClickListener != null) {
                recyclerView.playSoundEffect(0);
                MzRecyclerView.this.mOnItemClickListener.onItemClick(recyclerView, view, i, j);
                view.sendAccessibilityEvent(1);
                z = true;
            }
            if (z2 && MzRecyclerView.this.mEnableHoldPress) {
                if (!MzRecyclerView.this.mShowPressed) {
                    view.setHovered(true);
                }
                if (MzRecyclerView.this.mHoldView == null) {
                    MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                    HoldView unused = mzRecyclerView.mHoldView = new HoldView(view, i, j);
                } else {
                    MzRecyclerView.this.mHoldView.view = view;
                    MzRecyclerView.this.mHoldView.position = i;
                    MzRecyclerView.this.mHoldView.id = j;
                }
            }
            return z;
        }

        private boolean performLongPress(RecyclerView recyclerView, int i, long j) {
            if (MzRecyclerView.this.mzIsHeaderOrFooter(i)) {
                return true;
            }
            if (MzRecyclerView.this.mChoiceMode == 4 || MzRecyclerView.this.mChoiceMode == 5) {
                if (MzRecyclerView.this.getAdapter() instanceof MzRvAdapterBaseInterface ? ((MzRvAdapterBaseInterface) MzRecyclerView.this.getAdapter()).isSelectable(i) : true) {
                    if (MzRecyclerView.this.mMultiChoiceModeCallback != null) {
                        if (MzRecyclerView.this.mChoiceActionMode == null) {
                            MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                            if (mzRecyclerView.mChoiceActionMode = recyclerView.startActionMode(mzRecyclerView.mMultiChoiceModeCallback) != null) {
                                MzRecyclerView.this.setItemChecked(i, true);
                                if (MzRecyclerView.this.hasFlymeFeature()) {
                                    recyclerView.performHapticFeedback(30900);
                                } else {
                                    recyclerView.performHapticFeedback(0);
                                }
                                MzRecyclerView.this.scrollUpIfNeeded(this.clickView);
                                MzRecyclerView.this.notifyPossibleUpdate(false);
                            }
                        }
                    } else if (MzRecyclerView.this.mMultiChoiceListener != null) {
                        MzRecyclerView.this.mMultiChoiceListener.onEnterMultiChoice();
                        boolean unused = MzRecyclerView.this.mInMultiChoiceState = true;
                        MzRecyclerView.this.setItemChecked(i, true);
                        if (MzRecyclerView.this.hasFlymeFeature()) {
                            recyclerView.performHapticFeedback(30900);
                        } else {
                            recyclerView.performHapticFeedback(0);
                        }
                    }
                    return true;
                }
            }
            boolean onItemLongClick = MzRecyclerView.this.mOnItemLongClickListener != null ? MzRecyclerView.this.mOnItemLongClickListener.onItemLongClick(recyclerView, this.clickView, i, j) : false;
            if (onItemLongClick) {
                if (MzRecyclerView.this.hasFlymeFeature()) {
                    recyclerView.performHapticFeedback(30900);
                } else {
                    recyclerView.performHapticFeedback(0);
                }
            }
            if (MzRecyclerView.this.mDragSelectionEnable) {
                int unused2 = MzRecyclerView.this.mLongPressPosition = i;
            }
            return onItemLongClick;
        }

        public void dispatchSingleTapUpIfNeeded(MotionEvent motionEvent) {
            if (this.clickView != null) {
                onSingleTapUp(motionEvent);
            }
        }

        public void onCancel() {
            MzRecyclerView.this.endDragSelection();
            int unused = MzRecyclerView.this.mTouchMode = -1;
            MzRecyclerViewHelper.invokeRvSetScrollState(0, RecyclerView.class, MzRecyclerView.this);
            View view = this.clickView;
            if (view != null) {
                view.setPressed(false);
            }
            MzRecyclerView.this.setPressed(false);
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (MzRecyclerView.this.mTouchMode == 4 && MzRecyclerView.this.getScrollState() == 1) {
                int unused = MzRecyclerView.this.mTouchMode = 3;
            } else {
                int unused2 = MzRecyclerView.this.mTouchMode = 0;
                int y = (int) motionEvent.getY();
                int x = (int) motionEvent.getX();
                MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                Rect rect = mzRecyclerView.mCheckRegionRect;
                if ((mzRecyclerView.mChoiceActionMode != null || MzRecyclerView.this.mInMultiChoiceState) && MzRecyclerView.this.mDragSelectionEnable && !MzRecyclerView.this.mIsBeginDragSelect && MzRecyclerView.this.getScrollState() == 0 && x >= rect.left && x <= rect.right && MzRecyclerView.this.onDragMotionChanged(y)) {
                    int unused3 = MzRecyclerView.this.mDragMotionY = y;
                }
                this.isTapDown = true;
                this.clickView = MzRecyclerView.this.findChildViewUnder((float) x, (float) y);
            }
            boolean unused4 = MzRecyclerView.this.mShowPressed = false;
            int unused5 = MzRecyclerView.this.mFirstDragSelectStatus = -1;
            MzRecyclerView mzRecyclerView2 = MzRecyclerView.this;
            mzRecyclerView2.mCheckWidth = mzRecyclerView2.mDefaultCheckWidth;
            mzRecyclerView2.ensureCheckRegion(true);
            boolean unused6 = MzRecyclerView.this.mLongPressDrag = false;
            return this.clickView != null;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.isTapDown = false;
            if (MzRecyclerView.this.mTouchMode == 3) {
                int unused = MzRecyclerView.this.mTouchMode = 4;
            }
            MzRecyclerView.this.mSelectorRect.setEmpty();
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0123  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onLongPress(android.view.MotionEvent r9) {
            /*
                r8 = this;
                r0 = 0
                r8.isTapDown = r0
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.animations.SpringAnimationHelper r1 = r1.mSpringAnimationHelper
                boolean r1 = r1.isOverScrollDynamic()
                if (r1 == 0) goto L_0x002d
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                float r1 = r1.getTranslationY()
                float r1 = java.lang.Math.abs(r1)
                flyme.support.v7.widget.MzRecyclerView r2 = flyme.support.v7.widget.MzRecyclerView.this
                android.content.Context r2 = r2.getContext()
                android.view.ViewConfiguration r2 = android.view.ViewConfiguration.get(r2)
                int r2 = r2.getScaledTouchSlop()
                float r2 = (float) r2
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 <= 0) goto L_0x002d
                return
            L_0x002d:
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                int r1 = r1.mTouchMode
                r2 = 3
                if (r1 != r2) goto L_0x0037
                return
            L_0x0037:
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r1 = r1.isLongClickable()
                r2 = 2
                if (r1 == 0) goto L_0x0129
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                int r1 = r1.mTouchMode
                if (r1 == 0) goto L_0x004a
                goto L_0x0129
            L_0x004a:
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                int unused = r1.mTouchMode = r2
                android.view.View r1 = r8.clickView
                r3 = 1
                if (r1 == 0) goto L_0x00a5
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                int r1 = r4.getChildPositionExt(r1)
                if (r1 < 0) goto L_0x00a5
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView$ItemFilter r4 = r4.mItemFilter
                if (r4 == 0) goto L_0x0070
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                flyme.support.v7.widget.MzRecyclerView$ItemFilter r4 = r4.mItemFilter
                boolean r4 = r4.isLongPressForItem(r1)
                if (r4 == 0) goto L_0x00a5
            L_0x0070:
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()
                long r4 = r4.getItemId(r1)
                flyme.support.v7.widget.MzRecyclerView r6 = flyme.support.v7.widget.MzRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
                boolean r6 = r6 instanceof flyme.support.v7.widget.MzRecyclerView.MzRvAdapterBaseInterface
                if (r6 == 0) goto L_0x0091
                flyme.support.v7.widget.MzRecyclerView r6 = flyme.support.v7.widget.MzRecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r6 = r6.getAdapter()
                flyme.support.v7.widget.MzRecyclerView$MzRvAdapterBaseInterface r6 = (flyme.support.v7.widget.MzRecyclerView.MzRvAdapterBaseInterface) r6
                boolean r6 = r6.isEnabled(r1)
                goto L_0x0092
            L_0x0091:
                r6 = r3
            L_0x0092:
                if (r6 == 0) goto L_0x00a5
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r6 = androidx.recyclerview.widget.RecyclerView.class
                flyme.support.v7.widget.MzRecyclerView r7 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r6 = flyme.support.v7.widget.MzRecyclerViewHelper.invokeRvStateDidStructureChange(r6, r7)
                if (r6 != 0) goto L_0x00a5
                flyme.support.v7.widget.MzRecyclerView r6 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r1 = r8.performLongPress(r6, r1, r4)
                goto L_0x00a6
            L_0x00a5:
                r1 = r0
            L_0x00a6:
                if (r1 == 0) goto L_0x0123
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                r1.setPressed(r0)
                android.view.View r1 = r8.clickView
                r1.setPressed(r0)
                r0 = 0
                r8.clickView = r0
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                android.graphics.Rect r0 = r0.mSelectorRect
                r0.setEmpty()
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                r1 = -1
                int unused = r0.mTouchMode = r1
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.mChoiceMode
                r1 = 4
                if (r0 == r1) goto L_0x00d4
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.mChoiceMode
                r1 = 5
                if (r0 != r1) goto L_0x0128
            L_0x00d4:
                float r0 = r9.getY()
                int r0 = (int) r0
                float r9 = r9.getX()
                int r9 = (int) r9
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                android.graphics.Rect r2 = r1.mCheckRegionRect
                android.view.ActionMode r1 = r1.mChoiceActionMode
                if (r1 != 0) goto L_0x00f0
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r1 = r1.mInMultiChoiceState
                if (r1 == 0) goto L_0x0128
            L_0x00f0:
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r1 = r1.mDragSelectionEnable
                if (r1 == 0) goto L_0x0128
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r1 = r1.mIsBeginDragSelect
                if (r1 != 0) goto L_0x0128
                flyme.support.v7.widget.MzRecyclerView r1 = flyme.support.v7.widget.MzRecyclerView.this
                int r1 = r1.getScrollState()
                if (r1 != 0) goto L_0x0128
                int r1 = r2.left
                if (r9 < r1) goto L_0x0128
                int r1 = r2.right
                if (r9 > r1) goto L_0x0128
                flyme.support.v7.widget.MzRecyclerView r9 = flyme.support.v7.widget.MzRecyclerView.this
                boolean r9 = r9.onDragMotionChanged(r0)
                if (r9 == 0) goto L_0x0128
                flyme.support.v7.widget.MzRecyclerView r9 = flyme.support.v7.widget.MzRecyclerView.this
                int unused = r9.mDragMotionY = r0
                flyme.support.v7.widget.MzRecyclerView r8 = flyme.support.v7.widget.MzRecyclerView.this
                boolean unused = r8.mLongPressDrag = r3
                goto L_0x0128
            L_0x0123:
                flyme.support.v7.widget.MzRecyclerView r8 = flyme.support.v7.widget.MzRecyclerView.this
                int unused = r8.mTouchMode = r2
            L_0x0128:
                return
            L_0x0129:
                flyme.support.v7.widget.MzRecyclerView r8 = flyme.support.v7.widget.MzRecyclerView.this
                int unused = r8.mTouchMode = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzRecyclerView.ItemGestureListener.onLongPress(android.view.MotionEvent):void");
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.isTapDown = false;
            startScrolled();
            return MzRecyclerView.this.startDragSelection(motionEvent2);
        }

        public void onShowPress(MotionEvent motionEvent) {
            if (MzRecyclerView.this.mTouchMode != 3 && !MzRecyclerView.this.mSpringAnimationHelper.isOverScrollDynamic()) {
                if (this.clickView != null && !MzRecyclerView.this.mInCheckRegion) {
                    int access$1300 = MzRecyclerView.this.getChildPositionExt(this.clickView);
                    boolean isEnabled = MzRecyclerView.this.getAdapter() instanceof MzRvAdapterBaseInterface ? ((MzRvAdapterBaseInterface) MzRecyclerView.this.getAdapter()).isEnabled(access$1300) : true;
                    if (access$1300 >= 0 && isEnabled) {
                        MzRecyclerView.this.setPressed(true);
                        this.clickView.setPressed(true);
                        MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                        mzRecyclerView.positionSelector(mzRecyclerView.getChildLayoutPosition(this.clickView), this.clickView);
                        Drawable drawable = MzRecyclerView.this.mSelector;
                        if (drawable != null) {
                            drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                        }
                    }
                }
                this.isTapDown = false;
                int unused = MzRecyclerView.this.mTouchMode = 0;
                boolean unused2 = MzRecyclerView.this.mShowPressed = true;
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            boolean z;
            View view;
            boolean z2 = false;
            if (MzRecyclerView.this.getAdapter() == null || !(MzRecyclerView.this.getAdapter() instanceof MzRvAdapterBaseInterface) || (view = this.clickView) == null) {
                z = true;
            } else {
                int childLayoutPosition = MzRecyclerView.this.getChildLayoutPosition(view);
                z = childLayoutPosition == -1 ? false : ((MzRvAdapterBaseInterface) MzRecyclerView.this.getAdapter()).isEnabled(childLayoutPosition);
            }
            if (this.clickView != null && !MzRecyclerViewHelper.invokeRvStateDidStructureChange(RecyclerView.class, MzRecyclerView.this) && MzRecyclerView.this.mTouchMode == 0 && z) {
                if (!MzRecyclerView.this.isSony && MzRecyclerView.this.mSpringAnimationHelper.isOverScrollDynamic()) {
                    return false;
                }
                int access$1800 = this.isTapDown ? MzRecyclerView.this.mPressStateDuration : 0;
                Log.d(MzRecyclerView.TAG, "mPressStateDuration " + MzRecyclerView.this.mPressStateDuration + " time " + access$1800);
                if (this.isTapDown) {
                    MzRecyclerView.this.setPressed(true);
                    this.clickView.setPressed(true);
                    MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                    mzRecyclerView.positionSelector(mzRecyclerView.getChildLayoutPosition(this.clickView), this.clickView);
                    Drawable drawable = MzRecyclerView.this.mSelector;
                    if (drawable != null) {
                        drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                    }
                }
                if (MzRecyclerView.this.mOnItemClickListener != null) {
                    z2 = true;
                }
                MzRecyclerView.this.postDelayed(new Runnable() {
                    public void run() {
                        if (ItemGestureListener.this.clickView != null) {
                            MzRecyclerView.this.setPressed(false);
                            ItemGestureListener.this.clickView.setPressed(false);
                            ItemGestureListener itemGestureListener = ItemGestureListener.this;
                            int access$1300 = MzRecyclerView.this.getChildPositionExt(itemGestureListener.clickView);
                            if (access$1300 >= 0) {
                                if (!MzRecyclerViewHelper.invokeRvStateDidStructureChange(RecyclerView.class, MzRecyclerView.this) && MzRecyclerView.this.isAttachedToWindow()) {
                                    long itemId = MzRecyclerView.this.getAdapter().getItemId(access$1300);
                                    ItemGestureListener itemGestureListener2 = ItemGestureListener.this;
                                    boolean unused = itemGestureListener2.performItemClick(MzRecyclerView.this, itemGestureListener2.clickView, access$1300, itemId);
                                }
                            }
                            View unused2 = ItemGestureListener.this.clickView = null;
                            boolean unused3 = ItemGestureListener.this.isTapDown = false;
                        }
                    }
                }, (long) access$1800);
                int unused = MzRecyclerView.this.mTouchMode = -1;
            }
            return z2;
        }

        public boolean onUp() {
            if (this.clickView != null && !this.isTapDown) {
                MzRecyclerView.this.setPressed(false);
                this.clickView.setPressed(false);
            }
            if (MzRecyclerView.this.mTouchMode == 2) {
                int access$1300 = MzRecyclerView.this.getChildPositionExt(this.clickView);
                boolean isEnabled = (MzRecyclerView.this.getAdapter() == null || !(MzRecyclerView.this.getAdapter() instanceof MzRvAdapterBaseInterface)) ? true : ((MzRvAdapterBaseInterface) MzRecyclerView.this.getAdapter()).isEnabled(MzRecyclerView.this.getChildLayoutPosition(this.clickView));
                if (access$1300 >= 0 && !MzRecyclerViewHelper.invokeRvStateDidStructureChange(RecyclerView.class, MzRecyclerView.this) && MzRecyclerView.this.isAttachedToWindow() && isEnabled) {
                    long itemId = MzRecyclerView.this.getAdapter().getItemId(access$1300);
                    if (!MzRecyclerView.this.mSpringAnimationHelper.isOverScrollDynamic()) {
                        performItemClick(MzRecyclerView.this, this.clickView, access$1300, itemId);
                    }
                }
            }
            if (MzRecyclerView.this.mIsBeginDragSelect && MzRecyclerView.this.mDragDownPosition != -1) {
                MzRecyclerView mzRecyclerView = MzRecyclerView.this;
                mzRecyclerView.downSelect(-1, mzRecyclerView.mDragDownPosition);
            }
            MzRecyclerView.this.endDragSelection();
            if (MzRecyclerView.this.mFlingRunnable == null) {
                MzRecyclerView mzRecyclerView2 = MzRecyclerView.this;
                FlingRunnable unused = mzRecyclerView2.mFlingRunnable = new FlingRunnable();
            }
            if (MzRecyclerView.this.mTouchMode == 3 || MzRecyclerView.this.mTouchMode == 0 || MzRecyclerView.this.mTouchMode == 2) {
                int unused2 = MzRecyclerView.this.mTouchMode = -1;
            }
            return false;
        }

        public void startScrolled() {
            MzRecyclerView.this.setPressed(false);
            View view = this.clickView;
            if (view != null) {
                view.setPressed(false);
            }
            Drawable drawable = MzRecyclerView.this.mSelector;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            MzRecyclerView.this.mSelectorRect.setEmpty();
            int unused = MzRecyclerView.this.mTouchMode = 3;
        }
    }

    public static class MZSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MZSavedState> CREATOR = new Parcelable.Creator<MZSavedState>() {
            public MZSavedState createFromParcel(Parcel parcel) {
                return new MZSavedState(parcel);
            }

            public MZSavedState[] newArray(int i) {
                return new MZSavedState[i];
            }
        };
        LongSparseArray<Integer> checkIdState;
        SparseBooleanArray checkState;
        int checkedItemCount;
        boolean inActionMode;

        public String toString() {
            return "MzRecyclerView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checkState=" + this.checkState + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.inActionMode ? (byte) 1 : 0);
            parcel.writeInt(this.checkedItemCount);
            parcel.writeSparseBooleanArray(this.checkState);
            LongSparseArray<Integer> longSparseArray = this.checkIdState;
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(this.checkIdState.keyAt(i2));
                parcel.writeInt(this.checkIdState.valueAt(i2).intValue());
            }
        }

        public MZSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private MZSavedState(Parcel parcel) {
            super(parcel);
            this.inActionMode = parcel.readByte() != 0;
            this.checkedItemCount = parcel.readInt();
            this.checkState = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.checkIdState = new LongSparseArray<>();
                for (int i = 0; i < readInt; i++) {
                    this.checkIdState.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }
    }

    public interface MultiChoiceListener {
        void onEnterMultiChoice();

        void onFinishMultiChoice();

        void onItemCheckedStateChanged(int i, long j, boolean z);
    }

    public interface MultiChoiceModeListener extends ActionMode.Callback {
        void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z);
    }

    public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
        private MultiChoiceModeListener mWrapped;

        public MultiChoiceModeWrapper() {
        }

        public boolean hasWrappedCallback() {
            return this.mWrapped != null;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (!this.mWrapped.onCreateActionMode(actionMode, menu)) {
                return false;
            }
            if (MzRecyclerView.this.mChoiceMode == 4 || MzRecyclerView.this.mChoiceMode == 5) {
                MzRecyclerView.this.setLongClickable(true);
            } else {
                MzRecyclerView.this.setLongClickable(false);
            }
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            if (MzRecyclerView.this.mIsUserEnableOverScroll) {
                MzRecyclerView.this.mSpringAnimationHelper.setOverScrollEnable(true);
            }
            this.mWrapped.onDestroyActionMode(actionMode);
            ActionMode unused = MzRecyclerView.this.mChoiceActionMode = null;
            boolean unused2 = MzRecyclerView.this.mHasCallFinishActionMode = true;
            MzRecyclerView.this.clearChoices();
            MzRecyclerView.this.updateOnScreenCheckedViews();
            MzRecyclerView.this.setLongClickable(true);
            MzRecyclerViewHelper.invokeRvRecyclerVClear(RecyclerView.class, MzRecyclerView.this);
            MzRecyclerView.this.getRecycledViewPool().clear();
        }

        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            this.mWrapped.onItemCheckedStateChanged(actionMode, i, j, z);
            if (MzRecyclerView.this.getCheckedItemCount() == 0) {
                int unused = MzRecyclerView.this.mChoiceMode;
            }
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }

        public void setWrapped(MultiChoiceModeListener multiChoiceModeListener) {
            this.mWrapped = multiChoiceModeListener;
        }
    }

    public interface MzRvAdapterBaseInterface {
        int immersiveItemType(int i);

        boolean isEnabled(int i);

        boolean isSelectable(int i);
    }

    public interface OnDragSelectListener {
        boolean onDragSelection(View view, int i, long j);
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int i, long j);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(RecyclerView recyclerView, View view, int i, long j);
    }

    public interface OverScrollListener extends GlobalOverScrollListener {
    }

    public interface ParallaxAnimationListener {
        public static final int ANIMATE_STATE_END = 3;
        public static final int ANIMATE_STATE_RUNING = 2;
        public static final int ANIMATE_STATE_START = 1;

        void onAddViewHolderWhenAnimation(RecyclerView.ViewHolder viewHolder);

        void onAnimationStateChange(int i, HashSet hashSet);

        void onRecycleViewHolderWhenAnimation(RecyclerView.ViewHolder viewHolder);

        void onRunning(int i, int i2, int i3, HashSet hashSet);
    }

    public class ScrollItemManager {
        private int mBaseDuration = 500;
        private TimeInterpolator mInterpolator = new LinearInterpolator();
        /* access modifiers changed from: private */
        public boolean mIsParallaxAnimationComplete = true;
        /* access modifiers changed from: private */
        public int mOffsetState = 3;
        private ArrayList<ScrollItem> mScrollItemCache = new ArrayList<>();
        /* access modifiers changed from: private */
        public HashMap<View, ScrollItem> mScrollItemHashMap = new HashMap<>();
        private float mScrollProportion = 0.0f;
        private int mSensitivity = 5;
        private int mSmoothBackAnimationDuration;
        private ValueAnimator mSmoothBackAnimator;

        public ScrollItemManager() {
        }

        private float calculateOffset(ScrollItem scrollItem, float f) {
            float downThreshold;
            float upScrollOffsetRatio;
            float f2 = 0.0f;
            int i = (scrollItem.getCurrentOffset() > 0.0f ? 1 : (scrollItem.getCurrentOffset() == 0.0f ? 0 : -1));
            if (i == 0) {
                if (f > 0.0f) {
                    if (scrollItem.getDownThreshold() == 0.0f) {
                        return 0.0f;
                    }
                    float offsetAfterSmoothBack = scrollItem.getOffsetAfterSmoothBack();
                    if (offsetAfterSmoothBack < 0.0f) {
                        offsetAfterSmoothBack *= Math.abs(scrollItem.getDownThreshold() / scrollItem.getUpThreshold());
                    }
                    upScrollOffsetRatio = offsetAfterSmoothBack + (scrollItem.getDownScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                    if (upScrollOffsetRatio > scrollItem.getDownThreshold()) {
                        downThreshold = scrollItem.getDownThreshold();
                    }
                } else if (scrollItem.getUpThreshold() == 0.0f) {
                    return 0.0f;
                } else {
                    float offsetAfterSmoothBack2 = scrollItem.getOffsetAfterSmoothBack();
                    if (offsetAfterSmoothBack2 > 0.0f) {
                        offsetAfterSmoothBack2 *= Math.abs(scrollItem.getUpThreshold() / scrollItem.getDownThreshold());
                    }
                    upScrollOffsetRatio = offsetAfterSmoothBack2 + (scrollItem.getUpScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                    if (upScrollOffsetRatio < scrollItem.getUpThreshold()) {
                        downThreshold = scrollItem.getUpThreshold();
                    }
                }
                return upScrollOffsetRatio;
            } else if (i > 0) {
                if (scrollItem.getDownThreshold() == 0.0f) {
                    return 0.0f;
                }
                float offsetAfterSmoothBack3 = scrollItem.getOffsetAfterSmoothBack();
                if (offsetAfterSmoothBack3 < 0.0f) {
                    offsetAfterSmoothBack3 *= Math.abs(scrollItem.getDownThreshold() / scrollItem.getUpThreshold());
                }
                float downScrollOffsetRatio = offsetAfterSmoothBack3 + (scrollItem.getDownScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                if (downScrollOffsetRatio >= 0.0f) {
                    f2 = downScrollOffsetRatio;
                }
                if (f2 <= scrollItem.getDownThreshold()) {
                    return f2;
                }
                downThreshold = scrollItem.getDownThreshold();
            } else if (scrollItem.getUpThreshold() == 0.0f) {
                return 0.0f;
            } else {
                float offsetAfterSmoothBack4 = scrollItem.getOffsetAfterSmoothBack();
                if (offsetAfterSmoothBack4 > 0.0f) {
                    offsetAfterSmoothBack4 *= Math.abs(scrollItem.getUpThreshold() / scrollItem.getDownThreshold());
                }
                float upScrollOffsetRatio2 = offsetAfterSmoothBack4 + (scrollItem.getUpScrollOffsetRatio() * (f / ((float) this.mSensitivity)));
                if (upScrollOffsetRatio2 <= 0.0f) {
                    f2 = upScrollOffsetRatio2;
                }
                return f2 < scrollItem.getUpThreshold() ? scrollItem.getUpThreshold() : f2;
            }
            return downThreshold;
        }

        public void addScrollItem(View view, RecyclerView.ViewHolder viewHolder) {
            addScrollItem(view, viewHolder, 1.0f, 1.0f);
        }

        public void addScrollItemToCache(ScrollItem scrollItem) {
            this.mScrollItemCache.add(scrollItem);
        }

        public void cancleSmoothBackToOriginalPosition() {
            ValueAnimator valueAnimator = this.mSmoothBackAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mSmoothBackAnimator.cancel();
            }
        }

        public ScrollItem getScrollItemFromCache() {
            if (this.mScrollItemCache.size() <= 0) {
                return null;
            }
            ArrayList<ScrollItem> arrayList = this.mScrollItemCache;
            ScrollItem scrollItem = arrayList.get(arrayList.size() - 1);
            this.mScrollItemCache.remove(scrollItem);
            return scrollItem;
        }

        public HashMap<View, ScrollItem> getScrollItemHashMap() {
            return this.mScrollItemHashMap;
        }

        public boolean isParallaxAnimationComplete() {
            return this.mIsParallaxAnimationComplete;
        }

        public void resetOriginalTransilationY() {
            for (ScrollItem originalTransilationY : this.mScrollItemHashMap.values()) {
                originalTransilationY.setOriginalTransilationY(MzRecyclerView.INVALUE_VALUE);
            }
        }

        public void setBaseDuration(int i) {
            this.mBaseDuration = i;
        }

        public void setParallaxAnimationComplete(boolean z) {
            this.mIsParallaxAnimationComplete = z;
        }

        public void setSensitivity(int i) {
            this.mSensitivity = i;
        }

        public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
            this.mInterpolator = timeInterpolator;
        }

        public void startSmoothBackToOriginalPosition() {
            if (this.mOffsetState == 3) {
                resetOriginalTransilationY();
                this.mIsParallaxAnimationComplete = true;
                if (MzRecyclerView.this.mParallaxAnimationListener != null) {
                    MzRecyclerView.this.mParallaxAnimationListener.onAnimationStateChange(3, MzRecyclerView.this.getViewHoldSet());
                    return;
                }
                return;
            }
            this.mSmoothBackAnimationDuration = (int) (((float) this.mBaseDuration) * this.mScrollProportion);
            for (ScrollItem next : this.mScrollItemHashMap.values()) {
                next.setOffsetBeforeSmoothBack(next.getCurrentOffset());
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            this.mSmoothBackAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.translateItemY(((Float) valueAnimator.getAnimatedValue()).floatValue() * scrollItem.getOffsetBeforeSmoothBack());
                    }
                }
            });
            this.mSmoothBackAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = ScrollItemManager.this.mIsParallaxAnimationComplete = true;
                    for (ScrollItem scrollItem : ScrollItemManager.this.mScrollItemHashMap.values()) {
                        scrollItem.setOffsetAfterSmoothBack(scrollItem.getCurrentOffset());
                        if (scrollItem.getCurrentOffset() != 0.0f) {
                            boolean unused2 = ScrollItemManager.this.mIsParallaxAnimationComplete = false;
                        } else {
                            scrollItem.setOriginalTransilationY(MzRecyclerView.INVALUE_VALUE);
                        }
                    }
                    if (ScrollItemManager.this.mIsParallaxAnimationComplete) {
                        int unused3 = ScrollItemManager.this.mOffsetState = 3;
                    }
                    if (ScrollItemManager.this.mIsParallaxAnimationComplete && MzRecyclerView.this.mParallaxAnimationListener != null) {
                        MzRecyclerView.this.mParallaxAnimationListener.onAnimationStateChange(3, MzRecyclerView.this.getViewHoldSet());
                    }
                }
            });
            this.mSmoothBackAnimator.setDuration((long) this.mSmoothBackAnimationDuration);
            this.mSmoothBackAnimator.setInterpolator(this.mInterpolator);
            this.mSmoothBackAnimator.start();
        }

        public void translateItemY(float f) {
            if (f != 0.0f || this.mOffsetState != 3) {
                this.mOffsetState = 3;
                this.mScrollProportion = 0.0f;
                for (ScrollItem next : this.mScrollItemHashMap.values()) {
                    float calculateOffset = calculateOffset(next, f);
                    if (calculateOffset > 0.0f) {
                        this.mOffsetState = 1;
                        this.mScrollProportion = Math.abs(calculateOffset / next.getDownThreshold());
                    } else if (calculateOffset < 0.0f) {
                        this.mOffsetState = 2;
                        this.mScrollProportion = Math.abs(calculateOffset / next.getUpThreshold());
                    }
                    next.translateItemY(calculateOffset);
                }
            }
        }

        public void addScrollItem(View view, RecyclerView.ViewHolder viewHolder, float f, float f2) {
            if (this.mScrollItemCache.size() > 0) {
                ScrollItem scrollItemFromCache = getScrollItemFromCache();
                scrollItemFromCache.setTranslateView(view);
                scrollItemFromCache.setScrollOffsetRatio(f, f2);
                scrollItemFromCache.setViewHolder(viewHolder);
                this.mScrollItemHashMap.put(view, scrollItemFromCache);
                return;
            }
            ScrollItem scrollItem = new ScrollItem();
            scrollItem.setTranslateView(view);
            scrollItem.setScrollOffsetRatio(f, f2);
            scrollItem.setViewHolder(viewHolder);
            this.mScrollItemHashMap.put(view, scrollItem);
        }
    }

    public final class ScrollSelectionRunnable implements Runnable {
        private static final int SCROLL_DURATION = 5;
        private static final int SCROLL_SPEED = 10;
        private boolean mStart = false;
        private boolean mUpSelect = true;

        public ScrollSelectionRunnable() {
        }

        public void finish() {
            this.mStart = false;
            MzRecyclerView.this.removeCallbacks(this);
        }

        public boolean isStarted() {
            return this.mStart;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            if (r10.this$0.getFirstPosition() == 0) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
            if ((r10.this$0.getFirstPosition() + flyme.support.v7.widget.MzRecyclerView.access$4600(r10.this$0)) == flyme.support.v7.widget.MzRecyclerView.access$3900(r10.this$0)) goto L_0x0079;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                boolean r0 = r10.mUpSelect
                r1 = -1
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x0039
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r8 = androidx.recyclerview.widget.RecyclerView.class
                flyme.support.v7.widget.MzRecyclerView r9 = flyme.support.v7.widget.MzRecyclerView.this
                r4 = 0
                r0 = -10
                r6 = 0
                r7 = 0
                r5 = r0
                boolean r4 = flyme.support.v7.widget.MzRecyclerViewHelper.invokeRvScrollByInternal(r4, r5, r6, r7, r8, r9)
                flyme.support.v7.widget.MzRecyclerView r5 = flyme.support.v7.widget.MzRecyclerView.this
                r5.trackMotionScroll(r0, r3)
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.findCandidateScrollSelection(r2)
                if (r0 != r1) goto L_0x0024
                r1 = r2
                goto L_0x0025
            L_0x0024:
                r1 = r3
            L_0x0025:
                flyme.support.v7.widget.MzRecyclerView r5 = flyme.support.v7.widget.MzRecyclerView.this
                int r6 = r5.mLastUpSelectPosition
                if (r6 == r0) goto L_0x002e
                r5.upSelect(r6, r0)
            L_0x002e:
                if (r4 != 0) goto L_0x0078
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.getFirstPosition()
                if (r0 != 0) goto L_0x0078
                goto L_0x0079
            L_0x0039:
                java.lang.Class<androidx.recyclerview.widget.RecyclerView> r8 = androidx.recyclerview.widget.RecyclerView.class
                flyme.support.v7.widget.MzRecyclerView r9 = flyme.support.v7.widget.MzRecyclerView.this
                r4 = 0
                r0 = 10
                r6 = 0
                r7 = 0
                r5 = r0
                boolean r4 = flyme.support.v7.widget.MzRecyclerViewHelper.invokeRvScrollByInternal(r4, r5, r6, r7, r8, r9)
                flyme.support.v7.widget.MzRecyclerView r5 = flyme.support.v7.widget.MzRecyclerView.this
                r5.trackMotionScroll(r0, r3)
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.findCandidateScrollSelection(r3)
                if (r0 != r1) goto L_0x0056
                r1 = r2
                goto L_0x0057
            L_0x0056:
                r1 = r3
            L_0x0057:
                flyme.support.v7.widget.MzRecyclerView r5 = flyme.support.v7.widget.MzRecyclerView.this
                int r6 = r5.mLastDownSelectPosition
                if (r6 == r0) goto L_0x0060
                r5.downSelect(r6, r0)
            L_0x0060:
                if (r4 != 0) goto L_0x0078
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                int r0 = r0.getFirstPosition()
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                int r4 = r4.getChildCountExt()
                int r0 = r0 + r4
                flyme.support.v7.widget.MzRecyclerView r4 = flyme.support.v7.widget.MzRecyclerView.this
                int r4 = r4.getItemCount()
                if (r0 != r4) goto L_0x0078
                goto L_0x0079
            L_0x0078:
                r2 = r1
            L_0x0079:
                if (r2 != 0) goto L_0x0082
                flyme.support.v7.widget.MzRecyclerView r0 = flyme.support.v7.widget.MzRecyclerView.this
                r1 = 5
                r0.postDelayed(r10, r1)
            L_0x0082:
                flyme.support.v7.widget.MzRecyclerView r10 = flyme.support.v7.widget.MzRecyclerView.this
                android.content.Context r10 = r10.getContext()
                r0 = 2
                r1 = 300(0x12c, float:4.2E-43)
                flyme.support.v7.util.ImportanceUXHintHelper.importanceUXHint(r10, r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzRecyclerView.ScrollSelectionRunnable.run():void");
        }

        public void startScrollSelected(boolean z) {
            this.mUpSelect = z;
            this.mStart = true;
            MzRecyclerView.this.post(this);
        }
    }

    public interface SelectionBoundsAdjuster {
        void adjustListItemSelectionBounds(Rect rect);
    }

    public MzRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ int access$2808(MzRecyclerView mzRecyclerView) {
        int i = mzRecyclerView.mCheckedItemCount;
        mzRecyclerView.mCheckedItemCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$2810(MzRecyclerView mzRecyclerView) {
        int i = mzRecyclerView.mCheckedItemCount;
        mzRecyclerView.mCheckedItemCount = i - 1;
        return i;
    }

    private void cancelBackgroundAnimation(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.jumpToCurrentState();
        }
    }

    private void checkDuringTouch(MotionEvent motionEvent) {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            if (getScrollY() != 0) {
                ensureCheckRegion(true);
            } else {
                ensureCheckRegion(false);
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 || actionMasked == 2) {
                checkInRegion((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (actionMasked == 3) {
                this.mInCheckRegion = false;
                return;
            }
            return;
        }
        this.mInCheckRegion = false;
        this.mDragSelectionEnable = false;
        this.mDragSelectListener = null;
    }

    private void checkInRegion(int i, int i2) {
        Rect rect = this.mCheckRegionRect;
        this.mInCheckRegion = rect != null && rect.contains(i, i2);
    }

    private static int dip2px(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: private */
    public void endDragSelection() {
        this.mDragMotionY = -1;
        this.mLastDragMotionY = -1;
        this.mIsBeginDragSelect = false;
        this.mIsOutOfDragRegion = false;
        this.mDragDownPosition = -1;
        this.mLastDownSelectPosition = -1;
        this.mLastUpSelectPosition = -1;
        this.mDragMotionPosition = -1;
        this.mIsOutOfListContent = false;
        ScrollSelectionRunnable scrollSelectionRunnable = this.mScrollSelection;
        if (scrollSelectionRunnable != null) {
            scrollSelectionRunnable.finish();
        }
    }

    private View findMotionRow(int i) {
        for (int childCount = getLayoutManager().getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getLayoutManager().getChildAt(childCount);
            float translationY = childAt.getTranslationY();
            float f = (float) i;
            if (f >= ((float) getDecoratedTop(childAt)) + translationY && f <= ((float) getDecoratedBottom(childAt)) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    private boolean findRecyclerViewParent(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup instanceof RecyclerView) {
            return true;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            return findRecyclerViewParent((ViewGroup) parent);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public int getChildCountExt() {
        return getLayoutManager().getChildCount();
    }

    /* access modifiers changed from: private */
    public int getChildPositionExt(View view) {
        if (view == null) {
            return -1;
        }
        return getChildLayoutPosition(view);
    }

    private Drawable getImmersiveResById(String str) {
        return getResources().getDrawable(getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
    }

    /* access modifiers changed from: private */
    public int getItemCount() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    private boolean handleDragCheckRegion() {
        if ((this.mInMultiChoiceState || this.mChoiceActionMode != null) && (getLayoutManager() instanceof LinearLayoutManager) && !this.mSpringAnimationHelper.isOverScrollDynamic()) {
            return this.mInCheckRegion || this.mIsBeginDragSelect;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasFlymeFeature() {
        /*
            r2 = this;
            r2 = 0
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x000c
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x002a
            goto L_0x000c
        L_0x000a:
            r0 = move-exception
            goto L_0x003d
        L_0x000c:
            java.lang.String r0 = "flyme.config.FlymeFeature"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            java.lang.reflect.Field r1 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = "SHELL_HAPTICFEEDBACK_MOTOR"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mShellHapticFeedBackMotor = r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x001e:
            java.lang.reflect.Field r1 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r1 != 0) goto L_0x002a
            java.lang.String r1 = "USE_QCOM_VIBRATE"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            mUseQCOMVibrate = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
        L_0x002a:
            java.lang.reflect.Field r0 = mShellHapticFeedBackMotor     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            r1 = 0
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 != 0) goto L_0x003b
            java.lang.reflect.Field r0 = mUseQCOMVibrate     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x000a }
            if (r0 == 0) goto L_0x0040
        L_0x003b:
            r2 = 1
            goto L_0x0040
        L_0x003d:
            r0.printStackTrace()
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzRecyclerView.hasFlymeFeature():boolean");
    }

    private void initRecyclerView() {
        Resources resources = getResources();
        this.mInCheckRegion = false;
        this.mDefaultCheckWidth = resources.getDimensionPixelSize(R.dimen.mz_list_check_width);
        this.mListItemHeight = resources.getDimensionPixelSize(R.dimen.mz_list_item_height);
        this.mDragSelectListener = null;
        this.mIsBeginDragSelect = false;
        this.mDragMotionViewTop = 0;
        this.mDragMotionViewBottom = 0;
        this.mDragMotionPosition = -1;
        this.mDragMotionY = -1;
        this.mLastDragMotionY = 0;
        this.mScrollSelection = null;
        this.mIsOutOfListContent = false;
        this.mLongPressPosition = -1;
        this.mLastUpSelectPosition = -1;
        this.mLastDownSelectPosition = -1;
        this.mScrollbarPadding = getResources().getDimensionPixelSize(R.dimen.mz_recyclerview_scrollbar_padding);
    }

    private void initSpringAnimationHelper() {
        this.mSpringAnimationHelper.setDamping(DAMPING_DEFAULT);
        this.mSpringAnimationHelper.setStiffness(STIFFNESS_DEFAULT);
        this.mSpringAnimationHelper.setEdgeVelocityFactor(0.5f);
    }

    private boolean isUiModeNight(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    private boolean needScrollUpInMultiChoiceMode(View view) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || layoutManager == null || !layoutManager.canScrollVertically()) {
            return false;
        }
        if (layoutManager.getChildCount() >= adapter.getItemCount()) {
            Log.i(TAG, "item view do not fill screen.");
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Point point = new Point();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.y - (iArr[1] + view.getMeasuredHeight()) < dip2px(getContext(), 64.0f);
    }

    private void notifyPossibleUpdate() {
        notifyPossibleUpdate(this.mRequestLayoutWhenSwitchActionMode);
    }

    /* access modifiers changed from: private */
    public boolean onDragMotionChanged(int i) {
        View findMotionRow = findMotionRow(i);
        if (findMotionRow == null) {
            return false;
        }
        this.mDragMotionPosition = getChildPositionExt(findMotionRow);
        this.mDragMotionViewTop = getDecoratedTop(findMotionRow);
        this.mDragMotionViewBottom = getDecoratedBottom(findMotionRow);
        return true;
    }

    private void onDrawForegroundInternal(Canvas canvas) {
        int itemDecorationCount = getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            if (getItemDecorationAt(i) instanceof ItemDecoration) {
                ((ItemDecoration) getItemDecorationAt(i)).onDrawUnderForeground(canvas, this, MzRecyclerViewHelper.getStateField(RecyclerView.class, this));
            }
        }
    }

    private void onLayoutExt() {
        if (this.mChoiceMode == 5 && !this.mHasCallFinishActionMode && this.mMultiChoiceDelayRunnable == null) {
            AnonymousClass2 r0 = new Runnable() {
                public void run() {
                    MzRecyclerView.this.startMultiChoice();
                    Runnable unused = MzRecyclerView.this.mMultiChoiceDelayRunnable = null;
                }
            };
            this.mMultiChoiceDelayRunnable = r0;
            post(r0);
        }
    }

    private void refreshSelectStatus() {
        int itemCount = getAdapter().getItemCount();
        int[] iArr = new int[2];
        iArr[1] = 2;
        int i = 0;
        iArr[0] = itemCount;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int[][] iArr3 = this.mItemDragSelectStatus;
        if (iArr3 != null && iArr3.length < iArr2.length) {
            while (true) {
                int[][] iArr4 = this.mItemDragSelectStatus;
                if (i < iArr4.length) {
                    iArr2[i] = iArr4[i];
                    i++;
                } else {
                    this.mItemDragSelectStatus = iArr2;
                    return;
                }
            }
        }
    }

    private FixedViewInfo removeFixedViewInfo(RecyclerView.ViewHolder viewHolder, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FixedViewInfo fixedViewInfo = arrayList.get(i);
            if (fixedViewInfo.viewHolder == viewHolder) {
                arrayList.remove(i);
                return fixedViewInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void scrollUpIfNeeded(View view) {
        if (this.mScrollUpWhenItemCoveredInMultiChoiceEnable && needScrollUpInMultiChoiceMode(view)) {
            smoothScrollBy(0, dip2px(getContext(), 84.0f));
        }
    }

    public static void setAvoidNotifyItemRangeChanged(boolean z) {
        mAvoidNotifyItemRangeChanged = z;
    }

    /* access modifiers changed from: private */
    public boolean startDragSelection(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = this.mCheckRegionRect;
        boolean z = false;
        if (this.mChoiceActionMode == null && !this.mInMultiChoiceState) {
            return false;
        }
        if (this.mDragSelectionEnable && !this.mIsBeginDragSelect && this.mDragMotionY >= 0) {
            this.mDragDownPosition = this.mDragMotionPosition;
            this.mDragMotionY = y;
            this.mLastDragMotionY = y;
            this.mIsBeginDragSelect = true;
            int itemCount = getAdapter().getItemCount();
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = itemCount;
            this.mItemDragSelectStatus = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            this.mCheckWidth = getWidth();
            ensureCheckRegion(true);
            boolean unused = super.onTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
            this.mTouchMode = 3;
            return true;
        } else if (this.mIsOutOfDragRegion) {
            return true;
        } else {
            boolean z2 = this.mIsBeginDragSelect;
            if (!z2 || (x >= rect.left && x <= rect.right)) {
                if (z2) {
                    this.mLastDragMotionY = this.mDragMotionY;
                    this.mDragMotionY = y;
                }
                if (!z2) {
                    return false;
                }
                if (this.mIsOutOfListContent) {
                    if (onDragMotionChanged(y)) {
                        if (this.mLastDragMotionY < 0) {
                            downSelect(-1, this.mDragMotionPosition);
                        } else {
                            upSelect(-1, this.mDragMotionPosition);
                        }
                        this.mIsOutOfListContent = false;
                    }
                    return true;
                } else if (canScrollSelect(y)) {
                    if (this.mScrollSelection == null) {
                        this.mScrollSelection = new ScrollSelectionRunnable();
                    }
                    if (!this.mScrollSelection.isStarted()) {
                        if (y < getPaddingTop() + this.mListItemHeight) {
                            z = true;
                        }
                        this.mScrollSelection.startScrollSelected(z);
                    }
                    return true;
                } else {
                    ScrollSelectionRunnable scrollSelectionRunnable = this.mScrollSelection;
                    if (scrollSelectionRunnable != null && scrollSelectionRunnable.isStarted()) {
                        this.mScrollSelection.finish();
                    }
                    if (y < this.mDragMotionViewTop) {
                        int i = this.mDragDownPosition;
                        if (i != -1) {
                            upSelect(-1, i);
                            this.mDragDownPosition = -1;
                        }
                        int i2 = this.mLastDownSelectPosition;
                        if (i2 != -1) {
                            upSelect(-1, i2);
                        }
                        if (!onDragMotionChanged(y)) {
                            int firstPosition = getFirstPosition();
                            int i3 = this.mLastUpSelectPosition;
                            if (i3 != firstPosition) {
                                upSelect(i3, firstPosition);
                            }
                            this.mLastDownSelectPosition = -1;
                            this.mLastUpSelectPosition = -1;
                            this.mIsOutOfListContent = true;
                            return true;
                        }
                        upSelect(this.mLastUpSelectPosition, this.mDragMotionPosition);
                    } else if (y > this.mDragMotionViewBottom) {
                        int i4 = this.mDragDownPosition;
                        if (i4 != -1) {
                            downSelect(-1, i4);
                            this.mDragDownPosition = -1;
                        }
                        int i5 = this.mLastUpSelectPosition;
                        if (i5 != -1) {
                            downSelect(-1, i5);
                        }
                        if (!onDragMotionChanged(y)) {
                            int lastPosition = getLastPosition();
                            int i6 = this.mLastDownSelectPosition;
                            if (i6 != lastPosition) {
                                downSelect(i6, lastPosition);
                            }
                            this.mLastDownSelectPosition = -1;
                            this.mLastUpSelectPosition = -1;
                            this.mIsOutOfListContent = true;
                            return true;
                        }
                        downSelect(this.mLastDownSelectPosition, this.mDragMotionPosition);
                    }
                    return true;
                }
            } else {
                this.mIsOutOfDragRegion = true;
                ScrollSelectionRunnable scrollSelectionRunnable2 = this.mScrollSelection;
                if (scrollSelectionRunnable2 != null) {
                    scrollSelectionRunnable2.finish();
                }
                return true;
            }
        }
    }

    private void syncDrawDecoration() {
        int itemDecorationCount = getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            if (getItemDecorationAt(i) instanceof ItemDecoration) {
                ((ItemDecoration) getItemDecorationAt(i)).clearNoDividerPositionSync();
            }
        }
        for (int i2 = 0; i2 < itemDecorationCount; i2++) {
            if (getItemDecorationAt(i2) instanceof ItemDecoration) {
                HashSet<Integer> hashSet = ((ItemDecoration) getItemDecorationAt(i2)).getmNoDividerPositions();
                for (int i3 = 0; i3 < itemDecorationCount; i3++) {
                    if (i2 != i3 && (getItemDecorationAt(i3) instanceof ItemDecoration)) {
                        ((ItemDecoration) getItemDecorationAt(i3)).setNoDividerPositionSync(hashSet);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void trackMotionScroll(int i, boolean z) {
        if (getChildCountExt() != 0) {
            if (z) {
                offsetChildrenVertical(i);
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
        }
    }

    private void updateHoldView() {
        HoldView holdView;
        int i;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter.hasStableIds() && (holdView = this.mHoldView) != null && (i = holdView.position) != -1) {
            long j = holdView.id;
            if (j != adapter.getItemId(i)) {
                View view = this.mHoldView.view;
                if (view != null) {
                    view.setHovered(false);
                    cancelBackgroundAnimation(this.mHoldView.view);
                }
                HoldView holdView2 = this.mHoldView;
                holdView2.view = null;
                holdView2.position = -1;
                int min = Math.min(i + 20, adapter.getItemCount());
                for (int max = Math.max(0, i - 20); max < min; max++) {
                    if (j == adapter.getItemId(max)) {
                        RecyclerView.ViewHolder findViewHolderForItemId = findViewHolderForItemId(j);
                        if (findViewHolderForItemId != null) {
                            HoldView holdView3 = this.mHoldView;
                            holdView3.position = max;
                            holdView3.view = findViewHolderForItemId.itemView;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateOnScreenCheckedViews() {
        int childCountExt = getChildCountExt();
        for (int i = 0; i < childCountExt; i++) {
            View childAtExt = getChildAtExt(i);
            setViewChecked(childAtExt, getChildPositionExt(childAtExt));
        }
    }

    private void useDefaultSelector() {
        Drawable drawable;
        Log.i(TAG, "useDefaultSelector,  try to get f10 res");
        try {
            drawable = getResources().getDrawable(getResources().getIdentifier("mz_recyclerview_selector_f10", "drawable", getContext().getPackageName()));
        } catch (Exception e) {
            Log.i(TAG, "useDefaultSelector,  get f10 res fail , may be app code compression: " + e);
            drawable = null;
        }
        if (drawable == null) {
            Log.i(TAG, "useDefaultSelector, get f10 res fail, and try to reflect MzPressAnimationDrawable");
            Class<MzPressAnimationDrawable> cls = MzPressAnimationDrawable.class;
            try {
                int i = MzPressAnimationDrawable.f9492a;
                MzPressAnimationDrawable newInstance = cls.getConstructor((Class[]) null).newInstance((Object[]) null);
                if (newInstance instanceof Drawable) {
                    if (isUiModeNight(getResources().getConfiguration())) {
                        Method declaredMethod = cls.getDeclaredMethod("setTint", new Class[]{Integer.TYPE});
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(newInstance, new Object[]{-1});
                        Method declaredMethod2 = cls.getDeclaredMethod("setAlphaTo", new Class[]{Float.TYPE});
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(newInstance, new Object[]{Float.valueOf(0.03f)});
                    }
                    drawable = newInstance;
                }
            } catch (Exception e2) {
                Log.i(TAG, "useDefaultSelector,  try to reflect MzPressAnimationDrawable fail " + e2);
            }
        }
        if (drawable == null) {
            Log.i(TAG, "useDefaultSelector,  try to reflect MzPressAnimationDrawable fail , and to get old res");
            drawable = getResources().getDrawable(R.drawable.mz_recyclerview_selector);
        }
        setSelector(drawable);
    }

    public void addAnimateView(View view, RecyclerView.ViewHolder viewHolder) {
        addAnimateView(view, viewHolder, -50.0f, 50.0f);
    }

    @Deprecated
    public void addFooterView(RecyclerView.ViewHolder viewHolder) {
        addFooterView(viewHolder, true);
    }

    @Deprecated
    public void addHeaderView(RecyclerView.ViewHolder viewHolder) {
        addHeaderView(viewHolder, true);
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        if (!(itemDecoration instanceof ItemDecoration)) {
            Log.i(TAG, "you should use MzRecyclerView.ItemDecoration!! Otherwise, it may cause problems");
        }
        super.addItemDecoration(itemDecoration);
    }

    public void addOnOverScrollListener(@NonNull OverScrollListener overScrollListener) {
        this.mSpringAnimationHelper.addOnOverScrollListener(overScrollListener);
    }

    public boolean canScrollSelect(int i) {
        int childCountExt = getChildCountExt();
        if (childCountExt <= 0) {
            return false;
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View childAtExt = getChildAtExt(0);
        int childPositionExt = getChildPositionExt(childAtExt);
        boolean z = childPositionExt == 0 && childAtExt.getTop() >= getPaddingTop();
        boolean z2 = i < paddingTop + this.mListItemHeight;
        if (z && z2) {
            return false;
        }
        boolean z3 = childPositionExt + childCountExt == getItemCount() && getChildAtExt(childCountExt - 1).getBottom() <= getHeight() - getPaddingBottom();
        boolean z4 = i > height - this.mListItemHeight;
        if (!z3 || !z4) {
            return z2 || z4;
        }
        return false;
    }

    public void checkedAll() {
        boolean z;
        boolean z2;
        int itemCount = getItemCount();
        RecyclerView.Adapter adapter = getAdapter();
        if (itemCount != 0 && adapter != null) {
            int itemCount2 = getItemCount() - getFooterViewsCount();
            clearChoices();
            if (this.mChoiceMode != 0) {
                for (int headerViewsCount = getHeaderViewsCount(); headerViewsCount < itemCount2; headerViewsCount++) {
                    if (adapter instanceof MzRvAdapterBaseInterface) {
                        MzRvAdapterBaseInterface mzRvAdapterBaseInterface = (MzRvAdapterBaseInterface) adapter;
                        z = mzRvAdapterBaseInterface.isEnabled(headerViewsCount);
                        z2 = mzRvAdapterBaseInterface.isSelectable(headerViewsCount);
                    } else {
                        z2 = true;
                        z = true;
                    }
                    if (z && z2) {
                        this.mCheckStates.put(headerViewsCount, true);
                        if (this.mCheckedIdStates != null && adapter.hasStableIds()) {
                            this.mCheckedIdStates.put(adapter.getItemId(headerViewsCount), Integer.valueOf(headerViewsCount));
                        }
                        this.mCheckedItemCount++;
                    }
                }
            }
            notifyPossibleUpdate();
        }
    }

    public void clearChoices() {
        SparseBooleanArray sparseBooleanArray = this.mCheckStates;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.mCheckedItemCount = 0;
    }

    public void clearOnOverScrollListener() {
        this.mSpringAnimationHelper.clearOnOverScrollListener();
    }

    public void confirmCheckedPositionsById() {
        ActionMode actionMode;
        MultiChoiceListener multiChoiceListener;
        MultiChoiceModeWrapper multiChoiceModeWrapper;
        RecyclerView.Adapter adapter = getAdapter();
        if (this.mChoiceMode != 0 && adapter != null && adapter.hasStableIds()) {
            int itemCount = getItemCount();
            this.mCheckStates.clear();
            int i = 0;
            boolean z = false;
            while (i < this.mCheckedIdStates.size()) {
                long keyAt = this.mCheckedIdStates.keyAt(i);
                int intValue = this.mCheckedIdStates.valueAt(i).intValue();
                if (keyAt != adapter.getItemId(intValue)) {
                    int max = Math.max(0, intValue - 20);
                    int min = Math.min(intValue + 20, itemCount);
                    while (true) {
                        if (max >= min) {
                            this.mCheckedIdStates.delete(keyAt);
                            i--;
                            this.mCheckedItemCount--;
                            ActionMode actionMode2 = this.mChoiceActionMode;
                            if (actionMode2 != null && (multiChoiceModeWrapper = this.mMultiChoiceModeCallback) != null) {
                                multiChoiceModeWrapper.onItemCheckedStateChanged(actionMode2, intValue, keyAt, false);
                            } else if (this.mInMultiChoiceState && (multiChoiceListener = this.mMultiChoiceListener) != null) {
                                multiChoiceListener.onItemCheckedStateChanged(intValue, keyAt, false);
                            }
                            z = true;
                        } else if (keyAt == adapter.getItemId(max)) {
                            this.mCheckStates.put(max, true);
                            this.mCheckedIdStates.setValueAt(i, Integer.valueOf(max));
                            break;
                        } else {
                            max++;
                        }
                    }
                } else {
                    this.mCheckStates.put(intValue, true);
                }
                i++;
            }
            if (z && (actionMode = this.mChoiceActionMode) != null) {
                actionMode.invalidate();
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.mDrawSelectorOnTop && !this.mEnableImmersive) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        syncDrawDecoration();
        int itemDecorationCount = getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            if (getItemDecorationAt(i) instanceof ItemDecoration) {
                ((ItemDecoration) getItemDecorationAt(i)).onDrawOverChildren(canvas, this, MzRecyclerViewHelper.getStateField(RecyclerView.class, this));
            }
        }
        onDrawForegroundInternal(canvas);
    }

    public void dispatchSetPressed(boolean z) {
    }

    public boolean dispatchStatusBarTap() {
        return onStatusBarTapScrollTop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r0 != 3) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r0 != 3) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.mEnableParallax
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L_0x0094
            float r0 = r8.getY()
            r7.mCurrentTouchPosition = r0
            int r0 = r8.getAction()
            if (r0 == 0) goto L_0x006b
            if (r0 == r3) goto L_0x005d
            if (r0 == r2) goto L_0x001b
            if (r0 == r1) goto L_0x005d
            goto L_0x0090
        L_0x001b:
            float r0 = r7.mMoveLength
            float r4 = INVALUE_VALUE
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0090
            boolean r0 = r7.canScrollVertically(r3)
            if (r0 == 0) goto L_0x003c
            float r0 = r7.mLastTouchPosition
            float r4 = r7.mCurrentTouchPosition
            float r5 = r0 - r4
            r6 = 1097859072(0x41700000, float:15.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x003c
            float r5 = r7.mMoveLength
            float r0 = r0 - r4
            float r5 = r5 + r0
            r7.mMoveLength = r5
            goto L_0x0055
        L_0x003c:
            r0 = -1
            boolean r0 = r7.canScrollVertically(r0)
            if (r0 == 0) goto L_0x0055
            float r0 = r7.mLastTouchPosition
            float r4 = r7.mCurrentTouchPosition
            float r5 = r0 - r4
            r6 = -1049624576(0xffffffffc1700000, float:-15.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0055
            float r5 = r7.mMoveLength
            float r0 = r0 - r4
            float r5 = r5 + r0
            r7.mMoveLength = r5
        L_0x0055:
            flyme.support.v7.widget.MzRecyclerView$ScrollItemManager r0 = r7.mScrollItemManager
            float r4 = r7.mMoveLength
            r0.translateItemY(r4)
            goto L_0x0090
        L_0x005d:
            float r0 = r7.mMoveLength
            float r4 = INVALUE_VALUE
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0090
            flyme.support.v7.widget.MzRecyclerView$ScrollItemManager r0 = r7.mScrollItemManager
            r0.startSmoothBackToOriginalPosition()
            goto L_0x0090
        L_0x006b:
            float r0 = r7.mCurrentTouchPosition
            r7.mLastTouchPosition = r0
            r0 = 0
            r7.mMoveLength = r0
            flyme.support.v7.widget.MzRecyclerView$ScrollItemManager r0 = r7.mScrollItemManager
            r0.cancleSmoothBackToOriginalPosition()
            flyme.support.v7.widget.MzRecyclerView$ScrollItemManager r0 = r7.mScrollItemManager
            boolean r0 = r0.isParallaxAnimationComplete()
            if (r0 == 0) goto L_0x0090
            flyme.support.v7.widget.MzRecyclerView$ScrollItemManager r0 = r7.mScrollItemManager
            r4 = 0
            r0.setParallaxAnimationComplete(r4)
            flyme.support.v7.widget.MzRecyclerView$ParallaxAnimationListener r0 = r7.mParallaxAnimationListener
            if (r0 == 0) goto L_0x0090
            java.util.HashSet r4 = r7.getViewHoldSet()
            r0.onAnimationStateChange(r3, r4)
        L_0x0090:
            float r0 = r7.mCurrentTouchPosition
            r7.mLastTouchPosition = r0
        L_0x0094:
            int r0 = r8.getAction()
            if (r0 == r3) goto L_0x00e9
            if (r0 == r2) goto L_0x009f
            if (r0 == r1) goto L_0x00e9
            goto L_0x00f6
        L_0x009f:
            int r0 = r7.mChoiceMode
            r1 = 4
            if (r0 == r1) goto L_0x00a7
            r1 = 5
            if (r0 != r1) goto L_0x00f6
        L_0x00a7:
            float r0 = r8.getY()
            int r0 = (int) r0
            float r1 = r8.getX()
            int r1 = (int) r1
            android.graphics.Rect r3 = r7.mCheckRegionRect
            int r4 = r7.mOverScrollModeBeforeDrag
            int r5 = NOT_SET_OVER_SCROLL_STATUS
            if (r4 != r5) goto L_0x00f6
            android.view.ActionMode r4 = r7.mChoiceActionMode
            if (r4 != 0) goto L_0x00c1
            boolean r4 = r7.mInMultiChoiceState
            if (r4 == 0) goto L_0x00f6
        L_0x00c1:
            boolean r4 = r7.mDragSelectionEnable
            if (r4 == 0) goto L_0x00f6
            boolean r4 = r7.mIsBeginDragSelect
            if (r4 != 0) goto L_0x00f6
            int r4 = r7.getScrollState()
            if (r4 != 0) goto L_0x00f6
            int r4 = r3.left
            if (r1 < r4) goto L_0x00f6
            int r4 = r3.right
            if (r1 > r4) goto L_0x00f6
            int r1 = r3.top
            if (r0 < r1) goto L_0x00f6
            int r1 = r3.bottom
            if (r0 > r1) goto L_0x00f6
            int r0 = r7.getOverScrollMode()
            r7.mOverScrollModeBeforeDrag = r0
            r7.setOverScrollMode(r2)
            goto L_0x00f6
        L_0x00e9:
            int r0 = r7.mOverScrollModeBeforeDrag
            int r1 = NOT_SET_OVER_SCROLL_STATUS
            if (r0 == r1) goto L_0x00f6
            r7.setOverScrollMode(r0)
            int r0 = NOT_SET_OVER_SCROLL_STATUS
            r7.mOverScrollModeBeforeDrag = r0
        L_0x00f6:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: int[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downSelect(int r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r1 = -1
            if (r10 != r1) goto L_0x0006
            r10 = r11
            goto L_0x0007
        L_0x0006:
            int r10 = r10 + r0
        L_0x0007:
            int[][] r2 = r9.mItemDragSelectStatus
            if (r2 == 0) goto L_0x0011
            int r3 = r2.length
            if (r11 >= r3) goto L_0x0011
            int r2 = r2.length
            if (r10 < r2) goto L_0x0014
        L_0x0011:
            r9.refreshSelectStatus()
        L_0x0014:
            int[][] r2 = r9.mItemDragSelectStatus
            if (r2 == 0) goto L_0x00b7
            int r3 = r2.length
            if (r11 >= r3) goto L_0x00b7
            int r2 = r2.length
            if (r10 < r2) goto L_0x0020
            goto L_0x00b7
        L_0x0020:
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r9.getAdapter()
            int r3 = r9.getFirstPosition()
        L_0x0028:
            if (r10 > r11) goto L_0x00b6
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r9.getAdapter()
            boolean r4 = r4 instanceof flyme.support.v7.widget.MzRecyclerView.MzRvAdapterBaseInterface
            if (r4 == 0) goto L_0x0047
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r9.getAdapter()
            flyme.support.v7.widget.MzRecyclerView$MzRvAdapterBaseInterface r4 = (flyme.support.v7.widget.MzRecyclerView.MzRvAdapterBaseInterface) r4
            boolean r4 = r4.isEnabled(r10)
            androidx.recyclerview.widget.RecyclerView$Adapter r5 = r9.getAdapter()
            flyme.support.v7.widget.MzRecyclerView$MzRvAdapterBaseInterface r5 = (flyme.support.v7.widget.MzRecyclerView.MzRvAdapterBaseInterface) r5
            boolean r5 = r5.isSelectable(r10)
            goto L_0x0049
        L_0x0047:
            r4 = r0
            r5 = r4
        L_0x0049:
            if (r5 == 0) goto L_0x00b0
            int r5 = r9.mLongPressPosition
            if (r10 != r5) goto L_0x0050
            return
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            if (r4 != 0) goto L_0x0055
            goto L_0x00b2
        L_0x0055:
            int r4 = r10 - r3
            android.view.View r4 = r9.getChildAtExt(r4)
            long r5 = r2.getItemId(r10)
            boolean r7 = r9.isItemChecked(r10)
            flyme.support.v7.widget.MzRecyclerView$OnDragSelectListener r8 = r9.mDragSelectListener
            if (r8 == 0) goto L_0x006b
            r8.onDragSelection(r4, r10, r5)
            goto L_0x00ac
        L_0x006b:
            int[][] r4 = r9.mItemDragSelectStatus
            r4 = r4[r10]
            r5 = 0
            r6 = r4[r5]
            if (r6 != 0) goto L_0x0076
            r4[r0] = r7
        L_0x0076:
            int r6 = r6 + 1
            r4[r5] = r6
            int r8 = r9.mFirstDragSelectStatus
            if (r8 != r1) goto L_0x008b
            boolean r6 = r9.mLongPressDrag
            if (r6 == 0) goto L_0x0084
            r6 = r7
            goto L_0x0086
        L_0x0084:
            r6 = r7 ^ 1
        L_0x0086:
            r9.mFirstDragSelectStatus = r6
            r4[r0] = r6
            goto L_0x009a
        L_0x008b:
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x0097
            r4 = r4[r0]
            if (r4 != r0) goto L_0x0095
        L_0x0093:
            r6 = r0
            goto L_0x009a
        L_0x0095:
            r6 = r5
            goto L_0x009a
        L_0x0097:
            if (r8 != r0) goto L_0x0095
            goto L_0x0093
        L_0x009a:
            if (r6 == r7) goto L_0x00ac
            r9.setItemChecked(r10, r6)
            flyme.support.v7.widget.FeedbackHandlerThread r4 = r9.mFeedbackHandlerThread
            boolean r6 = r9.hasFlymeFeature()
            if (r6 == 0) goto L_0x00a9
            r5 = 31016(0x7928, float:4.3463E-41)
        L_0x00a9:
            r4.sendPerformHapticFeedbackMessage(r9, r5)
        L_0x00ac:
            r9.mLastDownSelectPosition = r10
            r9.mLastUpSelectPosition = r1
        L_0x00b0:
            r9.mLongPressPosition = r1
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0028
        L_0x00b6:
            return
        L_0x00b7:
            java.lang.String r9 = "MzRecyclerView"
            java.lang.String r10 = "downSelect error mItemDragSelectStatus len < start or end"
            android.util.Log.e(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzRecyclerView.downSelect(int, int):void");
    }

    public void drawSelector(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    public void ensureCheckRegion(boolean z) {
        if (this.mCheckRegionRect == null) {
            Rect rect = new Rect();
            this.mCheckRegionRect = rect;
            rect.setEmpty();
        }
        int i = this.mChoiceMode;
        if (i != 4 && i != 5) {
            this.mCheckRegionRect.setEmpty();
        } else if (!this.mCheckRegionRect.isEmpty() && !z) {
        } else {
            if (getLayoutDirection() == 1) {
                this.mCheckRegionRect.left = getPaddingLeft();
                Rect rect2 = this.mCheckRegionRect;
                rect2.right = rect2.left + this.mCheckWidth;
                rect2.top = getPaddingTop();
                this.mCheckRegionRect.bottom = getHeight() - getPaddingBottom();
                return;
            }
            this.mCheckRegionRect.right = getWidth() - getPaddingRight();
            Rect rect3 = this.mCheckRegionRect;
            rect3.left = rect3.right - this.mCheckWidth;
            rect3.top = getPaddingTop();
            this.mCheckRegionRect.bottom = getHeight() - getPaddingBottom();
        }
    }

    public int findCandidateScrollSelection(boolean z) {
        int childCountExt = getChildCountExt();
        int firstPosition = getFirstPosition();
        if (z) {
            for (int i = 0; i < childCountExt; i++) {
                View childAtExt = getChildAtExt(i);
                if (getDecoratedBottom(childAtExt) - (getDecoratedMeasuredHeight(childAtExt) / 2) > getPaddingTop()) {
                    return firstPosition + i;
                }
            }
            return -1;
        }
        for (int i2 = childCountExt - 1; i2 >= 0; i2--) {
            View childAtExt2 = getChildAtExt(i2);
            if (getDecoratedTop(childAtExt2) + (getDecoratedMeasuredHeight(childAtExt2) / 2) < getHeight() - getPaddingBottom()) {
                return firstPosition + i2;
            }
        }
        return -1;
    }

    public void finishMultiChoice() {
        ActionMode actionMode = this.mChoiceActionMode;
        if (actionMode != null) {
            actionMode.finish();
        } else if (this.mInMultiChoiceState) {
            this.mMultiChoiceListener.onFinishMultiChoice();
            this.mInMultiChoiceState = false;
            clearChoices();
            updateOnScreenCheckedViews();
            setLongClickable(true);
            MzRecyclerViewHelper.invokeRvRecyclerVClear(RecyclerView.class, this);
            getRecycledViewPool().clear();
        }
    }

    public boolean fling(int i, int i2) {
        this.mSpringAnimationHelper.fling(i, i2);
        return super.fling(i, i2);
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        if (this.mChoiceMode == 0 || this.mCheckedIdStates == null || getAdapter() == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public View getChildAtExt(int i) {
        return getLayoutManager().getChildAt(i);
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    public int getCount() {
        return getAdapter().getItemCount();
    }

    public int getDecoratedBottom(View view) {
        return getLayoutManager().getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int getDecoratedMeasuredHeight(View view) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return layoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int getDecoratedTop(View view) {
        return getLayoutManager().getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int getFirstPosition() {
        View childAtExt = getChildAtExt(0);
        if (childAtExt == null) {
            return -1;
        }
        return getChildPositionExt(childAtExt);
    }

    public int getFooterViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
            return 0;
        }
        return ((HeaderAndFooterWrapperAdapter) getAdapter()).getFootersCount();
    }

    public int getHeaderViewsCount() {
        if (getAdapter() == null || !(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
            return 0;
        }
        return ((HeaderAndFooterWrapperAdapter) getAdapter()).getHeadersCount();
    }

    public int getLastPosition() {
        View childAtExt = getChildAtExt(getChildCountExt() - 1);
        if (childAtExt == null) {
            return -1;
        }
        return getChildPositionExt(childAtExt);
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return getFirstPosition() + i;
            }
        }
        return -1;
    }

    public SpringAnimationHelper getSpringAnimationHelper() {
        return this.mSpringAnimationHelper;
    }

    public HashSet getViewHoldSet() {
        return this.mViewHolderHashSet;
    }

    public void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isBottomOverScrollEnable() {
        return this.mSpringAnimationHelper.isBottomOverScrollEnable();
    }

    public boolean isEndOverScrollEnable() {
        return this.mSpringAnimationHelper.isEndOverScrollEnable();
    }

    public Boolean isInMutiChoiceState() {
        return Boolean.valueOf(this.mChoiceActionMode != null || this.mInMultiChoiceState);
    }

    public boolean isItemChecked(int i) {
        SparseBooleanArray sparseBooleanArray;
        if (this.mChoiceMode == 0 || (sparseBooleanArray = this.mCheckStates) == null) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    public boolean isOverScrollEnable() {
        return this.mSpringAnimationHelper.isOverScrollEnable();
    }

    public boolean isScrollUpByItemCoveredInMultiChoiceEnable() {
        return this.mScrollUpWhenItemCoveredInMultiChoiceEnable;
    }

    public boolean isStartOverScrollEnable() {
        return this.mSpringAnimationHelper.isStartOverScrollEnable();
    }

    public boolean isTopOverScrollEnable() {
        return this.mSpringAnimationHelper.isTopOverScrollEnable();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public boolean mzIsHeaderOrFooter(int i) {
        return i >= 0 && (i < getHeaderViewsCount() || i >= getItemCount() - getFooterViewsCount());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (findRecyclerViewParent((ViewGroup) getParent())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.mSpringAnimationHelper.onInterceptTouchEvent(motionEvent);
        if (!((getTranslationX() == 0.0f && getTranslationY() == 0.0f) || (parent = getParent()) == null || !this.mShouldRequestDisallow)) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        onLayoutExt();
        RecyclerView.State stateField = MzRecyclerViewHelper.getStateField(RecyclerView.class, this);
        if (MzRecyclerViewHelper.getRvStateStepField(RecyclerView.State.class, stateField) == 1 && stateField.didStructureChange()) {
            confirmCheckedPositionsById();
            updateHoldView();
            setPressed(false);
            Drawable drawable = this.mSelector;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        super.onMeasure(i, i2);
    }

    public void onScrolled(int i, int i2) {
        ParallaxAnimationListener parallaxAnimationListener;
        if (this.mEnableParallax && !this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
            parallaxAnimationListener.onRunning(2, i, i2, getViewHoldSet());
        }
        super.onScrolled(i, i2);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ensureCheckRegion(true);
    }

    public boolean onStatusBarTapScrollTop() {
        View childAt;
        if (getItemCount() == 0 || this.mSpringAnimationHelper.isOverScrollDynamic()) {
            return false;
        }
        int firstPosition = getFirstPosition();
        if ((firstPosition == 0 && (childAt = getChildAt(0)) != null && childAt.getTop() >= getPaddingTop()) || getItemCount() == Integer.MAX_VALUE) {
            return false;
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.endFling();
            this.mFlingRunnable = null;
        }
        if (firstPosition > getChildCount() * 2) {
            scrollToPosition(getChildCount() * 2);
        }
        smoothScrollToPosition(0);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RecyclerPinnedHeaderDecoration recyclerPinnedHeaderDecoration = this.mRecyclerPinnedHeaderDecoration;
        if (recyclerPinnedHeaderDecoration != null && -1 != recyclerPinnedHeaderDecoration.findHeaderPositionUnder((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        checkDuringTouch(motionEvent);
        if (isPressed() && this.mSpringAnimationHelper.isOverScrollDynamic()) {
            setPressed(false);
        }
        if (!(!handleDragCheckRegion()) || !this.mSpringAnimationHelper.onTouchEvent(motionEvent)) {
            boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                this.mLongPressDrag = false;
            }
            if (!onTouchEvent && !this.mIsBeginDragSelect) {
                return super.onTouchEvent(motionEvent);
            }
            if (onTouchEvent && action == 0) {
                boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
                if (getLayoutManager().canScrollVertically()) {
                    canScrollHorizontally |= true;
                }
                startNestedScroll(canScrollHorizontally ? 1 : 0);
            }
            return true;
        }
        ViewParent parent = getParent();
        if (parent != null && this.mShouldRequestDisallow) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        HoldView holdView;
        View view;
        super.onWindowFocusChanged(z);
        if (z && this.mEnableHoldPress && (holdView = this.mHoldView) != null && (view = holdView.view) != null) {
            if (this.mShowPressed) {
                view.setHovered(true);
                this.mShowPressed = false;
            }
            this.mHoldView.view.setHovered(false);
            HoldView holdView2 = this.mHoldView;
            holdView2.view = null;
            holdView2.id = -1;
            holdView2.position = -1;
        }
    }

    public void positionSelector(int i, View view) {
        boolean z = i != this.mSelectorPosition;
        if (i != -1) {
            this.mSelectorPosition = i;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof SelectionBoundsAdjuster) {
            ((SelectionBoundsAdjuster) view).adjustListItemSelectionBounds(rect);
        }
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            drawable.setBounds(rect);
            if (z) {
                if (getVisibility() == 0) {
                    drawable.setVisible(true, false);
                }
                updateSelectorState();
            }
        }
        refreshDrawableState();
    }

    public void recycleScrollItem(RecyclerView.ViewHolder viewHolder) {
        ScrollItemManager scrollItemManager;
        ParallaxAnimationListener parallaxAnimationListener;
        if (this.mEnableParallax && (scrollItemManager = this.mScrollItemManager) != null) {
            Iterator<ScrollItem> it = scrollItemManager.getScrollItemHashMap().values().iterator();
            while (it.hasNext()) {
                ScrollItem next = it.next();
                if (viewHolder.equals(next.getViewHolder())) {
                    next.translateItemY(0.0f);
                    next.setOriginalTransilationY(INVALUE_VALUE);
                    next.reset();
                    this.mScrollItemManager.addScrollItemToCache(next);
                    it.remove();
                }
            }
            if (this.mViewHolderHashSet.contains(viewHolder)) {
                this.mViewHolderHashSet.remove(viewHolder);
                if (!this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
                    parallaxAnimationListener.onRecycleViewHolderWhenAnimation(viewHolder);
                }
            }
        }
    }

    public boolean removeFooterView(RecyclerView.ViewHolder viewHolder) {
        if (getAdapter() == null || !(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
            return false;
        }
        boolean removeFooterView = ((HeaderAndFooterWrapperAdapter) getAdapter()).removeFooterView(removeFixedViewInfo(viewHolder, this.mFooterViewInfos));
        if (!removeFooterView) {
            return removeFooterView;
        }
        ((HeaderAndFooterWrapperAdapter) getAdapter()).getWrappedAdapter().notifyDataSetChanged();
        return removeFooterView;
    }

    public boolean removeHeaderView(RecyclerView.ViewHolder viewHolder) {
        if (getAdapter() == null || !(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
            return false;
        }
        boolean removeHeaderView = ((HeaderAndFooterWrapperAdapter) getAdapter()).removeHeaderView(removeFixedViewInfo(viewHolder, this.mHeaderViewInfos));
        if (!removeHeaderView) {
            return removeHeaderView;
        }
        ((HeaderAndFooterWrapperAdapter) getAdapter()).getWrappedAdapter().notifyDataSetChanged();
        return removeHeaderView;
    }

    public void removeOverScrollListener(@NonNull OverScrollListener overScrollListener) {
        this.mSpringAnimationHelper.removeOverScrollListener(overScrollListener);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof MzRvAdapterBaseInterface)) {
            Log.i(TAG, "you should use MzRecyclerView.Adapter！！！ Otherwise, it may cause problems");
        }
        if (adapter != null && (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0)) {
            if (!(adapter instanceof HeaderAndFooterWrapperAdapter)) {
                adapter = new HeaderAndFooterWrapperAdapter(adapter);
            }
            HeaderAndFooterWrapperAdapter headerAndFooterWrapperAdapter = (HeaderAndFooterWrapperAdapter) adapter;
            Iterator<FixedViewInfo> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                headerAndFooterWrapperAdapter.addHeaderView(it.next());
            }
            Iterator<FixedViewInfo> it2 = this.mFooterViewInfos.iterator();
            while (it2.hasNext()) {
                headerAndFooterWrapperAdapter.addFooterView(it2.next());
            }
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            boolean hasStableIds = getAdapter().hasStableIds();
            if (this.mChoiceMode != 0 && hasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        clearChoices();
    }

    public void setBaseDuration(int i) {
        ScrollItemManager scrollItemManager = this.mScrollItemManager;
        if (scrollItemManager != null) {
            scrollItemManager.setBaseDuration(i);
        }
    }

    public void setBottomOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setBottomOverScrollEnable(z);
    }

    public void setCheckBoxIsAnimation(boolean z) {
        if (this.mIsCheckBoxAnim != z) {
            this.mIsCheckBoxAnim = z;
        }
    }

    public void setChoiceMode(int i) {
        this.mChoiceMode = i;
        ActionMode actionMode = this.mChoiceActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mChoiceActionMode = null;
        } else if (this.mInMultiChoiceState) {
            this.mMultiChoiceListener.onFinishMultiChoice();
            this.mInMultiChoiceState = false;
            clearChoices();
            updateOnScreenCheckedViews();
            setLongClickable(true);
            MzRecyclerViewHelper.invokeRvRecyclerVClear(RecyclerView.class, this);
            getRecycledViewPool().clear();
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseBooleanArray(0);
            }
            RecyclerView.Adapter adapter = getAdapter();
            if (this.mCheckedIdStates == null && adapter != null && adapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>(0);
            }
            if (this.mChoiceMode == 4) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setDrawDuringWindowsAnimating(View view, boolean z) {
        try {
            Object invoke = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null).invoke(view, (Object[]) null);
            Method declaredMethod = invoke.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setEnableDragSelection(boolean z) {
        this.mDragSelectionEnable = z;
    }

    public void setEnableHoldPress(boolean z) {
        this.mEnableHoldPress = z;
    }

    public void setEnableParallax(boolean z) {
        if (z) {
            if (this.mScrollItemManager == null) {
                this.mScrollItemManager = new ScrollItemManager();
            }
            if (this.mViewHolderHashSet == null) {
                this.mViewHolderHashSet = new HashSet<>();
            }
        }
        this.mEnableParallax = z;
    }

    public void setEndOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setEndOverScrollEnable(z);
    }

    @SuppressLint({"NewApi"})
    public void setImmersiveItemBackground(View view, int i) {
        if (this.mEnableImmersive) {
            if (i == 0) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_head"));
            } else if (i == 1) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_middle"));
            } else if (i == 2) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_foot"));
            } else if (i == 3) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_alone"));
            } else if (i == 5) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_head_related_setting"));
            } else if (i == 6) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_middle_related_setting"));
            } else if (i == 7) {
                view.setBackground(getImmersiveResById("immersive_item_bkg_foot_related_setting"));
            } else {
                view.setBackground(getContext().getDrawable(R.drawable.immmersive_item_bkg_title));
            }
        }
    }

    public void setImmersiveListEnable() {
        this.mEnableImmersive = true;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.mChoiceMode != 0) {
            RecyclerView.Adapter adapter = getAdapter();
            if (z && this.mChoiceMode == 4 && this.mChoiceActionMode == null) {
                MultiChoiceListener multiChoiceListener = this.mMultiChoiceListener;
                if (multiChoiceListener == null) {
                    MultiChoiceModeWrapper multiChoiceModeWrapper = this.mMultiChoiceModeCallback;
                    if (multiChoiceModeWrapper == null || !multiChoiceModeWrapper.hasWrappedCallback()) {
                        throw new IllegalStateException("RecyclerView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                    }
                    this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
                } else {
                    multiChoiceListener.onEnterMultiChoice();
                    this.mInMultiChoiceState = true;
                }
            }
            int i2 = this.mChoiceMode;
            if (i2 == 4 || i2 == 5) {
                boolean z2 = this.mCheckStates.get(i);
                this.mCheckStates.put(i, z);
                if (this.mCheckedIdStates != null && adapter.hasStableIds()) {
                    if (z) {
                        this.mCheckedIdStates.put(adapter.getItemId(i), Integer.valueOf(i));
                    } else {
                        this.mCheckedIdStates.delete(adapter.getItemId(i));
                    }
                }
                if (z2 != z) {
                    if (z) {
                        this.mCheckedItemCount++;
                    } else {
                        this.mCheckedItemCount--;
                    }
                }
                if (this.mChoiceActionMode != null) {
                    this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, i, adapter.getItemId(i), z);
                } else if (this.mInMultiChoiceState && this.mMultiChoiceListener != null) {
                    this.mMultiChoiceListener.onItemCheckedStateChanged(i, adapter.getItemId(i), z);
                }
            } else {
                boolean z3 = this.mCheckedIdStates != null && adapter.hasStableIds();
                if (z || isItemChecked(i)) {
                    this.mCheckStates.clear();
                    if (z3) {
                        this.mCheckedIdStates.clear();
                    }
                }
                if (z) {
                    this.mCheckStates.put(i, true);
                    if (z3) {
                        this.mCheckedIdStates.put(adapter.getItemId(i), Integer.valueOf(i));
                    }
                    this.mCheckedItemCount = 1;
                } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0)) {
                    this.mCheckedItemCount = 0;
                }
            }
            updateOnScreenCheckedViews();
        }
    }

    public void setItenFilter(ItemFilter itemFilter) {
        this.mItemFilter = itemFilter;
    }

    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        SpringAnimationHelper springAnimationHelper = this.mSpringAnimationHelper;
        if (springAnimationHelper != null && layoutManager != null) {
            springAnimationHelper.setLayoutDirection(layoutManager.canScrollVertically() ? 1 : 0);
        }
    }

    public void setMultiChoiceListener(MultiChoiceListener multiChoiceListener) {
        this.mMultiChoiceListener = multiChoiceListener;
    }

    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (this.mMultiChoiceModeCallback == null) {
            this.mMultiChoiceModeCallback = new MultiChoiceModeWrapper();
        }
        this.mMultiChoiceModeCallback.setWrapped(multiChoiceModeListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOverScrollEnable(boolean z) {
        this.mIsUserEnableOverScroll = z;
        this.mSpringAnimationHelper.setOverScrollEnable(z);
    }

    public void setParallaxAnimationListener(ParallaxAnimationListener parallaxAnimationListener) {
        this.mParallaxAnimationListener = parallaxAnimationListener;
    }

    public void setPinnedHeaderDecoration(RecyclerPinnedHeaderDecoration recyclerPinnedHeaderDecoration) {
        this.mRecyclerPinnedHeaderDecoration = recyclerPinnedHeaderDecoration;
    }

    public void setPressStateDuration(int i) {
        this.mPressStateDuration = i;
    }

    @Deprecated
    public void setRequestLayoutWhenSwitchActionMode(boolean z) {
        this.mRequestLayoutWhenSwitchActionMode = z;
    }

    public void setScrollSensitivity(int i) {
        ScrollItemManager scrollItemManager = this.mScrollItemManager;
        if (scrollItemManager != null) {
            scrollItemManager.setSensitivity(i);
        }
    }

    public void setScrollUpByItemCoveredInMultiChoiceEnable(boolean z) {
        this.mScrollUpWhenItemCoveredInMultiChoiceEnable = z;
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z) {
        this.mShouldRequestDisallow = z;
    }

    public void setSmoothBackInterpolator(TimeInterpolator timeInterpolator) {
        ScrollItemManager scrollItemManager;
        if (timeInterpolator != null && (scrollItemManager = this.mScrollItemManager) != null) {
            scrollItemManager.setSmoothBackInterpolator(timeInterpolator);
        }
    }

    public void setStartOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setStartOverScrollEnable(z);
    }

    public void setTopOverScrollEnable(boolean z) {
        this.mSpringAnimationHelper.setTopOverScrollEnable(z);
    }

    public void setViewChecked(View view, int i) {
        SparseBooleanArray sparseBooleanArray;
        View findViewById;
        if (view != null && this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null) {
            boolean z = sparseBooleanArray.get(i);
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(z);
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                int i2 = this.mChoiceMode;
                if ((i2 == 4 || i2 == 5) && (findViewById = view.findViewById(16908289)) != null && (findViewById instanceof Checkable)) {
                    ((Checkable) findViewById).setChecked(this.mChoiceActionMode != null || this.mInMultiChoiceState);
                }
                view.setActivated(z);
            }
        }
    }

    public boolean shouldShowSelector() {
        return (isFocused() && !isInTouchMode()) || isPressed();
    }

    public boolean startMultiChoice() {
        int i = this.mChoiceMode;
        if (i == 5 || i == 4) {
            if (this.mChoiceActionMode == null && this.mMultiChoiceListener == null) {
                ActionMode startActionMode = startActionMode(this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                this.mCheckWidth = this.mDefaultCheckWidth;
                if (startActionMode == null) {
                    return false;
                }
                notifyPossibleUpdate();
                return true;
            }
            MultiChoiceListener multiChoiceListener = this.mMultiChoiceListener;
            if (multiChoiceListener != null) {
                multiChoiceListener.onEnterMultiChoice();
                this.mInMultiChoiceState = true;
                notifyPossibleUpdate();
                return true;
            }
        }
        return false;
    }

    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            if (!(adapter instanceof HeaderAndFooterWrapperAdapter)) {
                adapter = new HeaderAndFooterWrapperAdapter(adapter);
            }
            HeaderAndFooterWrapperAdapter headerAndFooterWrapperAdapter = (HeaderAndFooterWrapperAdapter) adapter;
            Iterator<FixedViewInfo> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                headerAndFooterWrapperAdapter.addHeaderView(it.next());
            }
            Iterator<FixedViewInfo> it2 = this.mFooterViewInfos.iterator();
            while (it2.hasNext()) {
                headerAndFooterWrapperAdapter.addFooterView(it2.next());
            }
        }
        super.swapAdapter(adapter, z);
        if (adapter != null) {
            boolean hasStableIds = getAdapter().hasStableIds();
            if (this.mChoiceMode != 0 && hasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        clearChoices();
    }

    public void unCheckedAll() {
        clearChoices();
        notifyPossibleUpdate();
    }

    public void upSelect(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        RecyclerView.Adapter adapter = getAdapter();
        int firstPosition = getFirstPosition();
        for (int i3 = i == -1 ? i2 : i - 1; i3 >= i2; i3--) {
            boolean z4 = true;
            if (getAdapter() instanceof MzRvAdapterBaseInterface) {
                z2 = ((MzRvAdapterBaseInterface) getAdapter()).isEnabled(i3);
                z = ((MzRvAdapterBaseInterface) getAdapter()).isSelectable(i3);
            } else {
                z2 = true;
                z = true;
            }
            if (z) {
                if (i3 != this.mLongPressPosition) {
                    if (getAdapter() == null || z2) {
                        View childAtExt = getChildAtExt(i3 - firstPosition);
                        long itemId = adapter.getItemId(i3);
                        int isItemChecked = isItemChecked(i3);
                        OnDragSelectListener onDragSelectListener = this.mDragSelectListener;
                        if (onDragSelectListener != null) {
                            onDragSelectListener.onDragSelection(childAtExt, i3, itemId);
                        } else {
                            int[] iArr = this.mItemDragSelectStatus[i3];
                            int i4 = 0;
                            int i5 = iArr[0];
                            if (i5 == 0) {
                                iArr[1] = isItemChecked;
                            }
                            int i6 = i5 + 1;
                            iArr[0] = i6;
                            int i7 = this.mFirstDragSelectStatus;
                            if (i7 == -1) {
                                int i8 = this.mLongPressDrag ? isItemChecked : isItemChecked ^ 1;
                                this.mFirstDragSelectStatus = i8;
                                iArr[1] = i8;
                                z3 = i8;
                            } else {
                                if (i6 % 2 == 0) {
                                }
                                z4 = false;
                                z3 = z4;
                            }
                            if (z3 != isItemChecked) {
                                setItemChecked(i3, z3);
                                FeedbackHandlerThread feedbackHandlerThread = this.mFeedbackHandlerThread;
                                if (hasFlymeFeature()) {
                                    i4 = 31016;
                                }
                                feedbackHandlerThread.sendPerformHapticFeedbackMessage(this, i4);
                            }
                        }
                        this.mLastUpSelectPosition = i3;
                        this.mLastDownSelectPosition = -1;
                    }
                } else {
                    return;
                }
            }
            this.mLongPressPosition = -1;
        }
    }

    public void updateSelectorState() {
        if (this.mSelector == null) {
            return;
        }
        if (shouldShowSelector()) {
            this.mSelector.setState(getDrawableState());
        } else {
            this.mSelector.setState(StateSet.NOTHING);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }

    public MzRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public void notifyPossibleUpdate(final boolean z) {
        if (!mAvoidNotifyItemRangeChanged) {
            post(new Runnable() {
                public void run() {
                    RecyclerView.Adapter adapter = MzRecyclerView.this.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemRangeChanged(0, MzRecyclerView.this.getItemCount());
                        final RecyclerView.ItemAnimator itemAnimator = MzRecyclerView.this.getItemAnimator();
                        if (itemAnimator != null) {
                            MzRecyclerView.this.post(new Runnable() {
                                public void run() {
                                    itemAnimator.endAnimations();
                                }
                            });
                        }
                        if (z) {
                            MzRecyclerView.this.requestLayout();
                        }
                    }
                }
            });
        }
    }

    public void addAnimateView(View view, RecyclerView.ViewHolder viewHolder, float f, float f2) {
        ParallaxAnimationListener parallaxAnimationListener;
        if (view != null && this.mScrollItemManager != null) {
            if (!this.mViewHolderHashSet.contains(viewHolder)) {
                this.mViewHolderHashSet.add(viewHolder);
                if (!this.mScrollItemManager.isParallaxAnimationComplete() && (parallaxAnimationListener = this.mParallaxAnimationListener) != null) {
                    parallaxAnimationListener.onAddViewHolderWhenAnimation(viewHolder);
                }
            }
            this.mScrollItemManager.addScrollItem(view, viewHolder, f2 / 50.0f, f / -50.0f);
        }
    }

    @Deprecated
    public void addFooterView(RecyclerView.ViewHolder viewHolder, boolean z) {
        if (viewHolder != null) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            fixedViewInfo.viewHolder = viewHolder;
            fixedViewInfo.isSelectable = z;
            this.mFooterViewInfos.add(fixedViewInfo);
            if (getAdapter() != null) {
                if (!(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
                    Class<RecyclerView> cls = RecyclerView.class;
                    RecyclerView.AdapterDataObserver recyclerViewDataObserver = MzRecyclerViewHelper.getRecyclerViewDataObserver(cls, this);
                    getAdapter().unregisterAdapterDataObserver(recyclerViewDataObserver);
                    MzRecyclerViewHelper.setInnerAdapterAsHeadAndFootAdapter(cls, this, new HeaderAndFooterWrapperAdapter(getAdapter()));
                    getAdapter().registerAdapterDataObserver(recyclerViewDataObserver);
                    ((HeaderAndFooterWrapperAdapter) getAdapter()).setHeaderAndFooterSpanForGridLayoutManager(this);
                }
                ((HeaderAndFooterWrapperAdapter) getAdapter()).addFooterView(fixedViewInfo);
                ((HeaderAndFooterWrapperAdapter) getAdapter()).getWrappedAdapter().notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the viewHolder to add must not be null!");
    }

    @Deprecated
    public void addHeaderView(RecyclerView.ViewHolder viewHolder, boolean z) {
        if (viewHolder != null) {
            FixedViewInfo fixedViewInfo = new FixedViewInfo();
            fixedViewInfo.viewHolder = viewHolder;
            fixedViewInfo.isSelectable = z;
            this.mHeaderViewInfos.add(fixedViewInfo);
            if (getAdapter() != null) {
                if (!(getAdapter() instanceof HeaderAndFooterWrapperAdapter)) {
                    Class<RecyclerView> cls = RecyclerView.class;
                    RecyclerView.AdapterDataObserver recyclerViewDataObserver = MzRecyclerViewHelper.getRecyclerViewDataObserver(cls, this);
                    getAdapter().unregisterAdapterDataObserver(recyclerViewDataObserver);
                    MzRecyclerViewHelper.setInnerAdapterAsHeadAndFootAdapter(cls, this, new HeaderAndFooterWrapperAdapter(getAdapter()));
                    getAdapter().registerAdapterDataObserver(recyclerViewDataObserver);
                    ((HeaderAndFooterWrapperAdapter) getAdapter()).setHeaderAndFooterSpanForGridLayoutManager(this);
                }
                ((HeaderAndFooterWrapperAdapter) getAdapter()).addHeaderView(fixedViewInfo);
                ((HeaderAndFooterWrapperAdapter) getAdapter()).getWrappedAdapter().notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the viewHolder to add must not be null!");
    }

    public void setEnableDragSelection(OnDragSelectListener onDragSelectListener) {
        setEnableDragSelection(true);
        this.mDragSelectListener = onDragSelectListener;
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.mSelector;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public MzRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchMode = -1;
        this.mChoiceMode = 0;
        this.mRequestLayoutWhenSwitchActionMode = false;
        this.mItemFilter = null;
        this.mMultiChoiceDelayRunnable = null;
        this.mIsCheckBoxAnim = true;
        this.mDrawSelectorOnTop = false;
        this.mSelectorRect = new Rect();
        this.mSelectorPosition = -1;
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mScrollbarPaddingMethod = null;
        this.mEnableHoldPress = false;
        this.mShowPressed = false;
        this.mEnableParallax = false;
        this.mMoveLength = INVALUE_VALUE;
        this.mInMultiChoiceState = false;
        this.mFirstDragSelectStatus = -1;
        this.mOverScrollModeBeforeDrag = NOT_SET_OVER_SCROLL_STATUS;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mScrollUpWhenItemCoveredInMultiChoiceEnable = true;
        this.mIsUserEnableOverScroll = true;
        this.mHasCallFinishActionMode = false;
        this.mShouldRequestDisallow = false;
        this.mPressStateDuration = ViewConfiguration.getPressedStateDuration();
        this.isSony = false;
        this.mEnableImmersive = false;
        initRecyclerView();
        this.mGestureDetector = new ItemGestureDetector(context, new ItemGestureListener());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MzRecyclerView, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.MzRecyclerView_listSelectors);
        if (drawable != null) {
            setSelector(drawable);
        }
        obtainStyledAttributes.recycle();
        setOverScrollMode(2);
        OverScroller overScroller = new OverScroller(context, MzRecyclerViewHelper.getsQuinticInterpolator(RecyclerView.class, this));
        this.mOverScroller = overScroller;
        this.mSpringAnimationHelper = new SpringAnimationHelper(context, this, overScroller);
        initSpringAnimationHelper();
        this.mFeedbackHandlerThread = FeedbackHandlerThread.getInstance();
        if (TextUtils.equals(Build.BRAND, "Sony")) {
            this.isSony = true;
        }
    }

    public class ScrollItem {
        private float mCurrentOffset;
        private float mDownScrollOffsetRatio = 1.0f;
        private float mDownThreshold = 50.0f;
        private float mOffsetAfterSmoothBack;
        private float mOffsetBeforeSmoothBack;
        private float mOriginalTransilationY = MzRecyclerView.INVALUE_VALUE;
        private View mTranslateView;
        private float mUpScrollOffsetRatio = 1.0f;
        private float mUpThreshold = -50.0f;
        private RecyclerView.ViewHolder mViewHolder;

        public ScrollItem() {
        }

        public float getCurrentOffset() {
            return this.mCurrentOffset;
        }

        public float getDownScrollOffsetRatio() {
            return this.mDownScrollOffsetRatio;
        }

        public float getDownThreshold() {
            return this.mDownThreshold;
        }

        public float getOffsetAfterSmoothBack() {
            return this.mOffsetAfterSmoothBack;
        }

        public float getOffsetBeforeSmoothBack() {
            return this.mOffsetBeforeSmoothBack;
        }

        public View getTranslateView() {
            return this.mTranslateView;
        }

        public float getUpScrollOffsetRatio() {
            return this.mUpScrollOffsetRatio;
        }

        public float getUpThreshold() {
            return this.mUpThreshold;
        }

        public RecyclerView.ViewHolder getViewHolder() {
            return this.mViewHolder;
        }

        public void reset() {
            this.mTranslateView = null;
            this.mViewHolder = null;
            this.mUpScrollOffsetRatio = 1.0f;
            this.mDownScrollOffsetRatio = 1.0f;
            this.mDownThreshold = 50.0f;
            this.mUpThreshold = -50.0f;
            this.mOriginalTransilationY = MzRecyclerView.INVALUE_VALUE;
            this.mCurrentOffset = 0.0f;
        }

        public void setOffsetAfterSmoothBack(float f) {
            this.mOffsetAfterSmoothBack = f;
        }

        public void setOffsetBeforeSmoothBack(float f) {
            this.mOffsetBeforeSmoothBack = f;
        }

        public void setOriginalTransilationY(float f) {
            this.mOriginalTransilationY = f;
        }

        public void setScrollOffsetRatio(float f, float f2) {
            this.mUpScrollOffsetRatio = f2;
            this.mDownScrollOffsetRatio = f;
            this.mDownThreshold = f * 50.0f;
            this.mUpThreshold = f2 * -50.0f;
        }

        public void setTranslateView(View view) {
            this.mTranslateView = view;
        }

        public void setViewHolder(RecyclerView.ViewHolder viewHolder) {
            this.mViewHolder = viewHolder;
        }

        public void translateItemY(float f) {
            if (this.mTranslateView != null) {
                if (this.mOriginalTransilationY == MzRecyclerView.INVALUE_VALUE) {
                    this.mOriginalTransilationY = this.mTranslateView.getTranslationY();
                }
                this.mCurrentOffset = f;
                View view = this.mTranslateView;
                if (view instanceof ScrollView) {
                    view.scrollBy(0, (int) f);
                } else {
                    view.setTranslationY(this.mOriginalTransilationY + f);
                }
            }
        }

        public ScrollItem(View view, float f, float f2) {
            this.mTranslateView = view;
            this.mDownScrollOffsetRatio = f;
            this.mUpScrollOffsetRatio = f2;
            this.mDownThreshold = f * 50.0f;
            this.mUpThreshold = f2 * -50.0f;
        }
    }
}
