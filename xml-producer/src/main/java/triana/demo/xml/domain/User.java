package triana.demo.xml.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@XmlElement
	private String name;
	@XmlElement
	private long data;

}
