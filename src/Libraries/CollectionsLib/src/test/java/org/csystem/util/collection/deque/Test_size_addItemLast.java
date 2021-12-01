package org.csystem.util.collection.deque;

import org.csystem.collection.Deque;
import org.csystem.util.collection.factory.StringDataFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_size_addItemLast {
    private final List<String> m_list;
    private Deque<String> m_testDeque;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        return StringDataFactory.getData();
    }

    @Before
    public void setUp()
    {
        m_testDeque = new Deque<>();
    }

    public Test_size_addItemLast(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_size()
    {
        m_list.forEach(m_testDeque::addItemLast);

        Assert.assertEquals(m_list.size(), m_testDeque.size());
    }
}
