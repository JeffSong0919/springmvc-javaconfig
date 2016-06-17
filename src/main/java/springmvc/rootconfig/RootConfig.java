package springmvc.rootconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//除了web的组件的bean扫描
//excludeFilters是排除扫描的包，因为在webConfig中已经扫描了，这里扫面的是除了EnableWebMvc的其他组件
@ComponentScan(basePackages={"springmvc"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

}
