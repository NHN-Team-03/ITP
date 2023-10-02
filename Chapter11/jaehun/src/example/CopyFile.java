package Chapter11.jaehun.src.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
    public static void main(String[] args) {
        String sourceName;
        String copyName;

        InputStream source;
        OutputStream copy;
        boolean force;

        int byteCount;

        if(args.length == 3 && args[0].equalsIgnoreCase("-f")) {
            sourceName = args[1];
            copyName = args[2];
            force = true;
        }
        else if(args.length == 2) {
            sourceName = args[0];
            copyName = args[1];
            force = false;
        } else {
            System.out.println("Usage: java CopyFile <source-file> <copy-name>");
            System.out.println("    or java CopyFile -f <source-file> <copy-name>");
            return;
        }

        try {
            source = new FileInputStream(sourceName);
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file \"" + sourceName + "\".");
            return;
        }

        File file = new File(copyName);

        if(file.exists() && force == false) {
            System.out.println("Output file exists. Use the -f option to replace it.");
            return;
        }


        try {
            copy = new FileOutputStream(copyName);
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file \"" + copyName + "\".");
            return;
        }

        byteCount = 0;

        try {
            while (true) {
                int data = source.read();
                if(data < 0) {
                    break;
                }

                copy.write(data);
                byteCount++;
            }
            source.close();
            copy.close();
            System.out.println("Successfully copied " + byteCount + "bytes.");
        } catch (IOException e) {
            System.out.println("Error occurred while copying. " + byteCount + "byte copied.");
            System.out.println("Errir: " + e);
        }
    }
}
