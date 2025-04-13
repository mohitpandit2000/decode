//package com.decode.decode.service;
//
//import com.decode.decode.entity.User;
//import com.decode.decode.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    UserService userService;
//
//    @Mock
//    UserRepository userRepository;
//
//    @Test
//    public void saveNewUserTest(){
//        User user=new User("ram","ram");
//        userService.saveUser(user);
//        verify(userRepository, times(1)).save(user);
//    }
//
//    @Test
//    public void getAllUserTest(){
//        User user1 = new User("ram","ram");
//        User user2 = new User("shyam","shyam");
//        List<User> mockUsers = Arrays.asList(user1, user2);
//        when(userRepository.findAll()).thenReturn(mockUsers);
//        List<User> result = userService.getAll();
//        assertEquals(2, result.size());
//        assertEquals(mockUsers, result);
//        verify(userRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void findByUserName(){
//        String username = "ram";
//        User user=new User("ram","ram");
//        when(userRepository.findByUserName(username)).thenReturn(user);
//        User result=userService.findByUserName(username);
//        assertEquals(user,result);
//        assertEquals(username,result.getUserName());
//        verify(userRepository, times(1)).findByUserName(username);
//    }
//}
