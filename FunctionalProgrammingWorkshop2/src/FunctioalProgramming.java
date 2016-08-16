import java.util.function.Function;

import org.junit.Test;

public class FunctioalProgramming {
	
	@Test
	public void testOld() {		
		/*long startTime = System.currentTimeMillis();
		System.out.println(square(2.0));
		long endTime = System.currentTimeMillis();
		long totalTime =  endTime - startTime;
		System.out.println("Time Taken(ms) = "+ totalTime);*/
		//System.out.println(timerFunction(new FunctioalProgramming() :: square).apply(2.0));
		//System.out.println(loggingFunction(new FunctioalProgramming()::square, "Square").apply(3.0));
		System.out.println(loggingFunction(timerFunction(new FunctioalProgramming() :: square), "4 inch Square").apply(4.0));
		//System.out.println(cube(2.0));
	}

	  Double square(Double x){
		
		try{
			System.out.println("Calculation Square....");
			Thread.sleep(2000);
			System.out.println("Done..");
		} catch(Exception e){
			e.printStackTrace();
		}
		Function<Double,Double> square = power(2.0);
		return square.apply(2.0);
	}
	
	/*Function<Double,Double> timerFunction(Function<Double,Double> function) {
		return x -> {
			long startTime = System.currentTimeMillis();
			Double result = function.apply(x);
			long endTime = System.currentTimeMillis();
			long totalTime =  endTime - startTime;
			System.out.println("Time Taken(ms) = "+ totalTime);
			return result;
		};
		
	}*/
	
	<T,R>Function<T, R> timerFunction(Function<T, R> function) {
		return x -> {
			long startTime = System.currentTimeMillis();
			R result = function.apply(x);
			long endTime = System.currentTimeMillis();
			long totalTime =  endTime - startTime;
			System.out.println("Time Taken(ms) = "+ totalTime);
			return result;
		};
		
	}
	
	<T, R> Function<T, R>  loggingFunction(Function<T, R> function, String ...name){
		return x -> {
			String functionName = (name.length==0) ? "NoFunction" : name[0];
			System.out.println("Enter the function "+functionName);
			R result = function.apply(x);
			System.out.println("Exit the function "+functionName);
			return result;
		};
	}
	
	static Double cube(Double x) {
		return power(x, 3.0);
	}
	
	static Double power(Double x, Double raiseTo) {
		return Math.pow(x, raiseTo);
	}
	
	@Test
	public void test() {
		Function<Double,Double> square = power(2.0);
		Function<Double,Double> cube = power(3.0);
		
		System.out.println(square.apply(2.0));
		System.out.println(cube.apply(2.0));
	}

	
	static Function<Double,Double> power(Double raiseTo){
		return x -> Math.pow(x, raiseTo);
	}
	
}


