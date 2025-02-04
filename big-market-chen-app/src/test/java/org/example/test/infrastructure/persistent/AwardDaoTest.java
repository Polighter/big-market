package org.example.test.infrastructure.persistent;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.persistent.dao.IAwardDao;
import org.example.infrastructure.persistent.po.Award;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {
    @Resource
    private IAwardDao iAwardDao;

    @Test
    public void test_queryAwardList(){
        List<Award> query = iAwardDao.queryAwardList();
        log.info("测试结果：{}", JSON.toJSONString(query));
    }
}
