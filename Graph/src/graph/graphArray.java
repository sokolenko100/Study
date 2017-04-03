package graph;


public class graphArray 
{

	public static void main(String [] arg)
	{
		graphArray g = new graphArray();

		g.addEdge("Dnipro", "Kiev", 555);
		g.addEdge("Kiev", "Lugansk", 255);
		g.addEdge("Kiev", "Donetsk", 355);
		System.out.println(g.toString());	
		g.delVertex("Dnipro");
		System.out.println(g.toString());	
	}
	Vertex [] vertexList=null;
	private Edge adjMat[][]=null;
	int arLeghtV=20;
	int nVerts;
	public graphArray() 
	{
		vertexList= new Vertex[arLeghtV];
		adjMat = new Edge[arLeghtV][arLeghtV];
		nVerts=0;
	}
	@Override
	public String toString() 
	{
		String result ="";
		for (int i = 0; i < arLeghtV; i++) 
		{
			for (int j = 0; j < arLeghtV; j++)
			{
				if(adjMat[i][j]!=null)
				{
					Edge edge = adjMat[i][j];
					Vertex from = vertexList[i];
					Vertex to = vertexList[j];
					result+="from "+from.val+" to "+to.val+ " - " +edge.val+"\n";
				}
			}
		}	
		return result;
	}
	class Edge
	{
		public int val; 
		public Edge(int val)
		{
			this.val = val;
		}
	}
	class Vertex
	{
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
			if(vertexList[i].equals(val))
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
				if(vertexList[i].val.equals(val))
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
		adjMat[from][to]=new Edge(val);
	}
	public void delVertex(String val)
	{
		int indexV=findIndexVertexForDelVertex(val);
		for (int i = 0; i < nVerts; i++)
		{
			adjMat[indexV][i]=null;
		}
		
//		for (int i = indexV; i<nVerts; i++) 
//		{
//			vertexList[i]=vertexList[i+1];
//		}
	//	vertexList[nVerts]=null;
	//	nVerts--;
		
		
		vertexList[indexV]=null;
	}

	private int findIndexVertexForDelVertex(String val)
	{
		int index = 0;
		for (int i = 0; i < nVerts; i++) 
		{
			if(vertexList[i].equals(val))
			{
				index=i;
				break;
			}
		}
		return index;
	}
}
