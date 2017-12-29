package com.allei;

import javax.annotation.Resource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * @author alleiming 2017/12/28 下午7:15
 */
@EnableBinding(MsgProducer.SinkOutput.class)
public class MsgProducer {

    public interface SinkOutput {
        String OUTPUT = "input";

        @Output(SinkOutput.OUTPUT)
        MessageChannel messageChannel();
    }

    @Resource(name = "input")
    private MessageChannel messageChannel;

    public void sendMsg(String msg) {
        messageChannel.send(MessageBuilder.withPayload(msg).build());
    }

}
