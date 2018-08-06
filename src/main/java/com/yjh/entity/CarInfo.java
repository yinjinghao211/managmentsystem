package com.yjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarInfo implements Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(length = 32)
    private String carInfoId;
    @Column
    private String carId;
    @Column
    private String parkingId;
    @Column
    private String carCharge;
    @Column
    private String parkingTime;
    @Column
    private String payMode;
    @Column
    private String inTime;
    @Column
    private String outTime;
    @Column
    private String tollCollector;
    @Column
    private String originTime;
    @Column
    private String endTime;
    @Column
    private String carReason;
    @Column
    private String parkingSecurity;
    @Column
    private String travelRecord;
    @Column
    private String carModifyTime;

}
