package com.yqp.config;

/**
 * @author YuQingPeng
 * @Date 2022/7/8 000814:56
 * @Description TODO
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//告诉spring容器,我是一个配置类
public class RegistInterceptor implements WebMvcConfigurer {

    @Autowired//自动装配
    private MyInterceptor a ;


    /**
     * 添加拦截器-进行拦截
     * addPathPatterns 添加拦截
     * excludePathPatterns 排除拦截
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(a)
                .addPathPatterns("/**")
                //====== 以下为不需要拦截的地址 ======
                //跳转到登录页
                .excludePathPatterns("/login/loginIn")
                //跳转到登出成功页
                .excludePathPatterns("/login/loginOut")
                //主页面
                .excludePathPatterns("/")
                //静态资源
                .excludePathPatterns("/css/*")
                .excludePathPatterns("/js/*")
                .excludePathPatterns("/img/*");
    }


}
