package com.forest.drawguess.bean.dto;

import lombok.Data;

/**
 * 用户提交答案实体
 *
 * @author dongyang
 * @date 2021年02月07日 17:48
 */
@Data
public class SubmitAnswerDTO {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 提交的答案
     */
    private String word;
}
