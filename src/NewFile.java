import java.io.File;
import java.io.FileWriter;

public class NewFile {
    private String outFileName;
    private File myFile;
    private String myText;

    NewFile(String outFileName,String myText) {
        this.outFileName = outFileName;
        this.myText = myText;

    }

    boolean writeFile() {
        myFile = new File(outFileName);
        boolean success = false;
        try {
            success = myFile.createNewFile();
        } catch (Exception o) {
            System.out.println(o.getMessage());
            success = false;
        }
        try (
            FileWriter FileOutWrite = new FileWriter(myFile, false)) {
            FileOutWrite.write(myText);
        } catch (Exception o) {
            System.out.println(o.getMessage());
            success = false;
        }


        return success;
    }
}
