package com.example.multidatasourceexample.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExampleResponse {
    String firstDatabaseResult;
    String secondDatabaseResult;
}
