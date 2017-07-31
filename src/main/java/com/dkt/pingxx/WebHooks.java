package com.dkt.pingxx;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by linkd on 2017/7/5.
 */
@RestController
@Scope("session")
public class WebHooks {

    @RequestMapping("/payment/callback")
    public void eventListener(@RequestBody WebHooksEvent event){

        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return;
    }
}
