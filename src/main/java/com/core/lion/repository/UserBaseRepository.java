package com.core.lion.repository;

import com.core.lion.model.entity.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBaseRepository extends JpaRepository<UserBase, Long> {
    UserBase findByGid(String gid);

    UserBase findByMobile(String mobile);
}