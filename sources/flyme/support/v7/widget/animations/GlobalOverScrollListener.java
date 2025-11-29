package flyme.support.v7.widget.animations;

import android.view.View;

public interface GlobalOverScrollListener {
    void onOverScroll(View view, float f, float f2);

    void onOverScrollStateChanged(View view, int i);
}
