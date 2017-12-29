package com.allei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author alleiming 2017/12/28 下午6:57
 */
@EnableBinding(Sink.class)
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Sink.INPUT)
    public void consume(Object msg) {
        logger.info(String.valueOf(msg).toString());
    }

}
