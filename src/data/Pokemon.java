package data;


/**
 *
 * @author alber
 */
public class Pokemon {
   private String nombre;
   private int hp;

    public Pokemon(String nombre, int hp) {
        this.nombre = nombre;
        this.hp = hp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return nombre + ", HP = " + hp ;
    }
   
   
   
   
}


