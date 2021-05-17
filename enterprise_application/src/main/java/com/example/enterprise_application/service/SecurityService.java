package com.example.enterprise_application.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
