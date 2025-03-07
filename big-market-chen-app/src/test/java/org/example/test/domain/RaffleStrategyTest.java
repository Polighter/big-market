package org.example.test.domain;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.RaffleAwardEntity;
import org.example.domain.strategy.model.entity.RaffleFactorEntity;
import org.example.domain.strategy.service.IRaffleStrategy;
import org.example.domain.strategy.service.armory.IStrategyArmory;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import org.example.domain.strategy.service.rule.tree.impl.RuleLockLogicTreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;

    @Resource
    private RuleLockLogicTreeNode ruleLockLogicTreeNode;


    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IStrategyDispatch strategyDispatch;
    @Resource
    private IRaffleStrategy raffleStrategy;

    @Before
    public void setUp() {
        // 策略装配 100001、100002、100003
//        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100001L));
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100006L));
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 0L);
    }

    @Test
    public void test_performRaffle() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                    .userId("xiaofuge")
                    .strategyId(100006L)
                    .build();
            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
            log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
            log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
        }
        // 等待 UpdateAwardStockJob 消费队列
        new CountDownLatch(1).await();
    }


    @Test
    public void test_performRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user101")  // 黑名单用户 user101
                .strategyId(100001L)
                .build();
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_performRaffle_whitelist(){
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("cqy")  // 白名单用户 cqy
                .strategyId(100001L)
                .build();
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));

    }
    @Test
    public void test_performRaffle_rulelock(){
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("xiaofuge")
                .strategyId(100003L)
                .build();
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }
}
