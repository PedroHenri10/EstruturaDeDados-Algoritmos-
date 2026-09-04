import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {
    private final List<String> alunos = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry");
    private final String[] fileiras;

    KindergartenGarden(String garden) {
        this.fileiras = garden.split("\n");
    }

    List<Plant> getPlantsOfStudent(String student) {
        // .indexOf() substitui o seu loop "for" de busca e já te dá o índice direto
        int indiceInicio = alunos.indexOf(student) * 2;

        List<Plant> plantasDoAluno = new ArrayList<>();
        
        plantasDoAluno.add(Plant.getPlant(fileiras[0].charAt(indiceInicio)));
        plantasDoAluno.add(Plant.getPlant(fileiras[0].charAt(indiceInicio + 1)));
        
        plantasDoAluno.add(Plant.getPlant(fileiras[1].charAt(indiceInicio)));
        plantasDoAluno.add(Plant.getPlant(fileiras[1].charAt(indiceInicio + 1)));

        return plantasDoAluno;
    }
}
