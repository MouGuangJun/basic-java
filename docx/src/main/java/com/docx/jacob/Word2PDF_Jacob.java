package com.docx.jacob;

/**
 * 将word转换为pdf的方式
 * 需要将jacob-1.20-x64.dll拷贝到jdk1.8.0_181/jre/bin下面
 */
public class Word2PDF_Jacob {
    public static void main(String[] arg) {
        String docPath = "D:\\Word转PDF\\poi笔记.docx";
        String pdfPath = "D:\\Word转PDF\\poi笔记.pdf";
        boolean res = Word2PdfJacobUtil.word2PDF(docPath, pdfPath);
        System.out.println(res);
    }
}
