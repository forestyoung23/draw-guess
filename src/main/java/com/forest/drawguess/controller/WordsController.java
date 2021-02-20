package com.forest.drawguess.controller;

import com.forest.drawguess.bean.dto.SelectWordDTO;
import com.forest.drawguess.bean.dto.SubmitAnswerDTO;
import com.forest.drawguess.bean.dto.WordsDTO;
import com.forest.drawguess.bean.vo.RandomWordsVO;
import com.forest.drawguess.service.WordsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongyang
 * @date 2021年02月07日 16:23
 */
@RestController
@RequestMapping("/words")
public class WordsController {
    @Resource
    private WordsService wordsService;

    /**
     * 随机获取count个词
     *
     * @param count
     * @return
     * @author dongyang
     * @date 2021/2/7 下午4:41
     */
    @GetMapping("getRandomWords")
    public List<RandomWordsVO> getRandomWords(@RequestParam(value = "count", defaultValue = "4") Integer count) {
        return wordsService.getRandomWords(count);
    }

    /**
     * 选中题目（出题人）
     *
     * @param
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:16
     */
    @PostMapping("select")
    public void select(@RequestBody SelectWordDTO dto) {
        wordsService.select(dto);
    }

    /**
     * 用户提交答案
     *
     * @param dto
     * @return
     * @author dongyang
     * @date 2021/2/7 下午5:49
     */
    @PostMapping("submit")
    public String submit(@RequestBody SubmitAnswerDTO dto) {
        return wordsService.submit(dto);
    }

    /**
     * 导入词库
     *
     * @param
     * @return
     * @author dongyang
     * @date 2021/2/20 下午10:01
     */
    @PostMapping("import")
    public String importWords(@RequestBody WordsDTO dto) {
        return wordsService.importWords(dto.getWords());
    }
}
