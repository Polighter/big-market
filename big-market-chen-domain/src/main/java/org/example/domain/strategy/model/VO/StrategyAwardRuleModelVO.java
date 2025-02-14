package org.example.domain.strategy.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.example.types.common.Constants;

import java.util.ArrayList;
import java.util.List;


/*
* 抽奖规则的值对象，仅限从数据库中查询返回
* */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

}
