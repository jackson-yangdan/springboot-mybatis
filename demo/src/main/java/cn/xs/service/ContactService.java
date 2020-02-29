package cn.xs.service;

import cn.xs.pojo.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContactList();//查询所有信息
    public boolean getAddContact(Contact contact);//添加一个用户
    public List<Contact> getContact(String cname);//根据姓名进行模糊查询

}
