package work.home.tests;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zzz {
    static ClassLoader cl = zzz.class.getClassLoader();
    public static void main(String[] args) throws Exception {
        InputStream is = cl.getResourceAsStream("TestFile.zip");
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry.getName());
//            String entryName = entry.getName();
//            if (entryName.equals("test.png")) ;
        }
    }
}