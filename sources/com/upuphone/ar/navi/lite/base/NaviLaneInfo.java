package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;
import java.util.ArrayList;

public class NaviLaneInfo implements Serializable {
    public int[] backgroundLane;
    public int[] frontLane;
    public int laneCount;
    public int laneTypeId = 0;
    public ArrayList<Integer> lanesIconList;
}
