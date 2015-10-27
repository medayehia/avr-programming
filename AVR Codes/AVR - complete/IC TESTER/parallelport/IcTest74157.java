//IcTest74157.java
//Testing IC74157

import javax.swing.JOptionPane;
import parport.ParallelPort1;


public class IcTest74157
{
	public void result74157()
	{
	 	out t=new out();
		ParallelPort1 lpt1=new ParallelPort1(0x378);
		int inp,ret,fin1[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin2[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin3[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin4[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin5[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin6[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin7[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},fin8[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
		String string=" ";
		Declaration declaration=new Declaration();
		lpt1.writeControlPort(0x0b);
		declaration.DDRB(0xf6);//setting upperside of  gate
		declaration.DDRD(0xed);//setting lowerside of  gate	
		
		
		//check E=1	
		declaration.PORTB(0xff);
		declaration.PORTD(0xfe);
		
		inp=declaration.PIND();
		ret=declaration.BITCHK(inp,4,fin1,1);
		ret=declaration.BITCHK(inp,7,fin2,1);
		inp=declaration.PINB();
		ret=declaration.BITCHK(inp,8,fin3,1);
		ret=declaration.BITCHK(inp,5,fin4,1);
		
		//check for S and D1=1111 and D0=0000
		declaration.PORTB(0x92);
		declaration.PORTD(0xa4);
		
		inp=declaration.PIND();
		ret=declaration.BITCHK(inp,4,fin1,2);
		ret=declaration.BITCHK(inp,7,fin2,2);
		inp=declaration.PINB();
		ret=declaration.BITCHK(inp,8,fin3,2);
		ret=declaration.BITCHK(inp,5,fin4,2);
		//s=0
		declaration.PORTD(0x24);
		inp=declaration.PIND();
		ret=declaration.BITCHK(inp,4,fin1,3);
		ret=declaration.BITCHK(inp,7,fin2,3);
		inp=declaration.PINB();
		ret=declaration.BITCHK(inp,8,fin3,3);
		ret=declaration.BITCHK(inp,5,fin4,3);
		
		//s and D0=1111
		declaration.PORTB(0xa4);
		declaration.PORTD(0xc8);
		
		inp=declaration.PIND();
		ret=declaration.BITCHK(inp,4,fin1,4);
		ret=declaration.BITCHK(inp,7,fin2,4);
		inp=declaration.PINB();
		ret=declaration.BITCHK(inp,8,fin3,4);
		ret=declaration.BITCHK(inp,5,fin4,4);
		//s=0
		declaration.PORTD(0x48);
		inp=declaration.PIND();
		ret=declaration.BITCHK(inp,4,fin1,5);
		ret=declaration.BITCHK(inp,7,fin2,5);
		inp=declaration.PINB();
		ret=declaration.BITCHK(inp,8,fin3,5);
		ret=declaration.BITCHK(inp,5,fin4,5);
			
				
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		if(t.dec(fin1)==18&&t.dec(fin2)==18&&t.dec(fin4)==18&&t.dec(fin3)==18)
		string+="\n IC IS GOOD";
		else
		string+="\n IC IS BAD"+" "+t.dec(fin1)+" "+t.dec(fin2)+" "+t.dec(fin3)+" "+t.dec(fin4);		
		
		
		JOptionPane.showMessageDialog(null,string,"Test Result of Ic74157",
		JOptionPane.INFORMATION_MESSAGE);
	}//end of main
	
	
public static class out
	{			
		public void prin(int inp)
		{
			int a,b[]={0,0,0,0,0,0,0,0,},i;
			a=inp;
			for(i=0;a!=0;i++)
			{
				b[i]=a%2;
				a=a/2;
			}
			
		}
		public int dec(int a[])
		{
		int i;
		i=((a[1]*1)+(a[2]*2)+(a[3]*4)+(a[4]*8)+(a[5]*16)+(a[6]*32)+(a[7]*64)+(a[8]*128));
		return(i);
		}
	}
}
