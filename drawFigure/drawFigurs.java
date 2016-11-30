package drawFigure;

public class drawFigurs
{
		public static void main(String[] args) {
		//	squareleWithStars();
		//	squareHollow();
		  //   draw_X_fromStars();
		//	draw_Isosceles_triangle_1();
		//	draw_Isosceles_triangle_2();
		//	draw_Isosceles_triangle_3();
		//	draw_Isosceles_triangle_4();
		//	draw_Isosceles_triangle_5();
		//	 draw_Isosceles_triangle_6();
		//	draw_Isosceles_triangle_7();
			draw_Isosceles_triangle_8();
		}

		public static void squareleWithStars() {
			String line10chars = "_______________";
			String stars = "* * * * * * *";
			Character verticalLine = '|';
			System.out.print(line10chars);
			System.out.println();
			for (int j = 0; j < 7; j++) {
				System.out.print(verticalLine);
				System.out.print(stars);
				System.out.print(verticalLine);
				System.out.println();
			}
			System.out.print(line10chars);
			System.out.println();
			System.out.println();
		}

		public static void squareHollow()
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==0||i==0||j==6||i==6)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_X_fromStars()
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==i||j==6-i)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_1()
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==0||i==0||j==6-i)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_2() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==0||i==6||j==i)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_3() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==6||i==0||j==i)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_4() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==6-i||i==6||j==6)
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_5() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (i==0||(j==i&&(j<4))||(j==6-i&&(j>3)))
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_6() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (i==6||(j==i&&(j>2))||(j==6-i&&(j<3)))
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_7() 
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==0||(j==i&&(j<3))||(j==6-i&&!(j>3)))
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
		
			System.out.print(squareFromStars);
			System.out.println();
		}

		public static void draw_Isosceles_triangle_8()
		{
			String squareFromStars= "";
			String stars ="* ";
			String space ="  ";
         for (int i = 0; i < 7; i++) 
         {
        	for (int j = 0; j < 7; j++)
        	{
        		if (j==6||(j==i&&(j>3))||(j==6-i&&!(j<3)))
    			{
        			squareFromStars+=stars;
    			}
        		else
        		{
        			squareFromStars+=space;
        		}
   			}
        	squareFromStars+='\n';
         }
			System.out.print(squareFromStars);
			System.out.println();
		}
	}

