package work.home.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipTest {
    static ClassLoader cl = ZipTest.class.getClassLoader();
    @Test
    void pdfTest() throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/TestFile.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("TestFile.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            if (entry.getName().contains(".pdf")) {
                try (InputStream inputStream = zf.getInputStream(entry)) {
                    PDF pdf = new PDF(inputStream);
                    System.out.println("");
                    assertThat(pdf.text).contains("Политика конфиденциальности сервиса «Личный кабинет абонента-физического лица");
                }
            }
        }
    }
}