package validate.person;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
@Controller
public class PersonController {
//    @Autowired
//    private PersonValidator personValidator;

    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;
    public PersonVO getVO(PersonVO vo, BindingResult bindingResult){
//        personValidator.validate(vo,bindingResult);
//        System.out.println(bindingResult.hasErrors());
        return vo.setName("maikec");
    }
    public String getVOByName(PersonVO personVO, BindingResult bindingResult){
        localValidatorFactoryBean.validate(personVO,bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        return "";
    }
    @GetMapping
    public String getVOByAge(@Validated PersonVO personVO, BindingResult bindingResult){
//        localValidatorFactoryBean.validate(personVO,bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        return "";
    }
}
