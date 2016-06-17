package springmvc.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springmvc.web.HomeController;

@Configuration
@EnableWebMvc//springmvc配置注解
@ComponentScan("springmvc.web")//启动组件扫描，没有这个只能显式声明在配置类中的控制器
public class WebConfig extends WebMvcConfigurerAdapter {
	//视图解析器配置
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	//静态资源的处理
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		//要求DispatcherServlet将静态资源请求转发到Servlet容器中，默认的Servlet上
		configurer.enable();
	}
	//不使用组件扫描的方式时，可以采用这种javaconfig方式
//	@Bean
//	public HomeController homeController(){
//		return new HomeController();
//	}
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
}
