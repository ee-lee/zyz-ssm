package com.yc.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.pojo.Scores;
import com.yc.service.ActivityService;
import com.yc.service.ScoresService;
import com.yc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.font.DelegatingShape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/scores")
public class ScoresController {

    @Autowired
    private ScoresService scoresService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;

    /**
     * 管理员查询当前活动参加的人员
     *
     * @param aid
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "findToactivity")
    @ResponseBody //将数据转成json的注解
    public String findToactivity(@RequestParam(value = "aid", required = false) String aid,
                                 @RequestParam(value = "page", required = false) String page,
                                 @RequestParam(value = "limit", required = false) String limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(aid);
        int rows = Integer.parseInt(limit);
        int tag = (Integer.parseInt(page) - 1) * rows;
        long count = 0L;
        List<Scores> scoresList = null;
        scoresList = scoresService.scoresfindToactivity(tag, rows, id);
        count = scoresService.getTotalScores(id);
        //将我们的对象解析成为json格式
        //为了符合layuimini 的前端接收接口
        String str = "{\"code\": 0, \"msg\": \"\",\"count\": " + count + ",\"data\":" + mapper.writeValueAsString(scoresList) + "}";
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
    public Map<String, String> del(String sid) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(sid)) {
            int id = Integer.parseInt(sid);
            i = scoresService.deleteScores(id);
        }
        if (i > 0) {
            map.put("result", "成功");
        } else {
            map.put("result", "失败");
        }
        System.out.println(map.toString());
        return map;
    }


    /**
     * 更新用户参加的活动状态
     * 0：报名中未审核。1：通过审核。2：志愿者完成活动
     * 当为2 时，需要给志愿者加积分
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> up(@RequestParam(value = "sid", required = false) String sid,
                                  @RequestParam(value = "uid", required = false) String uid,
                                  @RequestParam(value = "aid", required = false) String aid,
                                  @RequestParam(value = "ustatus", required = false) String ustatus
    ) throws Exception {
        Map<String, String> map = new HashMap<>();
        int i = 0;
        if (!"".equals(sid) && !"".equals(ustatus)) {
            int id = Integer.parseInt(sid);
            int uids = Integer.parseInt(uid);
            int aids = Integer.parseInt(aid);
            int ustatu = Integer.parseInt(ustatus);

            if (ustatu == 0) {
                activityService.outActivity(aids);  //减去参加人数
                i = scoresService.updateUstatus(id, ustatu); //设置为零 成功返回1
            } else if (ustatu == 1) {
                int jion = activityService.joinActivity(aids); //判断人数满没满 jion为0 人数满，未满则增加参加人数
                if (jion > 0) {  //大于0 就修改积分表 但用户还未完成 所以不能增加加积分
                    i = scoresService.updateUstatus(id, ustatu);//成功返回1
                } else {
                    i = 2;
                    map.put("result", "人数已满");
                }
            } else if (ustatu == 2) {
                //        int jion = activityService.joinActivity(aids); //判断人数满没满 jion为0 人数满，未满则增加参加人数

                i = scoresService.updateUstatus(id, ustatu);  //成功返回1
                userService.updateScore(uids);
            }
        }

        if (i == 1) {
            map.put("result", "成功");
        } else if (i == 0) {
            map.put("result", "失败");
        }
        return map;
    }
}
