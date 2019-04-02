package com.zysl.cloud.pms.common.uo;

import lombok.Data;

/**
 * @author: bxguo
 * @time: 2019/4/2 16:30
 */
@Data
public class UserSessionUO {
    private Long id;
    private String userId;
    private String userName;
    private String partyId;
    private String accountType;
}
