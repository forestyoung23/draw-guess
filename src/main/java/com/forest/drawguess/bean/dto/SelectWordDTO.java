package com.forest.drawguess.bean.dto;

import lombok.Data;

/**
 * 出题人选中题目实体
 *
 * @author dongyang
 * @date 2021年02月07日 17:06
 */
@Data
public class SelectWordDTO {
    private Integer id;
    private String word;
}
