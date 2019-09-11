package kr.or.ddit.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;


//문자열 -> java.util.Date
public class CustomDateConverter implements Converter<String, Date> {
	private static final Logger logger = LoggerFactory.getLogger(CustomDateConverter.class);
	
	//<property name="reg_dt" value="2019-08-08"/>
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
