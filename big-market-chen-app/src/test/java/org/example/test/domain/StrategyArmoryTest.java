package org.example.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.service.armory.IStrategyArmory;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private IStrategyDispatch strategyDispatch;
    @Test
    public void test_strategyArmory(){
        strategyArmory.assembleLotteryStrategy(100001L);
    }

    @Test
    public void test_getAssembleRandomVal(){
        log.info("测试结果{} - 奖品Id" ,strategyDispatch.getRandomAwardId(100001L));
        log.info("测试结果{} - 奖品Id" ,strategyDispatch.getRandomAwardId(100001L));
        log.info("测试结果{} - 奖品Id" ,strategyDispatch.getRandomAwardId(100001L));
    }

    @Test
    public void test_getAssembleRandomVal_ruleWeightValue(){
        log.info("测试结果{} - 4000策略" ,strategyDispatch.getRandomAwardId(100001L,"4000:101,102,103,104"));
        log.info("测试结果{} - 4000策略" ,strategyDispatch.getRandomAwardId(100001L,"4000:101,102,103,104"));
        log.info("测试结果{} - 4000策略" ,strategyDispatch.getRandomAwardId(100001L,"4000:101,102,103,104"));
        log.info("测试结果{} - 6000策略" ,strategyDispatch.getRandomAwardId(100001L,"6000:102,103,104,105,106,107,108,109"));
        log.info("测试结果{} - 6000策略" ,strategyDispatch.getRandomAwardId(100001L,"6000:102,103,104,105,106,107,108,109"));
        log.info("测试结果{} - 6000策略" ,strategyDispatch.getRandomAwardId(100001L,"6000:102,103,104,105,106,107,108,109"));
    }

}
