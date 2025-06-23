package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * 指定したユーザーIDに紐づくTodoリストを取得するメソッド
     * 
     * @param userId ユーザーのID
     * @return ユーザーIDに関連付けられたTodoのリスト
     */
    List<Todo> findByUser_Id(Long userId);
}
