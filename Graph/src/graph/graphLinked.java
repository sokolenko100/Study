package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class graphLinked
{

	graphLinked()
	{
		queue = new LinkedList<Vertex>();
	}
	public static void main(String [] arg)
	{
		graphLinked g = new graphLinked();

		g.addEdge("Dnipro", "Kiev", 555);
		g.addEdge("Kiev", "Lugansk", 255);
		g.addEdge("Kiev", "Donetsk", 355);

		System.out.println(g.toString());	
		//	g.delVertex("Kiev");
		//	System.out.println(g.toString());

		g.BypassHigth();
		g.BypassWidth();
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

	class Way implements Cloneable
	{
		public String route = "";
		public int distance = 0;	
		public Way(String name) 
		{
			route += name;
		}
		@Override
		protected Object clone() 
		{
			Way w = new Way("");
			w.route = this.route;
			w.distance = this.distance;
			return w;
		}

	}

	public Way bestWay(String from, String to)
	{
		ArrayList<Way> arrWays = new ArrayList<>();
		Vertex fromV = findV(from);
		Vertex toV = findV(to);

		if(fromV != null && toV != null)
		{
			serchWay(arrWays, fromV, toV, new Way(fromV.val));

			if(arrWays.size() == 0)
				throw new IllegalArgumentException("ни проехать ни пройти - нет такого здесь пути");

			else
			{
				Collections.sort(arrWays, new Comparator<Way>() {
					public int compare(Way o1, Way o2) {
						Integer one = o1.distance;
						Integer two = o2.distance;
						return one.compareTo(two);
					}
				});    
				return arrWays.get(0);
			}
		}
		else
			throw new IllegalArgumentException("нет такого пункта отправки или назначения");
	}


	private void serchWay(ArrayList<Way> arrWays, Vertex f, Vertex t, Way tmp)
	{
		if(f == t)//if way go to asked point - save this way
			arrWays.add(tmp); 

		while(f!= null)
		{
			//			f.isVisit= true;
			//			Edge e = f.root;
			//			arrWays.add(f); 
			//			s.str +=f.val+", ";
			//			while(e!=null)
			//			{
			//				Way tmp1 = new Way(f.name); //on each fork create new way
			//				tmp1 = tmp.clone();      // copy passed way
			//				tmp1.route += "--" + f.edges.get(i).distansce + "-->" + f.edges.get(i).to.name; //add next point
			//				tmp1.distance += f.edges.get(i).distansce; //add distance to next point
			//				serchWay(arrWays, f.edges.get(i).to, t, tmp1);//
			//			}
						f = f.next;
		}
		//		if(f.root != null)
		//		{
		//			for(int i = 0; i < f.edges.size(); i++)
		//			{
		//				Way tmp1 = new Way(f.name); //on each fork create new way
		//				tmp1 = tmp.clone();      // copy passed way
		//				tmp1.route += "--" + f.edges.get(i).distansce + "-->" + f.edges.get(i).to.name; //add next point
		//				tmp1.distance += f.edges.get(i).distansce; //add distance to next point
		//				serchWay(arrWays, f.edges.get(i).to, t, tmp1);//
		//			}
	}
}
