package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * Spring Type Conversion 
 * @author kimcatt
 * @date 2018年5月25日 下午9:52:35
 * @since JDK 1.7
 */
public class App {
	public static void main(String[] args) {
		DefaultConversionService cs = new DefaultConversionService();
		List<Integer> input = Arrays.asList(new Integer[] { 1, 3, 9, 27 });
		List<String> out = (List<String>) cs.convert(input, TypeDescriptor.forObject(input), // List<Integer> type descriptor
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));
		
		System.out.println(out.getClass());
		System.out.println(out.size());
		
		cs.addConverter(new FromToConverter());
		
		List<FromType> fromTypeList = new ArrayList<>();
		fromTypeList.add(new FromType("kim"));
		fromTypeList.add(new FromType("cat"));
		List<ToType> toTypeList = (List<ToType>)cs.convert(fromTypeList, TypeDescriptor.forObject(fromTypeList), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ToType.class)));
		System.out.println(Arrays.toString(toTypeList.toArray(new ToType[toTypeList.size()])));
		
		System.out.println(cs.convert(new FromType("john"), ToType.class));
		
	}
}
