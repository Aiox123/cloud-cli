package cn.nean.points.mapper;

import cn.nean.model.points.pojo.Points;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsMapper extends BaseMapper<Points> {

    Points queryPointsById(@Param("id") Long id);

    /*
    * 增加积分
    * */
    int increasePoints(@Param("userId") Long userId,
                       @Param("points") Integer points);
}
