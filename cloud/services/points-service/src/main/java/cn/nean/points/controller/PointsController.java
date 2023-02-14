package cn.nean.points.controller;

import cn.nean.model.points.pojo.Points;
import cn.nean.points.mapper.PointsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/points")
@Slf4j
public class PointsController {

    @Autowired
    PointsMapper pointsMapper;

    @GetMapping("/query/{id}")
    public Points getPoints(@PathVariable Long id){
        Points points = pointsMapper.queryPointsById(id);
        log.info("points: {}",points);
        return points;
    }

    @GetMapping("/increase/{userId}/{points}")
    public String increasePoints(@PathVariable Long userId,
                                 @PathVariable Integer points) throws InterruptedException {
        int i = pointsMapper.increasePoints(userId, points);
        TimeUnit.SECONDS.sleep(3);
        if(i > 0){
            log.info(userId + "  号用户增加积分   " + points + "成功!");
            return "success";
        }
        log.info(userId + "  号用户增加积分   " + points + "失败!");
        return "fail";
    }
}
