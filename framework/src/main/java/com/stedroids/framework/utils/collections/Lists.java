package com.stedroids.framework.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gastonsanguinetti on 25/07/16.
 */
public class Lists {

    public Lists() {
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... elements) {
        ArrayList list = new ArrayList();
        Collections.addAll(list, elements);
        return list;
    }

    public static <E> List<E> safeArrayList(List<E> list) {
        return (List)(list != null?list:newArrayList());
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements) {
        return elements instanceof Collection ?new ArrayList((Collection)elements):newArrayList(elements.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements) {
        ArrayList list = newArrayList();

        while(elements.hasNext()) {
            list.add(elements.next());
        }

        return list;
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList();
    }

    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> elements) {
        LinkedList list = newLinkedList();
        Iterator i$ = elements.iterator();

        while(i$.hasNext()) {
            Object element = i$.next();
            list.add(element);
        }

        return list;
    }

    public static <T> List<T> trim(List<T> list, int maxCount) {
        return (List)(list.size() > maxCount?newArrayList((Iterable)list.subList(0, maxCount)):list);
    }

    public static Boolean isNullOrEmpty(List<?> list) {
        return Boolean.valueOf(list == null || list.isEmpty());
    }


    public static boolean intersect(Collection<?> a, Collection<?> b) {
        return !Collections.disjoint(a, b);
    }
}