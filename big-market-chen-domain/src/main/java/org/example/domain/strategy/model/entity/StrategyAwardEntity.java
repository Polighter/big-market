package org.example.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardEntity {

    /*策略ID*/
    private Long strategyId;
    /*奖品ID*/
    private Integer awardId;
    /*奖品总量*/
    private Integer awardCount;
    /*奖品剩余*/
    private Integer awardCountSurplus;
    /*中奖概率*/
    private BigDecimal awardRate;

}
