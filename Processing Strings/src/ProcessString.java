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
    int occurenciesNumber = 0, comparisonsNumber = 0;

    int i = 0, j = 0;
    while (i < textLength) {
      if (pattern.charAt(j) == text.charAt(i)) {
        comparisonsNumber++;
        j++;
        i++;
      }
      if (j == patternLength) {
        occurenciesNumber++;
        System.out.println("Comparações até o índice " + (i - j) + ": " + comparisonsNumber);
        comparisonsNumber = 0;
        j = prefixTable[j - 1];
      } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
        comparisonsNumber++;
        if (j != 0) {
          j = prefixTable[j - 1];
        } else {
          i++;
        }
      }
    }
    System.out.println("Total de ocorrências: " + occurenciesNumber);
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
    int prefixSize = 0;
    int i = 1;
    prefixTable[0] = 0;

    while (i < patternLength) {
      if (pattern.charAt(i) == pattern.charAt(prefixSize)) {
        prefixSize++;
        prefixTable[i] = prefixSize;
        i++;
      } else {
        if (prefixSize != 0) {
          prefixSize = prefixTable[prefixSize - 1];
        } else {
          prefixTable[i] = prefixSize;
          i++;
        }
      }
    }

    return prefixTable;
  }
}
