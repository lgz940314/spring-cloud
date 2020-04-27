package com.krupp.security.config.security.login;

import com.zhengqing.config.security.dto.SecurityUser;
import com.zhengqing.modules.common.dto.output.ApiResult;
import com.zhengqing.modules.system.entity.User;
import com.zhengqing.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p> 认证成功处理 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/12 15:31
 */
@Slf4j
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        User user = new User();
        SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
        user.setToken(securityUser.getCurrentUserInfo().getToken());
        ResponseUtils.out(response, ApiResult.ok("登录成功!", user));
        log.info("认证成功处理： AdminAuthenticationSuccessHandler.onAuthenticationSuccess");
    }
}
