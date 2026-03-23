/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorEstudiantes;
import java.util.LinkedList;
/**
 *
 * @author ramir
 */
public class Carrera {

    private String nombre;
    private LinkedList<Estudiante> estudiantes;
    private int cantEdudiantes;
    

    public Carrera () {
        estudiantes = new LinkedList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCantEdudiantes() {
        return cantEdudiantes;
    }

    public void setCantEdudiantes(int cantEdudiantes) {
        this.cantEdudiantes = cantEdudiantes;
    }

    @Override
    public String toString() {
        return nombre; 
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
