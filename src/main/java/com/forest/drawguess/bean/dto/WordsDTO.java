package com.forest.drawguess.bean.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 词库导入实体
 *
 * @author dongyang
 * @date 2021年02月20日 22:02
 */
@Data
public class WordsDTO {
    /**
     * key:   words
     * value: tips
     */
    private Map<String, String> words;
}
