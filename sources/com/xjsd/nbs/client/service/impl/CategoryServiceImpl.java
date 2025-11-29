package com.xjsd.nbs.client.service.impl;

import com.alibaba.fastjson2.TypeReference;
import com.xjsd.nbs.client.domain.dto.CategoryAllDTO;
import com.xjsd.nbs.client.service.ICategoryService;
import com.xjsd.nbs.client.service.base.BaseService;
import com.xjsd.nbs.common.domain.response.CommonResponse;
import java.util.List;

public class CategoryServiceImpl extends BaseService implements ICategoryService {

    /* renamed from: com.xjsd.nbs.client.service.impl.CategoryServiceImpl$1  reason: invalid class name */
    class AnonymousClass1 extends TypeReference<CommonResponse<List<CategoryAllDTO>>> {
    }
}
