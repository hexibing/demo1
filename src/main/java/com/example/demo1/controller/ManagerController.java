package com.example.demo1.controller;

import com.example.demo1.ConfigDto.BaseDto;
import com.example.demo1.config.SessionUtil;
import com.example.demo1.dto.AdminUserTokenDto;
import com.example.demo1.dto.ManagerDto;
import com.example.demo1.model.Manager;
import com.example.demo1.service.IManagerService;
import com.example.demo1.service.IUserService;
import com.example.demo1.util.ShiroUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private static Logger log= Logger.getLogger(ManagerController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IManagerService managerService;


    @Autowired
    private SessionUtil sessionUtil;
    /**
     * 登录
     *
     * @PARAM REQUEST
     * @PARAM RESPONSE
     * @RETURN
     * @THROWS IOEXCEPTION
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ManagerDto login(@RequestBody @Validated Manager vo, BindingResult bindingResult,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info(vo.getManagerCode()+"=="+vo.getManagerPassword());
        Subject subject = ShiroUtil.getSubject();
        AdminUserTokenDto token = new AdminUserTokenDto(vo.getManagerCode(),vo.getManagerPassword());
        subject.login(token);

        Long managerId = managerService.getMangerByManagerCode(vo.getManagerCode()).getId();

        ShiroUtil.setSessionAttribute("managerId", managerId);

        return managerService.getManagerDtoById(managerId);
    }

    /**
     * 登录
     *
     * @PARAM REQUEST
     * @PARAM RESPONSE
     * @RETURN
     * @THROWS IOEXCEPTION
     */
    @RequestMapping(value = "/mocLogin.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ManagerDto mocLogin(@RequestBody @Validated Manager vo, BindingResult bindingResult,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info(vo.getManagerCode()+"=="+vo.getManagerPassword());
        Subject subject = ShiroUtil.getSubject();
        AdminUserTokenDto token = new AdminUserTokenDto(vo.getManagerCode());
        subject.login(token);

        Long managerId = managerService.getMangerByManagerCode(vo.getManagerCode()).getId();

        ShiroUtil.setSessionAttribute("managerId", managerId);

        return managerService.getManagerDtoById(managerId);
    }


    /**
     * 登出
     *
     * @param session
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/logout.do", method=RequestMethod.POST)
    @ResponseBody
    public BaseDto logout(HttpSession session, HttpServletResponse response) throws IOException {
        ShiroUtil.logout();

        Long managerId = sessionUtil.getManagerId(session);
        log.info("----------logout start----------");
        session.invalidate();
        log.info("----------logout end----------");
        return new BaseDto(true);
    }

    // @RequestMapping(value = "/addManager.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
     @RequestMapping (value = "/addManager.do",method = {RequestMethod.GET,RequestMethod.POST})
    public BaseDto addManager(@RequestBody  Manager manager){
//        long managerId=sessionUtil.getManagerId(request);
        long managerId=12;
        manager.setDescription(managerId+"操作员ID");
        managerService.addManager(manager);
        return  new BaseDto(true);
    }


    @RequestMapping(value = "/noauth", method = RequestMethod.GET)
    public String noauth(){
        return  "没有权限";
    }


}
