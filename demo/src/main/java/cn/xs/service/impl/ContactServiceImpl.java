package cn.xs.service.impl;


import cn.xs.mapper.ContactMapper;
import cn.xs.pojo.Contact;
import cn.xs.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    /**
     * 查询所有信息
     * @return
     */
    @Override
    public List<Contact> getContactList() {
        return contactMapper.getList();
    }

    /**
     * 添加一个用户
     * @param contact
     * @return
     */
    @Override
    public boolean getAddContact(Contact contact) {
        int result=contactMapper.getAdd(contact);
        if(result>0){
            return  true;
        }
        return false;
    }

    /**
     * 根据姓名进行模糊查询
     * @param cname
     * @return
     */
    @Override
    public List<Contact> getContact(String cname) {
        return contactMapper.getLike(cname);
    }


}
