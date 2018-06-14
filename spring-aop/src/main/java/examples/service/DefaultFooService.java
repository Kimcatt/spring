package examples.service;

import examples.Foo;

public class DefaultFooService implements FooService {

	@Override
	public Foo getFoo(String name, int age) {
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Foo(name, age);
	}

}
