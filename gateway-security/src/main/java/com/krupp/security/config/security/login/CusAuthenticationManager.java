package com.krupp.security.config.security.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p> 自定义认证管理器 </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2019/10/12 14:49
 */
@Slf4j
@Component
public class CusAuthenticationManager implements AuthenticationManager {

    private final AdminAuthenticationProvider adminAuthenticationProvider;

    public CusAuthenticationManager(AdminAuthenticationProvider adminAuthenticationProvider) {
        this.adminAuthenticationProvider = adminAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("自定义认证管理器： CusAuthenticationManager.authenticate");
        Authentication result = adminAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }

}
