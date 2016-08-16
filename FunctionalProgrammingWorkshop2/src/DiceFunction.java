import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;

public class DiceFunction {

	@Test
	public void test() {
		System.out.println(getDiceValue());
		System.out.println(tossValue());
		System.out.println(names("Sun","Moon","Earth"));
	}
	
	Integer generator(Integer max){
		Random random =new Random();
		return random.nextInt(max);
	}
	
	
	private Integer getDiceValue() {
		return generator(6)+1;
	}
	
	private String tossValue(){
		Integer value = generator(2);
		return value%2==0 ? "Tail" : "Head"; 
	}

	private String names(String ...ns){
		Integer value = generator(ns.length);
		return ns[value];
	}
	
	Supplier<Integer> generatorFunction(Integer max) {
		Random random =new Random();
		return () -> random.nextInt(max);
	}
	
	private String namesPicker(String ...ns){
		Supplier<Integer> namePicker = generatorFunction(ns.length);
		Integer value = namePicker.get();
		return ns[value];
	}
	
	@Test
	public void testName() throws Exception {
		Supplier<Integer> dice = generatorFunction(6);
		System.out.println(dice.get()+1);
		
		Supplier<Integer> toss = generatorFunction(2);
		System.out.println(toss.get()%2==0 ? "Head" : "Tails");
		
		System.out.println(namesPicker("Sun","Moon","Earth"));
		
	}
}
