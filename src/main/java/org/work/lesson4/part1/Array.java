package org.work.lesson4.part1;

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static <E> List<E> bringOutUniqueElements(List<E> list) {
        List<E> uniqueElements = new ArrayList<>();
        for (E element : list) {
            int intBuffer = 0;
            for (int i = 0; i < list.size(); i++) {
                if (element.equals(list.get(i))) {
                    intBuffer++;
                    if (intBuffer > 1) {
                        break;
                    }
                }
                if (i == list.size() - 1) {
                    uniqueElements.add(element);
                }
            }
        }
        return uniqueElements;
    }
//      Для себя: Вариант на много лучше
//    public static <E> List<E> map(List<E> list) {
//        List<E> newList = new ArrayList<>();
//        Map<E, Integer> map = new HashMap<>();
//
//        for (E e : list) {
//            map.put(e, map.getOrDefault(e, 0)+ 1);
//        }
//        for (E e : list) {
//            if (map.get(e)==1){
//                newList.add(e);
//            }
//        }
//        return newList;
//    }
}
