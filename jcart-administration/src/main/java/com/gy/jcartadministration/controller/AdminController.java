package com.gy.jcartadministration.controller;

import com.gy.jcartadministration.dto.in.*;
import com.gy.jcartadministration.dto.out.AdminGetProfileOutDTO;
import com.gy.jcartadministration.dto.out.AdminListOutDTO;
import com.gy.jcartadministration.dto.out.AdminShowOutDTO;
import com.gy.jcartadministration.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interview")
public class AdminController {

    //管理员登录页面
    @GetMapping("/login")
    public String login(AdminLoginDTO adminLoginDTO){
        return null;
    }

    //获取管理员编辑页信息
    @GetMapping("/getProfile")
    public AdminGetProfileOutDTO getProfile(@RequestParam(required = false) Integer administrator_id){
        return null;
    }
    //编辑管理员页面
    @PostMapping("/updateProdfile")
    public void updatePro(@RequestBody AdminUpdateProfileDTO adminUpdateProfileDTO){

    }
    //传入重置的密码
    @GetMapping("/getPwdRestCode")
    public String getPwdRest(@RequestParam String email){
        return null;
    }
    //重置新的密码
    @PostMapping("/restPwd")
    public void restPwd(@RequestBody AdminRestPwdInDTO adminRestPwdInDTO){

    }

    //获取列表
    @GetMapping("/UserList")
    public PageOutDTO<AdminListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public AdminShowOutDTO getBYId(@RequestParam Integer administrator_id){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AdminCreateInDTO adminCreateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdminUpdateInDTO adminUpdateInDTO){

    }
}
