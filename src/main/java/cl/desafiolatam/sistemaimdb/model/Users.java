package cl.desafiolatam.sistemaimdb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "SQ_USER", initialValue = 1, allocationSize = 1)
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(targetEntity = Show.class , fetch=FetchType.LAZY,mappedBy = "user")
	private List<Show> shows;
	
	@OneToMany(targetEntity = Rating.class , fetch=FetchType.LAZY,mappedBy = "user")
	private List<Rating> ratings;

}
