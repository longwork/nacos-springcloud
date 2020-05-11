package wimi.masterlink.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : wenchao.long
 * @date : Created in 2020/04/29 17:24
 */
@Data
@AllArgsConstructor
@TableName("usermanagement")
public class User {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    @TableField(value = "birth")
    private String birth;
}
