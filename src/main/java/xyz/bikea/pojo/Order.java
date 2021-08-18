package xyz.bikea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderID;
    private String date;
    private Integer bikeID;
    private Integer userID;
    private String start_place;
    private String start_place_coordinate;
    private float distance;
    private String start_time;
    private float use_time;
    private float cost;
}
