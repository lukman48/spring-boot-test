package com.lukman48;

import com.lukman48.domain.User;
import com.lukman48.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/user/{id}")
  public ResponseEntity fooBar(@PathVariable("id") Long id) {
    Optional<User> user = userRepository.findById(id);

    if(user.isPresent()){
      return ResponseEntity.ok(user.get().getRoles());
    }else{
      return ResponseEntity.notFound().build();
    }
  }

  @RequestMapping("/user/byName/{name}")
  public ResponseEntity fooBar(@PathVariable("name") String name) {
    Optional<User> user = userRepository.findByName(name);
    if(user.isPresent()){
      if(user.get().getRoles().size() > 0) {
        return ResponseEntity.ok(user.get().getRoles().get(0).getModules());
      }else{
        return ResponseEntity.notFound().build();
      }
    }else{
      return ResponseEntity.notFound().build();
    }
  }

}
