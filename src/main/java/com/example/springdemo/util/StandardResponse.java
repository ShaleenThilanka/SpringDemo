package com.example.springdemo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
