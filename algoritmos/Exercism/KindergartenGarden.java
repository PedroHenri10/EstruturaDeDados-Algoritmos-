import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

    String[] alunos = {"Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid",  "Larry"};
    ArrayList<Character> primeiraFileira = new ArrayList<>();
    ArrayList<Character> segundaFileira =new ArrayList<>();

    KindergartenGarden(String garden) {
        boolean interruptor = false;

        for(char c : garden.toCharArray()){

            if(c == '\n'){
                interruptor = true;
                continue;
            }

            if(!interruptor){
                primeiraFileira.add(c);
            }else{
                segundaFileira.add(c);
            }

        }

    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> lista = new ArrayList<>();

        int indiceInicio = 0;
        for(int i = 0; i < alunos.length; i++){
            if(alunos[i].equals(student)){
                indiceInicio = i * 2;
            }
        }

        lista.add(Plant.getPlant(primeiraFileira.get(indiceInicio)));
        lista.add(Plant.getPlant(primeiraFileira.get(indiceInicio +1)));
        lista.add(Plant.getPlant(segundaFileira.get(indiceInicio)));
        lista.add(Plant.getPlant(segundaFileira.get(indiceInicio +1)));

        return lista;
    }

}
