package aop;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 增强
 *  @author maikec
 *  @date 2019/7/3
 */
@Aspect
@Component
public class DemoAdvice {
    @Pointcut("execution(* aop.DemoService.wave(..))")
    public void warePointCut(){};
    @Before("warePointCut()")
    public void beforeWave(){
        System.out.println("beforeWave");
    }
}
