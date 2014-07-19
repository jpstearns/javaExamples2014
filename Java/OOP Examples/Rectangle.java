public class Rectangle
{
	private double length;
	private double width;

		public Rectangle(double len, double wid)
		{
			length = len;
			width = wid;
		}
		/**
		The Set length method stores a value in the length field
		*/
		public void setLength(double len)
		{
			if( len >= 0)
			length = len;
			else
			System.out.println("Bad length value: "+len);
		}

		/**
		The setWidth method stores a value in the width field
		*/
		public void setWidth(double  wid)
		{
			if (wid >=0)
			width = wid;
			else
			System.out.println("Bad width value :"+wid);
		}
		/**
		The getLength method returns length
		*/
		public double getLength()
		{
			return length;
		}
		/**
		The getWidth method returns width
		*/
		public double getWidth()
		{
			return width;
		}
		public double getArea()
		{
			return  length * width;
		}
}
