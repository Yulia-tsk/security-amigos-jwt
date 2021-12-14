package com.securityamigos.securityamigosjwt.auth;

import com.google.common.collect.Lists;
import com.securityamigos.securityamigosjwt.secutiry.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.securityamigos.securityamigosjwt.secutiry.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserService implements ApplicationUserDao{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> findByApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser ->
                username.equals(applicationUser.getUsername())).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        "annasmith",
                        passwordEncoder.encode("password"),
                        true, true, true, true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password"),
                        true, true, true, true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password"),
                        true, true, true, true
                )
        );

        return applicationUsers;
    }

//    public Set<ApplicationUser> getApplicationUsers(){
//        Set<ApplicationUser>applicaionUsers = (Set<ApplicationUser>) Lists.newArrayList(
//                new ApplicationUser(
//                        ApplicationUserRole.STUDENT.getGrantedAuthorities(),
//                        "annasmith",
//                        passwordEncoder.encode("password"),
//                        true, true, true, true
//                ),
//                new ApplicationUser(
//                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
//                        "linda",
//                        passwordEncoder.encode("password"),
//                        true, true, true, true
//                ),
//                new ApplicationUser(
//                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
//                        "tom",
//                        passwordEncoder.encode("password"),
//                        true, true, true, true
//                )
//        );
//        return getApplicationUsers();
//    }
}
