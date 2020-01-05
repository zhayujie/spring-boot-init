package {{packageName}}.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhayujie
 * @description 获取bean的工具类
 * @date 2019/12/14
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取bean
     * @param name bean的名称，类名首字母改为小写
     * @return bean对象
     * @throws BeansException 获取失败异常
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}
