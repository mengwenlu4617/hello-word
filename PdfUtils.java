package com.zhijian.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PdfUtils {

	/**
	 * 添加二维码
	 * 
	 * @param str
	 *            条码内容
	 * @param filepath
	 *            pdf 文件绝对路径
	 * @param l_height
	 *            水平位置
	 * @param l_weight
	 *            垂直位置
	 */
	public static void addString(String str, String filepath, int l_height, int l_weight) {
		System.out.println(System.currentTimeMillis());
		// BufferedImage localBufferedImage = null;
		// JBarcode jbcode = null;
		try {
			// 1.创建条码图像
			// jbcode = new org.jbarcode.JBarcode(Code39Encoder.getInstance(),
			// WideRatioCodedPainter.getInstance(),
			// BaseLineTextPainter.getInstance());
			// localBufferedImage = jbcode.createBarcode(str);
			// ByteArrayOutputStream bao = new ByteArrayOutputStream();
			// ImageIO.write(localBufferedImage, "png", bao);
			// Image img = Image.getInstance(bao.toByteArray());
			Image img = Image.getInstance("c:\\1.png");
			img.setAlignment(1); // 居中显示
			img.setAbsolutePosition(l_height, l_weight);// 显示位置，根据需要调整
			img.scalePercent(60); // 显示为原条形码图片大小的比例，百分比
			// 2.创建pdf输入输出流
			InputStream is = new FileInputStream(filepath);
			PdfReader reader = new PdfReader(is);
			OutputStream os = new FileOutputStream(filepath);
			PdfStamper stamp = new PdfStamper(reader, os);
			PdfContentByte contentByte = null;
			int n = reader.getNumberOfPages();
			// 3. 设置透明度
			PdfGState gs = new PdfGState();
			gs.setFillOpacity(0.7f);
			gs.setStrokeOpacity(0.7f);

			// 4.在pdf每页右上角添加条码
			for (int i = 1; i <= n; i++) {
				contentByte = stamp.getOverContent(i); // getOverContent
														// 水印会把正文盖住
														// getUnderContent
														// 水印会被正文的图片盖住
				contentByte.setGState(gs);
				contentByte.addImage(img);
				// contentByte.addImage(Image.getInstance("D:/primeton/yunda/ide/eclipse/workspace/ydsoa/com.yd.soa.budget/src/webcontent/comm/logo.jpg"));
			}
			// 5.关闭所有输入输出
			reader.close();
			stamp.close();
			// IOUtils.closeQuietly(bao);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			System.out.println(System.currentTimeMillis());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加图片水印 居中
	 * 
	 * @param imagepath
	 *            图片文件绝对路径
	 * @param filepath
	 *            pdf 文件绝对路径
	 */
	public static void addWaterImage(String imagepath, String filepath) {
		InputStream is = null;
		PdfReader reader = null;
		OutputStream os = null;
		PdfStamper stamp = null;
		try {
			// 1.创建pdf输入输出流
			is = new FileInputStream(filepath);
			reader = new PdfReader(is);
			os = new FileOutputStream(filepath);
			stamp = new PdfStamper(reader, os);

			PdfContentByte contentByte = null;
			int n = reader.getNumberOfPages();
			// 2. 设置透明度
			PdfGState gs = new PdfGState();
			gs.setFillOpacity(0.5f);
			gs.setStrokeOpacity(0.5f);
			// 3. 读取图片
			Image logo = Image.getInstance(imagepath);
			// 4.在pdf每页右上角添加条码
			for (int i = 1; i <= n; i++) {
				contentByte = stamp.getUnderContent(i); // getOverContent
														// 水印会把正文盖住
														// getUnderContent
														// 水印会被正文的图片盖住
				contentByte.setGState(gs);
				Rectangle rectangle = reader.getPageSize(i);
				float width = rectangle.getWidth();
				float height = rectangle.getHeight();
				logo.setAbsolutePosition(width / 2 - logo.getWidth() / 2, height / 2);
				contentByte.addImage(logo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			// 5.关闭所有输入输出
			reader.close();
			try {
				stamp.close();
			} catch (DocumentException e) {
			} catch (IOException e) {
			}
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			System.out.println("ok");
		}
	}

	public static void main(String[] args) {
		addString("YDHT-CG-20160525-001", "C:\\Users\\雷尉韬\\Desktop\\001.pdf", 400, 795);
		// addWaterImage("c:\\2.png", "C:\\Users\\雷尉韬\\Desktop\\001.pdf");

	}

	// jar 包下载链接http://files.cnblogs.com/files/juforg/jar.zip

}
