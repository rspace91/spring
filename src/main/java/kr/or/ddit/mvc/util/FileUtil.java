package kr.or.ddit.mvc.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import kr.or.ddit.util.model.FileInfo;

public class FileUtil {

	public static FileInfo getFileInfo(String originalFilename) {
		
		String path = getPath();
		
		String uuidFileName = UUID.randomUUID().toString();
		String extName = getExtension(originalFilename);
		File file = new File(path + "\\" + uuidFileName + extName);
		
		FileInfo fileInfo = new FileInfo(file, extName, originalFilename);
		fileInfo.setFile(file);
		fileInfo.setExtName(extName);
		fileInfo.setOrginalFileName(originalFilename);
		
		
		return fileInfo;
	}

	private static String getPath() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		String path = "E:\\springUpload\\"+yyyy + "\\" + mm;
		File pathFile = new File(path);
		
		if(!pathFile.exists())
			pathFile.mkdirs();
		return path;
	}

	/**
	 * 
	 * Method : getExtension
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param originalFilename
	 * @return
	 * Method 설명 : originalFilename 헤더 문자열로부터 파일 확장자 추출
	 */
	public static String getExtension(String originalFilename) {
		//확장자가 없을 경우 공백리턴
		//파일명에 .이 여러개 등장할 경우가장 마지막에 있는 녀석이 확장자 구분자로 판단
		
		int index = originalFilename.lastIndexOf(".");
		
		if(index>0) {
			return originalFilename.substring(originalFilename.lastIndexOf("."));
		}else
			return "";
	}
	
	
}
