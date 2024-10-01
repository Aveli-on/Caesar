import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

public class NewFileReader {

    private String puth;
    private String inText = "";
    File myFile;
    NewFileReader(String puth){
        this.puth=puth;
        myFile = new File(puth);

    }
    String readFile(){
        try {
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
        }
        return inText;
    }




}
