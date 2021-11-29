/*
    createData metodunda belli bir tohum değeri üretilmiş rasgele string'ler doldurunuz. Test metodunda
    yine aynı tohum değeriyle aynı sayıda string üretip dlinkedlist'e atınız. Yine test metodunda rasgele bir
    poziyondaki string'i alıp dlinkedlist içerisinde aynı konumda olup olmadığını test ediniz
*/

package org.csystem.util.collection.dlinkedlist;

import org.csystem.collection.DLinkedList;
import org.csystem.util.string.StringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@RunWith(Parameterized.class)
public class Test_findFirstItemIndex_Random_TODO {
    private static final Random ms_random = new Random();
    private final List<String> m_list;
    private DLinkedList<String> m_testList;

    @Parameterized.Parameters
    public static Collection<List<String>> createData()
    {
        var list = new ArrayList<List<String>>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>(){{add("ali");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("veli"); add("ayşe");}});
        list.add(new ArrayList<>(){{add("ali"); add("veli"); add("selami"); add("ali");}});
        list.add(new ArrayList<>(){{add("ali"); add("ayşe"); add("veli"); add("selami"); add("ayşe"); add("fatma");}});

        return list;
    }

    @Before
    public void setUp()
    {
        m_testList = new DLinkedList<>();
        m_list.forEach(m_testList::addItemTail);
    }

    public Test_findFirstItemIndex_Random_TODO(List<String> list)
    {
        m_list = list;
    }

    @Test
    public void test_findFirstItemIndex()
    {
        String str = "";

        if (!m_list.isEmpty()) {
            var random = new Random();
            var pos = random.nextInt(m_list.size());
            str = m_list.get(pos);
        }

        Assert.assertEquals(m_list.indexOf(str), m_testList.findFirstItemIndex(str));
    }

    @Test
    public void test_findFirstItemIndexNotFound()
    {
        var str = "Muhammet";

        Assert.assertEquals(-1, m_testList.findFirstItemIndex(str));
    }

    @Test
    public void test_findFirstItemIndexRandom()
    {
        var random = new Random();
        var str = StringUtil.getRandomTextTR(random, random.nextInt(10) + 5);

        Assert.assertEquals(m_list.indexOf(str), m_testList.findFirstItemIndex(str));
    }
}
