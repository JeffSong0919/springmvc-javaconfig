package springmvc.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.util.Log4jConfigListener;

public class MyServletInitializer implements WebApplicationInitializer {
	// 设置filter，listener，Servlet配置
	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		arg0.addListener(Log4jConfigListener.class);
		Dynamic filter = arg0.addFilter("encodingFilter",
				CharacterEncodingFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/custom/*");
	}

}
