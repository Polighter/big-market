package org.example.domain.strategy.service.raffle;

import org.example.domain.strategy.model.VO.RuleTreeVO;
import org.example.domain.strategy.model.VO.StrategyAwardRuleModelVO;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.AbstractRaffleStrategy;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.ILogicChain;
import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import org.example.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import org.springframework.stereotype.Service;

@Service
public class DefaultRaffleStrategy extends AbstractRaffleStrategy {


    public DefaultRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory,DefaultTreeFactory defaultTreeFactory) {
        super(repository, strategyDispatch, defaultChainFactory,defaultTreeFactory);
    }

    @Override
    public DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId) {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        return logicChain.logic(userId, strategyId);
    }

    @Override
    public DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId) {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(strategyId, awardId);
        if (null == strategyAwardRuleModelVO) {
            return DefaultTreeFactory.StrategyAwardVO.builder().awardId(awardId).build();
        }
        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId(strategyAwardRuleModelVO.getRuleModels());
        if (null == ruleTreeVO) {
            throw new RuntimeException("存在抽奖策略配置的规则模型 Key，未在库表 rule_tree、rule_tree_node、rule_tree_line 配置对应的规则树信息 " + strategyAwardRuleModelVO.getRuleModels());
        }
        IDecisionTreeEngine treeEngine = defaultTreeFactory.openLogicTree(ruleTreeVO);
        return treeEngine.process(userId, strategyId, awardId);
    }
}
