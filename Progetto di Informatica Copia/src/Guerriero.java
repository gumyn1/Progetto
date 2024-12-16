public class Guerriero extends Personaggio {


    public Guerriero(int vita,int energia, int ad, int ap,Boolean dead) {
        super(vita,energia,ad,ap,dead);
    }


    public boolean aggiornaVita(int vitaPersa){
        vita =- vitaPersa;
        if (vita <= 0){
            dead = true;

        }
        return dead;
    }
}
