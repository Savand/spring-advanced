package util;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import beans.models.Role;

public class RoleUtil {

    public static final String ROLES_RELIMITER = ",";

    public static Set<Role> getRolesFromString(String roles) {
        Objects.requireNonNull(roles, "'roles' must not be Null");

        return Arrays.stream(roles.split(ROLES_RELIMITER)).map(stringRole -> Role.valueOf(stringRole)).collect(Collectors.toSet());

    }

}
