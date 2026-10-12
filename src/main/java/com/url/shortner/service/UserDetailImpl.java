package com.url.shortner.service;

import com.url.shortner.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetailImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String userName;
    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailImpl(Long id, String userName, Collection<? extends GrantedAuthority> authorities, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.authorities = authorities;
        this.password = password;
        this.email = email;
    }

    public static UserDetailImpl build(User user){
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new UserDetailImpl(
                user.getId(),
                user.getUsername(),
                Collections.singletonList(authority),
                user.getPassword(),
                user.getEmail()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }
}
