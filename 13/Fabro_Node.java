package coe20_LabExer;
/*
 * FABRO, DAN NINO I.					BSCpE2A_C1					COE20 Lab Exercise 9
 */


public class Fabro_Node{
    public int exponentX,exponentY,coefficient;			//This class represents the nodes. A node consists of a container for the coefficients,
    public Fabro_Node proceed;								//and exponents of x and y. Every node also has a link section wherein it connects to the
    public Fabro_Node(int x,int y, int z)					//next node. This node consists of coefficients, exponents for x and y--hence, it can be
    {												//incurred that every node is a term of the polynomial input.
        coefficient=x;
        exponentX=y;
        exponentY=z;
    }
}
