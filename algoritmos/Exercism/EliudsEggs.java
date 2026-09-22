public class EliudsEggs {
    public int eggCount(int number) {
        int contadorDeOvos = 0;
        
        while (number > 0) {
            contadorDeOvos += (number % 2);
            number = number / 2;            
        }
        
        return contadorDeOvos;
    }
}
/*
public class EliudsEggs {
    public int eggCount(int number) {
        if (number <= 0) {
            return 0;
        }
        
        return (number % 2) + eggCount(number / 2);
    }
}

*/
