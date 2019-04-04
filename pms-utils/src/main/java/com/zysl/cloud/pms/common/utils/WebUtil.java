package com.zysl.cloud.pms.common.utils;

import com.zysl.cloud.pms.common.constants.SessionConstants;
import com.zysl.cloud.pms.common.constants.exception.AppLogicException;
import com.zysl.cloud.pms.common.enums.RespCodeEnum;
import com.zysl.cloud.pms.common.uo.UserSessionUO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: bxguo
 * @time: 2019/4/2 15:25
 */
@Slf4j
@Component
public class WebUtil {
    private static final String CODE = "UTF-8";
    public static final String IP_HEADER_NAME = "X-Forwarded-For";

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpSession session;

    public void clearSession(){
        session.invalidate();
    }

    public String getSessionId(){
        return session.getId();
    }

    public Object getSession(String key){
        return session.getAttribute(key);
    }
    public boolean hasLogin(){
        return getSession(SessionConstants.LOGIN_FLAG) != null;
    }
    public UserSessionUO getUserSession(){
        Object user = getSession(SessionConstants.USER_INFO);
        if (user == null) {
            throw new AppLogicException(RespCodeEnum.AUTHFAILED.getDesc(), RespCodeEnum.AUTHFAILED.getCode());
        }
        return (UserSessionUO) user;
    }

    public String getUserIp(){
        String userIp = httpServletRequest.getHeader(IP_HEADER_NAME);
        if (StringUtils.isBlank(userIp)) {
            return httpServletRequest.getRemoteAddr();
        }
        if (userIp.contains(",")){
            //return userIp.substring(0, userIp.indexOf(","));
            return userIp.split(",")[0].trim();
        }
        return userIp;
    }
}
