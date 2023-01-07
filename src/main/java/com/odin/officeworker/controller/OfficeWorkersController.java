package com.odin.officeworker.controller;

import com.odin.officeworker.entity.HistoryEntity;
import com.odin.officeworker.model.FormModel;
import com.odin.officeworker.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class OfficeWorkersController {

    private boolean status = false;

    @Autowired
    HistoryRepository historyRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model){

        model.addAttribute("status", status);
        status = false;

        return "index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertDate(@ModelAttribute FormModel formModel, Model model){
        Map scoreMap = new HashMap();
        scoreMap.put("스바르트",4);
        scoreMap.put("두라스로르",4);
        scoreMap.put("모네가름",4);
        scoreMap.put("드라우그",4);
        scoreMap.put("굴베이그",4);
        scoreMap.put("메기르",5);
        scoreMap.put("신마라",5);
        scoreMap.put("헤르가름",5);
        scoreMap.put("탕그리스니르",5);
        scoreMap.put("엘드룬",5);
        scoreMap.put("7층 드라우그",4);
        scoreMap.put("최하층 강글로티",4);
        scoreMap.put("최하층 굴베이그",4);
        scoreMap.put("아우둠라",4);
        scoreMap.put("티르",5);
        scoreMap.put("토르",5);
        scoreMap.put("오딘",5);

        String[] arrays = formModel.getBoss().split(",");

        int score = 0;
        for(String boss : arrays) {
            score += (int)scoreMap.get(boss);
        }

        String uuid = UUID.randomUUID().toString();

        HistoryEntity history = new HistoryEntity();
        history.setId(uuid);
        history.setNick(formModel.getNick());
        history.setBoss(formModel.getBoss());
        history.setScore(score);
        history.setDate(new Timestamp(System.currentTimeMillis()));

        historyRepository.save(history);

        System.out.println(formModel.getNick());
        System.out.println(formModel.getBoss());
        System.out.println(score);

        status = true;
        return "redirect:/";
    }
}
