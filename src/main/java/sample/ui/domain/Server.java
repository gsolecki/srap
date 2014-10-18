package sample.ui.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Getter @Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Server {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "Endpoint is required")
	@Pattern(message = "Endpoint url is invalid", regexp = "\\b(https?|ftp|file|ldap)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]")
	@Size(max = 200, message = "Endpoint must be less than 200 characters")
	private String endpoint;

	@NotEmpty(message = "Name is required")
	@Size(max = 20, message = "Name must be less than 20 characters")
	private String name;

	private Calendar created = Calendar.getInstance();

}
