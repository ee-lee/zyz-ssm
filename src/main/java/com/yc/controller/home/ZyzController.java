package com.yc.controller.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.*;
import com.yc.service.ActivityService;
import com.yc.service.ScoresService;
import com.yc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/zyz")
public class ZyzController {

    @Resource
    private ActivityService activityService;
    @Resource
    private UserService userService;
    @Resource
    private ScoresService scoresService;
    private static final Logger log = Logger
            .getLogger(ZyzController.class);// 日志文件

    /**
     * 查找相应的数据集合
     * 活动
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    @ResponseBody //将数据转成json的注解
    public String show(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "limit", required = false) String limit,
                       @RequestParam(value = "title", required = false) String title) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<Activity> activityList;
        if ("".equals(title) || title == null) {
            //创建一个jackson的对象映射器，用来解析数据
            activityList = activityService.findActivityByzyz(1, tag, rows);
            count = activityService.getTotalActivityByzyz(1);
        } else {
            activityList = activityService.findActivityBytitle(title, tag, rows);
            count = activityService.getTotalActivityBytitle(title);
        }
        //将我们的对象解析成为json格式
        //为了符合layuimini的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(activityList) + "}";
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        //     前端api格式   { "code":0, "msg":"","count":16, "data": [{ },]}
    }

    /**
     * 查找相应的数据集合
     * 新闻
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/shownews")
    @ResponseBody //将数据转成json的注解
    public String shownews(@RequestParam(value = "page", required = false) String page,
                           @RequestParam(value = "limit", required = false) String limit,
                           @RequestParam(value = "title", required = false) String title) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<Activity> activityList;
        if ("".equals(title) || title == null) {
            //创建一个jackson的对象映射器，用来解析数据
            activityList = activityService.findActivityByzyz(0, tag, rows);
            count = activityService.getTotalActivityByzyz(0);
        } else {
            activityList = activityService.findActivityBytitle(title, tag, rows);
            count = activityService.getTotalActivityBytitle(title);
        }
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(activityList) + "}";
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        //     前端api格式   { "code":0, "msg":"","count":16, "data": [{ },]}

    }

    /**
     * 加入活动
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addscores", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addscores(@RequestParam(value = "aid", required = false) String aid,
                                         HttpSession session) {
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getUissys() == 0) {
                map.put("result", "审核未通过");
                return map;
            }
            Scores scores = new Scores();
            scores.setAid(Integer.parseInt(aid));
            scores.setUid(user.getUid());
            scores.setJid(user.getJid());
            scores.setUstatus(0);
            int scoresAdd = 0;
            scoresAdd = scoresService.addScores(scores);
            if (scoresAdd > 0) {
                map.put("result", "成功");
            } else {
                map.put("result", "失败");
            }
            System.out.println(map.toString());
            return map;
        } else {
            map.put("result", "请先登录");
            return map;
        }
    }

    /**
     * 验证email是否已注册
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/re", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> re(@RequestParam(value = "email", required = false) String email) {

        Map<String, String> map = new HashMap<String, String>();
        int req = 0;
        try {
            req = userService.findemail(email);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (req > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        return map;
    }

    /**
     * 注册
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> adduser(User user) {
        //把日期序列化成yyyy-MM-dd格式的字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegtime(dateFormat.format(new Date()));
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        int userAdd = 0;
        try {
            userAdd = userService.addUser(user);
        } catch (Exception e) {
            System.out.println(userAdd);
        }
        if (userAdd > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        return map;
    }

    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    @ResponseBody // 使用这个前端才能接收到 login.html
    public Map<String, String> checklogin(User user, HttpServletRequest request, HttpServletResponse response) {
        //新建一个session 是存放服务器中的
        HttpSession session = request.getSession();
        Map map = new HashMap<String, String>();
        // 调用service方法
        user = userService.login(user);
        //     System.out.println(root1.getRid()); 不能有 没有数据时会爆500错误
        if (user != null) {
            map.put("result", "成功");
            //session
            session.setAttribute("user", user);
            //   System.out.println("登录" + user);
            Cookie cookieuname = new Cookie("uname", user.getUname());
            Cookie cookiejid = new Cookie("jid", user.getJid().toString());
            Cookie cookiescore = new Cookie("score", user.getScore().toString());
            Cookie cookieuissys = new Cookie("uissys", user.getUissys().toString());
            cookieuname.setMaxAge(3600 * 24);
            cookiejid.setMaxAge(3600 * 24);
            cookiescore.setMaxAge(3600 * 24);
            cookieuissys.setMaxAge(3600 * 24);
            //设置cookie路径
            cookiejid.setPath(request.getContextPath() + "/page/home/");
            cookieuname.setPath(request.getContextPath() + "/page/home/");
            cookiescore.setPath(request.getContextPath() + "/page/home/");
            cookieuissys.setPath(request.getContextPath() + "/page/home/");
            System.out.println("cookie 路径：" + cookiejid.getPath());
            //输出
            response.addCookie(cookieuname);
            response.addCookie(cookiejid);
            response.addCookie(cookiescore);
            response.addCookie(cookieuissys);

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
        //获取cookie 清空cookie
        Cookie cookies[] = request.getCookies();
        Cookie cookie = new Cookie("uname", "");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath() + "/page/home/");
        response.addCookie(cookie);
        map.put("result", "成功");
        return map;
    }


    /**
     * 查看自己参加的活动
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/findByactivity")
    @ResponseBody //将数据转成json的注解
    public String findByactivity(@RequestParam(value = "page", required = false) String page,
                                 @RequestParam(value = "limit", required = false) String limit,
                                 HttpServletRequest request
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        HttpSession session = request.getSession();
        try {
            User user = (User) session.getAttribute("user");
            int id = user.getUid();
            int rows = Integer.parseInt(limit);
            int tag = (Integer.parseInt(page) - 1) * rows;
            long count = 0L;
            List<ActivityAndScores> activityAndScores = null;
            activityAndScores = scoresService.findByactivity(id, tag, rows);
            count = scoresService.findByUid(id);
            //创建一个jackson的对象映射器，用来解析数据
            //将我们的对象解析成为json格式
            //为了符合layuimini 的前端接收接口
            str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(activityAndScores) + "}";

        } catch (Exception e) {
            str = "{\"code\": 0, \"msg\": \"\",\"count\": " + 0 + ",\"data\":" + mapper.writeValueAsString(null) + "}";
        }
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        //     前端api   { "code":0, "msg":"","count":16, "data": [{ },]}
    }

    /**
     * 取消报名活动
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delscores", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delscores(@RequestParam(value = "sid", required = false) String sid, HttpSession session) {
        //map集合用来存放返回值
        int id = Integer.parseInt(sid);
        int del = 0;
        Map<String, String> map = new HashMap<String, String>();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if (user != null) {
            del = scoresService.deleteByPrimaryKey(id);
            if (del > 0) {
                map.put("result", "成功");
            } else {
                map.put("result", "失败");
            }
        } else {
            map.put("result", "请先登录");
        }
        return map;
    }


    /**
     * 查看自己信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/showuser")
    @ResponseBody // 使用这个前端才能接收到 login.html
    public String showuser(@RequestParam(value = "page", required = false) String page,
                           @RequestParam(value = "limit", required = false) String limit, HttpServletRequest request) throws JsonProcessingException {
        //新建一个session 是存放服务器中的
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String str;
        if (user != null) {
            //创建一个jackson的对象映射器，用来解析数据
            //将我们的对象解析成为json格式
            //为了符合layuimini 的前端接收接口
            //这里必须加 [ ] ,要不然前台解析不了 详见https://blog.csdn.net/weixin_43795169/article/details/92404910
            str = "{\"code\": 0, \"msg\": \"\",\"count\": " + 2 + ",\"data\":[" + mapper.writeValueAsString(user) + "]}";
        } else {
            str = "{\"code\": 0, \"msg\": \"\",\"count\": " + 0 + ",\"data\":[" + mapper.writeValueAsString(null) + "]}";
        }
        return str;
    }

    /**
     * 用户修改密码
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uppwd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uppwd(@RequestParam(value = "nowpwd", required = false) String nowpwd, @RequestParam(value = "pwd", required = false) String pwd,
                                     HttpSession session) {
        //map集合用来存放返回值
        Map<String, String> map = new HashMap<String, String>();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            int up = 0;
            int id = user.getUid();
            up = userService.updatePwd(nowpwd, pwd, id);
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
