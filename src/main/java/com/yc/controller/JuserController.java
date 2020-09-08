package com.yc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.Juser;
import com.yc.service.JuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/juser")
public class JuserController {

    @Autowired
    private JuserService juserService;

    private  ObjectMapper mapper =new ObjectMapper();


    /**
     * 登录
     *
     * @param juser
     * @param request
     * @return
     */
    @RequestMapping(value = "/jlogin", method = RequestMethod.POST)
    @ResponseBody // 使用这个前端才能接收到 login.html
    public Map<String, String> checklogin(Juser juser, HttpServletRequest request, HttpServletResponse response) {
        //新建一个session 是存放服务器中的
        HttpSession session = request.getSession();
        Juser juser1 = null;
        Map map = new HashMap<String, String>();
        // 调用service方法
        juser1 = juserService.login(juser);
        if (juser1 != null) {
            map.put("result", "成功");
            session.setAttribute("juser", juser1);
            Cookie jname = new Cookie("jname", juser1.getJname());
            Cookie email = new Cookie("email", juser1.getEmail());
            jname.setMaxAge(3600);
            email.setMaxAge(3600);
            jname.setPath(request.getContextPath() + "/page/admin/jd/");
            email.setPath(request.getContextPath() + "/page/admin/jd/");
            response.addCookie(jname);
            response.addCookie(email);
            //System.out.println(session.toString() + "    " + session.getId() + " --" + session.getAttribute("root"));
        } else {
            map.put("result", "失败");
        }
        return map;
    }


    @RequestMapping("/joutLogin")
    @ResponseBody
    public Map outLogin(HttpServletRequest request, HttpServletResponse response) {
        Map map = new HashMap<String, String>();
        //通过session.invalidata()方法来注销当前的session
        request.getSession().invalidate();
        Cookie jname = new Cookie("jname", "");
        jname.setMaxAge(0);
        jname.setPath(request.getContextPath() + "/page/admin/jd/");
        response.addCookie(jname);
        map.put("result", "200");
        return map;
    }





    /**
     * 查找相应的数据集合
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    @ResponseBody //将数据转成json的注解
    public String show(  @RequestParam(value = "page", required = false) String page,
                         @RequestParam(value = "limit", required = false) String limit,
                         @RequestParam(value = "name", required = false) String jname
    ) throws JsonProcessingException {
        int rows= Integer.parseInt(limit);
        int tag =(Integer.parseInt(page)-1)*rows;
        long  count =0L;
        List<Juser> juserList;
        if ("".equals(jname)|| jname == null) {
        //创建一个jackson的对象映射器，用来解析数据
         juserList =juserService.findJuser(tag,rows);
        count =juserService.getTotalJuser();}
        else{
            juserList =juserService.findJuserByjname(jname,tag,rows);
            count =juserService.getTotalJuserByjname(jname);
        }
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": "+count+",\"data\":"+mapper.writeValueAsString(juserList)+"}";


        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, String> addroot(Juser juser) {
        //map集合用来存放返回值
        Map<String,String> map = new HashMap<String, String>();
//       System.out.println("Controller表现层：添加指定root.."+juser.toString());
        int rootAdd =0;
        try {
            rootAdd =juserService.addJuser(juser);
        }catch (Exception e){
            map.put("result","提交失败");
        }
        if(rootAdd > 0) {
            map.put("result","提交成功");
        }else {
            map.put("result","提交失败");
        }
      //  System.out.println(map.toString());
        return map;
    }


    /**
     * 删除
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> del(String jid) throws Exception {
        Map<String,String> map = new HashMap<>();
        int i =0;
        if (!"".equals(jid)){
            int id = Integer.parseInt(jid);
            i=juserService.deleteJuser(id);
        }
        if (i>0 ){
            map.put("result","成功");
        }else {
            map.put("result","失败");
        }
       // System.out.println(map.toString());
        return map;
    }

    /**
     * 更新账号状态
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/up",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> up(@RequestParam(value = "jissys", required = false) String jissys,
                                 @RequestParam(value = "jid", required = false) String jid
    ) throws Exception {
        Map<String,String> map = new HashMap<>();
        int i =0;
        if (!"".equals(jid) && !"".equals(jissys)){
            int id = Integer.parseInt(jid);
            int issy = Integer.parseInt(jissys);
            i= juserService.updateUissys(issy,id);
        }
        if (i>0 ){
            map.put("result","成功");
        }else {
            map.put("result","失败");
        }
        return map;
    }




}
