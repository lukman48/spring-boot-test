package com.lukman48.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  @NotEmpty()
  private String name;

  @Column(nullable=false, unique=true)
  @NotEmpty
  @Email(message="{errors.invalid_email}")
  private String email;

  @Column(nullable=false)
  @NotEmpty
  @Size(min=4)
  private String password;

  @OneToMany(mappedBy="user",cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  private List<Role> roles;

  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  public List<Role> getRoles()
  {
    return roles;
  }
  public void setRoles(List<Role> roles)
  {
    this.roles = roles;
  }

  public User(Long id, String name, String email, String password){
    super();
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
  }
}
