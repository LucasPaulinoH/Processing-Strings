import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    private static File textFile = new File("E:/Repositórios GitHub/Processing-Strings/Processing Strings/teste.txt");
    private static Scanner sc;
    private static String text = "";

    private static void readFile() throws FileNotFoundException {
        sc = new Scanner(textFile);

        while (sc.hasNextLine()) {
            text += sc.nextLine();
        }
    }

    public static void main(String[] args) throws Exception {
        ProcessString process = new ProcessString();

        final String patterns[] = { "TATATAAGAAAAAAG",
                "AGACTCTG",
                "GAGAGCGG",
                "TCCTCCCAC" };

        readFile(); // realiza a leitura do arquivo que contém o texto

        process.brutalForce(text, patterns);
    }
}
