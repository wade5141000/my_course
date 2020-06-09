package com.sedia.my_course.model.user;

import com.sedia.my_course.model.Course;
import com.sedia.my_course.model.CourseTable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/**
    使用者
 */
@Entity
@Getter
@Setter
@Table(name = "all_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

	@Column(unique = true)
	private String account;

    private String password;

    private String nickname;

    private String school;
	// 科系
    private String department;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID_FK")
    private List<CourseTable> courseTables;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID_FK")
	private List<Course> courses;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID_FK")
	private List<UserRole> authorities;


	@Override
	public String getUsername() {
		return this.account;
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