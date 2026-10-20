
class SqueakyClean {

    static String clean(String identifier) {
        StringBuilder resultado = new StringBuilder();
        boolean proximaMaiuscula = false;

        for (char caractere : identifier.toCharArray()) {

            if (caractere == ' ') {
                resultado.append('_');
                continue;
            }

            if (caractere == '-') {
                proximaMaiuscula = true;
                continue;
            }

            if (proximaMaiuscula) {
                resultado.append(Character.toUpperCase(caractere));
                proximaMaiuscula = false;
                continue;
            }

            switch (caractere) {
                case '4':
                    resultado.append('a');
                    break;
                case '3':
                    resultado.append('e');
                    break;
                case '0':
                    resultado.append('o');
                    break;
                case '1':
                    resultado.append('l');
                    break;
                case '7':
                    resultado.append('t');
                    break;
                default:
                    if (Character.isLetter(caractere)) {
                        resultado.append(caractere);
                    }
                    break;
            }
        }

        return resultado.toString();
    }
}
