
package modelo;

public class EstadoCivil {
    private String nombre;
    private int estadoCivilId;
    
    public EstadoCivil(){
        
    }
    
    public EstadoCivil(int estadoCivilId){
        this.estadoCivilId = estadoCivilId;
        
    }
    
    public EstadoCivil(int estadoCivil, String nombre){
        this.estadoCivilId = estadoCivil;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(int estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
