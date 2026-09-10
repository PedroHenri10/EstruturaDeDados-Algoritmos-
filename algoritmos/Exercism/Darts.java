class Darts {
    int score(double xOfDart, double yOfDart) {
        xOfDart = Math.abs(xOfDart);
        yOfDart = Math.abs(yOfDart);
        
        double somaDosQuadrados = (xOfDart * xOfDart) + (yOfDart* yOfDart);
        double distancia = Math.sqrt(somaDosQuadrados);

        if(distancia <= 1){
            return 10;
        } else if (distancia <= 5) {
            return 5;
        } else if (distancia <= 10) {
            return  1;
        }else {
            return 0;
        }
    }
}

/*
class Darts {

    int score(final double xOfDart, final double yOfDart) {
        final double distancia = Math.hypot(xOfDart, yOfDart);

        if (distancia <= 1.0) return 10;
        if (distancia <= 5.0) return 5;
        if (distancia <= 10.0) return 1;
        
        return 0; 
    }
}

*/
