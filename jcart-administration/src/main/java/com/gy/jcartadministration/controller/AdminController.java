package com.gy.jcartadministration.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.Page;
import com.gy.jcartadministration.constant.ClientExceptionConstant;
import com.gy.jcartadministration.dto.in.*;
import com.gy.jcartadministration.dto.out.*;
import com.gy.jcartadministration.exception.ClientException;
import com.gy.jcartadministration.po.Administrator;
import com.gy.jcartadministration.service.AdminService;
import com.gy.jcartadministration.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrator")
@CrossOrigin
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
    public AdminGetProfileOutDTO getProfile(@RequestAttribute Integer administratorId){
        Administrator administrator = adminService.getById(administratorId);
        AdminGetProfileOutDTO adminGetProfileOutDTO = new AdminGetProfileOutDTO();
        adminGetProfileOutDTO.setAdministratorId(administrator.getAdministratorId());
        adminGetProfileOutDTO.setUsername(administrator.getUsername());
        adminGetProfileOutDTO.setRealName(administrator.getRealName());
        adminGetProfileOutDTO.setEmail(administrator.getEmail());
        adminGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        adminGetProfileOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());

        return adminGetProfileOutDTO;
    }
    //编辑管理员页面
    @PostMapping("/updateProdfile")
    public void updatePro(@RequestBody AdminUpdateProfileDTO adminUpdateProfileDTO,
                          @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setRealName(adminUpdateProfileDTO.getRealName());
        administrator.setEmail(adminUpdateProfileDTO.getEmail());
        administrator.setAvatarUrl(adminUpdateProfileDTO.getAvatarUrl());
        adminService.update(administrator);
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
    public PageOutDTO<AdminListOutDTO> getList(@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Administrator> page = adminService.getList(pageNum);
        List<AdminListOutDTO> administratorListOutDTOS = page.stream().map(administrator -> {
            AdminListOutDTO adminListOutDTO = new AdminListOutDTO();
            adminListOutDTO.setAdministratorId(administrator.getAdministratorId());
            adminListOutDTO.setUsername(administrator.getUsername());
            adminListOutDTO.setStatus(administrator.getStatus());
            adminListOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
            return adminListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<AdminListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(administratorListOutDTOS);

        return pageOutDTO;
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
