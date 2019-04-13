package javaclass.lessons;

public class ArrayLesson {

	public static void main(String[] args) {
		int[][] myValues = {{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,13,14,15}};

		int[][][] threeDim = {
				{{1, 2, 3},{4, 5, 6},{7, 8, 9}},
				{{10,11,12},{13,14,15},{16,17,18}},
				{{19,20,21},{22,23,24},{25,26,27}}
		};
		for(int[] value : myValues){
			for(int j = 0; j < value.length; j++) {
				System.out.print(value[j]+" ");
				if(j == (value.length - 1)){
					System.out.println("");
				}
			}
		}
		System.out.println("tres dimensiones");

		for(int[][] value : threeDim){
			for(int j = 0; j < value.length; j++) {
				if(j == 0){
					System.out.print("[");
				} 
				System.out.print("[");
				for(int k = 0; k < value[j].length;k++){
					System.out.print(value[j][k]);
					if(k != (value[j].length - 1)){
						System.out.print(",");
					} else{
						System.out.print("]");
					}
				}
				if(j == (value.length - 1)){
					System.out.println("]");
				} else {
					System.out.print(",");
				}
			}
		}
	}

}
