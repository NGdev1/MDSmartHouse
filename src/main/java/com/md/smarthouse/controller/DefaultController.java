package com.md.smarthouse.controller;

import com.md.smarthouse.dao.SocketDataRepository;
import com.md.smarthouse.model.SocketData;
import com.md.smarthouse.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Controller
@ApiIgnore
public class DefaultController {

    private final
    SocketDataRepository socketDataRepository;

    public DefaultController(SocketDataRepository socketDataRepository) {
        this.socketDataRepository = socketDataRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap) {

        SocketData socketData = socketDataRepository.getCurrent();
        modelMap.put("data", socketData);
        modelMap.put("content", "main");

        if (Utils.isAjax(request)) {
            return "site/main";
        } else {
            return "site/index";
        }
    }
}
