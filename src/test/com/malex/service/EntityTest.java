package com.malex.service;

import com.malex.configuration.AppConfigTest;

import com.malex.model.Bank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@WebAppConfiguration
public class EntityTest extends AbstractTransactionalJUnit4SpringContextTests {

    //

    @Autowired
    private BankService bankService;

    @Test
    @Rollback
    public void testCreate_1_0() {
        //given
        Bank expectBank = new Bank();
        expectBank.setName("ABB");



        //when
        Bank actualBank = bankService.save(expectBank);
        // then

        assertEquals(expectBank, actualBank);
    }


}
