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
        System.out.println("Введите путь к файлу");

        outFileName = scan.nextLine();
        //C:\\Users\\sava2\\IdeaProjects\\Caesar\\Final.txt
        //C:\Users\sava2\Downloads\ТЗ.txt
        NewFileReader ReadFile= new NewFileReader(outFileName);
        String inText = ReadFile.readFile();
if(inText==null)break;
        Cod cod;
        String outText = "";
        System.out.println(inText);
        if(function!=3){
            while (key<=0|key>31) {
                System.out.println("Введите ключ сдвига(1-31)");
                key = scan.nextInt();
                scan.nextLine();
            }
        }
        //обработка текста
        cod=new Cod(inText,key);
        switch (function){
            case 1:
                outText= cod.coding();
                break;
            case 2:
               outText=cod.decoding();
                break;
            case 3:
                String[] masString=inText.split(" ");
                String BrutForce="";
                String outBrut="";
                Cod brut;
                for (int i = 0; i < masString.length/2; i++) {
                    BrutForce+=masString[i]+" ";
                }
                for (int j = 1; j <32 ; j++) {
                    brut=new Cod(BrutForce,j);
                    outBrut=brut.decoding();
                    System.out.println("Сдвиг "+j+".\n"+outBrut);
                }
                while (key<=0|key>31) {
                    System.out.println("Введите ключ сдвига(1-31)");
                    key = scan.nextInt();
                    scan.nextLine();
                }
                brut=new Cod(inText,key);
                outText= brut.decoding();
        }
    System.out.println("Введите название файла для записи в него результата");
    outFileName = scan.nextLine()+".txt";
    System.out.println();
    NewFile outFile=new NewFile(outFileName,outText);
    if(outFile.writeFile()) System.out.println("Файл успешно записан, чтобы выйти введите exit, либо введите любую клавишу,чтобы продолжить");

    exit = scan.nextLine();
}
}
}