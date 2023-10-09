package hk.security1.controller;

import hk.security1.model.User;
import hk.security1.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller //view를 리턴하겠다!!
@AllArgsConstructor
public class IndexController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public String index() {
        //머스테치 기본폴더 src/main/resources/
        //뷰리졸버 설정 : templates (prefix), .mustache(suffix)
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    //spring security가 낚아챔 - spring security file을 만드니 작동하지 않음

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }


    @PostMapping("/join")
    public String join(User user) {
        log.info(String.valueOf(user));
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        //인코딩(암호화)를 해줘야지만 spring security가 작동한다.
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);

        return "redirect:/loginForm";
    }

    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }
}
