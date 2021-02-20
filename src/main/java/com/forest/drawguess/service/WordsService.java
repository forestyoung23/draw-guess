package com.forest.drawguess.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.forest.drawguess.bean.dto.SelectWordDTO;
import com.forest.drawguess.bean.dto.SubmitAnswerDTO;
import com.forest.drawguess.bean.pojo.WordsDO;
import com.forest.drawguess.bean.vo.RandomWordsVO;

import java.util.List;
import java.util.Map;

/**
 * @author dongyang
 * @date 2021年02月07日 16:21
 */
public interface WordsService extends IService<WordsDO> {
    /**
     * 随机获取count个词
     *
     * @param count
     * @return
     * @author dongyang
     * @date 2021/2/7 下午4:41
     */
    List<RandomWordsVO> getRandomWords(Integer count);

    /**
     * 选中题目
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:16
     */
    Integer select(SelectWordDTO dto);

    /**
     * 用户提交答案
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:50
     */
    String submit(SubmitAnswerDTO dto);

    /**
     * 词库导入
     *
     * @param words
     * @return
     * @author dongyang
     * @date 2021/2/20 下午10:06
     */
    String importWords(Map<String, String> words);
}
