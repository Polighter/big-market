package org.example.domain.strategy.service.armory;


/*策略配置库接口*/

public interface IStrategyArmory {
    void assembleLotteryStrategy(Long strategyId);

    Integer getRandomAwardId(Long strategyId);
}
