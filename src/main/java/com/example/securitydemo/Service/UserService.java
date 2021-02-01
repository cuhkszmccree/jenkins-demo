package com.example.securitydemo.Service;

import com.example.securitydemo.Domain.User;
import com.example.securitydemo.Repository.UserRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    private GrantedAuthority Defalut_grantedAuthority = new SimpleGrantedAuthority("USER");


    @Override
    public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
        User user = userRepository.findOneByusername(UserName);
        if(user == null){
            throw new UsernameNotFoundException("User " + UserName + " not found");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        String Role = user.getRole();
        System.out.println(Role);
        if(StringUtils.isNullOrEmpty(Role)){
            grantedAuthorityList.add(Defalut_grantedAuthority);
        }
        else{
            for(String S: Role.split(",")){
                grantedAuthorityList.add(new SimpleGrantedAuthority(S));
            }
        }
        System.out.println(grantedAuthorityList);
        return new org.springframework.security.core.userdetails.User(UserName,user.getPassword(),grantedAuthorityList);
    }
}
