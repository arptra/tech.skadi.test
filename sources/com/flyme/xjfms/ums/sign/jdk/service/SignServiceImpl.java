package com.flyme.xjfms.ums.sign.jdk.service;

import com.flyme.xjfms.ums.sign.jdk.dto.SignDTO;
import com.flyme.xjfms.ums.sign.jdk.utils.MD5Util;

public class SignServiceImpl implements SignSerivce {
    public String a(SignDTO signDTO) {
        if (signDTO == null) {
            return null;
        }
        String a2 = signDTO.a();
        String b = signDTO.b();
        Long c = signDTO.c();
        b(a2, b, c);
        return MD5Util.a(a2 + b + c);
    }

    public final void b(String str, String str2, Long l) {
        if (str == null || str.trim().equals("")) {
            throw new RuntimeException("appId不能为空！");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new RuntimeException("appSecret不能为空！");
        } else if (l == null) {
            throw new RuntimeException("reqTime不能为空！");
        }
    }
}
