package com.meijia.common.result.model;

import com.meijia.common.result.BaseModel;
import lombok.*;

/**
 * @author kaiser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {

    private Long id;

    private String name;

    private Integer age;

}
