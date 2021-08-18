package xyz.bikea.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int queryNumMale();

    int queryNumFemale();

    int queryAge(int age1, int age2);

    int queryNumRide(int r1,int r2);

    int queryNumDist(int d1, int d2);

    int queryNumTime(int t1, int t2);

}
