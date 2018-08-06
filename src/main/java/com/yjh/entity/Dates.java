package com.yjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "dates")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dates implements Serializable{
    @Id
    @Column(length = 32)
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    private String dateId;
    @Column(nullable = false)
    private Date dates;
}
