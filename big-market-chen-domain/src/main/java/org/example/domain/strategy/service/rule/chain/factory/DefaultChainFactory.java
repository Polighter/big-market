package org.example.domain.strategy.service.rule.chain.factory;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.rule.chain.ILogicChain;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;

    private IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup,IStrategyRepository repository){
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    public ILogicChain openLogicChain(Long strategyId){
        StrategyEntity strategyEntity = repository.queryStrategyEntityByStrategyId(strategyId);
        String[] ruleModels = strategyEntity.ruleModels();
        if(null == ruleModels || ruleModels.length == 0){
            return logicChainGroup.get("default");
        }
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for(int i = 1;i < ruleModels.length;i++){
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current.appendNext(nextChain);
            current = current.next();
        }
        current.appendNext(logicChainGroup.get("default"));
        return logicChain;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO{
        /*抽奖奖品Id*/
        private Integer awardId;
        /*抽奖奖品规则*/
        private String logicModel;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_DEFAULT("default", "默认抽奖"),
        RULE_BLACKLIST("rule_blacklist", "黑名单抽奖"),
        RULE_WEIGHT("rule_weight", "权重规则"),
        ;

        private final String code;
        private final String info;

    }

}
