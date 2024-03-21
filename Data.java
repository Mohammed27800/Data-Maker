import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Data {
    static Scanner scan = new Scanner(System.in);
    static Scanner scan1 = new Scanner(System.in);

    static int Size;
    static String Path;
    static final int Giga = 134217728;
    public static void main(String[] args) {
        inputs();
        createfile(Pathconvert(Path));
        writedata(Size,Path);
        System.out.println("Done");
    }
    

    static String Pathconvert(String Path){
        String newstr = "";
        String[] PathArray = new String[Path.length() * 2];
        for (int i = 0; i < Path.length(); i++) {
            if(Path.charAt(i) == '\\'){
                PathArray[i] = "\\" + "\\";
            }
            else {
                PathArray[i] = String.valueOf(Path.charAt(i));
            }
        }

        for (String string : PathArray) {
            if(string != null){
                newstr += string;
            }
            
        }
        return newstr;
    }

    static void inputs() {
        System.out.println("Input your Data Size (GB)");
        Size = scan.nextInt();

        System.out.println("Select the Path of data : ");
        Path = scan1.nextLine();
        if(Path == ""){
            Path = System.getProperty("user.dir");
        }
    }

    static void createfile(String Path) {
        try {
            new File(Path + "\\Data.txt");

        } catch (Exception e) {
            System.out.println("Error on createing file");
        }
    }

    static void writedata(long Data_Size, String Path) {
        

        try {
            FileWriter myobj = new FileWriter(Path + "\\Data.txt");
            System.out.println("Loading ...");
            for (int i = 0; i < Giga * Data_Size; i++) {
                myobj.write("01010101");

            }

            myobj.close();
        } catch (Exception e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

    }

}