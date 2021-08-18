package xyz.bikea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRecord {
    private Date date;
    private int numNormal;
    private int numBroken;
    private int numMiss;
    private int numOrder;
    private float income;
}
