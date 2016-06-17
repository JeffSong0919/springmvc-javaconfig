package springmvc.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import springmvc.rootconfig.RootConfig;
import springmvc.webconfig.WebConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	 
	@Override
	protected void customizeRegistration(Dynamic registration) {
		//设置load-on-startup优先级
		registration.setLoadOnStartup(1);
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/springmvc/uploads"));
	}
}
