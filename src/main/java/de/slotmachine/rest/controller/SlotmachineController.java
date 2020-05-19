package de.slotmachine.rest.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.slotmachine.rest.dao.SlotmachineDAO;
import de.slotmachine.rest.dao.SpinResultDAO;
 
@RestController
public class SlotmachineController 
{
    @Autowired
    private SlotmachineDAO slotmachineDao;
     
    @GetMapping(path="/", produces = "application/json")
    public String getStartPage() 
    {
        return "Hi! Please use /spin to spin.";
    }
     
    @GetMapping(path = "/spin", produces = "application/json")
    public SpinResultDAO getSpinResult() {
        return slotmachineDao.getSpinResult();
    }
}