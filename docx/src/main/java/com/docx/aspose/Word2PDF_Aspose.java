package com.docx.aspose;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 利用Aspose的方式将word转为PDF
 */
public class Word2PDF_Aspose {
    public static void main(String[] args) {
        // 生成一个空的PDF文件
        File file = new File("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729_水印.pdf");
        try (FileOutputStream os = new FileOutputStream(file);
             //凭证 不然切换后有水印
             InputStream is = new ClassPathResource("/license.xml").getInputStream()) {
            License aposeLic = new License();
            aposeLic.setLicense(is);

            //要转换的word文件
            Document doc = new Document("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.docx");
            doc.save(os, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
