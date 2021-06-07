package com.example.serviceb.Mapper;

import com.example.serviceb.model.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface VipDao extends JpaRepository<Vip,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update vip v set v.name=?1 where v.id=?2",nativeQuery = true)
    int insertOrUpdate(String name,Integer id);
}
