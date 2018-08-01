package com.yjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "merchant")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(length = 32)
    private String merId;
    @Column
    private String userId;
    @Column
    private String carInfoId;
    @Column
    private String merName;
}
