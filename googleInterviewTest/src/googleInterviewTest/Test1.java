package googleInterviewTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

	static void getMax(ArrayList<Integer> input, int k, int[] maxNum,ArrayList<Integer> output){
		
		
		if(k==0){
			int sum=0;
			for(int v:input){
				sum*=10;
				sum+=v;
			}//calculate the number after several swaps
			
			if(sum>maxNum[0]){
				maxNum[0]=sum;
				deepCopyList(input,output);	
			}//update the results
	        return;						
		}
		
		  for (int i = 0; i < input.size() - 1; i ++) {
		        for (int j = i + 1; j < input.size(); j ++) {

		            swapList(input,i, j);//try to swap input[i] with input[j]
		            getMax(input, k - 1, maxNum,output);//take care of the other k - 1 swaps
		            swapList(input,i, j);//swap back
		        }
		    }
		   return;
	}
	
	private static void swapList(ArrayList<Integer> input, Integer i, Integer j) {

		int temp=input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
		
	}
	
	private static void deepCopyList(ArrayList<Integer> input,ArrayList<Integer> target) {

	
	//ArrayList<Integer> target=new ArrayList<Integer>(input.size());
//	if(target==null||target.size()==0){	
//		target=new ArrayList<Integer>(input.size());
//		for(int i=0;i<input.size();i++){
//			target.add(0);
//		}
//	}
	
	
	//assert(input.size()==target.size());
	for(int i = 0; i < input.size(); i ++){
		target.set(i, input.get(i));
		
	}	
	
	}

	static void swap2max(ArrayList<Integer> input, int k) {
	    if (input.size() < 2) {
	    	System.out.println("invalid input");
	    }
	    int maxNum[];
	    maxNum=new int[input.size()];
	    maxNum[0]= Integer.MIN_VALUE;
	    ArrayList<Integer> maxVec = new  ArrayList<Integer>(input.size());
	    //maxVec=deepCopyList(input,maxVec);
	    for(int i=0;i<input.size();i++){
	    	maxVec.add(0);
 		}
 	    getMax(input, k, maxNum,maxVec);//DFS function to call

 	    
 	   System.out.print("{ "); ;
	    for (int i = 0; i < input.size(); i ++) {
	    	  System.out.print(input.get(i) + " ");
	    }
	    System.out.print("} "); 
 	    
	    System.out.print(" == "+k+" swap ==>  "); 
 	    
	    //print out the results here
	    System.out.print("{ "); ;
	    for (int i = 0; i < maxVec.size(); i ++) {
	    	  System.out.print(maxVec.get(i) + " ");
	    }
	    System.out.print("} \n"); 
	    return;
	}

	
	public static void main(String[] args) {

		ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(1,3,2)); ;
	    swap2max(input1, 1);

	    ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(1,3,2)); ;
	    swap2max(input2, 2);
	    
	    ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(7,8,9,9)); ;
	    swap2max(input3, 2);
	    
	    ArrayList<Integer> input4 = new ArrayList<Integer>(Arrays.asList(8,7,9,9)); ;
	    swap2max(input4, 2);

	}
}
