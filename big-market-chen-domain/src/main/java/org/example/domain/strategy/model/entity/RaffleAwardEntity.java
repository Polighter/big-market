package org.example.domain.strategy.model.entity;
/*
* 抽奖奖品实体
* */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {

    /*策略Id*/
    private Long strategyId;

    private Integer awardId;

    /*奖品对接标识，每一个都是一个对应的发奖策略*/
    private String awardKey;

    private String awardConfig;

    private String awardDesc;
}
