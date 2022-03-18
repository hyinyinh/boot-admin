package com.hy.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/12 17:04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableField(exist = false)
    String userName;
    @TableField(exist = false)
    String password;

    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
