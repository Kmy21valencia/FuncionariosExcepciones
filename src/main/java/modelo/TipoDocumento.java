
package modelo;


public class TipoDocumento {
    
    private int tipoDocumentoId;
    private String nombre;
    
    public TipoDocumento(){
        
    }
    
    public TipoDocumento(int tipoDocumentoId){
        this.tipoDocumentoId = tipoDocumentoId;
        
    }
    

    public int getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(int tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
