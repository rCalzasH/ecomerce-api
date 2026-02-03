/*
 *rCalzas
 *esta clase debe definir los usarios y dichos atributos 
 */
package com.ecomerce.api.model;
public class Usuario{
	private Long id; //id Usuario
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
	 
	
	public Long getId(){
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
	  

	public Usuario setId(Long id){
		this.id=id;return this;
	}
	
	//@param String


	public Usuario setPassword(String p){
		this.password=p;return this;
	}
	
	//@param String
	public Usuario setEmail(String e){
		this.email=e;return this;
	}
	//@param Rol
	public Usuario setRol(Rol r){	
		this.rol=r;return this;
	}
	//@param String
	public Usuario setPathPic(String pp){	
		this.pathPic=pp;return this;
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











