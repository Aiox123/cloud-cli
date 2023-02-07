package cn.nean.feign.points;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("points-service")
public interface PointsClient {
}
