package com.page.demo.controller;


import com.page.demo.model.Member;
import com.page.demo.repositories.MemberRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Spirng data JPA Test "}) // swagger에 표시되는 제목
@RestController
@RequestMapping("/")
public class SampleAPIController {

    @Autowired
    private MemberRepository memberRepository;

    @ApiOperation(value = "특정 회원 조회", notes = "특정 회원을 조회한다")
    @RequestMapping(method = RequestMethod.GET, path = "/memberInfo/{memberNo}")
    public Member getMemberInfo(@ApiParam(value = "회원번호", required = true) @PathVariable Long memberNo){
        return memberRepository.findById(memberNo).orElse(null);
    }


    @ApiOperation(value = "전체 회원 조회", notes = "전체 회원을 조회한다")
    @RequestMapping(method = RequestMethod.GET, path = "/allMemberInfo")
    public List<Member> getAllMemberInfo(){
        return memberRepository.findAll();
    }

    @ApiOperation(value = "회원 입력", notes = "회원 정보를 입력한다")
    @RequestMapping(method = RequestMethod.POST, path = "/memberInfo")
    public String insertMemberInfo(@ApiParam(value = "회원 아이디", required = true)  @RequestBody Member member ){

        return memberRepository.save(member).toString();
    }

    @ApiOperation(value = "회원 수정", notes = "회원 정보를 수정한다")
    @RequestMapping(method = RequestMethod.PUT, path = "/memberInfo/{memberNo}")
    public String updateMemberInfo(@ApiParam(value = "회원번호", required = true) @PathVariable Long memberNo ,
                                   @ApiParam(value = "회원 아이디", required = true)  @RequestBody Member member ){

        Member memberTemp = memberRepository.findById(memberNo).orElse(null);
        if(memberTemp == null) return "wrong member number ";
        memberTemp.setId(member.getId());
        memberTemp.setName(member.getName());
        memberRepository.flush();

        return memberTemp.toString();
    }


    @ApiOperation(value = "회원 삭제", notes = "회원 정보를 삭제한다")
    @RequestMapping(method = RequestMethod.DELETE, path = "/memberInfo/{memberNo}")
    public String deleteMemberInfo( @ApiParam(value = "회원번호", required = true) @PathVariable Long memberNo ){

        memberRepository.delete(memberRepository.findById(memberNo).orElse(null));
        return "Success";
    }

}
