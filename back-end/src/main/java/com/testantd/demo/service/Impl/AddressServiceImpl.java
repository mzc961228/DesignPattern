package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Address;
import com.testantd.demo.mapper.AddressMapper;
import com.testantd.demo.service.AddressService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public Address getAddressById(Integer id, Integer userId) {
        return addressMapper.getAddressDetail(userId,id);
    }

    @Override
    public Address saveAddress(Address address) {
        if (address.getId() == null || address.getId() == 0){
            addressMapper.insertSelective(address);
        }else {
            addressMapper.updateByPrimaryKeySelective(address);
        }
        // 如果设置为默认，则取消其它的默认
        if (address.getIs_default() == 1){
            Example example = new Example(Address.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andNotEqualTo("id",address.getId());
            criteria.andCondition("user_id = ",address.getUser_id());
            Address updateAddress = new Address();
            updateAddress.setIs_default(0);
            addressMapper.updateByExampleSelective(updateAddress,example);
        }
        return addressMapper.selectByPrimaryKey(address.getId());
    }

    @Override
    public List<Address> getAddressesByUserId(Integer userId) {
//        Example example = new Example(Address.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andCondition("user_id = ",userId);
//        example.setOrderByClause("id desc");
        return addressMapper.getAddressesByUserId(userId);
    }

    @Override
    public void deleteAddress(Integer id,Integer userId) {
        Example example = new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("id = ",id);
        criteria.andCondition("user_id = ",userId);
        Address address = new Address();
        address.setIs_delete(1);
        addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public Address getAddressById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
