package serviceuser.ServiceUser.Mapper;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import serviceuser.ServiceUser.common.Vip;

import java.util.List;

@Component
public interface VipDao extends JpaRepository<Vip,Integer> {
        List<Vip> findByAccount(String account);

        @Transactional
        @Modifying
        @Query("update Vip c set c.name=?1 where c.account=?2")
        Integer updateUsernameByaccount(String name,String account);

}