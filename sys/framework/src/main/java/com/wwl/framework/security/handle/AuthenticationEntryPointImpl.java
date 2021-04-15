package com.wwl.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.wwl.common.constant.HttpStatus;
import com.wwl.common.core.domain.AjaxResult;
import com.wwl.common.utils.MessageUtils;
import com.wwl.common.utils.ServletUtils;
import com.wwl.common.utils.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 * 
 * @author wk
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.format(MessageUtils.message("no.access.permission"), request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}
