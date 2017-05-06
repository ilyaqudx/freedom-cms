package com.iquizoo.core.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 对象 排序
 * 
 * @author Jianxing Wen
 * @date 2016-7-20上午9:16:45
 * @param <E>
 */
public class SortList<E> {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Sort(List<E> list, final String method, final String sort) {
		Collections.sort(list, new Comparator() {
			public int compare(Object a, Object b) {
				int ret = 0;
				try {
					Method m1 = ((E) a).getClass().getMethod(method, null);
					Method m2 = ((E) b).getClass().getMethod(method, null);
					
					if (sort != null && "desc".equals(sort)){// 倒序
						ret = m2.invoke(((E) b), null).toString().compareTo(m1.invoke(((E) a), null).toString());
					}else{
						// 正序
						ret = m1.invoke(((E) a), null).toString().compareTo(m2.invoke(((E) b), null).toString());
					}
					
					} catch (NoSuchMethodException ne) {
					System.out.println(ne);
				} catch (IllegalAccessException ie) {
					System.out.println(ie);
				} catch (InvocationTargetException it) {
					System.out.println(it);
				}
				return ret;
			}
		});
	}
}
