package ioc;
/**
 * 公司名称
 * <p>
 * 本源代码由《spring》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/6/16
 */
@Component("petStoreService")
public class PetStoreServiceImpl implements PetStoreService {
    public List<String> getUserNameList() {
        return Arrays.asList("maikec_1","maikec_2","maikec_3");
    }
}
