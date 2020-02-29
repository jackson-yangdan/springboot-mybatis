package cn.xs.mapper;

import cn.xs.pojo.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactMapper {

    public List<Contact> getList();//查询所有信息
    public int getAdd(Contact contact);//添加一个用户
    public List<Contact> getLike(@Param("cname")String cname);//根据姓名进行模糊查询
}
