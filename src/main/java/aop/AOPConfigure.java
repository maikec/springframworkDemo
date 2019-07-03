package aop;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.context.annotation.*;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/3
 */
@Configuration
@EnableAspectJAutoProxy
public class AOPConfigure {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("aop");
        context.refresh();
        final DemoService bean = context.getBean(DemoService.class);
        bean.wave();
    }
}
