import java.util.List;

class BinarySearch {
    private List<Integer> itens;
    BinarySearch(List<Integer> items) {
        this.itens = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        int flag = 0;
        int inicio = 0;
        int fim = itens.size() - 1;

        while(flag != 1 && inicio <= fim){
            int meio = (inicio + fim)/2;

            if(item == itens.get(meio)){
                flag = 1;
                return meio;
            }if(itens.get(meio) > item)
                fim = meio - 1;
            else
                inicio = meio + 1;

        }

        throw new ValueNotFoundException("Value not in array");
    }
}
