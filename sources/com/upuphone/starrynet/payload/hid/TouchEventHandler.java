package com.upuphone.starrynet.payload.hid;

import android.util.Log;
import android.view.MotionEvent;
import com.upuphone.starrynet.payload.hid.TouchPadProxy;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TouchEventHandler {
    private static final String TAG = "TouchEventHandler";
    private TouchPadProxy.TouchEventListener mWrapper;
    HashMap<Integer, Integer> pointerIdTouchId = new HashMap<>();
    Queue<Integer> touchIDPool;

    public TouchEventHandler(TouchPadProxy.TouchEventListener touchEventListener) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.touchIDPool = concurrentLinkedQueue;
        this.mWrapper = touchEventListener;
        concurrentLinkedQueue.offer(0);
        this.touchIDPool.offer(1);
        this.touchIDPool.offer(2);
        this.touchIDPool.offer(3);
        this.touchIDPool.offer(4);
        this.touchIDPool.offer(5);
        this.touchIDPool.offer(6);
        this.touchIDPool.offer(7);
    }

    private void releaseTipSwitch(MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (this.touchIDPool.size() > 0 && this.pointerIdTouchId.containsKey(Integer.valueOf(pointerId))) {
            Integer num = this.pointerIdTouchId.get(Integer.valueOf(pointerId));
            int intValue = num.intValue();
            this.pointerIdTouchId.remove(Integer.valueOf(pointerId));
            this.touchIDPool.offer(num);
            this.mWrapper.touchMove(intValue, (int) motionEvent.getX(motionEvent.getActionIndex()), (int) motionEvent.getY(motionEvent.getActionIndex()));
            this.mWrapper.touchReset(intValue);
        }
    }

    public boolean onTouch(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                Log.d(TAG, "onTouch ,action =ACTION_UP");
                releaseTipSwitch(motionEvent);
                return true;
            } else if (actionMasked == 2) {
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId = motionEvent.getPointerId(i);
                    int intValue = this.pointerIdTouchId.get(Integer.valueOf(pointerId)).intValue();
                    if (this.pointerIdTouchId.containsKey(Integer.valueOf(pointerId))) {
                        this.mWrapper.touchMove(intValue, (int) motionEvent.getX(i), (int) motionEvent.getY(i));
                    }
                }
                return true;
            } else if (actionMasked == 3) {
                releaseTipSwitch(motionEvent);
                Log.d(TAG, "onTouch ,action =ACTION_CANCEL");
                return true;
            } else if (actionMasked != 5) {
                if (actionMasked != 6) {
                    return false;
                }
                releaseTipSwitch(motionEvent);
                Log.d(TAG, "onTouch ,action =ACTION_POINTER_UP");
                return true;
            }
        }
        Log.d(TAG, String.format("onTouch ,action =%d(0:action down; 5:action pointer down) ", new Object[]{Integer.valueOf(motionEvent.getActionMasked())}));
        int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (this.touchIDPool.size() > 0) {
            if (!this.pointerIdTouchId.containsKey(Integer.valueOf(pointerId2))) {
                Integer poll = this.touchIDPool.poll();
                int intValue2 = poll.intValue();
                this.pointerIdTouchId.put(Integer.valueOf(pointerId2), poll);
                this.mWrapper.touchMove(intValue2, (int) motionEvent.getX(motionEvent.getActionIndex()), (int) motionEvent.getY(motionEvent.getActionIndex()));
                return true;
            }
            Log.d(TAG, "onTouch down or pointer down,but pointerID has contained, so ignore it!");
        }
        return false;
    }
}
