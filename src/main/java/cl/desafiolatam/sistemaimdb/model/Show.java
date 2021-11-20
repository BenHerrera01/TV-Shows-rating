package cl.desafiolatam.sistemaimdb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "SQ_SHOWS", initialValue = 1, allocationSize = 1)
@Table(name = "shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SHOWS")
	private Long id;
	
	@Size(min = 3, max = 50)
	private String showTitle;
	
	@Size(min = 1, max = 30)
	private String showNetwork;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "users_shows")
	private Users user;

	@ManyToMany(mappedBy = "shows",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Rating> ratings;
}
