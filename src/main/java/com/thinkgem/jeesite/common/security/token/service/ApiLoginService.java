package com.thinkgem.jeesite.common.security.token.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input;
import com.thinkgem.jeesite.common.security.Digests;
import com.thinkgem.jeesite.common.security.token.manager.TokenManager;
import com.thinkgem.jeesite.common.security.token.model.TokenModel;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Service
public class ApiLoginService {

    @Autowired
    private TokenManager manager;

    public User login(ServletRequest request, ServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String passwordStr = request.getParameter("password");
        
      /*  byte[] password = Digests.sha1(passwordStr.getBytes());
        passwordStr = password.toString();*/
        
        if (passwordStr == null) {
        	passwordStr = "";
        }
        String host = StringUtils.getRemoteAddr((HttpServletRequest) request);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,passwordStr.toCharArray() , false, host);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        // 登录成功
        return UserUtils.getByLoginName(username);
    }

    /**
     * 创建token
     *
     * @param userId 用户id
     * @return
     */
    public TokenModel createToken(String userId) {
        return manager.createToken(userId);
    }

    /**
     * 删除token
     *
     * @param userId 用户id
     */
    public void deleteToken(String userId) {
        manager.deleteToken(userId);
    }
}
