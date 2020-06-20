package com.testantd.demo.mapper;

import com.testantd.demo.bean.Address;
import com.testantd.demo.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AddressMapper extends MyMapper<Address> {

    @Select("SELECT *, r1.`name` AS province_name, r2.`name` AS city_name,r3.`name` AS district_name,CONCAT(r1.`name`,r2.`name`,r3.`name`) as full_region FROM hiolabs_address a LEFT JOIN hiolabs_region r1 ON a.province_id = r1.id LEFT JOIN hiolabs_region r2 ON a.city_id = r2.id LEFT JOIN hiolabs_region r3 ON a.district_id = r3.id where a.user_id = #{userId} and a.is_delete = 0")
    List<Address> getAddressesByUserId(Integer userId);

    @Select("SELECT *, r1.`name` AS province_name, r2.`name` AS city_name,r3.`name` AS district_name,CONCAT(r1.`name`,r2.`name`,r3.`name`) as full_region FROM hiolabs_address a LEFT JOIN hiolabs_region r1 ON a.province_id = r1.id LEFT JOIN hiolabs_region r2 ON a.city_id = r2.id LEFT JOIN hiolabs_region r3 ON a.district_id = r3.id where a.user_id = #{userId} and a.id = #{id}  and a.is_delete = 0")
    Address getAddressDetail(Integer userId, Integer id);

    @Select("SELECT *, r1.`name` AS province_name, r2.`name` AS city_name,r3.`name` AS district_name,CONCAT(r1.`name`,r2.`name`,r3.`name`) as full_region FROM hiolabs_address a LEFT JOIN hiolabs_region r1 ON a.province_id = r1.id LEFT JOIN hiolabs_region r2 ON a.city_id = r2.id LEFT JOIN hiolabs_region r3 ON a.district_id = r3.id where a.user_id = #{userId} and a.is_delete = 0 and a.is_default = 1")
    Address selectDefaultAddress(Integer userId);

    @Select("SELECT *, r1.`name` AS province_name, r2.`name` AS city_name,r3.`name` AS district_name,CONCAT(r1.`name`,r2.`name`,r3.`name`) as full_region FROM hiolabs_address a LEFT JOIN hiolabs_region r1 ON a.province_id = r1.id LEFT JOIN hiolabs_region r2 ON a.city_id = r2.id LEFT JOIN hiolabs_region r3 ON a.district_id = r3.id where a.user_id = #{userId} and a.is_delete = 0 and a.id = #{addressId}")
    Address selectAddressById(Integer addressId, Integer userId);
}
