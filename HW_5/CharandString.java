package HW_5;



public class CharandString 
{
     public static void main(String [] args)
     {
         // DisplayChar_A_Z();
         // DisplayChar_a_z(); 
         // DisplayChar_А_Я();//1040 - 1071
         // DisplayChar_а_я();// 1072 - 1103
         // DisplayChar_0_9();
         // SearchWordMin();
    	    Display_asci_cod();
	 }
     
     //1. Вывести в одну строку символы:
     public static void DisplayChar_a_z()
     {
    	 int a ='a';
    	 int z ='z';
        for (int i = a; i <= z; i++) 
    	{
		System.out.print((char) i+" ");	
		}
        System.out.println();
     }
     public static void DisplayChar_А_Я()
     {
    	 int A ='А';
    	 int Ya ='Я';
        for (int i = A; i <= Ya; i++) 
    	{
		System.out.print((char) i+" ");	
		}
        System.out.println();
     }
     public static void DisplayChar_а_я()
     {
    	 int a ='а';
    	 int ya ='я';
        for (int i = a; i <= ya; i++) 
    	{
		System.out.print((char) i+" ");	
		}
        System.out.println();
     }
     public static void DisplayChar_A_Z()
     {
    	 int A ='A';
    	 int Z ='Z';
        for (int i = A; i < Z; i++) 
    	{
		System.out.print((char) i+" ");	
		}
        System.out.println();
     }
     public static void DisplayChar_0_9()
     {
    	 int zero ='0';
    	 int nine ='9';
        for (int i = zero; i < nine; i++) 
    	{
		System.out.print((char) i+" ");	
		}
        System.out.println();
     }
     public static String Display_asci_cod()
     {
    	 String result = "";
    	 for (int i = 32; i <= 126; i++) {
             char ch = (char) i;
             System.out.printf("%3s",ch);
             result+=ch;
         }
        return result;
     }
     
     //2. Написать и протестировать функции преобразования:
     
     // 2.1 целого чиста в строку
     public static String intToString(int intagrg)
     {
    	 String tempInt = "";
    	 Boolean isMinus = false;
    	 if (intagrg<0)
    	 {
    		 isMinus=true;
    		 intagrg*=-1;
		 }
    	 while (intagrg!=0) 
    	 {
    		 tempInt+=intagrg%10;
    		 intagrg/=10;
	     }
    	 String result ="";
    	 for (int i = 0; i < tempInt.length(); i++)
    	 {
    		 result+=tempInt.charAt( tempInt.length()-(1+i));
			
	     }
    	 if (isMinus) 
    	 {
			result="-"+result;
		 }
    	 if (result =="") 
    	 {
    		 result="0";
		 }
    	 return result;
     }
     // 2.2 вещественного числа в строку
     public static  String doubleToString(double dnumb)
     {
    /*	 String tempDouble = "";
    	 Boolean isMinus = false;
    	 if (dnumb<0)
    	 {
    		 isMinus=true;
    		 dnumb*=-1;
		 }
    	 while (dnumb!=0) 
    	 {
    		 tempDouble+=dnumb%10;
    		 dnumb/=10;
	     }*/
         return String.valueOf(dnumb);
     }
     //2.3 строки в целое число

     public static int StringToInt(String stringI)
     {
    	 if (stringI ==null||stringI =="")
    	 {
    		 throw new IllegalArgumentException();	
		 }
    	 Boolean isMinus = false;
    	 if (stringI.charAt(0)=='-')
    	 {
    		 isMinus=true;
		 }
         int dNumb = 0;
    	 for (int i = 0; i < stringI.length(); i++)
    	 {
    		 if ('0'<=stringI.charAt(i)&&'9'>stringI.charAt(i))
    		 {
				int res = ReturnNumb(stringI.charAt(i));
				
				dNumb+=res;
				if (i<stringI.length()-1) {
					dNumb*=10;
				}
		     }
	     }
    	 if (isMinus)
    	 {
    		 dNumb*=-1;
		 }
         return dNumb;
     }

     //2.4 строки в вещественное число////////////////////////////////
     

     public static  double StringToDouble(String stringd) {
    	 if (stringd ==null||stringd =="")
    	 {
    		 throw new IllegalArgumentException();	
		 }
    	 Boolean isMinus = false;
    	 if (stringd.charAt(0)=='-')
    	 {
    		 isMinus=true;
		 }
         double dNumb = 0;
         int pointIndeks =1;
         if (stringd.indexOf(".")!=-1)
         {
        	 pointIndeks =stringd.length() -(stringd.indexOf("."));
		 }
    	 for (int i = 0; i < stringd.length(); i++)
    	 {
    		 if ('0'<=stringd.charAt(i)&&'9'>stringd.charAt(i))
    		 {
				int res = ReturnNumb(stringd.charAt(i));
				
				dNumb+=res;
				dNumb*=10;
		     }
	     }
    	 dNumb/=Math.pow(10,pointIndeks);
    	 if (isMinus)
    	 {
    		 dNumb*=-1;
		 }
         return dNumb;
     }
     
     private static int ReturnNumb(char numb)
     {	int result = 0;
		switch (numb)
		{
		case '0': result = 0;break;
		case '1': result = 1;break;
		case '2': result = 2;break;
		case '3': result = 3;break;
		case '4': result = 4;break;
		case '5': result = 5;break;
		case '6': result = 6;break;
		case '7': result = 7;break;
		case '8': result = 8;break;
		case '9': result = 9;break;
		}
		return result;
     }
     
     public static  double dDouble(String string) {
         double i = 0;
         try {
             i = Double.parseDouble(string);
         } catch (NumberFormatException e) {
             e.printStackTrace();
         }
         return i;
     }
     /////////////////////////////////////////////////////////////////
     
     
     //3. Написать и протестировать функции работы со строками:
     
     //3.1 Дана строка, состоящая из слов, разделенных пробелами и знаками препинания. Определить длину самого короткого слова.
     
     public static int SearchWordMin(String words )
     {
    	if (words == null||words =="")
    	{
    		throw new IllegalArgumentException();
    	}
    	int count = 0;
    	int min =0;
    	words=words.toLowerCase();
    	for (int i = 0; i < words.length(); i++)
    	{
    		if ((words.charAt(i)>='a'&&words.charAt(i)<='z')||(words.charAt(i)>='а'&&words.charAt(i)<='я')||(words.charAt(i)>='0'&&words.charAt(i)<='9'))
    		{
    			count++;
			}
    		else if (words.charAt(i)==' '||words.charAt(i)=='.'||words.charAt(i)==','||words.charAt(i)==':'||words.charAt(i)==';'||words.charAt(i)=='?'||words.charAt(i)=='!'||words.charAt(i)=='-')
    		{
    			if(min==0)
    			{
    				min=count;
    			}
    			else if(min>count&&count>1)
    			{
    				min=count;
    			}
    			count=0;
			}
		}
    	return min;
     }
     
     // 3.2 Дан массив слов. Заменить последние три символа слов, имеющих заданную длину на символ "$"
     public static void ReplaseThreeWord_on_$(String [] words)
     {
 		if (words == null) {
			throw new IllegalArgumentException();
		}
 		for (int i = 0; i < words.length; i++) {
			
 			if (words[i].length()-3>0) {
 				words[i]=words[i].substring(0, words[i].length()-3);
				words[i]+="$";
			}
		}
     }
     // 3.3 Добавить в строку пробелы после знаков препинания, если они там отсутствуют.
     public static String addSpaceThenMarks(String  wordString)
     {
 		if (wordString == null) {
			throw new IllegalArgumentException();
		}
 		wordString = wordString.replaceAll("[,]", ", ").replaceAll("[.]", ". ").replaceAll("[:]", ": ").replaceAll("[;]", "; ").replaceAll("[?]", "? ").replaceAll("[!]", "! ").replaceAll("[-]", "- ").replaceAll("[_]", "_ ");
 		return wordString;
     }
     //3.4 Оставить в строке только один экземпляр каждого встречающегося символа.
     public static String oneCharInString(String  wordString)
     {
 		if (wordString == null)
 		{
			throw new IllegalArgumentException();
		}
 		String result = null;
 		String sb="";
		char ch = ' ';
		while (!wordString.isEmpty()) {
			ch = wordString.charAt(0);
			sb+=ch;
			wordString = wordString.replaceAll("["+ch+"]", "");
		}
		result = sb.toString();
 		return result;
     }
     
     //3.5 Подсчитать количество слов во введенной пользователем строке.
     
     public static int CountWord(String words )
     {
    	if (words == null) 
    	{
    		throw new IllegalArgumentException();
   		}
    	int result=0;
        String [] arrayStr=	words.split("[.\\,\\:\\;\\?\\!\\-\\ ]");
        for  (int i = 0; i < arrayStr.length; i++) 
        {
		if (arrayStr[i].length()>0)
		{
			result++;	
		}	
		}
    	return result;
     }
     
     // 3.6 Удалить из строки ее часть с заданной позиции и заданной длины.
     
     public static String ReplaceString(int startPosition,int Lenght, String words )
     {
    	if (words == null||words =="")
    	{
    		throw new IllegalArgumentException();
   		}
    	 else if ((startPosition + Lenght) > words.length()||(startPosition+ Lenght<0))
    	 {
 			throw new IllegalArgumentException();
 		 }
    	String result ="";
    	for (int i = 0; i < words.length(); i++) 
    	{
			if ((i<startPosition)||(i>=(startPosition + Lenght)))
			{
				result+=words.charAt(i);
			} 
		}
    	return result;
     }
     //3.7 Перевернуть строку, т.е. последние символы должны стать первыми, а первые последними.
     public static String PolindromString(String words )
     {
    	if (words == null||words =="")
    	{
    		throw new IllegalArgumentException();
   		}
    	String result = "";
         char [] arrayChar = words.toCharArray();
 		int arrLeght = arrayChar.length;
 		for (int i = 0; i < arrLeght / 2; i++) {
 			char temp = arrayChar[i];
 			arrayChar[i] = arrayChar[arrLeght -(1+ i)];
 			arrayChar[arrLeght -(1+ i)] = temp;
 		}
 		result= new String(arrayChar);
    	return result;
     }
     
     
     //3.7 В заданной строке удалить последнее слово
     
     public static String DeleteLatWord(String word )
     {
    	if (word == null||word =="") 
    	{
    		throw new IllegalArgumentException();
   		}
    	 String result="";
    	 word.trim();
    	 result=word.substring(0,word.lastIndexOf(' ') );
    	 return result;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
