package validate.person;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
public class Start{

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        final ValidateConfigure configure = new ValidateConfigure();
        annotationConfigApplicationContext.scan("validate");
        annotationConfigApplicationContext.refresh();
        final PersonController personController = annotationConfigApplicationContext.getBean(PersonController.class);
        System.out.println(personController.getVO(new PersonVO("maikec",-1),new MapBindingResult(new HashMap<String,String>(),"3")));
        personController.getVOByAge(new PersonVO(null,-1),new MapBindingResult(new HashMap<String,String>(),"age"));


        personController.getVOByName(new PersonVO(null,10),new MapBindingResult(new HashMap<String,String>(),"name"));
    }
}
