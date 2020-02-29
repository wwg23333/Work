package com.gy.jcartadministration.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gy.jcartadministration.constant.ClientExceptionConstant;
import com.gy.jcartadministration.dto.in.*;
import com.gy.jcartadministration.dto.out.*;
import com.gy.jcartadministration.exception.ClientException;
import com.gy.jcartadministration.po.Administrator;
import com.gy.jcartadministration.service.AdminService;
import com.gy.jcartadministration.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interview")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JWTUtil jwtUtil;

    //管理员登录页面
    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdminLoginDTO adminLoginDTO)throws ClientException {

        Administrator administrator = adminService.getByUsername(adminLoginDTO.getUsername());
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encPwdDB = administrator.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(adminLoginDTO.getPassword().toCharArray(), encPwdDB);

        if (result.verified) {
            AdministratorLoginOutDTO adminLoginOutDTO = jwtUtil.issueToken(administrator);

            return adminLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
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
