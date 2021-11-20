package cl.desafiolatam.sistemaimdb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "SQ_RATING", initialValue = 1, allocationSize = 1)
@Table(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RATING")
	private Long id;
	
	@Range(min=1, max=5, message="The rating must be between 1 and 5")  
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "user_rating", referencedColumnName = "id")
	private Users user;
	
	@ManyToMany
	@JoinTable(name = "show_rating", joinColumns = @JoinColumn(name = "rating_id"), inverseJoinColumns = @JoinColumn(name = "show_id"))
	private List<Show> shows;
}
