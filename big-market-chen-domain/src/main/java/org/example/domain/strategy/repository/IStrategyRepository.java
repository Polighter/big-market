package org.example.domain.strategy.repository;

/*策略仓储接口*/

import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.model.entity.StrategyRuleEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTables(String key, BigDecimal rateRange, HashMap<Integer, Integer> shuffleStrategyAwardSearchRateTables);

    int getRateRange(Long strategyId);
    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRuleEntity(Long strategyId,String ruleModel);
}
