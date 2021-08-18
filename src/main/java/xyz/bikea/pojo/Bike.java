package xyz.bikea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private Integer bikeID;
    private String status;
    private int isUsing;
    private String location;
    private String coordinate;
    private int num_use;

}
