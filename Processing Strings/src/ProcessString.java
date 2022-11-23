public class ProcessString {
  private void brutalForce(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();
    int occurenciesNumber = 0, comparisonsNumber = 0;

    for (int i = 0; i < (textLength - patternLength); i++) {
      for (int j = 0; j < patternLength; j++) {
        comparisonsNumber++;

        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
        if (j != patternLength - 1) {
          continue;
        }

        occurenciesNumber++;

        System.out.println("Comparações até o índice " + i + ": " + comparisonsNumber);
        comparisonsNumber = 0;
      }
    }
    System.out.println("Total de ocorrências: " + occurenciesNumber);
  }

  public void brutalForce(String text, String[] patterns) {
    System.out.println("=========== FORÇA BRUTA ===========\n");
    for (int i = 0; i < patterns.length; i++) {
      System.out.println(patterns[i] + ": ");
      brutalForce(text, patterns[i]);
      System.out.println();
    }
  }

  private void KMP(String text, String pattern) {
    int prefixTable[] = createPrefixTable(pattern);
    int textLength = text.length();
    int patternLength = pattern.length();
    int occurenciesNumber = 0;

  }

  public void KMP(String text, String[] patterns) {
    System.out.println("=========== KMP ===========\n");
    for (int i = 0; i < patterns.length; i++) {
      System.out.println(patterns[i] + ": ");
      KMP(text, patterns[i]);
      System.out.println();
    }
  }

  private int[] createPrefixTable(String pattern) {
    int patternLength = pattern.length();
    int prefixTable[] = new int[patternLength];

    return prefixTable;
  }
}
