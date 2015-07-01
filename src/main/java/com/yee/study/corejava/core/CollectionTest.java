package com.yee.study.corejava.core;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 9/4/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionTest
{
    public static void main(String [] args)
    {
        CollectionTest test = new CollectionTest();
        test.NullEntryTest();
    }

    /**
     *  测试ArrayList, HashSet
     */
    public void NullEntryTest()
    {
        List arrayList = new ArrayList();
        arrayList.add(null);
        System.out.println("Size of arrayList is " + arrayList.size());

        Set set = new HashSet();
        set.add(null);
        System.out.println("Size of set is " + set.size());

        Map hashTable = new Hashtable();
//        hashTable.put("String", null); // NullPointException will be thrown.
//        System.out.println("Size of hashTable is " + hashTable.keySet().size());

//        hashTable.put(null,"String"); // NullPointException will be thrown.
//        System.out.println("Size of hashTable is " + hashTable.keySet().size());

        Map hashMap = new HashMap();
        hashMap.put("String", null);
        System.out.println("Size of hashMap is " + hashMap.keySet().size());

        hashMap.put(null, "String");
        System.out.println("Size of hashMap is " + hashMap.keySet().size());
    }
}
