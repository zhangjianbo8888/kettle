package org.pentaho.di.ui.repo.utils;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.validator.Var;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
//import com.dagu.framework.common.JsonUtil;
//import com.dagu.framework.web.passport.jwt.JwtPayload;

public class JwtPassport {

    private Boolean allowRefresh;

    private Long refreshDelta;

    private Long timeout;

    private Algorithm signKey;

    private JWTVerifier jwt;


//    public String generateToken(String userId, String userName) {
//        JwtPayload payload = new JwtPayload();
//        payload.setUserId(userId);
//        payload.setUserName(userName);
//        Long ts = System.currentTimeMillis();
//        if (timeout > 0) {
//            payload.setExp(new Date(ts + timeout * 1000));
//        }
//        Builder builder = JWT.create().withClaim("user_id", payload.getUserId())
//                .withClaim("user_name", payload.getUserName()).withExpiresAt(payload.getExp());
//        if (allowRefresh) {
//            Integer orig_iat = Long.valueOf(ts / 1000).intValue();
//            builder = builder.withClaim("orig_iat", orig_iat);
//        }
//        return builder.sign(signKey);
//    }

//    public String generateToken(String userId, String userName, Long origIat) {
//        JwtPayload payload = new JwtPayload();
//        payload.setUserId(userId);
//        payload.setUserName(userName);
//        if (timeout > 0) {
//            payload.setExp(new Date(System.currentTimeMillis() + timeout * 1000));
//        }
//        Builder builder = JWT.create().withClaim("user_id", payload.getUserId())
//                .withClaim("user_name", payload.getUserName()).withExpiresAt(payload.getExp());
//        if (allowRefresh) {
//            Integer orig_iat = origIat.intValue();
//            builder = builder.withClaim("orig_iat", orig_iat);
//        }
//        return builder.sign(signKey);
//    }

    public JwtPayload getData(String token) { //获取数据
        String baseStr = jwt.verify(token).getPayload().replace("_", "/");
        try {
			return JsonUtil.fromJson(new String(Base64.getDecoder().decode(baseStr)), JwtPayload.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		

    }



}