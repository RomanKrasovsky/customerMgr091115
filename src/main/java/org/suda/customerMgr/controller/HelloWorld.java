package org.suda.customerMgr.controller;

/**
 * Created by user1 on 09.11.15.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suda.customerMgr.domain.Customer;
import org.suda.customerMgr.service.api.CustomerService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class HelloWorld {

//    @Autowired
//    private CustomerService customerService;

    @WebMethod(operationName="getHelloWorld")
    public List<Customer> getHelloWorld(String name) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        CustomerService customerService = (CustomerService) context.getBean("customerServiceImpl");
        return customerService.listCustomer();

    }

}