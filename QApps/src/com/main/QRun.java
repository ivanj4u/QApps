package com.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.util.QConstant;
import com.util.QUtil;

public class QRun {

	public static void main(String[] args) throws WriterException, IOException,
			NotFoundException {
		String data = "This is QRCode Baru";
		String fileName = "QRCode.png";
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
		testCreate(data, QConstant.FILEPATH.OUTPUT, fileName , charset, hintMap);
		testRead(QConstant.FILEPATH.INPUT, fileName, charset, hintMap);
	}

	private static void testCreate(String data, String filePath, String fileName, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintMap) throws WriterException, IOException {
		QUtil.createQRCode(data, filePath + fileName, charset, hintMap, 200, 200);
		System.out.println("QR Code image created successfully!");
		
		QUtil.copyFile(filePath, QConstant.FILEPATH.INPUT, fileName);
		System.out.println("File Successfully Copied!");
	}
	
	private static void testRead(String filePath, String fileName, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintMap) throws WriterException, IOException, NotFoundException {
		System.out.println("Data read from QR Code: "
				+ QUtil.readQRCode(filePath + fileName, charset, hintMap));
	}
	
}
