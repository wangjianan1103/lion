package com.core.lion.controller.content.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class IndexViewController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        log.info("********************");
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("name", "wjn");
        return modelAndView;
    }
}
