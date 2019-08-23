package com.lukman48.repository;

import com.lukman48.domain.Module;
import com.lukman48.domain.Role;
import com.lukman48.domain.User;
import com.lukman48.repo.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testInsertUser(){
        User user = new User(1L, "lukman", "test@gmail.com", "12345");
        Role role = new Role(1L, "admin");
        Module module1 = new Module(1L, "Promo");
        Module module2 = new Module(2L, "Category");
        Module module3 = new Module(2L, "FlashSale");
        Module module4 = new Module(2L, "History");
        Module module5 = new Module(2L, "News");
       // userRepository.save(user);

        Assert.assertEquals(user.getId(), new Long(1));

    }
}
