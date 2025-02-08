package data;

import java.util.Random;

/**
 *
 * @author alber
 */
public class Combate {
    private Pokemon  [] p;

    public Combate(Pokemon[] p) {
        this.p = p;
    }

    public Pokemon[] getP() {
        return p;
    }

    public void setP(Pokemon[] p) {
        this.p = p;
    }
    
    public int atacar() throws InterruptedException{
       Random r = new Random(System.currentTimeMillis());
       int puntosAtaque = r.nextInt(0,8);
       int posibilidadCritico = r.nextInt(0,10);
       if (posibilidadCritico > 7 && puntosAtaque>0){
            puntosAtaque += 6;
            System.out.println("GOLPE CRITICO!!!");
        }
       
       if (puntosAtaque == 0)
           System.out.println("El ataque fallo...");
       else
           System.out.println("El ataque ha quitado " + puntosAtaque + " de vida al enemigo.");
       
       Thread.sleep(1000);
       return puntosAtaque;
       
   }
   public void cambiarVida(int puntosAtaque, int pokemonAtacado){
       p[pokemonAtacado].setHp(p[pokemonAtacado].getHp()-puntosAtaque);
   }


}
