package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.dto.request.TodoRequestDto;
import com.example.demo.dto.response.TodoResponseDto;
import com.example.demo.entity.Todo;
import com.example.demo.entity.User;

@Component
public class TodoMapper {

    public Todo toEntity(TodoRequestDto dto, User user) {
        return Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .dueDate(dto.getDueDate())
                .createdAt(LocalDateTime.now())
                .completed(false)
                .user(user)
                .build();
    }

    public TodoResponseDto toDto(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .dueDate(todo.getDueDate())
                .createdAt(todo.getCreatedAt())
                .build();
    }
}
