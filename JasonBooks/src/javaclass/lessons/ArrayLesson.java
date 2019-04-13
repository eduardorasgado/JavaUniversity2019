package javaclass.lessons;

public class ArrayLesson {

	public static void main(String[] args) {
		// Definiendo los arreglos
		
		int[][] myValues = {{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,13,14,15}};

		int[][][] threeDim = {
				{{1, 2, 3},{4, 5, 6},{7, 8, 9}},
				{{10,11,12},{13,14,15},{16,17,18}},
				{{19,20,21},{22,23,24},{25,26,27}}
		};
		
		int[][][][] fourDim = {
				{
				 {{1,2,3},
				 {4,5,6},
				 {7,8,9}
						},{
							{11,21,31},
							{41,51,61},
							{71,81,91}
					 	  		},{
					 	  			{10,11,12,},
					 		        {13,14,15},
					 		        {16,17,18}
					 		        			},{
					 		        				{19,20,21},
					 		        				{22,23,24},
					 		        				{25,26,27}
					 		        			  }
				},
				{{{28,29,30},
				  {31,32,33},
				  {34,35,36}},{{37,38,39},
							   {40,41,42},
							   {43,44,45}},{{46,47,48},
										    {49,50,52},
										    {53,54,55}},{{56,57,58},
												    	 {59,60,61},
												    	 {62,63,64}}},
					{{{65,66,67},
					  {68,69,70},
					  {71,72,73}},{{74,75,76},
								   {77,78,79},
								   {80,81,82}},{{83,84,95},
											    {86,87,88},
											    {89,90,91}},{{92,93,94},
													    	 {95,96,97},
													    	 {98,99,100}}},
					{{{101,102,103},
					  {104,105,106},
					  {108,109,110}},{{111,112,113},
									   {114,115,116},
									   {117,118,119}},{{120,121,122},
													    {123,124,125},
													    {126,127,128}},{{129,130,131},
																    	 {131,132,133},
																    	 {134,135}}}
		};
		
		// analisis de cada uno de los arreglos que tenemos
		
		System.out.println("Dos dimensiones: ");
		
		for(int[] value : myValues){
			for(int j = 0; j < value.length; j++) {
				System.out.print(value[j]+" ");
				if(j == (value.length - 1)){
					System.out.println("");
				}
			}
		}
		System.out.println("Tres dimensiones:");

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
		
		System.out.println("Cuatro dimensiones");
		
		for(int[][][] layer1 : fourDim) {
			System.out.print("[");
			for(int[][] layer2 : layer1) {
				System.out.print("[");
				for(int[] layer3 : layer2) {
					System.out.print("[");
					for(int i = 0; i < layer3.length; i++) {
						System.out.print(layer3[i]+", ");
					}
					System.out.println("]");
				}
				System.out.println("]");
			}
			System.out.print("]");
		}
		
		
		System.out.println("Cuatro dimensiones(version estructurada)");
	}

}
