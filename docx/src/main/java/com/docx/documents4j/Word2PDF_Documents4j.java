package com.docx.documents4j;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * 利用documents4j的方式将word转为PDF
 */
public class Word2PDF_Documents4j {
    public static void main(String[] args) {
        // 生成一个空的PDF文件
        File inputWord = new File("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.docx");
        File outputFile = new File("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.pdf");
        try (InputStream is = Files.newInputStream(inputWord.toPath());
             OutputStream os = Files.newOutputStream(outputFile.toPath())) {
            IConverter converter = LocalConverter.builder().build();
            converter.convert(is).as(DocumentType.DOCX).to(os).as(DocumentType.PDF).execute();
            converter.shutDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
