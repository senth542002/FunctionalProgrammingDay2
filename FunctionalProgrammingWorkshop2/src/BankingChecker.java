import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class BankingChecker {

	@Test
	public void test() {
		
		List<Transaction> transactions = Arrays.asList();
		Transactions txns = new Transactions();
		//Function<List<Transaction>,Boolean> approvalStrategy = txns.volumeOf(transactions);
		Predicate<List<Transaction>> approvalStrategy = txns.volumeOf(transactions);
		//approvalStrategy.apply(transactions);
		approvalStrategy.test(transactions);
	}
	
	class Maker{}
	class Checker {}
	interface Transaction {}
	
	/*interface ApprovalStrategy {
		boolean approve(List<Transaction> ts);
	}*/
	
	
	class SingleMakerChecker {
		public SingleMakerChecker(Maker m, Checker c){
			
		}
		
		public SingleMakerChecker() {
		}

		public boolean approve(List<Transaction> ts) {
			System.out.println("Inside SingleMakerChecker approve");
			return true;
		}
	}

	class DoubleMakerChecker {
		public DoubleMakerChecker(Maker m, Checker c1, Checker c2){
			
		}
		
		public boolean approve(List<Transaction> ts) {
			System.out.println("Inside DoubleMakerChecker approve");
			return true;
		}
	}
	
	class Transactions{
		private Transactions(){}
		
		/*Function<List<Transaction>,Boolean> volumeOf(List<Transaction> ts){
			return new SingleMakerChecker(new Maker(), new Checker())::approve;
		}*/
		
		Predicate<List<Transaction>> volumeOf(List<Transaction> ts) {
			return new SingleMakerChecker(new Maker(), new Checker())::approve;
		}
	}
}
