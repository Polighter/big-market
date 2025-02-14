package org.example.domain.strategy.service.rule.chain.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.AbstractLogicChain;
import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
* 默认
* */
@Slf4j
@Component("default")
public class DefaultLogicChain extends AbstractLogicChain {
    @Resource
    private IStrategyDispatch strategyDispatch;


    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId：{} strategyId:{} ruleModel:{} awardId:{}",userId,strategyId,ruleModel(),awardId);
        return  DefaultChainFactory.StrategyAwardVO.builder()
                .awardId(awardId)
                .logicModel(ruleModel())
                .build()
                ;
    }

    @Override
    protected String ruleModel() {
        return "default";
    }
}
