package com.zero.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Author: zero
 * @Description: Date:Create: in 2019/8/26 13:48
 * Modified By:
 */

public class MyHandler implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        // 装载模型数据和逻辑视图
        ModelAndView modelAndView = new ModelAndView();
        // 添加模型数据
        modelAndView.addObject("name","Tom");
        // 添加逻辑视图
        modelAndView.setViewName("show");

        return modelAndView;
    }
}
