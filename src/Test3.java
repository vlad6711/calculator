import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path1 = "C:" + separator + "Users" + separator + "Владислав" + separator + "IdeaProjects" + separator + "calculator" + separator + "input.txt";
        String path2 = "C:" + separator + "Users" + separator + "Владислав" + separator + "IdeaProjects" + separator + "calculator" + separator + "output.txt";

        File file1 = new File(path1);
        File file2 = new File(path2);

        Scanner sc = new Scanner(file1);
        PrintWriter pw = new PrintWriter(file2);

        try {
            String input = sc.nextLine();
            String[] str = input.split(" ");
            String a1 = str[0];
            String sign = str[1];
            if (!sign.equals("+") && !sign.equals("-") && !sign.equals("*") && !sign.equals("/"))
                throw new Exception("Operation Error!");
            String b1 = str[2];
            double a = Double.parseDouble(a1);
            double b = Double.parseDouble(b1);

            if (sign.equals("/") && b == 0) throw new Exception("Error! Division by zero");

            if (sign.equals("+")) pw.println(String.valueOf(a + b));
            else if (sign.equals("-")) pw.println(String.valueOf(a - b));
            else if (sign.equals("*")) pw.println(String.valueOf(a * b));
            else pw.println(String.valueOf(a / b));
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
        pw.close();
    }
}