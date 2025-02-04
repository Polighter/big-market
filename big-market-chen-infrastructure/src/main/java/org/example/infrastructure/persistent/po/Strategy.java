package org.example.infrastructure.persistent.po;


/*@author chen
* @describe 抽奖策略
* @create 2025/2/1*/

import lombok.Data;

import java.util.Date;

@Data
public class Strategy {
    private Long id;
    private Long strategyId;
    private String strategyDesc;
    private Date createTime;
    private Date updateTime;

}
