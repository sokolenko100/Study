package graph;


public class graphArLink
{
	public static void main(String [] arg)
	{
		graphArLink g = new graphArLink();

		g.addEdge("Dnipro", "Kiev", 555);
		g.addEdge("Kiev", "Lugansk", 255);
		g.addEdge("Kiev", "Donetsk", 355);
		System.out.println(g.toString());	
		g.delVertex("Dnipro");
		System.out.println(g.toString());	
	}
	
	@Override
	public String toString() 
	{
		String result = "";
		
		for (int i = 0; i < nVerts; i++)
		{
			Vertex v = vertexList[i];

			Edge e = v.root;
			while (e!=null)
			{
				result+="from " + v.val+" "+e.toString()+"\n";
				e = e.next;
			}
		}
		
		return result;
	}
	Vertex [] vertexList=null;
	int arLeghtV=20;
	int nVerts;
	public graphArLink() 
	{
		vertexList= new Vertex[arLeghtV];
		nVerts=0;
	}
	class Edge
	{
		Vertex link = null;
		public int val; 
		Edge next =null;
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
	class Vertex
	{
		Edge root =null;
		public String val; 
		public Vertex(String val)
		{
			this.val = val;
		}
		
	}
	public void addVertex(String val)
	{
		Boolean flag = true;

		for (int i = 0; i < nVerts; i++) 
		{
			if(vertexList[i].val.equals(val))
			{
				flag = false;
				break;
			}
		}
		if(flag)
		{
			vertexList[nVerts++]= new Vertex(val);
		}
	}
	private int findIndexVertexForAddEdge(String val)
	{
		int index = 0;
		if(nVerts==0)
		{
			vertexList[nVerts++]= new Vertex(val);
		}
		else
		{
			Boolean flag = true;
			for (int i = 0; i < nVerts; i++) 
			{
				if(vertexList[i].val==val)
				{
					index=i;
					flag = false;
					break;
				}
			}
			if (flag) 
			{
				index= nVerts;
				vertexList[nVerts++]= new Vertex(val);
			}
		}

		return index;
	}
	public void addEdge(String fromStr,String toStr,int val)
	{
		int from =findIndexVertexForAddEdge(fromStr);
		int to =findIndexVertexForAddEdge(toStr);
		Vertex fromV = vertexList[from];
		Vertex toV = vertexList[to];
		Edge edge = new Edge(val);
		edge.link=toV;
		edge.next= fromV.root;
		fromV.root = edge;
	}
	private int findIndexVertexForDelVertex(String val)
	{
		int index = 0;
		for (int i = 0; i < nVerts; i++) 
		{
			if(vertexList[i].val==val)
			{
				index=i;
				break;
			}
		}
		return index;
	}
	public void delVertex(String val)
	{
		int indexV=findIndexVertexForDelVertex(val);
		for (int i = indexV; i<nVerts; i++) 
		{
			vertexList[i]=vertexList[i+1];
		}
		vertexList[nVerts]=null;
		nVerts--;
		for (int i = 0; i < nVerts; i++)
		{
			Vertex v = vertexList[i];
			delEdgeIN(v.root,v.root,val);
		}
	}
	private void delEdgeIN(Edge parent,Edge from,String to)
	{
		if(from==null)
			return ;
		parent = from;
		if(from.link.val.equals(to))
			parent= from.next;

		delEdgeIN(parent,from.next,to);
	}

}
