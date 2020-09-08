package com.yc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.Root;
import com.yc.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RootController {

    @Autowired
    private RootService rootService;

    private ObjectMapper mapper = new ObjectMapper();



    /**
     * 登录
     *
     * @param root
     * @param request
     * @return
     */
    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    @ResponseBody // 使用这个前端才能接收到 login.html
    public Map<String, String> checklogin(Root root, HttpServletRequest request, HttpServletResponse response) {
        //新建一个session 是存放服务器中的
        HttpSession session = request.getSession();
        Root root1 = null;
        Map map = new HashMap<String, String>();
        // 调用service方法
        root1 = rootService.login(root);
        //     System.out.println(root1.getRid()); 不能有 没有数据时会爆500错误
        if (root1 != null) {
            map.put("result", "成功");
            session.setAttribute("root", root1);
            Cookie rname = new Cookie("rname", root1.getRname());
            Cookie email = new Cookie("email", root1.getEmail());
            rname.setMaxAge(3600);
            email.setMaxAge(3600);
            rname.setPath(request.getContextPath() + "/page/admin/");
            email.setPath(request.getContextPath() + "/page/admin/");
            response.addCookie(rname);
            response.addCookie(email);
            //System.out.println(session.toString() + "    " + session.getId() + " --" + session.getAttribute("root"));
        } else {
            map.put("result", "失败");
        }
        return map;
    }


    @RequestMapping("/outLogin")
    @ResponseBody
    public Map outLogin(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap<String, String>();
        //通过session.invalidata()方法来注销当前的session
        request.getSession().invalidate();
        Cookie rname = new Cookie("rname", "");
        rname.setMaxAge(0);
        rname.setPath(request.getContextPath() + "/page/admin/");
        response.addCookie(rname);
        map.put("result", "200");
        return map;
    }


    /**
     * 查找相应的数据集合
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/root/show")
    @ResponseBody //将数据转成json的注解
    public String show(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "limit", required = false) String limit) throws JsonProcessingException {
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 1L;
        //创建一个jackson的对象映射器，用来解析数据
        List<Root> rootList = rootService.findRoot(tag, rows);
        count = rootService.getTotalRoot();
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(rootList) + "}";
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
    }


    @RequestMapping(value = "/root/addroot", method = RequestMethod.POST)
    public Map<String, String> addroot(Root root) {
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        // System.out.println("Controller表现层：添加指定root.."+root.toString());
        int rootAdd = 0;
        rootAdd = rootService.addRoot(root);
        if (rootAdd > 0) {
            map.put("result", "提交成功");
        } else {
            map.put("result", "提交失败");
        }
        return map;
    }


    @RequestMapping(value = "/root/selectByrname", method = RequestMethod.POST)
    public Map selectByrname(String rname) {
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        //  System.out.println("Controller表现层：添加指定root.."+root.toString());
        int rootAdd = 0;
        try {

        } catch (Exception e) {
            map.put("result", "提交失败");
        }
        if (rootAdd > 0) {
            map.put("result", "提交成功");
        } else {
            map.put("result", "提交失败");
        }
        //System.out.println(map.toString());
        return map;
    }

    /**
     * 删除
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/root/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> del(String rid) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(rid)) {
            int id = Integer.parseInt(rid);
            i = rootService.deleteRoot(id);
        }
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        return map;
    }

    /**
     * 修改密码
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/root/uppwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uppwd(@RequestParam(value = "old_pwd", required = false) String old_pwd, @RequestParam(value = "new_pwd", required = false) String new_pwd,
                                     HttpSession session) {
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        Root root = (Root) session.getAttribute("root");
        if (root != null) {
            int up = 0;
            int id = root.getRid();
            up = rootService.updatePwd(old_pwd, new_pwd, id);
            if (up > 0) {
                map.put("result", "成功");
            } else {
                map.put("result", "失败");
            }
        } else {
            map.put("result", "请先登录");
        }
        return map;
    }
}
