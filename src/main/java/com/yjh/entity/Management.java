package com.yjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Management")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Management implements Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(length = 32)
    private String manageId;
    @Column
    private String userId;
    @Column
    private String carInfoId;
    @Column
    private String tollCollector;
    @Column
    private String totalTime;
    @Column
    private String chargeType;
    @Column
    private String money;
}
