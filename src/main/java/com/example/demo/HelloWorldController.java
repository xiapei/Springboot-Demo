package com.example.demo;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class HelloWorldController {

  @RequestMapping("/helloPage")
  public String helloPage(HashMap<String, Object> map) {
    map.put("helloYou", "欢迎进入你的世界");
    map.put("helloMe", "欢迎进入我的世界");
    return "/demo/helloWorld";
  }

  @ResponseBody
  @RequestMapping("/helloString")
  public HashMap<String, Object> helloString() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("helloWorld", "欢迎进入Hello World");
    return map;
  }
}
