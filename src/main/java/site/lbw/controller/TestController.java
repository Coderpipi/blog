package site.lbw.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.lbw.model.vo.Result;

@RestController
public class TestController {
    @GetMapping("ping")
    public Result ping() {
        return Result.ok("pong");
    }
}
