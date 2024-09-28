package spring_web_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
//	@RequestMapping("/login")
//	public String display(HttpServletRequest req, Model m) {
//		
//		String name = req.getParameter("name");
//		String pass = req.getParameter("pass");
//		
//		System.out.println("HelloWorldController.display()");	
//		if (name.equals("kunal") && pass.equals("admin")) {
//			String msg = "HELLO " + name + " Now ALL YOURS IN MVC";
//			// add a message to the model
//			m.addAttribute("message", msg);
//			return "viewPage";
//		} else {
//			String msg = "Sorry " + name + ". You entered an incorrect name or password";
//			m.addAttribute("message", msg);
//			return "errorPage";
//		}
//	}

	@RequestMapping("/login")
	public String display(@RequestParam(name = "name") String name, @RequestParam(name = "pass") String pass, Model m) {
		System.out.println("HelloWorldController.display()");	
		if (name.equals("kunal") && pass.equals("admin")) {
			String msg = "HELLO " + name + " NOW ALL YOURS";
			// add a message to the model
			m.addAttribute("message", msg);
			return "viewPage";
		} else {
			String msg = "Sorry " + name + ". You entered an incorrect name or password";
			m.addAttribute("message", msg);
			return "errorPage";
		}
	}

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

}
