package com.ferao.pojo;/*
 * @author Ferao
 * @date
 * @discription
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class requestBodyPO {

    @JSONField(name = "username")
    private String username;
    @JSONField(name = "password")
    private String password;
    @JSONField(name = "money")
    private String money;
}
