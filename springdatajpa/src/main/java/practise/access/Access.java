package practise.access;

import jakarta.persistence.*;
import practise.piid.PIID;
import practise.role.Role;
import practise.user.User;

import java.io.Serializable;

@Entity
@Table(name = "mail_forwarding_access")
public class Access {

    @EmbeddedId
    private AccessId id;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @MapsId("piidId")
    @JoinColumn(name = "piid_id")
    private PIID piid;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "organization")
    private String organization;

    public Access() {
        this.id = new AccessId();
    }

    public Access(AccessId id, User user, PIID piid, Role role, String organization) {
        this.id = id;
        this.user = user;
        this.piid = piid;
        this.role = role;
        this.organization = organization;
    }

    public AccessId getId() {
        return id;
    }

    public void setId(AccessId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PIID getPiid() {
        return piid;
    }

    public void setPiid(PIID piid) {
        this.piid = piid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Embeddable
    public static class AccessId implements Serializable {

        private static final long serialVersionUID = 1L;
        private Long userId;
        private Long piidId;
        private Long roleId;

        public AccessId() {

        }

        public AccessId(Long userId, Long piidId, Long roleId) {
            this.userId = userId;
            this.piidId = piidId;
            this.roleId = roleId;
        }

        public Long getUserId() {
            return userId;
        }

        public AccessId setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Long getPiidId() {
            return piidId;
        }

        public AccessId setPiidId(Long piidId) {
            this.piidId = piidId;
            return this;
        }

        public Long getRoleId() {
            return roleId;
        }

        public AccessId setRoleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

    }

}
