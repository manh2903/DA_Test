package com.example.da_test.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity implements UserDetails {


    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Getter
    @Column(name = "email", length = 45, nullable = false, unique = true)
    private String email;

    @Getter
    @Column(name = "address", length = 1000, nullable = false)
    private String address;

    @Getter
    @Column(name = "phone", length = 10)
    private String phone;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Role> roles = new HashSet<Role>();
    public void addRoles(Role role) {
        role.getUsers().add(this);
        roles.add(role);
    }
    public void deleteRoles(Role role) {
        role.getUsers().remove(this);
        roles.remove(role);
    }

    @Getter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Saleorder> saleOrders = new HashSet<Saleorder>();
    public void addSaleOrder(Saleorder saleOrder) {
        saleOrders.add(saleOrder);
        saleOrder.setUser(this);
    }
    public void deleteSaleOrder(Saleorder saleOrder) {
        saleOrders.remove(saleOrder);
        saleOrder.setUser(null);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
