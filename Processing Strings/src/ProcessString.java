public class ProcessString {
  private void brutalForce(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();

    int i, j;
    for (i = 0; i <= textLength - patternLength; i++) {
      for (j = 0; j < patternLength; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == patternLength) {
        System.out.println("Padrão encontrado no índice " + i);
      }
    }
  }

  public void brutalForce(String text, String[] patterns) {
    System.out.println("=========== FORÇA BRUTA ===========");
    for (int i = 0; i < patterns.length; i++) {
      System.out.println(patterns[i] + ": ");
      brutalForce(text, patterns[i]);
      System.out.println();
    }
  }

  private void createPrefixTable(String pattern, int size){

  }

  /*private void KMP(){

  }

  public void KMP(){


  }*/
}
