package com.example.demo.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoRequestDto {
    private String title;
    private String description;
    private LocalDateTime dueDate;
}
