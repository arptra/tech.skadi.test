package com.upuphone.xr.interconnect.api;

public interface OperatorManager {
    AccountAbilityOperator getAccountAbilityOperator();

    DataBinderOperator getDataBinderOperator();

    StarryNetDeviceInfoOperator getDeviceInfoOperator();

    StarryNetDeviceOperator getDeviceOperator();

    StarryNetDialerOperator getDialerOperator();

    StarryNetFileOperator getFileOperator();

    StarryNetGroupMessageOperator getGroupMessageOperator();

    InfoOperator getInfoOperator();

    StarryNetMessageOperator getMessageOperator();

    NaviAbilityOperator getNaviAbilityOperator();

    ResourceOperator getResourceOperator();

    SappAbilityOperator getSappAbilityOperator();

    StarryNetAppOperator getStarryNetAppOperator();

    StarryNetDlnaServerOperator getStarryNetDlnaServerOperator();

    TaskOperator getTaskOperator();

    TransAbilityOperator getTransAbilityOperator();

    VolumeChangeControllerOperator getVolumeChangeControllerOperator();

    StarryNetWifiOperator getWifiOperator();
}
