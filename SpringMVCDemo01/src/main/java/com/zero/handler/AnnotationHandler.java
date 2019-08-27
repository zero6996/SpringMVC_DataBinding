package com.zero.handler;

import com.zero.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: zero
 * @Description: Date:Create: in 2019/8/26 15:55
 * Modified By:
 */

// 基于注解实现映射
@Controller
public class AnnotationHandler {

    /**
     * 业务方法1：ModelAndView完成数据的传递，视图的解析
     */
    @RequestMapping("/modelAndViewTest")
    public ModelAndView modelAndViewTest(){
        // 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 填充模型数据
        modelAndView.addObject("name","Tom");
        // 设置逻辑视图
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /**
     * 业务方法2：Model传值，String进行视图解析
     * @return
     */
    @RequestMapping("/modelTest")
    public String ModelTest(Model model){
        // 填充模型数据
        model.addAttribute("name","Jerry");
        // 设置逻辑视图
        return "show";
    }

    /**
     * 业务方法3：Map传值，String进行视图解析
     */
    @RequestMapping("/mapTest")
    public String MapTest(Map<String,String> map){
        // 填充模型数据
        map.put("name","Cat");
        // 设置逻辑视图
        return "show";
    }

    /**
     * 添加商品并展示
     */
    @RequestMapping("/addGoods")
    public ModelAndView addGoods(Goods goods){
        System.out.println(goods.getName()+""+goods.getPrice());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
