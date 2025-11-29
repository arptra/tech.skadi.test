package flyme.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import flyme.support.v7.appcompat.R;

public class TwoStateTextView extends TextView {
    private String mCancelSelectALl;
    private int mCurrentSelectedCount;
    private boolean mForceUpdate;
    private String mSelectAll;
    private State mState;
    private int mTotalCount;

    public enum State {
        COMPLETED,
        PROGRESS
    }

    public TwoStateTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        this.mSelectAll = getContext().getResources().getString(R.string.mz_action_bar_multi_choice_select_all);
        this.mCancelSelectALl = getContext().getResources().getString(R.string.mz_action_bar_multi_choice_select_all_cancel);
    }

    private void updateState() {
        if (this.mForceUpdate) {
            this.mForceUpdate = false;
            if (this.mCurrentSelectedCount >= this.mTotalCount) {
                this.mState = State.COMPLETED;
                setText(this.mCancelSelectALl);
                return;
            }
            this.mState = State.PROGRESS;
            setText(this.mSelectAll);
            return;
        }
        State state = this.mState;
        State state2 = State.PROGRESS;
        if (state == state2 && this.mCurrentSelectedCount >= this.mTotalCount) {
            setText(this.mCancelSelectALl);
            this.mState = State.COMPLETED;
        } else if (state == State.COMPLETED && this.mCurrentSelectedCount < this.mTotalCount) {
            setText(this.mSelectAll);
            this.mState = state2;
        }
    }

    public void setSelectedCount(int i) {
        this.mCurrentSelectedCount = i;
        updateState();
    }

    public void setTotalCount(int i) {
        this.mTotalCount = i;
        this.mForceUpdate = true;
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalCount = 0;
        this.mCurrentSelectedCount = Integer.MAX_VALUE;
        this.mForceUpdate = false;
        init();
    }
}
