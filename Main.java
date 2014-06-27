
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main{
	
	public static int checkAP(int [] input){
		int cd = input[1] - input[0];
		if(cd == input[2] - input[1])
			return cd;
		else
			return 10001;
	}

	public static int checkGP(int [] input){
		int sf = input[1]/input[0];
		if(sf == input[2]/input[1])
			return sf;
		else
			return 10001;
	}

	public static int[] convertToInts(String [] input){
		int [] arr = new int[input.length];
		for(int i = 0 ;i<input.length;i++){
			arr[i] = Integer.parseInt(input[i]);
		}
		return arr;
	}

	public static void main(String args[]) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = reader.readLine();
			if(line.equals("0 0 0"))
				break;
			String [] inputs = line.split(" ");
			int [] input = convertToInts(inputs);
			int cd = checkAP(input);
			if(cd > 10000){
				int sf = checkGP(input);
				if(sf < 10000){
					int next = input[2]*sf;
					System.out.println("GP "+next);
				}
			}else{
				int next = input[2] + cd;
				System.out.println("AP "+next);
			}
		}
	}
}

