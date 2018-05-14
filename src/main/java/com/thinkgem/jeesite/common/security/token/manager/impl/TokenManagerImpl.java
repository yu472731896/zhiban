package com.thinkgem.jeesite.common.security.token.manager.impl;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.common.entity.Constants;
import com.thinkgem.jeesite.common.security.token.manager.TokenManager;
import com.thinkgem.jeesite.common.security.token.model.TokenModel;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.IdGen;

/**
 * token 管理类
 *
 * @author yooranchen
 */
@Service
public class TokenManagerImpl implements TokenManager {

    @Override
    public TokenModel createToken(String userId) {
//        String savedToken = (String) CacheUtils.get(Constants.CACHE_TOKEN, userId);
//        if (StringUtils.isNoneBlank(savedToken)) {
//            CacheUtils.put(Constants.CACHE_TOKEN, userId, savedToken);
//            return new TokenModel(userId, savedToken);
//        }
        //使用uuid作为源token
        String token = IdGen.uuid();
        TokenModel model = new TokenModel(userId, token);
        //存储到并设置过期时间
        CacheUtils.put(Constants.CACHE_TOKEN, userId, model.getToken());
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String userId = model.getUserId();
        String token = model.getToken();
        String savedToken = (String) CacheUtils.get(Constants.CACHE_TOKEN, userId);
        if (savedToken == null || !savedToken.equals(token)) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        CacheUtils.put(Constants.CACHE_TOKEN, userId, savedToken);
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        String userId = param[0];
        String token = param[1];
        return new TokenModel(userId, token);
    }

    @Override
    public void deleteToken(String userId) {
        CacheUtils.remove(Constants.CACHE_TOKEN, userId);
    }
}
