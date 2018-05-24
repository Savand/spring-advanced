package util;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrantedAuthorityUtil {

    public static List<? extends GrantedAuthority> getListFromStringRolesRow(String roles) {
        return Arrays.asList(roles.split(",")).stream().map(auth -> new AppGrantedAuthority(auth)).collect(Collectors.toList());
    }

    private static class AppGrantedAuthority implements GrantedAuthority {

        private static final long serialVersionUID = 1L;

        private String authority;

        public AppGrantedAuthority(String authority) {
            this.authority = authority;
        }

        @Override
        public String getAuthority() {
            return authority;
        }

    }
}
