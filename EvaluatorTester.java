/**
	* Class to help test your rootPackage.Evaluator:
	* javac rootPackage.EvaluatorTester
	* java rootPackage.EvaluatorTester "1+2" "3*5"
	*/
public class EvaluatorTester {
	public static void main(String[] args) {
		Evaluator evaluator = new Evaluator();
		for ( String arg : args ) {
			System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
		}
	}
}
