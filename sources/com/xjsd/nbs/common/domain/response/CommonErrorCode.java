package com.xjsd.nbs.common.domain.response;

public enum CommonErrorCode implements ErrorCode {
    SUCCESS(0, "success"),
    BUSINESS_ERROR(1, "please come back later"),
    SERVICE_ERROR(2, "please come back later"),
    PARAM_ERROR(100001, "参数错误"),
    REMOTE_ERROR(100002, "远程请求错误"),
    DATE_INVALID(100003, "日期不合法"),
    CONNECTION_ERROR(1000004, "服务连接异常"),
    OPERATION_ERROR(1000005, "操作异常"),
    AUTHENTICATION_ERROR(1000006, "认证失败"),
    SENTINEL_FLOW_ERROR(1000007, "流控规则限流"),
    SENTINEL_DEGRADE_ERROR(1000008, "熔断规则限流"),
    SENTINEL_PARAM_FLOW_ERROR(1000009, "热点参数限流"),
    SENTINEL_AUTHORITY_ERROR(1000010, "授权规则限流"),
    SENTINEL_SYSTEM_BLOCK_ERROR(1000011, "系统规则限流");
    
    private int errorCode;
    private String errorMessage;

    private CommonErrorCode(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
