package flyme.support.v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecyclerViewItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_DURATION = 200;
    private static float DEFAULT_SCALE = 0.94f;
    private static final int ITEM_MOVE_DELAY = 50;
    private static final int ITEM_MOVE_DURATION = 350;
    private static final int LISTENER_TAG_ID = -1912602624;
    private static TimeInterpolator sDefaultInterpolator;
    private static final Interpolator sItemAddedInterpolator = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator sItemMoveInterpolator = new PathInterpolator(0.1f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator sItemRemovedInterpolator = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    /* access modifiers changed from: private */
    public ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<AddInfo>> mAdditionsList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    private int mDuration = 200;
    /* access modifiers changed from: private */
    public ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    private ArrayList<AddInfo> mPendingAdditions = new ArrayList<>();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<RemoveInfo> mPendingRemovals = new ArrayList<>();
    private final RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    private float mScale = DEFAULT_SCALE;

    public static class AddInfo {
        public int deltaY;
        public RecyclerView.ViewHolder holder;
        public int layoutPosition;

        private AddInfo(RecyclerView.ViewHolder viewHolder, int i) {
            this.holder = viewHolder;
            this.layoutPosition = i;
        }
    }

    public static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    public static class MoveInfo {
        public int fromBottom;
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int layoutPosition;
        public int toX;
        public int toY;

        private MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4, int i5, int i6) {
            this.holder = viewHolder;
            this.layoutPosition = i;
            this.fromX = i2;
            this.fromY = i3;
            this.toX = i4;
            this.toY = i5;
            this.fromBottom = i6;
        }
    }

    public static class RemoveInfo {
        public int deltaY;
        public RecyclerView.ViewHolder holder;

        private RemoveInfo(RecyclerView.ViewHolder viewHolder, int i) {
            this.holder = viewHolder;
            this.deltaY = i;
        }
    }

    public static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        private VpaListenerAdapter() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    public RecyclerViewItemAnimator(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    /* access modifiers changed from: private */
    public void animateAddImpl(final AddInfo addInfo) {
        View view = addInfo.holder.itemView;
        final ViewPropertyAnimatorCompat e = ViewCompat.e(view);
        AnonymousClass5 r2 = new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewCompat.y0(view, 1.0f);
                ViewCompat.U0(view, 1.0f);
                ViewCompat.T0(view, 1.0f);
                ViewCompat.Z0(view, 0.0f);
            }

            public void onAnimationEnd(View view) {
                e.k((ViewPropertyAnimatorListener) null);
                view.setTag(RecyclerViewItemAnimator.LISTENER_TAG_ID, (Object) null);
                RecyclerViewItemAnimator.this.dispatchAddFinished(addInfo.holder);
                RecyclerViewItemAnimator.this.mAddAnimations.remove(addInfo.holder);
                RecyclerViewItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.dispatchAddStarting(addInfo.holder);
            }
        };
        setListenerTag(view, r2);
        this.mAddAnimations.add(addInfo.holder);
        e.b(1.0f).h(1.0f).g(1.0f).q(0.0f).i((long) this.mDuration).j(sItemAddedInterpolator).k(r2).o();
    }

    /* access modifiers changed from: private */
    public void animateChangeImpl(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final View view = null;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat i = ViewCompat.e(view2).i(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            i.p((float) (changeInfo.toX - changeInfo.fromX));
            i.q((float) (changeInfo.toY - changeInfo.fromY));
            i.b(0.0f).k(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    i.k((ViewPropertyAnimatorListener) null);
                    ViewCompat.y0(view, 1.0f);
                    ViewCompat.Y0(view, 0.0f);
                    ViewCompat.Z0(view, 0.0f);
                    RecyclerViewItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    RecyclerViewItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    RecyclerViewItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(View view) {
                    RecyclerViewItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).o();
        }
        if (view != null) {
            final ViewPropertyAnimatorCompat e = ViewCompat.e(view);
            this.mChangeAnimations.add(changeInfo.newHolder);
            e.p(0.0f).q(0.0f).i(getChangeDuration()).b(1.0f).k(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    e.k((ViewPropertyAnimatorListener) null);
                    ViewCompat.y0(view, 1.0f);
                    ViewCompat.Y0(view, 0.0f);
                    ViewCompat.Z0(view, 0.0f);
                    RecyclerViewItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    RecyclerViewItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    RecyclerViewItemAnimator.this.dispatchFinishedWhenDone();
                }

                public void onAnimationStart(View view) {
                    RecyclerViewItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).o();
        }
    }

    /* access modifiers changed from: private */
    public void animateMoveImpl(MoveInfo moveInfo) {
        View view = moveInfo.holder.itemView;
        final int i = moveInfo.toX - moveInfo.fromX;
        final int i2 = moveInfo.toY - moveInfo.fromY;
        if (i != 0) {
            ViewCompat.e(view).p(0.0f);
        }
        if (i2 != 0) {
            ViewCompat.e(view).q(0.0f);
        }
        ViewPropertyAnimatorCompat e = ViewCompat.e(view);
        final MoveInfo moveInfo2 = moveInfo;
        final ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = e;
        AnonymousClass6 r3 = new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                if (i != 0) {
                    ViewCompat.Y0(view, 0.0f);
                }
                if (i2 != 0) {
                    ViewCompat.Z0(view, 0.0f);
                }
            }

            public void onAnimationEnd(View view) {
                viewPropertyAnimatorCompat.k((ViewPropertyAnimatorListener) null);
                view.setTag(RecyclerViewItemAnimator.LISTENER_TAG_ID, (Object) null);
                RecyclerViewItemAnimator.this.dispatchMoveFinished(moveInfo2.holder);
                RecyclerViewItemAnimator.this.mMoveAnimations.remove(moveInfo2.holder);
                RecyclerViewItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.dispatchMoveStarting(moveInfo2.holder);
            }
        };
        setListenerTag(view, r3);
        this.mMoveAnimations.add(moveInfo.holder);
        e.m(50).i(350).j(sItemMoveInterpolator).k(r3).o();
    }

    private void animateRemoveImpl(final RemoveInfo removeInfo) {
        View view = removeInfo.holder.itemView;
        final ViewPropertyAnimatorCompat e = ViewCompat.e(view);
        AnonymousClass4 r2 = new VpaListenerAdapter() {
            public void onAnimationEnd(View view) {
                e.k((ViewPropertyAnimatorListener) null);
                view.setTag(RecyclerViewItemAnimator.LISTENER_TAG_ID, (Object) null);
                ViewCompat.y0(view, 1.0f);
                ViewCompat.U0(view, 1.0f);
                ViewCompat.T0(view, 1.0f);
                ViewCompat.Z0(view, 0.0f);
                RecyclerViewItemAnimator.this.dispatchRemoveFinished(removeInfo.holder);
                RecyclerViewItemAnimator.this.mRemoveAnimations.remove(removeInfo.holder);
                RecyclerViewItemAnimator.this.dispatchFinishedWhenDone();
            }

            public void onAnimationStart(View view) {
                RecyclerViewItemAnimator.this.dispatchRemoveStarting(removeInfo.holder);
            }
        };
        setListenerTag(view, r2);
        this.mRemoveAnimations.add(removeInfo.holder);
        e.i((long) this.mDuration).b(0.0f).h(this.mScale).g(this.mScale).q((float) removeInfo.deltaY).j(sItemRemovedInterpolator).k(r2).o();
    }

    private int checkTheAnchorViewIsMoveView(int i) {
        for (int i2 = 0; i2 < this.mPendingMoves.size(); i2++) {
            if (this.mPendingMoves.get(i2).layoutPosition == i) {
                return this.mPendingMoves.get(i2).fromBottom;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        if (viewHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder2);
        }
    }

    private int getOriginalBottomY(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return 0;
        }
        int checkTheAnchorViewIsMoveView = checkTheAnchorViewIsMoveView(viewHolder.getLayoutPosition());
        return checkTheAnchorViewIsMoveView == -1 ? viewHolder.itemView.getBottom() : checkTheAnchorViewIsMoveView;
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(viewHolder);
    }

    private void setAddInfoDeltaY(ArrayList<AddInfo> arrayList) {
        int i;
        int i2;
        View view;
        sortItemList(arrayList);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < arrayList.size()) {
            if (i3 == 0) {
                int i6 = arrayList.get(0).layoutPosition;
                if (arrayList.get(0).layoutPosition == 0) {
                    i5 = 0;
                } else {
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.mRecyclerView.findViewHolderForLayoutPosition(i6 - 1);
                    if (!(findViewHolderForLayoutPosition == null || (view = findViewHolderForLayoutPosition.itemView) == null)) {
                        i5 = view.getBottom();
                    }
                }
                arrayList.get(0).deltaY = 0;
                i = i6;
                i2 = 0;
            } else {
                i = arrayList.get(i3).layoutPosition;
                if (i - i4 == 1) {
                    i2 = arrayList.get(i3).holder.itemView.getTop() - i5;
                    arrayList.get(i3).deltaY = i2;
                } else {
                    i5 = getOriginalBottomY(this.mRecyclerView.findViewHolderForLayoutPosition(i - 1));
                    i2 = arrayList.get(i3).holder.itemView.getTop() - i5;
                    arrayList.get(i3).deltaY = i2;
                }
            }
            if (i2 != 0) {
                ViewCompat.Z0(arrayList.get(i3).holder.itemView, (float) (-i2));
            }
            i3++;
            i4 = i;
        }
    }

    private void setListenerTag(View view, VpaListenerAdapter vpaListenerAdapter) {
        if (view.getTag(LISTENER_TAG_ID) != null) {
            VpaListenerAdapter vpaListenerAdapter2 = (VpaListenerAdapter) view.getTag(LISTENER_TAG_ID);
            vpaListenerAdapter2.onAnimationCancel(view);
            vpaListenerAdapter2.onAnimationEnd(view);
        }
        view.setTag(LISTENER_TAG_ID, vpaListenerAdapter);
    }

    private void sortItemList(ArrayList<AddInfo> arrayList) {
        int i = 0;
        while (true) {
            if (i < arrayList.size() - 1) {
                for (int i2 = 1; i2 < arrayList.size() - i; i2++) {
                    int i3 = i2 - 1;
                    if (arrayList.get(i3).layoutPosition - arrayList.get(i2).layoutPosition > 0) {
                        arrayList.set(i3, arrayList.get(i2));
                        arrayList.set(i2, arrayList.get(i3));
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        ViewCompat.y0(viewHolder.itemView, 0.0f);
        ViewCompat.U0(viewHolder.itemView, this.mScale);
        ViewCompat.T0(viewHolder.itemView, this.mScale);
        this.mPendingAdditions.add(new AddInfo(viewHolder, viewHolder.getLayoutPosition()));
        return true;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        RecyclerView.ViewHolder viewHolder3 = viewHolder;
        RecyclerView.ViewHolder viewHolder4 = viewHolder2;
        if (viewHolder3 == viewHolder4) {
            dispatchChangeFinished(viewHolder, true);
            return false;
        }
        float K = ViewCompat.K(viewHolder3.itemView);
        float L = ViewCompat.L(viewHolder3.itemView);
        float o = ViewCompat.o(viewHolder3.itemView);
        resetAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - K);
        int i6 = (int) (((float) (i4 - i2)) - L);
        ViewCompat.Y0(viewHolder3.itemView, K);
        ViewCompat.Z0(viewHolder3.itemView, L);
        ViewCompat.y0(viewHolder3.itemView, o);
        if (viewHolder4 != null) {
            resetAnimation(viewHolder2);
            ViewCompat.Y0(viewHolder4.itemView, (float) (-i5));
            ViewCompat.Z0(viewHolder4.itemView, (float) (-i6));
            ViewCompat.y0(viewHolder4.itemView, 0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int K = (int) (((float) i) + ViewCompat.K(view));
        int L = (int) (((float) i2) + ViewCompat.L(viewHolder.itemView));
        resetAnimation(viewHolder);
        int i5 = i3 - K;
        int i6 = i4 - L;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.Y0(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.Z0(view, (float) (-i6));
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, viewHolder.getLayoutPosition(), K, L, i3, i4, L + viewHolder.itemView.getHeight()));
        return true;
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        int i;
        View view;
        int bottom;
        int top2;
        resetAnimation(viewHolder);
        View view2 = viewHolder.itemView;
        int layoutPosition = viewHolder.getLayoutPosition();
        if (layoutPosition == -1) {
            bottom = this.mRecyclerView.getPaddingTop();
            top2 = view2.getTop();
        } else {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.mRecyclerView.findViewHolderForLayoutPosition(layoutPosition);
            if (findViewHolderForLayoutPosition == null || (view = findViewHolderForLayoutPosition.itemView) == null) {
                i = 0;
                this.mPendingRemovals.add(new RemoveInfo(viewHolder, i));
                return true;
            }
            bottom = view.getBottom();
            top2 = view2.getTop();
        }
        i = bottom - top2;
        this.mPendingRemovals.add(new RemoveInfo(viewHolder, i));
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return true;
    }

    public void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.e(list.get(size).itemView).c();
        }
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewCompat.e(view).c();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.mPendingMoves.get(size).holder == viewHolder) {
                ViewCompat.Z0(view, 0.0f);
                ViewCompat.Y0(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            ViewCompat.y0(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            ViewCompat.y0(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).holder == viewHolder) {
                    ViewCompat.Z0(view, 0.0f);
                    ViewCompat.Y0(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(viewHolder)) {
                ViewCompat.y0(view, 1.0f);
                ViewCompat.U0(view, 1.0f);
                ViewCompat.T0(view, 1.0f);
                ViewCompat.Z0(view, 0.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.mChangeAnimations.remove(viewHolder);
        this.mMoveAnimations.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            ViewCompat.Z0(view, 0.0f);
            ViewCompat.Y0(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2).holder);
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            AddInfo addInfo = this.mPendingAdditions.get(size3);
            View view2 = addInfo.holder.itemView;
            ViewCompat.y0(view2, 1.0f);
            ViewCompat.U0(view2, 1.0f);
            ViewCompat.T0(view2, 1.0f);
            ViewCompat.Z0(view2, 0.0f);
            dispatchAddFinished(addInfo.holder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view3 = moveInfo2.holder.itemView;
                    ViewCompat.Z0(view3, 0.0f);
                    ViewCompat.Y0(view3, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder = ((AddInfo) arrayList2.get(size8)).holder;
                    View view4 = viewHolder.itemView;
                    ViewCompat.y0(view4, 1.0f);
                    ViewCompat.U0(view4, 1.0f);
                    ViewCompat.T0(view4, 1.0f);
                    ViewCompat.Z0(view4, 0.0f);
                    dispatchAddFinished(viewHolder);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
    }

    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            setAddInfoDeltaY(this.mPendingAdditions);
            Iterator<RemoveInfo> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                AnonymousClass1 r8 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.animateMoveImpl((MoveInfo) it.next());
                        }
                        arrayList.clear();
                        RecyclerViewItemAnimator.this.mMovesList.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.m0(((MoveInfo) arrayList.get(0)).holder.itemView, r8, 0);
                } else {
                    r8.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                AnonymousClass2 r82 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
                        }
                        arrayList2.clear();
                        RecyclerViewItemAnimator.this.mChangesList.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.m0(((ChangeInfo) arrayList2.get(0)).oldHolder.itemView, r82, 0);
                } else {
                    r82.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                AnonymousClass3 r7 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RecyclerViewItemAnimator.this.animateAddImpl((AddInfo) it.next());
                        }
                        arrayList3.clear();
                        RecyclerViewItemAnimator.this.mAdditionsList.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.m0(((AddInfo) arrayList3.get(0)).holder.itemView, r7, 0);
                } else {
                    r7.run();
                }
            }
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        ViewCompat.y0(viewHolder.itemView, 1.0f);
        ViewCompat.Y0(viewHolder.itemView, 0.0f);
        ViewCompat.Z0(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }
}
