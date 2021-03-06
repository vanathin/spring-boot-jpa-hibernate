package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.Address;
import com.learning.springboothibernate.dao.AddressDAO;
import com.learning.springboothibernate.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressDAOImpl {

    @Autowired
    private AddressDAO add;

    @Autowired
    private EmployeeDAO emp;

    /*Propagation.REQUIRED*/
    @Transactional(propagation = Propagation.REQUIRED)
    public int save(Address address){
        return Optional.ofNullable(add.save(address))
                .map(Address::getId)
                .orElse(0);
    }


    /*Propagation.Propagation.MANDATORY*/
    /*@Transactional(propagation = Propagation.MANDATORY)
    public int save(Address address){
        return Optional.ofNullable(add.save(address))
                .map(Address::getId)
                .orElse(0);
    }*/
}
