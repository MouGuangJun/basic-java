package com.docx.xwpf;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 通过poi + xwpf方式将word转为pdf
 */
public class Word2PDF_XWPF {
    public static void main(String[] args) {
        try (InputStream is = Files.newInputStream(Paths.get("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.docx"));
             FileOutputStream os = new FileOutputStream("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.pdf")) {
            XWPFDocument document = new XWPFDocument(is);
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, os, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
