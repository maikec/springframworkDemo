package validate.person;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
@Configuration
@PropertySource("validate.properties")
public class ValidateConfigure {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

}
