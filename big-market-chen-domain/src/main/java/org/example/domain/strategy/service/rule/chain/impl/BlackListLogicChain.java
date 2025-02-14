package org.example.domain.strategy.service.rule.chain.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.AbstractLogicChain;
import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import org.example.types.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/*
* 黑名单责任链
* */
@Slf4j
@Component("rule_blacklist")
public class BlackListLogicChain extends AbstractLogicChain {
    @Resource
    private IStrategyRepository strategyRepository;
    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {

        log.info("抽奖责任链-黑名单开始 userId：{} strategyId:{} ruleModel:{} ",userId,strategyId,ruleModel());
        String ruleValue = strategyRepository.queryStrategyRuleValue(strategyId, ruleModel());
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);
        // 过滤其他规则
        String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)){
                log.info("抽奖责任链-黑名单接管 userId：{} strategyId:{} ruleModel:{} awardId:{}",userId,strategyId,ruleModel(),awardId);
                return DefaultChainFactory.StrategyAwardVO.builder()
                        .awardId(awardId)
                        .logicModel(ruleModel())
                        .build()
                        ;
            }
        }
        log.info("抽奖责任链-黑名单放行 userId：{} strategyId:{} ruleModel:{} ",userId,strategyId,ruleModel());
        return next().logic(userId,strategyId);
    }

    @Override
    protected String ruleModel() {
        return "rule_blacklist";
    }
}
