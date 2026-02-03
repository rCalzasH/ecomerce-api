/*
 *rCalzas
 * esta clase debe definifr los atributos de los productos que posteriormente;
 */

package com.ecomerce.api.model;
public class Producto{
//id
	private Long id;
//nombre
	private String nombre;
//precio(+)	
	private double precio;
//Descripcion	
	private String descripcion;
//constructores
/*
 *Un constructor para los json, todavía no enteindo pq teiene que estar vacío peor bueno
 */
public Producto(){}
/*
 * PRE: los datos de entrada son válidos
 *crea un producto de nombre n, precio p y descripcion d
*/	
	public Producto(String n, double p){
		this.nombre=n;
		this.precio=p;
		this.descripcion="";
	}
/*
 * PRE: los datos de entrada son válidos
 *crea un producto de nombre n, precio p y descripcion d
*/
	public Producto(String n, double p, String d){
		this.nombre=n;
		this.precio=p;
		this.descripcion=d;
	
	}
/*
 * PRE: existe el producto
 * devuele el nombre de dicho producto
 */
	public String getNombre(){
		return this.nombre;
	}
/*
 * PRE: existe el producto
 * devuele el precio de dicho producto
 */
	public double getPrecio(){
		return this.precio;
	}

/*
 * PRE: existe el producto y dicho producto tiene descripcion
 * devuele la descripcion de dicho producto
 */
	public String getDescripcion(){
		return this.descripcion;
	}

	public Long getId(){
		return this.id;
	}
        public void setNombre(String n){
		this.nombre=n;
	}
 	
	public void setPrecio(double p){
		this.precio=p;
	}
	
	public void setDescripcion(String d){
		this.descripcion=d;
	}
	public void setId(Long id){
		this.id=id;
	}
 /*PRE: existe el producto al que has llamado
 *
 */	@Override
	public String toString(){
		String producto="Nombre: "+this.nombre+"\n";
		//asumo que el casting lo hace automaticamente
		producto+="Precio: "+this.precio+"\n";
		producto+="Descripcion: "+this.descripcion+"\n";
		return producto;

	}
}
