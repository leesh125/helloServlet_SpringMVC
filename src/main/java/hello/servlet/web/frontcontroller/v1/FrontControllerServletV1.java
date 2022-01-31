package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// v1 하위에 어떤 url이 들어와도 일단 이 서블릿이 호출됨
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public FrontControllerServletV1() {
        // 매개변수 1 url 요청이 오면 , MemberFormControllerV1 생성
        controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI();// 들어온 URL을 얻을 수 있다.

        ControllerV1 controller = controllerV1Map.get(requestURI); // 요청 온 URI에 의해 Controller 객체가 다르게 호출
        if(controller == null){ // 읽어온 URI에 매치되는 Controller 객체가 없다면
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 Not Found
            return;
        }

        controller.process(request, response);

    }
}
