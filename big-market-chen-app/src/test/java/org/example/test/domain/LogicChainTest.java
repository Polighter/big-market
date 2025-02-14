package org.example.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.service.rule.chain.ILogicChain;
import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import org.example.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogicChainTest {

    @Resource
    private DefaultChainFactory defaultChainFactory;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;
    @Test
    public void test_LogicChain_rule_blacklist() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        DefaultChainFactory.StrategyAwardVO awardId = logicChain.logic("user101", 100001L);
        log.info("测试结果：{}", awardId.getAwardId());
    }
    @Test
    public void test_LogicChain_rule_whitelist() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        DefaultChainFactory.StrategyAwardVO awardId = logicChain.logic("cqy", 100001L);
        log.info("测试结果：{}", awardId.getAwardId());
    }

    @Test
    public void test_LogicChain_rule_weight() {
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 7000L);
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        DefaultChainFactory.StrategyAwardVO awardId = logicChain.logic("xiaofuge", 100001L);
        log.info("测试结果：{}", awardId.getAwardId());
    }

    @Test
    public void test_LogicChain_rule_default() {
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 3000L);
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        DefaultChainFactory.StrategyAwardVO awardId = logicChain.logic("xiaofuge", 100001L);
        log.info("测试结果：{}", awardId.getAwardId());
    }
}
