package org.example.test;

import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.persistent.redis.IRedisService;
import org.example.infrastructure.persistent.redis.RedissonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private IRedisService redisService;


    @Test
    public void test() {
        RMap<Object, Object> map = redisService.getMap("strategy_id_100001");
        map.put(1,101);
        map.put(2,101);
        map.put(3,101);
        map.put(4,102);
        map.put(5,102);
        map.put(6,102);


        log.info("测试结果{}",redisService.getFromMap("strategy_id_100001",1).toString());
    }

}
