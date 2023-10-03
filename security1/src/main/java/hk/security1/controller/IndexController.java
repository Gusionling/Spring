package hk.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller //view를 리턴하겠다!!
public class IndexController {

    @GetMapping({"", "/"})
    public String index(){
        //머스테치 기본폴더 src/main/resources/
        //뷰리졸버 설정 : templates (prefix), .mustache(suffix)
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }

    //spring security가 낚아챔 - spring security file을 만드니 작동하지 않음
    @ResponseBody
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @ResponseBody
    @GetMapping("/joinProc")
    public String joinProc(){
        return "회원가입 완료됨!";
    }
}
