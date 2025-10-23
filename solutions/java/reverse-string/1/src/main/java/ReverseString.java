class ReverseString {

    String reverse(String inputString) {
        if (inputString.isEmpty()){
            return inputString;
        }
        int lgString = inputString.length()-1;
        char[] caracteres = inputString.toCharArray();
        char[] outputString;
        char tmp;
        for(int i = 0; i < ((lgString)/2)+1 ; i++){
            tmp = caracteres[lgString-i];
            caracteres[lgString-i] = caracteres[i];
            caracteres[i] = tmp;
        }
        return new String(caracteres);
    }
  
}
