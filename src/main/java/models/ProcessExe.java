package models;

import utilities.CustomAlerts;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class ProcessExe {
    public static boolean searchExeSignature(File exe) {
        try (RandomAccessFile raf = new RandomAccessFile(exe, "r")) {

            byte[] gettingBytes = new byte[3];
            raf.seek(0x618F3);
            raf.read(gettingBytes, 0, 3);

            boolean isValidOffset1 = gettingBytes[0] == (byte) 0x83;
            boolean isValidOffset2 = gettingBytes[1] == (byte) 0xF8;
            boolean isValidOffset3 = gettingBytes[2] == (byte) 0x64;


            if(isValidOffset1 && isValidOffset2 && isValidOffset3) {
                System.out.println("File is the correct file.");
                return true;
            } else {
                CustomAlerts.setRejectFile();
                System.out.println("It is not the correct file.");
                return false;
            }

        } catch (IOException e) {
            CustomAlerts.setRejectFile();
            System.out.println("There is an error searching magic bytes.");
            e.printStackTrace();
            return false;
        }
    }

    public static void writeExe(File exe, long offset, byte [] bytesForWrite) {
        try (RandomAccessFile raf = new RandomAccessFile(exe, "rw")) {

            raf.seek(offset);
            raf.write(bytesForWrite);

            CustomAlerts.setValidWrite();
            System.out.println("File wrote correctly!");

        } catch (IOException e) {
            System.out.println("Error: it cannot write the file!");
            e.printStackTrace();
        }
    }
}
