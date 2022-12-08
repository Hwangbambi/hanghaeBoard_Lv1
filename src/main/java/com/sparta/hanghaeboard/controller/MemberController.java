package com.sparta.hanghaeboard.controller;

import com.sparta.hanghaeboard.dto.MemberRequestDto;
import com.sparta.hanghaeboard.dto.ResponseDto;
import com.sparta.hanghaeboard.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody MemberRequestDto memberRequestDto, Errors errors){
        if (errors.hasErrors()) {
            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            return ResponseEntity.ok(validatorResult);
        }
        memberService.join(memberRequestDto);

        return ResponseEntity.ok(new ResponseDto("회원가입 성공", HttpStatus.OK.value()));
    }

    //로그인
    @PostMapping("/login")
    public ResponseDto login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response){
        return memberService.login(memberRequestDto,response);
    }


}
