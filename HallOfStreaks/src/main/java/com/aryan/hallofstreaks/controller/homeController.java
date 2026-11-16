package com.aryan.hallofstreaks.controller;
import com.aryan.hallofstreaks.tracker.exisitingStreak;
import com.aryan.hallofstreaks.tracker.stats;
import org.springframework.ui.Model;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

    @GetMapping("/")
    public String home(Model model) throws IOException {

        exisitingStreak tracker = new exisitingStreak();

        tracker.execute();

        model.addAttribute("name", tracker.getName());
        model.addAttribute("currentStreak", tracker.getCurrentStreak());
        model.addAttribute("longestStreak", tracker.getLongestStreak());
        model.addAttribute("totalWords", tracker.getTotalWords());
        model.addAttribute("XP", tracker.getXP());
        model.addAttribute("daysWritten", tracker.getDaysWritten());
        model.addAttribute("daysMissed", tracker.getDaysMissed());

        model.addAttribute("rankName",tracker.getRank());
        model.addAttribute("rankXp", tracker.getRankXp());
        model.addAttribute("totalXp", tracker.getTotalXP());
        model.addAttribute("xpFilled", tracker.getXpFilled());

        stats OBJ = new stats();
        OBJ.compute();
        model.addAttribute("grammar", OBJ.getGrammar());
        model.addAttribute("vocabulary", OBJ.getVocabulary());
        model.addAttribute("flow", OBJ.getFlow());
        model.addAttribute("impact", OBJ.getImpact());


        model.addAttribute("gP", OBJ.getGrammar()*10);
        model.addAttribute("vP", OBJ.getVocabulary()*10);
        model.addAttribute("fP", OBJ.getFlow()*10);
        model.addAttribute("iP", OBJ.getImpact()*10);

        return "index";
    }

    @PostMapping("/submit")
    public String submit(
            @RequestParam String paragraph,
            @RequestParam double grammar,
            @RequestParam double vocabulary,
            @RequestParam double flow,
            @RequestParam double impact
    )throws IOException{
        exisitingStreak obj = new exisitingStreak();
        obj.execute();
        obj.resumeStreak(paragraph);
        stats review = new stats();
        review.enterGrammar(grammar);
        review.enterVocabulary(vocabulary);
        review.enterFlow(flow);
        review.enterImpact(impact);
        review.enter();
        return "redirect:/";
    }
}
