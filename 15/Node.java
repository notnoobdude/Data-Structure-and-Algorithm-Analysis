package coe20_LabExercises;

/*
 * FABRO, DAN NINO I.			BSCpE2A_C1				#11 Laboratory Exercise
 */

public class Node {							//The node class upholding info, left, and right pointers.
	public FreshmanApplicant info;
	public Node left;
	public Node right;
	
	public Node(FreshmanApplicant d, Node l, Node r) {
		info = d;					
		left = l;
		right = r;
	}
}
