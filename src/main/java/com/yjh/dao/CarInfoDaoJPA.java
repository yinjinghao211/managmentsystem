package com.yjh.dao;

import com.yjh.entity.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarInfoDaoJPA extends JpaRepository<CarInfo,String> {
//    //目前本地数据库用的类型为String，使用此接口须修改类型
//    @Modifying
//    @Query(value = "SELECT distinct * FROM timetest WHERE UNIX_TIMESTAMP(times) >UNIX_TIMESTAMP('2018-07-01 12:10:12')")
//    String getTimediff(String endTime,String startTime);
@Query(value = "select carCharge from CarInfo as ci where ci.parkingId = ?1")
String getcarChargeByParkingId(String parkingId);
}
