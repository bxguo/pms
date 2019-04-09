package com.zysl.cloud.pms.common.constants;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: bxguo
 * @time: 2019/4/4 17:31
 */
@Data
public class MyPage implements Serializable {
    private static final long serialVersionUID = -8735573353757118989L;

    private int begin;
    private int end;
    private int length=10;
    private int totalRecords;
    private int pageNo;
    private int pageCount;

    public MyPage(int pageNo, int length) {
        this.length = length;
        this.pageNo = pageNo;
    }
}
