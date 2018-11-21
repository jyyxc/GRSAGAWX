package com.jyyx.example.springbootdemo.service.impl.test;


import com.jyyx.example.springbootdemo.entity.test.CbtTestConfig;
import com.jyyx.example.springbootdemo.entity.test.TestTran;
import com.jyyx.example.springbootdemo.mapper.test.CbtTestConfigMapper;
import com.jyyx.example.springbootdemo.mapper.test.TestTranMapper;
import com.jyyx.example.springbootdemo.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestTranMapper testTranMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(TestTran record) {
        return testTranMapper.insert(record);
    }

    @Override
    public int insertSelective(TestTran record) {
        return 0;
    }

    @Override
    public TestTran selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TestTran record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TestTran record) {
        return 0;
    }
}
