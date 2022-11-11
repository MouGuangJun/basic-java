package com.docx;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 给pdf添加水印
 */
public class PDFWater {
    private static final int INTERVAL = 5;
    private static final int FONT_SIZE = 30;
    private static final String FONT_DIALOG = "C:\\Windows\\Fonts\\SIMYOU.TTF";


    public static void main(String[] args) throws Exception {
        String waterMark = "logotext";

        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            // 原PDF文件
            reader = new PdfReader("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729.pdf");
            stamper = new PdfStamper(reader, Files.newOutputStream(Paths.get("D:\\Word转PDF\\项目周报新模板-浙商银行20220725-20220729-水印.pdf")));
            PdfGState gs = new PdfGState();
            // 设置透明度
            gs.setFillOpacity(0.3f);
            gs.setStrokeOpacity(0.4f);

            JLabel label = new JLabel();
            label.setText(waterMark);
            label.setFont(new Font(FONT_DIALOG, Font.PLAIN, FONT_SIZE));
            FontMetrics metrics = label.getFontMetrics(label.getFont());
            // 文字高
            int textH = metrics.getHeight();
            // 文字宽
            int textW = metrics.stringWidth(label.getText());

            //页数
            int totalPage = reader.getNumberOfPages() + 1;
            // 水印的字体
            BaseFont baseFont = BaseFont.createFont(FONT_DIALOG, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            for (int i = 1; i < totalPage; i++) {
                com.itextpdf.text.Rectangle pageRect = reader.getPageSizeWithRotation(i);
                // 水印在文字的上面
                PdfContentByte over = stamper.getOverContent(i);
                over.saveState();
                // 设置透明度
                over.setGState(gs);
                over.beginText();
                // 设置水印字体、大小
                over.setFontAndSize(baseFont, FONT_SIZE);

                for (int height = INTERVAL + textH; height < pageRect.getHeight(); height = height + textH * 4) {
                    for (int width = INTERVAL + textW; width < pageRect.getWidth() + textW; width = width + textW * 2) {
                        over.showTextAligned(Element.ALIGN_LEFT, waterMark, width - textW, height - textH, 30);
                    }
                }

                over.endText();
            }
        } finally {
            // 关闭
            if (stamper != null) stamper.close();
            if (reader != null) reader.close();
        }
    }
}
