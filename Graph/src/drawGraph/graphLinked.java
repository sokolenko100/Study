package drawGraph;

import java.util.PriorityQueue;
import java.util.Queue;

public class graphLinked
{
	public void init()
	{
		addEdge("Dnipro", "Kiev", 555);
		addEdge("Dnipro", "Lugansk", 255);
		addEdge("Dnipro", "Donetsk", 355);
		addEdge("Kiev", "Lugansk", 255);
		addEdge("Kiev", "Donetsk", 355);
//		addEdge("A", "B", 555);
//		addEdge("C", "D", 255);
//		addEdge("E", "F", 355);
//		addEdge("G", "H", 555);
//		addEdge("Q", "E", 255);
//		addEdge("M", "L", 355);
	//	System.out.println(g.toString());	
	//	g.delVertex("Kiev");
	//	System.out.println(g.toString());

	//	g.BypassHigth();
	//	g.BypassWidth();
	}
	@Override
	public String toString()
	{
		if(root ==null)
			return "";

		Vertex temp = root;

		String str ="\n";
		while (temp != null )
		{
			str += temp.toString();
			str+="\n";
			temp = temp.next;
		}
		return  str;
	}

	Vertex root = null;

	class Vertex 
	{
		String val;
		Vertex next;
		Edge root;
		Boolean isVisit = false;
		public Vertex(String val)
		{
			this.val = val;
		}
		@Override
		public String toString()
		{
			String str = "city " + val +" => ";
			Edge temp= root;
			while (temp != null )
			{
				str += temp.toString();
				str+="\n";
				temp = temp.next;
			}
			return str;
		}
	}
	class Edge
	{
		int val;
		Edge next;
		Vertex link;
		public Edge(int val)
		{
			this.val = val;
		}
		@Override
		public String toString()
		{
			return  "to city=>"+ link.val +" - " + val;
		}
	}
	public void addV(String Name)
	{
		addVertex(root, Name);
	}
	private Vertex addVertex(Vertex v, String Name)
	{
		if(v == null)
		{
			v = new Vertex(Name);
			v.next=root;
			root =v;
			return v;
		}
		return	addVertex(v.next, Name);
	}
	
	public void addEdge(String from,String to, int val)
	{
		Vertex fromV = findVertex(from);
		Vertex toV = findVertex(to);
		Edge edge = new Edge(val);
		edge.link=toV;
		edge.next= fromV.root;
		fromV.root = edge;
	}
	private Vertex findV(String val)
	{
		Vertex ret = root;
		while(ret != null)
		{
			if(val.equals(ret.val))
			{
				break;
			}
			ret = ret.next;
		}
		return ret;
	}
	private Vertex findVertex(String val)
	{
		Vertex ret = root;
		ret = findV(val);
		if(ret == null)
		{
			ret = addVertex(root,val);
		}
		return ret;
	}
	private Vertex findVertexDelEdge(String val)
	{
		Vertex ret = root;
		while(ret != null)
		{
			if(val.equals(ret.val)&&ret.root !=null)
			{
				break;
			}
			ret = ret.next;
		}
		return ret;
	}
	public void delEdge(String from,String to)
	{
		Vertex fromV = findVertexDelEdge(from);
		delEdgeIN(fromV.root,to);
	}
	private Edge delEdgeIN(Edge from,String to)
	{
		if(from==null)
			return null;


		if(from.link.val.equals(to))
			return from.next;

		return	from.next = delEdgeIN(from.next,to);
	}

	public void delVertex(String val)
	{
		root = delVertexIN( root, val);
	}
	private Vertex delVertexIN(Vertex v,String val)
	{
		if(v == null)
		{
			return null;
		}
		v.next=delVertexIN(v.next, val);
		if(v.val.equals(val))
		{
			return v.next;
		}
		v.root=delEdgeIN(v.root,val);

		return v;
	}

	public void BypassHigth()
	{
		Str s = new Str();
		BypassHigthIN(root,s);
		System.out.println(s.str);
		Vertex v = root;
		while(v!= null)
		{
			v.isVisit=false;
			v = v.next;
		}
	}
	class Str
	{
		String str ="";	
	}
	private void BypassHigthIN(Vertex v,Str s)
	{
		while(v!= null)
		{
			v.isVisit= true;
			Edge e = v.root;
			s.str +=v.val+", ";
			while(e!=null)
			{
				if(!e.link.isVisit)
				{
					BypassHigthIN(e.link, s);
				}
				e= e.next;
			}
			v = v.next;
		}
	}
	Queue<Vertex>  queue = null;
	public void BypassWidth()
	{
		Queue<Vertex> queue = new PriorityQueue<Vertex>();
		Str s = new Str();
		BypassWidthIN(root,queue,s);
		System.out.println("\n");
		System.out.println(s.str);
		Vertex v = root;
		while(v!= null)
		{
			v.isVisit=false;
			v = v.next;
		}
	}
	private void BypassWidthIN(Vertex v,Queue<Vertex> queue,Str s)
	{
		v.isVisit=true;
		s.str += v.val+", ";
		while(v!=null)
		{
			Edge e = v.root;
			
			while(e != null)
			{
				if(!e.link.isVisit)
				{
					e.link.isVisit=true;
					s.str += e.link.val+", ";
				}
				e = e.next;
			}
			if(!v.isVisit)
			{
				v.isVisit=true;
				s.str += v.val+", ";
			}
			v=v.next;
		}
	}
	
	public void serthWay(String from, String to)
	{
		Vertex fromV = findV(from);
		Vertex toV = findV(to);
	}
	private Vertex serthWay(Vertex from,Vertex to)
	{
		
		
		return null;
	}
	class Ways
	{
		
	}
}
