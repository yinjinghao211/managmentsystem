package com.yjh.redistest;


import com.yjh.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Text {

    public static Logger logger= LoggerFactory.getLogger(Test.class);

    private RedisDao redisDao;
    public void testRedis(){
        redisDao.setKey("name","forezp");
        redisDao.setKey("age","11");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }
}
