import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;import java.util.Objects;
import java.util.Scanner;
public class Main {    public static void main(String[] args) {
    String exit= "";
    String confirm = "";        String outFileName = " ";
    Scanner scan = new Scanner(System.in);
    while (!Objects.equals(String.valueOf(exit), "exit")) {

        System.out.println("Какую операцию вы хотите выполнить? \n1.Шифровка\n2.Расшифровка\n3.Грубый взлом");
        int function=scan.nextInt();scan.nextLine();
        int key=0;
        exit = "";
        confirm = "";
        outFileName = "";
        String inText = "";
        String outText = "";
        outerloop:while (!Objects.equals(String.valueOf(confirm), "yes")) {
            try {

               /*
               C://Users//sava2//Downloads//ТЗ.txt
               C://Users//sava2//IdeaProjects//Caesar//Final.txt
               * */
                File myFile = new File("C://Users//sava2//IdeaProjects//Caesar//Final.txt");
                FileInputStream inputStream = new FileInputStream(myFile);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, bytesRead));
                    inText += new String(buffer, 0, bytesRead);
                }
                inputStream.close();
            } catch (Exception o) {
                System.out.println(o.getMessage());
                break outerloop;

            }
            System.out.println();
            System.out.println("Это правильный файл?(yes/no)");
            confirm = scan.nextLine();
        }
        if(function!=3){ System.out.println("Введите ключ сдвига");
        key = scan.nextInt();
        scan.nextLine();}
        //обработка текста
        switch (function){
            case 1:
                for (int i = 0; i < inText.length(); i++) {
                    if ((int) inText.charAt(i) >= 1040 & (int) inText.charAt(i) <= 1071) {
                        outText += (char) (((int) inText.charAt(i) + key - 1040) % 32 + 1040);
                    } else if ((int) inText.charAt(i) > 1071& (int) inText.charAt(i) <= 1103) {
                        outText += (char) (((int) inText.charAt(i) + key - 1072) % 32+ 1072);
                    } else if ((int) inText.charAt(i) == 32) {
                        outText += ' ';
                    } else if ((int) inText.charAt(i) == (int) 'ё') {
                        outText += (char) (((int) 'е' + key - 1072) % 32 + 1072);
                    } else if ((int) inText.charAt(i) == (int) 'Ё') {
                        outText += (char) (((int) 'Е' + key - 1040) % 32 + 1040);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < inText.length(); i++) {
                    if ((int) inText.charAt(i) >= 1040 & (int) inText.charAt(i) <= 1071) {
                        if ((int) inText.charAt(i)-key>=1040)
                        outText += (char) ((int) inText.charAt(i)-key );
                        else {
                            outText += (char) (1072-Math.abs((int) inText.charAt(i)-key-1040) );
                        }
                    } else if ((int) inText.charAt(i) > 1071& (int) inText.charAt(i) <= 1103) {
                        if ((int) inText.charAt(i)-key>=1072)
                            outText += (char) ((int) inText.charAt(i)-key );
                        else {
                            outText += (char) (1104-Math.abs((int) inText.charAt(i)-key-1072) );
                        }
                    }

                    else if ((int) inText.charAt(i) == 32) {
                        outText += ' ';
                    }
                }
                break;
            case 3:
                String[] masString=inText.split(" ");
                String BrutForce="";
                for (int i = 0; i < masString.length/2; i++) {
                    BrutForce+=masString[i]+" ";
                }

                for (int j = 1; j <31 ; j++) {
                    String outBrut="";
                    for (int i = 0; i < BrutForce.length(); i++) {
                        if ((int) BrutForce.charAt(i) >= 1040 & (int) BrutForce.charAt(i) <= 1071) {
                            if ((int) BrutForce.charAt(i)-j>=1040)
                                outBrut += (char) ((int) BrutForce.charAt(i)-j );
                            else {
                                outBrut += (char) (1072-Math.abs((int) BrutForce.charAt(i)-j-1040) );
                            }
                        } else if ((int) BrutForce.charAt(i) > 1071& (int) BrutForce.charAt(i) <= 1103) {
                            if ((int) BrutForce.charAt(i)-j>=1072)
                                outBrut += (char) ((int) BrutForce.charAt(i)-j );
                            else {
                                outBrut += (char) (1104 - Math.abs((int) BrutForce.charAt(i) - j - 1072));
                            }
                        } else if ((int) BrutForce.charAt(i) == 32) {
                            outBrut += ' ';
                        }

                    }
                    System.out.println("Сдвиг "+j+".\n"+outBrut);
                }
                System.out.println("Введите ключ сдвига");
                key = scan.nextInt();
                scan.nextLine();
                for (int i = 0; i < inText.length(); i++) {
                    if ((int) inText.charAt(i) >= 1040 & (int) inText.charAt(i) <= 1071) {
                        if ((int) inText.charAt(i)-key>=1040)
                            outText += (char) ((int) inText.charAt(i)-key );
                        else {
                            outText += (char) (1072-Math.abs((int) inText.charAt(i)-key-1040) );
                        }
                    } else if ((int) inText.charAt(i) > 1071& (int) inText.charAt(i) <= 1103) {
                        if ((int) inText.charAt(i)-key>=1072)
                            outText += (char) ((int) inText.charAt(i)-key );
                        else {
                            outText += (char) (1104-Math.abs((int) inText.charAt(i)-key-1072) );
                        }
                    }

                    else if ((int) inText.charAt(i) == 32) {
                        outText += ' ';
                    }
                }
        }



    System.out.println("Введите название файла для записи в него результата");
    outFileName = scan.nextLine()+".txt";
    System.out.println();
    File myFile = new File(outFileName);
    try {
        boolean success = myFile.createNewFile();
    } catch (Exception o) {
        System.out.println(o.getMessage());
        continue;
    }
    try (FileWriter FileOutWrite = new FileWriter(myFile, false)) {
        FileOutWrite.write(outText);
    } catch (Exception o) {
        System.out.println(o.getMessage());
        continue;
    }
    System.out.println("Файл успешно записан, чтобы выйти введите exit, либо введите любую клавишу,чтобы продолжить");
    exit = scan.nextLine();
}
}
}