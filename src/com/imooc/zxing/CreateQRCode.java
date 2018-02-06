package com.imooc.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//生成二维码
public class CreateQRCode {

	public static void main(String[] args) {
		int width = 300;
		int height = 300;
		String format = "png";
		String content = "test";
		String name = "test";
		//定义二维码参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//字符集编码类型
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级,一般用M
		hints.put(EncodeHintType.MARGIN,2);
		
		//生成二维码
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			
			Path file = new File("E:/000work/workspace/" + name + ".png").toPath();
			
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
