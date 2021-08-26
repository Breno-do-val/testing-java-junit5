package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.exceptions.OupsHandlerWithNoArgumentException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oupsHandler(String name){
        if (name != "method") {
            throw new OupsHandlerWithNoArgumentException("No string name passed!");
        }
        return "notimplemented " + name;
    }
}
