package xyz.bikea.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.bikea.pojo.Bike;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BikeMapper {

    List<Bike> queryBikeList();

    List<Map<String,Object>> queryNormalBikeLocation();

    List<Map<String,Object>> queryBrokenBikeLocation();

    int queryNormalNow();

    int queryBrokenNow();

    int queryMissNow();

    int queryTotal();

    int queryUsing();

    List<String> queryDate();

    List<Integer> queryHistNormal();

    List<Integer> queryHistBroken();

    List<Integer> queryHistMiss();

    int queryNumUse(int i);

    int countNormalByCo(String s);

    int countBrokenByCo(String s);


}
