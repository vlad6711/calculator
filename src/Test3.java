import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Владислав" + separator + "IdeaProjects" + separator + "calculator" + separator + "input.txt";

        File file = new File(path);

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            try {
                String input = sc.nextLine();
                String[] str = input.split(" ");
                String a1 = str[0];
                String sign = str[1];
                if (!sign.equals("+") && !sign.equals("-") && !sign.equals("*") && !sign.equals("/")) throw new Exception("Operation Error!");
                String b1 = str[2];
                double a = Double.parseDouble(a1);
                double b = Double.parseDouble(b1);

                if (sign.equals("/") && b == 0) throw new Exception("Error! Division by zero");

                if (sign.equals("+")) System.out.println(a + b);
                else if (sign.equals("-")) System.out.println(a - b);
                else if (sign.equals("*")) System.out.println(a * b);
                else System.out.println(a / b);
            } catch (NumberFormatException e) {
                System.out.println("Error! Not number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}