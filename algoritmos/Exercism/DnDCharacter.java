import java.util.ArrayList;
import java.util.List;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int charisma;
    private int wisdom;
    private int hitpoints;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());

        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        int menor = 7;
        int soma = 0;

        for(Integer dado : scores){
            soma += dado;
            if(dado < menor){
                menor = dado;
            }
        }

        return soma - menor;
    }

    List<Integer> rollDice() {
        List<Integer> dadosDaRodada = new ArrayList<>();

        for(int i = 0; i <4; i++){
            int dado = (int) (Math.random() * 6) +1;
            dadosDaRodada.add(dado);
        }

        return dadosDaRodada;
    }

    int modifier(int input) {
        double resultado = (input - 10) / 2.0;

        return (int) Math.floor(resultado);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
