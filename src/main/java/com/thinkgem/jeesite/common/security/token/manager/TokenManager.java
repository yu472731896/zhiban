package com.thinkgem.jeesite.common.security.token.manager;

import com.thinkgem.jeesite.common.security.token.model.TokenModel;

/**
 * 对Token进行操作的接口
 *
 * @author yooranchen
 * @date 2017/12/28.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     *
     * @param userId 指定用户的id
     * @return 生成的token
     */
    TokenModel createToken(String userId);

    /**
     * 检查token是否有效
     *
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     *
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 清除token
     *
     * @param userId 登录用户的id
     */
    void deleteToken(String userId);
}
