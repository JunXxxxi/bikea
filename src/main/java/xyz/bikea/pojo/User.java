package xyz.bikea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userID;
    private String gender;
    private int age;
    private int ridePerMon;
    private int ridePerTime;
    private float distPerTime;
    private float payPerMon;
    private int rideTimes;
    private int rideTime;
    private float rideDist;
    private float totalPay;
}
