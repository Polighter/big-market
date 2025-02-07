package org.example.domain.strategy.model.entity;

import lombok.*;
import org.example.domain.strategy.model.VO.RuleLogicCheckTypeVO;

/*
* 规则行为实体，在抽奖过程中遇到不同的规则做出不同的反应的实体
* RuleActionEntity类通过泛型T来处理不同类型的数据，但这些数据必须是RaffleEntity或其子类
* */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;

    /*抽奖实体*/
    static public class RaffleEntity{
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RaffleBeforeEntity extends RaffleEntity{
        private Long strategyId;
        /*奖品Id，返回抽中的奖品*/
        private Integer awardId;

        /*规则权重值,用于权重抽奖*/
        private String ruleWeightValueKey;
    }


}
