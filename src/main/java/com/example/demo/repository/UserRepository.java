package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);

    // 参加者取得に使われる findAllById(List<Long> ids) はJPAに既に存在しているためOK
}

