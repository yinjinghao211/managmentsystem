package com.yjh.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable{
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(length = 32)
    private String userId;
    @Column(nullable = false)
    private String userName;
    @Column
    private String userAge;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String userPhone;
    @Column
    private String userIdCard;
    @Column
    private String userQQ;
    @Column
    private String userWeChat;

    public Users(String userName, String userPhone, String userAge) {
        this.userName = userName;
        this.userAge = userAge;
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userWeChat='" + userWeChat + '\'' +
                '}';
    }
}
