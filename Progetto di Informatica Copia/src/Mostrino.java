public class Mostrino {
    protected int attacco;
    protected int vita;
    protected String nome;
    protected Boolean dead;

    public Mostrino(int attacco, int vita, String nome, Boolean dead){
        this.attacco=attacco;
        this.vita=vita;
        this.nome=nome;
        this.dead=dead;
    }


        public int Goblin_to_Hero(int goblinAttacco, int vita, int personaggio) {

         switch(personaggio){
             case 1:
                System.out.println("===IL GOBLIN GUARDA IL GUERRIERO E ATTACCA!!===");

                System.out.println("==Guerriero riceve " + goblinAttacco + " di danno==");
                break;
             case 2:
                System.out.println("===IL GOBLIN GUARDA LO STREGONE E ATTACCA!!===");

                System.out.println("==Stregone riceve " + goblinAttacco + " di danno==");
                break;

             case 3:
                System.out.println("===IL GOBLIN GUARDA L'ARCIERE E ATTACCA!!===");
                System.out.println("==Arciere riceve " + goblinAttacco + " di danno==");
                break;

            }
            vita = vita - goblinAttacco;
            return vita;
        }
        }


