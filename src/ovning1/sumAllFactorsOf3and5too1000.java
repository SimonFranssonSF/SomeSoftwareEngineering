package ovning1;

public class sumAllFactorsOf3and5too1000 {
	public static void main(String[] args){
		new sumAllFactorsOf3and5too1000();
	}
	
	public sumAllFactorsOf3and5too1000(){
		int summa = 0;
		for(int i = 0; i < 1000; i++){
			if(i % 3 == 0 || i % 5 == 0){
				summa += i;
			}
		}
		System.out.println(summa);
	}

}
