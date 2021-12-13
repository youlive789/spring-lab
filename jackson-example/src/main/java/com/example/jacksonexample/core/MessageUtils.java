package com.example.jacksonexample.core;

import com.example.jacksonexample.inheritance.domain.ChildMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageUtils {

    public BaseMessage getBaseMessage() {
        BaseMessage baseMessage = new BaseMessage();
        BaseMessage.BaseNestedMessage baseNestedMessage = new BaseMessage.BaseNestedMessage();
        BaseMessage.BaseNestedMessage.BaseDoublyNestedMessage baseDoublyNestedMessage = new BaseMessage.BaseNestedMessage.BaseDoublyNestedMessage();

        baseNestedMessage.setBaseDoublyNestedMessage(baseDoublyNestedMessage);
        baseNestedMessage.setBaseDoublyNestedMessageMustBeIgnored(baseDoublyNestedMessage);

        baseMessage.setBaseNestedMessage(baseNestedMessage);
        baseMessage.setBaseNestedMessageMustBeIgnored(baseNestedMessage);

        return baseMessage;
    }

    public ChildMessage baseToChild(BaseMessage baseMessage) {
        ChildMessage childMessage = new ChildMessage();
        childMessage.setBaseProperty(baseMessage.getBaseProperty());
        childMessage.setBaseNestedMessage(baseMessage.getBaseNestedMessage());
        childMessage.setBasePropertyMustBeIgnored(baseMessage.getBasePropertyMustBeIgnored());
        childMessage.setBaseNestedMessage(baseMessage.getBaseNestedMessage());
        childMessage.setBaseNestedMessageMustBeIgnored(baseMessage.getBaseNestedMessageMustBeIgnored());

        childMessage.getBaseNestedMessage().setBaseNestedProperty(baseMessage.getBaseNestedMessage().getBaseNestedProperty());
        childMessage.getBaseNestedMessageMustBeIgnored().setBaseNestedProperty(baseMessage.getBaseNestedMessage().getBaseNestedProperty());

        childMessage.getBaseNestedMessage().setBaseDoublyNestedMessage(baseMessage.getBaseNestedMessage().getBaseDoublyNestedMessage());
        childMessage.getBaseNestedMessage().setBaseDoublyNestedMessageMustBeIgnored(baseMessage.getBaseNestedMessage().getBaseDoublyNestedMessage());

        return childMessage;
    }
}
