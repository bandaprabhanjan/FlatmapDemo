package com.prabhanjan.flatmap.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlatMapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatMapDemoApplication.class, args);
		Integer value1 = null;
		Integer value2 = new Integer(10);
		Optional<Integer> a = Optional.ofNullable(value1);
		System.out.println(a);
		Optional<Integer> b = Optional.of(value2);
		System.out.println(b);
		Integer sum = sum(a, b);
		System.out.println(sum);
		UserBean userBean1 = new UserBean("Prabhanjan", 30, Arrays.asList(123, 789));
		UserBean userBean2 = new UserBean("Ravi", 35, Arrays.asList(111, 222));
		UserBean userBean3 = new UserBean("Praveen", 40, Arrays.asList(101, 102));
		List<UserBean> userList = new ArrayList<UserBean>();
		userList.add(userBean1);
		userList.add(userBean2);
		userList.add(userBean3);
		Optional<Integer> findAnyPhoneNumber = userList.stream().map(user -> user.getPhoneNumber().stream())
				.flatMap(stringStream -> stringStream.filter(phoneNumber -> phoneNumber.equals(123))).findAny();
		Optional<Integer> findAny = userList.stream().map(element -> element.getPhoneNumber().stream())
				.flatMap(ele -> ele.filter(phoneNbr -> phoneNbr.equals(999))).findAny();
		Stream<Integer> listOfPhoneNumbers = userList.stream().flatMap(element -> element.getPhoneNumber().stream());
		listOfPhoneNumbers.forEach(System.out::println);

		System.out.println(findAny);
		System.out.println(findAnyPhoneNumber);

	}

	private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());
		Integer value1 = a.orElse(new Integer(0));
		System.out.println(value1);
		Integer value2 = b.get();
		return value1 + value2;
	}

}
