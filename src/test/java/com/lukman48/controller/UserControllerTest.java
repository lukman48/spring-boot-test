package com.lukman48.controller;

import com.lukman48.UserController;
import com.lukman48.domain.Module;
import com.lukman48.domain.Role;
import com.lukman48.domain.User;
import com.lukman48.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testUserFindById() throws Exception {
        //Preparation
        Mockito.when(userRepository.findById(anyLong())).
                thenReturn(
                        Optional.of(new User(1L, "lukman", "test@gmail.com", "12345")));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/1"));

    }
    @Test
    public void testUserFindByName() throws Exception {
        //Prepare Data
        Module module1 = new Module(1L, "Promo");
        Module module2 = new Module(2L, "Category");
        Module module3 = new Module(2L, "FlashSale");
        Module module4 = new Module(2L, "History");
        Module module5 = new Module(2L, "News");

        List<Module> modules= new ArrayList<>();
        modules.add(module1);
        modules.add(module2);
        modules.add(module3);
        modules.add(module4);
        modules.add(module5);

        Role role = new Role(1L, "admin");
        role.setModules(modules);

        List<Role> roles= new ArrayList<>();
        roles.add(role);

        User user = new User(1L, "lukman", "test@gmail.com", "12345");
        user.setRoles(roles);

        //Preparation
        Mockito.when(userRepository.findByName(anyString())).
                thenReturn(
                        Optional.of(user));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/byName/lukman"));

    }
}
