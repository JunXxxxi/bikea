package xyz.bikea.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.bikea.pojo.Order;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> queryOrderList();

    List<Integer> queryNumOrder();

    List<Integer> queryIncome();
}
