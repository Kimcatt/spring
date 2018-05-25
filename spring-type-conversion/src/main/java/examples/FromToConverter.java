package examples;

import org.springframework.core.convert.converter.Converter;

public class FromToConverter implements Converter<FromType, ToType>{

	public ToType convert(FromType arg) {
		return new ToType(String.valueOf(arg.getName()).toUpperCase());
	}

}
