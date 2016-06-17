package springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.exception.SpringNotFoundException;

@Controller
public class HomeController {

	@ExceptionHandler(SpringNotFoundException.class)
	@RequestMapping(value={"/","index"},method=RequestMethod.GET)
	public String index(){
		return "index";
	}
}
