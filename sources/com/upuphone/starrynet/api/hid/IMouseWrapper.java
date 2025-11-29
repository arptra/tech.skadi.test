package com.upuphone.starrynet.api.hid;

public interface IMouseWrapper {
    void buttonDown(int i);

    void buttonUp(int i);

    void move(byte b, byte b2);

    void scroll(byte b);
}
