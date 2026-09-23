class RaindropConverter {

    String convert(int number) {
        StringBuffer sb = new StringBuffer();
        
        if(number % 3 == 0)
        {
            sb.append("Pling");
        }
        
        if(number % 5 == 0)
        {
            sb.append("Plang");
        }
        
        if(number % 7 == 0)
        {
            sb.append("Plong");
        }
        
        if(number % 3 != 0 && number % 5 != 0 && number % 7 != 0){
            String numeroEmString = Integer.toString(number);
            return numeroEmString;
        }
        
        return sb.toString();
    }

}
