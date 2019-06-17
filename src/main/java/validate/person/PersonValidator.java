package validate.person;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
@Component
public class PersonValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return PersonVO.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name is empty");
        PersonVO personVO = (PersonVO) target;
        if (personVO.getAge()<0){
            errors.rejectValue("age","age < 0");
        }
    }
}
