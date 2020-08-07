package com.wushen.staservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.staservice.client.UcenterClient;
import com.wushen.staservice.entity.StatisticsDaily;
import com.wushen.staservice.mapper.StatisticsDailyMapper;
import com.wushen.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-06
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {
    @Autowired
    private UcenterClient ucenterClient;
    @Override
    public void createStatisticsByDay(String day) {
        //删除已存在的统计对象
        QueryWrapper<StatisticsDaily> dayQueryWrapper = new QueryWrapper<>();
        dayQueryWrapper.eq("date_calculated", day);
        baseMapper.delete(dayQueryWrapper);


        //获取统计信息
        Integer registerNum = (Integer) ucenterClient.registerCount(day).getData().get("countRegister");
        Integer loginNum = RandomUtils.nextInt(100, 200);//TODO
        Integer videoViewNum = RandomUtils.nextInt(100, 200);//TODO
        Integer courseNum = RandomUtils.nextInt(100, 200);//TODO

        //创建统计对象
        StatisticsDaily daily = new StatisticsDaily();
        daily.setRegisterNum(registerNum);
        daily.setLoginNum(loginNum);
        daily.setVideoViewNum(videoViewNum);
        daily.setCourseNum(courseNum);
        daily.setDateCalculated(day);

        baseMapper.insert(daily);
    }

    @Override
    public Map<String, Object> getData(String type, String begin, String end) {
        QueryWrapper<StatisticsDaily> queryWrapper = new QueryWrapper<>();
        /*查询两个时间段的数据*/
        queryWrapper.between("date_calculated",begin,end);
        /*查询指定列;type前端已和我们的数据库列匹配了*/
        queryWrapper.select("date_calculated",type);
        List<StatisticsDaily> dailyList = baseMapper.selectList(queryWrapper);
        List<String> dateList = new ArrayList<>(16);
        List<Integer> dataList = new ArrayList<>(16);
        if (dailyList != null) {
            for (int i = 0; i < dailyList.size(); i++) {
                StatisticsDaily daily = dailyList.get(i);
                dateList.add(daily.getDateCalculated());
                switch (type) {
                    case "login_num":
                        dataList.add(daily.getLoginNum());
                        break;
                    case "register_num":
                        dataList.add(daily.getRegisterNum());
                        break;
                    case "video_view_num":
                        dataList.add(daily.getVideoViewNum());
                        break;
                    case "course_num":
                        dataList.add(daily.getCourseNum());
                        break;
                    default:
                        break;
                }
            }
        }
        Map<String,Object> map = new HashMap<>(16);
        map.put("dateList",dateList);
        map.put("dataList",dataList);
        return map;
    }
}
