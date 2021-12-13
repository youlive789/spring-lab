package com.example.jacksonexample.inheritance.domain;

import com.example.jacksonexample.core.BaseMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"basePropertyMustBeIgnored", "baseNestedMessageMustBeIgnored"})
public class ChildMessage extends BaseMessage {
    String childProperty;

    @Override
    public BaseNestedMessage getBaseNestedMessage() {
        ChildNestedMessage childNestedMessage = new ChildNestedMessage();
        return childNestedMessage;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties({"baseNestedPropertyMustBeIgnored", "baseDoublyNestedMessageMustBeIgnored"})
    public static class ChildNestedMessage extends BaseNestedMessage {
        String childNestedProperty;

        @Override
        public BaseDoublyNestedMessage getBaseDoublyNestedMessage() {
            childDoublyNestedMessage childDoublyNestedMessage = new childDoublyNestedMessage();
            return childDoublyNestedMessage;
        }

        @NoArgsConstructor
        @Getter
        @Setter
        @ToString
        @JsonIgnoreProperties({"baseDoublyNestedPropertyMustBeIgnored"})
        public static class childDoublyNestedMessage extends BaseDoublyNestedMessage {
            String childDoublyNestedProperty;
        }
    }
}
