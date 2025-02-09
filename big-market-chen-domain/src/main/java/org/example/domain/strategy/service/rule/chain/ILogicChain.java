package org.example.domain.strategy.service.rule.chain;

/*
* 责任链接口
* */
public interface ILogicChain extends ILogicChainArmory{
    /*
    * 用户id
    * 策略id
    * @return 奖品ID
    * */
    Integer logic(String userId,Long strategyId);



}
