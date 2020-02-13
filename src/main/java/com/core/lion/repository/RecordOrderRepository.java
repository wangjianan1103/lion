package com.core.lion.repository;

import com.core.lion.model.entity.RecordOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordOrderRepository extends JpaRepository<RecordOrder, Long> {

    RecordOrder findByGid(String gid);

    List<RecordOrder> findByUserGidAndCreateTimeGreaterThanAndOrderStatusNot(String userGid, Long createTime, Integer orderStatus);
}
