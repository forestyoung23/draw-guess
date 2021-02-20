package com.forest.drawguess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forest.drawguess.bean.pojo.WordsDO;
import com.forest.drawguess.bean.vo.RandomWordsVO;

/**
 * @author dongyang
 * @date 2021年02月07日 16:20
 */
public interface WordsMapper extends BaseMapper<WordsDO> {
    /**
     * 随机获取
     *
     * @param
     * @return
     * @author dongyang
     * @date 2021/2/7 下午4:44
     */
    RandomWordsVO getRandomWords();
}
