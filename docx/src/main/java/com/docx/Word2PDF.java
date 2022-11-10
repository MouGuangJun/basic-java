package com.docx;


import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 通过poi + pdf-gae将word转换为PDF
 */
public class Word2PDF {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.docx");
             FileOutputStream fos = new FileOutputStream("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.pdf")) {
            // 读取文件
            XWPFDocument xwpfDocument = new XWPFDocument(fis);
            PdfOptions pdfOptions = PdfOptions.create();
            // 执行word转PDF的操作
            PdfConverter.getInstance().convert(xwpfDocument, fos, pdfOptions);
        }
    }
}
