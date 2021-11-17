package org.csystem.util.collection.circularqueue;

import org.csystem.collection.CircularQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class Test_size {
    private final List<String> m_list;
    private CircularQueue<String> m_testQueue;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        var list = new ArrayList<List<String>>();

        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("ayşe");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("ayşe"); add("fatma");}});

        return list;
    }

    @Before
    public void setUp()
    {
        m_testQueue = new CircularQueue<>();
    }

    public Test_size(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_size() throws IOException
    {
        for (var s : m_list)
            m_testQueue.putItem(s);

        Assert.assertEquals(m_list.size(), m_testQueue.size());

    }
}