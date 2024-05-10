package com.forest.drawguess.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forest.drawguess.bean.dto.SelectWordDTO;
import com.forest.drawguess.bean.dto.SubmitAnswerDTO;
import com.forest.drawguess.bean.pojo.WordsDO;
import com.forest.drawguess.bean.vo.RandomWordsVO;
import com.forest.drawguess.mapper.WordsMapper;
import com.forest.drawguess.service.WordsService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dongyang
 * @date 2021年02月07日 16:21
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WordsServiceImpl extends ServiceImpl<WordsMapper, WordsDO> implements WordsService {
    @Resource
    private WordsMapper wordsMapper;


    /**
     * 记录用户积分
     */
    private static final ConcurrentHashMap<String, Integer> SCORE = new ConcurrentHashMap<>();

    /**
     * 随机获取count个词
     *
     * @param count
     * @return
     * @author dongyang
     * @date 2021/2/7 下午4:41
     */
    @Override
    public List<RandomWordsVO> getRandomWords(Integer count) {
        ArrayList<RandomWordsVO> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(wordsMapper.getRandomWords());
        }
        return list;
    }

    /**
     * 选中题目
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:16
     */
    @Override
    @Cacheable(value = "selectOne", key = "#dto.word")
    public Integer select(SelectWordDTO dto) {
        // TODO: 2021/2/7 设置过期时间
        return dto.getId();
    }

    /**
     * 用户提交答案
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:50
     */
    @Override
    public String submit(SubmitAnswerDTO dto) {
        return null;
//        Cache cache = cacheManager.getCache("selectOne");
//        if (null != cache.get(dto.getWord())) {
//            synchronized (WordsServiceImpl.class) {
//                if (null != cache.get(dto.getWord())) {
//                    // TODO: 2021/2/7 答对，分数+1，删除缓存
//                    if (SCORE.containsKey(dto.getUserName())) {
//                        // 答对分数+1
//                        SCORE.put(dto.getUserName(), SCORE.get(dto.getUserName()) + 1);
//                    } else {
//                        // 第一次答对记1分
//                        SCORE.put(dto.getUserName(), 1);
//                    }
//                    return "回答正确";
//                } else {
//                    // TODO: 2021/2/7 并发操作，谁先获得锁谁成功
//                    return "回答错误";
//                }
//            }
//        } else {
//            // TODO: 2021/2/7 答错
//            return "回答错误";
//        }
    }

    /**
     * 词库导入
     *
     * @param words
     * @return
     * @author dongyang
     * @date 2021/2/20 下午10:06
     */
    @Override
    public String importWords(Map<String, String> words) {
        ArrayList<WordsDO> wordsDOS = new ArrayList<>(words.size());
        for (Map.Entry<String, String> entry : words.entrySet()) {
            WordsDO wordsDO = new WordsDO();
            wordsDO.setWords(entry.getKey());
            wordsDO.setTips(entry.getValue());
            wordsDOS.add(wordsDO);
        }
        saveBatch(wordsDOS);
        return "导入成功！";
    }
}
