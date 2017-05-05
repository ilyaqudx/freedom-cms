package freedom.cms;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.code.kaptcha.servlet.KaptchaServlet;

@Configuration
public class WebAppConfigurer 
        extends WebMvcConfigurerAdapter {

	@Value("${kaptcha.session.key}")  
    private String skey;  
      
    @Value("${kaptcha.textproducer.font.color}")  
    private String fcolor;  
      
    @Value("${kaptcha.textproducer.font.size}")  
    private String fsize;  
      
    @Value("${kaptcha.obscurificator.impl}")  
    private String obscurificator;  
      
    @Value("${kaptcha.noise.impl}")  
    private String noise;  
      
    @Value("${kaptcha.image.width}")  
    private String width;  
      
    @Value("${kaptcha.image.height}")  
    private String height;  
      
    @Value("${kaptcha.textproducer.char.length}")  
    private String clength;  
      
    @Value("${kaptcha.textproducer.char.space}")  
    private String cspace;  
      
    @Value("${kaptcha.background.clear.from}")  
    private String from;  
      
    @Value("${kaptcha.background.clear.to}")  
    private String to;  
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    
    @Bean   
    public ServletRegistrationBean servletRegistrationBean() throws ServletException{  
    	ServletRegistrationBean servlet =  new ServletRegistrationBean(new KaptchaServlet(),"/images/kaptcha.jpg");
        servlet.addInitParameter("kaptcha.border", "no"/*kborder*/);//无边框  
        servlet.addInitParameter("kaptcha.session.key", Constants.KAPTCHA_SESSION_KEY);//session key  
        servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);  
        servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);  
        servlet.addInitParameter("kaptcha.obscurificator.impl", obscurificator);  
        servlet.addInitParameter("kaptcha.noise.impl", noise);  
        servlet.addInitParameter("kaptcha.image.width", width);  
        servlet.addInitParameter("kaptcha.image.height", height);  
        servlet.addInitParameter("kaptcha.textproducer.char.length", clength);  
        servlet.addInitParameter("kaptcha.textproducer.char.space", cspace);  
        servlet.addInitParameter("kaptcha.background.clear.from", from); //和登录框背景颜色一致   
        servlet.addInitParameter("kaptcha.background.clear.to", to);  
        return servlet;
    }  

}