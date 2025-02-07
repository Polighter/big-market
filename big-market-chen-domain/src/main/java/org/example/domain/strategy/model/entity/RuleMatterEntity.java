package org.example.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 规则物料,用于过滤规则的必要参数信息
* */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleMatterEntity {
    private String userId;
    private Long strategyId;

    private Integer awardId;
    /*抽奖规则类型 rule_random rule_lock*/
    private String ruleModel;
}
