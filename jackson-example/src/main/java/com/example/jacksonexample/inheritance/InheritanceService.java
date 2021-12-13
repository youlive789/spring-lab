package com.example.jacksonexample.inheritance;

import com.example.jacksonexample.core.BaseMessage;
import com.example.jacksonexample.core.MessageUtils;
import com.example.jacksonexample.inheritance.domain.ChildMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InheritanceService {
    final private MessageUtils messageUtils;

    public BaseMessage getBaseMessage() {
        return messageUtils.getBaseMessage();
    }

    public ChildMessage getChildMessage() {
        return messageUtils.baseToChild(messageUtils.getBaseMessage());
    }
}
