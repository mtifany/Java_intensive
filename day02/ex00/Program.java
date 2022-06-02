
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)  {
    String path = "/Users/mtifany/IdeaProjects/d02/ex00/src/com/company/signatures.txt";
    String path2 = "/Users/mtifany/IdeaProjects/d02/ex00/src/com/company/result.txt";

        Map<String, String> map = new HashMap<>();
        StringBuilder str = new StringBuilder();

    try {
        FileInputStream fin = new FileInputStream(path);
        int i;

        while ((i = fin.read()) != -1) {
            if ((char) i == '\n' || (char) i == '\0') {
                String[] line = str.toString().split(", ");
                map.put(line[1].replaceAll(" ", ""), line[0]);
                str.delete(0, str.length());
                continue;
            }
            str.append((char) i);
        }
        fin.close();
        FileOutputStream resFile = new FileOutputStream(path2);
        resFile.close();
        } catch(IOException e){
             e.printStackTrace();
        }

        String path3 = "";
        Scanner sc = new Scanner(System.in);
        while (!(path3 = sc.nextLine()).equals("42")) {
            StringBuilder str2 = new StringBuilder();
            try {
                FileInputStream imageFile = new FileInputStream(path3);
                FileOutputStream resFile = new FileOutputStream(path2, true);
                for (int i = 0; imageFile.available() > 0 && i < 10; i++) {
                    str2.append(byteToHex((byte) imageFile.read()));
                }
                for (String code : map.keySet()) {
                    if (str2.toString().toUpperCase().startsWith(code)) {
                        byte[] buffer = map.get(code).getBytes();
                        resFile.write(buffer);
                        resFile.write('\n');
                        System.out.println("PROCESSED");
                    }
                }
            imageFile.close();
            resFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}
