package org.example.domain.strategy.service.rule.filter.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.strategy.model.entity.RuleActionEntity;
import org.example.domain.strategy.service.annotation.LogicStrategy;
import org.example.domain.strategy.service.rule.filter.ILogicFilter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    /*通过注解这种方式，DefaultLogicFactory 可以根据逻辑模式的代码快速找到对应的逻辑过滤器。*/
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WEIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY","Before"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回","Before"),
        RUlE_WHITELIST("rule_whitelist","【抽奖前规则】白名单规则过滤，命中白名单直接返回","Before"),
        RULE_LOCK("rule_lock","【抽奖中规则】抽奖n次后对应奖品可解锁抽奖","Center"),
        RULE_LUCK_AWARD("rule_luck_award","【抽奖后规则】根据是否有库存来发放兜底奖品","After")

        ;

        private final String code;
        private final String info;
        private final String type;

        public static boolean isCenter(String code){
            return "Center".equals(LogicModel.valueOf(code.toUpperCase()).getType());
        }
        public static boolean isAfter(String code){
            return "After".equals(LogicModel.valueOf(code.toUpperCase()).getType());
        }

    }

}
