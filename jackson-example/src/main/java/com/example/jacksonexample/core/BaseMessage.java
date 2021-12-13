package com.example.jacksonexample.core;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseMessage {
    String baseProperty;
    String basePropertyMustBeIgnored;
    BaseNestedMessage baseNestedMessage;
    BaseNestedMessage baseNestedMessageMustBeIgnored;

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class BaseNestedMessage {
        String baseNestedProperty;
        String baseNestedPropertyMustBeIgnored;
        BaseDoublyNestedMessage baseDoublyNestedMessage;
        BaseDoublyNestedMessage baseDoublyNestedMessageMustBeIgnored;

        @NoArgsConstructor
        @Getter
        @Setter
        @ToString
        public static class BaseDoublyNestedMessage {
            String baseDoublyNestedProperty;
            String baseDoublyNestedPropertyMustBeIgnored;
        }
    }
}
