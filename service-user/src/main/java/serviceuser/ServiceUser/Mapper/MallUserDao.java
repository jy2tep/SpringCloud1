package serviceuser.ServiceUser.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import serviceuser.ServiceUser.common.MallProduct;
import serviceuser.ServiceUser.common.MallUser;

import java.util.List;

@Mapper
public interface MallUserDao {
        List<MallUser> findAllByUsernameIs(@Param("username") String username);

        @Transactional
        @Modifying
        Integer updateUsernameByaccount(String name);

        Integer save(@Param("mallUser") MallUser mallUser);

        @Transactional
        @Modifying
        MallProduct getStock(int id);

}