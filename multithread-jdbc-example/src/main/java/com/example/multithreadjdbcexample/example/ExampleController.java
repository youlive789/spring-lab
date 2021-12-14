package com.example.multithreadjdbcexample.example;

import com.example.multithreadjdbcexample.example.domain.ClearResponse;
import com.example.multithreadjdbcexample.example.domain.ExecutedTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ExampleController {
    final private ExampleService exampleService;

    @GetMapping("/normal")
    public ExecutedTimeResponse noraml() {
        return exampleService.normalInsert();
    }

    @GetMapping("/threaded")
    public ExecutedTimeResponse threaded() {
        return exampleService.multiThreaedInsert();
    }

    @GetMapping("/clear")
    public ClearResponse clear() {
        return exampleService.clear();
    }
}
