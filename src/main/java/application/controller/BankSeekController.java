package application.controller;

import application.entity.*;
import application.service.*;
import application.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Autowired
    private RegService regService;

    @Autowired
    private PznService pznService;

    @Autowired
    private UerService uerService;

    @Autowired
    private TnpService tnpService;

    @GetMapping("/search")
    public String findBankSeek(Model model, @RequestParam("keyword") String keyword) {

        if (!keyword.isEmpty()) {
            model.addAttribute("bankSeekList", bankSeekService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("bankSeekList", bankSeekService.getBanksList());
        }
        return "bankseek-list";
    }

    @GetMapping("/searchPzn")
    public String findBankByPzn(Model model, @RequestParam("pzn") String keyword) {

        if (!keyword.equals("ALL")) {
            model.addAttribute("bankSeekList", bankSeekService.findBankByPzn(keyword));
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
        getAllModels(model);
        BankSeek bankSeek = new BankSeek();
        model.addAttribute("bankSeek", bankSeek);
        return "add-data-form";
    }

    @PostMapping("/saveBankSeek")
    public String saveBankSeek(@Valid @ModelAttribute("bankseek") BankSeek bankSeek, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            getAllModels(model);
            model.addAttribute("bankSeek", bankSeek);
            model.addAttribute("message", "Не все поля заполнены. Обязательными являются поля, обозначенные *");
            return "add-data-form";
        }

        if (bankSeek.getVkey().equals("")) {
            bankSeek.setVkey(AppUtils.generateVkey());
        }
        try {
            bankSeekService.saveBankSeek(bankSeek);
        }
        catch (DataIntegrityViolationException err) {
            getAllModels(model);
            model.addAttribute("bankSeek", bankSeek);
            model.addAttribute("message", "Поле БИК должно быть уникальным");
            return "add-data-form";
        }
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
        getAllModels(model);
        return "add-data-form";
    }

    public void getAllModels(Model model){
        List<Reg> regList = regService.getRegList();
        model.addAttribute("regList", regList);

        List<Pzn> pznList = pznService.getPznList();
        model.addAttribute("pznList", pznList);

        List<Uer> uerList = uerService.getUerList();
        model.addAttribute("uerList", uerList);

        List<Tnp> tnpList = tnpService.getTnpList();
        model.addAttribute("tnpList", tnpList);

    }

}

