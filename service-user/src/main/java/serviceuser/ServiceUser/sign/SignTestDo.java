package serviceuser.ServiceUser.sign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Component
public class SignTestDo {
    @Value("${api.secret}")
    private String secret="";

    public boolean SignPass(Map<String,Object> input,String sigin){
        StringBuilder str = new StringBuilder();
        Set<String> sets = new TreeSet(input.keySet());
        for (String set:sets){
            if (!Objects.isNull(input.get(set))){
                str.append(set);
                str.append(input.get(set));
            }
        }
        String hash = str+secret;
        String hash1 =  DigestUtils.md5DigestAsHex(hash.getBytes(StandardCharsets.UTF_8)).toUpperCase();
        if (hash1.equals(sigin)){
            return true;
        }
        return false;
    }
}
