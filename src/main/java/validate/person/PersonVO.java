package validate.person;/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class PersonVO {
    @NotNull(message = "Name is null")
    private String name;
    @Max(100)@Min(0)
    private Integer age;
}
