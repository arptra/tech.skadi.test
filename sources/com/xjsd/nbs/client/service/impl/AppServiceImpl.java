package com.xjsd.nbs.client.service.impl;

import com.alibaba.fastjson2.TypeReference;
import com.xjsd.nbs.client.domain.dto.AppDetailDTO;
import com.xjsd.nbs.client.domain.dto.AppInfoDTO;
import com.xjsd.nbs.client.domain.dto.AppVersionHistoryDTO;
import com.xjsd.nbs.client.service.IAppService;
import com.xjsd.nbs.client.service.base.BaseService;
import com.xjsd.nbs.common.domain.response.CommonResponse;
import java.util.List;

public class AppServiceImpl extends BaseService implements IAppService {

    /* renamed from: com.xjsd.nbs.client.service.impl.AppServiceImpl$1  reason: invalid class name */
    class AnonymousClass1 extends TypeReference<CommonResponse<List<AppInfoDTO>>> {
    }

    /* renamed from: com.xjsd.nbs.client.service.impl.AppServiceImpl$2  reason: invalid class name */
    class AnonymousClass2 extends TypeReference<CommonResponse<AppDetailDTO>> {
    }

    /* renamed from: com.xjsd.nbs.client.service.impl.AppServiceImpl$3  reason: invalid class name */
    class AnonymousClass3 extends TypeReference<CommonResponse<List<AppVersionHistoryDTO>>> {
    }
}
