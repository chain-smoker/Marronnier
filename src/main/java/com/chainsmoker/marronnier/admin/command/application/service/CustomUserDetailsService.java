package com.chainsmoker.marronnier.admin.command.application.service;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.Admin;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.AdminDetail;
import com.chainsmoker.marronnier.admin.command.domain.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    @Autowired
    public CustomUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.findAdminByLoginId(username);
//        AdminDetail adminDetail = new AdminDetail(admin);
//        List<SimpleGrantedAuthority> grantedAuthorities = adminDetail.getAuthorities().stream().map(authority -> {
//            return new SimpleGrantedAuthority(admin.getRole().getKey());
//        }).collect(Collectors.toList());
//        return new User(admin.getName(), admin.getPassword(), grantedAuthorities);
        return  new AdminDetail(
                admin.getId(),
                admin.getLoginId(),
                admin.getName(),
                admin.getPassword(),
                admin.getRole()
        );
    }
}
