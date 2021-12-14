package com.securityamigos.securityamigosjwt.auth;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserDao {

    Optional<ApplicationUser> findByApplicationUserByUsername(String username);
}
