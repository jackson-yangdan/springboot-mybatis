package cn.xs.controller;

import cn.xs.pojo.Contact;
import cn.xs.service.ContactService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/contact")
public class UserController {
    @Autowired
    private ContactService contactService;

    /**
     * 显示所有信息
     * @param model
     * @param start1
     * @param size
     * @return
     */
    @RequestMapping("main")
    public String getList(Model model, @RequestParam(value = "start1", defaultValue = "0") Integer start1, @RequestParam(value = "size", defaultValue ="3") Integer size){
        PageHelper.startPage(start1,size);
        List<Contact> contacts=contactService.getContactList();
        PageInfo<Contact> page=new PageInfo<Contact>(contacts);
        model.addAttribute("page",page);
       return "main";
    }


    /**
     * 显示添加页面
     * @return
     */

    @RequestMapping("add")
    public String getAdd(){
        return "addContact.html";
    }

    /**
     *添加信息
     * @param model
     * @param contact
     * @return
     */
    @RequestMapping("insert")
    public String insert(Model model, Contact contact){
        boolean result=contactService.getAddContact(contact);
        if(result){
            return "redirect:/contact/main";

        }else{
            return "redirect:/contact/add";
        }


    }

//    @RequestMapping("getLike")
//    public String getLike(Model model,@RequestParam("cname")String cname){
//        List<Contact> contacts=contactService.getContact(cname);
//        if(contacts!=null){
//            return "main";
//        }
//        else{
//            return "main";
//        }
//    }


}
