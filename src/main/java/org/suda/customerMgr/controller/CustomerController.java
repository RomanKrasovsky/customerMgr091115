package org.suda.customerMgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suda.customerMgr.domain.Customer;
import org.suda.customerMgr.scala.HelloScala;
import org.suda.customerMgr.service.api.CustomerService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public HelloScala HELLO;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String loadAddCustomer(Map<String, Object> map) {
        map.put("customer", new Customer());
        return "customer";
    }

    @RequestMapping("/list")

    public String listCustomer(Map<String, Object> map) {

        map.put("customer", new Customer());
        map.put("customerList", customerService.listCustomer());
        return "listCustomers";
    }

    @RequestMapping("/modal")
    public String listCustomer2(Map<String, Object> map) {
        return "modal";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer";
        }
        customerService.addCustomer(customer);
        return "customer";
    }

    @RequestMapping(value = "/edit/edit{customerId}", method = RequestMethod.POST)
    public String edit(@ModelAttribute("customer") @Valid Customer customer, BindingResult result)  {
        if (result.hasErrors()) {
            return "modal";
        }
        customerService.editCustomer(customer);
        return "redirect:/list";
    }
   @RequestMapping(value = "/edit/{customerId}")
    public String editCustomer( Map<String, Object> map, @PathVariable("customerId") Integer customerId ) {
       map.put("customer", new Customer());
       map.put("List", customerService.editCustomerforObject(customerId));
        return "edit";
    }
    @RequestMapping(value = "/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.removeCustomer(customerId);
        return "redirect:/list";
    }
    @RequestMapping(value = "/list/{customerId}")
    public String deleteCustomer2(Map<String, Object> map,@PathVariable("customerId") Integer customerId) {
    map.put("message", customerService.editCustomerforObject(customerId));
        return "rest";
    }
}
