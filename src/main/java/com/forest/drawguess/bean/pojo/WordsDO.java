package com.forest.drawguess.bean.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 词库
 *
 * @author dongyang
 * @date 2021年02月07日 16:17
 */
@Data
@TableName("words")
public class WordsDO {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String words;

    /**
     * 提示
     */
    private String tips;

    /**
     * 创建时间
     */
    private Date createTime;
}
