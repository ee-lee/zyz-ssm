package com.yc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.Juser;
import com.yc.pojo.User;
import com.yc.service.JuserService;
import com.yc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JuserService juserService;
    private static final Logger log = Logger
            .getLogger(UserController.class);// 日志文件
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 查找相应的数据集合
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    @ResponseBody //将数据转成json的注解
    public String show(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "limit", required = false) String limit,
                       @RequestParam(value = "name", required = false) String uname
    ) throws JsonProcessingException {
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<User> userList;
        if ("".equals(uname) || uname == null) {
            //创建一个jackson的对象映射器，用来解析数据
            userList = userService.findUser(tag, rows);
            count = userService.getTotalUser();
        } else {
            //创建一个jackson的对象映射器，用来解析数据
            userList = userService.findUserByuname(uname, tag, rows);
            count = userService.getTotalUserByuname(uname);
        }
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(userList) + "}";
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
    }

    /**
     * 街道管理员的权限
     * 只能查看属于本街道的志愿者用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/shows1")
    @ResponseBody //将数据转成json的注解
    public String shows1(@RequestParam(value = "page", required = false) String page,
                         @RequestParam(value = "limit", required = false) String limit,
                         @RequestParam(value = "name", required = false) String uname,
                         HttpSession session
    ) throws JsonProcessingException {

        Juser juser = (Juser) session.getAttribute("juser");
        int jids = juser.getJid();
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<User> userList;
        System.out.println("当前是街道管理员ID："+jids+"登录系统");
        //创建一个jackson的对象映射器，用来解析数据
        userList = userService.selectByJid(jids, tag, rows);
        count = userService.getTotalUserByuname(uname);
//        }
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(userList) + "}";
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
    }

    /**
     * 删除
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> del(String uid) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(uid)) {
            int id = Integer.parseInt(uid);
            i = userService.deleteUser(id);
        }
        log.info("request: activity/delete , aid: " + uid);
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        // System.out.println(map.toString());
        return map;
    }


    /**
     * 管理员 更新账号状态
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> up(@RequestParam(value = "uissys", required = false) String uissys,
                                  @RequestParam(value = "uid", required = false) String uid) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(uid) && !"".equals(uissys)) {
            int id = Integer.parseInt(uid);
            int issy = Integer.parseInt(uissys);
            i = userService.updateUissys(issy, id);
        }
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        return map;
    }


    /**
     * 查询用户数量
     * 查询街道员数量
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/welconme", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> welcome() {
        Map<String, String> map = new HashMap<>();
        long count = userService.getTotalUser();
        long yes = userService.getUserToWelcome(1);
        long no = userService.getUserToWelcome(0);
        long jusercount = juserService.getTotalJuser();
        map.put("count", count + "");
        map.put("yes", yes + "");
        map.put("no", no + "");
        map.put("jusercount", jusercount + "");
        return map;
    }


}
