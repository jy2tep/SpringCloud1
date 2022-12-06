package serviceuser.ServiceUser.Mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import serviceuser.ServiceUser.common.MallUser;

import java.util.List;

@Component
public interface MallUserDao extends JpaRepository<MallUser,Integer> {
        List<MallUser> findAllByUsernameIs(String username);

        @Transactional
        @Modifying
        @Query("update MallUser c set c.username=?1")
        Integer updateUsernameByaccount(String name);

}