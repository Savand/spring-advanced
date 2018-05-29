package beans.models;

import org.h2.util.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import util.GrantedAuthorityUtil;
import util.RoleUtil;

import java.time.LocalDate;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created with IntelliJ IDEA. User: Dmytro_Babichev Date: 2/1/2016 Time: 7:35 PM
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"userId", "email", "name", "birthday", "roles" })
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String email;
    private String name;

    @XmlTransient
    private LocalDate birthday;

    private String roles = "";
    private String password;

    @XmlTransient
    private UserAccount account;

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }


    public User() {
    }

    public User(long id, String email, String name, LocalDate birthday) {
        this();
        this.userId = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public User(String email, String name, LocalDate birthday) {
        this(-1, email, name, birthday);
    }

    public User(String email, String name, LocalDate birthday, String password) {
        this(email, name, birthday);
        this.password = password;
    }

    public User withId(long id) {
        return new User(id, email, name, birthday);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getRoles() {
        return roles;
    }

    public void addRole(Role role) {

        if (StringUtils.isNullOrEmpty(this.roles)) {
            this.setRoles(role.toString());
        } else {
            this.setRoles(this.roles + RoleUtil.ROLES_RELIMITER + role.toString());
        }
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (userId != user.userId) {
            return false;
        }
        if (email != null ? !email.equals(user.email) : user.email != null) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + userId + ", email='" + email + '\'' + ", name='" + name + '\'' + ", birthday=" + birthday + ", roles: " + getRoles() + '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return GrantedAuthorityUtil.getListFromStringRolesRow(roles);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
