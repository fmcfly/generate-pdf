public class Boleto{
    private String sala;
    private String nombre;

    public Boleto(String nombre,String sala){
        this.sala = sala;
        this.nombre = nombre;
    }

    public String getSala(){
        return this.sala;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}