package spring_web_app.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/footwear")
public class HelloWorldController2 {

	@GetMapping(path = { "/getmapping", "/fetchMapping" })
	public String get(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Footwear - Controller- fetchMapping");
		return "admin";
	}

	@GetMapping(path = { "/getParam" })
	public String getParam(@RequestParam(name = "name", defaultValue = "Guest") String name) {
		System.out.println("Controller-  params=name: " + name);
		return "index";
	}

	@ResponseBody
	@GetMapping(path = { "/getCustomer/{customerId}/details" })
	public String getPathVariable(@PathVariable String customerId) {
		System.out.println("Controller-  params=customerId : " + customerId);
		return "Controller-  params=customerId : " + customerId;
	}

	@RequestMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("myCookie", "DangerValue");
		cookie.setMaxAge(1110); // Cookie will expire in 1 hour
		response.addCookie(cookie);
		System.out.println("HelloWorldController2.setCookie()");
		return "redirect:/footwear/second";
	}

	@RequestMapping("/second")
	public String secondPage(
			@CookieValue(value = "myCookie", defaultValue = "defaultCookieValue1") String myCookieValue, Model model) {
		// Use myCookieValue in your controller logic
		System.out.println("HelloWorldController2.secondPage()");
		model.addAttribute("cookiesValue", myCookieValue);
		return "second";
	}

}
