package flyme.support.v7.widget;

public interface ITitleControl {
    float getCurrentScale();

    void releaseTitleScale();

    void setTitleOverScrollY(float f);

    void takeOverTitleScale();

    void updateScaleValue(float f);
}
