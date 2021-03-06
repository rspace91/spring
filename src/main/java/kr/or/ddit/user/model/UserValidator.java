package kr.or.ddit.user.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		//userId 필드는 null일 수 없고, 문자열 길이는 4글자 이상이어야 한다
//		if(user.getUserId()==null || user.getUserId().length() <=3) 
//			errors.rejectValue("userId", "required");  //필드명 , 에러코드(개발자 정의)
		
		Pattern p = Pattern.compile("^[a-zA-Z\\d\\.@]{3,20}$");
		Matcher m = p.matcher(user.getUserId());
		
		if(!m.find()) {
			errors.rejectValue("userId", "required");
		}
		
	}

}
