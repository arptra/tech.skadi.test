package flyme.support.v7.util;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class EnterAnimateUtil {
    private static int DEFAULTDELAY = 0;
    private static int DEFAULTDURATION = 200;
    private static int DEFAULTINTERVAL = 25;
    private static float DEFAULTOFFSETRATIO = 0.125f;
    /* access modifiers changed from: private */
    public ItemDividerManager itemDividerManager = new ItemDividerManager();
    private int mDelay = DEFAULTDELAY;
    private int mDuration = DEFAULTDURATION;
    private int mInterval = DEFAULTINTERVAL;
    private float mItemOffsetRatio = DEFAULTOFFSETRATIO;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;

    public EnterAnimateUtil(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    private void startItemAnimate(final int i, final View view, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((float) view.getHeight()) * this.mItemOffsetRatio, 0.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                EnterAnimateUtil.this.itemDividerManager.setDivider(i, (int) (255.0f * animatedFraction), (int) floatValue);
                EnterAnimateUtil.this.mRecyclerView.invalidateItemDecorations();
                view.setAlpha(animatedFraction);
                view.setTranslationY(floatValue);
            }
        });
        ofFloat.setDuration((long) i3);
        ofFloat.setStartDelay((long) i2);
        ofFloat.start();
    }

    public int getDividerAlpha(int i) {
        return this.itemDividerManager.getDividerAlpha(i);
    }

    public int getDividerOffset(int i) {
        return this.itemDividerManager.getDividerOffset(i);
    }

    public void runEnterAnimation() {
        for (int i = 0; i < this.mRecyclerView.getChildCount(); i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            childAt.setAlpha(0.0f);
            this.itemDividerManager.setDividerAlpha(i, 0);
            startItemAnimate(i, childAt, (this.mInterval * i) + this.mDelay, this.mDuration);
        }
        this.mRecyclerView.invalidateItemDecorations();
    }

    public void setDelay(int i) {
        this.mDelay = i;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setInterval(int i) {
        this.mInterval = i;
    }

    public void setItemOffsetRatio(float f) {
        this.mItemOffsetRatio = f;
    }

    public class ItemDividerManager {
        private HashMap<Integer, ItemDivider> itemDividerHashMap = new HashMap<>();

        public class ItemDivider {
            private int alpha = 0;
            private int offset = 0;

            public ItemDivider() {
            }

            public int getAlpha() {
                return this.alpha;
            }

            public int getOffset() {
                return this.offset;
            }

            public void setAlpha(int i) {
                this.alpha = i;
            }

            public void setOffset(int i) {
                this.offset = i;
            }
        }

        public ItemDividerManager() {
        }

        public int getDividerAlpha(int i) {
            if (this.itemDividerHashMap.get(Integer.valueOf(i)) == null) {
                return 255;
            }
            return this.itemDividerHashMap.get(Integer.valueOf(i)).getAlpha();
        }

        public int getDividerOffset(int i) {
            if (this.itemDividerHashMap.get(Integer.valueOf(i)) == null) {
                return 0;
            }
            return this.itemDividerHashMap.get(Integer.valueOf(i)).getOffset();
        }

        public void setDivider(int i, int i2) {
            if (this.itemDividerHashMap.containsKey(Integer.valueOf(i))) {
                this.itemDividerHashMap.get(Integer.valueOf(i)).setOffset(i2);
                return;
            }
            ItemDivider itemDivider = new ItemDivider();
            itemDivider.setOffset(i2);
            this.itemDividerHashMap.put(Integer.valueOf(i), itemDivider);
        }

        public void setDividerAlpha(int i, int i2) {
            if (this.itemDividerHashMap.containsKey(Integer.valueOf(i))) {
                this.itemDividerHashMap.get(Integer.valueOf(i)).setAlpha(i2);
                return;
            }
            ItemDivider itemDivider = new ItemDivider();
            itemDivider.setAlpha(i2);
            this.itemDividerHashMap.put(Integer.valueOf(i), itemDivider);
        }

        public void setDivider(int i, int i2, int i3) {
            if (this.itemDividerHashMap.containsKey(Integer.valueOf(i))) {
                this.itemDividerHashMap.get(Integer.valueOf(i)).setAlpha(i2);
                this.itemDividerHashMap.get(Integer.valueOf(i)).setOffset(i3);
                return;
            }
            ItemDivider itemDivider = new ItemDivider();
            itemDivider.setAlpha(i2);
            itemDivider.setOffset(i3);
            this.itemDividerHashMap.put(Integer.valueOf(i), itemDivider);
        }
    }
}
