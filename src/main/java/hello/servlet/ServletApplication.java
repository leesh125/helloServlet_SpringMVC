package hello.servlet;

import hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

// 프로젝트 패키지의 하위 패키지들 중에 서블릿을 찾아서 자동으로 등록한다
@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
/*	스프링 빈 수동 설정으로 @Controller 없이 @RequestMapping 만으로 핸들러 매핑
	@Bean
	SpringMemberFormControllerV1 springMemberFormControllerV1(){
		return new SpringMemberFormControllerV1();
	}
*/
}
