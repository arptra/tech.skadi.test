package com.xjsd.nbs.client.endpoint.response;

import com.xjsd.nbs.client.domain.enums.DownloadStatus;
import java.util.StringJoiner;

public class DownloadResp {

    /* renamed from: a  reason: collision with root package name */
    public DownloadStatus f8709a;
    public Integer b;

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", DownloadResp.class.getSimpleName() + "[", "]");
        StringJoiner add = stringJoiner.add("status=" + this.f8709a);
        return add.add("progressRatio=" + this.b).toString();
    }
}
