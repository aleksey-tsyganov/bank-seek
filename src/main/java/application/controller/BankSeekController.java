package application.controller;

import application.entity.BankSeek;
import application.service.BankSeekService;
import application.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bnkseek")
public class BankSeekController {


    @Autowired
    private BankSeekService bankSeekService;

    @GetMapping("/search")
    public String findBankSeek(Model model, @RequestParam("keyword") String keyword) {
        if (keyword != null) {
            model.addAttribute("bankSeekList", bankSeekService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("bankSeekList", bankSeekService.getBanksList());
        }
        return "bankseek-list";
    }

    @GetMapping("/list")
    public String bnkSeekList(Model model) {
        List<BankSeek> bankSeekList = bankSeekService.getBanksList();
        model.addAttribute("bankSeekList", bankSeekList);
        return "bankseek-list";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        BankSeek bankSeek = new BankSeek();
        model.addAttribute("bankSeek", bankSeek);
        return "add-data-form";
    }

    @PostMapping("/saveBankSeek")
    public String saveBankSeek(@Valid @ModelAttribute("bankseek") BankSeek bankSeek, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bankSeek", bankSeek);
            model.addAttribute("message", "Не все поля заполнены. Обязательными являются поля, обозначенные *. " +
                    "Поле БИК должно быть уникальным");
            return "add-data-form";
        }

        if (bankSeek.getVkey().equals("")) {
            bankSeek.setVkey(AppUtils.generateVkey());
        }
        bankSeekService.saveBankSeek(bankSeek);
        return "redirect:/bnkseek/list";
    }

    @GetMapping("/delete")
    public String deleteBankSeek(@RequestParam("bankVkey") String vkey){
        bankSeekService.deleteBankSeek(vkey);
        return "redirect:/bnkseek/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bankVkey") String vkey, Model model){
        BankSeek bankSeek = bankSeekService.getBank(vkey);
        model.addAttribute("bankSeek", bankSeek);
        return "add-data-form";
    }

}

