package net.bootsfaces.demo.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Me implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	
	@Inject
	private You you;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void init() {
		name = "The BootsFaces team";
	}

	public You getYou() {
		return you;
	}

	public void setYou(You you) {
		this.you = you;
	}
}