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

/*
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int hitpoints;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hitpoints = 10 + modifier(this.constitution);
    }

    public int ability(final List<Integer> scores) {
        return scores.stream()
                .sorted()             
                .skip(1)              
                .mapToInt(Integer::intValue)
                .sum();               
    }

    public List<Integer> rollDice() {
        return ThreadLocalRandom.current()
                .ints(4, 1, 7) // Gera 4 números inteiros entre 1 (inclusivo) e 7 (exclusivo)
                .boxed()
                .collect(Collectors.toList());
    }

    public int modifier(final int input) {
        return Math.floorDiv(input - 10, 2);
    }

}

*/
