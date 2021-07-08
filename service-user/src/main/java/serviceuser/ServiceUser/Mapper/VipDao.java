package serviceuser.ServiceUser.Mapper;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import serviceuser.ServiceUser.common.Vip;

@Component
public interface VipDao extends JpaRepository<Vip,Integer> {
        Vip findByAccount(String account);
}
