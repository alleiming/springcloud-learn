package com.allei;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author alleiming 2017/12/28 下午7:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
//@WebAppConfiguration
public class ProviderApplicationTest {

    @Resource
    private MsgProducer msgProducer;

    @Test
    public void testSend(){
        msgProducer.sendMsg("hello-world");
    }
}
