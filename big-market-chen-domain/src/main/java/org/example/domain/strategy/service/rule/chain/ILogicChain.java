package org.example.domain.strategy.service.rule.chain;

import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/*
* 责任链接口
* */
public interface ILogicChain extends ILogicChainArmory{
    /*
    * 用户id
    * 策略id
    * @return 奖品ID
    * */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);



}
