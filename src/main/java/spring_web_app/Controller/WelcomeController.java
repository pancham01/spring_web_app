package spring_web_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
//	@ResponseBody
	@RequestMapping("/")
	public String message()
	{
		System.out.println("message() called...................");
		return "index1.jsp";
	}
}
