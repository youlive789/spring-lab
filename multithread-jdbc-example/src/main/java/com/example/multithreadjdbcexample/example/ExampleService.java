package com.example.multithreadjdbcexample.example;

import com.example.multithreadjdbcexample.example.domain.ClearResponse;
import com.example.multithreadjdbcexample.example.domain.ExecutedTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Service
public class ExampleService {

    final private int INSERT_COUNT = 100;
    final private int THREAD_COUNT = 5;
    final private JdbcTemplate jdbcTemplate;

    public ExecutedTimeResponse normalInsert() {
        StopWatch tableWatch = new StopWatch();
        tableWatch.start();

        for (int i = 0; i < INSERT_COUNT; ++i) {
            sleepInsert();
        }

        tableWatch.stop();

        ExecutedTimeResponse executedTimeResponse = new ExecutedTimeResponse();
        executedTimeResponse.setExcutedTime(String.valueOf(tableWatch.getTotalTimeSeconds()));
        return executedTimeResponse;
    }

    public ExecutedTimeResponse multiThreaedInsert() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Callable<Void>> taskList = new ArrayList<>();

        StopWatch tableWatch = new StopWatch();
        tableWatch.start();

        int totalPage = INSERT_COUNT / THREAD_COUNT;
        for (int page = 0; page < totalPage; ++page) {

            // 쓰레드 개수만큼 Callable 적재
            for (int i = 0; i < THREAD_COUNT; ++i) {
                taskList.add(() -> {
                    sleepInsert();
                    return null;
                });
            }

            // 쓰레드 개수만큼 담아둔 작업리스트 실행
            try {
                executorService.invokeAll(taskList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            taskList.clear();
        }

        tableWatch.stop();

        ExecutedTimeResponse executedTimeResponse = new ExecutedTimeResponse();
        executedTimeResponse.setExcutedTime(String.valueOf(tableWatch.getTotalTimeSeconds()));
        return executedTimeResponse;
    }

    private void sleepInsert() {
        try {
            Thread.sleep(100L);
            String query = "INSERT INTO example VALUES (?)";
            jdbcTemplate.update(query, "foo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ClearResponse clear() {
        String truncQuery = "TRUNCATE TABLE example";
        jdbcTemplate.update(truncQuery);

        String CountQuery = "SELECT COUNT(*) FROM example";
        Integer count = jdbcTemplate.queryForObject(CountQuery, Integer.class);

        ClearResponse clearResponse = new ClearResponse();
        clearResponse.setCount(count);

        return clearResponse;
    }
}
