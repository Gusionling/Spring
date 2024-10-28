package com.example.preNews.security.service;

import com.example.preNews.global.exception.CommonException;
import com.example.preNews.global.exception.dto.ErrorCode;
import com.example.preNews.repository.UserRepository;
import com.example.preNews.security.info.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService {
    private final UserRepository userRepository;

    public UserDetails loadByUser(Long id){
        UserRepository.UserSecurityForm user = userRepository.findSecurityFormById(id)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));

        return UserPrincipal.createByUserSecurityForm(user);
    }
}
