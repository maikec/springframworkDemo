package resouce;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import ioc.PetStoreService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/28
 */
public class ResourcesMain {
    public static void main(String[] args) throws Exception{
        final ClassPathResource classPathResource = new ClassPathResource("spring.xml");
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext(classPathResource.getPath());
        final PetStoreService petStore = classPathXmlApplicationContext.getBean("petStore", PetStoreService.class);
        System.out.println(petStore.getUserNameList());
        classPathXmlApplicationContext.close();
    }
}
