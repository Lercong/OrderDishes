//百词斩笔试题么么哒

package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
	private static int PriceCap;
	private static int OrderNum;
	private static int FoodNum;
	private static int price=0;
	private static int num=0;

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Sample Input:");
		PriceCap=sc.nextInt();//预订价
		OrderNum=sc.nextInt();//想点
		FoodNum=sc.nextInt();//餐厅可点
		Object[] foodnums= new Object[FoodNum];
		for(int i=0;i<FoodNum;i++) {
			foodnums[i]=sc.nextInt();
		}
		
		ArrayList<Object[]> rs=cmn(foodnums,OrderNum);
        for(int i=0;i<rs.size();i++)
        {
//            System.out.print(i+"=");
            for(int j=0;j<rs.get(i).length;j++)
            {
            	price=price+Integer.parseInt(String.valueOf(rs.get(i)[j]));
              // System.out.print(rs.get(i)[j]+",");
                
              
            }
           // System.out.println("价格"+price);
            if(price<=PriceCap) {
            	num=num+1;
            }
			//System.out.println();
			price=0;
        }
        
        System.out.println("Sample Output:");
    	System.out.println(num);
	}

    static ArrayList<Object[]> cmn(Object[] source,int OrderNum)
    {
        ArrayList<Object[]> result=new ArrayList<Object[]>();
        int n=1;
        if(OrderNum==1)
        {
            for(int i=0;i<source.length;i++)
            {
                result.add(new Object[]{source[i]});

            }
        }
        else if(source.length==OrderNum)
        {
            result.add(source);
        }
        else
        {
            Object[] psource=new Object[source.length-1];
            for(int i=0;i<psource.length;i++)
            {
                psource[i]=source[i];
            }
            result=cmn(psource,OrderNum);          
            ArrayList<Object[]> tmp=cmn(psource,OrderNum-1);
           
            for(int i=0;i<tmp.size();i++)
            {
                Object[] rs=new Object[OrderNum];
                for(int j=0;j<OrderNum-1;j++)
                {
                    rs[j]=tmp.get(i)[j];
                }
                rs[OrderNum-1]=source[source.length-1];
                result.add(rs);
            }
        }
        n++;
        return result;
    }
}
