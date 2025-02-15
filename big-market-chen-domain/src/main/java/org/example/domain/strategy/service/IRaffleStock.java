package org.example.domain.strategy.service;

import org.example.domain.strategy.model.VO.StrategyAwardStockKeyVO;

public interface IRaffleStock {

    //获取奖品库存消耗队列
    StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException;

    //更新奖品库存消耗记录
    void updateStrategyAwardStock(Long strategyId,Integer awardId);


}
