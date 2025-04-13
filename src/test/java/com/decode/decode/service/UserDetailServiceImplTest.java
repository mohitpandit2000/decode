package com.decode.decode.service;

import com.decode.decode.entity.User;
import com.decode.decode.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailServiceImplTest {

    UserDetailServiceImpl userDetailServiceImpl;

    @Mock
    UserRepository userRepository;

//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public  void loadUserByUsernameTest(){
        User user=new User("ram","ram");
        user.setRoles(List.of("USER"));
        when(userRepository.findByUserName("ram")).thenReturn(user);
        UserDetails actual=userDetailServiceImpl.loadUserByUsername("ram");
        assertNotNull(actual);
    }
}
