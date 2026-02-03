/*
 *rCalzas
 *esta clase debe definir los usarios y dichos atributos 
 */
package com.ecomerce.api.model;
import java.util.concurrent.atomic.AtomicLong;
public class Usuario{
	private AtomicLong id; //id Usuario
	private String password; //contraeña
	private String email; //email del usuario
	private Rol rol; //rol del usuario, que será comprador seguramnete
	private String pathPic;	
	//constructores
	public Usuario(){}
	
	public Usuario( String p, String email, Rol rol, String pa){
		//el id lo genera el sistema pq debe se unico y servir para poder identificar al cliente 
		this.password=p;
		this.email=email;
		this.rol=rol;
		this.pathPic=pa;
	}
	
	
	//@returns id
	 
	
	public AtomicLong getId(){
		return this.id;
	}

	
	//@returns psswrd
	 
	
	public String getPassword(){
		return this.password;
	}


	//@returns email
	
	public String getEmail(){
		return this.email;
	}

	// @returns rol
	 
	
	public Rol getRol(){
		return this.rol;
	}
	
	//@reutrns pathPic
	public String getPathPic(){
		return this.pathPic;
	}
	
	// @param String
	  

	public void setId(AtomicLong id){
		this.id=id;
	}
	
	//@param String


	public void setPassword(String p){
		this.password=p;
	}
	
	//@param String
	public void setEmail(String e){
		this.email=e;
	}
	//@param Rol
	public void setRol(Rol r){	
		this.rol=r;
	}
	//@returns string del usuario
	@Override 
	public String toString(){
		String usuario="Id: "+ this.id +"\n";
		usuario+="Contraseña: ********"+ "\n";
		usuario+="Email:  "+ this.email +"\n";
		usuario+="Rol: "+ this.rol +"\n";
		return usuario;
	}
	
}











