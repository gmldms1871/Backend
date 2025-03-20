package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String findUser() { // ✅ 오타 수정 (finUser → findUser)
        return "User from Repository";
    }
}
