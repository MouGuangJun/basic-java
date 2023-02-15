package com.docx.openoffice;


import org.jodconverter.DocumentConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/*
 * 通过openoffice/libreoffice的方式将word转为PDF
 */
@Service
public class Word2PDF_Openoffice {
    @Autowired
    private DocumentConverter documentConverter;

    public void convert() throws Exception {
        File sourceFile = new File("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.docx");
        File pdfFile = new File("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.pdf");
        documentConverter.convert(sourceFile)
                .as(DefaultDocumentFormatRegistry.DOCX)
                .to(pdfFile)
                .as(DefaultDocumentFormatRegistry.PDF).execute();
    }

}
