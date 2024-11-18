package tvr.spring.dataeng.hive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tvr.spring.dataeng.hive.helper.HiveJDBCClient;

@RestController
public class MyWorld {
    @Autowired
    HiveJDBCClient client;
    @GetMapping("/")
    public String myWorld(){
        try {
            return "Hello MyWorld "+ client.runQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
