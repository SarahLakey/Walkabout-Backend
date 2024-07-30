package org.launchcode.Walkabout_Backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Data
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "username", nullable = false, unique = true)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "verifyPassword")
    private String verifyPassword;

    @Column(name = "email")
    private String email;

 //    @Column
//    private String role; //ADMIN,USER

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
