package com.testantd.demo.mapper;

import com.testantd.demo.bean.User;
import com.testantd.demo.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserMapper extends MyMapper<User> {
	/*@Insert("insert into student(sno,sname,ssex) values(#{sno},#{name},#{sex})")
	int add(User student);

	@Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    int update(User student);

	@Delete("delete from student where sno=#{sno}")
    int deleteBysno(String sno);

	@Select("select * from student where sno=#{sno}")
	@Results(id = "student",value= {
		 @Result(property = "sno", column = "sno", javaType = String.class),
         @Result(property = "name", column = "sname", javaType = String.class),
         @Result(property = "sex", column = "ssex", javaType = String.class)
	})
	User queryStudentBySno(String sno);*/
}
