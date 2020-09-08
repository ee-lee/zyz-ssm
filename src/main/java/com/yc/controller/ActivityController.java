package com.yc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.Activity;
import com.yc.service.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger log = Logger
            .getLogger(ActivityController.class);// 日志文件

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
                       @RequestParam(value = "title", required = false) String title) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<Activity> activityList;
        if ("".equals(title) || title == null) {
            //创建一个jackson的对象映射器，用来解析数据
            activityList = activityService.findActivity(tag, rows);
//        if (date != null) {
//            //把日期序列化成yyyy-MM-dd格式的字符串
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            formattedDate = simpleDateFormat.format(date);
//        }
            count = activityService.getTotalActivity();
        } else {
            activityList = activityService.findActivityBytitle(title, tag, rows);
            count = activityService.getTotalActivityBytitle(title);
        }
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(activityList) + "}";
        //  System.out.println("activit controller "+session.toString()+session.getId());
        return str; //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        //     前端api   { "code":0, "msg":"","count":16, "data": [{ },]}

    }


    /**
     * 添加
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody //将数据转成json的注解
    public Map<String, String> add(Activity activity) {
        // System.out.println(activity.toString());
        Map<String, String> map = new HashMap<>();
        int i = 0;
        i = activityService.addActivity(activity);
        if (i > 0) {
            int aid = activity.getAid(); //插入成功后将主键返回给前端 方便利用主键存储照片
            map.put("result", "成功");
            map.put("aid", aid + "");
        } else {
            map.put("result", "失败");
        }
        // System.out.println(map.toString());
        return map;
    }


    /**
     * 删除
     *
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> del(String aid) {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(aid)) {
            int id = Integer.parseInt(aid);
            i = activityService.deleteActivity(id);
        }
        log.info("request: activity/delete , aid: " + aid);
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        return map;
    }

    /**
     * 结束活动
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateByStatus", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateByStatus(@RequestParam(value = "aid", required = false) String aid,
                                              @RequestParam(value = "status", required = false) String status) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(aid) && !"".equals(status)) {
            int id = Integer.parseInt(aid);
            int statu = Integer.parseInt(status);
            i = activityService.updateByStatus(id, statu);
        }
        log.info("request: activity/updateByStatus , aid: " + aid + "status:" + status);
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        // System.out.println(map.toString());
        return map;
    }


    /**
     * 查询活动数量
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/welconme", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> welcome() {
        Map<String, String> map = new HashMap<>();
        long counts = activityService.getTotalActivity();
        long news = activityService.getActivityToWelcome(0);
        long activity = activityService.getActivityToWelcome(1);
        long ac = activityService.getActivityToWelcomeEnds(1, 1);
        long acends = activityService.getActivityToWelcomeEnds(1, 0);
        map.put("counts", counts + "");
        map.put("activity", activity + "");
        map.put("news", news + "");
        map.put("ac", ac + "");
        map.put("acends", acends + "");
        return map;
    }

}
