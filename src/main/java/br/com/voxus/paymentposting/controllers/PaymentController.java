package br.com.voxus.paymentposting.controllers;

import br.com.voxus.paymentposting.entities.Payment;
import br.com.voxus.paymentposting.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Payment> payments = paymentService.findAllPayments();
        model.addAttribute("payments", payments);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewPaymentForm(Model model){
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "new_payment";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("payment") Payment payment){
        paymentService.savePayment(payment);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPaymentForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_payment");
        Payment payment = paymentService.findPayment(id);
        mav.addObject("payment", payment);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePayment(@PathVariable(name = "id") Long id){
        paymentService.deletePayment(id);
        return "redirect:/";
    }

}
