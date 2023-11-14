package com.viazone.thymeleafapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @RequestMapping("/showform")
    public String showForm(){
        return "input-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "string-output";
    }


    @RequestMapping("/processFormVersionTwo")
    public String processForm1(HttpServletRequest request, Model theModel){
       //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        //convert all data to upper case
        theName = theName.toUpperCase();
        //create the message

        String result = "Yo !"+theName;
        //adding the message to the model
        theModel.addAttribute("message",result);


        return "output";
    }

    @RequestMapping("/processFormVersionThree")
    public String processForm2(@RequestParam("studentName") String theName, Model theModel){
        //read the request parameter from the HTML form
        //convert all data to upper case
        theName = theName.toUpperCase();
        //create the message

        String result = "Hello !!!!! "+theName;
        //adding the message to the model
        theModel.addAttribute("message",result);


        return "string-output";
    }

    @PostMapping("/processFormVersionThree")
    public String processForm3(@RequestParam("studentName") String theName, Model theModel){
        //read the request parameter from the HTML form
        //convert all data to upper case
        theName = theName.toUpperCase();
        //create the message

        String result = "Hello !!!!! "+theName;
        //adding the message to the model
        theModel.addAttribute("message",result);


        return "string-output";
    }

    @PostMapping("/processProductAddForm")
    public String processProductAdd(
                                    @RequestParam("pName") String pName,
                                    @RequestParam("pDesc") String pDesc,
                                    @RequestParam("pCat") String pCat,
                                    @RequestParam("pPrice") String pPrice,

                                    Model theModel
                                    )
    {
        //read the request parameter from the HTML form
        //convert all data to upper case
        //theName = theName.toUpperCase();
        //create the messag
        //adding the message to the model
        theModel.addAttribute("pName",pName);
        theModel.addAttribute("pDesc",pDesc);
        theModel.addAttribute("pCat",pCat);
        theModel.addAttribute("pPrice",pPrice);


        return "productconfirm";
    }
}
