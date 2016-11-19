package net.bootsfaces.demo.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class You implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public You() {
		System.out.println("You!");
	}
	
	public String howdy() {
		return "How are you?";
	}

}
