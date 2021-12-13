package com.example.jacksonexample.inheritance;

import com.example.jacksonexample.core.BaseMessage;
import com.example.jacksonexample.inheritance.domain.ChildMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: 손쉽게 부모 인스턴스에서 자식 인스턴스로 전환시킬 방법이 필요

@RestController
@RequiredArgsConstructor
public class InheritanceController {

    final private InheritanceService inheritanceService;

    @GetMapping("/base")
    public BaseMessage base() {
        return inheritanceService.getBaseMessage();
    }

    @GetMapping("/child")
    public ChildMessage child() {
        return inheritanceService.getChildMessage();
    }

}
