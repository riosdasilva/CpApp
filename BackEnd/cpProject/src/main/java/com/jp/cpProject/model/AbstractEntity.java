package com.jp.cpProject.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

// Class que permite registar a auditoria dos dados registados na base de dados
@MappedSuperclass
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "created_at")
	@CreationTimestamp
	private Instant createDateTime;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Instant updateDateTime;

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 17 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AbstractEntity other = (AbstractEntity) obj;
		return Objects.equals(this.id, other.id);
	}

	public Instant getCreateDateTime() {
		return createDateTime;
	}

	public Instant getUpdateDateTime() {
		return updateDateTime;
	}

	@Override
	public String toString() {
		return "id=" + id + ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
}
