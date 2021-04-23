/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.Cliente;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import logica.Prestamo;

/**
 *
 * @author Vinni
 */
@ManagedBean
@SessionScoped
public class ManejadorBean implements Serializable {
    
    private Date fecha;
    private String nombre;
    private Double valor;
    private Integer plazo;
    
    private Double cuota;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }
    
    

    /**
     * Creates a new instance of ManejadorBean
     */
    public ManejadorBean() {
    }
    public void guardar(){
        System.out.println("Ingreso ");
        System.out.println(" La fecha "+fecha+ " "+nombre +" "+ plazo+ " "+ valor);
        Cliente elCliente = new Cliente(nombre, fecha);
        Prestamo pre = new Prestamo(elCliente, plazo, valor);
        Double res = pre.hacerSimulacion();
        System.out.println(" "+res);
        if (res != null){
            this.cuota = res;
        }else{
            this.cuota = 0D ;
        }
    }
    
}
