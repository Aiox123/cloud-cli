package cn.nean.feign.points;


import cn.nean.model.points.pojo.Points;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
*  @Author nean
*  name 指定调用rest接口所在服务名称
*  path 指定调用rest接口所在的 PointsController 指定的 RequestMapping
* */
@FeignClient(value = "points-service",path = "points")
public interface PointsFeignClient {

    // 声明需要调用的 rest接口对应的方法
    @GetMapping("/query/{id}")
    Points queryPoints(@PathVariable Long id);

}
