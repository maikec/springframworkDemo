package ioc;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
public class IOCApplicationContext {
    public static void main(String[] args) {
//        final ClassPathXmlApplicationContext classPathXmlApplicationContext =
//                new ClassPathXmlApplicationContext("spring.xml");
//        final PetStoreService petStoreService = classPathXmlApplicationContext
//                .getBean("petStore", PetStoreService.class);
//        System.out.println(petStoreService.getUserNameList());

        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("spring.xml");
        context.refresh();
        final PetStoreService petStoreService = context.getBean("petStore", PetStoreService.class);
        System.out.println(petStoreService.getUserNameList());
    }
}
