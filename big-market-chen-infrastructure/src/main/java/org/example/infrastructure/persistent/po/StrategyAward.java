package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Data
public class StrategyAward {

    private Long id;

    /*策略ID*/
    private Long strategyId;
    /*奖品ID*/
    private Integer awardId;

    private String awardTitle;
    private String awardSubtitle;
    /*奖品总量*/
    private Integer awardCount;
    /*奖品剩余*/
    private Integer awardCountSurplus;
    /*中奖概率*/
    private BigDecimal awardRate;
    private String ruleModels;
    private Integer sort;
    private Date createTime;
    private Date updateTime;
}
