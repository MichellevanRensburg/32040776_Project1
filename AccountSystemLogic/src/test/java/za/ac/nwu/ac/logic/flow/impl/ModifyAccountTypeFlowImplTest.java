package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ModifyAccountTypeFlowImplTest {
    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private ModifyAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteAccountType() {
    }

    @Test
    public void updateAccountType() {
    }
}